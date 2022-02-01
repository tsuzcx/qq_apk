package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetShareGroupInfoRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupInfoResponse;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetShareGroupInfoRequest, GetShareGroupInfoResponse>
{
  protected String c;
  private final List<String> d;
  private GetShareGroupInfoHandler.OnGetShareGroupInfoCallback e;
  
  public GetShareGroupInfoHandler(String paramString1, String paramString2)
  {
    this.d = new ArrayList();
    this.d.add(paramString1);
    this.c = paramString2;
  }
  
  public GetShareGroupInfoHandler(List<String> paramList, String paramString)
  {
    this.d = paramList;
    this.c = paramString;
  }
  
  public GetShareGroupInfoHandler a(GetShareGroupInfoHandler.OnGetShareGroupInfoCallback paramOnGetShareGroupInfoCallback)
  {
    this.e = paramOnGetShareGroupInfoCallback;
    return this;
  }
  
  public void a()
  {
    GetShareGroupInfoRequest localGetShareGroupInfoRequest = new GetShareGroupInfoRequest();
    localGetShareGroupInfoRequest.e = this.d;
    CmdTaskManger.a().a(localGetShareGroupInfoRequest, this);
  }
  
  public void a(@NonNull GetShareGroupInfoRequest paramGetShareGroupInfoRequest, @Nullable GetShareGroupInfoResponse paramGetShareGroupInfoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetShareGroupInfoRequest = new GetShareGroupInfoHandler.GetShareGroupInfoEvent();
    paramGetShareGroupInfoRequest.g = paramErrorMessage;
    paramGetShareGroupInfoRequest.a = this.c;
    if ((paramErrorMessage.isSuccess()) && (paramGetShareGroupInfoResponse != null))
    {
      paramErrorMessage = new ArrayList();
      ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
      if ((paramGetShareGroupInfoResponse.a != null) && (!paramGetShareGroupInfoResponse.a.isEmpty()))
      {
        paramGetShareGroupInfoResponse = paramGetShareGroupInfoResponse.a.iterator();
        while (paramGetShareGroupInfoResponse.hasNext()) {
          paramErrorMessage.add(localShareGroupManager.a((ShareGroupItem)paramGetShareGroupInfoResponse.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramGetShareGroupInfoRequest.b = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramGetShareGroupInfoRequest.c = paramErrorMessage;
      c();
    }
    else
    {
      d();
    }
    StoryDispatcher.a().dispatch(paramGetShareGroupInfoRequest);
    paramGetShareGroupInfoResponse = this.e;
    if (paramGetShareGroupInfoResponse != null) {
      paramGetShareGroupInfoResponse.a(paramGetShareGroupInfoRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler
 * JD-Core Version:    0.7.0.1
 */