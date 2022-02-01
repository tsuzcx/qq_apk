package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkSecureReport
  extends QRouteApi
{
  public static final int RESULT_CHECK = 2;
  public static final int RESULT_INVALID = 1;
  public static final int RESULT_VALID = 0;
  
  public abstract void reportAccumulatedValidURL(String paramString);
  
  public abstract void reportNavigateURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3);
  
  public abstract void reportOpenURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3);
  
  public abstract void reportResourceURLAccess(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkSecureReport
 * JD-Core Version:    0.7.0.1
 */