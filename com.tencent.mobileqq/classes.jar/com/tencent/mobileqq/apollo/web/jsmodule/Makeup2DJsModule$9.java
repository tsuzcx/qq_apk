package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.DelFavListCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

class Makeup2DJsModule$9
  implements IStoreAvatar2D.DelFavListCallback
{
  Makeup2DJsModule$9(Makeup2DJsModule paramMakeup2DJsModule, String paramString) {}
  
  public void a(@Nullable JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      boolean bool = paramJSONObject.optBoolean("delHasError");
      if (bool) {
        localJSONObject.put("result", 1);
      } else {
        localJSONObject.put("result", 0);
      }
      localJSONObject.put("data", paramJSONObject.opt("errorList"));
    }
    catch (Exception paramJSONObject)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDelFavList");
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
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("IPC_APOLLO_DEL_FAV_List onResponse data is:");
      paramJSONObject.append(localJSONObject.toString());
      QLog.d("Makeup2DJsModule", 2, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.9
 * JD-Core Version:    0.7.0.1
 */