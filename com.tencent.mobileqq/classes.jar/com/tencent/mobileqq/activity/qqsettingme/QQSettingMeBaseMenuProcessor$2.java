package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class QQSettingMeBaseMenuProcessor$2
  implements Runnable
{
  QQSettingMeBaseMenuProcessor$2(QQSettingMeBaseMenuProcessor paramQQSettingMeBaseMenuProcessor, boolean paramBoolean1, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.a) {
      this.this$0.b(this.b, this.c);
    }
    QQSettingMeRedTouchUtil.a(this.this$0.c, this.b, this.this$0.f);
    this.this$0.a.setValue(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeBaseMenuProcessor.2
 * JD-Core Version:    0.7.0.1
 */