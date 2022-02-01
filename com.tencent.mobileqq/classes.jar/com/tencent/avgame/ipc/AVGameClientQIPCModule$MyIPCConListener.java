package com.tencent.avgame.ipc;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPClientConnectListener;
import java.util.concurrent.atomic.AtomicInteger;

class AVGameClientQIPCModule$MyIPCConListener
  implements EIPCOnGetConnectionListener, EIPClientConnectListener
{
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private AVGameClientQIPCModule$MyIPCConListener(AVGameClientQIPCModule paramAVGameClientQIPCModule) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public void connectFailed()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    QLog.i("AVGameClientQIPCModule", 1, "connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("connectSuccess, server[");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.i("AVGameClientQIPCModule", 1, localStringBuilder.toString());
  }
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnectBind, [");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.i("AVGameClientQIPCModule", 1, localStringBuilder.toString());
    if (TextUtils.equals("com.tencent.mobileqq", paramEIPCConnection.procName)) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnectUnbind, [");
    localStringBuilder.append(paramEIPCConnection.procName);
    localStringBuilder.append("]");
    QLog.i("AVGameClientQIPCModule", 1, localStringBuilder.toString());
    if (TextUtils.equals("com.tencent.mobileqq", paramEIPCConnection.procName)) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameClientQIPCModule.MyIPCConListener
 * JD-Core Version:    0.7.0.1
 */