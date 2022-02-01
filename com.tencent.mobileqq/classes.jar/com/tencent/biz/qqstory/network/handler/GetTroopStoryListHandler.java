package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.network.request.GetTroopStoryListRequest;
import com.tencent.biz.qqstory.network.response.GetTroopStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tribe.async.dispatch.Dispatcher;

public class GetTroopStoryListHandler
  implements CmdTaskManger.CommandCallback<GetTroopStoryListRequest, GetTroopStoryListResponse>
{
  StoryConfigManager a;
  String b;
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    GetTroopStoryListRequest localGetTroopStoryListRequest = new GetTroopStoryListRequest();
    localGetTroopStoryListRequest.e = paramLong;
    localGetTroopStoryListRequest.g = 20;
    localGetTroopStoryListRequest.f = paramInt2;
    localGetTroopStoryListRequest.i = paramInt1;
    StoryConfigManager localStoryConfigManager = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TROOP_STORY_TIMEZONE");
    localStringBuilder.append(String.valueOf(paramLong));
    paramInt1 = ((Integer)localStoryConfigManager.c(localStringBuilder.toString(), Integer.valueOf(-1))).intValue();
    paramInt2 = UIUtils.b();
    if (paramInt1 != paramInt2)
    {
      localStoryConfigManager = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TROOP_STORY_TIMEZONE");
      localStringBuilder.append(String.valueOf(paramLong));
      localStoryConfigManager.d(localStringBuilder.toString(), Integer.valueOf(paramInt2));
      localGetTroopStoryListRequest.i = 0;
    }
    localGetTroopStoryListRequest.h = paramInt2;
    CmdTaskManger.a().a(localGetTroopStoryListRequest, this);
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1)
    {
      StoryConfigManager localStoryConfigManager = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TROOP_STORY_COOKIE");
      localStringBuilder.append(String.valueOf(paramLong));
      i = ((Integer)localStoryConfigManager.c(localStringBuilder.toString(), Integer.valueOf(0))).intValue();
    }
    a(paramLong, 0, i);
  }
  
  public void a(@NonNull GetTroopStoryListRequest paramGetTroopStoryListRequest, @Nullable GetTroopStoryListResponse paramGetTroopStoryListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    GetTroopStoryListHandler.GetTroopStoryListEvent localGetTroopStoryListEvent = new GetTroopStoryListHandler.GetTroopStoryListEvent(this.b, paramErrorMessage);
    int i = paramGetTroopStoryListRequest.f;
    boolean bool2 = true;
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGetTroopStoryListEvent.c = bool1;
    if ((paramGetTroopStoryListResponse != null) && (!paramErrorMessage.isFail()))
    {
      localGetTroopStoryListEvent.b = false;
      localGetTroopStoryListEvent.a = paramGetTroopStoryListResponse.a;
      if (paramGetTroopStoryListResponse.e != paramGetTroopStoryListRequest.i) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localGetTroopStoryListEvent.f = bool1;
      localGetTroopStoryListEvent.e = paramGetTroopStoryListResponse.f;
      if (localGetTroopStoryListEvent.l.equals("REQUEST_CONTEXT_SAVE_COOKIE"))
      {
        paramErrorMessage = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TROOP_STORY_COOKIE");
        localStringBuilder.append(String.valueOf(paramGetTroopStoryListRequest.e));
        paramErrorMessage.d(localStringBuilder.toString(), Integer.valueOf(paramGetTroopStoryListResponse.b));
        paramErrorMessage = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TROOP_STORY_PAGE_IS_END");
        localStringBuilder.append(String.valueOf(paramGetTroopStoryListRequest.e));
        paramErrorMessage.d(localStringBuilder.toString(), Boolean.valueOf(paramGetTroopStoryListResponse.a));
        if (localGetTroopStoryListEvent.f)
        {
          paramErrorMessage = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("TROOP_STORY_SEQ710");
          localStringBuilder.append(String.valueOf(paramGetTroopStoryListRequest.e));
          paramErrorMessage.d(localStringBuilder.toString(), Integer.valueOf(paramGetTroopStoryListResponse.e));
        }
      }
      else
      {
        localGetTroopStoryListEvent.h = paramGetTroopStoryListResponse.b;
      }
      SLog.a("Q.qqstory.troopmemories:GetTroopStoryListHandler", "onCmdRespond：", paramGetTroopStoryListResponse);
      StoryDispatcher.a().dispatch(localGetTroopStoryListEvent);
      return;
    }
    StoryDispatcher.a().dispatch(localGetTroopStoryListEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler
 * JD-Core Version:    0.7.0.1
 */