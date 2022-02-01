package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class ArcBackGroundTextView
  extends TextView
{
  private int a;
  private int b;
  private float c;
  private float d;
  private Paint e = new Paint();
  private Path f;
  
  public ArcBackGroundTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ArcBackGroundTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ArcBackGroundTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e.setColor(1711276032);
    this.e.setStyle(Paint.Style.FILL);
    this.f = new Path();
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ArcBackGroundTextView, 0, 0);
    this.c = paramContext.getDimension(1, 0.0F);
    this.d = paramContext.getDimension(0, 0.0F);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.f, this.e);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = Math.round(this.d);
    this.b = ((int)Math.round(Math.sqrt(Math.pow(this.c, 2.0D) - Math.pow(this.c - this.a, 2.0D)) * 2.0D));
    setMeasuredDimension(this.b, this.a);
    if (getId() == 2131444157) {
      paramInt1 = 0;
    } else {
      paramInt1 = 5;
    }
    double d1;
    for (float f1 = 0.0F; f1 < this.b; f1 = (float)(d1 + 0.2D))
    {
      d1 = Math.sqrt(Math.pow(this.c, 2.0D) - Math.pow(f1 - this.b / 2, 2.0D));
      double d2 = this.a;
      Double.isNaN(d2);
      float f2 = (float)(d1 - d2);
      this.f.lineTo(f1, f2 + paramInt1);
      d1 = f1;
      Double.isNaN(d1);
    }
    this.f.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ArcBackGroundTextView
 * JD-Core Version:    0.7.0.1
 */