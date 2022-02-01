package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetJoinedShareGroupFriListRequest;
import com.tencent.biz.qqstory.network.response.GetJoinedShareGroupFriListResponse;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;

public class GetJoinedShareGroupFriListHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetJoinedShareGroupFriListRequest, GetJoinedShareGroupFriListResponse>
{
  public String c;
  public boolean d;
  public String e;
  
  public void a()
  {
    Object localObject = new GetJoinedShareGroupFriListRequest();
    ((GetJoinedShareGroupFriListRequest)localObject).f = this.c;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetJoinedShareGroupFriListHandler sendRequest groupID = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.e("Q.qqstory.shareGroup.GetJoinedShareGroupFriListHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(@NonNull GetJoinedShareGroupFriListRequest paramGetJoinedShareGroupFriListRequest, @Nullable GetJoinedShareGroupFriListResponse paramGetJoinedShareGroupFriListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetJoinedShareGroupFriListRequest = new GetJoinedShareGroupFriListHandler.GetJoinedShareGroupFriListEvent();
    paramGetJoinedShareGroupFriListRequest.g = paramErrorMessage;
    paramGetJoinedShareGroupFriListRequest.a = this.c;
    paramGetJoinedShareGroupFriListRequest.b = this.d;
    paramGetJoinedShareGroupFriListRequest.c = this.e;
    if ((paramErrorMessage.isSuccess()) && (paramGetJoinedShareGroupFriListResponse != null))
    {
      paramGetJoinedShareGroupFriListRequest.d = paramGetJoinedShareGroupFriListResponse.a;
      c();
    }
    else
    {
      d();
    }
    StoryDispatcher.a().dispatch(paramGetJoinedShareGroupFriListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetJoinedShareGroupFriListHandler
 * JD-Core Version:    0.7.0.1
 */