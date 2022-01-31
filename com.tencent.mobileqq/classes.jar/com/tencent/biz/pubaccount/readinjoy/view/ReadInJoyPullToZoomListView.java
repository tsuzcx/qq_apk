package com.tencent.biz.pubaccount.readinjoy.view;

import ajyc;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import bawz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import rca;
import rfa;
import rfb;

public class ReadInJoyPullToZoomListView
  extends ReadInJoyBaseListView
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new rfa();
  private static boolean e;
  float jdField_a_of_type_Float = -1.0F;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ReadInJoyPullToZoomListView.ScalingRunnalable jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable;
  private rfb jdField_a_of_type_Rfb;
  float jdField_b_of_type_Float = -1.0F;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  float jdField_c_of_type_Float = 1.401F;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  float jdField_d_of_type_Float = 1.235F;
  boolean jdField_d_of_type_Boolean;
  protected int e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  
  public ReadInJoyPullToZoomListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, localLayoutParams);
    }
    c();
    d();
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    f();
    rca localrca;
    if (this.jdField_a_of_type_Rca != null)
    {
      localrca = this.jdField_a_of_type_Rca;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 1;; i = 0)
    {
      localrca.a(this, i);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(-1);
      localTextView.setText(ajyc.a(2131713114));
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = bawz.a(getContext(), 52.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    }
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(1728053247);
      localTextView.setTextSize(1, 12.0F);
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = bawz.a(getContext(), 58.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetTextView = localTextView;
    }
  }
  
  private void e()
  {
    int i;
    int j;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() > 0) && (this.jdField_a_of_type_AndroidViewView.getBottom() > 0))
    {
      i = this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom();
      j = this.jdField_a_of_type_AndroidViewView.getBottom();
      if (i > j) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Rfb != null)
        {
          this.jdField_a_of_type_Rfb.a(this.jdField_f_of_type_Boolean);
          if (QLog.isColorLevel()) {
            QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "checkIsTopFixed(): mFixed=" + this.jdField_f_of_type_Boolean);
          }
        }
      }
      if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean)) {
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "checkIsTopFixed(): titleBarBottom=" + j + "， headerBottom=" + i + "， fixed = " + bool + ", mTopFixed=" + this.jdField_f_of_type_Boolean);
      }
      return;
    }
  }
  
  private void f()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      Drawable localDrawable = getResources().getDrawable(2130839142);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      ((Animatable)localDrawable).start();
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void h()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void j()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable.a(300L);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable = new ReadInJoyPullToZoomListView.ScalingRunnalable(this);
  }
  
  public void addHeaderView(View paramView)
  {
    a(paramView);
    super.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    a(paramView);
    super.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramObject, paramBoolean);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    e();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    e();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_e_of_type_Int = ((int)paramMotionEvent.getRawY());
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable.a) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable.a();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() / this.jdField_f_of_type_Int);
      if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean))
      {
        QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_DOWN ==>  mLastScale = " + this.jdField_b_of_type_Float + "， mHeaderMaxHeight = " + this.g);
        continue;
        this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY() - this.jdField_e_of_type_Int);
        if (this.jdField_a_of_type_Float == -1.0F) {
          this.jdField_a_of_type_Float = paramMotionEvent.getY();
        }
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() >= this.jdField_f_of_type_Int)
        {
          ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          float f1 = ((paramMotionEvent.getY() - this.jdField_a_of_type_Float + this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom()) / this.jdField_f_of_type_Int - this.jdField_b_of_type_Float) / 2.0F + this.jdField_b_of_type_Float;
          if ((this.jdField_b_of_type_Float <= 1.0D) && (f1 < this.jdField_b_of_type_Float))
          {
            localLayoutParams.height = this.jdField_f_of_type_Int;
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
            return super.onTouchEvent(paramMotionEvent);
          }
          this.jdField_b_of_type_Float = Math.min(Math.max(f1, 1.0F), this.jdField_c_of_type_Float);
          localLayoutParams.height = ((int)(this.jdField_f_of_type_Int * this.jdField_b_of_type_Float));
          if (localLayoutParams.height <= this.g) {
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
          }
          if (this.jdField_b_of_type_Float >= this.jdField_d_of_type_Float) {
            f();
          }
          for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
          {
            if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean)) {
              QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_MOVE, f = " + f1 + ", mLastScale=" + this.jdField_b_of_type_Float + ", mEnterRefreshDefer=" + this.jdField_d_of_type_Boolean);
            }
            this.jdField_a_of_type_Float = paramMotionEvent.getY();
            return true;
            g();
          }
        }
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        continue;
        if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean)) {
          QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_UP <=====  mEnterRefreshDefer=" + this.jdField_d_of_type_Boolean);
        }
        j();
        i();
        continue;
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean)) {
          QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_CANCEL xxxx");
        }
      }
    }
  }
  
  public void setHeaderViewSize(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new AbsListView.LayoutParams(paramInt1, paramInt2);
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_Int = paramInt2;
    this.g = ((int)(this.jdField_f_of_type_Int * this.jdField_c_of_type_Float));
  }
  
  public void setOnTopCallback(rfb paramrfb)
  {
    this.jdField_a_of_type_Rfb = paramrfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyPullToZoomListView
 * JD-Core Version:    0.7.0.1
 */