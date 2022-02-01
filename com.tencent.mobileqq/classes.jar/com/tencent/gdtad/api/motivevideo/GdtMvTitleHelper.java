package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;

public class GdtMvTitleHelper
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtMvTitleHelper.MvTitleListener jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper$MvTitleListener;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  
  private static int a(GdtAd paramGdtAd)
  {
    paramGdtAd = a(paramGdtAd, 104804);
    GdtLog.b("GdtMvTitleHelper", "getRewardVideoCloseBtnAppearSecFromExp = " + paramGdtAd);
    if (TextUtils.isEmpty(paramGdtAd)) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramGdtAd);
      return i;
    }
    catch (NumberFormatException paramGdtAd)
    {
      GdtLog.b("GdtMvTitleHelper", "getRewardVideoCloseBtnAppearSecFromExp error", paramGdtAd);
    }
    return 0;
  }
  
  private static String a(GdtAd paramGdtAd, int paramInt)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int i = 0;
        while (i < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get() == paramInt)
          {
            paramGdtAd = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get();
            return paramGdtAd;
          }
          i += 1;
        }
        return "";
      }
      catch (Throwable paramGdtAd)
      {
        QLog.e("GdtMvTitleHelper", 1, "exp_map error" + paramGdtAd);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(1.0F - paramFloat);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.c.setVisibility(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (paramLong1 > 0L)
      {
        a(HardCodeUtil.a(2131705236) + paramLong2 + "s", 0);
        return;
      }
      a("", 8);
      return;
    }
    if (paramLong1 > 0L)
    {
      a(String.format(HardCodeUtil.a(2131692897), new Object[] { Long.valueOf(paramLong2) }), 0);
      return;
    }
    a(HardCodeUtil.a(2131692896), 0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramLong >= this.jdField_b_of_type_Int))
    {
      QLog.i("GdtMvTitleHelper", 4, "set close button visible");
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Int == 0)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.c == null)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen bar == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen !isPortait");
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.jdField_a_of_type_Int);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.b())
    {
      localLayoutParams.topMargin = LiuHaiUtils.b(paramActivity);
      this.c.setLayoutParams(localLayoutParams);
      QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen addHeight = " + localLayoutParams.topMargin);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null))
    {
      QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner " + paramBoolean);
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130838603);
      localDrawable = ImageUtil.a(paramContext, -16777216);
      a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692909);
      a(this.jdField_b_of_type_AndroidWidgetImageView, localDrawable, 2131692909);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130838604);
    Drawable localDrawable = ImageUtil.a(paramContext, -16777216);
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692908);
    a(this.jdField_b_of_type_AndroidWidgetImageView, localDrawable, 2131692908);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368032));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368034));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368035));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368033);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381900));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381902));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381903));
    ImageView localImageView = (ImageView)paramView.findViewById(2131381901);
    localImageView.setImageDrawable(ImageUtil.a(paramView.getContext().getResources().getDrawable(2130840407), -16777216));
    this.jdField_a_of_type_AndroidViewView = localImageView;
    paramView.findViewById(2131368041).setVisibility(8);
    paramView.findViewById(2131381904).setVisibility(8);
  }
  
  public void a(View paramView, GdtMvTitleHelper.MvTitleListener paramMvTitleListener, GdtMotiveVideoModel paramGdtMotiveVideoModel, GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.a() != null) && (paramGdtMotiveVideoModel.a().exp_info.has()) && (paramGdtMotiveVideoModel.a().exp_info.video_countdown_style.has())) {
      this.jdField_a_of_type_Int = paramGdtMotiveVideoModel.a().exp_info.video_countdown_style.get();
    }
    if (paramGdtMotiveVideoModel != null) {
      this.jdField_b_of_type_Int = a(paramGdtMotiveVideoModel.a());
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper$MvTitleListener = paramMvTitleListener;
    this.c = paramView.findViewById(2131367817);
    if (this.c == null) {
      QLog.i("GdtMvTitleHelper", 1, "bar == null");
    }
    for (;;)
    {
      return;
      QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == 0) {
        b(paramView);
      }
      while (paramGdtMvMiniAppReportHelper != null)
      {
        paramGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_AndroidWidgetImageView);
        paramGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_AndroidViewView);
        return;
        a(paramView);
      }
    }
  }
  
  protected void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    paramImageView.setContentDescription(HardCodeUtil.a(paramInt));
  }
  
  protected void a(String paramString, int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368041));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368043));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368044));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368042);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381904));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381907));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381908));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381906);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramView.findViewById(2131368032).setVisibility(8);
    paramView.findViewById(2131381900).setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper$MvTitleListener != null)
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper$MvTitleListener.a(true);
        continue;
        if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper$MvTitleListener != null) {
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvTitleHelper$MvTitleListener.b(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvTitleHelper
 * JD-Core Version:    0.7.0.1
 */