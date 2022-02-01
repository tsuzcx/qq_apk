package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.os.Handler;
import ygp;
import zeb;

public class StoryListPresenter$4
  implements Runnable
{
  public StoryListPresenter$4(ygp paramygp) {}
  
  public void run()
  {
    String str = zeb.a(this.this$0.jdField_a_of_type_AndroidAppActivity, "qqstory_upgrade_guide.mp4");
    if (str != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new StoryListPresenter.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4
 * JD-Core Version:    0.7.0.1
 */