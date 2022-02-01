package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.store.webview.BridgeStream;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil
{
  public static WebResourceResponse a()
  {
    return new WebResourceResponse("application/octet-stream", "utf-8", new BridgeStream(null, null, null));
  }
  
  public static void a(WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse != null)
    {
      Map localMap = paramWebResourceResponse.getResponseHeaders();
      Object localObject = localMap;
      if (localMap == null) {
        localObject = new HashMap();
      }
      ((Map)localObject).put("Access-Control-Allow-Origin", "*");
      paramWebResourceResponse.setResponseHeaders((Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ResponseUtil
 * JD-Core Version:    0.7.0.1
 */