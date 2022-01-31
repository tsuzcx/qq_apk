package com.tencent.mobileqq.activity.contacts.view.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.contacts.adapter.HeadCardAdapter;
import com.tencent.mobileqq.activity.contacts.base.InterceptListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wlk;

@TargetApi(14)
public class SlideCardView
  extends LinearLayout
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new wlk();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private HeadCardAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter;
  private InterceptListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener;
  private SlideCardView.CardsSlideListener jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView$CardsSlideListener;
  private TargetDrawable jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private TargetDrawable jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int k = -1;
  private int l;
  private int m;
  private final int n = 300;
  private int o = -1;
  private int p;
  private int q;
  
  public SlideCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlideCardView);
    this.jdField_f_of_type_Int = ((int)paramAttributeSet.getDimension(0, this.jdField_f_of_type_Int));
    this.jdField_g_of_type_Int = paramAttributeSet.getInt(1, this.jdField_g_of_type_Int);
    this.jdField_a_of_type_Float = paramAttributeSet.getFloat(2, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(3);
    paramAttributeSet.recycle();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_i_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_b_of_type_Float = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
    this.jdField_c_of_type_Float = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable = new TargetDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable = new TargetDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_d_of_type_Float = Math.round(getResources().getDimension(2131558465));
    this.p = Math.round(getResources().getDimension(2131558467));
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#F74C31"));
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.q);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f1 <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (i2)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (i1 < paramInt1)
      {
        paramInt2 = i1 | 0x1000000;
        continue;
        paramInt2 = i1;
      }
    }
  }
  
  private View a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      return (View)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return null;
  }
  
  private void a()
  {
    if (!this.jdField_j_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = true;
      MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
      a(MotionEvent.obtain(localMotionEvent.getDownTime(), localMotionEvent.getEventTime() + ViewConfiguration.getLongPressTimeout(), 3, localMotionEvent.getX(), localMotionEvent.getY(), localMotionEvent.getMetaState()));
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_d_of_type_Boolean = true;
    View localView = a();
    if ((localView != null) && (a()) && (this.jdField_g_of_type_Boolean)) {
      a(localView, paramFloat1, paramFloat2);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = a();
    if (localView != null)
    {
      localView.offsetLeftAndRight(paramInt1);
      localView.offsetTopAndBottom(paramInt2);
      a(localView);
      b(localView);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void a(View paramView)
  {
    int i1 = paramView.getLeft();
    int i2 = Math.abs(paramView.getTop() - this.jdField_b_of_type_Int);
    float f3 = (Math.abs(i1 - this.jdField_a_of_type_Int) + i2) / (paramView.getWidth() / 2.0F);
    i1 = 1;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f2 = f3 - 0.2F * i1;
      float f1;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      for (;;)
      {
        a(paramView, f1, i1);
        i1 += 1;
        break;
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
      }
    }
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int i2 = this.jdField_a_of_type_Int;
    int i3 = this.jdField_b_of_type_Int;
    int i4 = paramView.getLeft() - this.jdField_a_of_type_Int;
    int i5 = paramView.getTop() - this.jdField_b_of_type_Int;
    int i1 = i4;
    if (i4 == 0) {
      i1 = 1;
    }
    boolean bool;
    if ((i1 > 300) || ((paramFloat1 > 900.0F) && (i1 > 0)))
    {
      i2 = this.jdField_c_of_type_Int;
      i1 = (this.jdField_e_of_type_Int + this.jdField_a_of_type_Int) * i5 / i1 + this.jdField_b_of_type_Int;
      bool = true;
    }
    for (;;)
    {
      if (i1 > this.jdField_d_of_type_Int) {
        i1 = this.jdField_d_of_type_Int;
      }
      label136:
      label309:
      for (;;)
      {
        label113:
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
        {
          i3 = 1;
          if (i3 < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (i3 == 1) {
              if (!bool) {
                a((View)this.jdField_a_of_type_JavaUtilList.get(i3), true);
              }
            }
            for (;;)
            {
              i3 += 1;
              break label136;
              if ((i1 >= -300) && ((paramFloat1 >= -900.0F) || (i1 >= 0))) {
                break label312;
              }
              i2 = -this.jdField_e_of_type_Int;
              i1 = (this.jdField_e_of_type_Int + this.jdField_a_of_type_Int) * i5 / -i1 + i5 + this.jdField_b_of_type_Int;
              bool = true;
              break;
              if (i1 >= -this.jdField_d_of_type_Int / 2) {
                break label309;
              }
              i1 = -this.jdField_d_of_type_Int / 2;
              break label113;
              a((View)this.jdField_a_of_type_JavaUtilList.get(i3), true);
            }
          }
        }
        a(i2, i1, 300, bool);
        return;
      }
      label312:
      i1 = i3;
      bool = false;
    }
  }
  
  private void a(View paramView, float paramFloat, int paramInt)
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramView);
    int i2 = this.jdField_f_of_type_Int * paramInt;
    float f1 = 1.0F - this.jdField_a_of_type_Float * paramInt;
    float f2 = (100 - this.jdField_g_of_type_Int * paramInt) * 1.0F / 100.0F;
    int i3 = this.jdField_f_of_type_Int;
    f2 = this.jdField_a_of_type_Float;
    float f3 = paramInt - 1;
    float f4 = (100 - this.jdField_g_of_type_Int * (paramInt - 1)) * 1.0F / 100.0F;
    f4 = i2;
    i2 = (int)((i3 * (paramInt - 1) - i2) * paramFloat + f4);
    f1 += (1.0F - f2 * f3 - f1) * paramFloat;
    paramView = (View)this.jdField_a_of_type_JavaUtilList.get(i1 + paramInt);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    paramView.offsetTopAndBottom(i2 - paramView.getTop() + this.jdField_b_of_type_Int);
    View localView;
    if ((paramInt == 1) && ((paramView instanceof ViewGroup)))
    {
      localView = ((ViewGroup)paramView).findViewById(2131363823);
      if (!this.jdField_i_of_type_Boolean) {
        break label219;
      }
      localView.setAlpha(1.0F);
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.setAlpha(paramFloat);
      }
      return;
      label219:
      paramView = localView;
    }
  }
  
  @TargetApi(17)
  private void a(View paramView, int paramInt)
  {
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i3 = paramView.getMeasuredWidth();
    int i4 = paramView.getMeasuredHeight();
    int i1 = ((LinearLayout.LayoutParams)localObject).gravity;
    int i2 = i1;
    if (i1 == -1) {
      i2 = 8388659;
    }
    switch (Gravity.getAbsoluteGravity(i2, getLayoutDirection()) & 0x7)
    {
    default: 
      i1 = getPaddingLeft() + ((LinearLayout.LayoutParams)localObject).leftMargin;
      switch (i2 & 0x70)
      {
      default: 
        i2 = getPaddingTop();
        i2 = ((LinearLayout.LayoutParams)localObject).topMargin + i2;
        label140:
        paramView.layout(i1, i2, i1 + i3, i2 + i4);
        i1 = this.jdField_f_of_type_Int;
        float f1 = 1.0F - this.jdField_a_of_type_Float * paramInt;
        float f2 = (100 - this.jdField_g_of_type_Int * paramInt) * 1.0F / 100.0F;
        paramView.offsetTopAndBottom(i1 * paramInt);
        paramView.setScaleX(f1);
        paramView.setScaleY(f1);
        paramView.setAlpha(f2);
        b(paramView, paramInt);
        f1 = getResources().getDisplayMetrics().density;
        i1 = Math.abs(this.jdField_f_of_type_Int);
        f2 = this.jdField_a_of_type_Float;
        localObject = new Rect(0, i4 - (int)(i1 * (1.0F - f2 * 3.0F) - f1 * 1.0F), i3, i4);
        if ((paramView instanceof CardChildView))
        {
          ((CardChildView)paramView).setClipRectArea((Rect)localObject);
          if (paramInt <= 0) {
            break label433;
          }
          ((CardChildView)paramView).setClipRecet(true);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramView.invalidate();
      return;
      i1 = (getWidth() + getPaddingLeft() - getPaddingRight() - i3) / 2 + ((LinearLayout.LayoutParams)localObject).leftMargin - ((LinearLayout.LayoutParams)localObject).rightMargin;
      break;
      i1 = getWidth() + getPaddingRight() - i3 - ((LinearLayout.LayoutParams)localObject).rightMargin;
      break;
      i2 = (getHeight() + getPaddingTop() - getPaddingBottom() - i4) / 2 + ((LinearLayout.LayoutParams)localObject).topMargin - ((LinearLayout.LayoutParams)localObject).bottomMargin;
      break label140;
      i2 = getHeight() - getPaddingBottom() - i4 - ((LinearLayout.LayoutParams)localObject).bottomMargin;
      break label140;
      label433:
      ((CardChildView)paramView).setClipRecet(false);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof CardChildView))
    {
      ((CardChildView)paramView).setClipRecet(paramBoolean);
      paramView.invalidate();
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a())
    {
      boolean bool1 = bool2;
      if (i1 > 0) {
        if (this.jdField_f_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.jdField_h_of_type_Int == i1 - 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {
      return;
    }
    c(paramInt);
  }
  
  private void b(View paramView)
  {
    float f1 = 1.0F;
    float f3 = 0.0F;
    int i1 = paramView.getLeft() - this.jdField_a_of_type_Int;
    float f2 = i1 / 300.0F;
    if (f2 >= 1.0F) {
      f2 = 1.0F;
    }
    for (;;)
    {
      f2 = Math.abs(f2);
      f3 = Math.abs(f3);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.a(f2);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.b(f2);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.a(f3);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.b(f3);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.d(this.jdField_f_of_type_Float + i1);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.d(this.jdField_e_of_type_Float + i1);
      f2 = Math.abs(f1);
      i1 = (int)(Math.abs(f1) * 255.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.c(f2);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.c(f2);
      this.q = ((int)(this.jdField_d_of_type_Float * f2));
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.q);
      invalidate();
      return;
      if ((f2 >= 0.0F) && (f2 < 1.0F))
      {
        f1 = f2;
      }
      else if ((f2 <= 0.0F) && (f2 > -1.0F))
      {
        f1 = f2;
        float f4 = 0.0F;
        f3 = f2;
        f2 = f4;
      }
      else if (f2 <= -1.0F)
      {
        f1 = -1.0F;
        f2 = 0.0F;
        f3 = -1.0F;
      }
      else
      {
        f1 = 0.0F;
        f2 = 0.0F;
      }
    }
  }
  
  private void b(View paramView, int paramInt)
  {
    View localView;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      localView = paramView.findViewById(2131363823);
      paramView.setAlpha(1.0F);
      if (localView != null)
      {
        if (paramInt <= 0) {
          break label39;
        }
        localView.setAlpha(0.0F);
      }
    }
    return;
    label39:
    localView.setAlpha(1.0F);
  }
  
  private boolean b()
  {
    return (!this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) && (!this.jdField_c_of_type_Boolean);
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    View localView = a();
    boolean bool1 = bool2;
    if (localView != null)
    {
      bool1 = bool2;
      if (localView.getVisibility() == 0)
      {
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        bool1 = bool2;
        if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    if (b())
    {
      d();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
      {
        int i1 = 1;
        while (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          b((View)this.jdField_a_of_type_JavaUtilList.get(i1), i1);
          i1 += 1;
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter == null) {
      return;
    }
    this.jdField_h_of_type_Int = paramInt;
    removeAllViewsInLayout();
    this.jdField_b_of_type_JavaUtilList.clear();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((Iterator)localObject).next();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(localView);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a();
    int i2;
    if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int < i1))
    {
      i2 = Math.min(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.b(), i1);
      paramInt = this.jdField_h_of_type_Int;
    }
    for (;;)
    {
      if ((paramInt < this.jdField_h_of_type_Int + i2) && (paramInt < i1))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(this, paramInt);
        if (localObject != null) {}
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView$CardsSlideListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView$CardsSlideListener.a(this.jdField_h_of_type_Int);
        return;
      }
      addView((View)localObject, 0);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      paramInt += 1;
    }
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    View localView = a();
    boolean bool1 = bool2;
    if (localView != null)
    {
      bool1 = bool2;
      if (localView.getVisibility() == 0)
      {
        localView = localView.findViewById(2131363830);
        bool1 = bool2;
        if (localView != null)
        {
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          bool1 = bool2;
          if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    View localView;
    if (this.jdField_b_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        b(this.o);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        localView = a();
        if ((localView != null) && ((localView.getLeft() != this.jdField_a_of_type_Int) || (localView.getTop() != this.jdField_b_of_type_Int)))
        {
          localView.offsetLeftAndRight(this.jdField_a_of_type_Int - localView.getLeft());
          localView.offsetTopAndBottom(this.jdField_b_of_type_Int - localView.getTop());
        }
      }
    }
    for (;;)
    {
      this.o = -1;
      return;
      localView = (View)this.jdField_b_of_type_JavaUtilList.get(0);
      if (localView.getLeft() == this.jdField_a_of_type_Int)
      {
        this.jdField_b_of_type_JavaUtilList.remove(0);
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_JavaUtilList.remove(0);
      removeViewInLayout(localView);
      this.jdField_a_of_type_JavaUtilList.remove(localView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter.a(localView);
      }
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        b(this.o + 1);
      }
      else
      {
        b(this.jdField_h_of_type_Int + 1);
      }
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    if (b())
    {
      b(paramInt);
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    this.o = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    View localView = a();
    if (localView == null) {
      this.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      if (paramInt1 != this.jdField_a_of_type_Int) {
        this.jdField_b_of_type_JavaUtilList.add(localView);
      }
      int i2 = localView.getLeft();
      int i1 = localView.getTop();
      paramInt1 -= i2;
      paramInt2 -= i1;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(localView.getLeft(), localView.getTop(), paramInt1, paramInt2, paramInt3);
        ViewCompat.postInvalidateOnAnimation(this);
      }
      while ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView$CardsSlideListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView$CardsSlideListener.b(this.jdField_h_of_type_Int);
        return;
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      View localView = a();
      if (localView == null) {
        return;
      }
      int i1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      int i2 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      int i3 = localView.getLeft();
      int i4 = localView.getTop();
      if ((i1 != this.jdField_a_of_type_AndroidWidgetScroller.getFinalX()) || (i2 != this.jdField_a_of_type_AndroidWidgetScroller.getFinalY())) {
        a(i1 - i3, i2 - i4);
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    a(paramMotionEvent);
    switch (i1)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener.c(true);
      }
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      d();
      if (c(paramMotionEvent)) {
        this.jdField_h_of_type_Boolean = true;
      }
      if ((b(paramMotionEvent)) && (a()) && (this.jdField_g_of_type_Boolean)) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_j_of_type_Int = ((int)paramMotionEvent.getRawY());
      this.k = ((int)paramMotionEvent.getRawX());
      this.l = this.jdField_j_of_type_Int;
      this.m = this.k;
      if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
      {
        a((View)this.jdField_a_of_type_JavaUtilList.get(1), false);
        continue;
        if ((!a()) || (!this.jdField_g_of_type_Boolean)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
        int i2 = (int)paramMotionEvent.getRawY();
        i1 = (int)paramMotionEvent.getRawX();
        int i3 = this.jdField_j_of_type_Int;
        i3 = this.k;
        this.jdField_j_of_type_Int = i2;
        this.k = i1;
        if (!this.jdField_b_of_type_Boolean)
        {
          int i4 = Math.abs(i1 - this.m);
          i2 = Math.abs(i2 - this.l);
          if (i2 + (i4 * i4 + i2) >= this.jdField_i_of_type_Int * this.jdField_i_of_type_Int) {
            this.jdField_b_of_type_Boolean = true;
          }
        }
        else
        {
          if ((this.jdField_h_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || ((!this.jdField_a_of_type_Boolean) && (!b(paramMotionEvent)))) {
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          a(i1 - i3, 0);
          a();
          return true;
        }
        return super.dispatchTouchEvent(paramMotionEvent);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener.c(false);
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_j_of_type_Boolean = false;
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_b_of_type_Float);
        float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
        float f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
        a(a(f1, this.jdField_c_of_type_Float, this.jdField_b_of_type_Float), a(f2, this.jdField_c_of_type_Float, this.jdField_b_of_type_Float));
        b();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {}
    do
    {
      return;
      paramInt4 = this.jdField_a_of_type_JavaUtilList.size();
    } while (paramInt4 == 0);
    paramInt2 = 0;
    while (paramInt2 < paramInt4)
    {
      a((View)this.jdField_a_of_type_JavaUtilList.get(paramInt2), paramInt2);
      paramInt2 += 1;
    }
    this.jdField_a_of_type_Int = ((View)this.jdField_a_of_type_JavaUtilList.get(0)).getLeft();
    this.jdField_b_of_type_Int = ((View)this.jdField_a_of_type_JavaUtilList.get(0)).getTop();
    this.jdField_e_of_type_Int = ((View)this.jdField_a_of_type_JavaUtilList.get(0)).getMeasuredWidth();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)this.jdField_a_of_type_JavaUtilList.get(0)).getLayoutParams();
    paramInt4 = localLayoutParams.leftMargin;
    int i1 = localLayoutParams.rightMargin;
    paramInt2 = ((View)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight();
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.a() / 2 + paramInt3 + i1);
    this.jdField_f_of_type_Float = (paramInt1 - this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.a() / 2 - paramInt4);
    float f1 = this.p + this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.b();
    float f2 = this.jdField_a_of_type_AndroidTextTextPaint.descent();
    float f3 = this.jdField_a_of_type_AndroidTextTextPaint.ascent();
    paramInt1 = this.jdField_b_of_type_Int;
    f1 = paramInt2 / 2 + paramInt1 - (f1 + (f2 + f3)) / 2.0F + this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.b() / 2;
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.d(this.jdField_e_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.e(f1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.d(this.jdField_f_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardTargetDrawable.e(f1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      measureChildWithMargins(getChildAt(i1), paramInt1, 0, paramInt2, 0);
      i1 += 1;
    }
    i1 = View.MeasureSpec.getSize(paramInt1);
    i2 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(a(i1, paramInt1, 0), a(i2, paramInt2, 0));
    this.jdField_c_of_type_Int = getMeasuredWidth();
    this.jdField_d_of_type_Int = getMeasuredHeight();
  }
  
  public void setAdapter(HeadCardAdapter paramHeadCardAdapter)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter = paramHeadCardAdapter;
    c(0);
  }
  
  public void setCardsSlideListener(SlideCardView.CardsSlideListener paramCardsSlideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewCardSlideCardView$CardsSlideListener = paramCardsSlideListener;
  }
  
  public void setColorTheme(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setInterceptListener(InterceptListener paramInterceptListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseInterceptListener = paramInterceptListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.card.SlideCardView
 * JD-Core Version:    0.7.0.1
 */