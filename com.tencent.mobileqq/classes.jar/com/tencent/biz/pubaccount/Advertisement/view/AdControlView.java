package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import nwz;
import nxa;

public class AdControlView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private View jdField_a_of_type_AndroidViewView;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  public boolean a;
  private View b;
  public boolean b;
  private View c;
  public boolean c;
  private View d;
  private View e;
  
  public AdControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    d();
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131559261, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380776);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131381020);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131362097);
    this.d = findViewById(2131362110);
    this.e = findViewById(2131371400);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = ((AdvertisementSplitedProgressBar)findViewById(2131380958));
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131717856));
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131698382));
    this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131689506));
    this.d.setContentDescription(getResources().getString(2131692394));
    this.e.setContentDescription(getResources().getString(2131689506));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F, 1.0F }).setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(3);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new nwz(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new nxa(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public AdvertisementSplitedProgressBar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841588);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F);
    }
  }
  
  public View c()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public View d()
  {
    return this.d;
  }
  
  public View e()
  {
    return this.e;
  }
  
  public void setMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(4);
        this.d.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(4);
        this.e.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.d.setVisibility(0);
      this.e.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(0);
      super.setVisibility(paramInt);
      continue;
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(4);
          this.d.setVisibility(4);
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(4);
          this.e.setVisibility(0);
        }
        else if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.d.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(0);
          this.e.setVisibility(4);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(4);
          this.jdField_c_of_type_AndroidViewView.setVisibility(4);
          this.d.setVisibility(4);
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(4);
          this.e.setVisibility(4);
        }
      }
      else {
        super.setVisibility(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdControlView
 * JD-Core Version:    0.7.0.1
 */