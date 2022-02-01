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
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, "on retry resp code=" + paramErrorMessage.errorCode);
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if ((paramGetVideoFullInfoListResponse != null) && (paramErrorMessage.isSuccess()))
    {
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListResponse.a.iterator();
      bool = true;
      if (paramGetVideoFullInfoListRequest.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramGetVideoFullInfoListRequest.next();
        if (paramErrorMessage.mErrorCode == 0) {
          localArrayList.add(paramErrorMessage);
        }
        for (;;)
        {
          break;
          this.a.a.add(paramErrorMessage.mVid);
          bool = false;
        }
      }
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
    }
    for (;;)
    {
      this.a.a(localArrayList, bool);
      return;
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListRequest.a.iterator();
      while (paramGetVideoFullInfoListRequest.hasNext())
      {
        paramGetVideoFullInfoListResponse = (String)paramGetVideoFullInfoListRequest.next();
        this.a.a.add(paramGetVideoFullInfoListResponse);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryAIOVideoListSynchronizer.2
 * JD-Core Version:    0.7.0.1
 */