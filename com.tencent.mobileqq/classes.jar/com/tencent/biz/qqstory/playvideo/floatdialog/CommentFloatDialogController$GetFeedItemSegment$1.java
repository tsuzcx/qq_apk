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
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramGetFriendStoryFeedInfoResp == null))
    {
      SLog.a("Q.qqstory.player.CommentFloatDialogController", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      CommentFloatDialogController.GetFeedItemSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetFeedItemSegment, paramErrorMessage);
      return;
    }
    paramBatchGetFriendStoryFeedInfoRequest = (FeedManager)SuperManager.a(11);
    if (paramGetFriendStoryFeedInfoResp.a.size() < 1)
    {
      SLog.e("Q.qqstory.player.CommentFloatDialogController", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramBatchGetFriendStoryFeedInfoRequest.a(CommentFloatDialogController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetFeedItemSegment.a));
      paramBatchGetFriendStoryFeedInfoRequest = new ErrorMessage(2222, "no feed data back.");
      CommentFloatDialogController.GetFeedItemSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetFeedItemSegment, paramBatchGetFriendStoryFeedInfoRequest);
      return;
    }
    paramGetFriendStoryFeedInfoResp = (CommentLikeHomeFeed)paramGetFriendStoryFeedInfoResp.a.get(0);
    if ((paramGetFriendStoryFeedInfoResp instanceof VideoListHomeFeed))
    {
      paramErrorMessage = (VideoListHomeFeed)paramGetFriendStoryFeedInfoResp;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a = paramGetFriendStoryFeedInfoResp.a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(paramBatchGetFriendStoryFeedInfoRequest.a(CommentFloatDialogController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetFeedItemSegment.a), paramErrorMessage.a(), true), true);
      ((FeedVideoManager)SuperManager.a(12)).a(2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.feedId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoSeq, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoNextCookie, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mIsVideoEnd, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mVideoPullType, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a = ((CommentLikeFeedItem)paramBatchGetFriendStoryFeedInfoRequest.a(CommentFloatDialogController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetFeedItemSegment.a).a));
      CommentFloatDialogController.GetFeedItemSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController$GetFeedItemSegment, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a = paramGetFriendStoryFeedInfoResp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetFeedItemSegment.1
 * JD-Core Version:    0.7.0.1
 */