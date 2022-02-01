package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class SimpleStep
  implements Step
{
  private Step.ErrorCallBack jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack;
  private Step.FinishCallBack jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack;
  private Object jdField_a_of_type_JavaLangObject;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack = paramFinishCallBack;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    Step.ErrorCallBack localErrorCallBack = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack;
    if (localErrorCallBack != null)
    {
      localErrorCallBack.a(paramErrorMessage);
      return;
    }
    paramErrorMessage = new StringBuilder();
    paramErrorMessage.append(a());
    paramErrorMessage.append(" errorCallBack is null.");
    SLog.d("SimpleStep", paramErrorMessage.toString());
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack;
    if (localObject != null)
    {
      ((Step.FinishCallBack)localObject).a(a());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(" finishCallBack is null.");
    SLog.d("SimpleStep", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep
 * JD-Core Version:    0.7.0.1
 */