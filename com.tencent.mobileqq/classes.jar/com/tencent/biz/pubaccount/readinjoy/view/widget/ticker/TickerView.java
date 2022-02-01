package com.tencent.biz.pubaccount.readinjoy.view.widget.ticker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import tfj;
import tfk;
import tfl;
import tfm;
import tfn;
import tfo;

public class TickerView
  extends View
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
  protected final Paint a;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private String jdField_a_of_type_JavaLangString;
  private final tfj jdField_a_of_type_Tfj = new tfj(this.jdField_a_of_type_Tfk);
  private final tfk jdField_a_of_type_Tfk = new tfk(this.jdField_a_of_type_AndroidGraphicsPaint);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Interpolator jdField_b_of_type_AndroidViewAnimationInterpolator;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  
  public TickerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint(1);
    a(paramContext, null, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint(1);
    a(paramContext, paramAttributeSet, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint(1);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = this.jdField_a_of_type_Tfj.b();; f = this.jdField_a_of_type_Tfj.a()) {
      return (int)f + getPaddingLeft() + getPaddingRight();
    }
  }
  
  private void a()
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_Int != a())
    {
      i = 1;
      if (this.jdField_b_of_type_Int == b()) {
        break label44;
      }
    }
    for (;;)
    {
      if ((i != 0) || (j != 0)) {
        requestLayout();
      }
      return;
      i = 0;
      break;
      label44:
      j = 0;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = this.jdField_a_of_type_Tfj.b();
    float f2 = this.jdField_a_of_type_Tfk.a();
    a(paramCanvas, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect, f1, f2);
  }
  
  static void a(Canvas paramCanvas, int paramInt, Rect paramRect, float paramFloat1, float paramFloat2)
  {
    int i = paramRect.width();
    int j = paramRect.height();
    float f1;
    if ((paramInt & 0x10) == 16) {
      f1 = paramRect.top;
    }
    for (float f2 = (j - paramFloat2) / 2.0F + f1;; f2 = 0.0F)
    {
      if ((paramInt & 0x1) == 1) {}
      for (f1 = paramRect.left + (i - paramFloat1) / 2.0F;; f1 = 0.0F)
      {
        if ((paramInt & 0x30) == 48) {
          f2 = 0.0F;
        }
        if ((paramInt & 0x50) == 80) {
          f2 = paramRect.top + (j - paramFloat2);
        }
        if ((paramInt & 0x800003) == 8388611) {
          f1 = 0.0F;
        }
        if ((paramInt & 0x800005) == 8388613) {
          f1 = paramRect.left + (i - paramFloat1);
        }
        paramCanvas.translate(f1, f2);
        paramCanvas.clipRect(0.0F, 0.0F, paramFloat1, paramFloat2);
        return;
      }
    }
  }
  
  private int b()
  {
    return (int)this.jdField_a_of_type_Tfk.a() + getPaddingTop() + getPaddingBottom();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Tfk.a();
    a();
    invalidate();
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    tfo localtfo = new tfo(this, paramContext.getResources());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TickerView, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(0, -1);
    if (paramInt1 != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt1, R.styleable.TickerView);
      localtfo.a(paramContext);
      paramContext.recycle();
    }
    localtfo.a(paramAttributeSet);
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = jdField_a_of_type_AndroidViewAnimationInterpolator;
    this.jdField_b_of_type_Long = paramAttributeSet.getInt(11, 350);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(10, false);
    this.jdField_c_of_type_Int = localtfo.jdField_a_of_type_Int;
    if (localtfo.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(localtfo.jdField_c_of_type_Float, localtfo.jdField_a_of_type_Float, localtfo.jdField_b_of_type_Float, localtfo.jdField_b_of_type_Int);
    }
    if (localtfo.jdField_d_of_type_Int != 0)
    {
      this.e = localtfo.jdField_d_of_type_Int;
      setTypeface(this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface());
    }
    setTextColor(localtfo.jdField_c_of_type_Int);
    setTextSize(localtfo.jdField_d_of_type_Float);
    switch (paramAttributeSet.getInt(12, 0))
    {
    default: 
      if (isInEditMode()) {
        setCharacterLists(new String[] { tfl.a() });
      }
      break;
    }
    for (;;)
    {
      paramInt1 = paramAttributeSet.getInt(13, 0);
      switch (paramInt1)
      {
      default: 
        throw new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: " + paramInt1);
        setCharacterLists(new String[] { tfl.a() });
        continue;
        setCharacterLists(new String[] { tfl.b() });
      }
    }
    this.jdField_a_of_type_Tfk.a(0);
    if (a()) {
      setText(localtfo.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      paramAttributeSet.recycle();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new tfm(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new tfn(this));
      return;
      this.jdField_a_of_type_Tfk.a(1);
      break;
      this.jdField_a_of_type_Tfk.a(2);
      break;
      this.jdField_b_of_type_JavaLangString = localtfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Tfj.a() != null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_Tfk.b());
    this.jdField_a_of_type_Tfj.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = a();
    this.jdField_b_of_type_Int = b();
    setMeasuredDimension(resolveSize(this.jdField_a_of_type_Int, paramInt1), resolveSize(this.jdField_b_of_type_Int, paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRect.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    this.jdField_a_of_type_Tfj.a(paramVarArgs);
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      setText(this.jdField_b_of_type_JavaLangString, false);
      this.jdField_b_of_type_JavaLangString = null;
    }
  }
  
  public void setCustomCharacterList(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_Tfj.a(paramArrayList);
  }
  
  public void setDigitalAnimWidthSpeedIncrement(boolean paramBoolean)
  {
    this.jdField_a_of_type_Tfj.a(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setIgnoreWidthAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Tfj.b(paramBoolean);
  }
  
  public void setPreferredScrollingDirection(int paramInt)
  {
    this.jdField_a_of_type_Tfk.a(paramInt);
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      setText(paramString, bool);
      return;
    }
  }
  
  public void setText(String paramString, boolean paramBoolean)
  {
    if (TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramString == null) {}
    for (char[] arrayOfChar = new char[0];; arrayOfChar = paramString.toCharArray())
    {
      this.jdField_a_of_type_Tfj.a(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    this.jdField_a_of_type_Tfj.a(1.0F);
    this.jdField_a_of_type_Tfj.a();
    a();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.jdField_d_of_type_Int != paramInt)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
      invalidate();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
      b();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Typeface localTypeface;
    if (this.e == 3) {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(localTypeface);
      b();
      return;
      if (this.e == 1)
      {
        localTypeface = Typeface.create(paramTypeface, 1);
      }
      else
      {
        localTypeface = paramTypeface;
        if (this.e == 2) {
          localTypeface = Typeface.create(paramTypeface, 2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */