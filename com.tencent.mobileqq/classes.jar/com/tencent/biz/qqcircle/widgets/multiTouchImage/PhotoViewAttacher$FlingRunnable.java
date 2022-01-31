package com.tencent.biz.qqcircle.widgets.multiTouchImage;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.OverScroller;
import uhn;

public class PhotoViewAttacher$FlingRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  private int b;
  
  public PhotoViewAttacher$FlingRunnable(PhotoViewAttacher paramPhotoViewAttacher, Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetOverScroller.forceFinished(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RectF localRectF = this.this$0.a();
    if (localRectF == null) {
      return;
    }
    int i = Math.round(-localRectF.left);
    int j;
    label52:
    int k;
    int m;
    if (paramInt1 < localRectF.width())
    {
      j = Math.round(localRectF.width() - paramInt1);
      paramInt1 = 0;
      k = Math.round(-localRectF.top);
      if (paramInt2 >= localRectF.height()) {
        break label148;
      }
      m = Math.round(localRectF.height() - paramInt2);
    }
    for (paramInt2 = 0;; paramInt2 = k)
    {
      this.jdField_a_of_type_Int = i;
      this.b = k;
      if ((i == j) && (k == m)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetOverScroller.fling(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
      return;
      j = i;
      paramInt1 = i;
      break label52;
      label148:
      m = k;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetOverScroller.isFinished()) {}
    while (!this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset()) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
    int j = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
    PhotoViewAttacher.a(this.this$0).postTranslate(this.jdField_a_of_type_Int - i, this.b - j);
    PhotoViewAttacher.a(this.this$0);
    this.jdField_a_of_type_Int = i;
    this.b = j;
    uhn.a(PhotoViewAttacher.a(this.this$0), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */