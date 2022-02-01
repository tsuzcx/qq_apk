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
  private AsyncStep jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep = null;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final LinkedList<AsyncStep> b = new LinkedList();
  
  public CaptureAsyncAutomator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(AsyncStep paramAsyncStep)
  {
    this.b.add(paramAsyncStep);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWaitingMode_Locked ");
      localStringBuilder.append(paramAsyncStep.mName);
      QLog.d("CaptureAsyncAutomator", 2, localStringBuilder.toString());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new CaptureAsyncAutomator.MyThreadFactory(this, null));
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
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
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep = paramAsyncStep;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run ");
          localStringBuilder.append(paramAsyncStep.mName);
          QLog.d("CaptureAsyncAutomator", 2, localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
          e();
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this);
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
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraEmo, mCountRunning ");
      localStringBuilder.append(this.c);
      QLog.d("CaptureAsyncAutomator", 1, localStringBuilder.toString());
      if (this.c < 3)
      {
        this.c += 1;
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
          e();
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramAsyncStep);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
      }
      return;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep;
      if (??? != null) {
        ((AsyncStep)???).run();
      }
      synchronized (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep = ((AsyncStep)this.b.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncAutomator
 * JD-Core Version:    0.7.0.1
 */