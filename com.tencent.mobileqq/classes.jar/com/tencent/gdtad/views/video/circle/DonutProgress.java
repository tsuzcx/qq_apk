package com.tencent.gdtad.views.video.circle;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.ad.api.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;

public class DonutProgress
  extends View
{
  private float A;
  private final float B = ViewUtils.dip2px(10.0F);
  private final int C = Color.rgb(66, 145, 241);
  private final int D = Color.rgb(204, 204, 204);
  private final int E = Color.rgb(66, 145, 241);
  private final int F = Color.rgb(66, 145, 241);
  private final int G = 0;
  private final int H = 100;
  private final int I = 0;
  private final float J = ViewUtils.spToPx(18.0F);
  private final float K = ViewUtils.spToPx(18.0F);
  private final int L = ViewUtils.dip2px(100.0F);
  private boolean M;
  protected Paint a;
  protected Paint b;
  private Paint c;
  private Paint d;
  private Paint e;
  private RectF f = new RectF();
  private RectF g = new RectF();
  private int h = 0;
  private Bitmap i;
  private boolean j;
  private float k;
  private int l;
  private int m;
  private float n = 0.0F;
  private int o;
  private int p;
  private int q;
  private int r;
  private float s;
  private float t;
  private int u;
  private String v = "";
  private String w = "%";
  private String x = null;
  private float y;
  private String z;
  
  public DonutProgress(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DonutProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DonutProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.Q, paramInt, 0);
    a(paramAttributeSet);
    paramAttributeSet.recycle();
    a(paramContext);
    a();
  }
  
  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824) {
      return paramInt;
    }
    int i2 = this.L;
    if (i1 == -2147483648) {
      return Math.min(i2, paramInt);
    }
    return i2;
  }
  
  private float getProgressAngle()
  {
    return getProgress() / this.o * 360.0F;
  }
  
  protected void a()
  {
    if (this.j)
    {
      this.a = new TextPaint();
      this.a.setColor(this.l);
      this.a.setTextSize(this.k);
      this.a.setAntiAlias(true);
      this.b = new TextPaint();
      this.b.setColor(this.m);
      this.b.setTextSize(this.y);
      this.b.setAntiAlias(true);
    }
    this.c = new Paint();
    this.c.setColor(this.p);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAntiAlias(true);
    this.c.setStrokeWidth(this.s);
    this.d = new Paint();
    this.d.setColor(this.q);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setAntiAlias(true);
    this.d.setStrokeWidth(this.t);
    this.e = new Paint();
    this.e.setColor(this.u);
    this.e.setAntiAlias(true);
  }
  
  protected void a(Context paramContext)
  {
    int i1 = this.h;
    if (i1 != 0) {
      this.i = Utils.a(paramContext, i1);
    }
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    this.p = paramTypedArray.getColor(R.styleable.T, this.C);
    this.q = paramTypedArray.getColor(R.styleable.ah, this.D);
    this.j = paramTypedArray.getBoolean(R.styleable.ac, true);
    this.h = paramTypedArray.getResourceId(R.styleable.Y, 0);
    setMax(paramTypedArray.getInt(R.styleable.Z, 100));
    setProgress(paramTypedArray.getFloat(R.styleable.ab, 0.0F));
    this.s = paramTypedArray.getDimension(R.styleable.U, this.B);
    this.t = paramTypedArray.getDimension(R.styleable.ai, this.B);
    if (this.j)
    {
      if (paramTypedArray.getString(R.styleable.aa) != null) {
        this.v = paramTypedArray.getString(R.styleable.aa);
      }
      if (paramTypedArray.getString(R.styleable.ad) != null) {
        this.w = paramTypedArray.getString(R.styleable.ad);
      }
      if (paramTypedArray.getString(R.styleable.ae) != null) {
        this.x = paramTypedArray.getString(R.styleable.ae);
      }
      this.l = paramTypedArray.getColor(R.styleable.af, this.E);
      this.k = paramTypedArray.getDimension(R.styleable.ag, this.J);
      this.y = paramTypedArray.getDimension(R.styleable.X, this.K);
      this.m = paramTypedArray.getColor(R.styleable.W, this.F);
      this.z = paramTypedArray.getString(R.styleable.V);
    }
    this.y = paramTypedArray.getDimension(R.styleable.X, this.K);
    this.m = paramTypedArray.getColor(R.styleable.W, this.F);
    this.z = paramTypedArray.getString(R.styleable.V);
    this.r = paramTypedArray.getInt(R.styleable.S, 0);
    this.u = paramTypedArray.getColor(R.styleable.R, 0);
  }
  
  protected void b()
  {
    a(getContext());
  }
  
  public int getAttributeResourceId()
  {
    return this.h;
  }
  
  public int getFinishedStrokeColor()
  {
    return this.p;
  }
  
  public float getFinishedStrokeWidth()
  {
    return this.s;
  }
  
  public int getInnerBackgroundColor()
  {
    return this.u;
  }
  
  public String getInnerBottomText()
  {
    return this.z;
  }
  
  public int getInnerBottomTextColor()
  {
    return this.m;
  }
  
  public float getInnerBottomTextSize()
  {
    return this.y;
  }
  
  public int getMax()
  {
    return this.o;
  }
  
  public String getPrefixText()
  {
    return this.v;
  }
  
  public float getProgress()
  {
    return this.n;
  }
  
  public int getStartingDegree()
  {
    return this.r;
  }
  
  public String getSuffixText()
  {
    return this.w;
  }
  
  public String getText()
  {
    return this.x;
  }
  
  public int getTextColor()
  {
    return this.l;
  }
  
  public float getTextSize()
  {
    return this.k;
  }
  
  public int getUnfinishedStrokeColor()
  {
    return this.q;
  }
  
  public float getUnfinishedStrokeWidth()
  {
    return this.t;
  }
  
  public void invalidate()
  {
    a();
    super.invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = Math.max(this.s, this.t);
    this.f.set(f1, f1, getWidth() - f1, getHeight() - f1);
    this.g.set(f1, f1, getWidth() - f1, getHeight() - f1);
    f1 = (getWidth() - Math.min(this.s, this.t) + Math.abs(this.s - this.t)) / 2.0F;
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1, this.e);
    if (!this.M)
    {
      paramCanvas.drawArc(this.f, -(360.0F - getStartingDegree()), -getProgressAngle(), false, this.c);
      paramCanvas.drawArc(this.g, -(360.0F - getStartingDegree()) - getProgressAngle(), -(360.0F - getProgressAngle()), false, this.d);
    }
    else
    {
      paramCanvas.drawArc(this.f, getStartingDegree(), getProgressAngle(), false, this.c);
      localObject = this.g;
      f1 = getStartingDegree();
      paramCanvas.drawArc((RectF)localObject, getProgressAngle() + f1, 360.0F - getProgressAngle(), false, this.d);
    }
    if (this.j)
    {
      localObject = this.x;
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.v);
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append(this.w);
        localObject = ((StringBuilder)localObject).toString();
      }
      float f2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        f1 = this.a.descent();
        f2 = this.a.ascent();
        paramCanvas.drawText((String)localObject, (getWidth() - this.a.measureText((String)localObject)) / 2.0F, (getWidth() - (f1 + f2)) / 2.0F, this.a);
      }
      if (!TextUtils.isEmpty(getInnerBottomText()))
      {
        this.b.setTextSize(this.y);
        f1 = getHeight();
        f2 = this.A;
        float f3 = (this.a.descent() + this.a.ascent()) / 2.0F;
        paramCanvas.drawText(getInnerBottomText(), (getWidth() - this.b.measureText(getInnerBottomText())) / 2.0F, f1 - f2 - f3, this.b);
      }
    }
    Object localObject = this.i;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, (getWidth() - this.i.getWidth()) / 2.0F, (getHeight() - this.i.getHeight()) / 2.0F, null);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), a(paramInt2));
    this.A = (getHeight() - getHeight() * 3 / 4);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.l = paramParcelable.getInt("text_color");
      this.k = paramParcelable.getFloat("text_size");
      this.y = paramParcelable.getFloat("inner_bottom_text_size");
      this.z = paramParcelable.getString("inner_bottom_text");
      this.m = paramParcelable.getInt("inner_bottom_text_color");
      this.p = paramParcelable.getInt("finished_stroke_color");
      this.q = paramParcelable.getInt("unfinished_stroke_color");
      this.s = paramParcelable.getFloat("finished_stroke_width");
      this.t = paramParcelable.getFloat("unfinished_stroke_width");
      this.u = paramParcelable.getInt("inner_background_color");
      this.h = paramParcelable.getInt("inner_drawable");
      b();
      a();
      setMax(paramParcelable.getInt("max"));
      setStartingDegree(paramParcelable.getInt("starting_degree"));
      setProgress(paramParcelable.getFloat("progress"));
      this.v = paramParcelable.getString("prefix");
      this.w = paramParcelable.getString("suffix");
      this.x = paramParcelable.getString("text");
      super.onRestoreInstanceState(paramParcelable.getParcelable("saved_instance"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("saved_instance", super.onSaveInstanceState());
    localBundle.putInt("text_color", getTextColor());
    localBundle.putFloat("text_size", getTextSize());
    localBundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
    localBundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
    localBundle.putString("inner_bottom_text", getInnerBottomText());
    localBundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
    localBundle.putInt("finished_stroke_color", getFinishedStrokeColor());
    localBundle.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
    localBundle.putInt("max", getMax());
    localBundle.putInt("starting_degree", getStartingDegree());
    localBundle.putFloat("progress", getProgress());
    localBundle.putString("suffix", getSuffixText());
    localBundle.putString("prefix", getPrefixText());
    localBundle.putString("text", getText());
    localBundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
    localBundle.putFloat("unfinished_stroke_width", getUnfinishedStrokeWidth());
    localBundle.putInt("inner_background_color", getInnerBackgroundColor());
    localBundle.putInt("inner_drawable", getAttributeResourceId());
    return localBundle;
  }
  
  public void setAttributeResourceId(int paramInt)
  {
    this.h = paramInt;
    b();
    invalidate();
  }
  
  public void setClockWise(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setFinishedStrokeColor(int paramInt)
  {
    this.p = paramInt;
    invalidate();
  }
  
  public void setFinishedStrokeWidth(float paramFloat)
  {
    this.s = paramFloat;
    invalidate();
  }
  
  public void setInnerBackgroundColor(int paramInt)
  {
    this.u = paramInt;
    invalidate();
  }
  
  public void setInnerBottomText(String paramString)
  {
    this.z = paramString;
    invalidate();
  }
  
  public void setInnerBottomTextColor(int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }
  
  public void setInnerBottomTextSize(float paramFloat)
  {
    this.y = paramFloat;
    invalidate();
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt > 0)
    {
      this.o = paramInt;
      invalidate();
    }
  }
  
  public void setPrefixText(String paramString)
  {
    this.v = paramString;
    invalidate();
  }
  
  public void setProgress(float paramFloat)
  {
    this.n = paramFloat;
    if (this.n > getMax()) {
      this.n %= getMax();
    }
    invalidate();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setStartingDegree(int paramInt)
  {
    this.r = paramInt;
    invalidate();
  }
  
  public void setSuffixText(String paramString)
  {
    this.w = paramString;
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.x = paramString;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.l = paramInt;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.k = paramFloat;
    invalidate();
  }
  
  public void setUnfinishedStrokeColor(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
  
  public void setUnfinishedStrokeWidth(float paramFloat)
  {
    this.t = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.circle.DonutProgress
 * JD-Core Version:    0.7.0.1
 */