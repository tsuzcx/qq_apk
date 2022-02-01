package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class StoryListPresenter$2
  implements DialogInterface.OnClickListener
{
  StoryListPresenter$2(StoryListPresenter paramStoryListPresenter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StoryReportor.a("home_page", "guide_known", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter.2
 * JD-Core Version:    0.7.0.1
 */