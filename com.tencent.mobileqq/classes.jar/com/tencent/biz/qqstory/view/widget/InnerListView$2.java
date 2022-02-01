package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.View.OnLongClickListener;

class InnerListView$2
  implements View.OnLongClickListener
{
  InnerListView$2(InnerListView paramInnerListView, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((InnerListView.c(this.b) != null) && (InnerListView.b(this.b) != null)) {
      return InnerListView.c(this.b).b(this.b, paramView, this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView.2
 * JD-Core Version:    0.7.0.1
 */