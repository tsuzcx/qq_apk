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
      if (paramParsableByteArray.readInt() == SEEK_HEADER_VBRI) {
        return SEEK_HEADER_VBRI;
      }
    }
    return 0;
  }
  
  private static boolean headersMatch(int paramInt, long paramLong)
  {
    return (0xFFFE0C00 & paramInt) == (0xFFFE0C00 & paramLong);
  }
  
  private Mp3Extractor.Seeker maybeReadSeekFrame(ExtractorInput paramExtractorInput)
  {
    Object localObject = new ParsableByteArray(this.synchronizedHeader.frameSize);
    paramExtractorInput.peekFully(((ParsableByteArray)localObject).data, 0, this.synchronizedHeader.frameSize);
    int i;
    if ((this.synchronizedHeader.version & 0x1) != 0) {
      if (this.synchronizedHeader.channels != 1) {
        i = 36;
      }
    }
    int j;
    for (;;)
    {
      j = getSeekFrameHeader((ParsableByteArray)localObject, i);
      if ((j != SEEK_HEADER_XING) && (j != SEEK_HEADER_INFO)) {
        break;
      }
      XingSeeker localXingSeeker = XingSeeker.create(paramExtractorInput.getLength(), paramExtractorInput.getPosition(), this.synchronizedHeader, (ParsableByteArray)localObject);
      if ((localXingSeeker != null) && (!this.gaplessInfoHolder.hasGaplessInfo()))
      {
        paramExtractorInput.resetPeekPosition();
        paramExtractorInput.advancePeekPosition(i + 141);
        paramExtractorInput.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
      }
      paramExtractorInput.skipFully(this.synchronizedHeader.frameSize);
      localObject = localXingSeeker;
      if (localXingSeeker != null)
      {
        localObject = localXingSeeker;
        if (!localXingSeeker.isSeekable())
        {
          localObject = localXingSeeker;
          if (j == SEEK_HEADER_INFO) {
            localObject = getConstantBitrateSeeker(paramExtractorInput);
          }
        }
      }
      return localObject;
      i = 21;
      continue;
      if (this.synchronizedHeader.channels != 1) {
        i = 21;
      } else {
        i = 13;
      }
    }
    if (j == SEEK_HEADER_VBRI)
    {
      localObject = VbriSeeker.create(paramExtractorInput.getLength(), paramExtractorInput.getPosition(), this.synchronizedHeader, (ParsableByteArray)localObject);
      paramExtractorInput.skipFully(this.synchronizedHeader.frameSize);
      return localObject;
    }
    paramExtractorInput.resetPeekPosition();
    return null;
  }
  
  private void peekId3Data(ExtractorInput paramExtractorInput)
  {
    int i = 0;
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
    Id3Decoder.FramePredicate localFramePredicate;
    if (this.metadata == null)
    {
      byte[] arrayOfByte = new byte[k];
      System.arraycopy(this.scratch.data, 0, arrayOfByte, 0, 10);
      paramExtractorInput.peekFully(arrayOfByte, 10, j);
      if ((this.flags & 0x2) != 0)
      {
        localFramePredicate = GaplessInfoHolder.GAPLESS_INFO_ID3_FRAME_PREDICATE;
        label129:
        this.metadata = new Id3Decoder(localFramePredicate).decode(arrayOfByte, k);
        if (this.metadata != null) {
          this.gaplessInfoHolder.setFromMetadata(this.metadata);
        }
      }
    }
    for (;;)
    {
      i += k;
      break;
      localFramePredicate = null;
      break label129;
      paramExtractorInput.advancePeekPosition(j);
    }
  }
  
  private int readSample(ExtractorInput paramExtractorInput)
  {
    int i = 0;
    if (this.sampleBytesRemaining == 0)
    {
      paramExtractorInput.resetPeekPosition();
      if (!paramExtractorInput.peekFully(this.scratch.data, 0, 4, true)) {
        i = -1;
      }
    }
    do
    {
      return i;
      this.scratch.setPosition(0);
      int j = this.scratch.readInt();
      if ((!headersMatch(j, this.synchronizedHeaderData)) || (MpegAudioHeader.getFrameSize(j) == -1))
      {
        paramExtractorInput.skipFully(1);
        this.synchronizedHeaderData = 0;
        return 0;
      }
      MpegAudioHeader.populateHeader(j, this.synchronizedHeader);
      if (this.basisTimeUs == -9223372036854775807L)
      {
        this.basisTimeUs = this.seeker.getTimeUs(paramExtractorInput.getPosition());
        if (this.forcedFirstSampleTimestampUs != -9223372036854775807L)
        {
          l1 = this.seeker.getTimeUs(0L);
          l2 = this.basisTimeUs;
          this.basisTimeUs = (this.forcedFirstSampleTimestampUs - l1 + l2);
        }
      }
      this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
      j = this.trackOutput.sampleData(paramExtractorInput, this.sampleBytesRemaining, true);
      if (j == -1) {
        return -1;
      }
      this.sampleBytesRemaining -= j;
    } while (this.sampleBytesRemaining > 0);
    long l1 = this.basisTimeUs;
    long l2 = this.samplesRead * 1000000L / this.synchronizedHeader.sampleRate;
    this.trackOutput.sampleMetadata(l2 + l1, 1, this.synchronizedHeader.frameSize, 0, null);
    this.samplesRead += this.synchronizedHeader.samplesPerFrame;
    this.sampleBytesRemaining = 0;
    return 0;
  }
  
  private boolean synchronize(ExtractorInput paramExtractorInput, boolean paramBoolean)
  {
    boolean bool2 = false;
    int m;
    int n;
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      m = 16384;
      paramExtractorInput.resetPeekPosition();
      if (paramExtractorInput.getPosition() != 0L) {
        break label325;
      }
      peekId3Data(paramExtractorInput);
      n = (int)paramExtractorInput.getPeekPosition();
      if (!paramBoolean) {
        paramExtractorInput.skipFully(n);
      }
      i = 0;
      j = 0;
      k = 0;
    }
    for (;;)
    {
      label63:
      byte[] arrayOfByte = this.scratch.data;
      boolean bool1;
      if (j > 0)
      {
        bool1 = true;
        label80:
        if (paramExtractorInput.peekFully(arrayOfByte, 0, 4, bool1)) {
          break label134;
        }
        label95:
        if (!paramBoolean) {
          break label316;
        }
        paramExtractorInput.skipFully(n + k);
      }
      for (;;)
      {
        this.synchronizedHeaderData = i;
        bool1 = true;
        label134:
        int i2;
        int i3;
        do
        {
          return bool1;
          m = 131072;
          break;
          bool1 = false;
          break label80;
          this.scratch.setPosition(0);
          i2 = this.scratch.readInt();
          if ((i == 0) || (headersMatch(i2, i)))
          {
            i3 = MpegAudioHeader.getFrameSize(i2);
            if (i3 != -1) {
              break label258;
            }
          }
          i = k + 1;
          if (k != m) {
            break label209;
          }
          bool1 = bool2;
        } while (paramBoolean);
        throw new ParserException("Searched too many bytes.");
        label209:
        if (paramBoolean)
        {
          paramExtractorInput.resetPeekPosition();
          paramExtractorInput.advancePeekPosition(n + i);
          k = i;
          j = 0;
          i = 0;
          break label63;
        }
        paramExtractorInput.skipFully(1);
        k = i;
        j = 0;
        i = 0;
        break label63;
        label258:
        int i1 = j + 1;
        if (i1 == 1)
        {
          MpegAudioHeader.populateHeader(i2, this.synchronizedHeader);
          j = i2;
        }
        do
        {
          paramExtractorInput.advancePeekPosition(i3 - 4);
          i = j;
          j = i1;
          break;
          j = i;
        } while (i1 != 4);
        break label95;
        label316:
        paramExtractorInput.resetPeekPosition();
      }
      label325:
      k = 0;
      n = 0;
      i = 0;
      j = 0;
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
    for (;;)
    {
      try
      {
        synchronize(paramExtractorInput, false);
        if (this.seeker == null)
        {
          this.seeker = maybeReadSeekFrame(paramExtractorInput);
          if ((this.seeker == null) || ((!this.seeker.isSeekable()) && ((this.flags & 0x1) != 0))) {
            this.seeker = getConstantBitrateSeeker(paramExtractorInput);
          }
          this.extractorOutput.seekMap(this.seeker);
          TrackOutput localTrackOutput = this.trackOutput;
          String str = this.synchronizedHeader.mimeType;
          int i = this.synchronizedHeader.channels;
          int j = this.synchronizedHeader.sampleRate;
          int k = this.gaplessInfoHolder.encoderDelay;
          int m = this.gaplessInfoHolder.encoderPadding;
          if ((this.flags & 0x2) != 0)
          {
            paramPositionHolder = null;
            localTrackOutput.format(Format.createAudioSampleFormat(null, str, null, -1, 4096, i, j, -1, k, m, null, null, 0, null, paramPositionHolder));
          }
        }
        else
        {
          return readSample(paramExtractorInput);
        }
      }
      catch (EOFException paramExtractorInput)
      {
        return -1;
      }
      paramPositionHolder = this.metadata;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp3.Mp3Extractor
 * JD-Core Version:    0.7.0.1
 */