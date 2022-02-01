package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSettingBean;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class QQSettingMeSettingProcessor$3
  implements Runnable
{
  QQSettingMeSettingProcessor$3(QQSettingMeSettingProcessor paramQQSettingMeSettingProcessor, BusinessInfoCheckUpdate.AppInfo paramAppInfo, QQSettingMeSettingBean paramQQSettingMeSettingBean) {}
  
  public void run()
  {
    QQSettingMeRedTouchUtil.a(this.this$0.c, this.a, this.this$0.f);
    this.this$0.a.setValue(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSettingProcessor.3
 * JD-Core Version:    0.7.0.1
 */