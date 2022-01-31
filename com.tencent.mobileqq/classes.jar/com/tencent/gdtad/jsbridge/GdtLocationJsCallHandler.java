package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

public class GdtLocationJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = GdtLocationUtil.INSTANCE.getLocation();
      JSONObject localJSONObject = new JSONObject();
      if (paramVarArgs != null)
      {
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
      }
      for (;;)
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
        return true;
        localJSONObject.put("lat", JSONObject.NULL);
        localJSONObject.put("lon", JSONObject.NULL);
      }
      return true;
    }
    catch (Exception paramGdtAdWebPlugin)
    {
      paramGdtAdWebPlugin.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLocationJsCallHandler
 * JD-Core Version:    0.7.0.1
 */