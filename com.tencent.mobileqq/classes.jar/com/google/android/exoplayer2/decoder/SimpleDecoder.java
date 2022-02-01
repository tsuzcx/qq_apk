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
  
  /* Error */
  private boolean decode()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/exoplayer2/decoder/SimpleDecoder:lock	Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 96	com/google/android/exoplayer2/decoder/SimpleDecoder:released	Z
    //   13: ifne +26 -> 39
    //   16: aload_0
    //   17: invokespecial 98	com/google/android/exoplayer2/decoder/SimpleDecoder:canDecodeBuffer	()Z
    //   20: ifne +19 -> 39
    //   23: aload_0
    //   24: getfield 42	com/google/android/exoplayer2/decoder/SimpleDecoder:lock	Ljava/lang/Object;
    //   27: invokevirtual 101	java/lang/Object:wait	()V
    //   30: goto -21 -> 9
    //   33: astore_3
    //   34: aload 5
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    //   39: aload_0
    //   40: getfield 96	com/google/android/exoplayer2/decoder/SimpleDecoder:released	Z
    //   43: ifeq +8 -> 51
    //   46: aload 5
    //   48: monitorexit
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_0
    //   52: getfield 47	com/google/android/exoplayer2/decoder/SimpleDecoder:queuedInputBuffers	Ljava/util/LinkedList;
    //   55: invokevirtual 105	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   58: checkcast 107	com/google/android/exoplayer2/decoder/DecoderInputBuffer
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 59	com/google/android/exoplayer2/decoder/SimpleDecoder:availableOutputBuffers	[Lcom/google/android/exoplayer2/decoder/OutputBuffer;
    //   66: astore 4
    //   68: aload_0
    //   69: getfield 61	com/google/android/exoplayer2/decoder/SimpleDecoder:availableOutputBufferCount	I
    //   72: iconst_1
    //   73: isub
    //   74: istore_1
    //   75: aload_0
    //   76: iload_1
    //   77: putfield 61	com/google/android/exoplayer2/decoder/SimpleDecoder:availableOutputBufferCount	I
    //   80: aload 4
    //   82: iload_1
    //   83: aaload
    //   84: astore 4
    //   86: aload_0
    //   87: getfield 109	com/google/android/exoplayer2/decoder/SimpleDecoder:flushed	Z
    //   90: istore_2
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 109	com/google/android/exoplayer2/decoder/SimpleDecoder:flushed	Z
    //   96: aload 5
    //   98: monitorexit
    //   99: aload_3
    //   100: invokevirtual 112	com/google/android/exoplayer2/decoder/DecoderInputBuffer:isEndOfStream	()Z
    //   103: ifeq +41 -> 144
    //   106: aload 4
    //   108: iconst_4
    //   109: invokevirtual 118	com/google/android/exoplayer2/decoder/OutputBuffer:addFlag	(I)V
    //   112: aload_0
    //   113: getfield 42	com/google/android/exoplayer2/decoder/SimpleDecoder:lock	Ljava/lang/Object;
    //   116: astore 5
    //   118: aload 5
    //   120: monitorenter
    //   121: aload_0
    //   122: getfield 109	com/google/android/exoplayer2/decoder/SimpleDecoder:flushed	Z
    //   125: ifeq +100 -> 225
    //   128: aload_0
    //   129: aload 4
    //   131: invokespecial 122	com/google/android/exoplayer2/decoder/SimpleDecoder:releaseOutputBufferInternal	(Lcom/google/android/exoplayer2/decoder/OutputBuffer;)V
    //   134: aload_0
    //   135: aload_3
    //   136: invokespecial 126	com/google/android/exoplayer2/decoder/SimpleDecoder:releaseInputBufferInternal	(Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;)V
    //   139: aload 5
    //   141: monitorexit
    //   142: iconst_1
    //   143: ireturn
    //   144: aload_3
    //   145: invokevirtual 129	com/google/android/exoplayer2/decoder/DecoderInputBuffer:isDecodeOnly	()Z
    //   148: ifeq +10 -> 158
    //   151: aload 4
    //   153: ldc 130
    //   155: invokevirtual 118	com/google/android/exoplayer2/decoder/OutputBuffer:addFlag	(I)V
    //   158: aload_0
    //   159: aload_0
    //   160: aload_3
    //   161: aload 4
    //   163: iload_2
    //   164: invokevirtual 133	com/google/android/exoplayer2/decoder/SimpleDecoder:decode	(Lcom/google/android/exoplayer2/decoder/DecoderInputBuffer;Lcom/google/android/exoplayer2/decoder/OutputBuffer;Z)Ljava/lang/Exception;
    //   167: putfield 135	com/google/android/exoplayer2/decoder/SimpleDecoder:exception	Ljava/lang/Exception;
    //   170: aload_0
    //   171: getfield 135	com/google/android/exoplayer2/decoder/SimpleDecoder:exception	Ljava/lang/Exception;
    //   174: ifnull -62 -> 112
    //   177: aload_0
    //   178: getfield 42	com/google/android/exoplayer2/decoder/SimpleDecoder:lock	Ljava/lang/Object;
    //   181: astore_3
    //   182: aload_3
    //   183: monitorenter
    //   184: aload_3
    //   185: monitorexit
    //   186: iconst_0
    //   187: ireturn
    //   188: astore 5
    //   190: aload_0
    //   191: aload_0
    //   192: aload 5
    //   194: invokevirtual 139	com/google/android/exoplayer2/decoder/SimpleDecoder:createUnexpectedDecodeException	(Ljava/lang/Throwable;)Ljava/lang/Exception;
    //   197: putfield 135	com/google/android/exoplayer2/decoder/SimpleDecoder:exception	Ljava/lang/Exception;
    //   200: goto -30 -> 170
    //   203: astore 5
    //   205: aload_0
    //   206: aload_0
    //   207: aload 5
    //   209: invokevirtual 139	com/google/android/exoplayer2/decoder/SimpleDecoder:createUnexpectedDecodeException	(Ljava/lang/Throwable;)Ljava/lang/Exception;
    //   212: putfield 135	com/google/android/exoplayer2/decoder/SimpleDecoder:exception	Ljava/lang/Exception;
    //   215: goto -45 -> 170
    //   218: astore 4
    //   220: aload_3
    //   221: monitorexit
    //   222: aload 4
    //   224: athrow
    //   225: aload 4
    //   227: invokevirtual 140	com/google/android/exoplayer2/decoder/OutputBuffer:isDecodeOnly	()Z
    //   230: ifeq +28 -> 258
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 142	com/google/android/exoplayer2/decoder/SimpleDecoder:skippedOutputBufferCount	I
    //   238: iconst_1
    //   239: iadd
    //   240: putfield 142	com/google/android/exoplayer2/decoder/SimpleDecoder:skippedOutputBufferCount	I
    //   243: aload_0
    //   244: aload 4
    //   246: invokespecial 122	com/google/android/exoplayer2/decoder/SimpleDecoder:releaseOutputBufferInternal	(Lcom/google/android/exoplayer2/decoder/OutputBuffer;)V
    //   249: goto -115 -> 134
    //   252: astore_3
    //   253: aload 5
    //   255: monitorexit
    //   256: aload_3
    //   257: athrow
    //   258: aload 4
    //   260: aload_0
    //   261: getfield 142	com/google/android/exoplayer2/decoder/SimpleDecoder:skippedOutputBufferCount	I
    //   264: putfield 143	com/google/android/exoplayer2/decoder/OutputBuffer:skippedOutputBufferCount	I
    //   267: aload_0
    //   268: iconst_0
    //   269: putfield 142	com/google/android/exoplayer2/decoder/SimpleDecoder:skippedOutputBufferCount	I
    //   272: aload_0
    //   273: getfield 49	com/google/android/exoplayer2/decoder/SimpleDecoder:queuedOutputBuffers	Ljava/util/LinkedList;
    //   276: aload 4
    //   278: invokevirtual 147	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   281: goto -147 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	SimpleDecoder
    //   74	9	1	i	int
    //   90	74	2	bool	boolean
    //   33	5	3	localObject1	Object
    //   252	5	3	localObject3	Object
    //   66	96	4	localObject4	Object
    //   218	59	4	localOutputBuffer	OutputBuffer
    //   4	136	5	localObject5	Object
    //   188	5	5	localRuntimeException	java.lang.RuntimeException
    //   203	51	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   9	30	33	finally
    //   34	37	33	finally
    //   39	49	33	finally
    //   51	80	33	finally
    //   86	99	33	finally
    //   158	170	188	java/lang/RuntimeException
    //   158	170	203	java/lang/OutOfMemoryError
    //   184	186	218	finally
    //   220	222	218	finally
    //   121	134	252	finally
    //   134	142	252	finally
    //   225	249	252	finally
    //   253	256	252	finally
    //   258	281	252	finally
  }
  
  private void maybeNotifyDecodeLoop()
  {
    if (canDecodeBuffer()) {
      this.lock.notify();
    }
  }
  
  private void maybeThrowException()
  {
    if (this.exception != null) {
      throw this.exception;
    }
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
      throw new IllegalStateException(localInterruptedException);
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
            this.dequeuedInputBuffer = ((DecoderInputBuffer)localObject1);
            localObject1 = this.dequeuedInputBuffer;
            return localObject1;
          }
          Object localObject1 = this.availableInputBuffers;
          int i = this.availableInputBufferCount - 1;
          this.availableInputBufferCount = i;
          localObject1 = localObject1[i];
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
      if (!this.queuedInputBuffers.isEmpty()) {
        releaseInputBufferInternal((DecoderInputBuffer)this.queuedInputBuffers.removeFirst());
      }
    }
    while (!this.queuedOutputBuffers.isEmpty()) {
      releaseOutputBufferInternal((OutputBuffer)this.queuedOutputBuffers.removeFirst());
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
    int i = 0;
    if (this.availableInputBufferCount == this.availableInputBuffers.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      DecoderInputBuffer[] arrayOfDecoderInputBuffer = this.availableInputBuffers;
      int j = arrayOfDecoderInputBuffer.length;
      while (i < j)
      {
        arrayOfDecoderInputBuffer[i].ensureSpaceForWrite(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.SimpleDecoder
 * JD-Core Version:    0.7.0.1
 */