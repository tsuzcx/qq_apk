package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.json.JSONObject;

class NewerGuidePlugin$9
  implements NewerGuidePlugin.ReadContactsPermissionsCallback
{
  NewerGuidePlugin$9(NewerGuidePlugin paramNewerGuidePlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  @QQPermissionDenied(1)
  public void deniedReadContacts()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "deniedReadContacts");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respRecommend", new String[] { localJSONObject.toString() });
      QQCustomDialog.showPermissionSettingDialog(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131707442));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NewerGuidePlugin", 1, "deniedReadContacts fail.", localException);
      }
    }
  }
  
  @QQPermissionGrant(1)
  public void grandReadContacts()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "grandReadContacts");
    }
    try
    {
      NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, this.jdField_a_of_type_OrgJsonJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.9
 * JD-Core Version:    0.7.0.1
 */