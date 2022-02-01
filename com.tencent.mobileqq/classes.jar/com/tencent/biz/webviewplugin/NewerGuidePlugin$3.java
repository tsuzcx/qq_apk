package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class NewerGuidePlugin$3
  implements QQPermissionCallback
{
  NewerGuidePlugin$3(NewerGuidePlugin paramNewerGuidePlugin, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar deny permissions");
    }
    QQCustomDialog.showPermissionSettingDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131707441));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar grant permissions");
    }
    NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.3
 * JD-Core Version:    0.7.0.1
 */