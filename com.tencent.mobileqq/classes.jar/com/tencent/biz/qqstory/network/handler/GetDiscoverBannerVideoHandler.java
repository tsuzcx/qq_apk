package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetDiscoverBannerVideoRequest;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class GetDiscoverBannerVideoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  public String a;
  public String b;
  
  public void a()
  {
    AssertUtils.a(this.a);
    GetDiscoverBannerVideoRequest localGetDiscoverBannerVideoRequest = new GetDiscoverBannerVideoRequest();
    localGetDiscoverBannerVideoRequest.b = this.a;
    localGetDiscoverBannerVideoRequest.c = this.b;
    CmdTaskManger.a().a(localGetDiscoverBannerVideoRequest, this);
  }
  
  public void a(@NonNull GetDiscoverBannerVideoRequest paramGetDiscoverBannerVideoRequest, @Nullable GetDiscoverBannerVideoResponse paramGetDiscoverBannerVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramGetDiscoverBannerVideoResponse == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.discover.GetDiscoverBannerVideoHandler", 2, "get banner info back failed. bannerId = " + this.a);
      }
      return;
    }
    ((DiscoverManager)SuperManager.a(22)).a(this.a, paramGetDiscoverBannerVideoResponse);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.discover.GetDiscoverBannerVideoHandler", 2, "saved banner info to db. bannerId = " + this.a);
    }
    paramGetDiscoverBannerVideoRequest = new GetDiscoverBannerVideoHandler.GetDiscoverBannerVideoEvent(paramGetDiscoverBannerVideoResponse);
    paramGetDiscoverBannerVideoRequest.errorInfo = paramErrorMessage;
    Dispatchers.get().dispatch(paramGetDiscoverBannerVideoRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetDiscoverBannerVideoHandler
 * JD-Core Version:    0.7.0.1
 */