package com.tencent.mm.ui.widget.listview;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.ui.f;

class PullDownListView$2
  implements Runnable
{
  PullDownListView$2(PullDownListView paramPullDownListView) {}
  
  public void run()
  {
    f.b("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.b(this.a).getLeft()), Integer.valueOf(PullDownListView.b(this.a).getTop()), Integer.valueOf(PullDownListView.b(this.a).getRight()), Integer.valueOf(PullDownListView.b(this.a).getBottom()) });
    PullDownListView.c(this.a).set(PullDownListView.b(this.a).getLeft(), PullDownListView.b(this.a).getTop(), PullDownListView.b(this.a).getRight(), PullDownListView.b(this.a).getBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.2
 * JD-Core Version:    0.7.0.1
 */