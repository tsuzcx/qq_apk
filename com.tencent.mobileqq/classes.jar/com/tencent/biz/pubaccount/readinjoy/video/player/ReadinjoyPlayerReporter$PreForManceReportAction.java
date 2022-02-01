package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.qphone.base.util.QLog;

public class ReadinjoyPlayerReporter$PreForManceReportAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$PreForManceReportAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = ((String)paramObject).split(":", 2);
      if ((paramObject != null) && (paramObject.length == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
        if ("prepare".equals(paramObject[0])) {
          this.a.a.l = paramObject[1];
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.PreForManceReportAction
 * JD-Core Version:    0.7.0.1
 */