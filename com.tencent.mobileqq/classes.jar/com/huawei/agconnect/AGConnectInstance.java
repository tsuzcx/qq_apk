package com.huawei.agconnect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.core.a.a;

public abstract class AGConnectInstance
{
  @SuppressLint({"StaticFieldLeak"})
  private static AGConnectInstance INSTANCE;
  
  public static AGConnectInstance getInstance()
  {
    return INSTANCE;
  }
  
  public static void initialize(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      try
      {
        Log.i("AGConnectInstance", "AGConnectInstance#initialize");
        localContext = paramContext.getApplicationContext();
        if (localContext == null)
        {
          if (INSTANCE == null) {
            INSTANCE = new a(paramContext);
          }
          return;
        }
      }
      finally {}
      paramContext = localContext;
    }
  }
  
  public abstract Context getContext();
  
  public abstract <T> T getService(Class<? super T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.AGConnectInstance
 * JD-Core Version:    0.7.0.1
 */