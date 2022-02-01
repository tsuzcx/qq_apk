package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;

public final class Mp3Extractor
  implements Extractor
{
  public static final ExtractorsFactory FACTORY = new Mp3Extractor.1();
  public static final int FLAG_DISABLE_ID3_METADATA = 2;
  public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
  private static final int MAX_SNIFF_BYTES = 16384;
  private static final int MAX_SYNC_BYTES = 131072;
  private static final int MPEG_AUDIO_HEADER_MASK = -128000;
  private static final int SCRATCH_LENGTH = 10;
  private static final int SEEK_HEADER_INFO = Util.getIntegerCodeForString("Info");
  private static final int SEEK_HEADER_UNSET = 0;
  private static final int SEEK_HEADER_VBRI = Util.getIntegerCodeForString("VBRI");
  private static final int SEEK_HEADER_XING = Util.getIntegerCodeForString("Xing");
  private long basisTimeUs;
  private ExtractorOutput extractorOutput;
  private final int flags;
  private final long forcedFirstSampleTimestampUs;
  private final GaplessInfoHolder gaplessInfoHolder;
  private Metadata metadata;
  private int sampleBytesRemaining;
  private long samplesRead;
  private final ParsableByteArray scratch;
  private Mp3Extractor.Seeker seeker;
  private final MpegAudioHeader synchronizedHeader;
  private int synchronizedHeaderData;
  private TrackOutput trackOutput;
  
  public Mp3Extractor()
  {
    this(0);
  }
  
  public Mp3Extractor(int paramInt)
  {
    this(paramInt, -9223372036854775807L);
  }
  
  public Mp3Extractor(int paramInt, long paramLong)
  {
    this.flags = paramInt;
    this.forcedFirstSampleTimestampUs = paramLong;
    this.scratch = new ParsableByteArray(10);
    this.synchronizedHeader = new MpegAudioHeader();
    this.gaplessInfoHolder = new GaplessInfoHolder();
    this.basisTimeUs = -9223372036854775807L;
  }
  
  private Mp3Extractor.Seeker getConstantBitrateSeeker(ExtractorInput paramExtractorInput)
  {
    paramExtractorInput.peekFully(this.scratch.data, 0, 4);
    this.scratch.setPosition(0);
    MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
    return new ConstantBitrateSeeker(paramExtractorInput.getLength(), paramExtractorInput.getPosition(), this.synchronizedHeader);
  }
  
  private static int getSeekFrameHeader(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    if (paramParsableByteArray.limit() >= paramInt + 4)
    {
      paramParsableByteArray.setPosition(paramInt);
      paramInt = paramParsableByteArray.readInt();
      if ((paramInt == SEEK_HEADER_XING) || (paramInt == SEEK_HEADER_INFO)) {
        return paramInt;
      }
    }
    if (paramParsableByteArray.limit() >= 40)
    {
      paramParsableByteArray.setPosition(36);
      paramInt = paramParsableByteArray.readInt();
      int i = SEEK_HEADER_VBRI;
      if (paramInt == i) {
        return i;
      }
    }
    return 0;
  }
  
  private static boolean headersMatch(int paramInt, long paramLong)
  {
    return (paramInt & 0xFFFE0C00) == (paramLong & 0xFFFE0C00);
  }
  
  private Mp3Extractor.Seeker maybeReadSeekFrame(ExtractorInput paramExtractorInput)
  {
    Object localObject = new ParsableByteArray(this.synchronizedHeader.frameSize);
    paramExtractorInput.peekFully(((ParsableByteArray)localObject).data, 0, this.synchronizedHeader.frameSize);
    if ((this.synchronizedHeader.version & 0x1) != 0)
    {
      if (this.synchronizedHeader.channels != 1)
      {
        i = 36;
        break label84;
      }
    }
    else {
      if (this.synchronizedHeader.channels == 1) {
        break label81;
      }
    }
    int i = 21;
    break label84;
    label81:
    i = 13;
    label84:
    int j = getSeekFrameHeader((ParsableByteArray)localObject, i);
    if ((j != SEEK_HEADER_XING) && (j != SEEK_HEADER_INFO))
    {
      if (j == SEEK_HEADER_VBRI)
      {
        localObject = VbriSeeker.create(paramExtractorInput.getLength(), paramExtractorInput.getPosition(), this.synchronizedHeader, (ParsableByteArray)localObject);
        paramExtractorInput.skipFully(this.synchronizedHeader.frameSize);
        return localObject;
      }
      paramExtractorInput.resetPeekPosition();
      return null;
    }
    localObject = XingSeeker.create(paramExtractorInput.getLength(), paramExtractorInput.getPosition(), this.synchronizedHeader, (ParsableByteArray)localObject);
    if ((localObject != null) && (!this.gaplessInfoHolder.hasGaplessInfo()))
    {
      paramExtractorInput.resetPeekPosition();
      paramExtractorInput.advancePeekPosition(i + 141);
      paramExtractorInput.peekFully(this.scratch.data, 0, 3);
      this.scratch.setPosition(0);
      this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
    }
    paramExtractorInput.skipFully(this.synchronizedHeader.frameSize);
    if ((localObject != null) && (!((Mp3Extractor.Seeker)localObject).isSeekable()) && (j == SEEK_HEADER_INFO)) {
      return getConstantBitrateSeeker(paramExtractorInput);
    }
    return localObject;
  }
  
  private void peekId3Data(ExtractorInput paramExtractorInput)
  {
    int i = 0;
    for (;;)
    {
      paramExtractorInput.peekFully(this.scratch.data, 0, 10);
      this.scratch.setPosition(0);
      if (this.scratch.readUnsignedInt24() != Id3Decoder.ID3_TAG)
      {
        paramExtractorInput.resetPeekPosition();
        paramExtractorInput.advancePeekPosition(i);
        return;
      }
      this.scratch.skipBytes(3);
      int j = this.scratch.readSynchSafeInt();
      int k = j + 10;
      if (this.metadata == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.scratch.data, 0, arrayOfByte, 0, 10);
        paramExtractorInput.peekFully(arrayOfByte, 10, j);
        if ((this.flags & 0x2) != 0) {
          localObject = GaplessInfoHolder.GAPLESS_INFO_ID3_FRAME_PREDICATE;
        } else {
          localObject = null;
        }
        this.metadata = new Id3Decoder((Id3Decoder.FramePredicate)localObject).decode(arrayOfByte, k);
        Object localObject = this.metadata;
        if (localObject != null) {
          this.gaplessInfoHolder.setFromMetadata((Metadata)localObject);
        }
      }
      else
      {
        paramExtractorInput.advancePeekPosition(j);
      }
      i += k;
    }
  }
  
  private int readSample(ExtractorInput paramExtractorInput)
  {
    if (this.sampleBytesRemaining == 0)
    {
      paramExtractorInput.resetPeekPosition();
      if (!paramExtractorInput.peekFully(this.scratch.data, 0, 4, true)) {
        return -1;
      }
      this.scratch.setPosition(0);
      i = this.scratch.readInt();
      if ((headersMatch(i, this.synchronizedHeaderData)) && (MpegAudioHeader.getFrameSize(i) != -1))
      {
        MpegAudioHeader.populateHeader(i, this.synchronizedHeader);
        if (this.basisTimeUs == -9223372036854775807L)
        {
          this.basisTimeUs = this.seeker.getTimeUs(paramExtractorInput.getPosition());
          if (this.forcedFirstSampleTimestampUs != -9223372036854775807L)
          {
            l1 = this.seeker.getTimeUs(0L);
            this.basisTimeUs += this.forcedFirstSampleTimestampUs - l1;
          }
        }
        this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
      }
      else
      {
        paramExtractorInput.skipFully(1);
        this.synchronizedHeaderData = 0;
        return 0;
      }
    }
    int i = this.trackOutput.sampleData(paramExtractorInput, this.sampleBytesRemaining, true);
    if (i == -1) {
      return -1;
    }
    this.sampleBytesRemaining -= i;
    if (this.sampleBytesRemaining > 0) {
      return 0;
    }
    long l1 = this.basisTimeUs;
    long l2 = this.samplesRead * 1000000L / this.synchronizedHeader.sampleRate;
    this.trackOutput.sampleMetadata(l1 + l2, 1, this.synchronizedHeader.frameSize, 0, null);
    this.samplesRead += this.synchronizedHeader.samplesPerFrame;
    this.sampleBytesRemaining = 0;
    return 0;
  }
  
  private boolean synchronize(ExtractorInput paramExtractorInput, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = 16384;
    } else {
      m = 131072;
    }
    paramExtractorInput.resetPeekPosition();
    int n;
    int i;
    int j;
    int k;
    if (paramExtractorInput.getPosition() == 0L)
    {
      peekId3Data(paramExtractorInput);
      n = (int)paramExtractorInput.getPeekPosition();
      if (!paramBoolean) {
        paramExtractorInput.skipFully(n);
      }
      i = 0;
      j = 0;
      k = 0;
    }
    else
    {
      i = 0;
      j = 0;
      k = 0;
      n = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte = this.scratch.data;
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      int i1;
      int i2;
      if (paramExtractorInput.peekFully(arrayOfByte, 0, 4, bool))
      {
        this.scratch.setPosition(0);
        i1 = this.scratch.readInt();
        if ((j == 0) || (headersMatch(i1, j)))
        {
          i2 = MpegAudioHeader.getFrameSize(i1);
          if (i2 != -1) {}
        }
        else
        {
          i = k + 1;
          if (k == m)
          {
            if (paramBoolean) {
              return false;
            }
            throw new ParserException("Searched too many bytes.");
          }
          if (paramBoolean)
          {
            paramExtractorInput.resetPeekPosition();
            paramExtractorInput.advancePeekPosition(n + i);
          }
          else
          {
            paramExtractorInput.skipFully(1);
          }
          k = i;
          i = 0;
          j = 0;
          continue;
        }
        i += 1;
        if (i == 1)
        {
          MpegAudioHeader.populateHeader(i1, this.synchronizedHeader);
        }
        else
        {
          i1 = j;
          if (i != 4) {}
        }
      }
      else
      {
        if (paramBoolean) {
          paramExtractorInput.skipFully(n + k);
        } else {
          paramExtractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = j;
        return true;
      }
      paramExtractorInput.advancePeekPosition(i2 - 4);
      j = i1;
    }
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
    this.trackOutput = this.extractorOutput.track(0, 1);
    this.extractorOutput.endTracks();
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    if (this.synchronizedHeaderData == 0) {}
    try
    {
      synchronize(paramExtractorInput, false);
    }
    catch (EOFException paramExtractorInput)
    {
      label17:
      TrackOutput localTrackOutput;
      String str;
      int i;
      int j;
      int k;
      int m;
      break label17;
    }
    return -1;
    if (this.seeker == null)
    {
      this.seeker = maybeReadSeekFrame(paramExtractorInput);
      paramPositionHolder = this.seeker;
      if ((paramPositionHolder == null) || ((!paramPositionHolder.isSeekable()) && ((this.flags & 0x1) != 0))) {
        this.seeker = getConstantBitrateSeeker(paramExtractorInput);
      }
      this.extractorOutput.seekMap(this.seeker);
      localTrackOutput = this.trackOutput;
      str = this.synchronizedHeader.mimeType;
      i = this.synchronizedHeader.channels;
      j = this.synchronizedHeader.sampleRate;
      k = this.gaplessInfoHolder.encoderDelay;
      m = this.gaplessInfoHolder.encoderPadding;
      if ((this.flags & 0x2) != 0) {
        paramPositionHolder = null;
      } else {
        paramPositionHolder = this.metadata;
      }
      localTrackOutput.format(Format.createAudioSampleFormat(null, str, null, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramPositionHolder));
    }
    return readSample(paramExtractorInput);
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.synchronizedHeaderData = 0;
    this.basisTimeUs = -9223372036854775807L;
    this.samplesRead = 0L;
    this.sampleBytesRemaining = 0;
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    return synchronize(paramExtractorInput, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp3.Mp3Extractor
 * JD-Core Version:    0.7.0.1
 */