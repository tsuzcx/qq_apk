package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class DetailFeedAllInfoPuller$FeedItemPullSegment$1
  implements CmdTaskManger.CommandCallback<BatchGetFriendStoryFeedInfoRequest, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp>
{
  DetailFeedAllInfoPuller$FeedItemPullSegment$1(DetailFeedAllInfoPuller.FeedItemPullSegment paramFeedItemPullSegment, JobContext paramJobContext) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((!paramErrorMessage.isFail()) && (paramGetFriendStoryFeedInfoResp != null))
    {
      paramBatchGetFriendStoryFeedInfoRequest = (FeedManager)SuperManager.a(11);
      if (paramGetFriendStoryFeedInfoResp.a.size() < 1)
      {
        SLog.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
        paramBatchGetFriendStoryFeedInfoRequest.e(DetailFeedAllInfoPuller.a(this.b.a));
        paramBatchGetFriendStoryFeedInfoRequest = new ErrorMessage(2222, "no feed data back.");
        DetailFeedAllInfoPuller.FeedItemPullSegment.b(this.b, paramBatchGetFriendStoryFeedInfoRequest);
        return;
      }
      paramGetFriendStoryFeedInfoResp = (CommentLikeHomeFeed)paramGetFriendStoryFeedInfoResp.a.get(0);
      if ((paramGetFriendStoryFeedInfoResp instanceof VideoListHomeFeed))
      {
        paramErrorMessage = (VideoListHomeFeed)paramGetFriendStoryFeedInfoResp;
        if ((DetailFeedAllInfoPuller.b(this.b.a).a == null) || (DetailFeedAllInfoPuller.b(this.b.a).f().mVideoSeq != paramErrorMessage.i().mVideoSeq))
        {
          DetailFeedAllInfoPuller.b(this.b.a).a = paramGetFriendStoryFeedInfoResp.c();
          DetailFeedAllInfoPuller.b(this.b.a).a(paramBatchGetFriendStoryFeedInfoRequest.a(DetailFeedAllInfoPuller.a(this.b.a), paramGetFriendStoryFeedInfoResp.a(), true), true);
          ((FeedVideoManager)SuperManager.a(12)).a(2, DetailFeedAllInfoPuller.b(this.b.a).a.feedId, DetailFeedAllInfoPuller.b(this.b.a).f().mVideoSeq, DetailFeedAllInfoPuller.b(this.b.a).a(), DetailFeedAllInfoPuller.b(this.b.a).f().mVideoNextCookie, DetailFeedAllInfoPuller.b(this.b.a).f().mIsVideoEnd, DetailFeedAllInfoPuller.b(this.b.a).f().mVideoPullType, true);
        }
      }
      else
      {
        DetailFeedAllInfoPuller.b(this.b.a).a = paramGetFriendStoryFeedInfoResp.c();
      }
      DetailFeedAllInfoPuller.b(this.b.a).a = ((CommentLikeFeedItem)paramBatchGetFriendStoryFeedInfoRequest.a(DetailFeedAllInfoPuller.b(this.b.a).a));
      paramBatchGetFriendStoryFeedInfoRequest = this.b;
      DetailFeedAllInfoPuller.FeedItemPullSegment.a(paramBatchGetFriendStoryFeedInfoRequest, DetailFeedAllInfoPuller.b(paramBatchGetFriendStoryFeedInfoRequest.a));
      return;
    }
    SLog.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
    DetailFeedAllInfoPuller.FeedItemPullSegment.a(this.b, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.FeedItemPullSegment.1
 * JD-Core Version:    0.7.0.1
 */