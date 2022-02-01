package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class QQSettingMeHeadVipProcessor$7
  implements Runnable
{
  QQSettingMeHeadVipProcessor$7(QQSettingMeHeadVipProcessor paramQQSettingMeHeadVipProcessor, BusinessInfoCheckUpdate.AppInfo paramAppInfo1, BusinessInfoCheckUpdate.AppInfo paramAppInfo2, boolean paramBoolean) {}
  
  public void run()
  {
    QQSettingMeRedTouchUtil.a(this.this$0.c, this.a, this.this$0.f);
    this.this$0.i.setValue(this.a);
    QQSettingMeRedTouchUtil.a(this.this$0.c, this.b, this.this$0.f);
    this.this$0.j.setValue(this.b);
    if (this.c) {
      QQSettingMeHeadVipProcessor.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.7
 * JD-Core Version:    0.7.0.1
 */