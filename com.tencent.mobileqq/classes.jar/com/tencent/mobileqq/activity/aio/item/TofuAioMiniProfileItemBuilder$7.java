package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.qphone.base.util.QLog;

class TofuAioMiniProfileItemBuilder$7
  extends AnonymousObserver
{
  TofuAioMiniProfileItemBuilder$7(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder) {}
  
  public void onBrowseAskAnonymouslyReport(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, "onBrowseAskAnonymouslyReport() success = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */