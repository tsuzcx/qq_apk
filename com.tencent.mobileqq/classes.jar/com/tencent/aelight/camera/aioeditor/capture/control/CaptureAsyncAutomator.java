package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CaptureAsyncAutomator
  extends Automator
  implements Runnable
{
  private AsyncStep m = null;
  private final LinkedList<AsyncStep> n = new LinkedList();
  private ThreadPoolExecutor o;
  
  public CaptureAsyncAutomator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(AsyncStep paramAsyncStep)
  {
    this.n.add(paramAsyncStep);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWaitingMode_Locked ");
      localStringBuilder.append(paramAsyncStep.mName);
      QLog.d("CaptureAsyncAutomator", 2, localStringBuilder.toString());
    }
  }
  
  private void l()
  {
    this.o = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new CaptureAsyncAutomator.MyThreadFactory(this, null));
    this.o.allowCoreThreadTimeOut(true);
  }
  
  public void a(AsyncStep paramAsyncStep)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start ");
      ((StringBuilder)???).append(paramAsyncStep.mName);
      QLog.d("CaptureAsyncAutomator", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.n)
    {
      if (this.m == null)
      {
        this.m = paramAsyncStep;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run ");
          localStringBuilder.append(paramAsyncStep.mName);
          QLog.d("CaptureAsyncAutomator", 2, localStringBuilder.toString());
        }
        if (this.o == null) {
          l();
        }
        this.o.execute(this);
      }
      else
      {
        c(paramAsyncStep);
      }
      return;
    }
  }
  
  public void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraEmo, mCountRunning ");
      localStringBuilder.append(this.h);
      QLog.d("CaptureAsyncAutomator", 1, localStringBuilder.toString());
      if (this.h < 3)
      {
        this.h += 1;
        if (this.o == null) {
          l();
        }
        this.o.execute(paramAsyncStep);
      }
      else
      {
        this.i.add(paramAsyncStep);
      }
      return;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ??? = this.m;
      if (??? != null) {
        ((AsyncStep)???).run();
      }
      synchronized (this.n)
      {
        this.m = ((AsyncStep)this.n.poll());
        if (this.m == null) {
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncAutomator
 * JD-Core Version:    0.7.0.1
 */