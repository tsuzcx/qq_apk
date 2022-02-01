package com.tencent.biz.qcircleshadow.lib.delegate;

import java.util.Map;

public abstract interface IDaTongReportDelegate
{
  public abstract void reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap);
  
  public abstract void setPageId(Object paramObject, String paramString);
  
  public abstract void setPageParams(Object paramObject, Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.delegate.IDaTongReportDelegate
 * JD-Core Version:    0.7.0.1
 */