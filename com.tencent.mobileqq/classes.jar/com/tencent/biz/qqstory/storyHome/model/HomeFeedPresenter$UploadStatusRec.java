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
  extends UIBaseEventReceiver
{
  public HomeFeedPresenter$UploadStatusRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  private void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, VideoListHomeFeed paramVideoListHomeFeed, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    Object localObject = paramVideoListHomeFeed.a().iterator();
    int i = 0;
    StoryVideoItem localStoryVideoItem;
    if (((Iterator)localObject).hasNext())
    {
      localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
      if (localStoryVideoItem.equals(paramStoryVideoItem1))
      {
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
        if (paramStoryVideoItem2 == null) {
          localStoryVideoItem.copy(paramStoryVideoItem1);
        }
      }
    }
    label67:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramBoolean) {
          break label460;
        }
        paramBoolean = true;
        label81:
        paramVideoListHomeFeed.a(paramStoryVideoItem1, paramBoolean);
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
        paramStoryVideoItem2 = (FeedVideoManager)SuperManager.a(12);
        localObject = ((VideoListFeedItem)paramVideoListHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
        ((FeedVideoInfo)localObject).mVideoItemList.clear();
        ((FeedVideoInfo)localObject).mVideoItemList.addAll(paramVideoListHomeFeed.a());
        paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject).feedId, ((FeedVideoInfo)localObject).mVideoSeq, ((FeedVideoInfo)localObject).mVideoItemList, ((FeedVideoInfo)localObject).mVideoNextCookie, ((FeedVideoInfo)localObject).mIsVideoEnd, ((FeedVideoInfo)localObject).mVideoPullType, true);
        if (QLog.isDebugVersion()) {
          SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", HomeFeedPresenter.a(paramHomeFeedPresenter));
        }
        HomeFeedPresenter.a(paramHomeFeedPresenter).remove(paramVideoListHomeFeed);
        HomeFeedPresenter.a(paramHomeFeedPresenter).add(0, paramVideoListHomeFeed);
        if (QLog.isDebugVersion()) {
          SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", HomeFeedPresenter.a(paramHomeFeedPresenter));
        }
        if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramVideoListHomeFeed instanceof GeneralHomeFeed)))
        {
          paramStoryVideoItem2 = paramVideoListHomeFeed.d;
          paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
          if (paramStoryVideoItem2.size() <= 0) {
            break label465;
          }
          paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
        }
      }
      for (;;)
      {
        SLog.d(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramVideoListHomeFeed.a().feedId });
        HomeFeedPresenter.a(paramHomeFeedPresenter).a(paramVideoListHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
        return;
        paramVideoListHomeFeed.a(i, paramStoryVideoItem2);
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { localStoryVideoItem.mVid, paramStoryVideoItem2 });
        paramStoryVideoItem2 = (FeedVideoManager)SuperManager.a(12);
        localObject = ((VideoListFeedItem)paramVideoListHomeFeed.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).getVideoInfo();
        ((FeedVideoInfo)localObject).mVideoItemList.clear();
        ((FeedVideoInfo)localObject).mVideoItemList.addAll(paramVideoListHomeFeed.a());
        paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject).feedId, ((FeedVideoInfo)localObject).mVideoSeq, ((FeedVideoInfo)localObject).mVideoItemList, ((FeedVideoInfo)localObject).mVideoNextCookie, ((FeedVideoInfo)localObject).mIsVideoEnd, ((FeedVideoInfo)localObject).mVideoPullType, true);
        break label67;
        i += 1;
        break;
        label460:
        paramBoolean = false;
        break label81;
        label465:
        paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
      }
    }
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.a())
    {
      SLog.b(this.TAG, "group video upload");
      return;
    }
    Object localObject2;
    label33:
    Object localObject3;
    Object localObject1;
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = paramStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StoryVideoUploadManager.ShareGroupFakeItem)((Iterator)localObject2).next();
        if (!(((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
        {
          AssertUtils.a("fake item type error", new Object[0]);
        }
        else
        {
          localObject1 = (ShareGroupItem)((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
          if (HomeFeedPresenter.a(paramHomeFeedPresenter, ((ShareGroupItem)localObject1).shareGroupId))
          {
            localObject1 = HomeFeedPresenter.a(paramHomeFeedPresenter, HomeFeedPresenter.a(paramHomeFeedPresenter), ((ShareGroupItem)localObject1).shareGroupId, ((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.date);
            if (localObject1 != null) {
              break label449;
            }
            if ((((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem))
            {
              localObject1 = new ShareGroupHomeFeed((ShareGroupFeedItem)((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
              HomeFeedPresenter.a(paramHomeFeedPresenter).add(0, localObject1);
            }
            SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
          }
        }
      }
    }
    label449:
    for (;;)
    {
      if ((((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem != null) && ((localObject1 instanceof ShareGroupHomeFeed))) {
        ((VideoListHomeFeed)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = ((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem;
      }
      localObject3 = ((StoryVideoUploadManager.ShareGroupFakeItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        StoryVideoUploadManager.OneVideoInfo localOneVideoInfo = (StoryVideoUploadManager.OneVideoInfo)((Iterator)localObject3).next();
        a(paramHomeFeedPresenter, (VideoListHomeFeed)localObject1, paramStoryVideoPublishStatusEvent.jdField_a_of_type_Boolean, localOneVideoInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localOneVideoInfo.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      break label33;
      if ((!paramStoryVideoPublishStatusEvent.jdField_b_of_type_Boolean) || (!HomeFeedPresenter.a(paramHomeFeedPresenter))) {
        break;
      }
      if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem == null)
      {
        SLog.d(this.TAG, "null pointer for feed item");
        return;
      }
      if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.getOwner() == null)
      {
        SLog.d(this.TAG, "null pointer for feed item user");
        return;
      }
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramStoryVideoPublishStatusEvent);
      SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.hashCode());
      localObject2 = HomeFeedPresenter.a(paramHomeFeedPresenter, HomeFeedPresenter.a(paramHomeFeedPresenter), paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.date);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new GeneralHomeFeed(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
        HomeFeedPresenter.a(paramHomeFeedPresenter).add(0, localObject1);
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
      }
      if (paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null)
      {
        ((GeneralHomeFeed)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem;
        ((GeneralHomeFeed)localObject1).jdField_a_of_type_Boolean = false;
      }
      a(paramHomeFeedPresenter, (VideoListHomeFeed)localObject1, paramStoryVideoPublishStatusEvent.jdField_a_of_type_Boolean, paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.UploadStatusRec
 * JD-Core Version:    0.7.0.1
 */