package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.theme.ISkinTypeface;

public class SimpleTextView
  extends View
  implements ISkinTypeface
{
  private CharSequence a = "";
  private final TextPaint b;
  private ColorStateList c;
  private int d;
  private int e = -16777216;
  private Paint.FontMetrics f;
  private int g = -1;
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.b = new TextPaint(1);
    this.b.density = ((Resources)localObject).getDisplayMetrics().density;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.dP);
      paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.dQ, (int)DisplayUtils.a(paramContext, 12.0F));
      localObject = paramAttributeSet.getColorStateList(R.styleable.dR);
      paramContext = paramAttributeSet.getString(R.styleable.dS);
      this.b.setTextSize(paramInt);
      this.f = this.b.getFontMetrics();
      this.c = ((ColorStateList)localObject);
      localObject = getDrawableState();
      this.d = this.c.getColorForState((int[])localObject, this.e);
      this.b.setColor(this.d);
      this.b.setTypeface(Typeface.SANS_SERIF);
      setText(paramContext);
      paramAttributeSet.recycle();
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      return paramInt1;
    }
    if (i == -2147483648) {
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  private void a()
  {
    int[] arrayOfInt = getDrawableState();
    int i = this.c.getColorForState(arrayOfInt, this.e);
    if (i != this.d)
    {
      this.d = i;
      this.b.setColor(this.d);
      invalidate();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ColorStateList localColorStateList = this.c;
    if ((localColorStateList != null) && (localColorStateList.isStateful())) {
      a();
    }
  }
  
  public Paint getPaint()
  {
    return this.b;
  }
  
  public CharSequence getText()
  {
    return this.a;
  }
  
  public Paint getTextPaint()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredHeight();
    float f2 = this.f.bottom;
    float f3 = this.f.top;
    float f1 = i;
    f2 = (f1 - (f2 - f3)) / 2.0F;
    f3 = this.f.bottom;
    CharSequence localCharSequence = this.a;
    paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), getPaddingLeft(), f1 - f2 - f3, this.b);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.g;
    if (i == -1)
    {
      TextPaint localTextPaint = this.b;
      CharSequence localCharSequence = this.a;
      i = (int)localTextPaint.measureText(localCharSequence, 0, localCharSequence.length());
    }
    setMeasuredDimension(a(paramInt1, i), a(paramInt2, Math.max((int)(this.f.top - this.f.bottom), getSuggestedMinimumWidth())));
  }
  
  public void setDefaultTextColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setFixedWidth(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject != this.a)
    {
      this.a = ((CharSequence)localObject);
      requestLayout();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.c = ColorStateList.valueOf(paramInt);
    a();
    invalidate();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.c = paramColorStateList;
    a();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
    this.b.setTextSize(paramFloat);
    this.f = this.b.getFontMetrics();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */