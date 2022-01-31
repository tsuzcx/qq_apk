package com.tencent.mobileqq.apollo.process.data;

import aipo;
import aipq;
import com.tencent.qphone.base.util.QLog;

public class CmGameLifeCycle$1
  implements Runnable
{
  public CmGameLifeCycle$1(aipo paramaipo, aipq paramaipq) {}
  
  public void run()
  {
    this.a.f();
    this.a.g();
    if (QLog.isColorLevel()) {
      QLog.d(aipo.a, 2, "onCurrentGame showMsgTips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle.1
 * JD-Core Version:    0.7.0.1
 */