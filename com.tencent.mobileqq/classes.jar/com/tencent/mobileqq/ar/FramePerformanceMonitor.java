package com.tencent.mobileqq.ar;

import aadc;
import com.tencent.mobileqq.app.ThreadManager;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int = 1000;
  private aadc jdField_a_of_type_Aadc;
  private FramePerformanceMonitor.FrameRefreshListener jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener;
  private GapDataCollector jdField_a_of_type_ComTencentMobileqqArGapDataCollector = new GapDataCollector(100);
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener == null) {
      return;
    }
    this.jdField_a_of_type_Aadc = new aadc(this, null);
    aadc.a(this.jdField_a_of_type_Aadc, true);
    ThreadManager.post(this.jdField_a_of_type_Aadc, 8, null, true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FramePerformanceMonitor.FrameRefreshListener paramFrameRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener = paramFrameRefreshListener;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArGapDataCollector.a(paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aadc != null)
    {
      aadc.a(this.jdField_a_of_type_Aadc, false);
      this.jdField_a_of_type_Aadc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor
 * JD-Core Version:    0.7.0.1
 */