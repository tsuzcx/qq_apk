package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import qpu;

public class GdtReporter
{
  private static GdtReporter jdField_a_of_type_ComTencentGdtadStatisticsGdtReporter;
  private GdtAdHandler jdField_a_of_type_ComTencentGdtadNetGdtAdHandler;
  
  private GdtReporter()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentGdtadNetGdtAdHandler = ((GdtAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110));
    }
  }
  
  public static GdtReporter a()
  {
    if (jdField_a_of_type_ComTencentGdtadStatisticsGdtReporter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadStatisticsGdtReporter == null) {
        jdField_a_of_type_ComTencentGdtadStatisticsGdtReporter = new GdtReporter();
      }
      return jdField_a_of_type_ComTencentGdtadStatisticsGdtReporter;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new qpu(paramString), 2, null, false);
    GdtLog.b("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporter
 * JD-Core Version:    0.7.0.1
 */