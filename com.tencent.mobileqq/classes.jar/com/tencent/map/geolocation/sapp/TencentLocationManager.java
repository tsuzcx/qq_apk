package com.tencent.map.geolocation.sapp;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.q;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  public static final boolean DEBUG = false;
  public static final String TAG = "TencentLocationManager";
  public static final String TYPE_OAID = "oaId";
  public static final String TYPE_QIMEI = "qImei";
  public static Context mContext;
  public static Pair<String, String> mPair;
  public static Class mProxyClass;
  public static Object mProxyObj;
  public static TencentLocationManager sInstance;
  public int mInitStatus;
  public final byte[] mLock;
  
  public TencentLocationManager(Context paramContext, Pair<String, String> paramPair)
  {
    int i = 0;
    this.mLock = new byte[0];
    this.mInitStatus = 0;
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
      try
      {
        System.loadLibrary("tencentlocsapp");
      }
      catch (Throwable paramContext)
      {
        j.a("libtencentloc", paramContext);
        this.mInitStatus = 3;
        return;
      }
    }
    mContext = paramContext;
    e.a(paramContext).c();
    while (i < 3)
    {
      if (paramPair == null)
      {
        Pair localPair = mPair;
        if (localPair != null)
        {
          bool = a(paramContext, localPair, i);
          break label97;
        }
      }
      boolean bool = a(paramContext, paramPair, i);
      label97:
      if (bool) {
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(Context paramContext, Pair<String, String> paramPair, int paramInt)
  {
    if (paramInt > 0)
    {
      q.a(q.d(paramContext));
      q.a(q.i(paramContext));
      q.a();
      f.a(paramContext).c();
    }
    Object localObject = f.a(paramContext);
    try
    {
      localObject = ((f)localObject).a();
      if (localObject == null)
      {
        paramContext = new StringBuilder();
        paramContext.append("class loader is null,");
        paramContext.append(paramInt);
        j.a(paramContext.toString());
        paramContext = e.b();
        paramContext.a("LMI", "41");
        this.mInitStatus = 4;
        return false;
      }
      mProxyClass = ((DexClassLoader)localObject).loadClass("com.tencent.map.geolocation.sapp.proxy.TencentLocationManagerProxy");
      if (paramPair != null) {
        mProxyObj = mProxyClass.getConstructor(new Class[] { Context.class, Pair.class }).newInstance(new Object[] { paramContext, paramPair });
      } else {
        mProxyObj = mProxyClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      }
      if (mProxyObj == null)
      {
        this.mInitStatus = 4;
        paramContext = new StringBuilder();
        paramContext.append("Mgr init failed,");
        paramContext.append(paramInt);
        j.a(paramContext.toString());
        paramContext = e.b();
        paramPair = new StringBuilder();
        paramPair.append("42,");
        paramPair.append(paramInt);
        paramContext.a("LMI", paramPair.toString());
        return false;
      }
      paramContext = e.b();
      paramPair = new StringBuilder();
      paramPair.append("0,");
      paramPair.append(paramInt);
      paramContext.a("LMI", paramPair.toString());
      return true;
    }
    catch (Throwable paramContext)
    {
      this.mInitStatus = 5;
      j.a("initLocManager", paramContext);
      paramPair = e.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("5");
      ((StringBuilder)localObject).append(paramContext.toString());
      paramPair.a("LMI", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        if (paramContext != null)
        {
          if (paramContext.getApplicationContext() != null)
          {
            System.currentTimeMillis();
            sInstance = new TencentLocationManager(paramContext.getApplicationContext(), null);
          }
          else
          {
            throw new NullPointerException("application context is null");
          }
        }
        else {
          throw new NullPointerException("context is null");
        }
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  public static TencentLocationManager getInstance(Context paramContext, Pair<String, String> paramPair)
  {
    try
    {
      if (sInstance == null) {
        if (paramContext != null)
        {
          if (paramContext.getApplicationContext() != null)
          {
            System.currentTimeMillis();
            sInstance = new TencentLocationManager(paramContext.getApplicationContext(), paramPair);
          }
          else
          {
            throw new NullPointerException("application context is null");
          }
        }
        else {
          throw new NullPointerException("context is null");
        }
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean isOtherIdIllegal(String paramString)
  {
    return paramString.matches("^[a-z0-9A-Z]{6,32}$");
  }
  
  public static void setDeviceID(Pair<String, String> paramPair)
  {
    if (paramPair != null) {
      if ((!((String)paramPair.first).equals("qImei")) && (!((String)paramPair.first).equals("oaId")) && (!isOtherIdIllegal((String)paramPair.first))) {
        throw new IllegalArgumentException("your deviceID is illegal!");
      }
    }
    try
    {
      if (mContext != null)
      {
        Object localObject = mProxyClass;
        if (localObject != null)
        {
          localObject = mProxyClass;
          localObject = ((Class)localObject).getDeclaredMethod("uploadLimeiInfo", new Class[] { Context.class, Pair.class });
          ((Method)localObject).setAccessible(true);
          if (mProxyObj != null) {
            ((Method)localObject).invoke(mProxyObj, new Object[] { mContext, paramPair });
          }
        }
      }
      else
      {
        mPair = paramPair;
      }
      return;
    }
    catch (Throwable|Exception paramPair) {}
    throw new IllegalArgumentException("deviceID is null!");
  }
  
  public String getBuild()
  {
    try
    {
      Object localObject = mProxyClass;
      localObject = (String)((Class)localObject).getDeclaredMethod("getBuild", new Class[0]).invoke(mProxyObj, new Object[0]);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "error";
  }
  
  public int getCoordinateType()
  {
    try
    {
      Class localClass = mProxyClass;
      int i = ((Integer)localClass.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(mProxyObj, new Object[0])).intValue();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1;
  }
  
  public TencentLocation getLastKnownLocation()
  {
    try
    {
      Object localObject = mProxyClass;
      localObject = (TencentLocation)((Class)localObject).getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(mProxyObj, new Object[0]);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public String getVersion()
  {
    try
    {
      Object localObject = mProxyClass;
      localObject = (String)((Class)localObject).getDeclaredMethod("getVersion", new Class[0]).invoke(mProxyObj, new Object[0]);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "error";
  }
  
  public void removeUpdates(TencentLocationListener paramTencentLocationListener)
  {
    try
    {
      synchronized (this.mLock)
      {
        Class localClass = mProxyClass;
        localClass.getDeclaredMethod("removeUpdates", new Class[] { TencentLocationListener.class }).invoke(mProxyObj, new Object[] { paramTencentLocationListener });
        e.b().d();
      }
    }
    catch (Throwable paramTencentLocationListener)
    {
      paramTencentLocationListener.printStackTrace();
      return;
    }
  }
  
  public int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    int i = this.mInitStatus;
    if (i > 0) {
      return i;
    }
    try
    {
      Class localClass = mProxyClass;
      i = ((Integer)localClass.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener })).intValue();
      return i;
    }
    catch (Throwable paramTencentLocationRequest)
    {
      j.a("reqLocUpdates error. ", paramTencentLocationRequest);
    }
    return 5;
  }
  
  public int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    System.currentTimeMillis();
    int i;
    if (paramTencentLocationRequest != null) {
      if (paramTencentLocationListener != null) {
        if (paramLooper != null)
        {
          i = this.mInitStatus;
          if (i > 0) {
            return i;
          }
        }
      }
    }
    synchronized (this.mLock)
    {
      try
      {
        Class localClass = mProxyClass;
        paramTencentLocationRequest = (Integer)localClass.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper });
        paramTencentLocationListener = e.b();
        paramTencentLocationListener.a("RLU", paramTencentLocationRequest.toString());
        i = paramTencentLocationRequest.intValue();
        return i;
      }
      catch (Throwable paramTencentLocationRequest)
      {
        paramTencentLocationRequest.printStackTrace();
        paramTencentLocationListener = e.b();
        paramLooper = new StringBuilder();
        paramLooper.append("5,");
        paramLooper.append(paramTencentLocationRequest.toString());
        paramTencentLocationListener.a("RLU", paramLooper.toString());
        j.a("reqLocUpdates looper error. ", paramTencentLocationRequest);
        return 5;
      }
      throw paramTencentLocationRequest;
      throw new NullPointerException("looper is null");
      throw new NullPointerException("listener is null");
      throw new NullPointerException("request is null");
    }
  }
  
  public int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    return requestSingleFreshLocation(paramTencentLocationRequest, paramTencentLocationListener, paramLooper, false);
  }
  
  public int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper, boolean paramBoolean)
  {
    int i;
    if (paramTencentLocationListener != null) {
      if (paramLooper != null)
      {
        i = this.mInitStatus;
        if (i > 0) {
          return i;
        }
      }
    }
    synchronized (this.mLock)
    {
      try
      {
        Class localClass = mProxyClass;
        i = ((Integer)localClass.getDeclaredMethod("requestSingleFreshLocation", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class, Boolean.TYPE }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper, Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Throwable paramTencentLocationRequest)
      {
        paramTencentLocationRequest.printStackTrace();
        j.a("reqSigLoc error. ", paramTencentLocationRequest);
        return 5;
      }
      throw paramTencentLocationRequest;
      throw new NullPointerException("looper is null");
      throw new NullPointerException("listener is null");
    }
  }
  
  public void setCoordinateType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0)) {}
    try
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("unknown coordinate type: ");
      ((StringBuilder)???).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)???).toString());
    }
    catch (Exception localException)
    {
      Class localClass;
      label99:
      localException.printStackTrace();
      return;
    }
    try
    {
      synchronized (this.mLock)
      {
        localClass = mProxyClass;
        localClass.getDeclaredMethod("setCoordinateType", new Class[] { Integer.TYPE }).invoke(mProxyObj, new Object[] { Integer.valueOf(paramInt) });
      }
    }
    catch (Throwable localThrowable)
    {
      break label99;
    }
    return;
    throw localObject2;
  }
  
  public boolean startIndoorLocation()
  {
    try
    {
      Class localClass = mProxyClass;
      boolean bool = ((Boolean)localClass.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean stopIndoorLocation()
  {
    try
    {
      Class localClass = mProxyClass;
      boolean bool = ((Boolean)localClass.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */