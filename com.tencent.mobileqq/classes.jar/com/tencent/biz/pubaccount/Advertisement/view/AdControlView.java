package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import kuw;
import kux;

public class AdControlView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public View a;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  public boolean a;
  public View b;
  public boolean b;
  public View c;
  private View d;
  
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
    LayoutInflater.from(getContext()).inflate(2130969030, this);
    this.d = findViewById(2131364806);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364807);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364809);
    this.c = findViewById(2131364808);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = ((AdvertisementSplitedProgressBar)findViewById(2131364810));
    this.d.setContentDescription(getResources().getString(2131435991));
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131436801));
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getResources().getString(2131437778));
    this.c.setContentDescription(getResources().getString(2131437778));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F, 1.0F }).setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(3);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new kuw(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new kux(this));
  }
  
  public View a()
  {
    return this.d;
  }
  
  public AdvertisementSplitedProgressBar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839660);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    }
  }
  
  public View c()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public View d()
  {
    return this.c;
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
        this.d.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(4);
        this.c.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      this.d.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.c.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(0);
      super.setVisibility(paramInt);
      continue;
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_Int == 2)
        {
          this.d.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(4);
          this.c.setVisibility(0);
        }
        else
        {
          this.d.setVisibility(4);
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setVisibility(4);
          this.c.setVisibility(4);
        }
      }
      else {
        super.setVisibility(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdControlView
 * JD-Core Version:    0.7.0.1
 */