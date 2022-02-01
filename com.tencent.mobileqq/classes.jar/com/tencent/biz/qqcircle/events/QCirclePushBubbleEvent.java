package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleEnvHub.Tips;

public class QCirclePushBubbleEvent
  extends SimpleBaseEvent
{
  public static final int BUBBLE_GUIDE = 3;
  public static final int BUBBLE_HIDE_SHARE = 2;
  public static final int BUBBLE_PUSH_MAX_TIMES = 1;
  public static final int BUBBLE_ROCKET_TIP = 4;
  public static final int BUBBLE_SHARE = 0;
  public int mBubbleType;
  public String mFeedId;
  public int mPageType;
  private QQCircleEnvHub.Tips mPushTip;
  
  public QCirclePushBubbleEvent(int paramInt1, String paramString, int paramInt2)
  {
    this.mBubbleType = paramInt1;
    this.mFeedId = paramString;
    this.mPageType = paramInt2;
  }
  
  public QCirclePushBubbleEvent(int paramInt1, String paramString, int paramInt2, QQCircleEnvHub.Tips paramTips)
  {
    this.mBubbleType = paramInt1;
    this.mFeedId = paramString;
    this.mPageType = paramInt2;
    this.mPushTip = paramTips;
  }
  
  public QQCircleEnvHub.Tips getPushTip()
  {
    return this.mPushTip;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePushBubbleEvent
 * JD-Core Version:    0.7.0.1
 */