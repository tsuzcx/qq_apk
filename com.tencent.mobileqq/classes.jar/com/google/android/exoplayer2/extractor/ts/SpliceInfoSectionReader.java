package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class SpliceInfoSectionReader
  implements SectionPayloadReader
{
  private boolean formatDeclared;
  private TrackOutput output;
  private TimestampAdjuster timestampAdjuster;
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    if (!this.formatDeclared)
    {
      if (this.timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) {
        return;
      }
      this.output.format(Format.createSampleFormat(null, "application/x-scte35", this.timestampAdjuster.getTimestampOffsetUs()));
      this.formatDeclared = true;
    }
    int i = paramParsableByteArray.bytesLeft();
    this.output.sampleData(paramParsableByteArray, i);
    this.output.sampleMetadata(this.timestampAdjuster.getLastAdjustedTimestampUs(), 1, i, 0, null);
  }
  
  public void init(TimestampAdjuster paramTimestampAdjuster, ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    this.timestampAdjuster = paramTimestampAdjuster;
    paramTrackIdGenerator.generateNewId();
    this.output = paramExtractorOutput.track(paramTrackIdGenerator.getTrackId(), 4);
    this.output.format(Format.createSampleFormat(paramTrackIdGenerator.getFormatId(), "application/x-scte35", null, -1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.SpliceInfoSectionReader
 * JD-Core Version:    0.7.0.1
 */