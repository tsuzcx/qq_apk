package com.tencent.aekit.api.standard.ARDetect;

import com.tencent.ttpic.model.ArFrameInfo;

public class ARDetectDataManager
{
  private static ArFrameInfo sData;
  private static ARDetectDataManager sInstance = new ARDetectDataManager();
  private static boolean sNeedMiddlePoint = true;
  
  public static ARDetectDataManager getInstance()
  {
    return sInstance;
  }
  
  public Object getData()
  {
    return sData;
  }
  
  public boolean getNeedMiddlePoint()
  {
    return sNeedMiddlePoint;
  }
  
  public void setNeedMiddlePoint(boolean paramBoolean)
  {
    sNeedMiddlePoint = paramBoolean;
  }
  
  public void updateData(ArFrameInfo paramArFrameInfo)
  {
    sData = paramArFrameInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ARDetect.ARDetectDataManager
 * JD-Core Version:    0.7.0.1
 */