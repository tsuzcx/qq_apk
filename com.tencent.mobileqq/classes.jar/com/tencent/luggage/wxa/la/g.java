package com.tencent.luggage.wxa.la;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import org.json.JSONObject;

public class g
  extends a
{
  public static final int CTRL_INDEX = 251;
  public static final String NAME = "navigateToMiniProgram";
  
  public void a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("appId", null);
    if (com.tencent.luggage.wxa.qz.af.c(str1))
    {
      paramb.a(paramInt, b("fail:appID is empty"));
      return;
    }
    if (str1.equals(paramb.getAppId()))
    {
      paramb.a(paramInt, b("fail:target appId is the same as the caller appId"));
      return;
    }
    String str2 = paramJSONObject.optString("path", null);
    int j = paramb.q().A().S.b;
    int i = b.a(paramJSONObject.optString("envVersion"), b.a).d;
    if ((j != 1) && (j != 2)) {
      i = 0;
    }
    j = paramJSONObject.optInt("sourcetype", 0);
    String str3 = paramJSONObject.optString("agentId");
    c.a locala = new c.a();
    locala.a = paramJSONObject.optInt("scene", 0);
    locala.b = paramJSONObject.optString("sceneNote");
    locala.c = paramJSONObject.optInt("preScene", 0);
    locala.d = paramJSONObject.optString("preSceneNote");
    locala.f = j;
    locala.e = str3;
    locala.g = paramJSONObject.optString("adInfo");
    m_().a(paramb, str1, i, str2, locala, paramJSONObject, new g.1(this, paramb, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.g
 * JD-Core Version:    0.7.0.1
 */