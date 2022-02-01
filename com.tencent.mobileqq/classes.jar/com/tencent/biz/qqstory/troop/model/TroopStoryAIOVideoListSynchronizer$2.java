package com.tencent.biz.qqstory.troop.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class TroopStoryAIOVideoListSynchronizer$2
  implements CmdTaskManger.CommandCallback<GetVideoFullInfoListRequest, GetVideoFullInfoListResponse>
{
  public void a(GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on retry resp code=");
      ((StringBuilder)localObject).append(paramErrorMessage.errorCode);
      QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    boolean bool = true;
    if ((paramGetVideoFullInfoListResponse != null) && (paramErrorMessage.isSuccess()))
    {
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListResponse.a.iterator();
      while (paramGetVideoFullInfoListRequest.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramGetVideoFullInfoListRequest.next();
        if (paramErrorMessage.mErrorCode == 0)
        {
          ((ArrayList)localObject).add(paramErrorMessage);
        }
        else
        {
          this.a.m.add(paramErrorMessage.mVid);
          bool = false;
        }
      }
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
    }
    else
    {
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListRequest.e.iterator();
      while (paramGetVideoFullInfoListRequest.hasNext())
      {
        paramGetVideoFullInfoListResponse = (String)paramGetVideoFullInfoListRequest.next();
        this.a.m.add(paramGetVideoFullInfoListResponse);
      }
      bool = false;
    }
    this.a.a((List)localObject, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryAIOVideoListSynchronizer.2
 * JD-Core Version:    0.7.0.1
 */