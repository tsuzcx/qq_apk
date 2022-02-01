package com.google.android.exoplayer2.extractor.rawcc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class RawCcExtractor
  implements Extractor
{
  private static final int HEADER_ID = Util.getIntegerCodeForString("RCC\001");
  private static final int HEADER_SIZE = 8;
  private static final int SCRATCH_SIZE = 9;
  private static final int STATE_READING_HEADER = 0;
  private static final int STATE_READING_SAMPLES = 2;
  private static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
  private static final int TIMESTAMP_SIZE_V0 = 4;
  private static final int TIMESTAMP_SIZE_V1 = 8;
  private final ParsableByteArray dataScratch;
  private final Format format;
  private int parserState;
  private int remainingSampleCount;
  private int sampleBytesWritten;
  private long timestampUs;
  private TrackOutput trackOutput;
  private int version;
  
  public RawCcExtractor(Format paramFormat)
  {
    this.format = paramFormat;
    this.dataScratch = new ParsableByteArray(9);
    this.parserState = 0;
  }
  
  private boolean parseHeader(ExtractorInput paramExtractorInput)
  {
    this.dataScratch.reset();
    if (paramExtractorInput.readFully(this.dataScratch.data, 0, 8, true))
    {
      if (this.dataScratch.readInt() != HEADER_ID) {
        throw new IOException("Input not RawCC");
      }
      this.version = this.dataScratch.readUnsignedByte();
      return true;
    }
    return false;
  }
  
  private void parseSamples(ExtractorInput paramExtractorInput)
  {
    while (this.remainingSampleCount > 0)
    {
      this.dataScratch.reset();
      paramExtractorInput.readFully(this.dataScratch.data, 0, 3);
      this.trackOutput.sampleData(this.dataScratch, 3);
      this.sampleBytesWritten += 3;
      this.remainingSampleCount -= 1;
    }
    if (this.sampleBytesWritten > 0) {
      this.trackOutput.sampleMetadata(this.timestampUs, 1, this.sampleBytesWritten, 0, null);
    }
  }
  
  private boolean parseTimestampAndSampleCount(ExtractorInput paramExtractorInput)
  {
    this.dataScratch.reset();
    if (this.version == 0) {
      if (!paramExtractorInput.readFully(this.dataScratch.data, 0, 5, true)) {
        return false;
      }
    }
    for (this.timestampUs = (this.dataScratch.readUnsignedInt() * 1000L / 45L);; this.timestampUs = this.dataScratch.readLong())
    {
      this.remainingSampleCount = this.dataScratch.readUnsignedByte();
      this.sampleBytesWritten = 0;
      return true;
      if (this.version != 1) {
        break label114;
      }
      if (!paramExtractorInput.readFully(this.dataScratch.data, 0, 9, true)) {
        break;
      }
    }
    label114:
    throw new ParserException("Unsupported version number: " + this.version);
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    paramExtractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    this.trackOutput = paramExtractorOutput.track(0, 3);
    paramExtractorOutput.endTracks();
    this.trackOutput.format(this.format);
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    for (;;)
    {
      switch (this.parserState)
      {
      default: 
        throw new IllegalStateException();
      case 0: 
        if (!parseHeader(paramExtractorInput)) {
          break label77;
        }
        this.parserState = 1;
        break;
      case 1: 
        if (!parseTimestampAndSampleCount(paramExtractorInput)) {
          break label72;
        }
        this.parserState = 2;
      }
    }
    label72:
    this.parserState = 0;
    label77:
    return -1;
    parseSamples(paramExtractorInput);
    this.parserState = 1;
    return 0;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.parserState = 0;
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    boolean bool = false;
    this.dataScratch.reset();
    paramExtractorInput.peekFully(this.dataScratch.data, 0, 8);
    if (this.dataScratch.readInt() == HEADER_ID) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor
 * JD-Core Version:    0.7.0.1
 */