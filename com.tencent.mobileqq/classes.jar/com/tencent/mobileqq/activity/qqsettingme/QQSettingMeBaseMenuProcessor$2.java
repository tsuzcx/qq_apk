package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class QQSettingMeBaseMenuProcessor$2
  implements Runnable
{
  QQSettingMeBaseMenuProcessor$2(QQSettingMeBaseMenuProcessor paramQQSettingMeBaseMenuProcessor, boolean paramBoolean1, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, this.b);
    }
    QQSettingMeRedTouchUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, this.this$0.jdField_a_of_type_JavaUtilHashSet);
    this.this$0.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeBaseMenuProcessor.2
 * JD-Core Version:    0.7.0.1
 */