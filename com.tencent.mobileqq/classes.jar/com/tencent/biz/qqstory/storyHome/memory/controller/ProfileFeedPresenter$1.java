package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest;
import com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest.GetProfileYearNodeListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.concurrent.atomic.AtomicBoolean;

class ProfileFeedPresenter$1
  implements CmdTaskManger.CommandCallback<GetProfileYearNodeListRequest, GetProfileYearNodeListRequest.GetProfileYearNodeListResponse>
{
  ProfileFeedPresenter$1(ProfileFeedPresenter paramProfileFeedPresenter, boolean paramBoolean) {}
  
  public void a(@NonNull GetProfileYearNodeListRequest paramGetProfileYearNodeListRequest, @Nullable GetProfileYearNodeListRequest.GetProfileYearNodeListResponse arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (ProfileFeedPresenter.a(this.b).get())
    {
      SLog.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    SLog.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramGetProfileYearNodeListRequest = new ProfileFeedPresenter.GetYearNodeListEvent(this.b, paramErrorMessage);
    paramGetProfileYearNodeListRequest.a = this.a;
    if ((??? != null) && (!paramErrorMessage.isFail()))
    {
      paramGetProfileYearNodeListRequest.b = ???.a;
      ((MemoryManager)SuperManager.a(19)).a(???.a, true);
      synchronized (this.b)
      {
        StoryDispatcher.a().dispatch(paramGetProfileYearNodeListRequest);
        return;
      }
    }
    StoryDispatcher.a().dispatch(paramGetProfileYearNodeListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.1
 * JD-Core Version:    0.7.0.1
 */