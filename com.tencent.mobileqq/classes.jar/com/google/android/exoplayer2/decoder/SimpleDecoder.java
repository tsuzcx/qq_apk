package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception>
  implements Decoder<I, O, E>
{
  private int availableInputBufferCount;
  private final I[] availableInputBuffers;
  private int availableOutputBufferCount;
  private final O[] availableOutputBuffers;
  private final Thread decodeThread;
  private I dequeuedInputBuffer;
  private E exception;
  private boolean flushed;
  private final Object lock = new Object();
  private final LinkedList<I> queuedInputBuffers = new LinkedList();
  private final LinkedList<O> queuedOutputBuffers = new LinkedList();
  private boolean released;
  private int skippedOutputBufferCount;
  
  protected SimpleDecoder(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.availableInputBuffers = paramArrayOfI;
    this.availableInputBufferCount = paramArrayOfI.length;
    int j = 0;
    int i = 0;
    while (i < this.availableInputBufferCount)
    {
      this.availableInputBuffers[i] = createInputBuffer();
      i += 1;
    }
    this.availableOutputBuffers = paramArrayOfO;
    this.availableOutputBufferCount = paramArrayOfO.length;
    i = j;
    while (i < this.availableOutputBufferCount)
    {
      this.availableOutputBuffers[i] = createOutputBuffer();
      i += 1;
    }
    this.decodeThread = new SimpleDecoder.1(this);
    this.decodeThread.start();
  }
  
  private boolean canDecodeBuffer()
  {
    return (!this.queuedInputBuffers.isEmpty()) && (this.availableOutputBufferCount > 0);
  }
  
  private boolean decode()
  {
    synchronized (this.lock)
    {
      while ((!this.released) && (!canDecodeBuffer())) {
        this.lock.wait();
      }
      if (this.released) {
        return false;
      }
      ??? = (DecoderInputBuffer)this.queuedInputBuffers.removeFirst();
      Object localObject4 = this.availableOutputBuffers;
      int i = this.availableOutputBufferCount - 1;
      this.availableOutputBufferCount = i;
      localObject4 = localObject4[i];
      boolean bool = this.flushed;
      this.flushed = false;
      if (((DecoderInputBuffer)???).isEndOfStream())
      {
        ((OutputBuffer)localObject4).addFlag(4);
      }
      else
      {
        if (((DecoderInputBuffer)???).isDecodeOnly()) {
          ((OutputBuffer)localObject4).addFlag(-2147483648);
        }
        try
        {
          this.exception = decode((DecoderInputBuffer)???, (OutputBuffer)localObject4, bool);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.exception = createUnexpectedDecodeException(localOutOfMemoryError);
        }
        catch (RuntimeException localRuntimeException)
        {
          this.exception = createUnexpectedDecodeException(localRuntimeException);
        }
        if (this.exception != null) {
          synchronized (this.lock)
          {
            return false;
          }
        }
      }
      synchronized (this.lock)
      {
        if (this.flushed)
        {
          releaseOutputBufferInternal(localOutputBuffer);
        }
        else if (localOutputBuffer.isDecodeOnly())
        {
          this.skippedOutputBufferCount += 1;
          releaseOutputBufferInternal(localOutputBuffer);
        }
        else
        {
          localOutputBuffer.skippedOutputBufferCount = this.skippedOutputBufferCount;
          this.skippedOutputBufferCount = 0;
          this.queuedOutputBuffers.addLast(localOutputBuffer);
        }
        releaseInputBufferInternal((DecoderInputBuffer)???);
        return true;
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void maybeNotifyDecodeLoop()
  {
    if (canDecodeBuffer()) {
      this.lock.notify();
    }
  }
  
  private void maybeThrowException()
  {
    Exception localException = this.exception;
    if (localException == null) {
      return;
    }
    throw localException;
  }
  
  private void releaseInputBufferInternal(I paramI)
  {
    paramI.clear();
    DecoderInputBuffer[] arrayOfDecoderInputBuffer = this.availableInputBuffers;
    int i = this.availableInputBufferCount;
    this.availableInputBufferCount = (i + 1);
    arrayOfDecoderInputBuffer[i] = paramI;
  }
  
  private void releaseOutputBufferInternal(O paramO)
  {
    paramO.clear();
    OutputBuffer[] arrayOfOutputBuffer = this.availableOutputBuffers;
    int i = this.availableOutputBufferCount;
    this.availableOutputBufferCount = (i + 1);
    arrayOfOutputBuffer[i] = paramO;
  }
  
  private void run()
  {
    IllegalStateException localIllegalStateException;
    try
    {
      boolean bool;
      do
      {
        bool = decode();
      } while (bool);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localIllegalStateException = new IllegalStateException(localInterruptedException);
    }
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  protected abstract I createInputBuffer();
  
  protected abstract O createOutputBuffer();
  
  protected abstract E createUnexpectedDecodeException(Throwable paramThrowable);
  
  protected abstract E decode(I paramI, O paramO, boolean paramBoolean);
  
  public final I dequeueInputBuffer()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        maybeThrowException();
        if (this.dequeuedInputBuffer == null)
        {
          bool = true;
          Assertions.checkState(bool);
          if (this.availableInputBufferCount == 0)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = this.availableInputBuffers;
            int i = this.availableInputBufferCount - 1;
            this.availableInputBufferCount = i;
            localObject1 = localObject1[i];
          }
          this.dequeuedInputBuffer = ((DecoderInputBuffer)localObject1);
          Object localObject1 = this.dequeuedInputBuffer;
          return localObject1;
        }
      }
      boolean bool = false;
    }
  }
  
  public final O dequeueOutputBuffer()
  {
    synchronized (this.lock)
    {
      maybeThrowException();
      if (this.queuedOutputBuffers.isEmpty()) {
        return null;
      }
      OutputBuffer localOutputBuffer = (OutputBuffer)this.queuedOutputBuffers.removeFirst();
      return localOutputBuffer;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.flushed = true;
      this.skippedOutputBufferCount = 0;
      if (this.dequeuedInputBuffer != null)
      {
        releaseInputBufferInternal(this.dequeuedInputBuffer);
        this.dequeuedInputBuffer = null;
      }
      while (!this.queuedInputBuffers.isEmpty()) {
        releaseInputBufferInternal((DecoderInputBuffer)this.queuedInputBuffers.removeFirst());
      }
      while (!this.queuedOutputBuffers.isEmpty()) {
        releaseOutputBufferInternal((OutputBuffer)this.queuedOutputBuffers.removeFirst());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void queueInputBuffer(I paramI)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        maybeThrowException();
        if (paramI == this.dequeuedInputBuffer)
        {
          bool = true;
          Assertions.checkArgument(bool);
          this.queuedInputBuffers.addLast(paramI);
          maybeNotifyDecodeLoop();
          this.dequeuedInputBuffer = null;
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public void release()
  {
    synchronized (this.lock)
    {
      this.released = true;
      this.lock.notify();
      try
      {
        this.decodeThread.join();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        label29:
        break label29;
      }
      Thread.currentThread().interrupt();
      return;
    }
  }
  
  protected void releaseOutputBuffer(O paramO)
  {
    synchronized (this.lock)
    {
      releaseOutputBufferInternal(paramO);
      maybeNotifyDecodeLoop();
      return;
    }
  }
  
  protected final void setInitialInputBufferSize(int paramInt)
  {
    int j = this.availableInputBufferCount;
    int k = this.availableInputBuffers.length;
    int i = 0;
    boolean bool;
    if (j == k) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    DecoderInputBuffer[] arrayOfDecoderInputBuffer = this.availableInputBuffers;
    j = arrayOfDecoderInputBuffer.length;
    while (i < j)
    {
      arrayOfDecoderInputBuffer[i].ensureSpaceForWrite(paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.SimpleDecoder
 * JD-Core Version:    0.7.0.1
 */