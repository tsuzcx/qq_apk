package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class HomeFeedListPageLoader$FeedIdPullSegment
  extends JobSegment<Integer, FeedListPageLoaderBase.GetFeedIdListResult>
{
  private FeedListPageLoaderBase.FeedIdListCache a;
  private int b;
  private BasicLocation c;
  
  public HomeFeedListPageLoader$FeedIdPullSegment(@NonNull FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache, BasicLocation paramBasicLocation)
  {
    this.a = paramFeedIdListCache;
    this.c = paramBasicLocation;
  }
  
  public static boolean a(@Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, AtomicBoolean paramAtomicBoolean)
  {
    List localList = ((StoryManager)SuperManager.a(5)).a(true);
    Iterator localIterator = paramGetStoryFeedIdListResponse.e.iterator();
    Object localObject1 = "";
    paramGetStoryFeedIdListResponse = null;
    while (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      Object localObject2 = localObject1;
      if (!((String)localObject1).equals(localFeedIdListSeqInfo.d)) {
        localObject2 = localFeedIdListSeqInfo.d;
      }
      localObject1 = localObject2;
      if (a(localFeedIdListSeqInfo, localList))
      {
        localFeedIdListSeqInfo.g = true;
        paramAtomicBoolean.set(true);
        paramGetStoryFeedIdListResponse = localFeedIdListSeqInfo;
        localObject1 = localObject2;
      }
    }
    return (paramGetStoryFeedIdListResponse != null) && (((String)localObject1).equals(paramGetStoryFeedIdListResponse.d));
  }
  
  private static boolean a(FeedIdListSeqInfo paramFeedIdListSeqInfo, List<StoryVideoItem> paramList)
  {
    Object localObject2;
    do
    {
      paramList = paramList.iterator();
      Object localObject1;
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject1 = (StoryVideoItem)paramList.next();
          } while (!paramFeedIdListSeqInfo.d.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramFeedIdListSeqInfo.c.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramFeedIdListSeqInfo });
            return true;
          }
          localObject2 = StoryVideoTaskInfo.b(((StoryVideoItem)localObject1).mVid);
          int i;
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i == 0) && (paramFeedIdListSeqInfo.c.equals(((StoryVideoItem)localObject1).mOwnerUid)))
          {
            SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramFeedIdListSeqInfo });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((VideoSpreadGroupList)localObject1).d == null));
        localObject1 = ((VideoSpreadGroupList)localObject1).d.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramFeedIdListSeqInfo.c.equals(localObject2));
    SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramFeedIdListSeqInfo });
    return true;
    return false;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((FeedListPageLoaderBase.GetFeedIdListResult)localObject).a.size() <= 0) && (!((FeedListPageLoaderBase.GetFeedIdListResult)localObject).c))
    {
      localObject = new AtomicBoolean(false);
      GetStoryFeedIdListRequest localGetStoryFeedIdListRequest = new GetStoryFeedIdListRequest();
      localGetStoryFeedIdListRequest.g = this.c;
      localGetStoryFeedIdListRequest.f = this.a.c();
      CmdTaskManger.a().a(localGetStoryFeedIdListRequest, new HomeFeedListPageLoader.FeedIdPullSegment.1(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
      return;
    }
    SLog.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
    notifyResult(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader.FeedIdPullSegment
 * JD-Core Version:    0.7.0.1
 */