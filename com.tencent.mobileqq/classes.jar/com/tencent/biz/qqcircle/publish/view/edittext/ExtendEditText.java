package com.tencent.biz.qqcircle.publish.view.edittext;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ExtendEditText
  extends EditText
{
  public static final ExtendEditText.LengthConvertor i = new ExtendEditText.2();
  private static final ExtendEditText.LengthConvertor s = new ExtendEditText.1();
  protected int a = 0;
  int b = -1;
  protected LinearGradient c;
  protected int[] d;
  protected float[] e;
  protected GradientDrawable.Orientation f;
  protected int g = 0;
  protected TextColorAnimation h = null;
  private boolean j = false;
  private ExtendEditText.LimitListener k;
  private ExtendEditText.LengthConvertor l = null;
  private int m = 4;
  private Transformation n = new Transformation();
  private String o;
  private int p;
  private boolean q;
  private int r = 0;
  
  public ExtendEditText(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.at);
    setClearFocusOnBack(paramContext.getBoolean(R.styleable.au, false));
    this.b = paramContext.getInteger(R.styleable.av, -1);
    paramContext.recycle();
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    int i1 = this.b;
    if (i1 >= 0) {
      setFilters(new InputFilter[] { new ExtendEditText.LengthFilter(this, i1) });
    }
  }
  
  private void e()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  private void f()
  {
    if (this.d != null)
    {
      if (this.e == null) {
        return;
      }
      int i1 = getMaxTextWidth();
      if ((this.c != null) && (i1 == this.g)) {
        return;
      }
      this.g = i1;
      Rect localRect = new Rect(0, 0, this.g, getMeasuredHeight());
      switch (ExtendEditText.3.a[this.f.ordinal()])
      {
      default: 
        f1 = localRect.left;
        f2 = localRect.top;
        f3 = localRect.right * 1.0F;
        i1 = localRect.bottom;
      case 7: 
      case 6: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        for (;;)
        {
          f4 = i1 * 1.0F;
          break label376;
          f2 = localRect.left;
          f1 = localRect.top;
          i1 = localRect.right;
          break label291;
          f1 = localRect.left;
          f2 = localRect.bottom;
          f3 = localRect.right * 1.0F;
          i1 = localRect.top;
          continue;
          f1 = localRect.left;
          f2 = localRect.bottom;
          i1 = localRect.top;
          break;
          f1 = localRect.right;
          f2 = localRect.bottom;
          f3 = localRect.left * 1.0F;
          i1 = localRect.top;
          continue;
          f2 = localRect.right;
          f1 = localRect.top;
          i1 = localRect.left;
          label291:
          float f5 = i1 * 1.0F;
          f3 = f2;
          f2 = f1;
          f4 = f2;
          f1 = f3;
          f3 = f5;
          break label376;
          f1 = localRect.right;
          f2 = localRect.top;
          f3 = localRect.left * 1.0F;
          i1 = localRect.bottom;
        }
      }
      float f1 = localRect.left;
      float f2 = localRect.top;
      i1 = localRect.bottom;
      float f4 = i1 * 1.0F;
      float f3 = f1;
      label376:
      this.c = new LinearGradient(f1, f2, f3, f4, this.d, this.e, Shader.TileMode.CLAMP);
    }
  }
  
  private boolean g()
  {
    int i1 = getScrollY();
    int i2 = getLayout().getHeight() - (getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom());
    boolean bool = false;
    if (i2 == 0) {
      return false;
    }
    if ((i1 > 0) || (i1 < i2 - 1)) {
      bool = true;
    }
    return bool;
  }
  
  private int getMaxTextHeight()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return 0;
    }
    int i1 = localLayout.getLineCount();
    if (i1 == 0) {
      return 0;
    }
    return localLayout.getLineBottom(i1 - 1);
  }
  
  private int getMaxTextWidth()
  {
    Layout localLayout = getLayout();
    if (TextUtils.isEmpty(getText()))
    {
      CharSequence localCharSequence = getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (!localCharSequence.equals(this.o))
        {
          this.o = localCharSequence.toString();
          this.p = ((int)getPaint().measureText(localCharSequence.toString()));
        }
        return this.p;
      }
    }
    int i1 = 0;
    if (localLayout == null) {
      return 0;
    }
    int i5 = localLayout.getLineCount();
    int i3;
    for (int i2 = 0; i1 < i5; i2 = i3)
    {
      int i4 = (int)localLayout.getLineRight(i1);
      i3 = i2;
      if (i2 < i4) {
        i3 = i4;
      }
      i1 += 1;
    }
    return i2;
  }
  
  int a(float paramFloat)
  {
    if (getLayout() == null) {
      return 0;
    }
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f1 = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f1));
  }
  
  protected void a()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i1 = getTargetLine();
    int i2 = localLayout.getLineTop(i1);
    int i3 = localLayout.getLineBottom(i1);
    int i5 = getScrollY();
    int i4 = getScrollX();
    i1 = i3;
    if (Math.abs(i5 - i2) <= Math.abs(i3 - i5)) {
      i1 = i2;
    }
    scrollTo(i4, i1);
  }
  
  protected void b()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i1 = localLayout.getLineBottom(getTargetLine());
    scrollTo(getScrollX(), i1);
  }
  
  public boolean bringPointIntoView(int paramInt)
  {
    return false;
  }
  
  protected void c()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i1 = getTargetLine() - 1;
    if (i1 < 0) {
      return;
    }
    i1 = localLayout.getLineTop(i1);
    scrollTo(getScrollX(), i1);
  }
  
  @TargetApi(11)
  int getTargetLine()
  {
    try
    {
      if (getLayout() == null) {
        return 0;
      }
      int i1 = Build.VERSION.SDK_INT;
      if (i1 > 13) {
        try
        {
          i1 = getOffsetForPosition(getX(), getY() - this.r);
          i1 = getLayout().getLineForOffset(i1);
          return i1;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return 0;
        }
      }
      if (i1 > 10) {
        return a(getY());
      }
      i1 = a(getTop());
      return i1;
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTargetLine error");
      localStringBuilder.append(localException2.getMessage());
      QLog.w("ExtendEditText", 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      TextPaint localTextPaint = getPaint();
      if (this.h != null)
      {
        boolean bool = this.h.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.n);
        int i1 = this.h.a();
        setTextColor(i1);
        setHintTextColor(i1);
        if (bool) {
          postInvalidateOnAnimation();
        }
      }
      f();
      if (this.c != null) {
        localTextPaint.setShader(this.c);
      }
      super.onDraw(paramCanvas);
      if (this.c != null)
      {
        localTextPaint.setShader(null);
        return;
      }
    }
    catch (Throwable paramCanvas)
    {
      QLog.e("ExtendEditText", 1, new Object[] { "onDraw error", paramCanvas.getMessage() });
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.j) && (paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      e();
      clearFocus();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    a();
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramInt1 = getLineCount();
    paramInt2 = this.a;
    if (paramInt2 != paramInt1)
    {
      if (paramInt2 < paramInt1)
      {
        if ((!this.q) && (paramInt1 > this.m))
        {
          b();
          return;
        }
        if ((this.q) && (g())) {
          b();
        }
      }
      else
      {
        c();
      }
      return;
    }
    a();
  }
  
  public void postInvalidateOnAnimation()
  {
    super.postInvalidateDelayed(33L);
  }
  
  public void setBeforeChangeLineCount(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setClearFocusOnBack(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setEditDistanceParentHeight(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setGradientColor(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    this.c = null;
    this.d = paramArrayOfInt;
    this.e = paramArrayOfFloat;
    this.f = paramOrientation;
    if (Build.VERSION.SDK_INT >= 11)
    {
      try
      {
        setLayerType(0, null);
      }
      catch (Exception paramArrayOfInt)
      {
        paramArrayOfInt.printStackTrace();
      }
      setDrawingCacheEnabled(false);
    }
  }
  
  public void setLimitListener(ExtendEditText.LimitListener paramLimitListener)
  {
    this.k = paramLimitListener;
  }
  
  public void setMaxLengthConvertor(ExtendEditText.LengthConvertor paramLengthConvertor)
  {
    this.l = paramLengthConvertor;
  }
  
  public void setMaxLineToScrollAlways(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setTextColorAnimation(ArrayList<Integer> paramArrayList, int paramInt)
  {
    TextColorAnimation localTextColorAnimation = this.h;
    if (localTextColorAnimation != null) {
      localTextColorAnimation.cancel();
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 2) && (paramInt != 0))
    {
      this.h = new TextColorAnimation(paramArrayList);
      this.h.setFillAfter(true);
      this.h.setRepeatCount(-1);
      this.h.setRepeatMode(2);
      this.h.setInterpolator(new LinearInterpolator());
      this.h.setDuration(paramInt);
      this.h.setStartTime(0L);
      return;
    }
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText
 * JD-Core Version:    0.7.0.1
 */