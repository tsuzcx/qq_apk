package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;

class DragSortListView$SmoothAnimator
  implements Runnable
{
  private float a;
  protected long b;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i;
  
  private DragSortListView$SmoothAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    this.d = paramFloat;
    this.a = paramInt;
    paramFloat = this.d;
    float f1 = 1.0F / (paramFloat * 2.0F * (1.0F - paramFloat));
    this.h = f1;
    this.e = f1;
    this.f = (paramFloat / ((paramFloat - 1.0F) * 2.0F));
    this.g = (1.0F / (1.0F - paramFloat));
  }
  
  public void cancel()
  {
    this.i = true;
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onUpdate(float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    if (this.i) {
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.b) / this.a;
    if (f1 >= 1.0F)
    {
      onUpdate(1.0F, 1.0F);
      onStop();
      return;
    }
    onUpdate(f1, transform(f1));
    this.c.post(this);
  }
  
  public void start()
  {
    this.b = SystemClock.uptimeMillis();
    this.i = false;
    onStart();
    this.c.post(this);
  }
  
  public float transform(float paramFloat)
  {
    float f1 = this.d;
    if (paramFloat < f1) {
      return this.e * paramFloat * paramFloat;
    }
    if (paramFloat < 1.0F - f1) {
      return this.f + this.g * paramFloat;
    }
    f1 = this.h;
    paramFloat -= 1.0F;
    return 1.0F - f1 * paramFloat * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
 * JD-Core Version:    0.7.0.1
 */