package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NeonControl
{
  private static NeonControl jdField_a_of_type_ComTencentMobileqqArNeonControl = null;
  public static boolean a;
  NeonControl.AvgConsumeReport jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private NeonControl()
  {
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("sp_cpu_neon_support", 4);
    if (!((SharedPreferences)localObject1).contains("sp_cpu_neon_support")) {
      ThreadManager.post(new NeonControl.1(this, (SharedPreferences)localObject1, false), 5, null, true);
    }
    boolean bool2 = ((SharedPreferences)localObject1).getBoolean("sp_cpu_neon_support", false);
    boolean bool3 = ScanEntranceDPC.a().e;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (bool3)
      {
        i = 1;
        if (!bool2) {
          break label174;
        }
        j = 1;
        label97:
        QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0) }));
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_JavaLangObject;
      if ((!bool3) || (!bool2)) {
        break label179;
      }
    }
    for (;;)
    {
      try
      {
        this.b = bool1;
        return;
      }
      finally {}
      i = 0;
      break;
      label174:
      j = 0;
      break label97;
      label179:
      bool1 = false;
    }
  }
  
  public static NeonControl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArNeonControl == null) {
      jdField_a_of_type_ComTencentMobileqqArNeonControl = new NeonControl();
    }
    return jdField_a_of_type_ComTencentMobileqqArNeonControl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport == null) {}
    NeonControl.AvgConsumeReport localAvgConsumeReport;
    int i;
    do
    {
      do
      {
        return;
        localAvgConsumeReport = new NeonControl.AvgConsumeReport(this);
        localAvgConsumeReport.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Long;
        localAvgConsumeReport.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Int;
        localAvgConsumeReport.b = this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b;
        this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b = -2147483648;
        this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Int = 0;
      } while ((localAvgConsumeReport.jdField_a_of_type_Long <= 0L) || (localAvgConsumeReport.jdField_a_of_type_Int <= 0) || (localAvgConsumeReport.b == -2147483648));
      i = (int)(localAvgConsumeReport.jdField_a_of_type_Long / localAvgConsumeReport.jdField_a_of_type_Int);
    } while ((i < 0) || (i >= 600000));
    ThreadManager.post(new NeonControl.2(this, localAvgConsumeReport, i), 5, null, false);
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
      this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Int = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl
 * JD-Core Version:    0.7.0.1
 */