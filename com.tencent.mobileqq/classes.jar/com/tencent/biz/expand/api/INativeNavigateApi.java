package com.tencent.biz.expand.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface INativeNavigateApi
  extends QRouteApi
{
  public abstract void navigateBySchema(String paramString);
  
  public abstract void navigateMiniApp(String paramString);
  
  public abstract void navigateWebView(String paramString);
  
  public abstract void navigateWithoutSchema(String paramString, Map<Object, Object> paramMap1, Map<Object, Object> paramMap2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.INativeNavigateApi
 * JD-Core Version:    0.7.0.1
 */