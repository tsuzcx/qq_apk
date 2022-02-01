package com.tencent.biz.widgets;

import android.view.View;
import java.util.List;

class TabLayout$TabAdapter$1
  implements Runnable
{
  TabLayout$TabAdapter$1(TabLayout.TabAdapter paramTabAdapter, int paramInt, View paramView) {}
  
  public void run()
  {
    this.this$0.c.setChildView(this.a, this.b);
    this.this$0.c.setChildWidth(this.a, this.b.getMeasuredWidth());
    int i;
    if (this.this$0.b == null) {
      i = 0;
    } else {
      i = this.this$0.b.size();
    }
    if (this.this$0.c.getChildSize() == i) {
      this.this$0.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter.1
 * JD-Core Version:    0.7.0.1
 */