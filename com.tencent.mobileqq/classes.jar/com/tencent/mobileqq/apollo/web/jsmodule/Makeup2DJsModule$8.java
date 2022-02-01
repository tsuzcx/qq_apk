package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.AddFavActionCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

class Makeup2DJsModule$8
  implements IStoreAvatar2D.AddFavActionCallback
{
  Makeup2DJsModule$8(Makeup2DJsModule paramMakeup2DJsModule, String paramString) {}
  
  public void a(@Nullable JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramJSONObject);
      localJSONObject.put("result", 0);
    }
    catch (JSONException paramJSONObject)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFavAction error:");
      localStringBuilder.append(paramJSONObject.getMessage());
      QLog.e("Makeup2DJsModule", 1, localStringBuilder.toString());
    }
    paramJSONObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("&&");
    localStringBuilder.append(this.a);
    localStringBuilder.append("(");
    localStringBuilder.append(localJSONObject.toString());
    localStringBuilder.append(");");
    paramJSONObject.d(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.8
 * JD-Core Version:    0.7.0.1
 */