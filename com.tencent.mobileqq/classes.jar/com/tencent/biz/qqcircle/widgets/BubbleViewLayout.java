package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class BubbleViewLayout
  extends RelativeLayout
{
  public boolean a = true;
  float[] b;
  RectF c;
  Path d;
  private Paint e;
  private Paint f;
  private boolean g = true;
  private boolean h = true;
  private float i = 30.0F;
  private Resources j;
  
  public BubbleViewLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BubbleViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.e = new Paint();
    this.e.setColor(-1);
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.f = new Paint();
    this.f.setXfermode(null);
    this.d = new Path();
    this.c = new RectF();
    this.b = new float[8];
    this.j = getResources();
    setRadius(15.0F);
    setWillNotDraw(false);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.g)
    {
      this.c.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      if (this.h)
      {
        this.d.reset();
        this.d.addRoundRect(this.c, this.b, Path.Direction.CW);
      }
      return;
    }
    Resources localResources = this.j;
    float f1 = a(10.0F, localResources);
    if (this.a) {
      this.c.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
    } else {
      this.c.set(f1, 0.0F, paramFloat1, paramFloat2);
    }
    this.d.reset();
    paramFloat2 = a(5.0F, localResources);
    float f2;
    if (this.a)
    {
      this.d.addRoundRect(this.c, this.b, Path.Direction.CW);
      f1 = a(14.0F, localResources);
      f2 = a(8.0F, localResources);
      this.d.moveTo(paramFloat1 - f1, f2);
      f1 = a(4.0F, localResources);
      f2 = a(10.0F, localResources);
      this.d.quadTo(paramFloat1 - f1, f2, paramFloat1, paramFloat2);
      paramFloat2 = a(10.0F, localResources);
      f1 = a(16.0F, localResources);
      f2 = a(1.0F, localResources);
      float f3 = a(14.0F, localResources);
      this.d.quadTo(paramFloat1 - f2, f3, paramFloat1 - paramFloat2, f1);
    }
    else
    {
      this.d.addRoundRect(this.c, this.b, Path.Direction.CCW);
      paramFloat1 = a(14.0F, localResources);
      f1 = a(8.0F, localResources);
      this.d.moveTo(paramFloat1, f1);
      paramFloat1 = a(4.0F, localResources);
      f1 = a(10.0F, localResources);
      this.d.quadTo(paramFloat1, f1, 0.0F, paramFloat2);
      paramFloat1 = a(10.0F, localResources);
      paramFloat2 = a(16.0F, localResources);
      f1 = a(1.0F, localResources);
      f2 = a(14.0F, localResources);
      this.d.quadTo(f1, f2, paramFloat1, paramFloat2);
    }
    this.d.close();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((Build.VERSION.SDK_INT != 28) && (Build.VERSION.SDK_INT != 29))
    {
      paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.f, 31);
      super.dispatchDraw(paramCanvas);
      paramCanvas.drawPath(this.d, this.e);
      paramCanvas.restore();
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    paramCanvas.clipPath(this.d);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.i = a(paramFloat, this.j);
    float[] arrayOfFloat = this.b;
    if (arrayOfFloat != null) {
      Arrays.fill(arrayOfFloat, this.i);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.i = a(paramFloat, this.j);
    float[] arrayOfFloat = this.b;
    if (arrayOfFloat != null)
    {
      Arrays.fill(arrayOfFloat, 0, 4, this.i);
      Arrays.fill(this.b, 4, 8, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.BubbleViewLayout
 * JD-Core Version:    0.7.0.1
 */