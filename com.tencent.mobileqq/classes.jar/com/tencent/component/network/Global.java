package com.tencent.component.network;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkState;

public class Global
{
  public static final String SDK_VERSION = "${env.NumberVersion}";
  private static Context sContext;
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static void init(Context paramContext)
  {
    sContext = paramContext;
    try
    {
      NetworkManager.init(getContext());
      NetworkState.g().setContext(getContext());
      return;
    }
    catch (Throwable paramContext)
    {
      QDLog.e("downloader", "", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.Global
 * JD-Core Version:    0.7.0.1
 */