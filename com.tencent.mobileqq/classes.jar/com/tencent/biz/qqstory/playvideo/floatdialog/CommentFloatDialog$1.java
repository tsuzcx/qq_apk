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
    Object localObject = CommentFloatDialog.a(this.a);
    String str = "2";
    if ((localObject != null) && (CommentFloatDialog.a(this.a).c()))
    {
      CommentFloatDialog.a(this.a).d();
      int i;
      if (CommentFloatDialog.b(this.a) != null) {
        i = StoryReportor.a(CommentFloatDialog.b(this.a).a);
      } else {
        i = 0;
      }
      if (this.a.c()) {
        str = "1";
      }
      StoryReportor.a("home_page", "cancel_reply", i, 0, new String[] { str, StoryReportor.b(CommentFloatDialog.c(this.a)), "5", CommentFloatDialog.d(this.a) });
    }
    else
    {
      this.a.a();
      if (this.a.c()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (!this.a.d()) {
        str = "1";
      }
      StoryReportor.a("play_video", "close_reply", 0, 3, new String[] { localObject, str });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.1
 * JD-Core Version:    0.7.0.1
 */