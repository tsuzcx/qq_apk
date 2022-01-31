package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import rra;

public class RefreshAnimView
  extends RelativeLayout
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RefreshEyeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView;
  private LottieComposition jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition;
  
  public RefreshAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131562309, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369591));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375059));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView = ((RefreshEyeView)findViewById(2131375052));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.b();
    ThreadManager.excute(new RefreshAnimView.1(this, paramContext), 64, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setWaveHeightPercent(paramDouble);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RefreshAnimView.2(this), paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new rra(this, paramString, paramBoolean));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.startAnimation(localScaleAnimation);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshEyeView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView
 * JD-Core Version:    0.7.0.1
 */