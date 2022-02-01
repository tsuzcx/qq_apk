package com.tencent.mm.ui.widget.sortlist;

class DragSortListView$LiftAnimator
  extends DragSortListView.SmoothAnimator
{
  private float d;
  private float e;
  
  private DragSortListView$LiftAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt, null);
  }
  
  public void onStart()
  {
    this.d = DragSortListView.c(this.a);
    this.e = DragSortListView.d(this.a);
  }
  
  public void onUpdate(float paramFloat1, float paramFloat2)
  {
    if (DragSortListView.b(this.a) != 4)
    {
      cancel();
      return;
    }
    DragSortListView.a(this.a, (int)(this.e * paramFloat2 + (1.0F - paramFloat2) * this.d));
    DragSortListView.e(this.a).y = (DragSortListView.f(this.a) - DragSortListView.c(this.a));
    DragSortListView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.LiftAnimator
 * JD-Core Version:    0.7.0.1
 */