package com.tencent.hippy.qq.view.tkd.listview;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class HippyTKDListView$ExposureForReport
  extends HippyViewEvent
{
  public int mEndEdgePos = 0;
  public int mFirstVisibleRowIndex = 0;
  public int mLastVisibleRowIndex = 0;
  public int mScrollState = 0;
  public int mStartEdgePos = 0;
  public int mVelocity = 0;
  public HippyArray mVisibleRowFrames = null;
  
  public HippyTKDListView$ExposureForReport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, HippyArray paramHippyArray)
  {
    super("onExposureReport");
    this.mStartEdgePos = paramInt2;
    this.mEndEdgePos = paramInt3;
    this.mFirstVisibleRowIndex = paramInt4;
    this.mLastVisibleRowIndex = paramInt5;
    this.mVelocity = paramInt6;
    this.mScrollState = paramInt7;
    this.mVisibleRowFrames = paramHippyArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView.ExposureForReport
 * JD-Core Version:    0.7.0.1
 */