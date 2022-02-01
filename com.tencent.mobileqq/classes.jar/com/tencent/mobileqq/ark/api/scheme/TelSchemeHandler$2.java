package com.tencent.mobileqq.ark.api.scheme;

import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.ark.module.ArkAPIPermission;
import com.tencent.mobileqq.ark.util.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class TelSchemeHandler$2
  implements Runnable
{
  TelSchemeHandler$2(TelSchemeHandler paramTelSchemeHandler, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = ark.Application.Create(this.jdField_a_of_type_JavaLangString, this.b);
    if (localObject1 == null)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate create application error");
      return;
    }
    if (!ArkAPIPermission.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, (ark.Application)localObject1, "permission.TELEPHONE"))
    {
      ((ark.Application)localObject1).Release();
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate check Permission fail");
      return;
    }
    ((ark.Application)localObject1).Release();
    String str = this.b;
    localObject1 = str;
    Object localObject2;
    if (TextUtils.isEmpty(str)) {
      try
      {
        localObject3 = StringUtil.a(new JSONObject(this.c)).get("number");
        localObject1 = str;
        if (localObject3 != null) {
          localObject1 = localObject3.toString();
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("ArkAppSchemeCenter.navigate parameter error: ");
        ((StringBuilder)localObject3).append(localJSONException.getMessage());
        QLog.i("ArkApp", 1, ((StringBuilder)localObject3).toString());
        localObject2 = str;
      }
    }
    this.this$0.a(localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler.2
 * JD-Core Version:    0.7.0.1
 */