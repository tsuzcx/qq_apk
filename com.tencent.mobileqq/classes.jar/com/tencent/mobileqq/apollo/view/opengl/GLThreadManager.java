package com.tencent.mobileqq.apollo.view.opengl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class GLThreadManager
{
  private static String jdField_a_of_type_JavaLangString = "GLThreadManager";
  private static volatile int jdField_b_of_type_Int;
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
    catch (Exception paramContext) {}
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
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:e	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 21	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:e	Z
    //   19: new 92	java/lang/Thread
    //   22: dup
    //   23: new 94	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager$1
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 96	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager$1:<init>	(Landroid/content/Context;)V
    //   31: invokespecial 99	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   34: invokevirtual 102	java/lang/Thread:start	()V
    //   37: goto -26 -> 11
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	40	finally
    //   15	37	40	finally
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (jdField_b_of_type_Int == 0)
      {
        jdField_b_of_type_Int = a(paramContext, "ro.opengles.version", 0).intValue();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkGLVersion sGLESVersion:" + jdField_b_of_type_Int);
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
      Log.i("GLThread", "exiting tid=" + paramGLThread.getId());
      paramGLThread.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread == paramGLThread) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 160	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:jdField_b_of_type_Boolean	Z
    //   8: ifne +65 -> 73
    //   11: aload_0
    //   12: invokespecial 162	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	()V
    //   15: aload_1
    //   16: sipush 7937
    //   19: invokeinterface 168 2 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 86	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:jdField_a_of_type_Int	I
    //   29: ldc 87
    //   31: if_icmpge +23 -> 54
    //   34: aload_1
    //   35: ldc 170
    //   37: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifne +36 -> 76
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 89	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:c	Z
    //   50: aload_0
    //   51: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   54: aload_0
    //   55: getfield 89	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:c	Z
    //   58: ifne +23 -> 81
    //   61: iload_3
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 176	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:d	Z
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 160	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:jdField_b_of_type_Boolean	Z
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -33 -> 45
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GLThreadManager
    //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   44	39	2	bool1	boolean
    //   1	61	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	43	86	finally
    //   45	54	86	finally
    //   54	61	86	finally
    //   63	73	86	finally
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
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread == paramGLThread) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread = paramGLThread;
      notifyAll();
    }
    do
    {
      return true;
      a();
    } while (this.c);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread.g();
    }
    return false;
  }
  
  public void b(GLThread paramGLThread)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread == paramGLThread) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThread = null;
    }
    notifyAll();
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 162	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	()V
    //   6: aload_0
    //   7: getfield 89	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:c	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne +9 -> 21
    //   15: iconst_1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	GLThreadManager
    //   10	13	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */