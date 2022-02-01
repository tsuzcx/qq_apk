package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
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
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ExtendEditText
  extends EditText
{
  public static final ExtendEditText.LengthConvertor a;
  private static final ExtendEditText.LengthConvertor c;
  protected int a;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList = null;
  protected LinearGradient a;
  protected GradientDrawable.Orientation a;
  private Transformation jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
  private ExtendEditText.LimitListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LimitListener;
  protected TextColorAnimation a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  protected float[] a;
  protected int[] a;
  int jdField_b_of_type_Int = -1;
  private ExtendEditText.LengthConvertor jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = null;
  protected int c;
  private int d = 4;
  private int e;
  
  static
  {
    jdField_c_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = new ExtendEditText.1();
    jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = new ExtendEditText.2();
  }
  
  public ExtendEditText(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = null;
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = null;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EditText);
    setClearFocusOnBack(paramContext.getBoolean(0, false));
    this.jdField_b_of_type_Int = paramContext.getInteger(1, -1);
    paramContext.recycle();
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = null;
    d();
  }
  
  private void a(ExtendEditText.SuperFontInfo paramSuperFontInfo)
  {
    int j = 0;
    if (paramSuperFontInfo == null)
    {
      paramSuperFontInfo = this.jdField_a_of_type_AndroidContentResColorStateList;
      if (paramSuperFontInfo != null)
      {
        setTextColor(paramSuperFontInfo);
        setHintTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      }
      setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      setTextColorAnimation(null, 0);
      setGradientColor(null, null, null);
      return;
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = getTextColors();
    }
    int i;
    if ((paramSuperFontInfo.jdField_a_of_type_Long & 1L) != 0L)
    {
      i = ExtendEditText.SuperFontInfo.a(paramSuperFontInfo.jdField_e_of_type_JavaLangString);
      setTextColor(i);
      setHintTextColor(i);
    }
    else
    {
      setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      setHintTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    }
    if ((paramSuperFontInfo.jdField_a_of_type_Long & 0x2) != 0L) {
      setShadowLayer(AIOUtils.b(paramSuperFontInfo.jdField_e_of_type_Int, getResources()), AIOUtils.b(paramSuperFontInfo.jdField_c_of_type_Int, getResources()), AIOUtils.b(paramSuperFontInfo.d, getResources()), ExtendEditText.SuperFontInfo.a(paramSuperFontInfo.jdField_f_of_type_JavaLangString));
    } else {
      setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    Object localObject;
    int k;
    if (((paramSuperFontInfo.jdField_a_of_type_Long & 0x8) != 0L) && (paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList != null) && (paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.size() >= 2))
    {
      localObject = new ArrayList(paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.size());
      k = paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.size();
      i = 0;
      while (i < k)
      {
        ((ArrayList)localObject).add(Integer.valueOf(ExtendEditText.SuperFontInfo.a((String)paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.get(i))));
        i += 1;
      }
      setTextColorAnimation((ArrayList)localObject, paramSuperFontInfo.g * (k - 1));
    }
    else
    {
      setTextColorAnimation(null, 0);
    }
    if (((paramSuperFontInfo.jdField_a_of_type_Long & 0x4) != 0L) && (paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList.size() >= 2) && (paramSuperFontInfo.b != null) && (paramSuperFontInfo.b.size() >= 2))
    {
      k = paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList.size();
      localObject = new int[k];
      i = 0;
      while (i < k)
      {
        localObject[i] = ExtendEditText.SuperFontInfo.a((String)paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      k = paramSuperFontInfo.b.size();
      float[] arrayOfFloat = new float[k];
      i = j;
      while (i < k)
      {
        arrayOfFloat[i] = ((Double)paramSuperFontInfo.b.get(i)).floatValue();
        i += 1;
      }
      GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
      i = paramSuperFontInfo.jdField_f_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramSuperFontInfo = GradientDrawable.Orientation.LEFT_RIGHT;
            } else {
              paramSuperFontInfo = GradientDrawable.Orientation.BL_TR;
            }
          }
          else {
            paramSuperFontInfo = GradientDrawable.Orientation.TL_BR;
          }
        }
        else {
          paramSuperFontInfo = GradientDrawable.Orientation.TOP_BOTTOM;
        }
      }
      else {
        paramSuperFontInfo = GradientDrawable.Orientation.LEFT_RIGHT;
      }
      setGradientColor((int[])localObject, arrayOfFloat, paramSuperFontInfo);
      return;
    }
    setGradientColor(null, null, null);
  }
  
  private int b()
  {
    Layout localLayout = getLayout();
    if (TextUtils.isEmpty(getText()))
    {
      CharSequence localCharSequence = getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (!localCharSequence.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaLangString = localCharSequence.toString();
          this.jdField_e_of_type_Int = ((int)getPaint().measureText(localCharSequence.toString()));
        }
        return this.jdField_e_of_type_Int;
      }
    }
    int i = 0;
    if (localLayout == null) {
      return 0;
    }
    int n = localLayout.getLineCount();
    int k;
    for (int j = 0; i < n; j = k)
    {
      int m = (int)localLayout.getLineRight(i);
      k = j;
      if (j < m) {
        k = m;
      }
      i += 1;
    }
    return j;
  }
  
  private void d()
  {
    int i = this.jdField_b_of_type_Int;
    if (i >= 0) {
      setFilters(new InputFilter[] { new ExtendEditText.LengthFilter(this, i) });
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      if (this.jdField_a_of_type_ArrayOfFloat == null) {
        return;
      }
      int i = b();
      if ((this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) && (i == this.jdField_c_of_type_Int)) {
        return;
      }
      this.jdField_c_of_type_Int = i;
      Rect localRect = new Rect(0, 0, this.jdField_c_of_type_Int, getMeasuredHeight());
      switch (ExtendEditText.3.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation.ordinal()])
      {
      default: 
        f1 = localRect.left;
        f2 = localRect.top;
        f3 = localRect.right * 1.0F;
        i = localRect.bottom;
      case 7: 
      case 6: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        for (;;)
        {
          f4 = i * 1.0F;
          break label376;
          f2 = localRect.left;
          f1 = localRect.top;
          i = localRect.right;
          break label291;
          f1 = localRect.left;
          f2 = localRect.bottom;
          f3 = localRect.right * 1.0F;
          i = localRect.top;
          continue;
          f1 = localRect.left;
          f2 = localRect.bottom;
          i = localRect.top;
          break;
          f1 = localRect.right;
          f2 = localRect.bottom;
          f3 = localRect.left * 1.0F;
          i = localRect.top;
          continue;
          f2 = localRect.right;
          f1 = localRect.top;
          i = localRect.left;
          label291:
          float f5 = i * 1.0F;
          f3 = f2;
          f2 = f1;
          f4 = f2;
          f1 = f3;
          f3 = f5;
          break label376;
          f1 = localRect.right;
          f2 = localRect.top;
          f3 = localRect.left * 1.0F;
          i = localRect.bottom;
        }
      }
      float f1 = localRect.left;
      float f2 = localRect.top;
      i = localRect.bottom;
      float f4 = i * 1.0F;
      float f3 = f1;
      label376:
      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
    }
  }
  
  private void f()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  @TargetApi(14)
  int a()
  {
    try
    {
      if (getLayout() == null) {
        return 0;
      }
      int i = Build.VERSION.SDK_INT;
      if (i > 13)
      {
        try
        {
          i = getOffsetForPosition(getX(), getY());
          i = getLayout().getLineForOffset(i);
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            break label114;
          }
        }
        QLog.w("ExtendEditText", 2, "", localException1);
        return 0;
      }
      else if (i > 10)
      {
        i = a(getY());
      }
      else
      {
        i = a(getTop());
      }
      return i;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ExtendEditText", 2, "", localException2);
      }
      return 0;
    }
    label114:
    return 0;
  }
  
  int a(float paramFloat)
  {
    if (getLayout() == null) {
      return 0;
    }
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  protected void a()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i = a();
    int j = localLayout.getLineTop(i);
    int k = localLayout.getLineBottom(i);
    int n = getScrollY();
    int m = getScrollX();
    i = k;
    if (Math.abs(n - j) <= Math.abs(k - n)) {
      i = j;
    }
    scrollTo(m, i);
  }
  
  protected void b()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i = localLayout.getLineBottom(a());
    scrollTo(getScrollX(), i);
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
    int i = a() - 1;
    if (i < 0) {
      return;
    }
    i = localLayout.getLineTop(i);
    scrollTo(getScrollX(), i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation;
    if (localObject != null)
    {
      boolean bool = ((TextColorAnimation)localObject).getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.a();
      setTextColor(i);
      setHintTextColor(i);
      if (bool) {
        postInvalidateOnAnimation();
      }
    }
    e();
    localObject = this.jdField_a_of_type_AndroidGraphicsLinearGradient;
    if (localObject != null) {
      localTextPaint.setShader((Shader)localObject);
    }
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) {
      localTextPaint.setShader(null);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      f();
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
    paramInt2 = this.jdField_a_of_type_Int;
    if (paramInt2 != paramInt1)
    {
      if (paramInt2 < paramInt1)
      {
        if (paramInt1 > this.d) {
          b();
        }
      }
      else {
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
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setClearFocusOnBack(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setGradientColor(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = null;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation = paramOrientation;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LimitListener = paramLimitListener;
  }
  
  public void setMaxLengthConvertor(ExtendEditText.LengthConvertor paramLengthConvertor)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = paramLengthConvertor;
  }
  
  public void setTextColorAnimation(ArrayList<Integer> paramArrayList, int paramInt)
  {
    TextColorAnimation localTextColorAnimation = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation;
    if (localTextColorAnimation != null) {
      localTextColorAnimation.cancel();
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 2) && (paramInt != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = new TextColorAnimation(paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setRepeatCount(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setRepeatMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setDuration(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setStartTime(0L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = null;
  }
  
  public void setTextEffect(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a(null);
      return;
    }
    a(ExtendEditText.SuperFontInfo.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText
 * JD-Core Version:    0.7.0.1
 */