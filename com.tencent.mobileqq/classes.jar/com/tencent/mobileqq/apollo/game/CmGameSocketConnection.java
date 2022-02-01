package com.tencent.mobileqq.apollo.game;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CmGameSocketConnection
{
  private List<String> a;
  private int b;
  private AtomicBoolean c = new AtomicBoolean(false);
  private HandlerThread d;
  private CmGameSocketConnection.ConnectionHandler e;
  private CmGameSocketConnection.ReadRunnable f;
  private HandlerThread g;
  private Handler h;
  private Socket i;
  private OutputStream j;
  private MsfSocketInputBuffer k = null;
  private int l = 0;
  private int m;
  private int n;
  private long o;
  private ConcurrentLinkedQueue<byte[]> p = new ConcurrentLinkedQueue();
  private WeakReference<CmGameSocketConnection.CmGameSocketConnectionListener> q;
  
  public CmGameSocketConnection(CmGameSocketConnection.ConnectionParam paramConnectionParam)
  {
    a(paramConnectionParam);
    this.n = 32768;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameConnection", 2, "[clearLastestConnection]");
    }
    if (!this.c.get())
    {
      QLog.w("[cmshow]CmGameConnection", 1, "[clearLastestConnection] not connected now");
      return;
    }
    this.c.set(false);
    try
    {
      if (this.e != null) {
        this.e.removeCallbacksAndMessages(null);
      }
      if (this.j != null)
      {
        this.j.close();
        this.j = null;
      }
      if (this.h != null) {
        this.h.removeCallbacksAndMessages(null);
      }
      if (this.i != null)
      {
        this.i.close();
        this.i = null;
      }
      this.k = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("[cmshow]CmGameConnection", 1, "[clearLastestConnection] exception=", localException);
    }
  }
  
  private boolean g()
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.p;
    return (localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty());
  }
  
  private boolean h()
  {
    QLog.d("[cmshow]CmGameConnection", 1, "[connect]");
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (this.c.get())
      {
        QLog.e("[cmshow]CmGameConnection", 1, "[connect] already running");
        return false;
      }
      long l1 = SystemClock.uptimeMillis();
      int i3 = this.a.size();
      int i1 = 14;
      int i2 = 0;
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        bool2 = bool1;
        if (i2 >= i3) {
          break;
        }
        localObject = (String)this.a.get(i2);
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmGameConnection", 2, new Object[] { "[connect] host=", localObject, ", port=", Integer.valueOf(this.b) });
          }
          this.i = new Socket();
          this.i.setKeepAlive(true);
          this.i.setTcpNoDelay(true);
          this.i.setSoTimeout(this.m);
          this.i.setSendBufferSize(524288);
          long l2 = SystemClock.uptimeMillis();
          localObject = new InetSocketAddress((String)localObject, this.b);
          this.i.connect((SocketAddress)localObject, this.l);
          QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[connect] cost time=", Long.valueOf(SystemClock.uptimeMillis() - l2), "ms" });
          this.j = this.i.getOutputStream();
          this.k = new MsfSocketInputBuffer(this.i, this.n, "US-ASCII", -1);
          this.f = new CmGameSocketConnection.ReadRunnable(this);
          this.g = ThreadManager.newFreeHandlerThread("CmGame_Socket_Reader", 0);
          this.g.start();
          this.h = new Handler(this.g.getLooper());
          this.c.set(true);
          this.h.post(this.f);
          try
          {
            this.o = SystemClock.uptimeMillis();
            i1 = 0;
            bool1 = true;
          }
          catch (Throwable localThrowable1)
          {
            bool1 = true;
          }
          bool2 = NetworkUtil.isNetSupportHw(BaseApplicationImpl.getApplication().getApplicationContext());
        }
        catch (Throwable localThrowable2) {}
        QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[connect] hasNet=", Boolean.valueOf(bool2), ", exception=", localThrowable2 });
        String str = localThrowable2.toString().toLowerCase();
        if (!bool2) {}
        do
        {
          i1 = 3;
          break;
          if (str.indexOf("illegal") > -1)
          {
            i1 = 1;
            break;
          }
          if (str.indexOf("route to host") > -1)
          {
            i1 = 2;
            break;
          }
        } while (str.indexOf("unreachable") > -1);
        if (str.indexOf("permission") > -1)
        {
          i1 = 4;
        }
        else if (str.indexOf("refused") > -1)
        {
          i1 = 5;
        }
        else if (str.indexOf("reset") > -1)
        {
          i1 = 6;
        }
        else
        {
          if ((str.indexOf("timeoutexception") <= -1) && (str.indexOf(") after") <= -1))
          {
            if (str.indexOf("unknownhost") > -1)
            {
              i1 = 8;
              break label703;
            }
            if (str.indexOf("unresolved") > -1)
            {
              i1 = 9;
              break label703;
            }
            if (str.indexOf("enotsock") > -1)
            {
              i1 = 10;
              break label703;
            }
            if (str.indexOf("enobufs") > -1)
            {
              i1 = 11;
              break label703;
            }
            if (str.indexOf("ebadf") > -1)
            {
              i1 = 12;
              break label703;
            }
            if (str.indexOf("operation") <= -1)
            {
              if (str.indexOf("invalid") > -1)
              {
                i1 = 13;
                break label703;
              }
              i1 = 14;
              break label703;
            }
          }
          i1 = 7;
        }
        label703:
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameConnection", 2, new Object[] { "[connect] index=", Integer.valueOf(i2), ", success=", Boolean.valueOf(bool1) });
        }
        if (bool1)
        {
          bool2 = bool1;
          break;
        }
        i2 += 1;
      }
      QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[connect] isSuccess=", Boolean.valueOf(bool2), ", failCode=", Integer.valueOf(i1), ", duration=", Long.valueOf(SystemClock.uptimeMillis() - l1), "ms" });
      return bool2;
    }
    QLog.e("[cmshow]CmGameConnection", 1, "[connect] empty host");
    return false;
  }
  
  /* Error */
  private boolean i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: istore_1
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore 5
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_1
    //   17: ifne +14 -> 31
    //   20: ldc 85
    //   22: iconst_1
    //   23: ldc_w 340
    //   26: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: iconst_0
    //   30: ireturn
    //   31: iload 4
    //   33: istore_1
    //   34: iload 5
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 58	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:p	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   41: invokevirtual 137	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
    //   44: ifne +118 -> 162
    //   47: iload 4
    //   49: istore_1
    //   50: aload_0
    //   51: getfield 58	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:p	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   54: invokevirtual 344	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   57: checkcast 346	[B
    //   60: astore 6
    //   62: iload 5
    //   64: istore_2
    //   65: aload 6
    //   67: ifnull +95 -> 162
    //   70: iload 4
    //   72: istore_1
    //   73: iload 5
    //   75: istore_2
    //   76: aload_0
    //   77: getfield 111	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:j	Ljava/io/OutputStream;
    //   80: ifnull +82 -> 162
    //   83: iload 4
    //   85: istore_1
    //   86: aload_0
    //   87: getfield 111	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:j	Ljava/io/OutputStream;
    //   90: astore 7
    //   92: iload 4
    //   94: istore_1
    //   95: aload 7
    //   97: monitorenter
    //   98: iload_3
    //   99: istore_2
    //   100: aload_0
    //   101: getfield 111	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:j	Ljava/io/OutputStream;
    //   104: aload 6
    //   106: invokevirtual 350	java/io/OutputStream:write	([B)V
    //   109: iload_3
    //   110: istore_2
    //   111: aload_0
    //   112: getfield 111	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:j	Ljava/io/OutputStream;
    //   115: invokevirtual 353	java/io/OutputStream:flush	()V
    //   118: aload 7
    //   120: monitorexit
    //   121: iconst_1
    //   122: ireturn
    //   123: astore 6
    //   125: iconst_1
    //   126: istore_1
    //   127: goto +7 -> 134
    //   130: astore 6
    //   132: iload_2
    //   133: istore_1
    //   134: iload_1
    //   135: istore_2
    //   136: aload 7
    //   138: monitorexit
    //   139: aload 6
    //   141: athrow
    //   142: astore 6
    //   144: ldc 85
    //   146: iconst_1
    //   147: ldc_w 355
    //   150: aload 6
    //   152: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_0
    //   156: iconst_1
    //   157: invokevirtual 359	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:a	(Z)V
    //   160: iload_1
    //   161: istore_2
    //   162: iload_2
    //   163: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	CmGameSocketConnection
    //   7	154	1	bool1	boolean
    //   36	127	2	bool2	boolean
    //   15	95	3	bool3	boolean
    //   9	84	4	bool4	boolean
    //   12	62	5	bool5	boolean
    //   60	45	6	arrayOfByte	byte[]
    //   123	1	6	localObject1	Object
    //   130	10	6	localObject2	Object
    //   142	9	6	localException	Exception
    //   90	47	7	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   118	121	123	finally
    //   100	109	130	finally
    //   111	118	130	finally
    //   136	139	130	finally
    //   37	47	142	java/lang/Exception
    //   50	62	142	java/lang/Exception
    //   76	83	142	java/lang/Exception
    //   86	92	142	java/lang/Exception
    //   95	98	142	java/lang/Exception
    //   139	142	142	java/lang/Exception
  }
  
  private boolean j()
  {
    boolean bool2 = true;
    QLog.d("[cmshow]CmGameConnection", 1, "[heartbeat] heartbeat");
    if (!this.c.get())
    {
      QLog.d("[cmshow]CmGameConnection", 1, "[heartbeat] not connected");
      return false;
    }
    bool1 = bool2;
    try
    {
      if (this.q != null)
      {
        ??? = (CmGameSocketConnection.CmGameSocketConnectionListener)this.q.get();
        bool1 = bool2;
        if (??? != null)
        {
          byte[] arrayOfByte = ((CmGameSocketConnection.CmGameSocketConnectionListener)???).e();
          bool1 = bool2;
          if (arrayOfByte != null)
          {
            bool1 = bool2;
            if (this.j != null) {
              synchronized (this.j)
              {
                this.j.write(arrayOfByte);
                this.j.flush();
                return true;
              }
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]CmGameConnection", 1, "[heartbeat] exception=", localException);
      bool1 = false;
    }
  }
  
  public void a()
  {
    try
    {
      QLog.d("[cmshow]CmGameConnection", 1, "open");
      if (this.c.get())
      {
        QLog.w("[cmshow]CmGameConnection", 1, "[open] failed, already connected");
        return;
      }
      if (this.d == null)
      {
        this.d = ThreadManager.newFreeHandlerThread("CmGame_Socket_Sender", 0);
        this.d.start();
      }
      if (this.e == null) {
        this.e = new CmGameSocketConnection.ConnectionHandler(this.d.getLooper(), this);
      }
      this.e.sendEmptyMessage(1);
      return;
    }
    finally {}
  }
  
  public void a(CmGameSocketConnection.CmGameSocketConnectionListener paramCmGameSocketConnectionListener)
  {
    if (paramCmGameSocketConnectionListener == null) {
      return;
    }
    this.q = new WeakReference(paramCmGameSocketConnectionListener);
  }
  
  public void a(CmGameSocketConnection.ConnectionParam paramConnectionParam)
  {
    this.a = paramConnectionParam.a;
    this.b = paramConnectionParam.b;
    this.m = paramConnectionParam.c;
    this.l = paramConnectionParam.d;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[disconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", conn duration=", Long.valueOf(SystemClock.uptimeMillis() - this.o), "ms" });
      f();
      if (this.q != null)
      {
        CmGameSocketConnection.CmGameSocketConnectionListener localCmGameSocketConnectionListener = (CmGameSocketConnection.CmGameSocketConnectionListener)this.q.get();
        if (localCmGameSocketConnectionListener != null) {
          localCmGameSocketConnectionListener.a(paramBoolean);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.c.get();
  }
  
  public void c()
  {
    QLog.d("[cmshow]CmGameConnection", 1, "[notifyConnSuccess]");
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = (CmGameSocketConnection.CmGameSocketConnectionListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((CmGameSocketConnection.CmGameSocketConnectionListener)localObject).c();
      }
    }
  }
  
  public void d()
  {
    f();
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = (CmGameSocketConnection.CmGameSocketConnectionListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((CmGameSocketConnection.CmGameSocketConnectionListener)localObject).d();
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameConnection", 2, "[destroy]");
    }
    try
    {
      this.c.set(false);
      if (this.e != null) {
        this.e.removeCallbacksAndMessages(null);
      }
      if (this.d != null)
      {
        this.d.quit();
        this.d = null;
      }
      if (this.j != null)
      {
        this.j.close();
        this.j = null;
      }
      if (this.g != null)
      {
        this.g.quit();
        this.g = null;
      }
      if (this.h != null)
      {
        this.h.removeCallbacksAndMessages(null);
        this.h = null;
      }
      if (this.i != null)
      {
        this.i.close();
        this.i = null;
      }
      this.k = null;
      this.f = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("[cmshow]CmGameConnection", 1, "[destoryInner] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameSocketConnection
 * JD-Core Version:    0.7.0.1
 */