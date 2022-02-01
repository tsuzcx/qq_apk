package com.tencent.mobileqq.apollo.process.data;

import com.tencent.qphone.base.util.QLog;

class CmGameLifeCycle$1
  implements Runnable
{
  CmGameLifeCycle$1(CmGameLifeCycle paramCmGameLifeCycle, CmGameMainManager paramCmGameMainManager) {}
  
  public void run()
  {
    this.a.f();
    this.a.g();
    if (QLog.isColorLevel()) {
      QLog.d(CmGameLifeCycle.a, 2, "onCurrentGame showMsgTips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle.1
 * JD-Core Version:    0.7.0.1
 */