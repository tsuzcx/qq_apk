package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentView$1
  implements View.OnClickListener
{
  CommentView$1(CommentView paramCommentView) {}
  
  public void onClick(View paramView)
  {
    if ((CommentView.a(this.a) != null) && (CommentView.a(this.a).vecReply.size() > 0))
    {
      CommentView.c(this.a).a(paramView, 10, CommentView.b(this.a), CommentView.a(this.a));
      this.a.j.f.setVisibility(8);
      this.a.j.e.setVisibility(8);
      this.a.e.setVisibility(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentView.1
 * JD-Core Version:    0.7.0.1
 */