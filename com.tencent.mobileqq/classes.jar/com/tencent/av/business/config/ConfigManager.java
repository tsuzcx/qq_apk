package com.tencent.av.business.config;

import android.content.Context;
import com.tencent.av.config.api.IConfigManager;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ConfigManager
{
  private static IConfigManager a;
  
  private ConfigManager()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("AVConfigManager", 1, "构造", new Throwable("打印调用栈"));
    }
  }
  
  public static IConfigManager a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = (IConfigManager)QRoute.api(IConfigManager.class);
          a.onCreate(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void b(Context paramContext)
  {
    if (a != null) {
      try
      {
        if (a != null)
        {
          a.onDestroy(paramContext);
          a = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public static IConfigParser c(Context paramContext)
  {
    return a(paramContext).getConfigParser(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */