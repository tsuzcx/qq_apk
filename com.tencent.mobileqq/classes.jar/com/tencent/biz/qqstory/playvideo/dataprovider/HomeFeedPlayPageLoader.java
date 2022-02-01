package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;

public class HomeFeedPlayPageLoader
  extends FeedIdBasePlayPageLoader<HomeFeedPlayInfo>
{
  public FeedListPageLoaderBase.FeedIdListCache c = new FeedListPageLoaderBase.FeedIdListCache();
  private int d;
  
  public HomeFeedPlayPageLoader(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    super(paramHomeFeedPlayInfo);
    paramHomeFeedPlayInfo = (FeedManager)SuperManager.a(11);
    if (paramHomeFeedPlayInfo.h != null) {
      this.c = paramHomeFeedPlayInfo.h;
    }
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    Iterator localIterator = this.c.a.iterator();
    while (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      if (localFeedIdListSeqInfo.a.equals(paramString)) {
        return localFeedIdListSeqInfo;
      }
    }
    return null;
  }
  
  public void a(boolean paramBoolean, int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    Object localObject1 = this.c.a;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramCallBack.a(new ErrorMessage(), (List)localObject2, this.c.b);
      SLog.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = (FeedManager)SuperManager.a(11);
    Object localObject2 = new GetStoryFeedIdListRequest();
    ((GetStoryFeedIdListRequest)localObject2).g = ((FeedManager)localObject1).i;
    ((GetStoryFeedIdListRequest)localObject2).f = this.c.c();
    SLog.a("Q.qqstory.player.data.HomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((GetStoryFeedIdListRequest)localObject2).f);
    this.d = 0;
    CmdTaskManger.a().a((NetworkRequest)localObject2, new HomeFeedPlayPageLoader.1(this, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.HomeFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */