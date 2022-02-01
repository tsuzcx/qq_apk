package com.tencent.mobileqq.apollo.view.opengl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import javax.microedition.khronos.opengles.GL10;

public class GLThreadManager
{
  private static String a = "[ApolloGL][GLThreadManager]";
  private static volatile int h = 0;
  private static volatile boolean i = false;
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private GLThread g;
  
  @SuppressLint({"UseValueOf"})
  private static Integer a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      label67:
      break label67;
    }
    return Integer.valueOf(paramInt);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      boolean bool = i;
      if (bool) {
        return;
      }
      i = true;
      new Thread(new GLThreadManager.1(paramContext)).start();
      return;
    }
    finally {}
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (h == 0)
      {
        h = a(paramContext, "ro.opengles.version", 0).intValue();
        paramContext = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkGLVersion sGLESVersion:");
        localStringBuilder.append(h);
        QLog.i(paramContext, 1, localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void c()
  {
    if (!this.b)
    {
      this.c = h;
      if (this.c >= 131072) {
        this.e = true;
      }
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkGLESVersion mGLESVersion = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", mMultipleGLESContextsAllowed = ");
      localStringBuilder.append(this.e);
      QLog.w(str, 1, localStringBuilder.toString());
      this.b = true;
    }
  }
  
  public void a(GLThread paramGLThread)
  {
    try
    {
      paramGLThread.a = true;
      if (this.g == paramGLThread) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void a(GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          c();
          paramGL10 = paramGL10.glGetString(7937);
          int j = this.c;
          boolean bool2 = false;
          if (j < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.e = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.e) {
              bool1 = true;
            }
            this.f = bool1;
            String str = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkGLDriver renderer = \"");
            localStringBuilder.append(paramGL10);
            localStringBuilder.append("\" multipleContextsAllowed = ");
            localStringBuilder.append(this.e);
            localStringBuilder.append(" mLimitedGLESContexts = ");
            localStringBuilder.append(this.f);
            QLog.w(str, 1, localStringBuilder.toString());
            this.d = true;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    try
    {
      c();
      boolean bool = this.e;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b(GLThread paramGLThread)
  {
    GLThread localGLThread = this.g;
    if ((localGLThread != paramGLThread) && (localGLThread != null))
    {
      c();
      if (this.e) {
        return true;
      }
      paramGLThread = this.g;
      if (paramGLThread != null) {
        paramGLThread.i();
      }
      return false;
    }
    this.g = paramGLThread;
    notifyAll();
    return true;
  }
  
  public void c(GLThread paramGLThread)
  {
    if (this.g == paramGLThread) {
      this.g = null;
    }
    notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */