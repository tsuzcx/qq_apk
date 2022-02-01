package com.tencent.biz.pubaccount.readinjoy.pts.util;

import com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport;

final class PTSHelper$1
  extends PTSReportUtil.DefaultPTSReport
{
  public void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    PTSReport.a("0X800B241", "", "", "", new PTSReport.R5Builder().a("tag", paramString1).a("msg", paramString2).a("reportType", "" + paramInt).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSHelper.1
 * JD-Core Version:    0.7.0.1
 */