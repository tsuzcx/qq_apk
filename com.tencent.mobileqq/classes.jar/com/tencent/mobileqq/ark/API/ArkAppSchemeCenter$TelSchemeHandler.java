package com.tencent.mobileqq.ark.API;

import aaqr;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppSchemeCenter$TelSchemeHandler
  implements ArkAppSchemeCenter.IRegScheme
{
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArkAppCenter.a().postToMainThread(new aaqr(this, paramString));
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (!ArkAppModuleReg.a(paramString3, paramLong, "permission.TELEPHONE")) {
      return false;
    }
    paramString3 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {}
    try
    {
      paramString2 = ArkAppSchemeCenter.a(new JSONObject(paramString2)).get("number");
      paramString3 = paramString1;
      if (paramString2 != null) {
        paramString3 = paramString2.toString();
      }
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString3 = paramString1;
        if (QLog.isColorLevel())
        {
          QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate parameter error: " + paramString2.getMessage());
          paramString3 = paramString1;
        }
      }
    }
    a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler
 * JD-Core Version:    0.7.0.1
 */