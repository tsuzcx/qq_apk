package com.tencent.mobileqq.apollo.utils;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;

public class CmShowCECapabilitiesChecker
{
  private static String a;
  private static String b;
  private static volatile boolean c = false;
  private static SimpleGLThread d;
  private static boolean e;
  
  public static void a()
  {
    try
    {
      if ((!c) && (d == null))
      {
        d = new SimpleGLThread((EGLContext)null, "CmShowCECapabilitiesChecker");
        d.postJob(new CmShowCECapabilitiesChecker.1());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    g();
    return e;
  }
  
  private static void e()
  {
    Object localObject = GLES20.glGetString(7937);
    String str = GLES20.glGetString(7936);
    b = GLES20.glGetString(7938);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    localStringBuilder.append(str);
    localStringBuilder.append("; ");
    localStringBuilder.append(b);
    a = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gpuInfo=");
    ((StringBuilder)localObject).append(a);
    QLog.i("[cmshow]CmShowCECapabilitiesChecker [CrossEngine]", 1, ((StringBuilder)localObject).toString());
  }
  
  private static void f()
  {
    String str = GLES20.glGetString(7939);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL_EXTENSIONS=");
    ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = true;
    QLog.i("[cmshow]CmShowCECapabilitiesChecker [CrossEngine]", 1, (String)localObject);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    boolean bool1 = bool2;
    if (!str.contains("GL_KHR_texture_compression_astc_ldr"))
    {
      bool1 = bool2;
      if (!str.contains("GL_KHR_texture_compression_astc_hdr")) {
        if (str.contains("GL_OES_texture_compression_astc")) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    e = bool1;
  }
  
  private static void g()
  {
    if (!c)
    {
      SimpleGLThread localSimpleGLThread = d;
      if (localSimpleGLThread != null)
      {
        localSimpleGLThread.waitDone(200);
        if (!c) {
          h();
        }
      }
      else
      {
        h();
      }
    }
  }
  
  private static void h()
  {
    QLog.e("[cmshow]CmShowCECapabilitiesChecker [CrossEngine]", 1, "useInWrongTime", new IllegalStateException("must call init method first"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.CmShowCECapabilitiesChecker
 * JD-Core Version:    0.7.0.1
 */