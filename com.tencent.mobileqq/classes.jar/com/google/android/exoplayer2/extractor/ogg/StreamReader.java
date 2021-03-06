package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

abstract class StreamReader
{
  private static final int STATE_END_OF_INPUT = 3;
  private static final int STATE_READ_HEADERS = 0;
  private static final int STATE_READ_PAYLOAD = 2;
  private static final int STATE_SKIP_HEADERS = 1;
  private long currentGranule;
  private ExtractorOutput extractorOutput;
  private boolean formatSet;
  private long lengthOfReadPacket;
  private final OggPacket oggPacket = new OggPacket();
  private OggSeeker oggSeeker;
  private long payloadStartPosition;
  private int sampleRate;
  private boolean seekMapSet;
  private StreamReader.SetupData setupData;
  private int state;
  private long targetGranule;
  private TrackOutput trackOutput;
  
  private int readHeaders(ExtractorInput paramExtractorInput)
  {
    int i = 1;
    while (i != 0)
    {
      if (!this.oggPacket.populate(paramExtractorInput))
      {
        this.state = 3;
        return -1;
      }
      this.lengthOfReadPacket = (paramExtractorInput.getPosition() - this.payloadStartPosition);
      boolean bool = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
      i = bool;
      if (bool)
      {
        this.payloadStartPosition = paramExtractorInput.getPosition();
        i = bool;
      }
    }
    this.sampleRate = this.setupData.format.sampleRate;
    if (!this.formatSet)
    {
      this.trackOutput.format(this.setupData.format);
      this.formatSet = true;
    }
    if (this.setupData.oggSeeker != null)
    {
      this.oggSeeker = this.setupData.oggSeeker;
    }
    else if (paramExtractorInput.getLength() == -1L)
    {
      this.oggSeeker = new StreamReader.UnseekableOggSeeker(null);
    }
    else
    {
      OggPageHeader localOggPageHeader = this.oggPacket.getPageHeader();
      this.oggSeeker = new DefaultOggSeeker(this.payloadStartPosition, paramExtractorInput.getLength(), this, localOggPageHeader.headerSize + localOggPageHeader.bodySize, localOggPageHeader.granulePosition);
    }
    this.setupData = null;
    this.state = 2;
    this.oggPacket.trimPayload();
    return 0;
  }
  
  private int readPayload(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    long l1 = this.oggSeeker.read(paramExtractorInput);
    if (l1 >= 0L)
    {
      paramPositionHolder.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      onSeekEnd(-(l1 + 2L));
    }
    if (!this.seekMapSet)
    {
      paramPositionHolder = this.oggSeeker.createSeekMap();
      this.extractorOutput.seekMap(paramPositionHolder);
      this.seekMapSet = true;
    }
    if ((this.lengthOfReadPacket <= 0L) && (!this.oggPacket.populate(paramExtractorInput)))
    {
      this.state = 3;
      return -1;
    }
    this.lengthOfReadPacket = 0L;
    paramExtractorInput = this.oggPacket.getPayload();
    l1 = preparePayload(paramExtractorInput);
    if (l1 >= 0L)
    {
      long l2 = this.currentGranule;
      if (l2 + l1 >= this.targetGranule)
      {
        l2 = convertGranuleToTime(l2);
        this.trackOutput.sampleData(paramExtractorInput, paramExtractorInput.limit());
        this.trackOutput.sampleMetadata(l2, 1, paramExtractorInput.limit(), 0, null);
        this.targetGranule = -1L;
      }
    }
    this.currentGranule += l1;
    return 0;
  }
  
  protected long convertGranuleToTime(long paramLong)
  {
    return paramLong * 1000000L / this.sampleRate;
  }
  
  protected long convertTimeToGranule(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  void init(ExtractorOutput paramExtractorOutput, TrackOutput paramTrackOutput)
  {
    this.extractorOutput = paramExtractorOutput;
    this.trackOutput = paramTrackOutput;
    reset(true);
  }
  
  protected void onSeekEnd(long paramLong)
  {
    this.currentGranule = paramLong;
  }
  
  protected abstract long preparePayload(ParsableByteArray paramParsableByteArray);
  
  final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    int i = this.state;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return readPayload(paramExtractorInput, paramPositionHolder);
        }
        throw new IllegalStateException();
      }
      paramExtractorInput.skipFully((int)this.payloadStartPosition);
      this.state = 2;
      return 0;
    }
    return readHeaders(paramExtractorInput);
  }
  
  protected abstract boolean readHeaders(ParsableByteArray paramParsableByteArray, long paramLong, StreamReader.SetupData paramSetupData);
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.setupData = new StreamReader.SetupData();
      this.payloadStartPosition = 0L;
      this.state = 0;
    }
    else
    {
      this.state = 1;
    }
    this.targetGranule = -1L;
    this.currentGranule = 0L;
  }
  
  final void seek(long paramLong1, long paramLong2)
  {
    this.oggPacket.reset();
    if (paramLong1 == 0L)
    {
      reset(this.seekMapSet ^ true);
      return;
    }
    if (this.state != 0)
    {
      this.targetGranule = this.oggSeeker.startSeek(paramLong2);
      this.state = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.StreamReader
 * JD-Core Version:    0.7.0.1
 */