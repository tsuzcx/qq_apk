package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentBottomBar$4
  implements View.OnClickListener
{
  CommentBottomBar$4(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (CommentBottomBar.b(this.a) != null)
    {
      CommentBottomBar.b(this.a).a(CommentBottomBar.c(this.a), CommentBottomBar.d(this.a));
      CommentBottomBar.e(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar.4
 * JD-Core Version:    0.7.0.1
 */