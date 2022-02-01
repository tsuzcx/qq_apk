package com.tencent.biz.subscribe.comment;

import android.widget.TextView;

class CommentPresenter$2
  implements Runnable
{
  CommentPresenter$2(CommentPresenter paramCommentPresenter) {}
  
  public void run()
  {
    if (CommentPresenter.a(this.this$0) != null) {
      CommentPresenter.a(this.this$0).a(CommentPresenter.a(this.this$0));
    }
    if (CommentPresenter.a(this.this$0) != null)
    {
      if (CommentPresenter.a(this.this$0) > 0)
      {
        CommentPresenter.a(this.this$0).setText(Formatter.a(CommentPresenter.a(this.this$0)));
        CommentPresenter.a(this.this$0).setVisibility(0);
        return;
      }
      CommentPresenter.a(this.this$0).setText("");
      CommentPresenter.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.2
 * JD-Core Version:    0.7.0.1
 */