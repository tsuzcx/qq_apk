package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class StoryListPresenter$1
  implements DialogInterface.OnClickListener
{
  StoryListPresenter$1(StoryListPresenter paramStoryListPresenter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.c.a(false, true, 12, null);
    StoryReportor.a("home_page", "guide_open", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.1
 * JD-Core Version:    0.7.0.1
 */