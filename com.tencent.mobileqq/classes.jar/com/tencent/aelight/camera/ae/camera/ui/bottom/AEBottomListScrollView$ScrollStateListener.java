package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.v7.widget.RecyclerView.ViewHolder;

class AEBottomListScrollView$ScrollStateListener
  implements AEBottomListScrollLayoutManager.ScrollStateListener
{
  private AEBottomListScrollView$ScrollStateListener(AEBottomListScrollView paramAEBottomListScrollView) {}
  
  public void a()
  {
    if (AEBottomListScrollView.a(this.a) == null) {
      return;
    }
    int i = AEBottomListScrollView.a(this.a).b();
    RecyclerView.ViewHolder localViewHolder = this.a.a(i);
    if (localViewHolder != null) {
      AEBottomListScrollView.a(this.a, localViewHolder, i);
    }
  }
  
  public void a(float paramFloat)
  {
    if (AEBottomListScrollView.a(this.a) == null) {
      return;
    }
    int i = this.a.a();
    int j = AEBottomListScrollView.a(this.a).a();
    if (i != j)
    {
      AEBottomListScrollView localAEBottomListScrollView = this.a;
      AEBottomListScrollView.a(localAEBottomListScrollView, paramFloat, i, j, localAEBottomListScrollView.a(i), this.a.a(j));
    }
  }
  
  public void b()
  {
    if ((AEBottomListScrollView.a(this.a) == null) && (AEBottomListScrollView.a(this.a) == null)) {
      return;
    }
    int i = AEBottomListScrollView.a(this.a).b();
    RecyclerView.ViewHolder localViewHolder = this.a.a(i);
    if (localViewHolder != null)
    {
      AEBottomListScrollView.b(this.a, localViewHolder, i);
      AEBottomListScrollView.c(this.a, localViewHolder, i);
    }
  }
  
  public void c()
  {
    this.a.post(new AEBottomListScrollView.ScrollStateListener.1(this));
  }
  
  public void d()
  {
    this.a.post(new AEBottomListScrollView.ScrollStateListener.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.ScrollStateListener
 * JD-Core Version:    0.7.0.1
 */