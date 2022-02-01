package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory
{
  private static final String TAG = "MicroMsg.PaySdk.WXFactory";
  
  private WXAPIFactory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" should not be instantiated");
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString)
  {
    return createWXAPI(paramContext, paramString, true);
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("createWXAPI, appId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", checkSignature = ");
    localStringBuilder.append(paramBoolean);
    Log.d("MicroMsg.PaySdk.WXFactory", localStringBuilder.toString());
    return new WXApiImplV10(paramContext, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.WXAPIFactory
 * JD-Core Version:    0.7.0.1
 */