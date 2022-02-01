package com.tencent.biz.qqstory.album.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class RoundCornerLayout
  extends RelativeLayout
{
  public static final float[] a = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  private static boolean l;
  Paint b;
  float[] c;
  Path d;
  RectF e;
  RectF f;
  public boolean g;
  private float h;
  private Resources i;
  private Paint j;
  private Path k;
  
  static
  {
    String str = Build.MODEL.toUpperCase();
    boolean bool;
    if ((!str.contains("BV0720")) && (!str.contains("M821")) && ((Build.VERSION.SDK_INT != 21) || ((!str.contains("NX511J")) && (!str.contains("MI 5")) && (!str.contains("GT-I9508")) && (!str.contains("X9077")) && (!str.contains("COOLPAD 8675-A"))))) {
      bool = false;
    } else {
      bool = true;
    }
    l = bool;
  }
  
  public RoundCornerLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.g = l;
    this.i = getResources();
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setAntiAlias(true);
    this.b.setFilterBitmap(true);
    this.b.setColor(-1);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.d = new Path();
    this.e = new RectF();
    this.f = new RectF();
    this.c = new float[8];
    this.j = new Paint();
    this.j.setColor(-1);
    this.j.setAntiAlias(true);
    this.j.setStrokeWidth(4.0F);
    this.j.setStyle(Paint.Style.STROKE);
    this.k = new Path();
    setWillNotDraw(false);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.e.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.d.reset();
    this.d.addRoundRect(this.e, this.c, Path.Direction.CW);
    this.f.set(2.0F, 2.0F, paramFloat1 - 2.0F, paramFloat2 - 2.0F);
    this.k.reset();
    this.k.addRoundRect(this.f, this.c, Path.Direction.CW);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int m = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    paramCanvas.drawPath(this.d, this.b);
    paramCanvas.drawPath(this.k, this.j);
    paramCanvas.restoreToCount(m);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.g)
    {
      setLayerType(1, null);
      return;
    }
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setLayerType(0, null);
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
    this.h = a(paramFloat, this.i);
    float[] arrayOfFloat = this.c;
    if (arrayOfFloat != null) {
      Arrays.fill(arrayOfFloat, this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.RoundCornerLayout
 * JD-Core Version:    0.7.0.1
 */