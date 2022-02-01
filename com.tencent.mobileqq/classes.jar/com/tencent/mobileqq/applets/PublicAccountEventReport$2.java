package com.tencent.mobileqq.applets;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;

final class PublicAccountEventReport$2
  implements Runnable
{
  PublicAccountEventReport$2(IWeatherCommApi paramIWeatherCommApi, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    String str = ServiceAccountFolderManager.a().c();
    if (this.a.isWeatherPA(str)) {
      PublicAccountEventReport.b(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.2
 * JD-Core Version:    0.7.0.1
 */