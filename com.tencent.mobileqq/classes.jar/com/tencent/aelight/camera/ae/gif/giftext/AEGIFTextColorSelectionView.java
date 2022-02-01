package com.tencent.aelight.camera.ae.gif.giftext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.util.DisplayUtil;

public class AEGIFTextColorSelectionView
  extends View
{
  private static String l = "#FFFFFF";
  private static String m = "#FFFFFF";
  private static String n = "#3CB6FF";
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private String f;
  private Context g;
  private Paint h;
  private Paint i;
  private Paint j;
  private boolean k;
  
  public AEGIFTextColorSelectionView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEGIFTextColorSelectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEGIFTextColorSelectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.g = paramContext;
    this.k = true;
    this.f = l;
    this.h = new Paint(1);
    this.h.setColor(Color.parseColor(this.f));
    this.j = new Paint(1);
    this.j.setColor(Color.parseColor(m));
    this.i = new Paint(1);
    this.i.setColor(Color.parseColor(n));
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(DisplayUtil.a(this.g, 2.0F));
  }
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue() != this.k)
    {
      this.k = paramBoolean.booleanValue();
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.k) {
      paramCanvas.drawCircle(this.a / 2, this.b / 2, this.e, this.i);
    }
    paramCanvas.drawCircle(this.a / 2, this.b / 2, this.c, this.j);
    paramCanvas.drawCircle(this.a / 2, this.b / 2, this.d, this.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = View.MeasureSpec.getSize(paramInt1);
    this.b = View.MeasureSpec.getSize(paramInt2);
    this.e = (this.a / 2 - DisplayUtil.a(this.g, 1.0F));
    this.c = (this.e - DisplayUtil.a(this.g, 5.0F));
    this.d = (this.c - DisplayUtil.a(this.g, 2.0F));
  }
  
  public void setColor(String paramString)
  {
    this.f = paramString;
    this.h.setColor(Color.parseColor(paramString));
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorSelectionView
 * JD-Core Version:    0.7.0.1
 */