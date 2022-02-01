package com.tencent.biz.pubaccount.readinjoy.comment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyCommentComponentFragment$12
  implements View.OnClickListener
{
  ReadInJoyCommentComponentFragment$12(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.b)
      {
        ReadInJoyCommentComponentFragment.a(this.a, false);
      }
      else
      {
        ReadInJoyCommentComponentFragment.a(this.a, true);
        continue;
        ReadInJoyCommentComponentFragment.c(this.a);
        continue;
        ReadInJoyCommentComponentFragment.b(this.a);
        if (ReadInJoyCommentComponentFragment.a(this.a) != null)
        {
          if (ReadInJoyCommentComponentFragment.c(this.a) >= ReadInJoyCommentComponentFragment.a(this.a).length) {
            ReadInJoyCommentComponentFragment.a(this.a, 0);
          }
          this.a.c.setText(ReadInJoyCommentComponentFragment.a(this.a)[ReadInJoyCommentComponentFragment.c(this.a)]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.12
 * JD-Core Version:    0.7.0.1
 */