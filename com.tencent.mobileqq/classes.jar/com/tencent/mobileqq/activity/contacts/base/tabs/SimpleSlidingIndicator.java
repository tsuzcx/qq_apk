package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class SimpleSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] jdField_b_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new SimpleSlidingIndicator.4(this);
  protected LinearLayout a;
  private InterceptListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsInterceptListener;
  private SimpleSlidingIndicator.OnCurrentTabClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnCurrentTabClickListener;
  protected SimpleSlidingIndicator.OnTabListener a;
  protected int[] a;
  protected String[] a;
  private int jdField_b_of_type_Int = -16777216;
  private int c = -7829368;
  private int d = 25;
  protected int e = 0;
  protected int f = 0;
  protected int g = -16776961;
  protected int h;
  private int i = 6;
  private int j = 12;
  private int k = 12;
  private int l = 16;
  private int m = 16;
  private int n = 12;
  private int o = 52;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  
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
    this.o = ((int)TypedValue.applyDimension(1, this.o, (DisplayMetrics)localObject));
    this.j = ((int)TypedValue.applyDimension(1, this.j, (DisplayMetrics)localObject));
    this.k = ((int)TypedValue.applyDimension(1, this.k, (DisplayMetrics)localObject));
    this.l = ((int)TypedValue.applyDimension(1, this.l, (DisplayMetrics)localObject));
    this.m = ((int)TypedValue.applyDimension(1, this.m, (DisplayMetrics)localObject));
    this.i = ((int)TypedValue.applyDimension(1, this.i, (DisplayMetrics)localObject));
    this.n = ((int)TypedValue.applyDimension(2, this.n, (DisplayMetrics)localObject));
    this.p = ((int)TypedValue.applyDimension(1, this.p, (DisplayMetrics)localObject));
    this.q = ((int)TypedValue.applyDimension(1, this.q, (DisplayMetrics)localObject));
    this.r = ((int)TypedValue.applyDimension(1, this.r, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_b_of_type_ArrayOfInt);
    this.n = ((TypedArray)localObject).getDimensionPixelSize(0, this.n);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleSlidingIndicator);
    this.g = paramAttributeSet.getColor(2, this.g);
    this.d = paramAttributeSet.getInt(1, this.d);
    this.jdField_b_of_type_Int = paramAttributeSet.getColor(0, this.jdField_b_of_type_Int);
    this.c = paramAttributeSet.getColor(11, this.c);
    this.l = paramAttributeSet.getDimensionPixelSize(5, this.l);
    this.m = paramAttributeSet.getDimensionPixelSize(6, this.m);
    this.j = paramAttributeSet.getDimensionPixelSize(4, this.j);
    this.k = paramAttributeSet.getDimensionPixelSize(3, this.k);
    this.i = paramAttributeSet.getDimensionPixelSize(9, this.i);
    this.p = paramAttributeSet.getDimensionPixelSize(8, this.p);
    this.q = paramAttributeSet.getDimensionPixelSize(10, this.q);
    this.r = paramAttributeSet.getDimensionPixelSize(7, this.r);
    paramAttributeSet.recycle();
    paramInt = this.d;
    if (paramInt > 255) {
      this.d = 255;
    } else if (paramInt < 0) {
      this.d = 0;
    }
    d();
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new SimpleSlidingIndicator.1(this));
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new SimpleSlidingIndicator.2(this, paramInt));
    int i1 = this.i;
    paramView.setPadding(i1, 0, i1, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 17;
    i1 = this.p;
    if (i1 != 0) {
      if (paramInt == 0) {
        localLayoutParams.leftMargin = 0;
      } else {
        localLayoutParams.leftMargin = i1;
      }
    }
    i1 = this.q;
    if (i1 != 0) {
      localLayoutParams.width = i1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt, localLayoutParams);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setGravity(17);
    localRedDotTextView.setPadding(30, 4, 30, 4);
    localRedDotTextView.setSingleLine();
    paramString = new RedTouch(getContext(), localRedDotTextView).b(53).a();
    paramString.setId(paramInt2);
    a(paramInt1, paramString);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839659);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int i1 = this.r;
    paramContext.setPadding(i1, 0, i1, 0);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.n);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  private void e()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      if ((localObject instanceof RedTouch))
      {
        localObject = (RedTouch)localObject;
        if ((((RedTouch)localObject).a() instanceof TextView)) {
          ((TextView)((RedTouch)localObject).a()).setTextSize(0, this.n);
        }
      }
      i1 += 1;
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  protected void a()
  {
    int i1 = this.f;
    int i2 = this.e;
    if (i1 != i2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new SimpleSlidingIndicator.3(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.h = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  public void a(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.c())) {
      localRedTouch.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = getResources().getColor(paramInt1);
    this.c = getResources().getColor(paramInt2);
    this.g = getResources().getColor(paramInt3);
    b(this.e);
    invalidate();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.q = paramInt1;
    this.p = paramInt2;
    this.i = paramInt3;
    this.r = paramInt4;
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setPadding(paramInt4, 0, paramInt4, 0);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
        if ((localObject != null) && (localObject.length > 0)) {
          b();
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update, tabWidth[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], gap[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], plr[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], cplr[");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("], pos[");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("SimpleSlidingIndicator", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt);
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfInt != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i1 = 0;
      for (;;)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (i1 >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[i1] == paramInt)
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i1] = paramString;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.e;
    if ((i1 != paramInt) && (i1 >= 0))
    {
      this.f = i1;
      this.e = paramInt;
      b(paramInt);
      c(this.e);
      if (paramBoolean1)
      {
        a();
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
        if (localObject != null) {
          this.h = ((View)localObject).getLeft();
        }
        invalidate();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnTabListener;
      if (localObject != null) {
        ((SimpleSlidingIndicator.OnTabListener)localObject).a(paramInt, paramBoolean2);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Int)
    {
      a(i1, this.jdField_a_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfInt[i1]);
      i1 += 1;
    }
    e();
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  protected void b(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      TextView localTextView = (TextView)((RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1)).a();
      if (i1 == paramInt) {
        localTextView.setTextColor(this.jdField_b_of_type_Int);
      } else {
        localTextView.setTextColor(this.c);
      }
      i1 += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      } else {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    }
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    setAccessibilityMsg();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.i * 3;
      int i2 = localView.getRight() - paramInt + i1 - getWidth();
      if (i2 > 0)
      {
        smoothScrollBy(i2, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i1;
      if (paramInt < 0) {
        smoothScrollBy(paramInt, 0);
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (paramInt > 255)
    {
      this.d = 255;
      return;
    }
    if (paramInt < 0)
    {
      this.d = 0;
      return;
    }
    this.d = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    invalidate();
  }
  
  public void f(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(paramInt);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!isInEditMode())
    {
      if (this.jdField_a_of_type_Int == 0) {
        return;
      }
      int i1 = getHeight();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.d);
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
      Object localObject2;
      int i2;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsRectF;
        i2 = this.h;
        ((RectF)localObject2).set(this.i + i2 - this.k, this.j, i2 + ((View)localObject1).getWidth() - this.i + this.k, i1 - this.j);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.l, this.m, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i1 = 0;
      while (i1 < this.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i1))
        {
          localObject1 = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
          localObject2 = (TextView)((RedTouch)localObject1).a();
          int i3 = ((RedTouch)localObject1).getRight();
          int i4 = ((TextView)localObject2).getPaddingRight();
          i2 = ((TextView)localObject2).getTop();
          i3 = i3 - i4 - this.i;
          i4 = ViewUtils.a(10.0F);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i3, i2, i3 + i4, i4 + i2);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    InterceptListener localInterceptListener;
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3))
      {
        localInterceptListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsInterceptListener;
        if (localInterceptListener != null) {
          localInterceptListener.b(false);
        }
      }
    }
    else
    {
      localInterceptListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsInterceptListener;
      if (localInterceptListener != null) {
        localInterceptListener.b(true);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 1) || (i1 == 3))
    {
      InterceptListener localInterceptListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsInterceptListener;
      if (localInterceptListener != null) {
        localInterceptListener.b(false);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.d)
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_Int)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
        if (localView != null)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfJavaLangString[i1]);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131714039));
          String str = ((StringBuilder)localObject).toString();
          localObject = str;
          if (i1 == this.e)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131714040));
            localObject = ((StringBuilder)localObject).toString();
          }
          localView.setContentDescription((CharSequence)localObject);
        }
        i1 += 1;
      }
    }
  }
  
  public void setCheckedTextColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setInterceptListener(InterceptListener paramInterceptListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsInterceptListener = paramInterceptListener;
  }
  
  public void setOnTabClickListener(SimpleSlidingIndicator.OnCurrentTabClickListener paramOnCurrentTabClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnCurrentTabClickListener = paramOnCurrentTabClickListener;
  }
  
  public void setOnTabListener(SimpleSlidingIndicator.OnTabListener paramOnTabListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnTabListener = paramOnTabListener;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0) && (paramArrayOfInt != null))
    {
      if (paramArrayOfInt.length != paramArrayOfString.length) {
        return;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramArrayOfString.clone());
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramArrayOfInt.clone());
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */