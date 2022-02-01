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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected Paint a;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  protected Paint b;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_b_of_type_JavaLangString = "%";
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private String jdField_c_of_type_JavaLangString = null;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private String jdField_d_of_type_JavaLangString;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private Paint jdField_e_of_type_AndroidGraphicsPaint;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private final float jdField_g_of_type_Float = ViewUtils.a(10.0F);
  private int jdField_g_of_type_Int;
  private final float jdField_h_of_type_Float = ViewUtils.d(18.0F);
  private int jdField_h_of_type_Int;
  private final float jdField_i_of_type_Float = ViewUtils.d(18.0F);
  private final int jdField_i_of_type_Int = Color.rgb(66, 145, 241);
  private final int j = Color.rgb(204, 204, 204);
  private final int k = Color.rgb(66, 145, 241);
  private final int l = Color.rgb(66, 145, 241);
  private final int m = 0;
  private final int n = 100;
  private final int o = 0;
  private final int p = ViewUtils.a(100.0F);
  
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
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.M, paramInt, 0);
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
    int i2 = this.p;
    if (i1 == -2147483648) {
      return Math.min(i2, paramInt);
    }
    return i2;
  }
  
  private float f()
  {
    return c() / this.jdField_d_of_type_Int * 360.0F;
  }
  
  public float a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint = new TextPaint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_e_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Float);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.jdField_f_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_d_of_type_Float);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(this.jdField_h_of_type_Int);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  protected void a(Context paramContext)
  {
    int i1 = this.jdField_a_of_type_Int;
    if (i1 != 0) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Utils.a(paramContext, i1);
    }
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    this.jdField_e_of_type_Int = paramTypedArray.getColor(R.styleable.jdField_f_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_f_of_type_Int = paramTypedArray.getColor(R.styleable.t, this.j);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.o, true);
    this.jdField_a_of_type_Int = paramTypedArray.getResourceId(R.styleable.k, 0);
    setMax(paramTypedArray.getInt(R.styleable.l, 100));
    setProgress(paramTypedArray.getFloat(R.styleable.n, 0.0F));
    this.jdField_c_of_type_Float = paramTypedArray.getDimension(R.styleable.jdField_g_of_type_Int, this.jdField_g_of_type_Float);
    this.jdField_d_of_type_Float = paramTypedArray.getDimension(R.styleable.u, this.jdField_g_of_type_Float);
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramTypedArray.getString(R.styleable.m) != null) {
        this.jdField_a_of_type_JavaLangString = paramTypedArray.getString(R.styleable.m);
      }
      if (paramTypedArray.getString(R.styleable.p) != null) {
        this.jdField_b_of_type_JavaLangString = paramTypedArray.getString(R.styleable.p);
      }
      if (paramTypedArray.getString(R.styleable.q) != null) {
        this.jdField_c_of_type_JavaLangString = paramTypedArray.getString(R.styleable.q);
      }
      this.jdField_b_of_type_Int = paramTypedArray.getColor(R.styleable.r, this.k);
      this.jdField_a_of_type_Float = paramTypedArray.getDimension(R.styleable.s, this.jdField_h_of_type_Float);
      this.jdField_e_of_type_Float = paramTypedArray.getDimension(R.styleable.j, this.jdField_i_of_type_Float);
      this.jdField_c_of_type_Int = paramTypedArray.getColor(R.styleable.jdField_i_of_type_Int, this.l);
      this.jdField_d_of_type_JavaLangString = paramTypedArray.getString(R.styleable.jdField_h_of_type_Int);
    }
    this.jdField_e_of_type_Float = paramTypedArray.getDimension(R.styleable.j, this.jdField_i_of_type_Float);
    this.jdField_c_of_type_Int = paramTypedArray.getColor(R.styleable.jdField_i_of_type_Int, this.l);
    this.jdField_d_of_type_JavaLangString = paramTypedArray.getString(R.styleable.jdField_h_of_type_Int);
    this.jdField_g_of_type_Int = paramTypedArray.getInt(R.styleable.jdField_e_of_type_Int, 0);
    this.jdField_h_of_type_Int = paramTypedArray.getColor(R.styleable.jdField_d_of_type_Int, 0);
  }
  
  public float b()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void b()
  {
    a(getContext());
  }
  
  public float c()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public float d()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int d()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public float e()
  {
    return this.jdField_e_of_type_Float;
  }
  
  public int e()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public int f()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int g()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public int h()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void invalidate()
  {
    a();
    super.invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = Math.max(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, f1, getWidth() - f1, getHeight() - f1);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(f1, f1, getWidth() - f1, getHeight() - f1);
    f1 = (getWidth() - Math.min(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float) + Math.abs(this.jdField_c_of_type_Float - this.jdField_d_of_type_Float)) / 2.0F;
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1, this.jdField_e_of_type_AndroidGraphicsPaint);
    if (!this.jdField_b_of_type_Boolean)
    {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -(360.0F - g()), -f(), false, this.jdField_c_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, -(360.0F - g()) - f(), -(360.0F - f()), false, this.jdField_d_of_type_AndroidGraphicsPaint);
    }
    else
    {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, g(), f(), false, this.jdField_c_of_type_AndroidGraphicsPaint);
      localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
      f1 = g();
      paramCanvas.drawArc((RectF)localObject, f() + f1, 360.0F - f(), false, this.jdField_d_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_c_of_type_JavaLangString;
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        localObject = ((StringBuilder)localObject).toString();
      }
      float f2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        f1 = this.jdField_a_of_type_AndroidGraphicsPaint.descent();
        f2 = this.jdField_a_of_type_AndroidGraphicsPaint.ascent();
        paramCanvas.drawText((String)localObject, (getWidth() - this.jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject)) / 2.0F, (getWidth() - (f1 + f2)) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (!TextUtils.isEmpty(d()))
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_e_of_type_Float);
        f1 = getHeight();
        f2 = this.jdField_f_of_type_Float;
        float f3 = (this.jdField_a_of_type_AndroidGraphicsPaint.descent() + this.jdField_a_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
        paramCanvas.drawText(d(), (getWidth() - this.jdField_b_of_type_AndroidGraphicsPaint.measureText(d())) / 2.0F, f1 - f2 - f3, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, (getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F, (getHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2.0F, null);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), a(paramInt2));
    this.jdField_f_of_type_Float = (getHeight() - getHeight() * 3 / 4);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.jdField_b_of_type_Int = paramParcelable.getInt("text_color");
      this.jdField_a_of_type_Float = paramParcelable.getFloat("text_size");
      this.jdField_e_of_type_Float = paramParcelable.getFloat("inner_bottom_text_size");
      this.jdField_d_of_type_JavaLangString = paramParcelable.getString("inner_bottom_text");
      this.jdField_c_of_type_Int = paramParcelable.getInt("inner_bottom_text_color");
      this.jdField_e_of_type_Int = paramParcelable.getInt("finished_stroke_color");
      this.jdField_f_of_type_Int = paramParcelable.getInt("unfinished_stroke_color");
      this.jdField_c_of_type_Float = paramParcelable.getFloat("finished_stroke_width");
      this.jdField_d_of_type_Float = paramParcelable.getFloat("unfinished_stroke_width");
      this.jdField_h_of_type_Int = paramParcelable.getInt("inner_background_color");
      this.jdField_a_of_type_Int = paramParcelable.getInt("inner_drawable");
      b();
      a();
      setMax(paramParcelable.getInt("max"));
      setStartingDegree(paramParcelable.getInt("starting_degree"));
      setProgress(paramParcelable.getFloat("progress"));
      this.jdField_a_of_type_JavaLangString = paramParcelable.getString("prefix");
      this.jdField_b_of_type_JavaLangString = paramParcelable.getString("suffix");
      this.jdField_c_of_type_JavaLangString = paramParcelable.getString("text");
      super.onRestoreInstanceState(paramParcelable.getParcelable("saved_instance"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("saved_instance", super.onSaveInstanceState());
    localBundle.putInt("text_color", b());
    localBundle.putFloat("text_size", d());
    localBundle.putFloat("inner_bottom_text_size", e());
    localBundle.putFloat("inner_bottom_text_color", f());
    localBundle.putString("inner_bottom_text", d());
    localBundle.putInt("inner_bottom_text_color", f());
    localBundle.putInt("finished_stroke_color", c());
    localBundle.putInt("unfinished_stroke_color", d());
    localBundle.putInt("max", a());
    localBundle.putInt("starting_degree", g());
    localBundle.putFloat("progress", c());
    localBundle.putString("suffix", b());
    localBundle.putString("prefix", c());
    localBundle.putString("text", a());
    localBundle.putFloat("finished_stroke_width", a());
    localBundle.putFloat("unfinished_stroke_width", b());
    localBundle.putInt("inner_background_color", e());
    localBundle.putInt("inner_drawable", h());
    return localBundle;
  }
  
  public void setAttributeResourceId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    b();
    invalidate();
  }
  
  public void setClockWise(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setFinishedStrokeColor(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setFinishedStrokeWidth(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
    invalidate();
  }
  
  public void setInnerBackgroundColor(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setInnerBottomText(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void setInnerBottomTextColor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setInnerBottomTextSize(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
    invalidate();
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_d_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setPrefixText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    if (this.jdField_b_of_type_Float > a()) {
      this.jdField_b_of_type_Float %= a();
    }
    invalidate();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setStartingDegree(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setSuffixText(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidate();
  }
  
  public void setUnfinishedStrokeColor(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setUnfinishedStrokeWidth(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.circle.DonutProgress
 * JD-Core Version:    0.7.0.1
 */