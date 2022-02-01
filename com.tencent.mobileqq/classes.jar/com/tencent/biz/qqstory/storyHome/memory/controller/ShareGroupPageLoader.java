package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetShareGroupListRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class ShareGroupPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetShareGroupListRequest, GetShareGroupListResponse>
{
  public String g;
  private String h;
  private boolean i;
  private String j;
  
  private void d()
  {
    GetShareGroupListRequest localGetShareGroupListRequest = new GetShareGroupListRequest();
    localGetShareGroupListRequest.i = this.g;
    localGetShareGroupListRequest.e = this.h;
    localGetShareGroupListRequest.h = 0L;
    localGetShareGroupListRequest.f = 10;
    localGetShareGroupListRequest.g = 10;
    CmdTaskManger.a().a(localGetShareGroupListRequest, this);
    SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localGetShareGroupListRequest.toString());
  }
  
  public void a(@NonNull GetShareGroupListRequest paramGetShareGroupListRequest, @Nullable GetShareGroupListResponse paramGetShareGroupListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.i)
    {
      SLog.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    ShareGroupPageLoader.GetShareGroupListEvent localGetShareGroupListEvent = new ShareGroupPageLoader.GetShareGroupListEvent(paramErrorMessage, this.j);
    localGetShareGroupListEvent.b = false;
    if ((paramGetShareGroupListResponse != null) && (!paramErrorMessage.isFail()))
    {
      this.h = paramGetShareGroupListResponse.e;
      localGetShareGroupListEvent.e = paramGetShareGroupListResponse.a;
      localGetShareGroupListEvent.f = paramGetShareGroupListResponse.b;
      localGetShareGroupListEvent.a = paramGetShareGroupListResponse.f;
      localGetShareGroupListEvent.c = TextUtils.isEmpty(paramGetShareGroupListRequest.e);
      paramGetShareGroupListResponse = paramGetShareGroupListResponse.a;
      ((MemoryManager)SuperManager.a(19)).b(paramGetShareGroupListResponse, paramGetShareGroupListRequest.i, localGetShareGroupListEvent.c);
      try
      {
        this.e = true;
        StoryDispatcher.a().dispatch(localGetShareGroupListEvent);
        SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localGetShareGroupListEvent);
        return;
      }
      finally {}
    }
    StoryDispatcher.a().dispatch(localGetShareGroupListEvent);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.i) {
      return;
    }
    this.h = "";
    d();
  }
  
  public void c()
  {
    super.c();
    if (this.i) {
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader
 * JD-Core Version:    0.7.0.1
 */