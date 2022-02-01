package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

final class SingleSampleMediaPeriod$SampleStreamImpl
  implements SampleStream
{
  private static final int STREAM_STATE_END_OF_STREAM = 2;
  private static final int STREAM_STATE_SEND_FORMAT = 0;
  private static final int STREAM_STATE_SEND_SAMPLE = 1;
  private boolean formatSent;
  private int streamState;
  
  private SingleSampleMediaPeriod$SampleStreamImpl(SingleSampleMediaPeriod paramSingleSampleMediaPeriod) {}
  
  private void sendFormat()
  {
    if (!this.formatSent)
    {
      SingleSampleMediaPeriod.access$300(this.this$0).downstreamFormatChanged(MimeTypes.getTrackType(this.this$0.format.sampleMimeType), this.this$0.format, 0, null, 0L);
      this.formatSent = true;
    }
  }
  
  public boolean isReady()
  {
    return this.this$0.loadingFinished;
  }
  
  public void maybeThrowError()
  {
    if (!this.this$0.treatLoadErrorsAsEndOfStream) {
      this.this$0.loader.maybeThrowError();
    }
  }
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (this.streamState == 2)
    {
      paramDecoderInputBuffer.addFlag(4);
      return -4;
    }
    if ((paramBoolean) || (this.streamState == 0))
    {
      paramFormatHolder.format = this.this$0.format;
      this.streamState = 1;
      return -5;
    }
    if (this.this$0.loadingFinished)
    {
      if (this.this$0.loadingSucceeded)
      {
        paramDecoderInputBuffer.timeUs = 0L;
        paramDecoderInputBuffer.addFlag(1);
        paramDecoderInputBuffer.ensureSpaceForWrite(this.this$0.sampleSize);
        paramDecoderInputBuffer.data.put(this.this$0.sampleData, 0, this.this$0.sampleSize);
        sendFormat();
      }
      for (;;)
      {
        this.streamState = 2;
        return -4;
        paramDecoderInputBuffer.addFlag(4);
      }
    }
    return -3;
  }
  
  public void reset()
  {
    if (this.streamState == 2) {
      this.streamState = 1;
    }
  }
  
  public int skipData(long paramLong)
  {
    if ((paramLong > 0L) && (this.streamState != 2))
    {
      this.streamState = 2;
      sendFormat();
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl
 * JD-Core Version:    0.7.0.1
 */