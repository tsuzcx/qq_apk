package com.tencent.biz.qqcircle.publish.uploader.report;

import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class QcirclrBusinessReport$ReportRunnable
  implements Runnable
{
  boolean a = false;
  ArrayList<ReportObj> b;
  int c;
  int d;
  
  public QcirclrBusinessReport$ReportRunnable(ArrayList<ReportObj> paramArrayList, int paramInt1, int paramInt2)
  {
    this.b = paramArrayList;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private void a()
  {
    if (this.a)
    {
      QLog.w("[upload2]QcirclrBusinessReport", 1, "inited = true");
      return;
    }
    if (this.b.isEmpty())
    {
      QLog.e("[upload2]QcirclrBusinessReport", 1, "listToSend is empty.");
      return;
    }
    Object localObject1 = this.b;
    try
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ReportObj)((Iterator)localObject1).next();
        if (((ReportObj)localObject2).b())
        {
          localObject2 = ((ReportObj)localObject2).c();
          StatisticCollector.getInstance(QCircleApplication.APP).collectPerformance(String.valueOf(LoginData.a().b()), "QcircleUploadReport", true, 0L, 0L, (HashMap)localObject2, null);
          if (this.d == 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("upload2: --- ");
            localStringBuilder.append(((HashMap)localObject2).toString());
            QLog.i("[upload2]QcirclrBusinessReport", 1, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSONException when uploadReport.");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("[upload2]QcirclrBusinessReport", 1, ((StringBuilder)localObject2).toString());
      this.a = true;
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.report.QcirclrBusinessReport.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */