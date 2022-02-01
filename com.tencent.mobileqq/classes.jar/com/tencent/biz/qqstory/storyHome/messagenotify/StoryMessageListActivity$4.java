package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class StoryMessageListActivity$4
  implements DialogInterface.OnClickListener
{
  StoryMessageListActivity$4(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.f();
    paramDialogInterface.dismiss();
    StoryReportor.a(this.a.a(), "clk_sure", 0, 0, new String[] { "2", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.4
 * JD-Core Version:    0.7.0.1
 */