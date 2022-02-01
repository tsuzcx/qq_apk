package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.os.Handler;
import com.tencent.biz.qqstory.utils.FileUtils;

class StoryListPresenter$4
  implements Runnable
{
  StoryListPresenter$4(StoryListPresenter paramStoryListPresenter) {}
  
  public void run()
  {
    String str = FileUtils.a(this.this$0.jdField_a_of_type_AndroidAppActivity, "qqstory_upgrade_guide.mp4");
    if (str != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new StoryListPresenter.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.4
 * JD-Core Version:    0.7.0.1
 */