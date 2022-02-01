package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

class QQSettingMeHeadVipProcessor$7
  implements Runnable
{
  QQSettingMeHeadVipProcessor$7(QQSettingMeHeadVipProcessor paramQQSettingMeHeadVipProcessor, BusinessInfoCheckUpdate.AppInfo paramAppInfo1, BusinessInfoCheckUpdate.AppInfo paramAppInfo2, boolean paramBoolean) {}
  
  public void run()
  {
    QQSettingMeRedTouchUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, this.this$0.jdField_a_of_type_JavaUtilHashSet);
    this.this$0.b.setValue(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    QQSettingMeRedTouchUtil.a(this.this$0.jdField_a_of_type_MqqAppAppRuntime, this.b, this.this$0.jdField_a_of_type_JavaUtilHashSet);
    this.this$0.c.setValue(this.b);
    if (this.jdField_a_of_type_Boolean) {
      QQSettingMeHeadVipProcessor.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.7
 * JD-Core Version:    0.7.0.1
 */