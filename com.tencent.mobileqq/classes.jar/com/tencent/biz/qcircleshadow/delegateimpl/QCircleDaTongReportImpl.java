package com.tencent.biz.qcircleshadow.delegateimpl;

import com.tencent.biz.qcircleshadow.lib.delegate.IDaTongReportDelegate;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;

public class QCircleDaTongReportImpl
  implements IDaTongReportDelegate
{
  public void reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap)
  {
    VideoReport.reportEvent(paramString, paramObject, paramMap);
  }
  
  public void setPageId(Object paramObject, String paramString)
  {
    VideoReport.setPageId(paramObject, paramString);
  }
  
  public void setPageParams(Object paramObject, Map<String, Object> paramMap)
  {
    VideoReport.setPageParams(paramObject, new PageParams(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCircleDaTongReportImpl
 * JD-Core Version:    0.7.0.1
 */