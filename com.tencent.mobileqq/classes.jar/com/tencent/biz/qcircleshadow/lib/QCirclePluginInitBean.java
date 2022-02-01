package com.tencent.biz.qcircleshadow.lib;

import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.io.Serializable;

public class QCirclePluginInitBean
  implements Serializable
{
  private static final long serialVersionUID = 5838484954956837977L;
  private int mLoadAction;
  private QCircleSchemeBean mSchemeBean;
  private long mStartTime;
  private QCirclePluginTrace mTrace;
  
  public int getLoadAction()
  {
    return this.mLoadAction;
  }
  
  public QCircleSchemeBean getSchemeBean()
  {
    return this.mSchemeBean;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public QCirclePluginTrace getTrace()
  {
    return this.mTrace;
  }
  
  public QCirclePluginInitBean setLoadAction(int paramInt)
  {
    this.mLoadAction = paramInt;
    return this;
  }
  
  public QCirclePluginInitBean setSchemeBean(QCircleSchemeBean paramQCircleSchemeBean)
  {
    this.mSchemeBean = paramQCircleSchemeBean;
    return this;
  }
  
  public QCirclePluginInitBean setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
    return this;
  }
  
  public QCirclePluginInitBean setTrace(QCirclePluginTrace paramQCirclePluginTrace)
  {
    this.mTrace = paramQCirclePluginTrace;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean
 * JD-Core Version:    0.7.0.1
 */