package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetCommentLikeCountRequest;
import com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone;
import com.tribe.async.dispatch.Dispatcher;

public class GetCommentLikeCountHandler
  implements CmdTaskManger.CommandCallback<GetCommentLikeCountRequest, GetCommentLikeCountRespone>
{
  public void a(@NonNull GetCommentLikeCountRequest paramGetCommentLikeCountRequest, @Nullable GetCommentLikeCountRespone paramGetCommentLikeCountRespone, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetCommentLikeCountRequest = new GetCommentLikeCountHandler.GetCommentLikeCountEvent(paramErrorMessage);
    if ((paramGetCommentLikeCountRespone != null) && (!paramErrorMessage.isFail()))
    {
      paramGetCommentLikeCountRequest.a = paramGetCommentLikeCountRespone.a;
      StoryDispatcher.a().dispatch(paramGetCommentLikeCountRequest);
      return;
    }
    StoryDispatcher.a().dispatch(paramGetCommentLikeCountRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetCommentLikeCountHandler
 * JD-Core Version:    0.7.0.1
 */