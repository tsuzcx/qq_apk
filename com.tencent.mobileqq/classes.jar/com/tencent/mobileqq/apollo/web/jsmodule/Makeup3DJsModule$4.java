package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.ipc.business.ICm3DMakeup.Save3DFaceListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class Makeup3DJsModule$4
  implements ICm3DMakeup.Save3DFaceListener
{
  Makeup3DJsModule$4(Makeup3DJsModule paramMakeup3DJsModule, String paramString) {}
  
  public void a()
  {
    this.b.a(this.a, "get faceUrl failed");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.b.a(this.a, "get faceUrl is empty");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      boolean bool = CmShowWnsUtils.aj();
      String str1 = CmShowWnsUtils.ah();
      String str2 = CmShowWnsUtils.ai();
      if ((bool) && (paramString.contains(str1))) {
        localJSONObject.put(ApolloConstant.e, paramString.replace(str1, str2));
      } else {
        localJSONObject.put(ApolloConstant.e, paramString);
      }
      this.b.a(this.a, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      this.b.a(this.a, "get faceUrl failed");
      QLog.e("[cmshow]Makeup3DJsModule", 1, new Object[] { "save3DFaceData json parser error", paramString.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.4
 * JD-Core Version:    0.7.0.1
 */