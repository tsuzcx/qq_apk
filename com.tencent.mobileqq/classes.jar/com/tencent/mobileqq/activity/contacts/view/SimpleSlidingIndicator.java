package com.tencent.mobileqq.activity.contacts.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.contacts.base.InterceptListener;
import wtw;
import wtx;
import wty;
import wtz;

@TargetApi(14)
public class SimpleSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private InterceptListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener;
  private SimpleSlidingIndicator.onTabListener jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator$onTabListener;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int c;
  private int d = -16777216;
  private int e = -7829368;
  private int f = 18;
  private int g = 12;
  private int h = 52;
  private int i = 4;
  private int j = 1;
  private int k = -16776961;
  private int l = -3355444;
  private int m;
  
  public SimpleSlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.h = ((int)TypedValue.applyDimension(1, this.h, (DisplayMetrics)localObject));
    this.i = ((int)TypedValue.applyDimension(1, this.i, (DisplayMetrics)localObject));
    this.j = ((int)TypedValue.applyDimension(1, this.j, (DisplayMetrics)localObject));
    this.f = ((int)TypedValue.applyDimension(1, this.f, (DisplayMetrics)localObject));
    this.g = ((int)TypedValue.applyDimension(2, this.g, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    this.g = ((TypedArray)localObject).getDimensionPixelSize(0, this.g);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleSlidingIndicator);
    this.k = paramAttributeSet.getColor(0, this.k);
    this.l = paramAttributeSet.getColor(1, this.l);
    this.d = paramAttributeSet.getColor(2, this.d);
    this.e = paramAttributeSet.getColor(3, this.e);
    this.i = paramAttributeSet.getDimensionPixelSize(4, this.i);
    this.j = paramAttributeSet.getDimensionPixelSize(5, this.j);
    this.f = paramAttributeSet.getDimensionPixelSize(6, this.f);
    paramAttributeSet.recycle();
    b();
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new wtw(this));
    }
  }
  
  private void a(int paramInt)
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int n = 0;
    if (n < i1)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(n);
      if (n == paramInt) {
        localTextView.setTextColor(this.d);
      }
      for (;;)
      {
        n += 1;
        break;
        localTextView.setTextColor(this.e);
      }
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new wtx(this, paramInt));
    paramView.setPadding(this.f, 0, this.f, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setGravity(17);
    localTextView.setSingleLine();
    localTextView.setId(paramInt2);
    a(paramInt1, localTextView);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.g);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    do
    {
      View localView;
      do
      {
        return;
        setAccessibilityMsg();
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
      } while (localView == null);
      paramInt = getScrollX();
      int n = this.f * 3;
      int i1 = localView.getRight() - paramInt + n - getWidth();
      if (i1 > 0)
      {
        smoothScrollBy(i1, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - n;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  private void c()
  {
    int n = 0;
    while (n < this.jdField_a_of_type_Int)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(n);
      if ((localView instanceof TextView)) {
        ((TextView)localView).setTextSize(0, this.g);
      }
      n += 1;
    }
  }
  
  private void d()
  {
    if (this.c != this.jdField_b_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.c);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_b_of_type_Int);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new wty(this));
        ((ValueAnimator)localObject).start();
      }
      return;
    }
    this.m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_b_of_type_Int).getLeft();
    invalidate();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int n = 0;
    while (n < this.jdField_a_of_type_Int)
    {
      a(n, this.jdField_a_of_type_ArrayOfJavaLangString[n], this.jdField_b_of_type_ArrayOfInt[n]);
      n += 1;
    }
    c();
    getViewTreeObserver().addOnGlobalLayoutListener(new wtz(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = getResources().getColor(paramInt1);
    this.e = getResources().getColor(paramInt2);
    this.k = getResources().getColor(paramInt3);
    a(this.jdField_b_of_type_Int);
    invalidate();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_b_of_type_Int != paramInt) && (this.jdField_b_of_type_Int >= 0))
    {
      this.c = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
      a(paramInt);
      b(this.jdField_b_of_type_Int);
      if (!paramBoolean1) {
        break label69;
      }
      d();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator$onTabListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator$onTabListener.a(paramInt, paramBoolean2);
      }
      return;
      label69:
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_b_of_type_Int);
      if (localView != null) {
        this.m = localView.getLeft();
      }
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.jdField_a_of_type_Int == 0)) {}
    int n;
    View localView;
    do
    {
      return;
      n = getHeight();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.k);
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_b_of_type_Int);
    } while (localView == null);
    float f1 = this.m + this.f - 10;
    float f2 = n - this.i;
    int i1 = this.m;
    paramCanvas.drawRect(f1, f2, localView.getWidth() + i1 - this.f + 10, n, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener.c(true);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener.c(false);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener.c(false);
      }
    }
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.b)
    {
      int n = 0;
      while (n < this.jdField_a_of_type_Int)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(n);
        if (localView != null)
        {
          String str2 = this.jdField_a_of_type_ArrayOfJavaLangString[n] + " 按钮";
          String str1 = str2;
          if (n == this.jdField_b_of_type_Int) {
            str1 = str2 + "，已选中";
          }
          localView.setContentDescription(str1);
        }
        n += 1;
      }
    }
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void setInterceptListener(InterceptListener paramInterceptListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener = paramInterceptListener;
  }
  
  public void setOnTabListener(SimpleSlidingIndicator.onTabListener paramonTabListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator$onTabListener = paramonTabListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length != paramArrayOfString.length)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
    this.jdField_b_of_type_ArrayOfInt = ((int[])paramArrayOfInt.clone());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */