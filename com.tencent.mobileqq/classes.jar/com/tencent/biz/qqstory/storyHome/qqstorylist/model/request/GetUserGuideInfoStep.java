package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class GetUserGuideInfoStep
  extends SimpleStep
{
  private boolean a = false;
  private GetUserGuideInfoStep.CompletedListener b;
  
  public GetUserGuideInfoStep(GetUserGuideInfoStep.CompletedListener paramCompletedListener)
  {
    this.b = paramCompletedListener;
  }
  
  public void a(@NonNull GetUserGuideInfoStep.Request paramRequest, @Nullable GetUserGuideInfoStep.Response paramResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (g())
    {
      SLog.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      h();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      SLog.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new GetUserGuideInfoStep.1(this, paramResponse));
    h();
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    GetUserGuideInfoStep.Request localRequest = new GetUserGuideInfoStep.Request();
    CmdTaskManger.a().a(localRequest, new GetUserGuideInfoStep.CommandCallback(this));
  }
  
  public String c()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void e() {}
  
  public void f()
  {
    try
    {
      this.a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean g()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep
 * JD-Core Version:    0.7.0.1
 */