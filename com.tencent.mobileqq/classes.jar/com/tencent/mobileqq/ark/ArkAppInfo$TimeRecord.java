package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ArkAppInfo$TimeRecord
{
  public long a;
  public ArkViewModelBase.TimeRecord a;
  public boolean a;
  public long b;
  
  public ArkAppInfo$TimeRecord(ArkViewModelBase.TimeRecord paramTimeRecord)
  {
    this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord = paramTimeRecord;
  }
  
  public void a()
  {
    int i = (int)(this.b - this.jdField_a_of_type_Long);
    int j = (int)(this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfCreateView - this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfCreateView);
    int k = (int)(this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfDisplyView - this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfDisplyView);
    String str1 = this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.appName;
    String str2 = this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.view;
    QLog.i("ArkApp", 1, String.format(Locale.CHINA, "TimeRecord.appName.%s.view:%s.getapp.%d.createview.%d.dispview.%d.", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    ArkAppDataReport.a(null, str1, str2, this.jdField_a_of_type_Boolean, i);
    ArkAppDataReport.a(null, str1, str2, j);
    ArkAppDataReport.b(null, str1, str2, k);
  }
  
  public void b()
  {
    int i = (int)(this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfCreateContext - this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfDisplyView);
    int j = (int)(this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfCreateDrawTarget - this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfCreateContext);
    int k = (int)(this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfFirstDraw - this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfFirstDraw);
    int m = (int)(this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfFirstDraw - this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfDisplyView);
    String str1 = this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.appName;
    String str2 = this.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.view;
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp", 2, String.format(Locale.CHINA, "TimeRecord.appName.%s.view.%s.surfaceprepare.%d.createcontext.%d.firstdraw.%d.totalcost.%d.", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    ArkAppDataReport.c(null, str1, str2, i);
    ArkAppDataReport.d(null, str1, str2, j);
    ArkAppDataReport.e(null, str1, str2, k);
    ArkAppDataReport.f(null, str1, str2, m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppInfo.TimeRecord
 * JD-Core Version:    0.7.0.1
 */