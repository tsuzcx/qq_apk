package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class QQSettingMeQRCodeProcessor$2
  implements Runnable
{
  QQSettingMeQRCodeProcessor$2(QQSettingMeQRCodeProcessor paramQQSettingMeQRCodeProcessor, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void run()
  {
    QQSettingMeRedTouchUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.a, this.this$0.jdField_a_of_type_JavaUtilHashSet);
    this.this$0.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQRCodeProcessor.2
 * JD-Core Version:    0.7.0.1
 */