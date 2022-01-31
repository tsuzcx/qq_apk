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
import bdhj;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Timer;
import xsm;
import ybt;
import yoj;

public class VideoNextFeedsView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = xsm.a(getContext(), 18.0F);
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private final String jdField_a_of_type_JavaLangString = "VideoNextFeedsView";
  private List<CertifiedAccountMeta.StFeed> jdField_a_of_type_JavaUtilList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private yoj jdField_a_of_type_Yoj;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = xsm.a(getContext(), 331.0F);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = xsm.a(getContext(), 75.0F);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e;
  private int f = 3;
  private int g;
  
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
    do
    {
      this.g += 1;
      if (this.g >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localStFeed = (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_JavaUtilList.get(this.g);
    } while ((localStFeed == null) || (!ybt.a(localStFeed.type.get())));
    for (;;)
    {
      if (localStFeed == null)
      {
        QZLog.e("VideoNextFeedsView", "playNextData():no more feed can play!");
        return false;
      }
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      String str = localStFeed.poster.icon.get();
      int i = xsm.a(getContext(), this.jdField_a_of_type_Int);
      int j = xsm.a(getContext(), this.jdField_a_of_type_Int);
      Context localContext = getContext();
      if (this.jdField_a_of_type_Boolean) {}
      for (float f1 = 10.0F;; f1 = 9.0F)
      {
        xsm.a(localImageView, str, i, j, xsm.a(localContext, f1), bdhj.b(), null);
        xsm.a(this.jdField_a_of_type_AndroidWidgetImageView, localStFeed.cover.url.get(), this.d, this.e, getResources().getDrawable(2130839372), null);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localStFeed.title.get());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStFeed.poster.nick.get());
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = localStFeed;
        this.g += 1;
        return true;
      }
      localStFeed = null;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558744, null);
    addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368849));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378897));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378898));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378726));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368850));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131364906));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, Color.parseColor("#ffffff"), 100, Color.parseColor("#ffffff"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(xsm.a(getContext(), 1.0F));
    setVisibility(8);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
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
    if (this.jdField_a_of_type_Yoj != null) {
      this.jdField_a_of_type_Yoj.a(b());
    }
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
  
  public void setOnCounterListener(yoj paramyoj)
  {
    this.jdField_a_of_type_Yoj = paramyoj;
  }
  
  public void setUIState(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j;
    if (paramBoolean2)
    {
      i = ImmersiveUtils.a(400.0F);
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (!paramBoolean1) {
        break label234;
      }
      j = ImmersiveUtils.a(14.0F);
      label28:
      if (!paramBoolean1) {
        break label245;
      }
      label32:
      this.jdField_b_of_type_Int = i;
      if (!paramBoolean1) {
        break label254;
      }
      i = ImmersiveUtils.a(135.0F);
      label48:
      this.jdField_c_of_type_Int = i;
      if (!paramBoolean1) {
        break label260;
      }
      i = ImmersiveUtils.a(133.0F);
      label64:
      this.d = i;
      if (!paramBoolean1) {
        break label269;
      }
      i = ImmersiveUtils.a(103.0F);
      label80:
      this.e = i;
      if (!paramBoolean1) {
        break label279;
      }
      i = ImmersiveUtils.a(20.0F);
      label96:
      this.jdField_a_of_type_Int = i;
      if (!paramBoolean1) {
        break label288;
      }
    }
    label260:
    label269:
    label279:
    label288:
    for (int i = ImmersiveUtils.a(30.0F);; i = ImmersiveUtils.a(10.0F))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(j, j, j, j);
      getLayoutParams().width = this.jdField_b_of_type_Int;
      getLayoutParams().height = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = this.d;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.e;
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, i, 0);
      requestLayout();
      return;
      i = (int)(ImmersiveUtils.a() * 0.88D);
      break;
      label234:
      j = ImmersiveUtils.a(8.0F);
      break label28;
      label245:
      i = ImmersiveUtils.a(331.0F);
      break label32;
      label254:
      i = -2;
      break label48;
      i = ImmersiveUtils.a(75.0F);
      break label64;
      i = ImmersiveUtils.a(59.0F);
      break label80;
      i = ImmersiveUtils.a(18.0F);
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.VideoNextFeedsView
 * JD-Core Version:    0.7.0.1
 */