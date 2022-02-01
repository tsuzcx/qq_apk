package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager.WSLiveAnimationCallback;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;

class WSFollowFeedHolder$10
  implements WSLiveAnimationManager.WSLiveAnimationCallback
{
  WSFollowFeedHolder$10(WSFollowFeedHolder paramWSFollowFeedHolder, stSimpleMetaPerson paramstSimpleMetaPerson) {}
  
  public void a()
  {
    boolean bool = WSFeedUtils.c(this.a.relation_type);
    WSFollowFeedHolder.a(this.b, this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.10
 * JD-Core Version:    0.7.0.1
 */