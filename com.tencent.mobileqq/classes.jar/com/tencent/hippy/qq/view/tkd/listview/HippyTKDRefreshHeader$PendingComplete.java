package com.tencent.hippy.qq.view.tkd.listview;

public class HippyTKDRefreshHeader$PendingComplete
{
  long mCompleteToastLastTime = 0L;
  String mCompleteToastString = null;
  boolean mShowRefreshIcon = false;
  
  public void setPendingCompleteInfo(String paramString, boolean paramBoolean, long paramLong)
  {
    this.mCompleteToastString = paramString;
    this.mCompleteToastLastTime = paramLong;
    this.mShowRefreshIcon = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.PendingComplete
 * JD-Core Version:    0.7.0.1
 */