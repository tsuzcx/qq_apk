package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.IEventReceiver;

public class Repository
  implements IEventReceiver
{
  protected MyStorys a;
  
  public MyStorys a()
  {
    return this.a;
  }
  
  public void a(Runnable paramRunnable)
  {
    SLog.b("Q.qqstory.home.Repository", "executeRunnableOnWorkThread");
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository
 * JD-Core Version:    0.7.0.1
 */