package com.tencent.biz.qqcircle.launchbean;

import java.util.HashMap;

public class QCircleFolderBean
  extends QCircleInitBean
{
  HashMap<String, String> attrs;
  private boolean isPublish;
  private boolean mHasRedDot;
  private int mQQCircleUnreadRedNum;
  private byte[] mRedDotTransInfo;
  private int mTabType = -1;
  
  public int getAssignShowTabType()
  {
    return this.mTabType;
  }
  
  public HashMap<String, String> getAttrs()
  {
    return this.attrs;
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
  }
  
  public void setHasRedDot(boolean paramBoolean)
  {
    this.mHasRedDot = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launchbean.QCircleFolderBean
 * JD-Core Version:    0.7.0.1
 */