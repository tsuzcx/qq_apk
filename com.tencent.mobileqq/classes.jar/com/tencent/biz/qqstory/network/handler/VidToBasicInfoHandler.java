package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VidToBasicInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetVideoFullInfoListRequest, GetVideoFullInfoListResponse>
{
  private static ConcurrentHashMap<String, Long> d = new ConcurrentHashMap();
  protected List<String> c = new ArrayList();
  private final boolean e;
  
  public VidToBasicInfoHandler(List<String> paramList)
  {
    a(paramList);
    this.e = false;
  }
  
  public VidToBasicInfoHandler(List<String> paramList, boolean paramBoolean)
  {
    a(paramList);
    this.e = paramBoolean;
  }
  
  private void a(List<String> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!StoryVideoItem.isFakeVid(str)) {
          this.c.add(str);
        }
      }
    }
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new VidToBasicInfoHandler.1(this), 0);
  }
  
  public void a(@NonNull GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    VidToBasicInfoHandler.GetVideoBasicInfoListEvent localGetVideoBasicInfoListEvent = new VidToBasicInfoHandler.GetVideoBasicInfoListEvent();
    if ((paramGetVideoFullInfoListResponse != null) && (!paramErrorMessage.isFail()))
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
      localGetVideoBasicInfoListEvent.a = paramGetVideoFullInfoListResponse.a;
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
      StoryDispatcher.a().dispatch(localGetVideoBasicInfoListEvent);
      c();
      return;
    }
    d();
    localGetVideoBasicInfoListEvent.g = paramErrorMessage;
    StoryDispatcher.a().dispatch(localGetVideoBasicInfoListEvent);
    paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListRequest.e.iterator();
    while (paramGetVideoFullInfoListRequest.hasNext())
    {
      paramGetVideoFullInfoListResponse = (String)paramGetVideoFullInfoListRequest.next();
      d.remove(paramGetVideoFullInfoListResponse);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidToBasicInfoHandler{mVidList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler
 * JD-Core Version:    0.7.0.1
 */