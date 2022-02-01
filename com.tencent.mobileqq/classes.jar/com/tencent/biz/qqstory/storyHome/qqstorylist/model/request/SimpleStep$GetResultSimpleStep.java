package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

public class SimpleStep$GetResultSimpleStep<T>
  extends SimpleStep
{
  public SimpleStep.SimpleStepResultCallback<T> a;
  public T a;
  public String a;
  
  public SimpleStep$GetResultSimpleStep(SimpleStep.SimpleStepResultCallback<T> paramSimpleStepResultCallback)
  {
    this.jdField_a_of_type_JavaLangString = "GetResultSimpleStep";
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStep$SimpleStepResultCallback = paramSimpleStepResultCallback;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    SimpleStep.SimpleStepResultCallback localSimpleStepResultCallback = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStep$SimpleStepResultCallback;
    if (localSimpleStepResultCallback != null) {
      localSimpleStepResultCallback.a(this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.GetResultSimpleStep
 * JD-Core Version:    0.7.0.1
 */