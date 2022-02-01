package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;

class DetailLikeListLoader$2
  implements CmdTaskManger.CommandCallback<DetailLikeListLoader.GetLikeListRequest, DetailLikeListLoader.GetLikeListResponse>
{
  DetailLikeListLoader$2(DetailLikeListLoader paramDetailLikeListLoader, boolean paramBoolean) {}
  
  public void a(@NonNull DetailLikeListLoader.GetLikeListRequest paramGetLikeListRequest, @Nullable DetailLikeListLoader.GetLikeListResponse arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetLikeListRequest = new DetailLikeListLoader.GetLikeListEvent(paramErrorMessage, DetailLikeListLoader.a(this.b));
    paramGetLikeListRequest.h = false;
    paramGetLikeListRequest.b = DetailLikeListLoader.c(this.b);
    paramGetLikeListRequest.c = DetailLikeListLoader.b(this.b);
    if ((??? != null) && (!paramErrorMessage.isFail()))
    {
      paramGetLikeListRequest.e = ???.b;
      paramGetLikeListRequest.d = ???.a;
      paramGetLikeListRequest.f = ???.e;
      paramGetLikeListRequest.i = this.a;
      ((LikeManager)SuperManager.a(15)).a(paramGetLikeListRequest.f, DetailLikeListLoader.a(this.b), DetailLikeListLoader.e(this.b), true);
      synchronized (this.b)
      {
        DetailLikeListLoader.a(this.b, true);
        StoryDispatcher.a().dispatch(paramGetLikeListRequest);
        SLog.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramGetLikeListRequest);
        return;
      }
    }
    StoryDispatcher.a().dispatch(paramGetLikeListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.2
 * JD-Core Version:    0.7.0.1
 */