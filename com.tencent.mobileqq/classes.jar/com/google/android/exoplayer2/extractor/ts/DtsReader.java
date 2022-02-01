package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DtsReader
  implements ElementaryStreamReader
{
  private static final int HEADER_SIZE = 18;
  private static final int STATE_FINDING_SYNC = 0;
  private static final int STATE_READING_HEADER = 1;
  private static final int STATE_READING_SAMPLE = 2;
  private int bytesRead;
  private Format format;
  private String formatId;
  private final ParsableByteArray headerScratchBytes = new ParsableByteArray(new byte[18]);
  private final String language;
  private TrackOutput output;
  private long sampleDurationUs;
  private int sampleSize;
  private int state = 0;
  private int syncBytes;
  private long timeUs;
  
  public DtsReader(String paramString)
  {
    this.language = paramString;
  }
  
  private boolean continueRead(ParsableByteArray paramParsableByteArray, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), paramInt - this.bytesRead);
    paramParsableByteArray.readBytes(paramArrayOfByte, this.bytesRead, i);
    this.bytesRead = (i + this.bytesRead);
    return this.bytesRead == paramInt;
  }
  
  private void parseHeader()
  {
    byte[] arrayOfByte = this.headerScratchBytes.data;
    if (this.format == null)
    {
      this.format = DtsUtil.parseDtsFormat(arrayOfByte, this.formatId, this.language, null);
      this.output.format(this.format);
    }
    this.sampleSize = DtsUtil.getDtsFrameSize(arrayOfByte);
    this.sampleDurationUs = ((int)(DtsUtil.parseDtsAudioSampleCount(arrayOfByte) * 1000000L / this.format.sampleRate));
  }
  
  private boolean skipToNextSync(ParsableByteArray paramParsableByteArray)
  {
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      this.syncBytes <<= 8;
      this.syncBytes |= paramParsableByteArray.readUnsignedByte();
      if (DtsUtil.isSyncWord(this.syncBytes))
      {
        this.headerScratchBytes.data[0] = ((byte)(this.syncBytes >> 24 & 0xFF));
        this.headerScratchBytes.data[1] = ((byte)(this.syncBytes >> 16 & 0xFF));
        this.headerScratchBytes.data[2] = ((byte)(this.syncBytes >> 8 & 0xFF));
        this.headerScratchBytes.data[3] = ((byte)(this.syncBytes & 0xFF));
        this.bytesRead = 4;
        this.syncBytes = 0;
        return true;
      }
    }
    return false;
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (!skipToNextSync(paramParsableByteArray)) {
          continue;
        }
        this.state = 1;
        break;
      case 1: 
        if (!continueRead(paramParsableByteArray, this.headerScratchBytes.data, 18)) {
          continue;
        }
        parseHeader();
        this.headerScratchBytes.setPosition(0);
        this.output.sampleData(this.headerScratchBytes, 18);
        this.state = 2;
        break;
      }
      int i = Math.min(paramParsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
      this.output.sampleData(paramParsableByteArray, i);
      this.bytesRead = (i + this.bytesRead);
      if (this.bytesRead == this.sampleSize)
      {
        this.output.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
        this.timeUs += this.sampleDurationUs;
        this.state = 0;
      }
    }
  }
  
  public void createTracks(ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    paramTrackIdGenerator.generateNewId();
    this.formatId = paramTrackIdGenerator.getFormatId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 1);
  }
  
  public void packetFinished() {}
  
  public void packetStarted(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public void seek()
  {
    this.state = 0;
    this.bytesRead = 0;
    this.syncBytes = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.DtsReader
 * JD-Core Version:    0.7.0.1
 */