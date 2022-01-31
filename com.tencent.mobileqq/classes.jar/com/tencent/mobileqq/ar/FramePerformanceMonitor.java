package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;
import zyi;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int = 1000;
  private FramePerformanceMonitor.FrameRefreshListener jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener;
  private GapDataCollector jdField_a_of_type_ComTencentMobileqqArGapDataCollector = new GapDataCollector(100);
  private zyi jdField_a_of_type_Zyi;
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener == null) {
      return;
    }
    this.jdField_a_of_type_Zyi = new zyi(this, null);
    zyi.a(this.jdField_a_of_type_Zyi, true);
    ThreadManager.post(this.jdField_a_of_type_Zyi, 8, null, true);
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
    if (this.jdField_a_of_type_Zyi != null)
    {
      zyi.a(this.jdField_a_of_type_Zyi, false);
      this.jdField_a_of_type_Zyi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor
 * JD-Core Version:    0.7.0.1
 */