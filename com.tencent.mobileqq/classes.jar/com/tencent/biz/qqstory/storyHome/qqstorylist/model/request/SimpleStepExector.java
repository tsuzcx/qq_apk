package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

public abstract class SimpleStepExector
  extends SimpleStep
  implements Step.ErrorCallBack, Step.FinishCallBack
{
  protected SimpleStepExector.CompletedHandler a;
  protected SimpleStepExector.ErrorHandler a;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector
 * JD-Core Version:    0.7.0.1
 */