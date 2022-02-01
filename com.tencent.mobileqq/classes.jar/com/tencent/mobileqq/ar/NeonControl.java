package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;

public class NeonControl
{
  private static NeonControl jdField_a_of_type_ComTencentMobileqqArNeonControl;
  public static boolean a = true;
  NeonControl.AvgConsumeReport jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport;
  final Object jdField_a_of_type_JavaLangObject;
  private boolean b;
  
  public static NeonControl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArNeonControl == null) {
      jdField_a_of_type_ComTencentMobileqqArNeonControl = new NeonControl();
    }
    return jdField_a_of_type_ComTencentMobileqqArNeonControl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport == null) {
      return;
    }
    NeonControl.AvgConsumeReport localAvgConsumeReport1 = new NeonControl.AvgConsumeReport(this);
    localAvgConsumeReport1.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Long;
    localAvgConsumeReport1.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Int;
    localAvgConsumeReport1.b = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b;
    NeonControl.AvgConsumeReport localAvgConsumeReport2 = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport;
    localAvgConsumeReport2.b = -2147483648;
    localAvgConsumeReport2.jdField_a_of_type_Long = 0L;
    localAvgConsumeReport2.jdField_a_of_type_Int = 0;
    if ((localAvgConsumeReport1.jdField_a_of_type_Long > 0L) && (localAvgConsumeReport1.jdField_a_of_type_Int > 0))
    {
      if (localAvgConsumeReport1.b == -2147483648) {
        return;
      }
      int i = (int)(localAvgConsumeReport1.jdField_a_of_type_Long / localAvgConsumeReport1.jdField_a_of_type_Int);
      if (i >= 0)
      {
        if (i >= 600000) {
          return;
        }
        ThreadManager.post(new NeonControl.2(this, localAvgConsumeReport1, i), 5, null, false);
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport = new NeonControl.AvgConsumeReport(this);
      this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b = paramInt;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b != paramInt)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Long > 0L) || (this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Int > 0)) {
        a();
      }
      localAvgConsumeReport = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport;
      localAvgConsumeReport.b = paramInt;
      localAvgConsumeReport.jdField_a_of_type_Long = 0L;
      localAvgConsumeReport.jdField_a_of_type_Int = 0;
    }
    NeonControl.AvgConsumeReport localAvgConsumeReport = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport;
    localAvgConsumeReport.jdField_a_of_type_Long += paramLong;
    localAvgConsumeReport = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport;
    localAvgConsumeReport.jdField_a_of_type_Int += 1;
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.b;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl
 * JD-Core Version:    0.7.0.1
 */