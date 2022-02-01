package com.tencent.biz.qcircleshadow.lib;

import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.io.Serializable;

public class QCirclePluginInitBean
  implements Serializable
{
  private static final long serialVersionUID = 5838484954956837977L;
  private QCircleSchemeBean initBean;
  private int mLoadAction;
  private long mStartTime;
  
  public QCircleSchemeBean getInitBean()
  {
    return this.initBean;
  }
  
  public int getLoadAction()
  {
    return this.mLoadAction;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public QCirclePluginInitBean setInitBean(QCircleSchemeBean paramQCircleSchemeBean)
  {
    this.initBean = paramQCircleSchemeBean;
    return this;
  }
  
  public QCirclePluginInitBean setLoadAction(int paramInt)
  {
    this.mLoadAction = paramInt;
    return this;
  }
  
  public QCirclePluginInitBean setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean
 * JD-Core Version:    0.7.0.1
 */