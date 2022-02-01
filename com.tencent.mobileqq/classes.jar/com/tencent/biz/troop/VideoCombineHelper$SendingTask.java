package com.tencent.biz.troop;

class VideoCombineHelper$SendingTask
  extends VideoCombineHelper.Task
{
  public VideoCombineHelper$SendingTask(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    super(paramVideoCombineHelper, paramTaskListener, paramString);
  }
  
  public void a()
  {
    this.a.e.e();
    VideoCombineHelper.CombineParams localCombineParams = c();
    this.a.e.a(localCombineParams.j, localCombineParams.c, localCombineParams.g, new VideoCombineHelper.SendingTask.1(this));
    this.f.b(this);
    this.h = new VideoCombineHelper.ClearTask(this.a, this.f, this.g);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.SendingTask
 * JD-Core Version:    0.7.0.1
 */