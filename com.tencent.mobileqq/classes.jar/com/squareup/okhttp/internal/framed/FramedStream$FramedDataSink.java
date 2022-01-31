package com.squareup.okhttp.internal.framed;

import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class FramedStream$FramedDataSink
  implements Sink
{
  private static final long EMIT_BUFFER_SIZE = 16384L;
  private boolean closed;
  private boolean finished;
  private final Buffer sendBuffer = new Buffer();
  
  static
  {
    if (!FramedStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  FramedStream$FramedDataSink(FramedStream paramFramedStream) {}
  
  /* Error */
  private void emitDataFrame(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   13: invokestatic 57	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   16: invokevirtual 62	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
    //   19: aload_0
    //   20: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   23: getfield 65	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
    //   26: lconst_0
    //   27: lcmp
    //   28: ifgt +60 -> 88
    //   31: aload_0
    //   32: getfield 46	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:finished	Z
    //   35: ifne +53 -> 88
    //   38: aload_0
    //   39: getfield 51	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:closed	Z
    //   42: ifne +46 -> 88
    //   45: aload_0
    //   46: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   49: invokestatic 69	com/squareup/okhttp/internal/framed/FramedStream:access$800	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   52: ifnonnull +36 -> 88
    //   55: aload_0
    //   56: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   59: invokestatic 72	com/squareup/okhttp/internal/framed/FramedStream:access$900	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
    //   62: goto -43 -> 19
    //   65: astore 6
    //   67: aload_0
    //   68: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   71: invokestatic 57	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   74: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   77: aload 6
    //   79: athrow
    //   80: astore 6
    //   82: aload 5
    //   84: monitorexit
    //   85: aload 6
    //   87: athrow
    //   88: aload_0
    //   89: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   92: invokestatic 57	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   95: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   98: aload_0
    //   99: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   102: invokestatic 78	com/squareup/okhttp/internal/framed/FramedStream:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedStream;)V
    //   105: aload_0
    //   106: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   109: getfield 65	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
    //   112: aload_0
    //   113: getfield 42	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
    //   116: invokevirtual 82	okio/Buffer:size	()J
    //   119: invokestatic 88	java/lang/Math:min	(JJ)J
    //   122: lstore_3
    //   123: aload_0
    //   124: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   127: astore 6
    //   129: aload 6
    //   131: aload 6
    //   133: getfield 65	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
    //   136: lload_3
    //   137: lsub
    //   138: putfield 65	com/squareup/okhttp/internal/framed/FramedStream:bytesLeftInWriteWindow	J
    //   141: aload 5
    //   143: monitorexit
    //   144: aload_0
    //   145: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   148: invokestatic 57	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   151: invokevirtual 62	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:enter	()V
    //   154: aload_0
    //   155: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   158: invokestatic 92	com/squareup/okhttp/internal/framed/FramedStream:access$500	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   161: astore 5
    //   163: aload_0
    //   164: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   167: invokestatic 96	com/squareup/okhttp/internal/framed/FramedStream:access$600	(Lcom/squareup/okhttp/internal/framed/FramedStream;)I
    //   170: istore_2
    //   171: iload_1
    //   172: ifeq +40 -> 212
    //   175: lload_3
    //   176: aload_0
    //   177: getfield 42	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
    //   180: invokevirtual 82	okio/Buffer:size	()J
    //   183: lcmp
    //   184: ifne +28 -> 212
    //   187: iconst_1
    //   188: istore_1
    //   189: aload 5
    //   191: iload_2
    //   192: iload_1
    //   193: aload_0
    //   194: getfield 42	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:sendBuffer	Lokio/Buffer;
    //   197: lload_3
    //   198: invokevirtual 102	com/squareup/okhttp/internal/framed/FramedConnection:writeData	(IZLokio/Buffer;J)V
    //   201: aload_0
    //   202: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   205: invokestatic 57	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   208: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   211: return
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -25 -> 189
    //   217: astore 5
    //   219: aload_0
    //   220: getfield 35	com/squareup/okhttp/internal/framed/FramedStream$FramedDataSink:this$0	Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   223: invokestatic 57	com/squareup/okhttp/internal/framed/FramedStream:access$1100	(Lcom/squareup/okhttp/internal/framed/FramedStream;)Lcom/squareup/okhttp/internal/framed/FramedStream$StreamTimeout;
    //   226: invokevirtual 75	com/squareup/okhttp/internal/framed/FramedStream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   229: aload 5
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	FramedDataSink
    //   0	232	1	paramBoolean	boolean
    //   170	22	2	i	int
    //   122	76	3	l	long
    //   4	186	5	localObject1	Object
    //   217	13	5	localObject2	Object
    //   65	13	6	localObject3	Object
    //   80	6	6	localObject4	Object
    //   127	5	6	localFramedStream	FramedStream
    // Exception table:
    //   from	to	target	type
    //   19	62	65	finally
    //   9	19	80	finally
    //   67	80	80	finally
    //   82	85	80	finally
    //   88	144	80	finally
    //   154	171	217	finally
    //   175	187	217	finally
    //   189	201	217	finally
  }
  
  public void close()
  {
    assert (!Thread.holdsLock(this.this$0));
    synchronized (this.this$0)
    {
      if (this.closed) {
        return;
      }
      if (this.this$0.sink.finished) {
        break label113;
      }
      if (this.sendBuffer.size() > 0L)
      {
        if (this.sendBuffer.size() <= 0L) {
          break label113;
        }
        emitDataFrame(true);
      }
    }
    FramedStream.access$500(this.this$0).writeData(FramedStream.access$600(this.this$0), true, null, 0L);
    label113:
    synchronized (this.this$0)
    {
      this.closed = true;
      FramedStream.access$500(this.this$0).flush();
      FramedStream.access$1000(this.this$0);
      return;
    }
  }
  
  public void flush()
  {
    assert (!Thread.holdsLock(this.this$0));
    synchronized (this.this$0)
    {
      FramedStream.access$1200(this.this$0);
      if (this.sendBuffer.size() > 0L)
      {
        emitDataFrame(false);
        FramedStream.access$500(this.this$0).flush();
      }
    }
  }
  
  public Timeout timeout()
  {
    return FramedStream.access$1100(this.this$0);
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    assert (!Thread.holdsLock(this.this$0));
    this.sendBuffer.write(paramBuffer, paramLong);
    while (this.sendBuffer.size() >= 16384L) {
      emitDataFrame(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedStream.FramedDataSink
 * JD-Core Version:    0.7.0.1
 */