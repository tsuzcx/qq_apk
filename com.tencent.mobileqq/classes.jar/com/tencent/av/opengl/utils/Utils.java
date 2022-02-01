package com.tencent.av.opengl.utils;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.qphone.base.util.QLog;

public class Utils
{
  public static final boolean A;
  public static final boolean B;
  public static final boolean C;
  public static final boolean D;
  public static final boolean E;
  public static final boolean F;
  public static final boolean G;
  public static final boolean H;
  public static final boolean I;
  public static final boolean J;
  public static final boolean K;
  public static final boolean L;
  public static final boolean M;
  public static final boolean N;
  public static final boolean O;
  public static final boolean P;
  public static final boolean Q;
  public static final boolean R;
  public static final boolean S;
  public static final boolean T;
  static int a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static final boolean f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;
  public static final boolean j;
  public static final boolean k;
  public static final boolean l;
  public static final boolean m;
  public static final boolean n;
  public static final boolean o;
  public static final boolean p;
  public static final boolean q;
  public static final boolean r;
  public static final boolean s;
  public static final boolean t;
  public static final boolean u;
  public static final boolean v;
  public static final boolean w;
  public static final boolean x;
  public static final boolean y;
  public static final boolean z;
  
  static
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    if (i1 >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    b = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    c = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    d = bool1;
    e = a(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
    f = a(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION");
    g = a(MediaStore.MediaColumns.class, "WIDTH");
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    h = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    i = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    j = bool1;
    k = a("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
    l = a("android.graphics.SurfaceTexture", "release", new Class[0]);
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    m = bool1;
    if (Build.VERSION.SDK_INT >= 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    n = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    o = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    p = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    q = bool1;
    r = a(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
    try
    {
      if ((a(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) && (a(Camera.class, "startFaceDetection", new Class[0])) && (a(Camera.class, "stopFaceDetection", new Class[0])))
      {
        bool1 = a(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        if (bool1) {
          bool1 = true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label374:
      break label374;
    }
    boolean bool1 = false;
    s = bool1;
    t = a(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    u = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    v = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    w = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    x = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    y = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    z = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    A = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    B = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    C = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    D = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    E = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    F = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    G = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    H = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    I = bool1;
    if (Build.VERSION.SDK_INT >= 14) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    J = bool1;
    if (Build.VERSION.SDK_INT >= 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    K = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    L = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    M = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    N = bool1;
    if (Build.VERSION.SDK_INT >= 11) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    O = bool1;
    P = a(WindowManager.LayoutParams.class, "rotationAnimation");
    if (Build.VERSION.SDK_INT >= 18) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Q = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    R = bool1;
    if (Build.VERSION.SDK_INT >= 18) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    S = bool1;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    T = bool1;
  }
  
  public static int a()
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkError error = ");
        localStringBuilder.append(i1);
        QLog.d("Utils", 2, localStringBuilder.toString());
      }
      SmallScreenUtils.a();
    }
    return i1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static int a(Context paramContext)
  {
    if (a == 0) {}
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
      if (paramContext == null)
      {
        a = 1;
        break label57;
      }
      if (paramContext.reqGlEsVersion < 131072) {
        break label65;
      }
      i1 = 2;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        continue;
        int i1 = 1;
      }
    }
    a = i1;
    break label57;
    a = 1;
    label57:
    return a;
  }
  
  private static boolean a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass)
    {
      label8:
      break label8;
    }
    return false;
  }
  
  private static boolean a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private static boolean a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1)
    {
      label12:
      break label12;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.utils.Utils
 * JD-Core Version:    0.7.0.1
 */