package com.tencent.map.geolocation.sapp.internal;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class TencentExtraKeys
{
  public static final boolean ALLOW_NLP_LOCATION = true;
  public static final boolean DIDI_INTERNAL = false;
  public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
  public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
  public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
  public static final String LOCATION_KEY_LOCALITY = "locality";
  public static final String LOCATION_KEY_NATION = "nation";
  public static final String LOCATION_KEY_ROUTE = "route";
  public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
  public static final String LOCATION_SOURCE_CELL = "cell";
  public static final String LOCATION_SOURCE_GPS = "gps";
  public static final String LOCATION_SOURCE_WIFI = "wifi";
  public static final String RAW_DATA = "raw_data";
  public static final String REQUEST_RAW_DATA = "request_raw_data";
  public static final boolean STRICT_CELL_FILTER = true;
  public static final String TAG = "TencentExtraKeys";
  public static final boolean TENCENT_INTERNAL = true;
  public static Context mContext;
  public static DexClassLoader mLoader;
  public static Object mProxyObj;
  public static Class mProxyclass;
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      q.a(q.d(paramContext));
      q.a(q.i(paramContext));
      q.a();
      f.a(paramContext).c();
      paramContext = f.a(paramContext).a();
      if (paramContext == null)
      {
        j.a("EKS,loader is null");
        paramContext = e.b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init error 2,");
        ((StringBuilder)localObject).append(paramInt);
        paramContext.a("EKS", ((StringBuilder)localObject).toString());
        return false;
      }
      if (mProxyclass != null)
      {
        localObject = mProxyObj;
        if (localObject != null) {}
      }
      else
      {
        mProxyclass = paramContext.loadClass("com.tencent.map.geolocation.sapp.proxy.TencentExtraKeysProxy");
        mProxyObj = mProxyclass.newInstance();
      }
      paramContext = e.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init ok 0,");
      ((StringBuilder)localObject).append(paramInt);
      paramContext.a("EKS", ((StringBuilder)localObject).toString());
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      Object localObject = e.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init error 3,");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(paramContext.toString());
      ((e)localObject).a("EKS", localStringBuilder.toString());
    }
    return false;
  }
  
  public static void enableMockLocationFilter(boolean paramBoolean)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("enableMockLocationFilter", new Class[] { Boolean.TYPE }).invoke(mProxyObj, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      throw new Exception(localThrowable.toString());
    }
  }
  
  public static String getLocationSource(TencentLocation paramTencentLocation)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return (String)localClass.getDeclaredMethod("getLocationSource", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  /* Error */
  public static File getLogDir()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 161	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:initProxy	()Z
    //   6: ifeq +36 -> 42
    //   9: getstatic 129	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyclass	Ljava/lang/Class;
    //   12: astore_0
    //   13: aload_0
    //   14: ldc 197
    //   16: iconst_0
    //   17: anewarray 141	java/lang/Class
    //   20: invokevirtual 171	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   23: getstatic 131	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyObj	Ljava/lang/Object;
    //   26: iconst_0
    //   27: anewarray 4	java/lang/Object
    //   30: invokevirtual 181	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 199	java/io/File
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: new 183	java/lang/Exception
    //   45: dup
    //   46: ldc 185
    //   48: invokespecial 187	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore_0
    //   53: goto +20 -> 73
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 150	java/lang/Throwable:printStackTrace	()V
    //   61: new 183	java/lang/Exception
    //   64: dup
    //   65: aload_0
    //   66: invokevirtual 155	java/lang/Throwable:toString	()Ljava/lang/String;
    //   69: invokespecial 187	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	29	0	localObject1	Object
    //   52	1	0	localObject2	Object
    //   56	21	0	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	13	52	finally
    //   13	37	52	finally
    //   42	52	52	finally
    //   57	73	52	finally
    //   3	13	56	java/lang/Throwable
    //   13	37	56	java/lang/Throwable
    //   42	52	56	java/lang/Throwable
  }
  
  public static byte[] getRawData(TencentLocation paramTencentLocation)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return (byte[])localClass.getDeclaredMethod("getRawData", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  public static Location getRawGps(TencentLocation paramTencentLocation)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return (Location)localClass.getDeclaredMethod("getRawGps", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  public static String getRawQuery(TencentLocation paramTencentLocation)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return (String)localClass.getDeclaredMethod("getRawQuery", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  public static boolean initProxy()
  {
    if (mContext == null) {
      return false;
    }
    int i = 0;
    while (i < 3)
    {
      if (a(mContext, i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isAllowedLevel(int paramInt)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return ((Boolean)localClass.getDeclaredMethod("isAllowedLevel", new Class[] { Integer.TYPE }).invoke(mProxyObj, new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      throw new Exception(localThrowable.toString());
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean isDebugEnabled()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 161	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:initProxy	()Z
    //   6: ifeq +39 -> 45
    //   9: getstatic 129	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyclass	Ljava/lang/Class;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 230
    //   16: iconst_0
    //   17: anewarray 141	java/lang/Class
    //   20: invokevirtual 171	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   23: getstatic 131	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyObj	Ljava/lang/Object;
    //   26: iconst_0
    //   27: anewarray 4	java/lang/Object
    //   30: invokevirtual 181	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 164	java/lang/Boolean
    //   36: invokevirtual 227	java/lang/Boolean:booleanValue	()Z
    //   39: istore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: iload_0
    //   44: ireturn
    //   45: new 183	java/lang/Exception
    //   48: dup
    //   49: ldc 185
    //   51: invokespecial 187	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   54: athrow
    //   55: astore_1
    //   56: goto +20 -> 76
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 150	java/lang/Throwable:printStackTrace	()V
    //   64: new 183	java/lang/Exception
    //   67: dup
    //   68: aload_1
    //   69: invokevirtual 155	java/lang/Throwable:toString	()Ljava/lang/String;
    //   72: invokespecial 187	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: ldc 2
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	5	0	bool	boolean
    //   12	2	1	localClass	Class
    //   55	1	1	localObject	Object
    //   59	21	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	13	55	finally
    //   13	40	55	finally
    //   45	55	55	finally
    //   60	76	55	finally
    //   3	13	59	java/lang/Throwable
    //   13	40	59	java/lang/Throwable
    //   45	55	59	java/lang/Throwable
  }
  
  public static int isInsIllegalApp(Context paramContext)
  {
    try
    {
      mContext = paramContext;
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return ((Integer)localClass.getDeclaredMethod("isInsIllegalApp", new Class[] { Context.class }).invoke(mProxyObj, new Object[] { paramContext })).intValue();
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      throw new Exception(paramContext.toString());
    }
  }
  
  public static boolean isRequestRawData(TencentLocationRequest paramTencentLocationRequest)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return ((Boolean)localClass.getDeclaredMethod("isRequestRawData", new Class[] { TencentLocationRequest.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest })).booleanValue();
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocationRequest)
    {
      paramTencentLocationRequest.printStackTrace();
      throw new Exception(paramTencentLocationRequest.toString());
    }
  }
  
  public static void loadLibrary(String paramString)
  {
    try
    {
      System.load(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      throw new Exception(paramString.toString());
    }
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
    e.a(paramContext).c();
  }
  
  /* Error */
  public static void setLogDir(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 161	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:initProxy	()Z
    //   6: ifeq +42 -> 48
    //   9: getstatic 129	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyclass	Ljava/lang/Class;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc_w 260
    //   17: iconst_1
    //   18: anewarray 141	java/lang/Class
    //   21: dup
    //   22: iconst_0
    //   23: ldc 199
    //   25: aastore
    //   26: invokevirtual 171	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   29: getstatic 131	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyObj	Ljava/lang/Object;
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokevirtual 181	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: new 183	java/lang/Exception
    //   51: dup
    //   52: ldc 185
    //   54: invokespecial 187	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   57: athrow
    //   58: astore_0
    //   59: goto +20 -> 79
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 150	java/lang/Throwable:printStackTrace	()V
    //   67: new 183	java/lang/Exception
    //   70: dup
    //   71: aload_0
    //   72: invokevirtual 155	java/lang/Throwable:toString	()Ljava/lang/String;
    //   75: invokespecial 187	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramFile	File
    //   12	2	1	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   3	13	58	finally
    //   13	44	58	finally
    //   48	58	58	finally
    //   63	79	58	finally
    //   3	13	62	java/lang/Throwable
    //   13	44	62	java/lang/Throwable
    //   48	58	62	java/lang/Throwable
  }
  
  public static TencentLocation setRawData(TencentLocation paramTencentLocation, byte[] paramArrayOfByte)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return (TencentLocation)localClass.getDeclaredMethod("setRawData", new Class[] { TencentLocation.class, [B.class }).invoke(mProxyObj, new Object[] { paramTencentLocation, paramArrayOfByte });
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  public static void setRawGps(TencentLocation paramTencentLocation, Location paramLocation)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setRawGps", new Class[] { TencentLocation.class, Location.class }).invoke(mProxyObj, new Object[] { paramTencentLocation, paramLocation });
        return;
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  public static void setRawQuery(TencentLocation paramTencentLocation, String paramString)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setRawQuery", new Class[] { TencentLocation.class, String.class }).invoke(mProxyObj, new Object[] { paramTencentLocation, paramString });
        return;
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocation)
    {
      paramTencentLocation.printStackTrace();
      throw new Exception(paramTencentLocation.toString());
    }
  }
  
  public static TencentLocationRequest setRequestRawData(TencentLocationRequest paramTencentLocationRequest, boolean paramBoolean)
  {
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return (TencentLocationRequest)localClass.getDeclaredMethod("setRequestRawData", new Class[] { TencentLocationRequest.class, Boolean.TYPE }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, Boolean.valueOf(paramBoolean) });
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramTencentLocationRequest)
    {
      paramTencentLocationRequest.printStackTrace();
      throw new Exception(paramTencentLocationRequest.toString());
    }
  }
  
  public static void setTencentLog(Context paramContext, File paramFile)
  {
    try
    {
      mContext = paramContext;
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setTencentLog", new Class[] { Context.class, File.class }).invoke(mProxyObj, new Object[] { paramContext, paramFile });
        return;
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      throw new Exception(paramContext.toString());
    }
  }
  
  public static void setTencentLogCallback(LocationLogCallback paramLocationLogCallback)
  {
    try
    {
      j.a(paramLocationLogCallback);
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setTencentLogCallback", new Class[] { LocationLogCallback.class }).invoke(mProxyObj, new Object[] { paramLocationLogCallback });
        return;
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramLocationLogCallback)
    {
      paramLocationLogCallback.printStackTrace();
      throw new Exception(paramLocationLogCallback.toString());
    }
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    try
    {
      boolean bool = TencentLocationManagerOptions.isLoadLibraryEnabled();
      if (bool) {
        try
        {
          System.loadLibrary("tencentlocsapp");
        }
        catch (Throwable paramArrayOfDouble1)
        {
          paramArrayOfDouble2 = new StringBuilder();
          paramArrayOfDouble2.append("LOAD:");
          paramArrayOfDouble2.append(paramArrayOfDouble1.toString());
          Log.e("TencentLocationSDK", paramArrayOfDouble2.toString());
          return false;
        }
      }
      if (initProxy())
      {
        Class localClass = mProxyclass;
        return ((Boolean)localClass.getDeclaredMethod("wgs84ToGcj02", new Class[] { [D.class, [D.class }).invoke(mProxyObj, new Object[] { paramArrayOfDouble1, paramArrayOfDouble2 })).booleanValue();
      }
      throw new Exception("proxy is error");
    }
    catch (Throwable paramArrayOfDouble1)
    {
      paramArrayOfDouble1.printStackTrace();
      throw new Exception(paramArrayOfDouble1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.internal.TencentExtraKeys
 * JD-Core Version:    0.7.0.1
 */