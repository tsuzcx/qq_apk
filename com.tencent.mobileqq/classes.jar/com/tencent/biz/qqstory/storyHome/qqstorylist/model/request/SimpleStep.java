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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramErrorMessage);
      return;
    }
    SLog.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
      return;
    }
    SLog.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep
 * JD-Core Version:    0.7.0.1
 */