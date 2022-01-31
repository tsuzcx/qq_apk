package com.tencent.gdtad.aditem;

import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class GdtStatistics
  implements Serializable
{
  public int reportState;
  public String traceId;
  
  public GdtStatistics(qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo paramReportInfo)
  {
    if (paramReportInfo == null) {
      return;
    }
    this.traceId = paramReportInfo.trace_info.traceid.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtStatistics
 * JD-Core Version:    0.7.0.1
 */