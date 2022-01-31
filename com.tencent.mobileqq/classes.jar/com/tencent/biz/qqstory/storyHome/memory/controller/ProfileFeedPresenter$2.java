package com.tencent.biz.qqstory.storyHome.memory.controller;

import java.util.List;
import wic;
import wle;

public class ProfileFeedPresenter$2
  implements Runnable
{
  public ProfileFeedPresenter$2(wic paramwic, wle paramwle) {}
  
  public void run()
  {
    if (this.a.d)
    {
      this.this$0.b(this.a);
      return;
    }
    wic.a(this.this$0, this.a);
    wic.a(this.this$0).remove(wic.a());
    wic.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */