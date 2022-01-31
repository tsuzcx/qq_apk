package com.tencent.mobileqq.armap;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARMapTracer$GLHackTask
  implements Runnable
{
  private static int jdField_a_of_type_Int;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static GLHackTask b;
  private GLHackTask jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$GLHackTask;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private WeakReference<ARGLSurfaceView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ARMapTracer$GLHackTask(Runnable paramRunnable, ARGLSurfaceView paramARGLSurfaceView)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$GLHackTask = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramARGLSurfaceView);
  }
  
  public static GLHackTask a(Runnable paramRunnable, ARGLSurfaceView paramARGLSurfaceView)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        GLHackTask localGLHackTask = b;
        b = localGLHackTask.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$GLHackTask;
        localGLHackTask.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$GLHackTask = null;
        localGLHackTask.jdField_a_of_type_JavaLangRunnable = paramRunnable;
        localGLHackTask.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramARGLSurfaceView);
        jdField_a_of_type_Int -= 1;
        return localGLHackTask;
      }
      return new GLHackTask(paramRunnable, paramARGLSurfaceView);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$GLHackTask = b;
        b = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((ARGLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mIsDestroyed)) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    l = SystemClock.elapsedRealtime() - l;
    String str2;
    if ((QLog.isDevelopLevel()) && (l > 33L))
    {
      str2 = GLHackTask.class.getSimpleName();
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        break label122;
      }
    }
    label122:
    for (String str1 = this.jdField_a_of_type_JavaLangRunnable.getClass().getName();; str1 = "default")
    {
      QLog.d(str2, 2, new Object[] { "%s cost: %d", str1, Long.valueOf(l) });
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer.GLHackTask
 * JD-Core Version:    0.7.0.1
 */