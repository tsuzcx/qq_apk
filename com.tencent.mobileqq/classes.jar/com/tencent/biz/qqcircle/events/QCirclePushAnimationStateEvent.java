package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePushAnimationStateEvent
  extends SimpleBaseEvent
{
  public static final int ANIMATION_STATE_END = 2;
  public static final int ANIMATION_STATE_START = 1;
  public int mSceneType;
  public int mState;
  public String mTargetFeedId;
  
  public QCirclePushAnimationStateEvent(String paramString, int paramInt1, int paramInt2)
  {
    this.mTargetFeedId = paramString;
    this.mState = paramInt1;
    this.mSceneType = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent
 * JD-Core Version:    0.7.0.1
 */