package com.tencent.mobileqq.armap.ipc;

import abna;
import abnb;
import abnc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResultCallback;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ArMapIPCProxy
{
  private static ArMapIPCProxy jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPCProxy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new abnc(this, "ArMapModule");
  EIPCOnGetConnectionListener jdField_a_of_type_EipcEIPCOnGetConnectionListener = new abna(this);
  EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new abnb(this);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  private ArMapIPCProxy()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPCProxy", 2, "ArMapIPCProxy");
    }
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public static ArMapIPCProxy a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPCProxy == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPCProxy == null) {
        jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPCProxy = new ArMapIPCProxy();
      }
      return jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPCProxy;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPCProxy", 2, "ArMapIPCProxy onCreate app:" + paramQQAppInterface);
    }
    QIPCServerHelper.getInstance().getServer().removeListener(this.jdField_a_of_type_EipcEIPCOnGetConnectionListener);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    QIPCServerHelper.getInstance().getServer().addListener(this.jdField_a_of_type_EipcEIPCOnGetConnectionListener);
  }
  
  /* Error */
  public void a(java.lang.String paramString, eipc.EIPCResult paramEIPCResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 27	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_3
    //   15: aload_0
    //   16: getfield 27	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   19: invokeinterface 129 1 0
    //   24: if_icmpge +45 -> 69
    //   27: aload_0
    //   28: getfield 27	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   31: iload_3
    //   32: invokeinterface 133 2 0
    //   37: checkcast 135	com/tencent/mobileqq/armap/ipc/IAsyncObserver
    //   40: astore 6
    //   42: aload_0
    //   43: getfield 68	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   46: new 137	abnd
    //   49: dup
    //   50: aload_0
    //   51: aload 6
    //   53: aload_1
    //   54: aload_2
    //   55: invokespecial 140	abnd:<init>	(Lcom/tencent/mobileqq/armap/ipc/ArMapIPCProxy;Lcom/tencent/mobileqq/armap/ipc/IAsyncObserver;Ljava/lang/String;Leipc/EIPCResult;)V
    //   58: invokevirtual 146	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   61: pop
    //   62: iload_3
    //   63: iconst_1
    //   64: iadd
    //   65: istore_3
    //   66: goto -52 -> 14
    //   69: aload 5
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield 25	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   76: astore 5
    //   78: aload 5
    //   80: monitorenter
    //   81: iload 4
    //   83: istore_3
    //   84: iload_3
    //   85: aload_0
    //   86: getfield 25	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   89: invokeinterface 129 1 0
    //   94: if_icmpge +51 -> 145
    //   97: aload_0
    //   98: getfield 25	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   101: iload_3
    //   102: invokeinterface 133 2 0
    //   107: checkcast 135	com/tencent/mobileqq/armap/ipc/IAsyncObserver
    //   110: astore 6
    //   112: aload_0
    //   113: getfield 73	com/tencent/mobileqq/armap/ipc/ArMapIPCProxy:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   116: new 148	abne
    //   119: dup
    //   120: aload_0
    //   121: aload 6
    //   123: aload_1
    //   124: aload_2
    //   125: invokespecial 149	abne:<init>	(Lcom/tencent/mobileqq/armap/ipc/ArMapIPCProxy;Lcom/tencent/mobileqq/armap/ipc/IAsyncObserver;Ljava/lang/String;Leipc/EIPCResult;)V
    //   128: invokevirtual 146	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   131: pop
    //   132: iload_3
    //   133: iconst_1
    //   134: iadd
    //   135: istore_3
    //   136: goto -52 -> 84
    //   139: astore_1
    //   140: aload 5
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: aload 5
    //   147: monitorexit
    //   148: return
    //   149: astore_1
    //   150: aload 5
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	ArMapIPCProxy
    //   0	155	1	paramString	java.lang.String
    //   0	155	2	paramEIPCResult	eipc.EIPCResult
    //   13	123	3	i	int
    //   1	81	4	j	int
    //   7	144	5	localList	List
    //   40	82	6	localIAsyncObserver	IAsyncObserver
    // Exception table:
    //   from	to	target	type
    //   14	62	139	finally
    //   69	72	139	finally
    //   140	143	139	finally
    //   84	132	149	finally
    //   145	148	149	finally
    //   150	153	149	finally
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.i("ArMapIPCProxy", 2, "ArMapIPCProxy onDestroy direct return app:" + paramQQAppInterface + "  this.app:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    do
    {
      return;
      QIPCServerHelper.getInstance().getServer().removeListener(this.jdField_a_of_type_EipcEIPCOnGetConnectionListener);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    } while (!QLog.isColorLevel());
    QLog.i("ArMapIPCProxy", 2, "ArMapIPCProxy onDestroy here");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ipc.ArMapIPCProxy
 * JD-Core Version:    0.7.0.1
 */