package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetSimpleInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetSimpleInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class DateVideoSimpleInfoPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetSimpleInfoListRequest, GetSimpleInfoListResponse>
{
  protected final int g;
  protected List<String> h;
  
  private void d()
  {
    if (this.h.size() == 0) {
      SLog.d("Q.qqstory.memories:DateVideoSimpleInfoPageLoader", "vid list has pulled to end!");
    }
    int i = Math.min(20, this.h.size());
    List localList = this.h;
    boolean bool = false;
    localList = localList.subList(0, i);
    GetSimpleInfoListRequest localGetSimpleInfoListRequest = new GetSimpleInfoListRequest();
    localGetSimpleInfoListRequest.e = localList;
    if (i == this.h.size()) {
      bool = true;
    }
    localGetSimpleInfoListRequest.f = bool;
    CmdTaskManger.a().a(localGetSimpleInfoListRequest, this);
  }
  
  public void a(@NonNull GetSimpleInfoListRequest paramGetSimpleInfoListRequest, @Nullable GetSimpleInfoListResponse paramGetSimpleInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    DateVideoSimpleInfoPageLoader.GetSimpleInfoListEvent localGetSimpleInfoListEvent = new DateVideoSimpleInfoPageLoader.GetSimpleInfoListEvent(paramErrorMessage);
    if ((paramGetSimpleInfoListResponse != null) && (!paramErrorMessage.isFail()))
    {
      paramGetSimpleInfoListResponse.a = ((StoryManager)SuperManager.a(5)).a(paramGetSimpleInfoListResponse.a);
      localGetSimpleInfoListEvent.c = false;
      localGetSimpleInfoListEvent.a = paramGetSimpleInfoListRequest.f;
      localGetSimpleInfoListEvent.b = false;
      localGetSimpleInfoListEvent.e = this.g;
      localGetSimpleInfoListEvent.f = paramGetSimpleInfoListResponse.a;
      paramGetSimpleInfoListResponse = new ArrayList(this.h);
      paramGetSimpleInfoListResponse.removeAll(paramGetSimpleInfoListRequest.e);
      this.h = paramGetSimpleInfoListResponse;
      StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
      return;
    }
    StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    d();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateVideoSimpleInfoPageLoader
 * JD-Core Version:    0.7.0.1
 */