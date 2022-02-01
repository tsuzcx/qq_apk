package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.network.response.GetStoryPlayerTagInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class GetStoryPlayerTagInfoHandler$1
  implements CmdTaskManger.CommandCallback<GetStoryPlayerTagInfoRequest, GetStoryPlayerTagInfoResponse>
{
  GetStoryPlayerTagInfoHandler$1(List paramList) {}
  
  public void a(@NonNull GetStoryPlayerTagInfoRequest paramGetStoryPlayerTagInfoRequest, @Nullable GetStoryPlayerTagInfoResponse paramGetStoryPlayerTagInfoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent localGetStoryPlayerTagInfoEvent = new GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent();
    localGetStoryPlayerTagInfoEvent.a = new ArrayList(paramGetStoryPlayerTagInfoRequest.e);
    localGetStoryPlayerTagInfoEvent.g = paramErrorMessage;
    if ((!paramErrorMessage.isFail()) && (paramGetStoryPlayerTagInfoResponse != null))
    {
      SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.a, paramGetStoryPlayerTagInfoResponse.a);
      paramErrorMessage = (StoryManager)SuperManager.a(5);
      paramGetStoryPlayerTagInfoRequest = paramGetStoryPlayerTagInfoRequest.e.iterator();
      while (paramGetStoryPlayerTagInfoRequest.hasNext())
      {
        Object localObject = (String)paramGetStoryPlayerTagInfoRequest.next();
        StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
        localObject = GetStoryPlayerTagInfoHandler.a((String)localObject, paramGetStoryPlayerTagInfoResponse.a);
        if (localStoryVideoItem != null)
        {
          if (localObject == null)
          {
            localStoryVideoItem.mTagInfoBase = null;
            localStoryVideoItem.mCompInfoBase = null;
            localStoryVideoItem.mOALinkInfoJson = null;
            localStoryVideoItem.mOALinkInfo = null;
          }
          else
          {
            localStoryVideoItem.mTagInfoBase = ((GetStoryPlayerTagInfoRequest.TagInfoBaseVidList)localObject).b;
            localStoryVideoItem.mCompInfoBase = ((GetStoryPlayerTagInfoRequest.TagInfoBaseVidList)localObject).c;
            localStoryVideoItem.mOALinkInfoJson = ((GetStoryPlayerTagInfoRequest.TagInfoBaseVidList)localObject).d;
            localStoryVideoItem.mOALinkInfo = VideoLinkInfo.a(localStoryVideoItem.mOALinkInfoJson);
          }
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.e = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
        }
      }
      localGetStoryPlayerTagInfoEvent.b = new ArrayList(paramGetStoryPlayerTagInfoResponse.a);
      StoryDispatcher.a().dispatch(localGetStoryPlayerTagInfoEvent);
      return;
    }
    SLog.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
    StoryDispatcher.a().dispatch(localGetStoryPlayerTagInfoEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */