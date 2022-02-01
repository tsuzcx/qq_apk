package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentBottomBar$3
  implements View.OnClickListener
{
  CommentBottomBar$3(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    if (CommentBottomBar.a(this.a) != null) {
      CommentBottomBar.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar.3
 * JD-Core Version:    0.7.0.1
 */