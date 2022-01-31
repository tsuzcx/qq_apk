package com.tencent.mobileqq.armap.ipc;

import abft;
import abfu;
import abfv;
import abfw;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResultCallback;
import eipc.EIPClientConnectListener;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ArMapIPC
{
  private static ArMapIPC jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC;
  static QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new abfw("ArMapModule");
  EIPCOnGetConnectionListener jdField_a_of_type_EipcEIPCOnGetConnectionListener = new abfu(this);
  EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new abfv(this);
  EIPClientConnectListener jdField_a_of_type_EipcEIPClientConnectListener = new abft(this);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  private ArMapIPC()
  {
    this.jdField_a_of_type_Boolean = false;
    QIPCClientHelper.getInstance().getClient().addListener(this.jdField_a_of_type_EipcEIPCOnGetConnectionListener);
    a();
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public static final ArMapIPC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC == null) {
      jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC = new ArMapIPC();
    }
    return jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC;
  }
  
  public void a()
  {
    QIPCClientHelper.getInstance().register(jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
    QIPCClientHelper.getInstance().getClient().connect(this.jdField_a_of_type_EipcEIPClientConnectListener);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().callServer("ArMapModule", paramString, paramBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  /* Error */
  public void a(String paramString, eipc.EIPCResult paramEIPCResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 36	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_3
    //   15: aload_0
    //   16: getfield 36	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   19: invokeinterface 110 1 0
    //   24: if_icmpge +45 -> 69
    //   27: aload_0
    //   28: getfield 36	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   31: iload_3
    //   32: invokeinterface 114 2 0
    //   37: checkcast 116	com/tencent/mobileqq/armap/ipc/IAsyncObserver
    //   40: astore 6
    //   42: aload_0
    //   43: getfield 81	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   46: new 118	abfx
    //   49: dup
    //   50: aload_0
    //   51: aload 6
    //   53: aload_1
    //   54: aload_2
    //   55: invokespecial 121	abfx:<init>	(Lcom/tencent/mobileqq/armap/ipc/ArMapIPC;Lcom/tencent/mobileqq/armap/ipc/IAsyncObserver;Ljava/lang/String;Leipc/EIPCResult;)V
    //   58: invokevirtual 127	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   61: pop
    //   62: iload_3
    //   63: iconst_1
    //   64: iadd
    //   65: istore_3
    //   66: goto -52 -> 14
    //   69: aload 5
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield 34	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   76: astore 5
    //   78: aload 5
    //   80: monitorenter
    //   81: iload 4
    //   83: istore_3
    //   84: iload_3
    //   85: aload_0
    //   86: getfield 34	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   89: invokeinterface 110 1 0
    //   94: if_icmpge +51 -> 145
    //   97: aload_0
    //   98: getfield 34	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   101: iload_3
    //   102: invokeinterface 114 2 0
    //   107: checkcast 116	com/tencent/mobileqq/armap/ipc/IAsyncObserver
    //   110: astore 6
    //   112: aload_0
    //   113: getfield 86	com/tencent/mobileqq/armap/ipc/ArMapIPC:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   116: new 129	abfy
    //   119: dup
    //   120: aload_0
    //   121: aload 6
    //   123: aload_1
    //   124: aload_2
    //   125: invokespecial 130	abfy:<init>	(Lcom/tencent/mobileqq/armap/ipc/ArMapIPC;Lcom/tencent/mobileqq/armap/ipc/IAsyncObserver;Ljava/lang/String;Leipc/EIPCResult;)V
    //   128: invokevirtual 127	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
    //   0	155	0	this	ArMapIPC
    //   0	155	1	paramString	String
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
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      QIPCClientHelper.getInstance().getClient().disConnect();
    }
    QIPCClientHelper.getInstance().getClient().removeListener(this.jdField_a_of_type_EipcEIPCOnGetConnectionListener);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ipc.ArMapIPC
 * JD-Core Version:    0.7.0.1
 */