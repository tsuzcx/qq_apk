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
import com.tencent.biz.qqstory.network.request.GetVidListRequest;
import com.tencent.biz.qqstory.network.response.GetVidListResponse;
import com.tencent.biz.qqstory.network.response.GetVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UidToVidHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetVidListRequest, GetVidListResponse>
{
  protected List<String> c = new ArrayList();
  protected int d;
  
  public UidToVidHandler(List<String> paramList, int paramInt)
  {
    if (paramList != null) {
      this.c.addAll(paramList);
    }
    this.d = paramInt;
  }
  
  public void a()
  {
    GetVidListRequest localGetVidListRequest = new GetVidListRequest();
    localGetVidListRequest.g = this.d;
    localGetVidListRequest.f = this.c;
    CmdTaskManger.a().a(localGetVidListRequest, this);
  }
  
  public void a(@NonNull GetVidListRequest paramGetVidListRequest, @Nullable GetVidListResponse paramGetVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    UidToVidHandler.GetUserVidListEvent localGetUserVidListEvent = new UidToVidHandler.GetUserVidListEvent();
    localGetUserVidListEvent.g = paramErrorMessage;
    localGetUserVidListEvent.b = paramGetVidListRequest.f;
    localGetUserVidListEvent.a = paramGetVidListRequest.g;
    if ((paramGetVidListResponse != null) && (!paramErrorMessage.isFail()))
    {
      c();
      paramGetVidListRequest = (StoryManager)SuperManager.a(5);
      paramErrorMessage = paramGetVidListResponse.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        GetVidListResponse.UserVidList localUserVidList = (GetVidListResponse.UserVidList)paramErrorMessage.next();
        int i = this.d;
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              if (i != 6)
              {
                if (i == 7) {}
              }
              else
              {
                paramGetVidListRequest.b(localUserVidList.a, 3, localUserVidList.b, true);
                continue;
              }
            }
            paramGetVidListRequest.b(localUserVidList.a, 0, localUserVidList.b, true);
          }
          else
          {
            paramGetVidListRequest.b(localUserVidList.a, 0, localUserVidList.b, true);
          }
        }
        else
        {
          paramGetVidListRequest.b(localUserVidList.a, 1, localUserVidList.b, true);
          StoryItem localStoryItem = paramGetVidListRequest.a(localUserVidList.a, 1);
          if (localStoryItem != null)
          {
            i = localUserVidList.b.size();
            SLog.a("Q.qqstory.net:UidToVidHandler", "update %s unread count , old : %d , new : %d", localUserVidList.a, Integer.valueOf(localStoryItem.unReadCount), Integer.valueOf(i));
            localStoryItem.unReadCount = i;
            paramGetVidListRequest.a(localUserVidList.a, 1, localStoryItem);
          }
        }
      }
      localGetUserVidListEvent.c = paramGetVidListResponse.a;
      StoryDispatcher.a().dispatch(localGetUserVidListEvent);
      return;
    }
    d();
    StoryDispatcher.a().dispatch(localGetUserVidListEvent);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UidToVidHandler{mUidList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPullType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.UidToVidHandler
 * JD-Core Version:    0.7.0.1
 */