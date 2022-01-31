package com.tencent.biz.videostory.network.observer;

import com.tencent.qphone.base.util.QLog;
import wxw;
import wxx;

public class VSDispatchObserver$4
  implements Runnable
{
  public VSDispatchObserver$4(wxw paramwxw, wxx paramwxx, Exception paramException) {}
  
  public void run()
  {
    this.jdField_a_of_type_Wxx.a(false, -2L, "rsp Parse Error", null);
    QLog.e("VSNetworkHelper", 1, "inform VSBaseRequest resultcode fail." + this.jdField_a_of_type_JavaLangException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.4
 * JD-Core Version:    0.7.0.1
 */