package com.tencent.biz.pubaccount.readinjoy.video;

import ajya;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import baxn;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import nol;
import qmo;
import qmq;
import qmr;
import qql;
import qza;
import qzb;

public class VideoFeedsAioGuideView
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131716190);
  }
  
  public VideoFeedsAioGuideView(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = baxn.a(paramActivity, 5.0F);
    setVisibility(8);
  }
  
  private void d()
  {
    setBackgroundResource(2130842188);
    int i = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F);
    int j = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 3.0F);
    setPadding(i, j, i, j);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-654311425);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842533);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842533);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 19;
    localLayoutParams.rightMargin = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 21;
    localLayoutParams.topMargin = (-baxn.a(this.jdField_a_of_type_AndroidAppActivity, 2.0F));
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 21;
    localLayoutParams.topMargin = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 3.0F);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  public void a()
  {
    setVisibility(0);
    setTranslationY(this.jdField_a_of_type_Int);
    setAlpha(0.0F);
    animate().translationYBy(-this.jdField_a_of_type_Int).alphaBy(1.0F).setDuration(240L);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(360L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new qmq(this));
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(360L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new qmr(this));
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setStartOffset(180L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setStartOffset(0L);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      qzb localqzb = new qzb(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, "0X8009833", "0X8009833", 0, 0, "", "", "", localqzb.a().a(), false);
    }
  }
  
  public void a(qmo paramqmo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramqmo.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      d();
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.gravity = 85;
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.bottomMargin = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 63.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.rightMargin = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
      setOnClickListener(this);
    }
    if (getParent() != paramqmo.d)
    {
      if (getParent() != null) {
        ((ViewGroup)getParent()).removeView(this);
      }
      paramqmo.d.addView(this, this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
    }
  }
  
  public void b()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    }
  }
  
  public void c()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
    paramView = new qzb(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, "0X8009834", "0X8009834", 0, 0, "", "", "", paramView.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView
 * JD-Core Version:    0.7.0.1
 */