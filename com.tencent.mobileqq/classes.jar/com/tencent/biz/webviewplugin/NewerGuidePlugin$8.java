package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.json.JSONObject;

class NewerGuidePlugin$8
  implements NewerGuidePlugin.ReadContactsPermissionsCallback
{
  NewerGuidePlugin$8(NewerGuidePlugin paramNewerGuidePlugin, JSONObject paramJSONObject, Activity paramActivity) {}
  
  @QQPermissionDenied(1)
  public void deniedReadContacts()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "deniedReadContacts");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      this.c.callJs("respUploadContacts", new String[] { localJSONObject.toString() });
      QQCustomDialog.showPermissionSettingDialog(this.b, HardCodeUtil.a(2131905283));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "deniedReadContacts fail.", localException);
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
      NewerGuidePlugin.a(this.c, this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.8
 * JD-Core Version:    0.7.0.1
 */