package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.OverScroller;

class PhotoViewAttacher$FlingRunnable
  implements Runnable
{
  private final OverScroller a;
  private int b;
  private int c;
  
  public PhotoViewAttacher$FlingRunnable(PhotoViewAttacher paramPhotoViewAttacher, Context paramContext)
  {
    this.a = new OverScroller(paramContext);
  }
  
  public void a()
  {
    this.a.forceFinished(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RectF localRectF = this.this$0.a();
    if (localRectF == null) {
      return;
    }
    int k = Math.round(-localRectF.left);
    float f = paramInt1;
    int j;
    int i;
    if (f < localRectF.width())
    {
      j = Math.round(localRectF.width() - f);
      i = 0;
    }
    else
    {
      paramInt1 = k;
      j = paramInt1;
      i = paramInt1;
    }
    int m = Math.round(-localRectF.top);
    f = paramInt2;
    if (f < localRectF.height())
    {
      paramInt2 = Math.round(localRectF.height() - f);
      paramInt1 = 0;
    }
    else
    {
      paramInt1 = m;
      paramInt2 = paramInt1;
    }
    this.b = k;
    this.c = m;
    if ((k != j) || (m != paramInt2)) {
      this.a.fling(k, m, paramInt3, paramInt4, i, j, paramInt1, paramInt2, 0, 0);
    }
  }
  
  public void run()
  {
    if (this.a.isFinished()) {
      return;
    }
    if (this.a.computeScrollOffset())
    {
      int i = this.a.getCurrX();
      int j = this.a.getCurrY();
      PhotoViewAttacher.c(this.this$0).postTranslate(this.b - i, this.c - j);
      PhotoViewAttacher.d(this.this$0);
      this.b = i;
      this.c = j;
      Compat.a(PhotoViewAttacher.i(this.this$0), this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multitouchimg.PhotoViewAttacher.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */