package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;

public class GetUserGuideInfoStep$CommandCallback
  implements CmdTaskManger.CommandCallback<GetUserGuideInfoStep.Request, GetUserGuideInfoStep.Response>
{
  private WeakReference<GetUserGuideInfoStep> a;
  
  public GetUserGuideInfoStep$CommandCallback(GetUserGuideInfoStep paramGetUserGuideInfoStep)
  {
    this.a = new WeakReference(paramGetUserGuideInfoStep);
  }
  
  public void a(@NonNull GetUserGuideInfoStep.Request paramRequest, @Nullable GetUserGuideInfoStep.Response paramResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    GetUserGuideInfoStep localGetUserGuideInfoStep = (GetUserGuideInfoStep)this.a.get();
    if (localGetUserGuideInfoStep == null) {
      return;
    }
    localGetUserGuideInfoStep.a(paramRequest, paramResponse, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.CommandCallback
 * JD-Core Version:    0.7.0.1
 */