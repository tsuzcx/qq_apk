package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class WidgetModule$DialogCallback
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
  APICallback a;
  
  public WidgetModule$DialogCallback(APICallback paramAPICallback)
  {
    this.a = paramAPICallback;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("confirm", false);
      paramDialogInterface.put("cancel", true);
      DoraemonUtil.a(this.a, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      APICallback localAPICallback = this.a;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      DoraemonUtil.a(localAPICallback, -1, paramDialogInterface);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    boolean bool2 = false;
    boolean bool1;
    if (paramInt == 1) {
      bool1 = true;
    }
    for (;;)
    {
      try
      {
        paramDialogInterface.put("confirm", bool1);
        bool1 = bool2;
        if (paramInt != 1) {
          bool1 = true;
        }
        paramDialogInterface.put("cancel", bool1);
        DoraemonUtil.a(this.a, paramDialogInterface);
        return;
      }
      catch (JSONException paramDialogInterface)
      {
        String str = paramDialogInterface.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
        }
        APICallback localAPICallback = this.a;
        paramDialogInterface = str;
        if (str == null) {
          paramDialogInterface = "";
        }
        DoraemonUtil.a(localAPICallback, -1, paramDialogInterface);
        return;
      }
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.WidgetModule.DialogCallback
 * JD-Core Version:    0.7.0.1
 */