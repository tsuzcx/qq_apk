package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Timer;

public class VideoNextFeedsView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = UIUtils.a(getContext(), 18.0F);
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoNextFeedsView.OnCounterListener jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView$OnCounterListener;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private final String jdField_a_of_type_JavaLangString = "VideoNextFeedsView";
  private List<CertifiedAccountMeta.StFeed> jdField_a_of_type_JavaUtilList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = UIUtils.a(getContext(), 331.0F);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = UIUtils.a(getContext(), 75.0F);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e;
  private int f = 5;
  private int g = 0;
  private int h;
  
  public VideoNextFeedsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoNextFeedsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoNextFeedsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    CertifiedAccountMeta.StFeed localStFeed;
    for (;;)
    {
      localStFeed = null;
      if (this.g >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localStFeed = (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_JavaUtilList.get(this.g);
      if ((localStFeed != null) && (SubscribeLaucher.a(localStFeed.type.get()))) {
        break;
      }
      this.g += 1;
    }
    if (localStFeed == null)
    {
      QZLog.e("VideoNextFeedsView", "playNextData():no more feed can play!");
      return false;
    }
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    String str = localStFeed.poster.icon.get();
    int i = UIUtils.a(getContext(), this.jdField_a_of_type_Int);
    int j = UIUtils.a(getContext(), this.jdField_a_of_type_Int);
    Context localContext = getContext();
    float f1;
    if (this.jdField_a_of_type_Boolean) {
      f1 = 10.0F;
    } else {
      f1 = 9.0F;
    }
    UIUtils.a(localImageView, str, i, j, UIUtils.a(localContext, f1), ImageUtil.e(), null);
    UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, localStFeed.cover.url.get(), this.d, this.e, getResources().getDrawable(2130839553), null);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localStFeed.title.get());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStFeed.poster.nick.get());
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = localStFeed;
    this.g += 1;
    return true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558779, null);
    addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369429));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379779));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379780));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379600));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369430));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131365306));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, Color.parseColor("#ffffff"), 100, Color.parseColor("#ffffff"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(UIUtils.a(getContext(), 1.0F));
    setVisibility(8);
  }
  
  private void e()
  {
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
      this.f = 5;
    }
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  public void a()
  {
    VideoNextFeedsView.OnCounterListener localOnCounterListener = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView$OnCounterListener;
    if (localOnCounterListener != null) {
      localOnCounterListener.a(b());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h = this.f;
      e();
      return;
    }
    c();
    this.h = 0;
  }
  
  public boolean a()
  {
    if (b())
    {
      c();
      setVisibility(0);
      return true;
    }
    setVisibility(8);
    return false;
  }
  
  public void b()
  {
    if (getHandler() != null) {
      getHandler().post(new VideoNextFeedsView.1(this));
    }
  }
  
  public void c()
  {
    e();
    int i = this.h;
    if (i != 0) {
      this.f = i;
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VideoNextFeedsView.2(this), 0L, 1000L);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (getHandler() != null) {
      getHandler().removeCallbacksAndMessages(null);
    }
    e();
  }
  
  public void setData(List<CertifiedAccountMeta.StFeed> paramList)
  {
    this.g = 0;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void setOnCounterListener(VideoNextFeedsView.OnCounterListener paramOnCounterListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView$OnCounterListener = paramOnCounterListener;
  }
  
  public void setUIState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      i = ImmersiveUtils.dpToPx(400.0F);
    }
    else
    {
      double d1 = ImmersiveUtils.getScreenWidth();
      Double.isNaN(d1);
      i = (int)(d1 * 0.88D);
    }
    this.jdField_a_of_type_Boolean = paramBoolean1;
    float f1;
    if (paramBoolean1) {
      f1 = 14.0F;
    } else {
      f1 = 8.0F;
    }
    int j = ImmersiveUtils.dpToPx(f1);
    if (!paramBoolean1) {
      i = ImmersiveUtils.dpToPx(331.0F);
    }
    this.jdField_b_of_type_Int = i;
    if (paramBoolean1) {
      i = ImmersiveUtils.dpToPx(135.0F);
    } else {
      i = -2;
    }
    this.jdField_c_of_type_Int = i;
    if (paramBoolean1) {
      f1 = 133.0F;
    } else {
      f1 = 75.0F;
    }
    this.d = ImmersiveUtils.dpToPx(f1);
    if (paramBoolean1) {
      f1 = 103.0F;
    } else {
      f1 = 59.0F;
    }
    this.e = ImmersiveUtils.dpToPx(f1);
    if (paramBoolean1) {
      f1 = 20.0F;
    } else {
      f1 = 18.0F;
    }
    this.jdField_a_of_type_Int = ImmersiveUtils.dpToPx(f1);
    if (paramBoolean1) {
      f1 = 30.0F;
    } else {
      f1 = 10.0F;
    }
    int i = ImmersiveUtils.dpToPx(f1);
    this.jdField_a_of_type_AndroidViewView.setPadding(j, j, j, j);
    getLayoutParams().width = this.jdField_b_of_type_Int;
    getLayoutParams().height = this.jdField_c_of_type_Int;
    this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = this.d;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.e;
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, i, 0);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.VideoNextFeedsView
 * JD-Core Version:    0.7.0.1
 */