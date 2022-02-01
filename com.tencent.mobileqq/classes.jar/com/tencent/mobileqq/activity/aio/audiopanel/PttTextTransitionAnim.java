package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class PttTextTransitionAnim
  extends ImageView
{
  int a;
  int b;
  int c;
  float d;
  String e;
  String f;
  String g;
  float h;
  float i;
  float j;
  int k = 255;
  int l = 0;
  int m = 0;
  float n;
  float o;
  float p;
  int q = -1;
  private Context r;
  private Paint s;
  
  public PttTextTransitionAnim(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PttTextTransitionAnim(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PttTextTransitionAnim(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.r = paramContext;
    a();
  }
  
  private void a()
  {
    this.s = new Paint();
    this.s.setAntiAlias(true);
    this.s.setColor(getResources().getColor(2131167982));
    this.s.setTextSize(ViewUtils.dip2px(16.0F));
    this.k = 255;
    this.l = 0;
    this.n = 0.0F;
    this.o = 0.0F;
    this.p = 0.0F;
    this.e = this.r.getString(2131886568);
    this.f = this.r.getString(2131886570);
    this.g = this.r.getString(2131896461);
    this.h = this.s.measureText(this.e);
    this.i = this.s.measureText(this.f);
    this.j = this.s.measureText(this.g);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.e != null) && (this.f != null))
    {
      if (this.g == null) {
        return;
      }
      paramCanvas.save();
      this.s.setAlpha(this.k);
      paramCanvas.drawText(this.e, this.a + this.n - this.h / 2.0F, this.b, this.s);
      this.s.setAlpha(this.l);
      paramCanvas.drawText(this.f, this.a + this.o - this.i / 2.0F, this.b, this.s);
      this.s.setAlpha(this.m);
      paramCanvas.drawText(this.g, this.a + this.p - this.j / 2.0F, this.b, this.s);
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = ((paramInt3 - paramInt1) / 2);
    this.b = ((paramInt4 - paramInt2) / 2);
    double d1 = this.a;
    Double.isNaN(d1);
    this.c = ((int)(d1 * 0.8D));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout ");
      localStringBuilder.append(toString());
      QLog.d("PttTextTransitionAnim", 2, localStringBuilder.toString());
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.q = paramInt;
    if (paramInt == 0)
    {
      this.d = 0.0F;
      setProgress(this.d);
      return;
    }
    if (paramInt == 1)
    {
      this.d = 0.5F;
      setProgress(this.d);
      return;
    }
    this.d = 1.0F;
    setProgress(this.d);
  }
  
  public void setProgress(float paramFloat)
  {
    float f1;
    int i1;
    if (paramFloat <= 0.5F)
    {
      f1 = 0.5F - paramFloat;
      this.k = ((int)(f1 * 255.0F) * 2);
      this.l = ((int)(255.0F * paramFloat) * 2);
      this.m = 0;
      i1 = this.c;
      this.n = (-i1 * paramFloat * 2.0F);
      this.o = (i1 * f1 * 2.0F);
    }
    else
    {
      this.k = 0;
      f1 = 1.0F - paramFloat;
      this.l = ((int)(f1 * 255.0F * 2.0F));
      paramFloat -= 0.5F;
      this.m = ((int)(255.0F * paramFloat * 2.0F));
      i1 = this.c;
      this.o = (-i1 * paramFloat * 2.0F);
      this.p = (i1 * f1 * 2.0F);
    }
    invalidate();
  }
  
  public void setScrollDis(float paramFloat, int paramInt)
  {
    paramFloat = paramFloat / paramInt / 2.0F;
    setProgress(this.d + paramFloat);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttTextTransitionAnim{ progress=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", alphaVoiceChange=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", alphaPressToSpeak=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", alphaRecord=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", tranlateXVoiceChange=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", tranlateXPressToSpeak=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", tranlateXRecord=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", centerX=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", centerY=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTextTransitionAnim
 * JD-Core Version:    0.7.0.1
 */