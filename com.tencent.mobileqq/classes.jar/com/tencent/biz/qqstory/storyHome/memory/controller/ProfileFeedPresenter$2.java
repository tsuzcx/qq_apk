package com.tencent.biz.qqstory.storyHome.memory.controller;

import java.util.List;
import wml;
import wpn;

public class ProfileFeedPresenter$2
  implements Runnable
{
  public ProfileFeedPresenter$2(wml paramwml, wpn paramwpn) {}
  
  public void run()
  {
    if (this.a.d)
    {
      this.this$0.b(this.a);
      return;
    }
    wml.a(this.this$0, this.a);
    wml.a(this.this$0).remove(wml.a());
    wml.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */