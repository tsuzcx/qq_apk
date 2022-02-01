package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class GetFeedFeatureHandler$1
  implements Runnable
{
  GetFeedFeatureHandler$1(GetFeedFeatureHandler paramGetFeedFeatureHandler) {}
  
  public void run()
  {
    Object localObject3;
    if (GetFeedFeatureHandler.a(this.this$0))
    {
      localObject1 = this.this$0.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = (Long)GetFeedFeatureHandler.f.get(localObject2);
        if ((localObject3 != null) && (System.currentTimeMillis() - ((Long)localObject3).longValue() < 30000L))
        {
          ((Iterator)localObject1).remove();
          SLog.a("Q.qqstory.home.GetFeedFeatureHandler", "remove same request for feed info:%s", localObject2);
        }
        else
        {
          GetFeedFeatureHandler.f.put(localObject2, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.c.size() == 0) {
      return;
    }
    SLog.a("Q.qqstory.home.GetFeedFeatureHandler", "request for feed info:%s", this.this$0.c);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.this$0.c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.this$0.e.b((String)localObject3) == null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((List)localObject1).add(localObject3);
        }
      }
      else {
        this.this$0.d.add(localObject3);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedItem: first=", ((List)localObject1).get(0) });
      }
      localObject2 = new BatchGetFriendStoryFeedInfoRequest();
      ((BatchGetFriendStoryFeedInfoRequest)localObject2).f = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = new FeedIdListSeqInfo((String)((Iterator)localObject1).next(), 0, "", "");
        ((BatchGetFriendStoryFeedInfoRequest)localObject2).f.add(localObject3);
      }
      CmdTaskManger.a().a((NetworkRequest)localObject2, this.this$0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request FeedFeature: first=", this.this$0.c.get(0) });
    }
    localObject1 = new GetFeedFeatureRequest();
    ((GetFeedFeatureRequest)localObject1).f = this.this$0.c;
    CmdTaskManger.a().a((NetworkRequest)localObject1, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1
 * JD-Core Version:    0.7.0.1
 */