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
    if ((paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList != null) && (!paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramBatchGetFeedCommentRequest = (CommentManager)SuperManager.a(17);
      paramBatchGetFeedCommentResp = paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList;
      boolean bool = false;
      paramBatchGetFeedCommentResp = (BatchGetFeedCommentRequest.FeedCommentInfo)paramBatchGetFeedCommentResp.get(0);
      if (paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList != null)
      {
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramBatchGetFeedCommentResp.jdField_a_of_type_JavaLangString, Integer.valueOf(paramBatchGetFeedCommentResp.jdField_a_of_type_Int), Integer.valueOf(paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList.size()) });
        paramBatchGetFeedCommentRequest.a(paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
        paramBatchGetFeedCommentRequest = new CommentListPageLoader.GetFeedCommentEvent(paramErrorMessage, paramBatchGetFeedCommentResp.jdField_a_of_type_JavaLangString, 1);
        paramBatchGetFeedCommentRequest.jdField_a_of_type_JavaUtilList = paramBatchGetFeedCommentResp.jdField_a_of_type_JavaUtilList;
        paramBatchGetFeedCommentRequest.c = true;
        if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {
          bool = true;
        }
        paramBatchGetFeedCommentRequest.jdField_a_of_type_Boolean = bool;
        paramBatchGetFeedCommentRequest.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
        paramBatchGetFeedCommentRequest.jdField_b_of_type_Int = paramBatchGetFeedCommentResp.jdField_a_of_type_Int;
        StoryDispatcher.a().dispatch(paramBatchGetFeedCommentRequest);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.5
 * JD-Core Version:    0.7.0.1
 */