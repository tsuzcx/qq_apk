package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import aonw;
import aoqp;
import aoqw;
import com.tencent.ark.ark.Application;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppSchemeCenter$TelSchemeHandler$2
  implements Runnable
{
  public ArkAppSchemeCenter$TelSchemeHandler$2(aoqw paramaoqw, String paramString1, String paramString2, long paramLong, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = ark.Application.Create(this.jdField_a_of_type_JavaLangString, this.b);
    if (localObject1 == null)
    {
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate create application error");
      return;
    }
    if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, (ark.Application)localObject1, "permission.TELEPHONE"))
    {
      ((ark.Application)localObject1).Release();
      QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate check Permission fail");
      return;
    }
    ((ark.Application)localObject1).Release();
    str = this.b;
    localObject1 = str;
    if (TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject3 = aoqp.a(new JSONObject(this.c)).get("number");
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = localObject3.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate parameter error: " + localJSONException.getMessage());
        Object localObject2 = str;
      }
    }
    this.this$0.a((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.2
 * JD-Core Version:    0.7.0.1
 */