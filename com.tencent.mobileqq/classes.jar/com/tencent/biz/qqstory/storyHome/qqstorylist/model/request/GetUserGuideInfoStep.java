package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import nyb;

public class GetUserGuideInfoStep
  extends SimpleStep
{
  private GetUserGuideInfoStep.CompletedListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserGuideInfoStep$CompletedListener;
  private boolean jdField_a_of_type_Boolean;
  
  public GetUserGuideInfoStep(GetUserGuideInfoStep.CompletedListener paramCompletedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserGuideInfoStep$CompletedListener = paramCompletedListener;
  }
  
  public String a()
  {
    return "GetUserGuideInfoStep";
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.home.GetUserGuideInfoStep", "run");
    GetUserGuideInfoStep.Request localRequest = new GetUserGuideInfoStep.Request();
    CmdTaskManger.a().a(localRequest, new GetUserGuideInfoStep.CommandCallback(this));
  }
  
  public void a(@NonNull GetUserGuideInfoStep.Request paramRequest, @Nullable GetUserGuideInfoStep.Response paramResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.d("Q.qqstory.home.GetUserGuideInfoStep", "onCmdRespond");
    if (b())
    {
      SLog.e("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      SLog.c("Q.qqstory.home.GetUserGuideInfoStep", "GetUserGuideInfoStep is failed:%s", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    ThreadManager.getUIHandler().post(new nyb(this, paramResponse));
    d();
  }
  
  public void b() {}
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep
 * JD-Core Version:    0.7.0.1
 */