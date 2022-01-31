package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okio.BufferedSource;
import okio.ByteString;

class FramedConnection$Reader
  extends NamedRunnable
  implements FrameReader.Handler
{
  final FrameReader frameReader;
  
  private FramedConnection$Reader(FramedConnection paramFramedConnection, FrameReader paramFrameReader)
  {
    super("OkHttp %s", new Object[] { FramedConnection.access$1100(paramFramedConnection) });
    this.frameReader = paramFrameReader;
  }
  
  private void ackSettingsLater(Settings paramSettings)
  {
    FramedConnection.access$2100().execute(new FramedConnection.Reader.3(this, "OkHttp %s ACK Settings", new Object[] { FramedConnection.access$1100(this.this$0) }, paramSettings));
  }
  
  public void ackSettings() {}
  
  public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
  
  public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
  {
    if (FramedConnection.access$1300(this.this$0, paramInt1)) {
      FramedConnection.access$1400(this.this$0, paramInt1, paramBufferedSource, paramInt2, paramBoolean);
    }
    FramedStream localFramedStream;
    do
    {
      return;
      localFramedStream = this.this$0.getStream(paramInt1);
      if (localFramedStream == null)
      {
        this.this$0.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
        paramBufferedSource.skip(paramInt2);
        return;
      }
      localFramedStream.receiveData(paramBufferedSource, paramInt2);
    } while (!paramBoolean);
    localFramedStream.receiveFin();
  }
  
  /* Error */
  public void execute()
  {
    // Byte code:
    //   0: getstatic 100	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   3: astore_3
    //   4: getstatic 100	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   7: astore 4
    //   9: aload_3
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 14	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   17: getfield 104	com/squareup/okhttp/internal/framed/FramedConnection:client	Z
    //   20: ifne +16 -> 36
    //   23: aload_3
    //   24: astore_2
    //   25: aload_3
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 29	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   31: invokeinterface 109 1 0
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 29	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   44: aload_0
    //   45: invokeinterface 113 2 0
    //   50: ifne -14 -> 36
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: astore_1
    //   57: getstatic 116	com/squareup/okhttp/internal/framed/ErrorCode:NO_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: astore_1
    //   65: getstatic 119	com/squareup/okhttp/internal/framed/ErrorCode:CANCEL	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 14	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   74: aload_3
    //   75: aload 5
    //   77: invokestatic 123	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   80: aload_0
    //   81: getfield 29	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   84: invokestatic 129	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   87: return
    //   88: astore_1
    //   89: aload_2
    //   90: astore_1
    //   91: getstatic 132	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   94: astore_3
    //   95: getstatic 132	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 14	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   103: aload_3
    //   104: aload_1
    //   105: invokestatic 123	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   108: aload_0
    //   109: getfield 29	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   112: invokestatic 129	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   115: return
    //   116: astore_2
    //   117: aload_1
    //   118: astore_3
    //   119: aload_2
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 14	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   125: aload_3
    //   126: aload 4
    //   128: invokestatic 123	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   131: aload_0
    //   132: getfield 29	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   135: invokestatic 129	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: goto -10 -> 131
    //   144: astore_1
    //   145: goto -24 -> 121
    //   148: astore_1
    //   149: goto -41 -> 108
    //   152: astore_1
    //   153: goto -73 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	Reader
    //   12	53	1	localObject1	Object
    //   88	1	1	localIOException1	java.io.IOException
    //   90	49	1	localObject2	Object
    //   144	1	1	localObject3	Object
    //   148	1	1	localIOException2	java.io.IOException
    //   152	1	1	localIOException3	java.io.IOException
    //   10	80	2	localObject4	Object
    //   116	4	2	localObject5	Object
    //   140	1	2	localIOException4	java.io.IOException
    //   3	123	3	localObject6	Object
    //   7	120	4	localErrorCode1	ErrorCode
    //   68	8	5	localErrorCode2	ErrorCode
    // Exception table:
    //   from	to	target	type
    //   13	23	88	java/io/IOException
    //   27	36	88	java/io/IOException
    //   40	53	88	java/io/IOException
    //   57	61	88	java/io/IOException
    //   65	70	88	java/io/IOException
    //   13	23	116	finally
    //   27	36	116	finally
    //   40	53	116	finally
    //   57	61	116	finally
    //   65	70	116	finally
    //   91	95	116	finally
    //   121	131	140	java/io/IOException
    //   95	99	144	finally
    //   99	108	148	java/io/IOException
    //   70	80	152	java/io/IOException
  }
  
  public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
  {
    if (paramByteString.size() > 0) {}
    synchronized (this.this$0)
    {
      paramByteString = (FramedStream[])FramedConnection.access$1900(this.this$0).values().toArray(new FramedStream[FramedConnection.access$1900(this.this$0).size()]);
      FramedConnection.access$1602(this.this$0, true);
      int j = paramByteString.length;
      int i = 0;
      if (i < j)
      {
        ??? = paramByteString[i];
        if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
        {
          ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
          this.this$0.removeStream(???.getId());
        }
        i += 1;
      }
    }
  }
  
  public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList, HeadersMode paramHeadersMode)
  {
    if (FramedConnection.access$1300(this.this$0, paramInt1)) {
      FramedConnection.access$1500(this.this$0, paramInt1, paramList, paramBoolean2);
    }
    FramedStream localFramedStream;
    do
    {
      return;
      synchronized (this.this$0)
      {
        if (FramedConnection.access$1600(this.this$0)) {
          return;
        }
      }
      localFramedStream = this.this$0.getStream(paramInt1);
      if (localFramedStream == null)
      {
        if (paramHeadersMode.failIfStreamAbsent())
        {
          this.this$0.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
          return;
        }
        if (paramInt1 <= FramedConnection.access$1700(this.this$0)) {
          return;
        }
        if (paramInt1 % 2 == FramedConnection.access$1800(this.this$0) % 2) {
          return;
        }
        paramList = new FramedStream(paramInt1, this.this$0, paramBoolean1, paramBoolean2, paramList);
        FramedConnection.access$1702(this.this$0, paramInt1);
        FramedConnection.access$1900(this.this$0).put(Integer.valueOf(paramInt1), paramList);
        FramedConnection.access$2100().execute(new FramedConnection.Reader.1(this, "OkHttp %s stream %d", new Object[] { FramedConnection.access$1100(this.this$0), Integer.valueOf(paramInt1) }, paramList));
        return;
      }
      if (paramHeadersMode.failIfStreamPresent())
      {
        localFramedStream.closeLater(ErrorCode.PROTOCOL_ERROR);
        this.this$0.removeStream(paramInt1);
        return;
      }
      localFramedStream.receiveHeaders(paramList, paramHeadersMode);
    } while (!paramBoolean2);
    localFramedStream.receiveFin();
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Ping localPing = FramedConnection.access$2400(this.this$0, paramInt1);
      if (localPing != null) {
        localPing.receive();
      }
      return;
    }
    FramedConnection.access$2500(this.this$0, true, paramInt1, paramInt2, null);
  }
  
  public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
  {
    FramedConnection.access$2600(this.this$0, paramInt2, paramList);
  }
  
  public void rstStream(int paramInt, ErrorCode paramErrorCode)
  {
    if (FramedConnection.access$1300(this.this$0, paramInt)) {
      FramedConnection.access$2200(this.this$0, paramInt, paramErrorCode);
    }
    FramedStream localFramedStream;
    do
    {
      return;
      localFramedStream = this.this$0.removeStream(paramInt);
    } while (localFramedStream == null);
    localFramedStream.receiveRstStream(paramErrorCode);
  }
  
  public void settings(boolean paramBoolean, Settings paramSettings)
  {
    for (;;)
    {
      int i;
      synchronized (this.this$0)
      {
        i = this.this$0.peerSettings.getInitialWindowSize(65536);
        if (paramBoolean) {
          this.this$0.peerSettings.clear();
        }
        this.this$0.peerSettings.merge(paramSettings);
        if (this.this$0.getProtocol() == Protocol.HTTP_2) {
          ackSettingsLater(paramSettings);
        }
        int j = this.this$0.peerSettings.getInitialWindowSize(65536);
        if ((j == -1) || (j == i)) {
          break label281;
        }
        l = j - i;
        if (!FramedConnection.access$2300(this.this$0))
        {
          this.this$0.addBytesToWriteWindow(l);
          FramedConnection.access$2302(this.this$0, true);
        }
        if (FramedConnection.access$1900(this.this$0).isEmpty()) {
          break label276;
        }
        paramSettings = (FramedStream[])FramedConnection.access$1900(this.this$0).values().toArray(new FramedStream[FramedConnection.access$1900(this.this$0).size()]);
        FramedConnection.access$2100().execute(new FramedConnection.Reader.2(this, "OkHttp %s settings", new Object[] { FramedConnection.access$1100(this.this$0) }));
        if ((paramSettings == null) || (l == 0L)) {
          break label275;
        }
        j = paramSettings.length;
        i = 0;
        if (i >= j) {
          break label275;
        }
      }
      synchronized (paramSettings[i])
      {
        ???.addBytesToWriteWindow(l);
        i += 1;
        continue;
        paramSettings = finally;
        throw paramSettings;
      }
      label275:
      return;
      label276:
      paramSettings = null;
      continue;
      label281:
      paramSettings = null;
      long l = 0L;
    }
  }
  
  public void windowUpdate(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      synchronized (this.this$0)
      {
        FramedConnection localFramedConnection = this.this$0;
        localFramedConnection.bytesLeftInWriteWindow += paramLong;
        this.this$0.notifyAll();
        return;
      }
    }
    ??? = this.this$0.getStream(paramInt);
    if (??? != null) {
      try
      {
        ((FramedStream)???).addBytesToWriteWindow(paramLong);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader
 * JD-Core Version:    0.7.0.1
 */