package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetGroupVidListRequest;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class TroopUidToVidListHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetGroupVidListRequest, GetGroupVidListResponse>
{
  protected String c;
  protected int d;
  
  public TroopUidToVidListHandler(String paramString, int paramInt)
  {
    this.c = paramString;
    this.d = paramInt;
  }
  
  public void a()
  {
    GetGroupVidListRequest localGetGroupVidListRequest = new GetGroupVidListRequest();
    localGetGroupVidListRequest.g = this.d;
    localGetGroupVidListRequest.f = this.c;
    CmdTaskManger.a().a(localGetGroupVidListRequest, this);
  }
  
  public void a(@NonNull GetGroupVidListRequest paramGetGroupVidListRequest, @Nullable GetGroupVidListResponse paramGetGroupVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    TroopUidToVidListHandler.GetTroopVidListEvent localGetTroopVidListEvent = new TroopUidToVidListHandler.GetTroopVidListEvent();
    localGetTroopVidListEvent.g = paramErrorMessage;
    localGetTroopVidListEvent.b = paramGetGroupVidListRequest.f;
    localGetTroopVidListEvent.a = paramGetGroupVidListRequest.g;
    if ((paramGetGroupVidListResponse != null) && (!paramErrorMessage.isFail()))
    {
      c();
      paramGetGroupVidListRequest = (StoryManager)SuperManager.a(5);
      if (this.d == 3)
      {
        paramGetGroupVidListRequest.b(paramGetGroupVidListResponse.a.a, 1, paramGetGroupVidListResponse.a.b, true);
        paramErrorMessage = paramGetGroupVidListRequest.a(paramGetGroupVidListResponse.a.a, 1);
        if (paramErrorMessage != null)
        {
          int i = paramGetGroupVidListResponse.a.b.size();
          SLog.a("Q.qqstory.net:TroopUidToVidListHandler", "update %s unread count , old : %d , new : %d", paramGetGroupVidListResponse.a.a, Integer.valueOf(paramErrorMessage.unReadCount), Integer.valueOf(i));
          paramErrorMessage.unReadCount = i;
          paramGetGroupVidListRequest.a(paramGetGroupVidListResponse.a.a, 1, paramErrorMessage);
        }
      }
      localGetTroopVidListEvent.c = paramGetGroupVidListResponse.a;
      StoryDispatcher.a().dispatch(localGetTroopVidListEvent);
      return;
    }
    d();
    StoryDispatcher.a().dispatch(localGetTroopVidListEvent);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopUnionIdToVidHandler{mUin=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPullType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler
 * JD-Core Version:    0.7.0.1
 */