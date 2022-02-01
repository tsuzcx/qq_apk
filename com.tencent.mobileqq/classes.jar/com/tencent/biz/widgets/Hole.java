package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class Hole
  extends View
{
  public int a;
  public int b;
  public int c;
  private Paint d;
  
  public Hole(Context paramContext)
  {
    super(paramContext);
  }
  
  public Hole(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new Paint();
    this.d.setColor(-16777216);
    this.d.setAntiAlias(true);
    this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  public Hole(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawARGB(221, 0, 0, 0);
    paramCanvas.drawCircle(this.a, this.b, this.c, this.d);
  }
  
  public void setHole(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.Hole
 * JD-Core Version:    0.7.0.1
 */