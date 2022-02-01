package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class RoundCornerImageView
  extends URLImageView
{
  private Path a = new Path();
  private Paint b = new Paint();
  private int c = Color.parseColor("#FFD5D5D5");
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private RectF h = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
  private float[] i;
  
  public RoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.d;
    float f1 = paramInt;
    float f2 = paramInt;
    paramInt = this.e;
    float f3 = paramInt;
    float f4 = paramInt;
    paramInt = this.g;
    float f5 = paramInt;
    float f6 = paramInt;
    paramInt = this.f;
    this.i = new float[] { f1, f2, f3, f4, f5, f6, paramInt, paramInt };
    this.b.setColor(this.c);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setAntiAlias(true);
    this.b.setFilterBitmap(true);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    } else if (Build.VERSION.SDK_INT >= 14) {
      super.setLayerType(1, null);
    }
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.roundCornerImageView);
      this.d = paramContext.getDimensionPixelSize(3, 0);
      this.e = paramContext.getDimensionPixelSize(4, 0);
      this.f = paramContext.getDimensionPixelSize(1, 0);
      this.g = paramContext.getDimensionPixelSize(2, 0);
      paramInt = paramContext.getDimensionPixelSize(0, 0);
      if (this.d == 0) {
        this.d = paramInt;
      }
      if (this.e == 0) {
        this.e = paramInt;
      }
      if (this.f == 0) {
        this.f = paramInt;
      }
      if (this.g == 0) {
        this.g = paramInt;
      }
      paramContext.recycle();
      this.i[0] = this.d;
      this.i[1] = this.d;
      this.i[2] = this.e;
      this.i[3] = this.e;
      this.i[4] = this.g;
      this.i[5] = this.g;
      this.i[6] = this.f;
      this.i[7] = this.f;
      return;
    }
    catch (Exception paramContext)
    {
      label450:
      break label450;
    }
    QLog.e("RoundCornerImageView", 1, "init RoundCornerImageView catch exception");
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a == null) {
      this.a = new Path();
    }
    this.a.reset();
    int j = getWidth();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    this.h.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (j - k - m), getPaddingTop() + (n - i1 - i2));
    this.a.addRoundRect(this.h, this.i, Path.Direction.CW);
    this.a.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.a);
    super.draw(paramCanvas);
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = paramInt3;
      this.g = paramInt4;
      float[] arrayOfFloat = this.i;
      float f1 = paramInt1;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f1;
      f1 = paramInt2;
      arrayOfFloat[2] = f1;
      arrayOfFloat[3] = f1;
      f1 = paramInt4;
      arrayOfFloat[4] = f1;
      arrayOfFloat[5] = f1;
      f1 = paramInt3;
      arrayOfFloat[6] = f1;
      arrayOfFloat[7] = f1;
      return;
    }
    throw new IllegalArgumentException("should not be less than 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */