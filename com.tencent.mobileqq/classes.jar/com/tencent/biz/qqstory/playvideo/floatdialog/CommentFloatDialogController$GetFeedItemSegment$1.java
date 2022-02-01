package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class CommentFloatDialogController$GetFeedItemSegment$1
  implements CmdTaskManger.CommandCallback<BatchGetFriendStoryFeedInfoRequest, BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp>
{
  CommentFloatDialogController$GetFeedItemSegment$1(CommentFloatDialogController.GetFeedItemSegment paramGetFeedItemSegment, JobContext paramJobContext, DetailFeedItem paramDetailFeedItem) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.a.isJobCancelled())
    {
      SLog.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((!paramErrorMessage.isFail()) && (paramGetFriendStoryFeedInfoResp != null))
    {
      paramBatchGetFriendStoryFeedInfoRequest = (FeedManager)SuperManager.a(11);
      if (paramGetFriendStoryFeedInfoResp.a.size() < 1)
      {
        SLog.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
        paramBatchGetFriendStoryFeedInfoRequest.e(CommentFloatDialogController.d(this.c.a));
        paramBatchGetFriendStoryFeedInfoRequest = new ErrorMessage(2222, "no feed data back.");
        CommentFloatDialogController.GetFeedItemSegment.b(this.c, paramBatchGetFriendStoryFeedInfoRequest);
        return;
      }
      paramGetFriendStoryFeedInfoResp = (CommentLikeHomeFeed)paramGetFriendStoryFeedInfoResp.a.get(0);
      if ((paramGetFriendStoryFeedInfoResp instanceof VideoListHomeFeed))
      {
        paramErrorMessage = (VideoListHomeFeed)paramGetFriendStoryFeedInfoResp;
        this.b.a = paramGetFriendStoryFeedInfoResp.c();
        this.b.a(paramBatchGetFriendStoryFeedInfoRequest.a(CommentFloatDialogController.d(this.c.a), paramErrorMessage.a(), true), true);
        ((FeedVideoManager)SuperManager.a(12)).a(2, this.b.a.feedId, this.b.f().mVideoSeq, this.b.a(), this.b.f().mVideoNextCookie, this.b.f().mIsVideoEnd, this.b.f().mVideoPullType, true);
      }
      else
      {
        this.b.a = paramGetFriendStoryFeedInfoResp.c();
      }
      this.b.a = ((CommentLikeFeedItem)paramBatchGetFriendStoryFeedInfoRequest.a(CommentFloatDialogController.a(this.c.a).a));
      CommentFloatDialogController.GetFeedItemSegment.a(this.c, this.b);
      return;
    }
    SLog.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
    CommentFloatDialogController.GetFeedItemSegment.a(this.c, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetFeedItemSegment.1
 * JD-Core Version:    0.7.0.1
 */