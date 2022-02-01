package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.FeedCommentInfo;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class HomeFeedPresenter$5
  implements CmdTaskManger.CommandCallback<BatchGetFeedCommentRequest, BatchGetFeedCommentRequest.BatchGetFeedCommentResp>
{
  HomeFeedPresenter$5(VideoListHomeFeed paramVideoListHomeFeed) {}
  
  public void a(@NonNull BatchGetFeedCommentRequest paramBatchGetFeedCommentRequest, @Nullable BatchGetFeedCommentRequest.BatchGetFeedCommentResp paramBatchGetFeedCommentResp, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramBatchGetFeedCommentResp == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new BatchGetFeedCommentRequest.BatchGetFeedCommentResp(paramErrorMessage);
      return;
    }
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
    }
    if ((paramBatchGetFeedCommentResp.a != null) && (!paramBatchGetFeedCommentResp.a.isEmpty()))
    {
      paramBatchGetFeedCommentRequest = (CommentManager)SuperManager.a(17);
      paramBatchGetFeedCommentResp = paramBatchGetFeedCommentResp.a;
      boolean bool = false;
      paramBatchGetFeedCommentResp = (BatchGetFeedCommentRequest.FeedCommentInfo)paramBatchGetFeedCommentResp.get(0);
      if (paramBatchGetFeedCommentResp.e != null)
      {
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramBatchGetFeedCommentResp.a, Integer.valueOf(paramBatchGetFeedCommentResp.b), Integer.valueOf(paramBatchGetFeedCommentResp.e.size()) });
        paramBatchGetFeedCommentRequest.a(paramBatchGetFeedCommentResp.e, this.a.f.feedId, true, true);
        paramBatchGetFeedCommentRequest = new CommentListPageLoader.GetFeedCommentEvent(paramErrorMessage, paramBatchGetFeedCommentResp.a, 1);
        paramBatchGetFeedCommentRequest.k = paramBatchGetFeedCommentResp.e;
        paramBatchGetFeedCommentRequest.c = true;
        if (((CommentLikeFeedItem)this.a.f).mCommentIsEnd == 1) {
          bool = true;
        }
        paramBatchGetFeedCommentRequest.a = bool;
        paramBatchGetFeedCommentRequest.h = ((CommentLikeFeedItem)this.a.f).mCommentLastCookie;
        paramBatchGetFeedCommentRequest.i = paramBatchGetFeedCommentResp.b;
        StoryDispatcher.a().dispatch(paramBatchGetFeedCommentRequest);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.5
 * JD-Core Version:    0.7.0.1
 */