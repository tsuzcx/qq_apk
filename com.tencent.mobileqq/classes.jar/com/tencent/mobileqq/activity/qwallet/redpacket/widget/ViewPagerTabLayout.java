package com.tencent.mobileqq.activity.qwallet.redpacket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class ViewPagerTabLayout
  extends HorizontalScrollView
  implements ViewPager.OnPageChangeListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViewPagerTabLayout.OnTabSelectListener jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout$OnTabSelectListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 1;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private float h;
  private float i;
  private float j;
  private float k;
  
  public ViewPagerTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, String paramString, View paramView)
  {
    TextView localTextView = (TextView)paramView.getTag();
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    paramView.setOnClickListener(new ViewPagerTabLayout.1(this));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramString = new LinearLayout.LayoutParams(0, -1, 1.0F);; paramString = new LinearLayout.LayoutParams(-2, -1))
    {
      if (this.jdField_c_of_type_Float > 0.0F) {
        paramString = new LinearLayout.LayoutParams((int)this.jdField_c_of_type_Float, -1);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt, paramString);
      return;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setFillViewport(true);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    b(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    int m = 0;
    if (m < this.jdField_b_of_type_Int)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m).getTag();
      int n;
      if (localTextView != null)
      {
        if (m != this.jdField_a_of_type_Int) {
          break label95;
        }
        n = this.jdField_d_of_type_Int;
        label42:
        localTextView.setTextColor(n);
        localTextView.setTextSize(0, this.k);
        localTextView.setPadding((int)this.jdField_b_of_type_Float, 0, (int)this.jdField_b_of_type_Float, 0);
        if (this.jdField_f_of_type_Int != 2) {
          break label103;
        }
        localTextView.getPaint().setFakeBoldText(true);
      }
      for (;;)
      {
        m += 1;
        break;
        label95:
        n = this.jdField_e_of_type_Int;
        break label42;
        label103:
        if (this.jdField_f_of_type_Int == 0) {
          localTextView.getPaint().setFakeBoldText(false);
        }
      }
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerTabLayout);
    this.jdField_c_of_type_Int = paramContext.getColor(0, Color.parseColor("#ffffff"));
    this.jdField_d_of_type_Float = paramContext.getDimension(2, -1.0F);
    this.jdField_e_of_type_Float = paramContext.getDimension(3, -1.0F);
    this.jdField_f_of_type_Float = paramContext.getDimension(1, -1.0F);
    this.k = paramContext.getDimension(8, b(16.0F));
    this.jdField_d_of_type_Int = paramContext.getColor(6, Color.parseColor("#FF2051"));
    this.jdField_e_of_type_Int = paramContext.getColor(7, Color.parseColor("#F5F6FA"));
    this.jdField_c_of_type_Float = paramContext.getDimension(5, a(-1.0F));
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Float > 0.0F)) {}
    for (float f1 = a(0.0F);; f1 = a(15.0F))
    {
      this.jdField_b_of_type_Float = paramContext.getDimension(4, f1);
      paramContext.recycle();
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Int <= 0) {}
    int m;
    do
    {
      return;
      int i1 = (int)(this.jdField_a_of_type_Float * this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).getWidth());
      int n = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int).getLeft() + i1;
      if (this.jdField_a_of_type_Int <= 0)
      {
        m = n;
        if (i1 <= 0) {}
      }
      else
      {
        m = getWidth() / 2;
        i1 = getPaddingLeft();
        d();
        m = n - (m - i1) + (this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_b_of_type_AndroidGraphicsRect.left) / 2;
      }
    } while (m == this.jdField_g_of_type_Int);
    this.jdField_g_of_type_Int = m;
    scrollTo(m, 0);
  }
  
  private void d()
  {
    View localView1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int);
    float f4 = localView1.getLeft();
    float f3 = localView1.getRight();
    float f2 = f3;
    float f1 = f4;
    View localView2;
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int - 1)
    {
      localView2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int + 1);
      f1 = localView2.getLeft();
      f2 = localView2.getRight();
      f1 = f4 + (f1 - f4) * this.jdField_a_of_type_Float;
      f2 = f3 + (f2 - f3) * this.jdField_a_of_type_Float;
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((int)f1);
    this.jdField_a_of_type_AndroidGraphicsRect.right = ((int)f2);
    this.jdField_b_of_type_AndroidGraphicsRect.left = ((int)f1);
    this.jdField_b_of_type_AndroidGraphicsRect.right = ((int)f2);
    if (this.jdField_e_of_type_Float < 0.0F) {
      return;
    }
    f2 = localView1.getLeft() + (localView1.getWidth() - this.jdField_e_of_type_Float) / 2.0F;
    f1 = f2;
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int - 1)
    {
      localView2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_Int + 1);
      f1 = this.jdField_a_of_type_Float;
      int m = localView1.getWidth() / 2;
      f1 = f2 + (localView2.getWidth() / 2 + m) * f1;
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((int)f1);
    this.jdField_a_of_type_AndroidGraphicsRect.right = ((int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_e_of_type_Float));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getCount();
    int m = 0;
    while (m < this.jdField_b_of_type_Int)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setClipChildren(false);
      localRelativeLayout.setClipToPadding(false);
      TextView localTextView = new TextView(getContext());
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter().getPageTitle(m);
      localRelativeLayout.setTag(localTextView);
      if (localObject != null) {
        a(m, ((CharSequence)localObject).toString(), localRelativeLayout);
      }
      m += 1;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    int m = 0;
    if (m < this.jdField_b_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
      boolean bool;
      if (m == paramInt)
      {
        bool = true;
        label28:
        localObject = (TextView)((View)localObject).getTag();
        if (localObject != null) {
          if (!bool) {
            break label90;
          }
        }
      }
      label90:
      for (int n = this.jdField_d_of_type_Int;; n = this.jdField_e_of_type_Int)
      {
        ((TextView)localObject).setTextColor(n);
        if (this.jdField_f_of_type_Int == 1) {
          ((TextView)localObject).getPaint().setFakeBoldText(bool);
        }
        m += 1;
        break;
        bool = false;
        break label28;
      }
    }
  }
  
  protected int b(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.jdField_b_of_type_Int <= 0)) {}
    int n;
    do
    {
      return;
      int m = getHeight();
      n = getPaddingLeft();
      d();
      if (this.jdField_d_of_type_Float < 0.0F) {
        this.jdField_d_of_type_Float = (m - this.h - this.j);
      }
    } while (this.jdField_d_of_type_Float <= 0.0F);
    if ((this.jdField_f_of_type_Float < 0.0F) || (this.jdField_f_of_type_Float > this.jdField_d_of_type_Float / 2.0F)) {
      this.jdField_f_of_type_Float = (this.jdField_d_of_type_Float / 2.0F);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setBounds((int)this.jdField_g_of_type_Float + n + this.jdField_a_of_type_AndroidGraphicsRect.left, (int)this.h, (int)(n + this.jdField_a_of_type_AndroidGraphicsRect.right - this.i), (int)(this.h + this.jdField_d_of_type_Float));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_f_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.draw(paramCanvas);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Float = paramFloat;
    c();
    invalidate();
    if (QLog.isColorLevel()) {
      QLog.i("ViewPagerTabLayout", 2, "onPageScrolled:" + paramInt1 + " positionOffset:" + paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("ViewPagerTabLayout", 2, "onPageSelected:" + paramInt);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.jdField_a_of_type_Int = paramParcelable.getInt("currentTab");
      paramParcelable = paramParcelable.getParcelable("currentState");
      localParcelable = paramParcelable;
      if (this.jdField_a_of_type_Int != 0)
      {
        localParcelable = paramParcelable;
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
        {
          a(this.jdField_a_of_type_Int);
          c();
          localParcelable = paramParcelable;
        }
      }
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("currentState", super.onSaveInstanceState());
    localBundle.putInt("currentTab", this.jdField_a_of_type_Int);
    return localBundle;
  }
  
  public void setBoldStyle(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setCurrentTab(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void setCurrentTab(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt, paramBoolean);
    if (!paramBoolean) {
      onPageScrolled(paramInt, 0.0F, 0);
    }
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setOnTabSelectListener(ViewPagerTabLayout.OnTabSelectListener paramOnTabSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout$OnTabSelectListener = paramOnTabSelectListener;
  }
  
  public void setScrollOnTabClick(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTextsize(float paramFloat)
  {
    this.k = b(paramFloat);
    b();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    if ((paramViewPager == null) || (paramViewPager.getAdapter() == null)) {
      throw new IllegalStateException("ViewPager or it's adapter can not be null");
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout
 * JD-Core Version:    0.7.0.1
 */