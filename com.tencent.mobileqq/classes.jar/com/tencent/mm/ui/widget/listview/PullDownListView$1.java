package com.tencent.mm.ui.widget.listview;

import android.view.View;

class PullDownListView$1
  implements Runnable
{
  PullDownListView$1(PullDownListView paramPullDownListView, View paramView) {}
  
  public void run()
  {
    if (PullDownListView.a(this.b) != null)
    {
      PullDownListView localPullDownListView = this.b;
      PullDownListView.a(localPullDownListView, -PullDownListView.a(localPullDownListView).getWidth());
      localPullDownListView = this.b;
      PullDownListView.b(localPullDownListView, PullDownListView.a(localPullDownListView).getHeight());
      PullDownListView.a(this.b).setVisibility(8);
    }
    this.a.bringToFront();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.1
 * JD-Core Version:    0.7.0.1
 */