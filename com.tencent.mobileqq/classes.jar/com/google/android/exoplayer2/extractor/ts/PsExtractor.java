package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PsExtractor
  implements Extractor
{
  public static final int AUDIO_STREAM = 192;
  public static final int AUDIO_STREAM_MASK = 224;
  public static final ExtractorsFactory FACTORY = new PsExtractor.1();
  private static final long MAX_SEARCH_LENGTH = 1048576L;
  private static final int MAX_STREAM_ID_PLUS_ONE = 256;
  private static final int MPEG_PROGRAM_END_CODE = 441;
  private static final int PACKET_START_CODE_PREFIX = 1;
  private static final int PACK_START_CODE = 442;
  public static final int PRIVATE_STREAM_1 = 189;
  private static final int SYSTEM_HEADER_START_CODE = 443;
  public static final int VIDEO_STREAM = 224;
  public static final int VIDEO_STREAM_MASK = 240;
  private boolean foundAllTracks;
  private boolean foundAudioTrack;
  private boolean foundVideoTrack;
  private ExtractorOutput output;
  private final ParsableByteArray psPacketBuffer;
  private final SparseArray<PsExtractor.PesReader> psPayloadReaders;
  private final TimestampAdjuster timestampAdjuster;
  
  public PsExtractor()
  {
    this(new TimestampAdjuster(0L));
  }
  
  public PsExtractor(TimestampAdjuster paramTimestampAdjuster)
  {
    this.timestampAdjuster = paramTimestampAdjuster;
    this.psPacketBuffer = new ParsableByteArray(4096);
    this.psPayloadReaders = new SparseArray();
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.output = paramExtractorOutput;
    paramExtractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    if (!paramExtractorInput.peekFully(this.psPacketBuffer.data, 0, 4, true)) {
      return -1;
    }
    this.psPacketBuffer.setPosition(0);
    int i = this.psPacketBuffer.readInt();
    if (i == 441) {
      return -1;
    }
    if (i == 442)
    {
      paramExtractorInput.peekFully(this.psPacketBuffer.data, 0, 10);
      this.psPacketBuffer.setPosition(9);
      paramExtractorInput.skipFully((this.psPacketBuffer.readUnsignedByte() & 0x7) + 14);
      return 0;
    }
    if (i == 443)
    {
      paramExtractorInput.peekFully(this.psPacketBuffer.data, 0, 2);
      this.psPacketBuffer.setPosition(0);
      paramExtractorInput.skipFully(this.psPacketBuffer.readUnsignedShort() + 6);
      return 0;
    }
    if ((i & 0xFFFFFF00) >> 8 != 1)
    {
      paramExtractorInput.skipFully(1);
      return 0;
    }
    i &= 0xFF;
    PsExtractor.PesReader localPesReader = (PsExtractor.PesReader)this.psPayloadReaders.get(i);
    paramPositionHolder = localPesReader;
    if (!this.foundAllTracks)
    {
      Object localObject = localPesReader;
      if (localPesReader == null)
      {
        localObject = null;
        if ((!this.foundAudioTrack) && (i == 189))
        {
          paramPositionHolder = new Ac3Reader();
          this.foundAudioTrack = true;
        }
        else if ((!this.foundAudioTrack) && ((i & 0xE0) == 192))
        {
          paramPositionHolder = new MpegAudioReader();
          this.foundAudioTrack = true;
        }
        else
        {
          paramPositionHolder = (PositionHolder)localObject;
          if (!this.foundVideoTrack)
          {
            paramPositionHolder = (PositionHolder)localObject;
            if ((i & 0xF0) == 224)
            {
              paramPositionHolder = new H262Reader();
              this.foundVideoTrack = true;
            }
          }
        }
        localObject = localPesReader;
        if (paramPositionHolder != null)
        {
          localObject = new TsPayloadReader.TrackIdGenerator(i, 256);
          paramPositionHolder.createTracks(this.output, (TsPayloadReader.TrackIdGenerator)localObject);
          localObject = new PsExtractor.PesReader(paramPositionHolder, this.timestampAdjuster);
          this.psPayloadReaders.put(i, localObject);
        }
      }
      if ((!this.foundAudioTrack) || (!this.foundVideoTrack))
      {
        paramPositionHolder = (PositionHolder)localObject;
        if (paramExtractorInput.getPosition() <= 1048576L) {}
      }
      else
      {
        this.foundAllTracks = true;
        this.output.endTracks();
        paramPositionHolder = (PositionHolder)localObject;
      }
    }
    paramExtractorInput.peekFully(this.psPacketBuffer.data, 0, 2);
    this.psPacketBuffer.setPosition(0);
    i = this.psPacketBuffer.readUnsignedShort() + 6;
    if (paramPositionHolder == null)
    {
      paramExtractorInput.skipFully(i);
      return 0;
    }
    this.psPacketBuffer.reset(i);
    paramExtractorInput.readFully(this.psPacketBuffer.data, 0, i);
    this.psPacketBuffer.setPosition(6);
    paramPositionHolder.consume(this.psPacketBuffer);
    paramExtractorInput = this.psPacketBuffer;
    paramExtractorInput.setLimit(paramExtractorInput.capacity());
    return 0;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.timestampAdjuster.reset();
    int i = 0;
    while (i < this.psPayloadReaders.size())
    {
      ((PsExtractor.PesReader)this.psPayloadReaders.valueAt(i)).seek();
      i += 1;
    }
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    byte[] arrayOfByte = new byte[14];
    boolean bool = false;
    paramExtractorInput.peekFully(arrayOfByte, 0, 14);
    if (442 != ((arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF)) {
      return false;
    }
    if ((arrayOfByte[4] & 0xC4) != 68) {
      return false;
    }
    if ((arrayOfByte[6] & 0x4) != 4) {
      return false;
    }
    if ((arrayOfByte[8] & 0x4) != 4) {
      return false;
    }
    if ((arrayOfByte[9] & 0x1) != 1) {
      return false;
    }
    if ((arrayOfByte[12] & 0x3) != 3) {
      return false;
    }
    paramExtractorInput.advancePeekPosition(arrayOfByte[13] & 0x7);
    paramExtractorInput.peekFully(arrayOfByte, 0, 3);
    if (1 == ((arrayOfByte[0] & 0xFF) << 16 | (arrayOfByte[1] & 0xFF) << 8 | arrayOfByte[2] & 0xFF)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.PsExtractor
 * JD-Core Version:    0.7.0.1
 */