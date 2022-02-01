package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.OneVideoInfo;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.ShareGroupFakeItem;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFeedPresenter$UploadStatusRec
  extends UIBaseEventReceiver<HomeFeedPresenter, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  public HomeFeedPresenter$UploadStatusRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  private void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, VideoListHomeFeed paramVideoListHomeFeed, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject1 = paramVideoListHomeFeed.a().iterator();
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
      {
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
        if (paramStoryVideoItem2 == null)
        {
          ((StoryVideoItem)localObject2).copy(paramStoryVideoItem1);
        }
        else
        {
          paramVideoListHomeFeed.a(i, paramStoryVideoItem2);
          SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
          paramStoryVideoItem2 = (FeedVideoManager)SuperManager.a(12);
          localObject1 = ((VideoListFeedItem)paramVideoListHomeFeed.f).getVideoInfo();
          ((FeedVideoInfo)localObject1).mVideoItemList.clear();
          ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramVideoListHomeFeed.a());
          paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
        }
        i = 1;
        break label205;
      }
      i += 1;
    }
    i = 0;
    label205:
    if (i == 0)
    {
      paramVideoListHomeFeed.a(paramStoryVideoItem1, paramBoolean ^ true);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
      paramStoryVideoItem2 = (FeedVideoManager)SuperManager.a(12);
      localObject1 = ((VideoListFeedItem)paramVideoListHomeFeed.f).getVideoInfo();
      ((FeedVideoInfo)localObject1).mVideoItemList.clear();
      ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramVideoListHomeFeed.a());
      if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
      {
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramVideoListHomeFeed.i().feedId);
        ((FeedVideoInfo)localObject1).mIsVideoEnd = true;
        localObject2 = ((FeedVideoInfo)localObject1).mVideoItemList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!StoryVideoItem.isFakeVid(((StoryVideoItem)((Iterator)localObject2).next()).mVid)) {
            ((FeedVideoInfo)localObject1).mIsVideoEnd = false;
          }
        }
      }
      paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
      if (QLog.isDebugVersion()) {
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", HomeFeedPresenter.b(paramHomeFeedPresenter));
      }
      int j = paramHomeFeedPresenter.i().size();
      i = 0;
      while (j > i)
      {
        paramStoryVideoItem2 = (StoryHomeFeed)HomeFeedPresenter.b(paramHomeFeedPresenter).get(i);
        if ((!(paramStoryVideoItem2 instanceof HotRecommendHomeFeed)) || (!((HotRecommendFeedItem)((HotRecommendHomeFeed)paramStoryVideoItem2).i()).mIsTopLocation)) {
          break;
        }
        i += 1;
      }
      HomeFeedPresenter.b(paramHomeFeedPresenter).remove(paramVideoListHomeFeed);
      HomeFeedPresenter.b(paramHomeFeedPresenter).add(i, paramVideoListHomeFeed);
      if (QLog.isDebugVersion()) {
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", HomeFeedPresenter.b(paramHomeFeedPresenter));
      }
      if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramVideoListHomeFeed instanceof GeneralHomeFeed)))
      {
        paramStoryVideoItem2 = paramVideoListHomeFeed.j;
        paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
        if (paramStoryVideoItem2.size() > 0) {
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        } else {
          paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
        }
        SLog.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramVideoListHomeFeed.i().feedId });
      }
    }
    HomeFeedPresenter.c(paramHomeFeedPresenter).a(paramVideoListHomeFeed.f.feedId);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.b())
    {
      SLog.b(this.TAG, "group video upload");
      return;
    }
    if (paramStoryVideoPublishStatusEvent.f != null)
    {
      Iterator localIterator = paramStoryVideoPublishStatusEvent.f.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (StoryVideoUploadManager.ShareGroupFakeItem)localIterator.next();
        if (!(((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).a instanceof ShareGroupFeedItem))
        {
          AssertUtils.fail("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).a.getOwner();
          if (HomeFeedPresenter.a(paramHomeFeedPresenter, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject2 = HomeFeedPresenter.a(paramHomeFeedPresenter, HomeFeedPresenter.b(paramHomeFeedPresenter), ((ShareGroupItem)localObject1).shareGroupId, ((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).a.date);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if ((((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).a instanceof ShareGroupFeedItem))
              {
                localObject1 = new ShareGroupHomeFeed((ShareGroupFeedItem)((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).a);
                HomeFeedPresenter.b(paramHomeFeedPresenter).add(0, localObject1);
              }
              SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
            }
            if ((((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).b != null) && ((localObject1 instanceof ShareGroupHomeFeed))) {
              ((VideoListHomeFeed)localObject1).f = ((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).b;
            }
            localObject2 = ((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).c.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (StoryVideoUploadManager.OneVideoInfo)((Iterator)localObject2).next();
              a(paramHomeFeedPresenter, (VideoListHomeFeed)localObject1, paramStoryVideoPublishStatusEvent.a, ((StoryVideoUploadManager.OneVideoInfo)localObject3).a, ((StoryVideoUploadManager.OneVideoInfo)localObject3).b);
            }
          }
        }
      }
    }
    if (!paramStoryVideoPublishStatusEvent.b) {
      return;
    }
    if (!HomeFeedPresenter.e(paramHomeFeedPresenter)) {
      return;
    }
    if (paramStoryVideoPublishStatusEvent.e == null)
    {
      SLog.d(this.TAG, "null pointer for feed item");
      return;
    }
    if (paramStoryVideoPublishStatusEvent.e.getOwner() == null)
    {
      SLog.d(this.TAG, "null pointer for feed item user");
      return;
    }
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramStoryVideoPublishStatusEvent);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("home task state write temp:");
    ((StringBuilder)localObject1).append(paramStoryVideoPublishStatusEvent.c.hashCode());
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", ((StringBuilder)localObject1).toString());
    Object localObject2 = HomeFeedPresenter.a(paramHomeFeedPresenter, HomeFeedPresenter.b(paramHomeFeedPresenter), paramStoryVideoPublishStatusEvent.e.date);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GeneralHomeFeed(paramStoryVideoPublishStatusEvent.e);
      int j = HomeFeedPresenter.b(paramHomeFeedPresenter).size();
      int i = 0;
      while (j > i)
      {
        localObject2 = (StoryHomeFeed)HomeFeedPresenter.b(paramHomeFeedPresenter).get(i);
        if ((!(localObject2 instanceof HotRecommendHomeFeed)) || (!((HotRecommendFeedItem)((HotRecommendHomeFeed)localObject2).i()).mIsTopLocation)) {
          break;
        }
        i += 1;
      }
      HomeFeedPresenter.b(paramHomeFeedPresenter).add(i, localObject1);
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
    }
    if (paramStoryVideoPublishStatusEvent.d != null)
    {
      ((GeneralHomeFeed)localObject1).f = paramStoryVideoPublishStatusEvent.e;
      ((GeneralHomeFeed)localObject1).e = false;
    }
    a(paramHomeFeedPresenter, (VideoListHomeFeed)localObject1, paramStoryVideoPublishStatusEvent.a, paramStoryVideoPublishStatusEvent.c, paramStoryVideoPublishStatusEvent.d);
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.UploadStatusRec
 * JD-Core Version:    0.7.0.1
 */