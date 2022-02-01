package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.WatchVideoRequest;
import com.tencent.biz.qqstory.network.response.WatchVideoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class WatchVideoHandler
  implements CmdTaskManger.CommandCallback<WatchVideoRequest, WatchVideoResponse>
{
  public Set<String> a = new HashSet();
  
  public void a(@NonNull WatchVideoRequest paramWatchVideoRequest, @Nullable WatchVideoResponse paramWatchVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    WatchVideoHandler.WatchVideoEvent localWatchVideoEvent = new WatchVideoHandler.WatchVideoEvent();
    localWatchVideoEvent.g = paramErrorMessage;
    localWatchVideoEvent.a = paramWatchVideoRequest.f;
    if (TroopStoryUtil.a(localWatchVideoEvent.a)) {
      paramWatchVideoRequest.g = "4_10000";
    }
    localWatchVideoEvent.b = paramWatchVideoRequest.g;
    localWatchVideoEvent.c = paramWatchVideoRequest.h;
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    if ((paramWatchVideoRequest.i != 3) && (paramWatchVideoRequest.i != 4) && (paramWatchVideoRequest.i != 31) && (paramWatchVideoRequest.i != 62))
    {
      localWatchVideoEvent.d = localStoryManager.i(paramWatchVideoRequest.g);
      SLog.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramWatchVideoRequest.f, Integer.valueOf(paramWatchVideoRequest.i));
    }
    else
    {
      localWatchVideoEvent.d = localStoryManager.a("Q.qqstory.player.WatchVideoHandler", paramWatchVideoRequest.g, paramWatchVideoRequest.f);
    }
    StoryItem localStoryItem = localStoryManager.a(paramWatchVideoRequest.g, 1);
    if (localStoryItem != null) {
      if (localStoryItem.unReadCount != 0)
      {
        localStoryItem.unReadCount = localWatchVideoEvent.d;
        localStoryManager.a(paramWatchVideoRequest.g, 1, localStoryItem);
        SLog.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramWatchVideoRequest.f, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      else
      {
        localStoryManager.b(paramWatchVideoRequest.g, 1);
      }
    }
    if ((paramWatchVideoResponse != null) && (paramErrorMessage.isSuccess()))
    {
      this.a.add(paramWatchVideoRequest.f);
      StoryDispatcher.a().dispatch(localWatchVideoEvent);
      return;
    }
    StoryDispatcher.a().dispatch(localWatchVideoEvent);
    paramWatchVideoResponse = localStoryManager.a(paramWatchVideoRequest.f);
    if (paramWatchVideoResponse == null) {
      return;
    }
    ((ReportWatchVideoManager)SuperManager.a(13)).a(paramWatchVideoRequest.f, paramWatchVideoRequest.g, paramWatchVideoRequest.h, paramWatchVideoResponse.mCreateTime, paramWatchVideoRequest.i, paramWatchVideoRequest.k, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      WatchVideoRequest localWatchVideoRequest = new WatchVideoRequest();
      localWatchVideoRequest.f = paramString1;
      localWatchVideoRequest.g = paramString2;
      localWatchVideoRequest.h = paramBoolean;
      localWatchVideoRequest.i = paramInt;
      localWatchVideoRequest.j = paramLong;
      CmdTaskManger.a().a(localWatchVideoRequest, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoHandler
 * JD-Core Version:    0.7.0.1
 */