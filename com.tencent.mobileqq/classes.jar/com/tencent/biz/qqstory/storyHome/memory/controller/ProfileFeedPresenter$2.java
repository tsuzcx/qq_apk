package com.tencent.biz.qqstory.storyHome.memory.controller;

import java.util.List;
import yfw;
import yiy;

public class ProfileFeedPresenter$2
  implements Runnable
{
  public ProfileFeedPresenter$2(yfw paramyfw, yiy paramyiy) {}
  
  public void run()
  {
    if (this.a.d)
    {
      this.this$0.b(this.a);
      return;
    }
    yfw.a(this.this$0, this.a);
    yfw.a(this.this$0).remove(yfw.a());
    yfw.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */