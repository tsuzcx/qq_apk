package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.mobileqq.app.QQManagerFactory;

class ReadInJoyNewFeedsActivity$8
  implements Runnable
{
  ReadInJoyNewFeedsActivity$8(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, GuideData paramGuideData) {}
  
  public void run()
  {
    if ("operation_guide".equals(this.a.business))
    {
      this.this$0.a(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER, this.a.business, this.a);
      return;
    }
    this.this$0.a(QQManagerFactory.READ_INJOY_SKIN_MANAGER, "", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.8
 * JD-Core Version:    0.7.0.1
 */