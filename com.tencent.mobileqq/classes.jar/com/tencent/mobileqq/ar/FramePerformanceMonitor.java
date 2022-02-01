package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int = 1000;
  private FramePerformanceMonitor.CurrentRunnable jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable;
  private FramePerformanceMonitor.FrameRefreshListener jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener;
  private GapDataCollector jdField_a_of_type_ComTencentMobileqqArGapDataCollector = new GapDataCollector(100);
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener == null) {
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
  
  public void a(FramePerformanceMonitor.FrameRefreshListener paramFrameRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener = paramFrameRefreshListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor
 * JD-Core Version:    0.7.0.1
 */