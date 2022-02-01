package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class CeaDecoder
  implements SubtitleDecoder
{
  private static final int NUM_INPUT_BUFFERS = 10;
  private static final int NUM_OUTPUT_BUFFERS = 2;
  private final LinkedList<CeaDecoder.CeaInputBuffer> availableInputBuffers = new LinkedList();
  private final LinkedList<SubtitleOutputBuffer> availableOutputBuffers;
  private CeaDecoder.CeaInputBuffer dequeuedInputBuffer;
  private long playbackPositionUs;
  private long queuedInputBufferCount;
  private final PriorityQueue<CeaDecoder.CeaInputBuffer> queuedInputBuffers;
  
  public CeaDecoder()
  {
    int i = 0;
    while (i < 10)
    {
      this.availableInputBuffers.add(new CeaDecoder.CeaInputBuffer(null));
      i += 1;
    }
    this.availableOutputBuffers = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.availableOutputBuffers.add(new CeaDecoder.CeaOutputBuffer(this, null));
      i += 1;
    }
    this.queuedInputBuffers = new PriorityQueue();
  }
  
  private void releaseInputBuffer(CeaDecoder.CeaInputBuffer paramCeaInputBuffer)
  {
    paramCeaInputBuffer.clear();
    this.availableInputBuffers.add(paramCeaInputBuffer);
  }
  
  protected abstract Subtitle createSubtitle();
  
  protected abstract void decode(SubtitleInputBuffer paramSubtitleInputBuffer);
  
  public SubtitleInputBuffer dequeueInputBuffer()
  {
    if (this.dequeuedInputBuffer == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if (!this.availableInputBuffers.isEmpty()) {
        break;
      }
      return null;
    }
    this.dequeuedInputBuffer = ((CeaDecoder.CeaInputBuffer)this.availableInputBuffers.pollFirst());
    return this.dequeuedInputBuffer;
  }
  
  public SubtitleOutputBuffer dequeueOutputBuffer()
  {
    if (this.availableOutputBuffers.isEmpty()) {
      return null;
    }
    CeaDecoder.CeaInputBuffer localCeaInputBuffer;
    Object localObject;
    do
    {
      do
      {
        releaseInputBuffer(localCeaInputBuffer);
        if ((this.queuedInputBuffers.isEmpty()) || (((CeaDecoder.CeaInputBuffer)this.queuedInputBuffers.peek()).timeUs > this.playbackPositionUs)) {
          break;
        }
        localCeaInputBuffer = (CeaDecoder.CeaInputBuffer)this.queuedInputBuffers.poll();
        if (localCeaInputBuffer.isEndOfStream())
        {
          localObject = (SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst();
          ((SubtitleOutputBuffer)localObject).addFlag(4);
          releaseInputBuffer(localCeaInputBuffer);
          return localObject;
        }
        decode(localCeaInputBuffer);
      } while (!isNewSubtitleDataAvailable());
      localObject = createSubtitle();
    } while (localCeaInputBuffer.isDecodeOnly());
    SubtitleOutputBuffer localSubtitleOutputBuffer = (SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst();
    localSubtitleOutputBuffer.setContent(localCeaInputBuffer.timeUs, (Subtitle)localObject, 9223372036854775807L);
    releaseInputBuffer(localCeaInputBuffer);
    return localSubtitleOutputBuffer;
    return null;
  }
  
  public void flush()
  {
    this.queuedInputBufferCount = 0L;
    this.playbackPositionUs = 0L;
    while (!this.queuedInputBuffers.isEmpty()) {
      releaseInputBuffer((CeaDecoder.CeaInputBuffer)this.queuedInputBuffers.poll());
    }
    if (this.dequeuedInputBuffer != null)
    {
      releaseInputBuffer(this.dequeuedInputBuffer);
      this.dequeuedInputBuffer = null;
    }
  }
  
  public abstract String getName();
  
  protected abstract boolean isNewSubtitleDataAvailable();
  
  public void queueInputBuffer(SubtitleInputBuffer paramSubtitleInputBuffer)
  {
    boolean bool;
    if (paramSubtitleInputBuffer == this.dequeuedInputBuffer)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (!paramSubtitleInputBuffer.isDecodeOnly()) {
        break label40;
      }
      releaseInputBuffer(this.dequeuedInputBuffer);
    }
    for (;;)
    {
      this.dequeuedInputBuffer = null;
      return;
      bool = false;
      break;
      label40:
      paramSubtitleInputBuffer = this.dequeuedInputBuffer;
      long l = this.queuedInputBufferCount;
      this.queuedInputBufferCount = (1L + l);
      CeaDecoder.CeaInputBuffer.access$202(paramSubtitleInputBuffer, l);
      this.queuedInputBuffers.add(this.dequeuedInputBuffer);
    }
  }
  
  public void release() {}
  
  protected void releaseOutputBuffer(SubtitleOutputBuffer paramSubtitleOutputBuffer)
  {
    paramSubtitleOutputBuffer.clear();
    this.availableOutputBuffers.add(paramSubtitleOutputBuffer);
  }
  
  public void setPositionUs(long paramLong)
  {
    this.playbackPositionUs = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.CeaDecoder
 * JD-Core Version:    0.7.0.1
 */