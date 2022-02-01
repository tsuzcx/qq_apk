package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetSimpleInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetSimpleInfoListResponse;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VidToSimpleInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetSimpleInfoListRequest, GetSimpleInfoListResponse>
{
  protected List<String> c = new ArrayList();
  protected String d;
  
  public VidToSimpleInfoHandler(String paramString, List<String> paramList)
  {
    this.d = paramString;
    if (paramList != null) {
      this.c.addAll(paramList);
    }
  }
  
  public void a()
  {
    GetSimpleInfoListRequest localGetSimpleInfoListRequest = new GetSimpleInfoListRequest();
    localGetSimpleInfoListRequest.e = this.c;
    CmdTaskManger.a().a(localGetSimpleInfoListRequest, this);
  }
  
  public void a(@NonNull GetSimpleInfoListRequest paramGetSimpleInfoListRequest, @Nullable GetSimpleInfoListResponse paramGetSimpleInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetSimpleInfoListRequest = new VidToSimpleInfoHandler.GetSimpleInfoListEvent();
    if ((paramGetSimpleInfoListResponse != null) && (!paramErrorMessage.isFail()))
    {
      c();
      paramGetSimpleInfoListResponse.a = ((StoryManager)SuperManager.a(5)).a(paramGetSimpleInfoListResponse.a);
      paramGetSimpleInfoListRequest.a = this.d;
      paramGetSimpleInfoListResponse = paramGetSimpleInfoListResponse.a.iterator();
      while (paramGetSimpleInfoListResponse.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramGetSimpleInfoListResponse.next();
        paramErrorMessage = new VideoCollectionItem.FakeVideoUIItem(paramErrorMessage.mVid, paramErrorMessage);
        paramGetSimpleInfoListRequest.b.add(paramErrorMessage);
      }
      StoryDispatcher.a().dispatch(paramGetSimpleInfoListRequest);
      return;
    }
    d();
    StoryDispatcher.a().dispatch(paramGetSimpleInfoListRequest);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidToSimpleInfoHandler{mVidList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mCollectionId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler
 * JD-Core Version:    0.7.0.1
 */