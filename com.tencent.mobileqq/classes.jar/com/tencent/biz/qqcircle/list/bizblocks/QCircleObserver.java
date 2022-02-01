package com.tencent.biz.qqcircle.list.bizblocks;

import anui;
import com.tencent.qphone.base.util.QLog;

public class QCircleObserver
  implements anui
{
  private static final String TAG = "QCircleObserver";
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramInt = ((Integer)paramObject).intValue();
    QLog.d("QCircleObserver", 1, "TYPE_UPDATE_RED_POINT_DISPLAY repointNum");
    onUpdateRedPoint(paramInt);
  }
  
  protected void onUpdateRedPoint(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleObserver
 * JD-Core Version:    0.7.0.1
 */