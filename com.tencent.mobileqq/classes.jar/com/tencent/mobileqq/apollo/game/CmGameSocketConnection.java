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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private CmGameSocketConnection.ConnectionHandler jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler;
  private CmGameSocketConnection.ReadRunnable jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ReadRunnable;
  private MsfSocketInputBuffer jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer = null;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private WeakReference<CmGameSocketConnection.CmGameSocketConnectionListener> jdField_a_of_type_JavaLangRefWeakReference;
  private Socket jdField_a_of_type_JavaNetSocket;
  private List<String> jdField_a_of_type_JavaUtilList;
  private ConcurrentLinkedQueue<byte[]> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_b_of_type_Int = 0;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private int c;
  private int d;
  
  public CmGameSocketConnection(CmGameSocketConnection.ConnectionParam paramConnectionParam)
  {
    a(paramConnectionParam);
    this.d = 32768;
  }
  
  private boolean b()
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
    return (localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty());
  }
  
  private boolean c()
  {
    QLog.d("[cmshow]CmGameConnection", 1, "[connect]");
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        QLog.e("[cmshow]CmGameConnection", 1, "[connect] already running");
        return false;
      }
      long l1 = SystemClock.uptimeMillis();
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int i = 14;
      int j = 0;
      boolean bool1 = false;
      boolean bool2;
      for (;;)
      {
        bool2 = bool1;
        if (j >= k) {
          break;
        }
        localObject = (String)this.jdField_a_of_type_JavaUtilList.get(j);
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmGameConnection", 2, new Object[] { "[connect] host=", localObject, ", port=", Integer.valueOf(this.jdField_a_of_type_Int) });
          }
          this.jdField_a_of_type_JavaNetSocket = new Socket();
          this.jdField_a_of_type_JavaNetSocket.setKeepAlive(true);
          this.jdField_a_of_type_JavaNetSocket.setTcpNoDelay(true);
          this.jdField_a_of_type_JavaNetSocket.setSoTimeout(this.c);
          this.jdField_a_of_type_JavaNetSocket.setSendBufferSize(524288);
          long l2 = SystemClock.uptimeMillis();
          localObject = new InetSocketAddress((String)localObject, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaNetSocket.connect((SocketAddress)localObject, this.jdField_b_of_type_Int);
          QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[connect] cost time=", Long.valueOf(SystemClock.uptimeMillis() - l2), "ms" });
          this.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
          this.jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer = new MsfSocketInputBuffer(this.jdField_a_of_type_JavaNetSocket, this.d, "US-ASCII", -1);
          this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ReadRunnable = new CmGameSocketConnection.ReadRunnable(this);
          this.jdField_b_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("CmGame_Socket_Reader", 0);
          this.jdField_b_of_type_AndroidOsHandlerThread.start();
          this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ReadRunnable);
          try
          {
            this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
            i = 0;
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
          i = 3;
          break;
          if (str.indexOf("illegal") > -1)
          {
            i = 1;
            break;
          }
          if (str.indexOf("route to host") > -1)
          {
            i = 2;
            break;
          }
        } while (str.indexOf("unreachable") > -1);
        if (str.indexOf("permission") > -1)
        {
          i = 4;
        }
        else if (str.indexOf("refused") > -1)
        {
          i = 5;
        }
        else if (str.indexOf("reset") > -1)
        {
          i = 6;
        }
        else
        {
          if ((str.indexOf("timeoutexception") <= -1) && (str.indexOf(") after") <= -1))
          {
            if (str.indexOf("unknownhost") > -1)
            {
              i = 8;
              break label699;
            }
            if (str.indexOf("unresolved") > -1)
            {
              i = 9;
              break label699;
            }
            if (str.indexOf("enotsock") > -1)
            {
              i = 10;
              break label699;
            }
            if (str.indexOf("enobufs") > -1)
            {
              i = 11;
              break label699;
            }
            if (str.indexOf("ebadf") > -1)
            {
              i = 12;
              break label699;
            }
            if (str.indexOf("operation") <= -1)
            {
              if (str.indexOf("invalid") > -1)
              {
                i = 13;
                break label699;
              }
              i = 14;
              break label699;
            }
          }
          i = 7;
        }
        label699:
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameConnection", 2, new Object[] { "[connect] index=", Integer.valueOf(j), ", success=", Boolean.valueOf(bool1) });
        }
        if (bool1)
        {
          bool2 = bool1;
          break;
        }
        j += 1;
      }
      QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[connect] isSuccess=", Boolean.valueOf(bool2), ", failCode=", Integer.valueOf(i), ", duration=", Long.valueOf(SystemClock.uptimeMillis() - l1), "ms" });
      return bool2;
    }
    QLog.e("[cmshow]CmGameConnection", 1, "[connect] empty host");
    return false;
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 88	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: istore_1
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore 5
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_1
    //   17: ifne +14 -> 31
    //   20: ldc 70
    //   22: iconst_1
    //   23: ldc_w 299
    //   26: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: iconst_0
    //   30: ireturn
    //   31: iload 4
    //   33: istore_1
    //   34: iload 5
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 45	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   41: invokevirtual 63	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
    //   44: ifne +118 -> 162
    //   47: iload 4
    //   49: istore_1
    //   50: aload_0
    //   51: getfield 45	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   54: invokevirtual 303	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   57: checkcast 305	[B
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
    //   77: getfield 166	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   80: ifnull +82 -> 162
    //   83: iload 4
    //   85: istore_1
    //   86: aload_0
    //   87: getfield 166	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   90: astore 7
    //   92: iload 4
    //   94: istore_1
    //   95: aload 7
    //   97: monitorenter
    //   98: iload_3
    //   99: istore_2
    //   100: aload_0
    //   101: getfield 166	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   104: aload 6
    //   106: invokevirtual 311	java/io/OutputStream:write	([B)V
    //   109: iload_3
    //   110: istore_2
    //   111: aload_0
    //   112: getfield 166	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   115: invokevirtual 314	java/io/OutputStream:flush	()V
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
    //   144: ldc 70
    //   146: iconst_1
    //   147: ldc_w 316
    //   150: aload 6
    //   152: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_0
    //   156: iconst_1
    //   157: invokevirtual 321	com/tencent/mobileqq/apollo/game/CmGameSocketConnection:a	(Z)V
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
  
  private boolean e()
  {
    boolean bool2 = true;
    QLog.d("[cmshow]CmGameConnection", 1, "[heartbeat] heartbeat");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.d("[cmshow]CmGameConnection", 1, "[heartbeat] not connected");
      return false;
    }
    bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        ??? = (CmGameSocketConnection.CmGameSocketConnectionListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        bool1 = bool2;
        if (??? != null)
        {
          byte[] arrayOfByte = ((CmGameSocketConnection.CmGameSocketConnectionListener)???).a();
          bool1 = bool2;
          if (arrayOfByte != null)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_JavaIoOutputStream != null) {
              synchronized (this.jdField_a_of_type_JavaIoOutputStream)
              {
                this.jdField_a_of_type_JavaIoOutputStream.write(arrayOfByte);
                this.jdField_a_of_type_JavaIoOutputStream.flush();
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
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameConnection", 2, "[clearLastestConnection]");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.w("[cmshow]CmGameConnection", 1, "[clearLastestConnection] not connected now");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaIoOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        this.jdField_a_of_type_JavaIoOutputStream = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaNetSocket != null)
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        this.jdField_a_of_type_JavaNetSocket = null;
      }
      this.jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("[cmshow]CmGameConnection", 1, "[clearLastestConnection] exception=", localException);
    }
  }
  
  public void a()
  {
    try
    {
      QLog.d("[cmshow]CmGameConnection", 1, "open");
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        QLog.w("[cmshow]CmGameConnection", 1, "[open] failed, already connected");
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("CmGame_Socket_Sender", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler = new CmGameSocketConnection.ConnectionHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler.sendEmptyMessage(1);
      return;
    }
    finally {}
  }
  
  public void a(CmGameSocketConnection.CmGameSocketConnectionListener paramCmGameSocketConnectionListener)
  {
    if (paramCmGameSocketConnectionListener == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameSocketConnectionListener);
  }
  
  public void a(CmGameSocketConnection.ConnectionParam paramConnectionParam)
  {
    this.jdField_a_of_type_JavaUtilList = paramConnectionParam.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Int = paramConnectionParam.jdField_a_of_type_Int;
    this.c = paramConnectionParam.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = paramConnectionParam.c;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      QLog.d("[cmshow]CmGameConnection", 1, new Object[] { "[disconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", conn duration=", Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), "ms" });
      f();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        CmGameSocketConnection.CmGameSocketConnectionListener localCmGameSocketConnectionListener = (CmGameSocketConnection.CmGameSocketConnectionListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localCmGameSocketConnectionListener != null) {
          localCmGameSocketConnectionListener.a(paramBoolean);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    QLog.d("[cmshow]CmGameConnection", 1, "wakeup");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.w("[cmshow]CmGameConnection", 1, "[wakeup] failed, not connected");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler.sendEmptyMessage(2);
  }
  
  public void c()
  {
    QLog.d("[cmshow]CmGameConnection", 1, "[notifyConnSuccess]");
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ConnectionHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_JavaIoOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        this.jdField_a_of_type_JavaIoOutputStream = null;
      }
      if (this.jdField_b_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_b_of_type_AndroidOsHandlerThread.quit();
        this.jdField_b_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_JavaNetSocket != null)
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        this.jdField_a_of_type_JavaNetSocket = null;
      }
      this.jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection$ReadRunnable = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("[cmshow]CmGameConnection", 1, "[destoryInner] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameSocketConnection
 * JD-Core Version:    0.7.0.1
 */