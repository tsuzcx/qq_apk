package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

final class ClippingMediaPeriod$ClippingSampleStream
  implements SampleStream
{
  public final SampleStream childStream;
  private boolean sentEos;
  
  public ClippingMediaPeriod$ClippingSampleStream(ClippingMediaPeriod paramClippingMediaPeriod, SampleStream paramSampleStream)
  {
    this.childStream = paramSampleStream;
  }
  
  public void clearSentEos()
  {
    this.sentEos = false;
  }
  
  public boolean isReady()
  {
    return (!this.this$0.isPendingInitialDiscontinuity()) && (this.childStream.isReady());
  }
  
  public void maybeThrowError()
  {
    this.childStream.maybeThrowError();
  }
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (this.this$0.isPendingInitialDiscontinuity()) {
      return -3;
    }
    if (this.sentEos)
    {
      paramDecoderInputBuffer.setFlags(4);
      return -4;
    }
    int i = this.childStream.readData(paramFormatHolder, paramDecoderInputBuffer, paramBoolean);
    if (i == -5)
    {
      paramDecoderInputBuffer = paramFormatHolder.format;
      if ((paramDecoderInputBuffer.encoderDelay != -1) || (paramDecoderInputBuffer.encoderPadding != -1))
      {
        if (this.this$0.startUs == 0L) {
          break label117;
        }
        i = 0;
        if (this.this$0.endUs == -9223372036854775808L) {
          break label126;
        }
      }
      label117:
      label126:
      for (int j = 0;; j = paramDecoderInputBuffer.encoderPadding)
      {
        paramFormatHolder.format = paramDecoderInputBuffer.copyWithGaplessInfo(i, j);
        return -5;
        i = paramDecoderInputBuffer.encoderDelay;
        break;
      }
    }
    if ((this.this$0.endUs != -9223372036854775808L) && (((i == -4) && (paramDecoderInputBuffer.timeUs >= this.this$0.endUs)) || ((i == -3) && (this.this$0.getBufferedPositionUs() == -9223372036854775808L))))
    {
      paramDecoderInputBuffer.clear();
      paramDecoderInputBuffer.setFlags(4);
      this.sentEos = true;
      return -4;
    }
    if ((i == -4) && (!paramDecoderInputBuffer.isEndOfStream())) {
      paramDecoderInputBuffer.timeUs -= this.this$0.startUs;
    }
    return i;
  }
  
  public int skipData(long paramLong)
  {
    if (this.this$0.isPendingInitialDiscontinuity()) {
      return -3;
    }
    return this.childStream.skipData(this.this$0.startUs + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream
 * JD-Core Version:    0.7.0.1
 */