package com.tencent.biz.qqstory.playmode.child;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import noa;

public class FeedsPlayModeBase$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver
{
  public FeedsPlayModeBase$FeedInfoUpdateReceiver(FeedsPlayModeBase paramFeedsPlayModeBase)
  {
    super(paramFeedsPlayModeBase);
  }
  
  public void a(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if (paramFeedsPlayModeBase.a(paramFeedsPlayModeBase.b) == null) {
      return;
    }
    paramFeedsPlayModeBase.a.post(new noa(this, paramFeedsPlayModeBase));
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */