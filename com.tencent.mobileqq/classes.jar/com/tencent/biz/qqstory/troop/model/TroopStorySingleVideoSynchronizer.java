package com.tencent.biz.qqstory.troop.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class TroopStorySingleVideoSynchronizer
  extends DefaultPlayerVideoListSynchronizer
  implements CmdTaskManger.CommandCallback<GetVideoFullInfoListRequest, GetVideoFullInfoListResponse>, DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  String b;
  AtomicBoolean c;
  String d;
  boolean e;
  IVidToVideoInfoPuller.OnFinishCallBack f;
  
  protected void a(int paramInt)
  {
    if (!this.c.compareAndSet(false, true)) {
      return;
    }
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.d);
    a(this.d, localStoryVideoItem);
  }
  
  public void a(@NonNull GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel())
    {
      paramGetVideoFullInfoListRequest = new StringBuilder();
      paramGetVideoFullInfoListRequest.append("onResp code=");
      paramGetVideoFullInfoListRequest.append(paramErrorMessage.errorCode);
      QLog.d("Q.qqstory.troopstory.singleSync", 2, paramGetVideoFullInfoListRequest.toString());
    }
    paramGetVideoFullInfoListRequest = new StoryVideoItem();
    paramGetVideoFullInfoListRequest.mVid = this.d;
    paramGetVideoFullInfoListRequest.mStoryType = 2;
    if ((paramGetVideoFullInfoListResponse != null) && (paramErrorMessage.isSuccess()))
    {
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListResponse.a.iterator();
      while (paramGetVideoFullInfoListRequest.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramGetVideoFullInfoListRequest.next();
        if (this.d.equals(paramErrorMessage.mVid)) {
          if (paramErrorMessage.mErrorCode == 0)
          {
            i = 1;
            break label131;
          }
        }
      }
    }
    int i = 0;
    label131:
    if (i != 0)
    {
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
      a(paramGetVideoFullInfoListResponse.a, false);
      return;
    }
    this.e = true;
    if (paramGetVideoFullInfoListResponse == null) {
      paramGetVideoFullInfoListRequest = new ArrayList();
    } else {
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListResponse.a;
    }
    a(paramGetVideoFullInfoListRequest, false);
  }
  
  protected void a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) && (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory.singleSync", 2, "url exist");
      }
      ThreadManager.getUIHandler().post(new TroopStorySingleVideoSynchronizer.1(this, paramStoryVideoItem));
      return;
    }
    if ((paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath)) && (new File(paramStoryVideoItem.mLocalVideoPath).exists()) && (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailPath)) && (new File(paramStoryVideoItem.mVideoLocalThumbnailPath).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory.singleSync", 2, "localPath exist");
      }
      ThreadManager.getUIHandler().post(new TroopStorySingleVideoSynchronizer.2(this, paramStoryVideoItem));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramStoryVideoItem = new StringBuilder();
      paramStoryVideoItem.append("need send storyId=");
      paramStoryVideoItem.append(paramString);
      QLog.d("Q.qqstory.troopstory.singleSync", 2, paramStoryVideoItem.toString());
    }
    paramStoryVideoItem = new GetVideoFullInfoListRequest();
    paramStoryVideoItem.e.add(paramString);
    CmdTaskManger.a().a(paramStoryVideoItem, this);
  }
  
  void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      localObject = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).a = this.b;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).i = paramBoolean;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).j = true;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).e.addAll(paramList);
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).h = paramList.size();
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    ((IVidToVideoInfoPuller.OnFinishCallBack)localObject).a(paramList, this.e);
    this.f = null;
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStorySingleVideoSynchronizer
 * JD-Core Version:    0.7.0.1
 */