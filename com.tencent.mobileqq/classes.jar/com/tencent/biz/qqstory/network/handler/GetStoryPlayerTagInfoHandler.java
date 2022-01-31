package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.network.response.GetStoryPlayerTagInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStoryPlayerTagInfoHandler
  implements CmdTaskManger.CommandCallback
{
  @Nullable
  public static GetStoryPlayerTagInfoRequest.TagInfoBaseVidList a(String paramString, List paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GetStoryPlayerTagInfoRequest.TagInfoBaseVidList localTagInfoBaseVidList = (GetStoryPlayerTagInfoRequest.TagInfoBaseVidList)paramList.next();
      if (paramString.equals(localTagInfoBaseVidList.jdField_a_of_type_JavaLangString)) {
        return localTagInfoBaseVidList;
      }
    }
    return null;
  }
  
  public void a(@NonNull GetStoryPlayerTagInfoRequest paramGetStoryPlayerTagInfoRequest, @Nullable GetStoryPlayerTagInfoResponse paramGetStoryPlayerTagInfoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent localGetStoryPlayerTagInfoEvent = new GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent();
    localGetStoryPlayerTagInfoEvent.a = new ArrayList(paramGetStoryPlayerTagInfoRequest.a);
    localGetStoryPlayerTagInfoEvent.errorInfo = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramGetStoryPlayerTagInfoResponse == null))
    {
      SLog.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      Dispatchers.get().dispatch(localGetStoryPlayerTagInfoEvent);
      return;
    }
    SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, response list:%s", paramGetStoryPlayerTagInfoResponse.a);
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    paramGetStoryPlayerTagInfoRequest = paramGetStoryPlayerTagInfoRequest.a.iterator();
    while (paramGetStoryPlayerTagInfoRequest.hasNext())
    {
      Object localObject = (String)paramGetStoryPlayerTagInfoRequest.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      if (localStoryVideoItem != null)
      {
        localObject = a((String)localObject, paramGetStoryPlayerTagInfoResponse.a);
        if (localObject != null) {}
        for (localStoryVideoItem.mTagInfoBase = ((GetStoryPlayerTagInfoRequest.TagInfoBaseVidList)localObject).jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase;; localStoryVideoItem.mTagInfoBase = null)
        {
          paramErrorMessage.a(localStoryVideoItem);
          break;
        }
      }
    }
    SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: tagVidList:%s", paramGetStoryPlayerTagInfoResponse.a);
    localGetStoryPlayerTagInfoEvent.b = new ArrayList(paramGetStoryPlayerTagInfoResponse.a);
    Dispatchers.get().dispatch(localGetStoryPlayerTagInfoEvent);
  }
  
  public void a(@NonNull List paramList)
  {
    SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "send request : %s", paramList.toString());
    paramList = new GetStoryPlayerTagInfoRequest(paramList);
    CmdTaskManger.a().a(paramList, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler
 * JD-Core Version:    0.7.0.1
 */