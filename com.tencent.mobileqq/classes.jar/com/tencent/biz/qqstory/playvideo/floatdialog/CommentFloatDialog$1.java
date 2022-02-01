package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentFloatDialog$1
  implements View.OnClickListener
{
  CommentFloatDialog$1(CommentFloatDialog paramCommentFloatDialog) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if ((CommentFloatDialog.a(this.a) != null) && (CommentFloatDialog.a(this.a).a()))
    {
      CommentFloatDialog.a(this.a).c();
      int i;
      if (CommentFloatDialog.a(this.a) != null)
      {
        i = StoryReportor.a(CommentFloatDialog.a(this.a).a);
        if (!this.a.a()) {
          break label128;
        }
      }
      label128:
      for (str1 = "1";; str1 = "2")
      {
        StoryReportor.a("home_page", "cancel_reply", i, 0, new String[] { str1, StoryReportor.a(CommentFloatDialog.a(this.a)), "5", CommentFloatDialog.a(this.a) });
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 0;
        break;
      }
    }
    this.a.a();
    if (this.a.a())
    {
      str1 = "2";
      label154:
      if (!this.a.b()) {
        break label199;
      }
    }
    label199:
    for (String str2 = "2";; str2 = "1")
    {
      StoryReportor.a("play_video", "close_reply", 0, 3, new String[] { str1, str2 });
      break;
      str1 = "1";
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.1
 * JD-Core Version:    0.7.0.1
 */