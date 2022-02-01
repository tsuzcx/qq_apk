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
    if (paramProfileFeedPlayInfo.b != null) {
      this.a = paramProfileFeedPlayInfo.b;
    }
  }
  
  public FeedIdListSeqInfo a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
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
    if (this.a == null)
    {
      paramCallBack.a(new ErrorMessage(940001, "null point"), null, true);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramCallBack.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      SLog.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new GetProfileFeedIdListRequest();
    ((GetProfileFeedIdListRequest)localObject).a = this.a.a();
    ((GetProfileFeedIdListRequest)localObject).b = QQStoryContext.a().b();
    SLog.c("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request with cookie " + ((GetProfileFeedIdListRequest)localObject).a);
    CmdTaskManger.a().a((NetworkRequest)localObject, new ProfileFeedPlayPageLoader.1(this, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ProfileFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */