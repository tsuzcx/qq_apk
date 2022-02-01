package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class FeedManager$3
  implements Runnable
{
  FeedManager$3(FeedManager paramFeedManager, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.d(this.a);
    if (localObject1 == null)
    {
      if (this.b)
      {
        localObject1 = (Long)FeedManager.k().get(this.a);
        if ((localObject1 != null) && (Math.abs(System.currentTimeMillis() - ((Long)localObject1).longValue()) < 300000L))
        {
          SLog.a("Q.qqstory.home.data.FeedManager", "request feed item, ignore same request %s", this.a);
          return;
        }
      }
      FeedManager.k().put(this.a, Long.valueOf(System.currentTimeMillis()));
      localObject1 = new BatchGetFriendStoryFeedInfoRequest();
      ((BatchGetFriendStoryFeedInfoRequest)localObject1).f = new ArrayList();
      localObject2 = new FeedIdListSeqInfo(this.a, 0, "", "");
      ((BatchGetFriendStoryFeedInfoRequest)localObject1).f.add(localObject2);
      CmdTaskManger.a().a((NetworkRequest)localObject1, new FeedManager.3.1(this));
      SLog.a("Q.qqstory.home.data.FeedManager", "request feed item, from net %s", this.a);
      return;
    }
    localObject1 = (FeedItem)FeedManager.b(this.this$0).a(((FeedItem)localObject1).feedId, (Copyable)localObject1);
    Object localObject2 = new FeedManager.GetFeedItemEvent();
    ((FeedManager.GetFeedItemEvent)localObject2).a = ((FeedItem)localObject1);
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject2);
    SLog.a("Q.qqstory.home.data.FeedManager", "request feed item, db rec %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.3
 * JD-Core Version:    0.7.0.1
 */