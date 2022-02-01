package com.tencent.mobileqq.apollo.utils;

import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ResponseUtil
 * JD-Core Version:    0.7.0.1
 */