package com.tencent.luggage.wxa.dl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.view.View;

public class c
  extends View
{
  int a = 0;
  int b = 0;
  private Rect c;
  private Bitmap d = null;
  private Bitmap e = null;
  private Bitmap f = null;
  private Bitmap g = null;
  private Paint h = new Paint();
  private Paint i = new Paint();
  
  public c(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.d = BitmapFactory.decodeResource(getResources(), 2130851681);
    this.e = BitmapFactory.decodeResource(getResources(), 2130851682);
    this.f = BitmapFactory.decodeResource(getResources(), 2130851683);
    this.g = BitmapFactory.decodeResource(getResources(), 2130851684);
    this.a = this.d.getWidth();
    this.b = this.d.getHeight();
    this.h.setAntiAlias(true);
    this.i.setAntiAlias(true);
  }
  
  public Rect getRect()
  {
    return new Rect(this.c);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipRect(this.c, Region.Op.DIFFERENCE);
    paramCanvas.drawRect(this.c, this.h);
    paramCanvas.restore();
    paramCanvas.drawBitmap(this.d, this.c.left, this.c.top, this.i);
    paramCanvas.drawBitmap(this.e, this.c.right - this.a, this.c.top, this.i);
    paramCanvas.drawBitmap(this.f, this.c.left, this.c.bottom - this.b, this.i);
    paramCanvas.drawBitmap(this.g, this.c.right - this.a, this.c.bottom - this.b, this.i);
  }
  
  public void setRect(Rect paramRect)
  {
    this.c = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dl.c
 * JD-Core Version:    0.7.0.1
 */