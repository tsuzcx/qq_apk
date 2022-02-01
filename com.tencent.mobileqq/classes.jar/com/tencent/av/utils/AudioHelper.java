package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.utils.api.IAudioHelperApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;

public class AudioHelper
{
  static final int[] a;
  public static boolean b = false;
  static String c;
  public static boolean d = false;
  public static boolean e = false;
  static boolean f = false;
  static String g = null;
  private static boolean h = false;
  private static int i = 0;
  private static boolean j = false;
  private static boolean k = false;
  private static final int[] l = { 35, 36 };
  private static final int[] m = { 26, 27 };
  private static long n;
  
  static
  {
    a = new int[39];
    b = false;
    n = 0L;
    c = "actAVFunChatExpression";
    d = false;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      bool = true;
    } else {
      bool = false;
    }
    e = bool;
  }
  
  public static int a(int paramInt)
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).getDebugValue(paramInt);
  }
  
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    try
    {
      long l1 = ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).enlargeVolumWrapper(paramContext, paramArrayOfByte, paramInt, paramFloat);
      return l1;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String a(Resources paramResources, int paramInt)
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).getResIDName(paramResources, paramInt);
  }
  
  public static String a(View paramView, int paramInt)
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).getResIDName(paramView, paramInt);
  }
  
  public static String a(Object paramObject)
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).getLogString(paramObject);
  }
  
  public static void a(Context paramContext)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).setBeaconDebug(paramContext);
  }
  
  public static void a(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).changButtonStyle(paramResources, paramTextView, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).syncPrintBaseInfo(paramAppInterface);
  }
  
  public static final void a(String paramString)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).writeTestLog(paramString);
  }
  
  public static void a(String paramString, Intent paramIntent)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).print(paramString, paramIntent);
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).print(paramString, paramBundle);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).print(paramString, paramBundle, paramBoolean);
  }
  
  public static <T1, T2> void a(String paramString, Map<T1, T2> paramMap, boolean paramBoolean)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).print(paramString, paramMap, paramBoolean);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).reportExp(paramString, paramBoolean);
  }
  
  public static boolean a()
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).isDev();
  }
  
  public static boolean a(BaseApplication paramBaseApplication, long paramLong)
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).registDebugReceiver(paramBaseApplication, paramLong);
  }
  
  public static long b()
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).getServerMSTime();
  }
  
  @TargetApi(17)
  public static void b(String paramString)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).printTime(paramString);
  }
  
  public static long c()
  {
    try
    {
      long l1 = ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).genDebugSeq();
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static long c(String paramString)
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).stringToLong(paramString);
  }
  
  @TargetApi(17)
  public static long d()
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).elapsedRealtimeNanos();
  }
  
  public static void d(String paramString)
  {
    ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).showDebugToast(paramString);
  }
  
  public static boolean e()
  {
    return ((IAudioHelperApi)QRoute.api(IAudioHelperApi.class)).isLogColorOrGary();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */