package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.ui.f;

class PullDownListView$4
  extends AnimatorListenerAdapter
{
  PullDownListView$4(PullDownListView paramPullDownListView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    f.c("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(this.a), Integer.valueOf(PullDownListView.d(this.d)), Integer.valueOf(PullDownListView.e(this.d)) });
    PullDownListView.c(this.d, false);
    PullDownListView.a(this.d, false);
    PullDownListView.d(this.d, false);
    PullDownListView.e(this.d, false);
    if ((PullDownListView.f(this.d) != null) && (this.a > PullDownListView.d(this.d)) && (this.a < PullDownListView.e(this.d)))
    {
      if (PullDownListView.g(this.d))
      {
        PullDownListView.f(this.d).onPostClose();
        PullDownListView.h(this.d);
        return;
      }
      PullDownListView.f(this.d).onPostOpen(this.c);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    f.c("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(this.a), Integer.valueOf(PullDownListView.d(this.d)), Integer.valueOf(PullDownListView.e(this.d)) });
    PullDownListView.a(this.d, true);
    if (this.b == 0) {
      PullDownListView.b(this.d, true);
    } else {
      PullDownListView.b(this.d, false);
    }
    if ((PullDownListView.f(this.d) != null) && (this.a > PullDownListView.d(this.d)) && (this.a < PullDownListView.e(this.d)))
    {
      if (PullDownListView.g(this.d))
      {
        PullDownListView.f(this.d).onPreClose();
        return;
      }
      PullDownListView.f(this.d).onPreOpen();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.4
 * JD-Core Version:    0.7.0.1
 */