package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import java.util.List;

public class SubscribePublishFeedsEvent
  extends SimpleBaseEvent
{
  public static final int STATE_PUBLISH = 1;
  public CertifiedAccountMeta.StFeed mFeed;
  public List<CertifiedAccountMeta.StFeed> mFeedList;
  public int mState;
  
  public SubscribePublishFeedsEvent(CertifiedAccountMeta.StFeed paramStFeed, int paramInt)
  {
    this.mState = paramInt;
    this.mFeed = paramStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent
 * JD-Core Version:    0.7.0.1
 */