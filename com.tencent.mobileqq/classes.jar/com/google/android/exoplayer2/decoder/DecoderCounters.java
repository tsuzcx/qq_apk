package com.google.android.exoplayer2.decoder;

public final class DecoderCounters
{
  public int decoderInitCount;
  public int decoderReleaseCount;
  public int droppedBufferCount;
  public int droppedToKeyframeCount;
  public int inputBufferCount;
  public int maxConsecutiveDroppedBufferCount;
  public int renderedOutputBufferCount;
  public int skippedInputBufferCount;
  public int skippedOutputBufferCount;
  
  public void ensureUpdated() {}
  
  public void merge(DecoderCounters paramDecoderCounters)
  {
    this.decoderInitCount += paramDecoderCounters.decoderInitCount;
    this.decoderReleaseCount += paramDecoderCounters.decoderReleaseCount;
    this.inputBufferCount += paramDecoderCounters.inputBufferCount;
    this.skippedInputBufferCount += paramDecoderCounters.skippedInputBufferCount;
    this.renderedOutputBufferCount += paramDecoderCounters.renderedOutputBufferCount;
    this.skippedOutputBufferCount += paramDecoderCounters.skippedOutputBufferCount;
    this.droppedBufferCount += paramDecoderCounters.droppedBufferCount;
    this.maxConsecutiveDroppedBufferCount = Math.max(this.maxConsecutiveDroppedBufferCount, paramDecoderCounters.maxConsecutiveDroppedBufferCount);
    this.droppedToKeyframeCount += paramDecoderCounters.droppedToKeyframeCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.DecoderCounters
 * JD-Core Version:    0.7.0.1
 */