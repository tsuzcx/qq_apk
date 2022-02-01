package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;

public class ArkAppLoadLayout
  extends RelativeLayout
{
  public static int a = -2565408;
  public static int b = -2565408;
  public static Paint c = new Paint(1);
  int d = -2565408;
  public boolean e = false;
  private Path f = new Path();
  private RectF g = new RectF();
  private ArkViewImplement h;
  
  public ArkAppLoadLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArkAppLoadLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ArkAppLoadLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.e)
    {
      Paint localPaint = c;
      int i;
      if (isPressed()) {
        i = a;
      } else {
        i = this.d;
      }
      localPaint.setColor(i);
      paramCanvas.drawPath(this.f, c);
    }
    super.draw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.e)
    {
      this.g.set(0.0F, 0.0F, View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      this.f.reset();
      this.h.makePath(this.g, this.f);
    }
  }
  
  public void setArkView(ArkViewImplement paramArkViewImplement)
  {
    this.h = paramArkViewImplement;
    setWillNotDraw(false);
  }
  
  public void setBkgColorNormal(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout
 * JD-Core Version:    0.7.0.1
 */