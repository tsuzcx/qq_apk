package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$3
  implements Runnable
{
  EqqAccountDetailActivityImpl$3(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, EqqDetail paramEqqDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "updateDetailInfo");
    }
    EqqDetail localEqqDetail = this.a;
    if (localEqqDetail != null)
    {
      this.this$0.saveEqqDetailToDBAndCache(localEqqDetail);
      this.this$0.notifyUpdateDetailInfo(this.a);
      if (this.b)
      {
        this.this$0.mHandler.sendEmptyMessage(1);
        return;
      }
      EqqAccountDetailActivityImpl.access$001(this.this$0, new EqqAccountDetailActivityImpl.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.3
 * JD-Core Version:    0.7.0.1
 */