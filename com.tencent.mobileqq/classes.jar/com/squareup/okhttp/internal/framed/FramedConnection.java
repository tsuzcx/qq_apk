package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

public final class FramedConnection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService executor;
  long bytesLeftInWriteWindow;
  final boolean client;
  private final Set<Integer> currentPushRequests = new LinkedHashSet();
  final FrameWriter frameWriter;
  private final String hostName;
  private long idleStartTimeNs = System.nanoTime();
  private int lastGoodStreamId;
  private final FramedConnection.Listener listener;
  private int nextPingId;
  private int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private Map<Integer, Ping> pings;
  final Protocol protocol;
  private final ExecutorService pushExecutor;
  private final PushObserver pushObserver;
  final FramedConnection.Reader readerRunnable;
  private boolean receivedInitialPeerSettings = false;
  private boolean shutdown;
  final Socket socket;
  private final Map<Integer, FramedStream> streams = new HashMap();
  long unacknowledgedBytesRead = 0L;
  final Variant variant;
  
  static
  {
    if (!FramedConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
      return;
    }
  }
  
  private FramedConnection(FramedConnection.Builder paramBuilder)
  {
    this.protocol = FramedConnection.Builder.access$000(paramBuilder);
    this.pushObserver = FramedConnection.Builder.access$100(paramBuilder);
    this.client = FramedConnection.Builder.access$200(paramBuilder);
    this.listener = FramedConnection.Builder.access$300(paramBuilder);
    int i;
    if (FramedConnection.Builder.access$200(paramBuilder))
    {
      i = 1;
      this.nextStreamId = i;
      if ((FramedConnection.Builder.access$200(paramBuilder)) && (this.protocol == Protocol.HTTP_2)) {
        this.nextStreamId += 2;
      }
      i = j;
      if (FramedConnection.Builder.access$200(paramBuilder)) {
        i = 1;
      }
      this.nextPingId = i;
      if (FramedConnection.Builder.access$200(paramBuilder)) {
        this.okHttpSettings.set(7, 0, 16777216);
      }
      this.hostName = FramedConnection.Builder.access$400(paramBuilder);
      if (this.protocol != Protocol.HTTP_2) {
        break label370;
      }
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostName }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    }
    for (;;)
    {
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
      this.socket = FramedConnection.Builder.access$500(paramBuilder);
      this.frameWriter = this.variant.newWriter(FramedConnection.Builder.access$600(paramBuilder), this.client);
      this.readerRunnable = new FramedConnection.Reader(this, this.variant.newReader(FramedConnection.Builder.access$700(paramBuilder), this.client), null);
      new Thread(this.readerRunnable).start();
      return;
      i = 2;
      break;
      label370:
      if (this.protocol != Protocol.SPDY_3) {
        break label399;
      }
      this.variant = new Spdy3();
      this.pushExecutor = null;
    }
    label399:
    throw new AssertionError(this.protocol);
  }
  
  /* Error */
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
  {
    // Byte code:
    //   0: getstatic 61	com/squareup/okhttp/internal/framed/FramedConnection:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 333	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 242	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 334	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 337	com/squareup/okhttp/internal/framed/FramedConnection:shutdown	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 98	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   34: invokeinterface 342 1 0
    //   39: ifne +247 -> 286
    //   42: aload_0
    //   43: getfield 98	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   46: invokeinterface 346 1 0
    //   51: aload_0
    //   52: getfield 98	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   55: invokeinterface 350 1 0
    //   60: anewarray 352	com/squareup/okhttp/internal/framed/FramedStream
    //   63: invokeinterface 358 2 0
    //   68: checkcast 360	[Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   71: astore 6
    //   73: aload_0
    //   74: getfield 98	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   77: invokeinterface 363 1 0
    //   82: aload_0
    //   83: iconst_0
    //   84: invokespecial 367	com/squareup/okhttp/internal/framed/FramedConnection:setIdle	(Z)V
    //   87: aload_0
    //   88: getfield 369	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   91: ifnull +189 -> 280
    //   94: aload_0
    //   95: getfield 369	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   98: invokeinterface 346 1 0
    //   103: aload_0
    //   104: getfield 369	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   107: invokeinterface 350 1 0
    //   112: anewarray 371	com/squareup/okhttp/internal/framed/Ping
    //   115: invokeinterface 358 2 0
    //   120: checkcast 373	[Lcom/squareup/okhttp/internal/framed/Ping;
    //   123: astore 7
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 369	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: ifnull +69 -> 206
    //   140: aload 6
    //   142: arraylength
    //   143: istore 4
    //   145: iconst_0
    //   146: istore_3
    //   147: iload_3
    //   148: iload 4
    //   150: if_icmpge +53 -> 203
    //   153: aload 6
    //   155: iload_3
    //   156: aaload
    //   157: astore 5
    //   159: aload 5
    //   161: aload_2
    //   162: invokevirtual 375	com/squareup/okhttp/internal/framed/FramedStream:close	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   165: aload_1
    //   166: astore 5
    //   168: iload_3
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: aload 5
    //   174: astore_1
    //   175: goto -28 -> 147
    //   178: astore_1
    //   179: goto -151 -> 28
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: astore 8
    //   189: aload_1
    //   190: astore 5
    //   192: aload_1
    //   193: ifnull -25 -> 168
    //   196: aload 8
    //   198: astore 5
    //   200: goto -32 -> 168
    //   203: aload_1
    //   204: astore 5
    //   206: aload 7
    //   208: ifnull +30 -> 238
    //   211: aload 7
    //   213: arraylength
    //   214: istore 4
    //   216: iconst_0
    //   217: istore_3
    //   218: iload_3
    //   219: iload 4
    //   221: if_icmpge +17 -> 238
    //   224: aload 7
    //   226: iload_3
    //   227: aaload
    //   228: invokevirtual 378	com/squareup/okhttp/internal/framed/Ping:cancel	()V
    //   231: iload_3
    //   232: iconst_1
    //   233: iadd
    //   234: istore_3
    //   235: goto -17 -> 218
    //   238: aload_0
    //   239: getfield 211	com/squareup/okhttp/internal/framed/FramedConnection:frameWriter	Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   242: invokeinterface 382 1 0
    //   247: aload 5
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 199	com/squareup/okhttp/internal/framed/FramedConnection:socket	Ljava/net/Socket;
    //   254: invokevirtual 385	java/net/Socket:close	()V
    //   257: aload_1
    //   258: ifnull +17 -> 275
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: aload 5
    //   266: ifnull -16 -> 250
    //   269: aload 5
    //   271: astore_1
    //   272: goto -22 -> 250
    //   275: return
    //   276: astore_1
    //   277: goto -20 -> 257
    //   280: aconst_null
    //   281: astore 7
    //   283: goto -153 -> 130
    //   286: aconst_null
    //   287: astore 6
    //   289: goto -202 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	FramedConnection
    //   0	292	1	paramErrorCode1	ErrorCode
    //   0	292	2	paramErrorCode2	ErrorCode
    //   146	89	3	i	int
    //   143	79	4	j	int
    //   133	137	5	localObject	Object
    //   71	217	6	arrayOfFramedStream	FramedStream[]
    //   123	159	7	arrayOfPing	Ping[]
    //   187	10	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   21	26	178	java/io/IOException
    //   30	87	182	finally
    //   87	130	182	finally
    //   130	132	182	finally
    //   183	185	182	finally
    //   159	165	187	java/io/IOException
    //   238	247	263	java/io/IOException
    //   250	257	276	java/io/IOException
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      if (paramBoolean2) {
        break label65;
      }
    }
    label65:
    for (paramBoolean2 = bool2;; paramBoolean2 = false)
    {
      synchronized (this.frameWriter)
      {
        try
        {
          if (!this.shutdown) {
            break label71;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      bool1 = false;
      break;
    }
    label71:
    int i = this.nextStreamId;
    this.nextStreamId += 2;
    FramedStream localFramedStream = new FramedStream(i, this, bool1, paramBoolean2, paramList);
    if (localFramedStream.isOpen())
    {
      this.streams.put(Integer.valueOf(i), localFramedStream);
      setIdle(false);
    }
    if (paramInt == 0) {
      this.frameWriter.synStream(bool1, paramBoolean2, i, paramInt, paramList);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.frameWriter.flush();
      }
      return localFramedStream;
      if (this.client) {
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      }
      this.frameWriter.pushPromise(paramInt, i, paramList);
    }
  }
  
  private void pushDataLater(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
  {
    Buffer localBuffer = new Buffer();
    paramBufferedSource.require(paramInt2);
    paramBufferedSource.read(localBuffer, paramInt2);
    if (localBuffer.size() != paramInt2) {
      throw new IOException(localBuffer.size() + " != " + paramInt2);
    }
    this.pushExecutor.execute(new FramedConnection.6(this, "OkHttp %s Push Data[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt1) }, paramInt1, localBuffer, paramInt2, paramBoolean));
  }
  
  private void pushHeadersLater(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    this.pushExecutor.execute(new FramedConnection.5(this, "OkHttp %s Push Headers[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
  }
  
  private void pushRequestLater(int paramInt, List<Header> paramList)
  {
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      this.pushExecutor.execute(new FramedConnection.4(this, "OkHttp %s Push Request[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramList));
      return;
    }
    finally {}
  }
  
  private void pushResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    this.pushExecutor.execute(new FramedConnection.7(this, "OkHttp %s Push Reset[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  private boolean pushedStream(int paramInt)
  {
    return (this.protocol == Protocol.HTTP_2) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  /* Error */
  private Ping removePing(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 369	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 369	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 515 2 0
    //   22: checkcast 371	com/squareup/okhttp/internal/framed/Ping
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	FramedConnection
    //   0	40	1	paramInt	int
    //   25	7	2	localPing	Ping
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l = System.nanoTime();
        this.idleStartTimeNs = l;
        return;
      }
      finally {}
      long l = 9223372036854775807L;
    }
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
  {
    FrameWriter localFrameWriter = this.frameWriter;
    if (paramPing != null) {}
    try
    {
      paramPing.send();
      this.frameWriter.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  private void writePingLater(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
  {
    executor.execute(new FramedConnection.3(this, "OkHttp %s ping %08x%08x", new Object[] { this.hostName, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, paramBoolean, paramInt1, paramInt2, paramPing));
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close()
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush()
  {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs()
  {
    try
    {
      long l = this.idleStartTimeNs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.streams.get(Integer.valueOf(paramInt));
      return localFramedStream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isIdle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/squareup/okhttp/internal/framed/FramedConnection:idleStartTimeNs	J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 516
    //   11: lcmp
    //   12: ifeq +9 -> 21
    //   15: iconst_1
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -6 -> 17
    //   26: astore 4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 4
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	FramedConnection
    //   6	2	1	l	long
    //   16	7	3	bool	boolean
    //   26	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public int maxConcurrentStreams()
  {
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(2147483647);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Ping ping()
  {
    Ping localPing = new Ping();
    try
    {
      if (this.shutdown) {
        throw new IOException("shutdown");
      }
    }
    finally {}
    int i = this.nextPingId;
    this.nextPingId += 2;
    if (this.pings == null) {
      this.pings = new HashMap();
    }
    this.pings.put(Integer.valueOf(i), localObject);
    writePing(false, i, 1330343787, localObject);
    return localObject;
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    if (this.client) {
      throw new IllegalStateException("Client cannot push requests.");
    }
    if (this.protocol != Protocol.HTTP_2) {
      throw new IllegalStateException("protocol != HTTP_2");
    }
    return newStream(paramInt, paramList, paramBoolean, false);
  }
  
  FramedStream removeStream(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.streams.remove(Integer.valueOf(paramInt));
      if ((localFramedStream != null) && (this.streams.isEmpty())) {
        setIdle(true);
      }
      notifyAll();
      return localFramedStream;
    }
    finally {}
  }
  
  public void sendConnectionPreface()
  {
    this.frameWriter.connectionPreface();
    this.frameWriter.settings(this.okHttpSettings);
    int i = this.okHttpSettings.getInitialWindowSize(65536);
    if (i != 65536) {
      this.frameWriter.windowUpdate(0, i - 65536);
    }
  }
  
  public void setSettings(Settings paramSettings)
  {
    synchronized (this.frameWriter)
    {
      try
      {
        if (this.shutdown) {
          throw new IOException("shutdown");
        }
      }
      finally {}
    }
    this.okHttpSettings.merge(paramSettings);
    this.frameWriter.settings(paramSettings);
  }
  
  public void shutdown(ErrorCode paramErrorCode)
  {
    int i;
    synchronized (this.frameWriter) {}
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.frameWriter.data(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i = Math.min((int)Math.min(l, this.bytesLeftInWriteWindow), this.frameWriter.maxDataLength());
        this.bytesLeftInWriteWindow -= i;
        l -= i;
        FrameWriter localFrameWriter = this.frameWriter;
        if ((!paramBoolean) || (l != 0L)) {
          break label170;
        }
        bool = true;
        localFrameWriter.data(bool, paramInt, paramBuffer, i);
        if (l <= 0L) {
          break;
        }
        try
        {
          if (this.bytesLeftInWriteWindow > 0L) {
            continue;
          }
          if (!this.streams.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramBuffer)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
  {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
  {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    executor.submit(new FramedConnection.1(this, "OkHttp %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  void writeWindowUpdateLater(int paramInt, long paramLong)
  {
    executor.execute(new FramedConnection.2(this, "OkHttp Window Update %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection
 * JD-Core Version:    0.7.0.1
 */