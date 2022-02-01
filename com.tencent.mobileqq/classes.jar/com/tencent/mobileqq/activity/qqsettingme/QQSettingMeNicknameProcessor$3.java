package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.qroute.QRoute;

class QQSettingMeNicknameProcessor$3
  implements Runnable
{
  QQSettingMeNicknameProcessor$3(QQSettingMeNicknameProcessor paramQQSettingMeNicknameProcessor) {}
  
  public void run()
  {
    if (this.this$0.c != null) {
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkAndGetSelfNickName(this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNicknameProcessor.3
 * JD-Core Version:    0.7.0.1
 */