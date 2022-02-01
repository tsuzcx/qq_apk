package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ArkAppQQModule$26
  implements Runnable
{
  ArkAppQQModule$26(ArkAppQQModule paramArkAppQQModule, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    ark.VariantWrapper localVariantWrapper2 = ArkAppQQModule.d(this.this$0, this.a);
    if (localVariantWrapper2 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper1 = null;
    if (TextUtils.isEmpty(this.b))
    {
      localObject = localVariantWrapper1;
      if (TextUtils.isEmpty(this.c)) {
        break label89;
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("openid", this.b);
      ((JSONObject)localObject).put("token", this.c);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      label79:
      ark.VariantWrapper localVariantWrapper3;
      break label79;
    }
    QLog.i("ArkApp.ArkAppQQModule", 1, "loginDoCallback, convert to json fail");
    Object localObject = localVariantWrapper1;
    label89:
    localVariantWrapper1 = localVariantWrapper2.Create();
    localVariantWrapper3 = localVariantWrapper2.Create();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localVariantWrapper1.SetNull();
    } else {
      localVariantWrapper1.SetTableAsJsonString((String)localObject);
    }
    localVariantWrapper2.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper3);
    localVariantWrapper3.Reset();
    localVariantWrapper1.Reset();
    localVariantWrapper2.Reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.26
 * JD-Core Version:    0.7.0.1
 */