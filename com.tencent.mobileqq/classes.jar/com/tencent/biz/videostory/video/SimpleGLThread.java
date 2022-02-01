package com.tencent.biz.videostory.video;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.TMG.utils.QLog;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;

@TargetApi(18)
public class SimpleGLThread
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EglCore jdField_a_of_type_ComTencentTtpicBaseutilsGlesEglCore;
  private OffscreenSurface jdField_a_of_type_ComTencentTtpicBaseutilsGlesOffscreenSurface;
  
  public SimpleGLThread(EGLContext paramEGLContext, String paramString)
  {
    paramString = new HandlerThread(paramString, 9);
    paramString.start();
    while (!paramString.isAlive()) {}
    QLog.i("SimpleGLThread", 2, "create SimpleGLThread");
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new SimpleGLThread.1(this, paramEGLContext));
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new SimpleGLThread.3(this));
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    localObject = new Object();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runJobSync: sync obj+");
    localStringBuilder.append(localObject.hashCode());
    QLog.d("SimpleGLThread", 3, localStringBuilder.toString());
    label103:
    try
    {
      a(paramRunnable);
      a(new SimpleGLThread.2(this, localObject));
    }
    finally {}
    try
    {
      localObject.wait();
      paramRunnable = new StringBuilder();
      paramRunnable.append("runJobSync: job done+");
      paramRunnable.append(localObject.hashCode());
      QLog.d("SimpleGLThread", 3, paramRunnable.toString());
    }
    catch (InterruptedException paramRunnable)
    {
      break label103;
    }
    QLog.w("SimpleGLThread", 0, "runJobSync: interrupted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread
 * JD-Core Version:    0.7.0.1
 */