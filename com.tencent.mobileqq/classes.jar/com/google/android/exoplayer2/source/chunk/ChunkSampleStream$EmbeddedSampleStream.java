package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;

public final class ChunkSampleStream$EmbeddedSampleStream
  implements SampleStream
{
  private boolean formatNotificationSent;
  private final int index;
  public final ChunkSampleStream<T> parent;
  private final SampleQueue sampleQueue;
  
  public ChunkSampleStream$EmbeddedSampleStream(ChunkSampleStream<T> paramChunkSampleStream, SampleQueue paramSampleQueue, int paramInt)
  {
    this.parent = paramSampleQueue;
    this.sampleQueue = paramInt;
    int i;
    this.index = i;
  }
  
  private void maybeNotifyTrackFormatChanged()
  {
    if (!this.formatNotificationSent)
    {
      ChunkSampleStream.access$400(this.this$0).downstreamFormatChanged(ChunkSampleStream.access$100(this.this$0)[this.index], ChunkSampleStream.access$200(this.this$0)[this.index], 0, null, ChunkSampleStream.access$300(this.this$0));
      this.formatNotificationSent = true;
    }
  }
  
  public boolean isReady()
  {
    return (this.this$0.loadingFinished) || ((!this.this$0.isPendingReset()) && (this.sampleQueue.hasNextSample()));
  }
  
  public void maybeThrowError() {}
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (this.this$0.isPendingReset()) {
      return -3;
    }
    int i = this.sampleQueue.read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean, this.this$0.loadingFinished, this.this$0.decodeOnlyUntilPositionUs);
    if (i == -4) {
      maybeNotifyTrackFormatChanged();
    }
    return i;
  }
  
  public void release()
  {
    Assertions.checkState(ChunkSampleStream.access$000(this.this$0)[this.index]);
    ChunkSampleStream.access$000(this.this$0)[this.index] = 0;
  }
  
  public int skipData(long paramLong)
  {
    int i;
    if ((this.this$0.loadingFinished) && (paramLong > this.sampleQueue.getLargestQueuedTimestampUs()))
    {
      i = this.sampleQueue.advanceToEnd();
    }
    else
    {
      int j = this.sampleQueue.advanceTo(paramLong, true, true);
      i = j;
      if (j == -1) {
        i = 0;
      }
    }
    if (i > 0) {
      maybeNotifyTrackFormatChanged();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream
 * JD-Core Version:    0.7.0.1
 */