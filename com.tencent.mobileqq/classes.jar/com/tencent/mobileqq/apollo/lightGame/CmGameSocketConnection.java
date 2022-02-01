package com.tencent.mobileqq.apollo.lightGame;

import amuc;
import amud;
import amue;
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
  private amud jdField_a_of_type_Amud;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private CmGameSocketConnection.ReadRunnable jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable;
  private MsfSocketInputBuffer jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private WeakReference<amuc> jdField_a_of_type_JavaLangRefWeakReference;
  private Socket jdField_a_of_type_JavaNetSocket;
  private List<String> jdField_a_of_type_JavaUtilList;
  private ConcurrentLinkedQueue<byte[]> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_b_of_type_Int;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private int c;
  private int d;
  
  public CmGameSocketConnection(amue paramamue)
  {
    a(paramamue);
    this.d = 32768;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty());
  }
  
  private boolean c()
  {
    QLog.d("CmGameConnection", 1, "[connect]");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      QLog.e("CmGameConnection", 1, "[connect] empty host");
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("CmGameConnection", 1, "[connect] already running");
      return false;
    }
    long l1 = SystemClock.uptimeMillis();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int i = 14;
    boolean bool1 = false;
    int j = 0;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      Object localObject;
      if (j < k)
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilList.get(j);
        bool2 = bool1;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("CmGameConnection", 2, new Object[] { "[connect] host=", localObject, ", port=", Integer.valueOf(this.jdField_a_of_type_Int) });
        }
        bool2 = bool1;
        localObject = new InetSocketAddress((String)localObject, this.jdField_a_of_type_Int);
        bool2 = bool1;
        this.jdField_a_of_type_JavaNetSocket = new Socket();
        bool2 = bool1;
        this.jdField_a_of_type_JavaNetSocket.setKeepAlive(true);
        bool2 = bool1;
        this.jdField_a_of_type_JavaNetSocket.setTcpNoDelay(true);
        bool2 = bool1;
        this.jdField_a_of_type_JavaNetSocket.setSoTimeout(this.c);
        bool2 = bool1;
        this.jdField_a_of_type_JavaNetSocket.setSendBufferSize(524288);
        bool2 = bool1;
        long l2 = SystemClock.uptimeMillis();
        bool2 = bool1;
        this.jdField_a_of_type_JavaNetSocket.connect((SocketAddress)localObject, this.jdField_b_of_type_Int);
        bool2 = bool1;
        QLog.d("CmGameConnection", 1, new Object[] { "[connect] cost time=", Long.valueOf(SystemClock.uptimeMillis() - l2), "ms" });
        bool2 = bool1;
        this.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
        bool2 = bool1;
        this.jdField_a_of_type_ComTencentQphoneBaseUtilMsfSocketInputBuffer = new MsfSocketInputBuffer(this.jdField_a_of_type_JavaNetSocket, this.d, "US-ASCII", -1);
        bool2 = bool1;
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable = new CmGameSocketConnection.ReadRunnable(this);
        bool2 = bool1;
        this.jdField_b_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("CmGame_Socket_Reader", 0);
        bool2 = bool1;
        this.jdField_b_of_type_AndroidOsHandlerThread.start();
        bool2 = bool1;
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
        bool2 = bool1;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        bool2 = bool1;
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable);
        bool2 = true;
        bool1 = true;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bool1 = NetworkUtil.isNetSupportHw(BaseApplicationImpl.getApplication().getApplicationContext());
          QLog.d("CmGameConnection", 1, new Object[] { "[connect] hasNet=", Boolean.valueOf(bool1), ", exception=", localThrowable });
          String str = localThrowable.toString().toLowerCase();
          if (!bool1)
          {
            i = 3;
            bool1 = bool2;
          }
          else if (str.indexOf("illegal") > -1)
          {
            i = 1;
            bool1 = bool2;
          }
          else if (str.indexOf("route to host") > -1)
          {
            i = 2;
            bool1 = bool2;
          }
          else if (str.indexOf("unreachable") > -1)
          {
            i = 3;
            bool1 = bool2;
          }
          else if (str.indexOf("permission") > -1)
          {
            i = 4;
            bool1 = bool2;
          }
          else if (str.indexOf("refused") > -1)
          {
            i = 5;
            bool1 = bool2;
          }
          else if (str.indexOf("reset") > -1)
          {
            i = 6;
            bool1 = bool2;
          }
          else if ((str.indexOf("timeoutexception") > -1) || (str.indexOf(") after") > -1))
          {
            i = 7;
            bool1 = bool2;
          }
          else if (str.indexOf("unknownhost") > -1)
          {
            i = 8;
            bool1 = bool2;
          }
          else if (str.indexOf("unresolved") > -1)
          {
            i = 9;
            bool1 = bool2;
          }
          else if (str.indexOf("enotsock") > -1)
          {
            i = 10;
            bool1 = bool2;
          }
          else if (str.indexOf("enobufs") > -1)
          {
            i = 11;
            bool1 = bool2;
          }
          else if (str.indexOf("ebadf") > -1)
          {
            i = 12;
            bool1 = bool2;
          }
          else if (str.indexOf("operation") > -1)
          {
            i = 7;
            bool1 = bool2;
          }
          else if (str.indexOf("invalid") > -1)
          {
            i = 13;
            bool1 = bool2;
          }
          else
          {
            i = 14;
            bool1 = bool2;
          }
        }
        j += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmGameConnection", 2, new Object[] { "[connect] index=", Integer.valueOf(j), ", success=", Boolean.valueOf(bool1) });
      }
      if (bool1)
      {
        bool2 = bool1;
        QLog.d("CmGameConnection", 1, new Object[] { "[connect] isSuccess=", Boolean.valueOf(bool2), ", failCode=", Integer.valueOf(i), ", duration=", Long.valueOf(SystemClock.uptimeMillis() - l1), "ms" });
        return bool2;
      }
    }
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: getfield 36	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 90	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifne +14 -> 25
    //   14: ldc 68
    //   16: iconst_1
    //   17: ldc_w 299
    //   20: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: iconst_0
    //   24: ireturn
    //   25: iload_2
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 41	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   31: invokevirtual 61	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
    //   34: ifne +111 -> 145
    //   37: iload_2
    //   38: istore_1
    //   39: aload_0
    //   40: getfield 41	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   43: invokevirtual 303	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   46: checkcast 305	[B
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +92 -> 145
    //   56: iload_2
    //   57: istore_1
    //   58: aload_0
    //   59: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   62: ifnull +83 -> 145
    //   65: iload_2
    //   66: istore_1
    //   67: aload_0
    //   68: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   71: astore 5
    //   73: iload_2
    //   74: istore_1
    //   75: aload 5
    //   77: monitorenter
    //   78: iload_3
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   84: aload 4
    //   86: invokevirtual 311	java/io/OutputStream:write	([B)V
    //   89: iload_3
    //   90: istore_2
    //   91: aload_0
    //   92: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   95: invokevirtual 314	java/io/OutputStream:flush	()V
    //   98: aload 5
    //   100: monitorexit
    //   101: iconst_1
    //   102: istore_1
    //   103: iload_1
    //   104: ireturn
    //   105: astore 4
    //   107: iload_2
    //   108: istore_1
    //   109: iload_1
    //   110: istore_2
    //   111: aload 5
    //   113: monitorexit
    //   114: aload 4
    //   116: athrow
    //   117: astore 4
    //   119: ldc 68
    //   121: iconst_1
    //   122: ldc_w 316
    //   125: aload 4
    //   127: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_0
    //   131: iconst_1
    //   132: invokevirtual 321	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:a	(Z)V
    //   135: goto -32 -> 103
    //   138: astore 4
    //   140: iconst_1
    //   141: istore_1
    //   142: goto -33 -> 109
    //   145: iconst_0
    //   146: istore_1
    //   147: goto -44 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	CmGameSocketConnection
    //   26	121	1	bool1	boolean
    //   1	110	2	bool2	boolean
    //   3	87	3	bool3	boolean
    //   49	36	4	arrayOfByte	byte[]
    //   105	10	4	localObject1	Object
    //   117	9	4	localException	Exception
    //   138	1	4	localObject2	Object
    //   71	41	5	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   80	89	105	finally
    //   91	98	105	finally
    //   111	114	105	finally
    //   27	37	117	java/lang/Exception
    //   39	51	117	java/lang/Exception
    //   58	65	117	java/lang/Exception
    //   67	73	117	java/lang/Exception
    //   75	78	117	java/lang/Exception
    //   114	117	117	java/lang/Exception
    //   98	101	138	finally
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: ldc 68
    //   2: iconst_1
    //   3: ldc_w 325
    //   6: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 36	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   13: invokevirtual 90	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   16: ifne +14 -> 30
    //   19: ldc 68
    //   21: iconst_1
    //   22: ldc_w 327
    //   25: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 53	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   34: ifnull +84 -> 118
    //   37: aload_0
    //   38: getfield 53	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   41: invokevirtual 331	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   44: checkcast 333	amuc
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +69 -> 118
    //   52: aload_2
    //   53: invokeinterface 336 1 0
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +58 -> 118
    //   63: aload_0
    //   64: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   67: ifnull +51 -> 118
    //   70: aload_0
    //   71: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   74: astore_2
    //   75: aload_2
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   81: aload_3
    //   82: invokevirtual 311	java/io/OutputStream:write	([B)V
    //   85: aload_0
    //   86: getfield 168	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   89: invokevirtual 314	java/io/OutputStream:flush	()V
    //   92: aload_2
    //   93: monitorexit
    //   94: goto +24 -> 118
    //   97: astore_3
    //   98: aload_2
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    //   102: astore_2
    //   103: ldc 68
    //   105: iconst_1
    //   106: ldc_w 338
    //   109: aload_2
    //   110: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: istore_1
    //   115: goto +5 -> 120
    //   118: iconst_1
    //   119: istore_1
    //   120: iload_1
    //   121: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	CmGameSocketConnection
    //   114	7	1	bool	boolean
    //   102	8	2	localException	Exception
    //   58	24	3	arrayOfByte	byte[]
    //   97	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   77	94	97	finally
    //   98	100	97	finally
    //   30	48	102	java/lang/Exception
    //   52	59	102	java/lang/Exception
    //   63	77	102	java/lang/Exception
    //   100	102	102	java/lang/Exception
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnection", 2, "[clearLastestConnection]");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.w("CmGameConnection", 1, "[clearLastestConnection] not connected now");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    try
    {
      if (this.jdField_a_of_type_Amud != null) {
        this.jdField_a_of_type_Amud.removeCallbacksAndMessages(null);
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
      QLog.d("CmGameConnection", 1, "[clearLastestConnection] exception=", localException);
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 68
    //   4: iconst_1
    //   5: ldc_w 365
    //   8: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: aload_0
    //   12: getfield 36	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: invokevirtual 90	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   18: ifeq +15 -> 33
    //   21: ldc 68
    //   23: iconst_1
    //   24: ldc_w 367
    //   27: invokestatic 346	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 369	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   37: ifnonnull +21 -> 58
    //   40: aload_0
    //   41: ldc_w 371
    //   44: iconst_0
    //   45: invokestatic 190	com/tencent/mobileqq/app/ThreadManager:newFreeHandlerThread	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   48: putfield 369	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   51: aload_0
    //   52: getfield 369	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   55: invokevirtual 197	android/os/HandlerThread:start	()V
    //   58: aload_0
    //   59: getfield 348	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_Amud	Lamud;
    //   62: ifnonnull +22 -> 84
    //   65: aload_0
    //   66: new 350	amud
    //   69: dup
    //   70: aload_0
    //   71: getfield 369	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   74: invokevirtual 203	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   77: aload_0
    //   78: invokespecial 374	amud:<init>	(Landroid/os/Looper;Lcom/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection;)V
    //   81: putfield 348	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_Amud	Lamud;
    //   84: aload_0
    //   85: getfield 348	com/tencent/mobileqq/apollo/lightGame/CmGameSocketConnection:jdField_a_of_type_Amud	Lamud;
    //   88: iconst_1
    //   89: invokevirtual 378	amud:sendEmptyMessage	(I)Z
    //   92: pop
    //   93: goto -63 -> 30
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	CmGameSocketConnection
    //   96	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	96	finally
    //   33	58	96	finally
    //   58	84	96	finally
    //   84	93	96	finally
  }
  
  public void a(amuc paramamuc)
  {
    if (paramamuc == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramamuc);
  }
  
  public void a(amue paramamue)
  {
    this.jdField_a_of_type_JavaUtilList = paramamue.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Int = paramamue.jdField_a_of_type_Int;
    this.c = paramamue.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = paramamue.c;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      QLog.d("CmGameConnection", 1, new Object[] { "[disconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", conn duration=", Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), "ms" });
      f();
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        amuc localamuc = (amuc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localamuc != null) {
          localamuc.a(paramBoolean);
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
    QLog.d("CmGameConnection", 1, "wakeup");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.w("CmGameConnection", 1, "[wakeup] failed, not connected");
      return;
    }
    this.jdField_a_of_type_Amud.removeMessages(2);
    this.jdField_a_of_type_Amud.sendEmptyMessage(2);
  }
  
  public void c()
  {
    QLog.d("CmGameConnection", 1, "[notifyConnSuccess]");
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      amuc localamuc = (amuc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localamuc != null) {
        localamuc.c();
      }
    }
  }
  
  public void d()
  {
    f();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      amuc localamuc = (amuc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localamuc != null) {
        localamuc.d();
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnection", 2, "[destroy]");
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.jdField_a_of_type_Amud != null) {
        this.jdField_a_of_type_Amud.removeCallbacksAndMessages(null);
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
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection$ReadRunnable = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("CmGameConnection", 1, "[destoryInner] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection
 * JD-Core Version:    0.7.0.1
 */