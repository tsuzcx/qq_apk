package com.tencent.biz.pubaccount.weishi_new.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.view.View;

public class RoundCornerHelper
{
  public Path a;
  public Paint b;
  public int c;
  public int d;
  public boolean e;
  public Region f;
  public RectF g;
  
  public void a()
  {
    this.g = new RectF();
    this.a = new Path();
    this.f = new Region();
    this.b = new Paint();
    this.b.setColor(-1);
    this.b.setAntiAlias(true);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.d > 0)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      this.b.setColor(-1);
      this.b.setStrokeWidth(this.d * 2);
      this.b.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.a, this.b);
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      this.b.setColor(this.c);
      this.b.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.a, this.b);
    }
    this.b.setColor(-1);
    this.b.setStyle(Paint.Style.FILL);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(this.a, this.b);
      return;
    }
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    Path localPath = new Path();
    localPath.addRect(0.0F, 0.0F, (int)this.g.width(), (int)this.g.height(), Path.Direction.CW);
    localPath.op(this.a, Path.Op.DIFFERENCE);
    paramCanvas.drawPath(localPath, this.b);
  }
  
  public void a(View paramView)
  {
    int i = (int)this.g.width();
    int j = (int)this.g.height();
    RectF localRectF = new RectF();
    localRectF.left = paramView.getPaddingLeft();
    localRectF.top = paramView.getPaddingTop();
    localRectF.right = (i - paramView.getPaddingRight());
    localRectF.bottom = (j - paramView.getPaddingBottom());
    this.a.reset();
    float f1;
    if (localRectF.width() >= localRectF.height()) {
      f1 = localRectF.height();
    } else {
      f1 = localRectF.width();
    }
    f1 /= 2.0F;
    float f2 = i / 2;
    float f3 = j / 2;
    paramView = new PointF(f2, f3);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.a.addCircle(paramView.x, paramView.y, f1, Path.Direction.CW);
      this.a.moveTo(0.0F, 0.0F);
      this.a.moveTo(i, j);
    }
    else
    {
      f2 = f3 - f1;
      this.a.moveTo(localRectF.left, f2);
      this.a.addCircle(paramView.x, f2 + f1, f1, Path.Direction.CW);
    }
    paramView = new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    this.f.setPath(this.a, paramView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    this.g.set(0.0F, 0.0F, paramInt1, paramInt2);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerHelper
 * JD-Core Version:    0.7.0.1
 */