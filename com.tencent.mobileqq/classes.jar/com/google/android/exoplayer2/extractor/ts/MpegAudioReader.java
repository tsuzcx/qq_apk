package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class MpegAudioReader
  implements ElementaryStreamReader
{
  private static final int HEADER_SIZE = 4;
  private static final int STATE_FINDING_HEADER = 0;
  private static final int STATE_READING_FRAME = 2;
  private static final int STATE_READING_HEADER = 1;
  private String formatId;
  private int frameBytesRead;
  private long frameDurationUs;
  private int frameSize;
  private boolean hasOutputFormat;
  private final MpegAudioHeader header;
  private final ParsableByteArray headerScratch = new ParsableByteArray(4);
  private final String language;
  private boolean lastByteWasFF;
  private TrackOutput output;
  private int state = 0;
  private long timeUs;
  
  public MpegAudioReader()
  {
    this(null);
  }
  
  public MpegAudioReader(String paramString)
  {
    this.headerScratch.data[0] = -1;
    this.header = new MpegAudioHeader();
    this.language = paramString;
  }
  
  private void findHeader(ParsableByteArray paramParsableByteArray)
  {
    byte[] arrayOfByte = paramParsableByteArray.data;
    int i = paramParsableByteArray.getPosition();
    int k = paramParsableByteArray.limit();
    while (i < k)
    {
      boolean bool;
      if ((arrayOfByte[i] & 0xFF) == 255) {
        bool = true;
      } else {
        bool = false;
      }
      int j;
      if ((this.lastByteWasFF) && ((arrayOfByte[i] & 0xE0) == 224)) {
        j = 1;
      } else {
        j = 0;
      }
      this.lastByteWasFF = bool;
      if (j != 0)
      {
        paramParsableByteArray.setPosition(i + 1);
        this.lastByteWasFF = false;
        this.headerScratch.data[1] = arrayOfByte[i];
        this.frameBytesRead = 2;
        this.state = 1;
        return;
      }
      i += 1;
    }
    paramParsableByteArray.setPosition(k);
  }
  
  private void readFrameRemainder(ParsableByteArray paramParsableByteArray)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
    this.output.sampleData(paramParsableByteArray, i);
    this.frameBytesRead += i;
    i = this.frameBytesRead;
    int j = this.frameSize;
    if (i < j) {
      return;
    }
    this.output.sampleMetadata(this.timeUs, 1, j, 0, null);
    this.timeUs += this.frameDurationUs;
    this.frameBytesRead = 0;
    this.state = 0;
  }
  
  private void readHeaderRemainder(ParsableByteArray paramParsableByteArray)
  {
    int i = Math.min(paramParsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
    paramParsableByteArray.readBytes(this.headerScratch.data, this.frameBytesRead, i);
    this.frameBytesRead += i;
    if (this.frameBytesRead < 4) {
      return;
    }
    this.headerScratch.setPosition(0);
    if (!MpegAudioHeader.populateHeader(this.headerScratch.readInt(), this.header))
    {
      this.frameBytesRead = 0;
      this.state = 1;
      return;
    }
    this.frameSize = this.header.frameSize;
    if (!this.hasOutputFormat)
    {
      this.frameDurationUs = (this.header.samplesPerFrame * 1000000L / this.header.sampleRate);
      paramParsableByteArray = Format.createAudioSampleFormat(this.formatId, this.header.mimeType, null, -1, 4096, this.header.channels, this.header.sampleRate, null, null, 0, this.language);
      this.output.format(paramParsableByteArray);
      this.hasOutputFormat = true;
    }
    this.headerScratch.setPosition(0);
    this.output.sampleData(this.headerScratch, 4);
    this.state = 2;
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    while (paramParsableByteArray.bytesLeft() > 0)
    {
      int i = this.state;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            readFrameRemainder(paramParsableByteArray);
          }
        }
        else {
          readHeaderRemainder(paramParsableByteArray);
        }
      }
      else {
        findHeader(paramParsableByteArray);
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
    this.frameBytesRead = 0;
    this.lastByteWasFF = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.MpegAudioReader
 * JD-Core Version:    0.7.0.1
 */