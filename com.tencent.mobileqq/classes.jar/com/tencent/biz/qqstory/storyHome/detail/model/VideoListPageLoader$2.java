package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoListPageLoader$2
  implements CmdTaskManger.CommandCallback<BatchGetFriendStoryFeedInfoRequest, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp>
{
  VideoListPageLoader$2(VideoListPageLoader paramVideoListPageLoader) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (VideoListPageLoader.c(this.a))
    {
      SLog.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    paramBatchGetFriendStoryFeedInfoRequest = new VideoListPageLoader.GetVideoListEvent(paramErrorMessage, VideoListPageLoader.a(this.a));
    paramBatchGetFriendStoryFeedInfoRequest.d = this.a.a;
    if ((??? != null) && (!paramErrorMessage.isFail()) && (???.a.size() != 0))
    {
      ??? = (StoryHomeFeed)???.a.get(0);
      if (!(??? instanceof VideoListHomeFeed))
      {
        paramBatchGetFriendStoryFeedInfoRequest.g = new ErrorMessage(940001, HardCodeUtil.a(2131913510));
        VideoListPageLoader.a(this.a, paramBatchGetFriendStoryFeedInfoRequest);
        paramBatchGetFriendStoryFeedInfoRequest = new StringBuilder();
        paramBatchGetFriendStoryFeedInfoRequest.append(???.g().toString());
        paramBatchGetFriendStoryFeedInfoRequest.append(" is not a video feed");
        AssertUtils.fail(paramBatchGetFriendStoryFeedInfoRequest.toString(), new Object[0]);
        return;
      }
      ??? = (VideoListHomeFeed)???;
      VideoListPageLoader.a(this.a, ???.i().mVideoNextCookie);
      VideoListPageLoader.a(this.a, ???.i().mVideoPullType);
      VideoListPageLoader.b(this.a, ???.i().mVideoSeq);
      paramBatchGetFriendStoryFeedInfoRequest.a = ???.i().mIsVideoEnd;
      paramBatchGetFriendStoryFeedInfoRequest.h = ???.a();
      paramBatchGetFriendStoryFeedInfoRequest.c = true;
      if ((!paramBatchGetFriendStoryFeedInfoRequest.a) && (TextUtils.isEmpty(VideoListPageLoader.d(this.a)))) {
        paramBatchGetFriendStoryFeedInfoRequest.a = true;
      }
      paramBatchGetFriendStoryFeedInfoRequest.f = ???.i().getOwner().getUnionId();
      paramBatchGetFriendStoryFeedInfoRequest.h = ((FeedManager)SuperManager.a(11)).a(VideoListPageLoader.a(this.a), paramBatchGetFriendStoryFeedInfoRequest.h, paramBatchGetFriendStoryFeedInfoRequest.c);
      paramBatchGetFriendStoryFeedInfoRequest.i = new FeedVideoInfo(VideoListPageLoader.a(this.a), VideoListPageLoader.e(this.a), VideoListPageLoader.b(this.a), VideoListPageLoader.d(this.a), paramBatchGetFriendStoryFeedInfoRequest.a);
      ??? = new ArrayList(paramBatchGetFriendStoryFeedInfoRequest.h.size());
      paramErrorMessage = paramBatchGetFriendStoryFeedInfoRequest.h.iterator();
      while (paramErrorMessage.hasNext()) {
        ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
      }
      GetVidPollInfoHandler.a(???);
      synchronized (this.a)
      {
        this.a.e = true;
        VideoListPageLoader.a(this.a, paramBatchGetFriendStoryFeedInfoRequest);
        return;
      }
    }
    SLog.a("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", VideoListPageLoader.a(this.a));
    VideoListPageLoader.a(this.a, paramBatchGetFriendStoryFeedInfoRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.2
 * JD-Core Version:    0.7.0.1
 */