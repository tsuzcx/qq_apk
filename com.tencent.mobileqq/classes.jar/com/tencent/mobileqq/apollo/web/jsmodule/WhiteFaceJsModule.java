package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

public class WhiteFaceJsModule
  extends BaseJsModule
{
  public WhiteFaceJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  @RequestRoute(a="addCmFace")
  private void handleJsApiAddCmFace(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("faceIdList");
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(paramJSONObject, new WhiteFaceJsModule.2(this, paramString));
      return;
    }
    a(paramString, HardCodeUtil.a(2131898684));
  }
  
  @RequestRoute(a="isCmFaceAdded")
  private void handleJsApiIsCmFaceAdded(String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("faceIdList");
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(paramJSONObject, new WhiteFaceJsModule.1(this, paramString));
      return;
    }
    a(paramString, HardCodeUtil.a(2131898684));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.WhiteFaceJsModule
 * JD-Core Version:    0.7.0.1
 */