package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

final class ExtractorMediaPeriod$SampleStreamImpl
  implements SampleStream
{
  private final int track;
  
  public ExtractorMediaPeriod$SampleStreamImpl(ExtractorMediaPeriod paramExtractorMediaPeriod, int paramInt)
  {
    this.track = paramInt;
  }
  
  public boolean isReady()
  {
    return this.this$0.isReady(this.track);
  }
  
  public void maybeThrowError()
  {
    this.this$0.maybeThrowError();
  }
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    return this.this$0.readData(this.track, paramFormatHolder, paramDecoderInputBuffer, paramBoolean);
  }
  
  public int skipData(long paramLong)
  {
    return this.this$0.skipData(this.track, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod.SampleStreamImpl
 * JD-Core Version:    0.7.0.1
 */