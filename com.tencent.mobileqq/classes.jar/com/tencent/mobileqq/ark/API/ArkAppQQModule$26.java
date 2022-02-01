package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import aptb;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ArkAppQQModule$26
  implements Runnable
{
  public ArkAppQQModule$26(aptb paramaptb, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper3 = this.this$0.a(this.jdField_a_of_type_Long);
    if (localVariantWrapper3 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = null;
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = localVariantWrapper2;
      if (TextUtils.isEmpty(this.b)) {
        break label76;
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("openid", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("token", this.b);
      localObject = ((JSONObject)localObject).toString();
      label76:
      localVariantWrapper2 = localVariantWrapper3.Create();
      ark.VariantWrapper localVariantWrapper4 = localVariantWrapper3.Create();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localVariantWrapper2.SetNull();
        localVariantWrapper3.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper4);
        localVariantWrapper4.Reset();
        localVariantWrapper2.Reset();
        localVariantWrapper3.Reset();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("ArkApp.ArkAppQQModule", 1, "loginDoCallback, convert to json fail");
        ark.VariantWrapper localVariantWrapper1 = localVariantWrapper2;
        continue;
        localVariantWrapper2.SetTableAsJsonString(localVariantWrapper1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.26
 * JD-Core Version:    0.7.0.1
 */