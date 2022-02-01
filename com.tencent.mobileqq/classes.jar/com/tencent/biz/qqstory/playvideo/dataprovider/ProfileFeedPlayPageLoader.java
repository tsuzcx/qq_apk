package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;

public class ProfileFeedPlayPageLoader
  extends FeedIdBasePlayPageLoader<ProfileFeedPlayInfo>
{
  public ProfileFeedPlayPageLoader(ProfileFeedPlayInfo paramProfileFeedPlayInfo)
  {
    super(paramProfileFeedPlayInfo);
    paramProfileFeedPlayInfo = (FeedManager)SuperManager.a(11);
    if (paramProfileFeedPlayInfo.h != null) {
      this.b = paramProfileFeedPlayInfo.h;
    }
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    if (this.b == null) {
      return null;
    }
    Iterator localIterator = this.b.a.iterator();
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
    if (this.b == null)
    {
      paramCallBack.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject1 = this.b.a;
    if ((paramBoolean) && (((List)localObject1).size() > 0))
    {
      localObject2 = b((List)localObject1);
      paramCallBack.a(new ErrorMessage(), (List)localObject2, this.b.b);
      SLog.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject1).size()));
      return;
    }
    localObject1 = new GetProfileFeedIdListRequest();
    ((GetProfileFeedIdListRequest)localObject1).e = this.b.c();
    ((GetProfileFeedIdListRequest)localObject1).f = QQStoryContext.a().i();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start request with cookie ");
    ((StringBuilder)localObject2).append(((GetProfileFeedIdListRequest)localObject1).e);
    SLog.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", ((StringBuilder)localObject2).toString());
    CmdTaskManger.a().a((NetworkRequest)localObject1, new ProfileFeedPlayPageLoader.1(this, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ProfileFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */