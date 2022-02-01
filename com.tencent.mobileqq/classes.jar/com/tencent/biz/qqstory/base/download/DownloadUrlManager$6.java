package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;

class DownloadUrlManager$6
  implements CmdTaskManger.CommandCallback<GetVideoFullInfoListRequest, GetVideoFullInfoListResponse>
{
  DownloadUrlManager$6(DownloadUrlManager paramDownloadUrlManager, DownloadUrlManager.PullNewVideoInfoCallBack paramPullNewVideoInfoCallBack, String paramString) {}
  
  public void a(@NonNull GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetVideoFullInfoListRequest = new StringBuilder();
    paramGetVideoFullInfoListRequest.append("pullNewVideoInfoIfNecessary: request video url response ");
    paramGetVideoFullInfoListRequest.append(paramGetVideoFullInfoListResponse);
    SLog.d("Q.qqstory.DownloadUrlManager", paramGetVideoFullInfoListRequest.toString());
    if ((!paramErrorMessage.isFail()) && (paramGetVideoFullInfoListResponse != null))
    {
      paramGetVideoFullInfoListRequest = (StoryManager)SuperManager.a(5);
      if (paramGetVideoFullInfoListResponse.a != null)
      {
        paramErrorMessage = paramGetVideoFullInfoListResponse.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramGetVideoFullInfoListResponse.a = paramGetVideoFullInfoListRequest.a(paramGetVideoFullInfoListResponse.a);
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
      this.c.d(this.b, 0);
      this.a.a(true);
      return;
    }
    SLog.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.6
 * JD-Core Version:    0.7.0.1
 */