package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$4
  implements Runnable
{
  EqqAccountDetailActivityImpl$4(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, EqqDetail paramEqqDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "saveEqqDetailInSubThread");
    }
    this.this$0.saveEqqDetailToDBAndCache(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.4
 * JD-Core Version:    0.7.0.1
 */