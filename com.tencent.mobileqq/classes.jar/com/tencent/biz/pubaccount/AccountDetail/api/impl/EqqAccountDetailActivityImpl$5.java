package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$5
  implements Runnable
{
  EqqAccountDetailActivityImpl$5(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "saveEqqDetailInSubThread");
    }
    EqqAccountDetailActivityImpl localEqqAccountDetailActivityImpl = this.this$0;
    localEqqAccountDetailActivityImpl.saveEqqDetailToDBAndCache(localEqqAccountDetailActivityImpl.eqqDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.5
 * JD-Core Version:    0.7.0.1
 */