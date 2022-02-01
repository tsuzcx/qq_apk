package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.AddGroupVideoRequest;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class StoryVideoUploadManager$2
  implements CmdTaskManger.CommandCallback<AddGroupVideoRequest, AddGroupVideoResponse>
{
  StoryVideoUploadManager$2(VideoListFeedItem paramVideoListFeedItem, List paramList, StoryManager paramStoryManager) {}
  
  public void a(@NonNull AddGroupVideoRequest paramAddGroupVideoRequest, @Nullable AddGroupVideoResponse paramAddGroupVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool1;
    if ((paramAddGroupVideoResponse != null) && (!paramErrorMessage.isFail())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramAddGroupVideoResponse.a() != null)
      {
        bool2 = bool1;
        if (paramAddGroupVideoResponse.a().size() != 1) {
          bool2 = true;
        }
      }
    }
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool2) });
    paramAddGroupVideoRequest = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
    paramAddGroupVideoRequest.b = false;
    paramAddGroupVideoRequest.f = new ArrayList(1);
    paramErrorMessage = new StoryVideoUploadManager.ShareGroupFakeItem();
    paramErrorMessage.a = this.a;
    Object localObject2;
    if (!bool2)
    {
      localObject1 = (AddGroupVideoResponse.AddGroupFeed)paramAddGroupVideoResponse.a().get(0);
      localObject2 = this.a;
      if (((localObject2 instanceof ShareGroupFeedItem)) && (((VideoListFeedItem)localObject2).feedId.equals(((AddGroupVideoResponse.AddGroupFeed)localObject1).b)))
      {
        paramErrorMessage.b = ((ShareGroupFeedItem)this.a);
      }
      else
      {
        paramErrorMessage.b = new ShareGroupFeedItem();
        paramErrorMessage.b.copy(paramErrorMessage.a);
        paramErrorMessage.b.feedId = ((AddGroupVideoResponse.AddGroupFeed)localObject1).b;
        if (paramErrorMessage.b.videoCount == 0) {
          paramErrorMessage.b.videoCount = 1;
        }
        AssertUtils.checkNotEmpty(((AddGroupVideoResponse.AddGroupFeed)localObject1).b);
        localObject1 = (FeedManager)SuperManager.a(11);
        paramErrorMessage.b = ((ShareGroupFeedItem)((FeedManager)localObject1).a(paramErrorMessage.b));
        ((FeedManager)localObject1).a(paramErrorMessage.b.ownerId, paramErrorMessage.b.date, paramErrorMessage.b.feedId);
      }
    }
    Object localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
      int i;
      if (bool2) {
        i = 6;
      } else {
        i = 5;
      }
      ((StoryVideoItem)localObject2).mUploadStatus = i;
      StoryVideoUploadManager.OneVideoInfo localOneVideoInfo = new StoryVideoUploadManager.OneVideoInfo();
      localOneVideoInfo.a = this.c.a((StoryVideoItem)localObject2);
      paramErrorMessage.c.add(localOneVideoInfo);
      if (!bool2)
      {
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(localObject2);
        List localList = paramAddGroupVideoResponse.a();
        localStoryVideoItem.mVid = ((String)((AddGroupVideoResponse.AddGroupFeed)localList.get(0)).c.get(((StoryVideoItem)localObject2).sourceVid));
        localStoryVideoItem.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem.mVid))
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { ((StoryVideoItem)localObject2).sourceVid, localList });
          AssertUtils.checkNotEmpty(localStoryVideoItem.mVid);
          localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        }
        localOneVideoInfo.b = this.c.a(localStoryVideoItem);
      }
    }
    paramAddGroupVideoRequest.f.add(paramErrorMessage);
    StoryDispatcher.a().dispatch(paramAddGroupVideoRequest);
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { paramAddGroupVideoRequest });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.2
 * JD-Core Version:    0.7.0.1
 */