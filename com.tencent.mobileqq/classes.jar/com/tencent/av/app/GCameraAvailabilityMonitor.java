package com.tencent.av.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.utils.ClassLoaderUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class GCameraAvailabilityMonitor
{
  private VideoAppInterface a;
  private Map<String, Integer> b = null;
  private GCameraAvailabilityMonitor.CameraAvailabilityReceiver c = null;
  private Object d = null;
  
  public GCameraAvailabilityMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.b;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.b.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    DexClassLoader localDexClassLoader = ClassLoaderUtil.a();
    if (this.b == null) {
      this.b = new HashMap();
    }
    Object localObject;
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change receiver");
      }
      this.c = new GCameraAvailabilityMonitor.CameraAvailabilityReceiver(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qav.camera.availability");
      this.a.getApplication().registerReceiver(this.c, (IntentFilter)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change callback");
    }
    if ((!Build.VERSION.RELEASE.equalsIgnoreCase("7.1.2")) && (!Build.MODEL.equalsIgnoreCase("vivo x9")))
    {
      this.d = ClassLoaderUtil.a(localDexClassLoader, "com.tencent.av.camera2.CameraManagerWrapper");
      localObject = this.d;
      Context localContext = this.a.getApplication().getApplicationContext();
      String str = this.a.getApplication().getPackageName();
      ClassLoaderUtil.a(localDexClassLoader, localObject, "registerAvailabilityCb", new Class[] { Context.class, String.class, Handler.class }, new Object[] { localContext, str, null });
    }
  }
  
  public void c()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (this.c != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change receiver");
      }
      try
      {
        this.a.getApplication().unregisterReceiver(this.c);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("regist e = ");
          localStringBuilder.append(localException);
          QLog.e("GCameraAvailabilityMonitor", 2, localStringBuilder.toString());
        }
      }
      this.c = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change callback");
    }
    if (this.d != null) {
      ClassLoaderUtil.a(ClassLoaderUtil.a(), this.d, "unRegisterAvailabilityCb", null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GCameraAvailabilityMonitor
 * JD-Core Version:    0.7.0.1
 */