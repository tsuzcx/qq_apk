package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

public class SimpleStep$GetResultSimpleStep<T>
  extends SimpleStep
{
  public String a = "GetResultSimpleStep";
  public T b = null;
  public SimpleStep.SimpleStepResultCallback<T> c;
  
  public SimpleStep$GetResultSimpleStep(SimpleStep.SimpleStepResultCallback<T> paramSimpleStepResultCallback)
  {
    this.c = paramSimpleStepResultCallback;
  }
  
  public Object a()
  {
    return this.b;
  }
  
  public void a(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public void b()
  {
    SimpleStep.SimpleStepResultCallback localSimpleStepResultCallback = this.c;
    if (localSimpleStepResultCallback != null) {
      localSimpleStepResultCallback.a(this.b);
    }
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.GetResultSimpleStep
 * JD-Core Version:    0.7.0.1
 */