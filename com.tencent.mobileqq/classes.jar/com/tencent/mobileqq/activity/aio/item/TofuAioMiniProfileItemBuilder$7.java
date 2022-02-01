package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.qphone.base.util.QLog;

class TofuAioMiniProfileItemBuilder$7
  extends AnonymousObserver
{
  TofuAioMiniProfileItemBuilder$7(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder) {}
  
  public void onBrowseAskAnonymouslyReport(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBrowseAskAnonymouslyReport() success = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */