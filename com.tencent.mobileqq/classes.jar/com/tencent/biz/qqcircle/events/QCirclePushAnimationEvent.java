package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePushAnimationEvent
  extends SimpleBaseEvent
{
  public static final int CLICK_TYPE_COMBO_CLICK = 2;
  public static final int CLICK_TYPE_LONG_PRESS = 3;
  public static final int CLICK_TYPE_SINGLE_CLICK = 1;
  public int mClickType;
  public int mPageType;
  public int mRecommendTimes;
  public String mTargetFeedId;
  
  public QCirclePushAnimationEvent(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTargetFeedId = paramString;
    this.mRecommendTimes = paramInt1;
    this.mClickType = paramInt2;
    this.mPageType = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent
 * JD-Core Version:    0.7.0.1
 */