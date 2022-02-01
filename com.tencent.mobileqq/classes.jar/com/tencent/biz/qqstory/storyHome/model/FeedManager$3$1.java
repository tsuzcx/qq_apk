package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class FeedManager$3$1
  implements CmdTaskManger.CommandCallback<BatchGetFriendStoryFeedInfoRequest, BaseResponse>
{
  FeedManager$3$1(FeedManager.3 param3) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramBatchGetFriendStoryFeedInfoRequest = (BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)paramBaseResponse;
    paramBaseResponse = new FeedManager.GetFeedItemEvent();
    paramBaseResponse.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramBatchGetFriendStoryFeedInfoRequest == null)) {
      FeedManager.a().remove(this.a.a);
    }
    for (;;)
    {
      SLog.a("Q.qqstory.home.data.FeedManager", "request feed item, net rec , feed id: %s , err :%d", this.a.a, Integer.valueOf(paramErrorMessage.errorCode));
      StoryDispatcher.a().dispatch(paramBaseResponse);
      return;
      if (!paramBatchGetFriendStoryFeedInfoRequest.a.isEmpty())
      {
        paramBaseResponse.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem = this.a.this$0.a(((StoryHomeFeed)paramBatchGetFriendStoryFeedInfoRequest.a.get(0)).a());
      }
      else
      {
        SLog.e("Q.qqstory.home.data.FeedManager", "request feed item, no data return for feedId:%s", new Object[] { this.a.a });
        FeedManager.a().remove(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.3.1
 * JD-Core Version:    0.7.0.1
 */