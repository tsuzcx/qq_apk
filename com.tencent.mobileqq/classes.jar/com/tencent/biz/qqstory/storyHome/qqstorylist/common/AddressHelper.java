package com.tencent.biz.qqstory.storyHome.qqstorylist.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetLocationRequest;
import com.tencent.biz.qqstory.network.response.GetLocationResponse;
import java.lang.ref.WeakReference;

public class AddressHelper
  implements CmdTaskManger.CommandCallback<GetLocationRequest, GetLocationResponse>
{
  private WeakReference<AddressHelper.AddressCallBack> a;
  
  public void a(@NonNull GetLocationRequest paramGetLocationRequest, @Nullable GetLocationResponse paramGetLocationResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetLocationRequest = (AddressHelper.AddressCallBack)this.a.get();
    if (paramGetLocationRequest == null) {
      return;
    }
    if ((paramErrorMessage.isSuccess()) && (paramGetLocationResponse != null))
    {
      paramGetLocationRequest.a(paramGetLocationResponse);
      return;
    }
    paramGetLocationRequest.a(paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.common.AddressHelper
 * JD-Core Version:    0.7.0.1
 */