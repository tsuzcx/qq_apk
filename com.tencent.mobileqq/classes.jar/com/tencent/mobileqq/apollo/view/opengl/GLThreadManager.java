package com.tencent.mobileqq.apollo.view.opengl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import javax.microedition.khronos.opengles.GL10;

public class GLThreadManager
{
  private static String jdField_a_of_type_JavaLangString = "[ApolloGL][GLThreadManager]";
  private static volatile int jdField_b_of_type_Int = 0;
  private static volatile boolean e = false;
  private int jdField_a_of_type_Int;
  private GLThread jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
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
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int >= 131072) {
        this.c = true;
      }
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkGLESVersion mGLESVersion = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", mMultipleGLESContextsAllowed = ");
      localStringBuilder.append(this.c);
      QLog.w(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      boolean bool = e;
      if (bool) {
        return;
      }
      e = true;
      new Thread(new GLThreadManager.1(paramContext)).start();
      return;
    }
    finally {}
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (jdField_b_of_type_Int == 0)
      {
        jdField_b_of_type_Int = a(paramContext, "ro.opengles.version", 0).intValue();
        paramContext = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkGLVersion sGLESVersion:");
        localStringBuilder.append(jdField_b_of_type_Int);
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
  
  public void a(GLThread paramGLThread)
  {
    try
    {
      paramGLThread.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread == paramGLThread) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread = null;
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
        if (!this.jdField_b_of_type_Boolean)
        {
          a();
          paramGL10 = paramGL10.glGetString(7937);
          int i = this.jdField_a_of_type_Int;
          boolean bool2 = false;
          if (i < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.c = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.c) {
              bool1 = true;
            }
            this.d = bool1;
            String str = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkGLDriver renderer = \"");
            localStringBuilder.append(paramGL10);
            localStringBuilder.append("\" multipleContextsAllowed = ");
            localStringBuilder.append(this.c);
            localStringBuilder.append(" mLimitedGLESContexts = ");
            localStringBuilder.append(this.d);
            QLog.w(str, 1, localStringBuilder.toString());
            this.jdField_b_of_type_Boolean = true;
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
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(GLThread paramGLThread)
  {
    GLThread localGLThread = this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread;
    if ((localGLThread != paramGLThread) && (localGLThread != null))
    {
      a();
      if (this.c) {
        return true;
      }
      paramGLThread = this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread;
      if (paramGLThread != null) {
        paramGLThread.g();
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread = paramGLThread;
    notifyAll();
    return true;
  }
  
  public void b(GLThread paramGLThread)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread == paramGLThread) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread = null;
    }
    notifyAll();
  }
  
  public boolean b()
  {
    try
    {
      a();
      boolean bool = this.c;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */