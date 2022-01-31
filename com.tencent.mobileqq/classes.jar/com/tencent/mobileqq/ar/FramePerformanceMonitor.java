package com.tencent.mobileqq.ar;

import alcs;
import alct;
import com.tencent.mobileqq.app.ThreadManager;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int = 1000;
  private alcs jdField_a_of_type_Alcs;
  private alct jdField_a_of_type_Alct = new alct(100);
  private FramePerformanceMonitor.CurrentRunnable jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable;
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Alcs == null) {
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
  
  public void a(alcs paramalcs)
  {
    this.jdField_a_of_type_Alcs = paramalcs;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Alct.a(paramLong);
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