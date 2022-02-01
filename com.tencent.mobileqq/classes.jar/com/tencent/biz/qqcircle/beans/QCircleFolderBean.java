package com.tencent.biz.qqcircle.beans;

import cooperation.qqcircle.report.QCircleReportBean;
import java.util.HashMap;

public class QCircleFolderBean
  extends QCircleInitBean
{
  HashMap<String, String> attrs;
  private boolean isPublish;
  private float mBottomMargin = 0.0F;
  private boolean mHasRedDot;
  private String mLastPageScheme;
  private int mQQCircleUnreadRedNum;
  private byte[] mRedDotTransInfo;
  private QCircleReportBean mReportDataBean;
  private int mTabType = -1;
  
  public QCircleFolderBean() {}
  
  public QCircleFolderBean(QCircleReportBean paramQCircleReportBean)
  {
    this.mReportDataBean = paramQCircleReportBean;
  }
  
  public int getAssignShowTabType()
  {
    return this.mTabType;
  }
  
  public HashMap<String, String> getAttrs()
  {
    return this.attrs;
  }
  
  public float getBottomMarginPx()
  {
    return this.mBottomMargin;
  }
  
  public String getLastPageScheme()
  {
    return this.mLastPageScheme;
  }
  
  public int getQQCircleUnreadRedNum()
  {
    return this.mQQCircleUnreadRedNum;
  }
  
  public byte[] getRedDotTransInfo()
  {
    return this.mRedDotTransInfo;
  }
  
  public boolean hasRedDotShownOnEntrance()
  {
    return this.mHasRedDot;
  }
  
  public boolean isPublish()
  {
    return this.isPublish;
  }
  
  public void setAssignShowTabType(int paramInt)
  {
    this.mTabType = paramInt;
  }
  
  public void setAttrs(HashMap<String, String> paramHashMap)
  {
    this.attrs = paramHashMap;
    this.mSchemeAttrs = paramHashMap;
  }
  
  public void setBottomMargin(float paramFloat)
  {
    this.mBottomMargin = paramFloat;
  }
  
  public void setHasRedDot(boolean paramBoolean)
  {
    this.mHasRedDot = paramBoolean;
  }
  
  public void setLastPageScheme(String paramString)
  {
    this.mLastPageScheme = paramString;
  }
  
  public void setPublish(boolean paramBoolean)
  {
    this.isPublish = paramBoolean;
  }
  
  public void setRedDotTransInfo(byte[] paramArrayOfByte)
  {
    this.mRedDotTransInfo = paramArrayOfByte;
  }
  
  public void setUnreadRedNum(int paramInt)
  {
    this.mQQCircleUnreadRedNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleFolderBean
 * JD-Core Version:    0.7.0.1
 */