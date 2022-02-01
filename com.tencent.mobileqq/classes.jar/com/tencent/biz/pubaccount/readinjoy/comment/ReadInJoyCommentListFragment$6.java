package com.tencent.biz.pubaccount.readinjoy.comment;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyCommentListFragment$6
  implements ReadInJoyCommentUtils.SecondCommentEvent
{
  ReadInJoyCommentListFragment$6(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a()
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null) {
      ReadInJoyCommentListFragment.a(this.a).a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a(false, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.6
 * JD-Core Version:    0.7.0.1
 */