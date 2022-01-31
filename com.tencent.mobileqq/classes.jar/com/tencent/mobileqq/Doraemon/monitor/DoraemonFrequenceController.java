package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.common.app.BaseApplicationImpl;

public class DoraemonFrequenceController
  implements DoraemonAPIReporter.OnFrequenceDataUpdateListener
{
  private static DoraemonFrequenceController jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController;
  DoraemonAPIReporter jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter;
  
  private DoraemonFrequenceController()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter = new DoraemonAPIReporterMain();; this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter = new DoraemonAPIReporterProxy())
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(this);
      return;
    }
  }
  
  public static DoraemonFrequenceController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController == null) {
        jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController = new DoraemonFrequenceController();
      }
      return jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramInt, paramString2, paramString3);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController
 * JD-Core Version:    0.7.0.1
 */