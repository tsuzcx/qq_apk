package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.Utils;

public class ColorView
  extends View
{
  private ColorView.ColorViewListener a;
  private int b;
  private Paint c;
  private Bitmap d;
  private int e = Utils.a(4.0F, getResources());
  
  public ColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getColor()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.d;
    if (localObject != null)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, new RectF(0.0F, 0.0F, getWidth(), getHeight()), null);
      return;
    }
    if (this.c == null) {
      return;
    }
    int j = getWidth();
    int k = getHeight();
    if (j > k) {
      i = j;
    } else {
      i = k;
    }
    this.c.setStrokeWidth(i);
    localObject = new RectF(0.0F, 0.0F, j, k);
    int i = this.e;
    paramCanvas.drawRoundRect((RectF)localObject, i, i, this.c);
  }
  
  public void setBtmap(Bitmap paramBitmap)
  {
    this.d = paramBitmap;
    this.c = null;
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.b = paramInt;
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setAntiAlias(true);
    }
    this.c.setColor(this.b);
    this.d = null;
    invalidate();
  }
  
  public void setListener(ColorView.ColorViewListener paramColorViewListener)
  {
    this.a = paramColorViewListener;
    setOnClickListener(new ColorView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorView
 * JD-Core Version:    0.7.0.1
 */