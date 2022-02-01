package com.tencent.mobileqq.ar;

import apke;
import apkf;
import com.tencent.mobileqq.app.ThreadManager;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int = 1000;
  private apke jdField_a_of_type_Apke;
  private apkf jdField_a_of_type_Apkf = new apkf(100);
  private FramePerformanceMonitor.CurrentRunnable jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable;
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Apke == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable = new FramePerformanceMonitor.CurrentRunnable(this, null);
    FramePerformanceMonitor.CurrentRunnable.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable, true);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable, 8, null, true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(apke paramapke)
  {
    this.jdField_a_of_type_Apke = paramapke;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Apkf.a(paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable != null)
    {
      FramePerformanceMonitor.CurrentRunnable.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable, false);
      this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor
 * JD-Core Version:    0.7.0.1
 */