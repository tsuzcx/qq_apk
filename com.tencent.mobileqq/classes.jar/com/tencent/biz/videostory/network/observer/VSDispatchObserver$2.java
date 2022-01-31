package com.tencent.biz.videostory.network.observer;

import com.tencent.qphone.base.util.QLog;
import xgt;
import xgu;

public class VSDispatchObserver$2
  implements Runnable
{
  public VSDispatchObserver$2(xgt paramxgt, xgu paramxgu, long paramLong, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Xgu.a(false, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, null);
    QLog.e("VSNetworkHelper", 1, "inform VSBaseRequest finalRsp is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.2
 * JD-Core Version:    0.7.0.1
 */