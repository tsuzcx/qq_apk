package com.tencent.av.report;

import android.content.Context;
import com.tencent.av.report.impl.AVCatonReport;
import com.tencent.av.report.impl.AVLinkMicReport;
import com.tencent.av.report.impl.AVMonitorReport;
import com.tencent.av.report.utils.AVReportUtils;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;

public class AVReportManager
{
  private static SimpleCoreHttpImpl mHttpInterface;
  
  public static AVReportInterface get(AVReportManager.ReportType paramReportType)
  {
    int i = AVReportManager.1.$SwitchMap$com$tencent$av$report$AVReportManager$ReportType[paramReportType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return new AVLinkMicReport(mHttpInterface);
      }
      return new AVMonitorReport(mHttpInterface);
    }
    return new AVCatonReport(mHttpInterface);
  }
  
  public static void init(Context paramContext, SimpleCoreHttpImpl paramSimpleCoreHttpImpl)
  {
    mHttpInterface = paramSimpleCoreHttpImpl;
    AVReportUtils.setAppContext(paramContext);
  }
  
  public static void setLog(AVReportLogInterface paramAVReportLogInterface)
  {
    AVReportLog.setLog(paramAVReportLogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.AVReportManager
 * JD-Core Version:    0.7.0.1
 */