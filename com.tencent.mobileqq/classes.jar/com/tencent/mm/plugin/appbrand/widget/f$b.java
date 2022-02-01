package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;

class f$b
{
  public f.a a = null;
  private Rect c = new Rect();
  private RectF d = new RectF();
  private Path e = new Path();
  
  public f$b(f paramf) {}
  
  void a(Canvas paramCanvas)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((f.a)localObject).a();
      this.c.setEmpty();
      this.b.getGlobalVisibleRect(this.c);
      RectF localRectF1 = new RectF(0.0F, 0.0F, this.c.right - this.c.left, this.c.bottom - this.c.top);
      this.d.setEmpty();
      RectF localRectF2 = this.d;
      localRectF2.left = 0.0F;
      localRectF2.top = 0.0F;
      localRectF2.right = (this.c.right - this.c.left);
      this.d.bottom = (this.c.bottom - this.c.top);
      this.e.rewind();
      this.e.addRoundRect(localRectF1, (float[])localObject, Path.Direction.CW);
      this.e.close();
      paramCanvas.clipPath(this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.b
 * JD-Core Version:    0.7.0.1
 */