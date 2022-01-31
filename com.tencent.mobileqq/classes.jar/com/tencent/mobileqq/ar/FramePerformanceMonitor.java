package com.tencent.mobileqq.ar;

import aajt;
import com.tencent.mobileqq.app.ThreadManager;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int = 1000;
  private aajt jdField_a_of_type_Aajt;
  private FramePerformanceMonitor.FrameRefreshListener jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener;
  private GapDataCollector jdField_a_of_type_ComTencentMobileqqArGapDataCollector = new GapDataCollector(100);
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener == null) {
      return;
    }
    this.jdField_a_of_type_Aajt = new aajt(this, null);
    aajt.a(this.jdField_a_of_type_Aajt, true);
    ThreadManager.post(this.jdField_a_of_type_Aajt, 8, null, true);
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
    if (this.jdField_a_of_type_Aajt != null)
    {
      aajt.a(this.jdField_a_of_type_Aajt, false);
      this.jdField_a_of_type_Aajt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor
 * JD-Core Version:    0.7.0.1
 */