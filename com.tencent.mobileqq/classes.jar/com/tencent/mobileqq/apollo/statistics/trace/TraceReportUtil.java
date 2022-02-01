package com.tencent.mobileqq.apollo.statistics.trace;

import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceConfig;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportInterceptor;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;

public class TraceReportUtil
{
  public static int a(int paramInt)
  {
    int i = 3;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3) {}
        }
      }
    }
    while (!CMShowPlatform.a.b(Scene.AIO))
    {
      return 1;
      return 113;
      paramInt = i;
      if (!CMShowPlatform.a.b(Scene.FRIEND_CARD)) {
        break;
      }
      return 154;
      if (CMShowPlatform.a.b(Scene.DRAWER)) {
        return 153;
      }
      return 2;
    }
    paramInt = 152;
    return paramInt;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 10)
              {
                if (paramInt != 20)
                {
                  if (paramInt != 30)
                  {
                    if (paramInt != 40)
                    {
                      if (paramInt != 113)
                      {
                        if (paramInt != 123)
                        {
                          switch (paramInt)
                          {
                          default: 
                            return "";
                          case 154: 
                            return "_sprite_friend_card_crossengine";
                          case 153: 
                            return "_sprite_drawer_crossengine";
                          }
                          return "_sprite_aio_crossengine";
                        }
                        return "_game_center";
                      }
                      return "_sprite_sdk";
                    }
                    return "_apollo_store_sso";
                  }
                  return "_apollo_resource_download";
                }
                return "_apollo_crash";
              }
              return "_apollo_so";
            }
            return "_apollo_view_re_attach";
          }
          return "_sprite_action_fps";
        }
        return "_sprite_friend_card";
      }
      return "_sprite_drawer";
    }
    return "_sprite_aio";
  }
  
  public static void a(int paramInt)
  {
    a(paramInt, "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, null, paramInt2, -100, 0L, 0, 0L, new Object[] { "" });
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, paramInt3, paramLong, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, paramInt3, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    a(paramInt1, null, paramInt2, -100, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, -100, 0L, 0, 0L, new Object[] { "" });
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    TraceReportInterceptor.a(paramInt1, paramString, paramInt2, paramInt3, paramLong1, paramInt4, paramLong2, new Object[] { localStringBuilder.toString() });
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, Object... paramVarArgs)
  {
    a(paramInt1, paramString, paramInt2, -100, 0L, 0, 0L, paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    TraceReportInterceptor.a(paramInt, paramString1, paramString2);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, int... paramVarArgs)
  {
    TraceReportInterceptor.a(paramInt, paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString, int... paramVarArgs)
  {
    a(paramInt, paramString, null, paramVarArgs);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    TraceReportInterceptor.a(paramInt, paramBoolean);
  }
  
  public static void a(TraceConfig paramTraceConfig)
  {
    TraceReportInterceptor.a(paramTraceConfig);
  }
  
  public static void b(int paramInt)
  {
    b(paramInt, null);
  }
  
  public static void b(int paramInt, String paramString)
  {
    TraceReportInterceptor.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil
 * JD-Core Version:    0.7.0.1
 */