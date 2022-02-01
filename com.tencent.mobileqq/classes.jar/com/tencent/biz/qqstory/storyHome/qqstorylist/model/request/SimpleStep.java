package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class SimpleStep
  implements Step
{
  private Step.FinishCallBack a;
  private Step.ErrorCallBack b;
  private Object c;
  
  public Object a()
  {
    return this.c;
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.b = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.a = paramFinishCallBack;
  }
  
  public void a(Object paramObject)
  {
    this.c = paramObject;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = c();
    Step.ErrorCallBack localErrorCallBack = this.b;
    if (localErrorCallBack != null)
    {
      localErrorCallBack.a(paramErrorMessage);
      return;
    }
    paramErrorMessage = new StringBuilder();
    paramErrorMessage.append(c());
    paramErrorMessage.append(" errorCallBack is null.");
    SLog.d("SimpleStep", paramErrorMessage.toString());
  }
  
  public boolean d()
  {
    return true;
  }
  
  protected void h()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((Step.FinishCallBack)localObject).a(c());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append(" finishCallBack is null.");
    SLog.d("SimpleStep", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep
 * JD-Core Version:    0.7.0.1
 */