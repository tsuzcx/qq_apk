package com.tencent.luggage.wxaapi;

import android.content.Context;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.fq.g;

public final class WxaApi$Factory
{
  public static final int TYPE_ABI_ARM_32 = 1;
  public static final int TYPE_ABI_ARM_64 = 2;
  private static WxaApi wxaApi;
  
  @UiThread
  public static WxaApi createApi(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getClass();
    paramString.getClass();
    Context localContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (wxaApi == null) {
      wxaApi = new g(localContext, paramString, paramInt);
    }
    return wxaApi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.WxaApi.Factory
 * JD-Core Version:    0.7.0.1
 */