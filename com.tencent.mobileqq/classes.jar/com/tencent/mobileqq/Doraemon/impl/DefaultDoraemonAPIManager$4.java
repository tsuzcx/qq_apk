package com.tencent.mobileqq.Doraemon.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DefaultDoraemonAPIManager$4
  implements DialogInterface.OnCancelListener
{
  DefaultDoraemonAPIManager$4(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager, UserPermission paramUserPermission, APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.e.g();
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("cancel ");
    paramDialogInterface.append(this.a.a);
    QLog.i("DoraemonOpenAPI.apiMgr", 1, paramDialogInterface.toString());
    DefaultDoraemonAPIManager.c(this.e, 4, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager.4
 * JD-Core Version:    0.7.0.1
 */