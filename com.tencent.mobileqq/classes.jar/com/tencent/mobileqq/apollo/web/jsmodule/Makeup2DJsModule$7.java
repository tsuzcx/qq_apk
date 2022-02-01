package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.GetFavActionCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

class Makeup2DJsModule$7
  implements IStoreAvatar2D.GetFavActionCallback
{
  Makeup2DJsModule$7(Makeup2DJsModule paramMakeup2DJsModule, String paramString) {}
  
  public void a(int paramInt, @Nullable JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      this.b.a(this.a, "fav action data is null");
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("data", paramJSONObject);
      ((JSONObject)localObject).put("result", 0);
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetFavAction error:");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e("Makeup2DJsModule", 1, localStringBuilder.toString());
    }
    Makeup2DJsModule localMakeup2DJsModule = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("&&");
    localStringBuilder.append(this.a);
    localStringBuilder.append("(");
    localStringBuilder.append(((JSONObject)localObject).toString());
    localStringBuilder.append(");");
    localMakeup2DJsModule.d(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFavAction onResponse data is:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("Makeup2DJsModule", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.7
 * JD-Core Version:    0.7.0.1
 */