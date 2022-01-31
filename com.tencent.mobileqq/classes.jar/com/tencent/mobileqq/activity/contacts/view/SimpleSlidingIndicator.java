package com.tencent.mobileqq.activity.contacts.view;

import afep;
import afhh;
import afhi;
import afhj;
import afhk;
import afhl;
import afhm;
import ajjy;
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
import bajq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

@TargetApi(14)
public class SimpleSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] jdField_b_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int;
  private afep jdField_a_of_type_Afep;
  private afhl jdField_a_of_type_Afhl;
  protected afhm a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new afhk(this);
  public LinearLayout a;
  protected int[] a;
  protected String[] a;
  private int jdField_b_of_type_Int = -16777216;
  private int c = -7829368;
  private int d = 25;
  public int e;
  protected int f;
  protected int g = -16776961;
  public int h;
  private int i = 6;
  private int j = 12;
  private int k = 12;
  private int l = 16;
  private int m = 16;
  private int n = 12;
  private int o = 52;
  private int p;
  private int q;
  private int r;
  
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
    if (this.d > 255) {
      this.d = 255;
    }
    for (;;)
    {
      d();
      a(paramContext);
      if (Build.VERSION.SDK_INT >= 14) {
        setAccessibilityDelegate(new afhh(this));
      }
      return;
      if (this.d < 0) {
        this.d = 0;
      }
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new afhi(this, paramInt));
    paramView.setPadding(this.i, 0, this.i, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 17;
    if (this.p != 0) {
      if (paramInt != 0) {
        break label91;
      }
    }
    label91:
    for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = this.p)
    {
      if (this.q != 0) {
        localLayoutParams.width = this.q;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt, localLayoutParams);
      return;
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setGravity(17);
    localRedDotTextView.setPadding(30, 4, 30, 4);
    localRedDotTextView.setSingleLine();
    paramString = new RedTouch(getContext(), localRedDotTextView).a(53).a();
    paramString.setId(paramInt2);
    a(paramInt1, paramString);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839355);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.r, 0, this.r, 0);
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
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      if (((localView instanceof RedTouch)) && ((((RedTouch)localView).a() instanceof TextView))) {
        ((TextView)((RedTouch)localView).a()).setTextSize(0, this.n);
      }
      i1 += 1;
    }
  }
  
  protected void a()
  {
    if (this.f != this.e)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.f);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new afhj(this));
        ((ValueAnimator)localObject).start();
      }
      return;
    }
    this.h = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e).getLeft();
    invalidate();
  }
  
  public void a(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.a())) {
      localRedTouch.b();
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
  
  public void a(int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = (RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt);
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i1] == paramInt)
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i1] = paramString;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.e != paramInt) && (this.e >= 0))
    {
      this.f = this.e;
      this.e = paramInt;
      b(paramInt);
      c(this.e);
      if (!paramBoolean1) {
        break label69;
      }
      a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Afhm != null) {
        this.jdField_a_of_type_Afhm.a(paramInt, paramBoolean2);
      }
      return;
      label69:
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
      if (localView != null) {
        this.h = localView.getLeft();
      }
      invalidate();
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
  
  public void b(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      TextView localTextView = (TextView)((RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1)).a();
      if (i1 == paramInt) {
        localTextView.setTextColor(this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localTextView.setTextColor(this.c);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label32;
      }
      getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      return;
      label32:
      getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void c(int paramInt)
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
      int i1 = this.i * 3;
      int i2 = localView.getRight() - paramInt + i1 - getWidth();
      if (i2 > 0)
      {
        smoothScrollBy(i2, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i1;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
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
    if ((isInEditMode()) || (this.jdField_a_of_type_Int == 0)) {}
    for (;;)
    {
      return;
      int i1 = getHeight();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.d);
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.e);
      int i2;
      if (localObject != null)
      {
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        float f1 = this.h + this.i - this.k;
        float f2 = this.j;
        i2 = this.h;
        localRectF.set(f1, f2, ((View)localObject).getWidth() + i2 - this.i + this.k, i1 - this.j);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.l, this.m, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i1 = 0;
      while (i1 < this.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i1))
        {
          localObject = (TextView)((RedTouch)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1)).a();
          int i3 = ((TextView)localObject).getRight();
          i2 = ((TextView)localObject).getTop();
          i3 -= this.i;
          int i4 = bajq.a(10.0F);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i3, i2, i3 + i4, i4 + i2);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_Afep != null)
      {
        this.jdField_a_of_type_Afep.b(true);
        continue;
        if (this.jdField_a_of_type_Afep != null) {
          this.jdField_a_of_type_Afep.b(false);
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
      if (this.jdField_a_of_type_Afep != null) {
        this.jdField_a_of_type_Afep.b(false);
      }
    }
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.c)
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_Int)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
        if (localView != null)
        {
          String str2 = this.jdField_a_of_type_ArrayOfJavaLangString[i1] + ajjy.a(2131648375);
          String str1 = str2;
          if (i1 == this.e) {
            str1 = str2 + ajjy.a(2131648376);
          }
          localView.setContentDescription(str1);
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
  
  public void setInterceptListener(afep paramafep)
  {
    this.jdField_a_of_type_Afep = paramafep;
  }
  
  public void setOnTabClickListener(afhl paramafhl)
  {
    this.jdField_a_of_type_Afhl = paramafhl;
  }
  
  public void setOnTabListener(afhm paramafhm)
  {
    this.jdField_a_of_type_Afhm = paramafhm;
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
    this.jdField_a_of_type_ArrayOfInt = ((int[])paramArrayOfInt.clone());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */