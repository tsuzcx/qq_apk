package com.tencent.gdtad.basics.motivevideo.elements;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.button.AdButtonController;
import com.tencent.ad.tangram.views.button.AdButtonView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.basics.motivevideo.GdtMvViewController;
import com.tencent.gdtad.basics.motivevideo.IMotiveVideoView;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class GdtMvElementsController
  implements View.OnClickListener, View.OnHoverListener
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdButtonController jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
  private AdButtonView jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private GdtMvViewController jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
  private GdtMvAnimation185H jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H;
  private GdtMvAnimation185V jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V;
  private GdtMvAnimation585V jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V;
  private GdtMotiveVideoClickCoordinateReportHelper jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper;
  private GdtMvMiniAppReportHelper jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper;
  public GdtThirdProcessorProxy a;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = null;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public GdtMvElementsController(GdtMvViewController paramGdtMvViewController, View paramView, GdtMotiveVideoModel paramGdtMotiveVideoModel, GdtThirdProcessorProxy paramGdtThirdProcessorProxy)
  {
    GdtLog.a("GdtMvElementsController", "GdtMvElementsController: ");
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController = paramGdtMvViewController;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidContentContext = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel = paramGdtMotiveVideoModel;
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper = new GdtMotiveVideoClickCoordinateReportHelper();
    this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy = paramGdtThirdProcessorProxy;
  }
  
  private static Context a(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext != null)
    {
      localContext = paramContext;
      if (!(paramContext instanceof Activity))
      {
        if (!(paramContext instanceof ContextThemeWrapper)) {
          return paramContext;
        }
        localContext = a(((ContextThemeWrapper)paramContext).getBaseContext());
      }
    }
    return localContext;
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidViewView.getContext());
    if (2 == paramInt)
    {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838464));
      return localImageView;
    }
    if (1 == paramInt)
    {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838458));
      return localImageView;
    }
    if (3 == paramInt) {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838459));
    }
    return localImageView;
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localObject = ((GdtMotiveVideoPageData)localObject).bannerBaseInfoText;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = ((String)localObject).length();
        if (i > 16)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localObject).substring(0, 16);
          this.jdField_b_of_type_JavaLangString = ((String)localObject).substring(16, i);
        }
      }
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject = this.jdField_a_of_type_JavaLangString;
      }
      localTextView.setText((CharSequence)localObject);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout != null)
    {
      if (paramDouble < 7.0D) {
        return;
      }
      int i = 4;
      int n = 0;
      int j;
      int k;
      if (paramDouble < 8.0D)
      {
        j = 0;
        k = 1;
      }
      else
      {
        if (paramDouble < 9.0D)
        {
          j = 1;
        }
        else
        {
          i = 5;
          j = 0;
        }
        k = 0;
      }
      int m = ViewUtils.a(15.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      m = 0;
      while (m < i)
      {
        if (m == 0) {
          localLayoutParams.leftMargin = 0;
        } else {
          localLayoutParams.leftMargin = ViewUtils.a(3.0F);
        }
        paramLinearLayout.addView(a(1), localLayoutParams);
        m += 1;
      }
      i = 0;
      for (;;)
      {
        m = n;
        if (i >= j) {
          break;
        }
        paramLinearLayout.addView(a(2), localLayoutParams);
        i += 1;
      }
      while (m < k)
      {
        paramLinearLayout.addView(a(3), localLayoutParams);
        m += 1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      Object localObject2 = new Rect();
      this.jdField_a_of_type_AndroidWidgetButton.getGlobalVisibleRect((Rect)localObject2);
      if ((this.jdField_c_of_type_AndroidViewView != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
      {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(GdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel));
        return;
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        localTextView.getGlobalVisibleRect((Rect)localObject2);
        if ((this.jdField_c_of_type_AndroidViewView != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
        {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(((GdtMotiveVideoPageData)localObject1).bannerImgName);
          return;
        }
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (localTextView != null)
        {
          localTextView.getGlobalVisibleRect((Rect)localObject2);
          if ((this.jdField_c_of_type_AndroidViewView != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
          {
            localObject2 = this.jdField_c_of_type_AndroidViewView;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              localObject1 = ((GdtMotiveVideoPageData)localObject1).bannerBaseInfoText;
            } else {
              localObject1 = this.jdField_a_of_type_JavaLangString;
            }
            ((View)localObject2).setContentDescription((CharSequence)localObject1);
          }
        }
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      if (Build.VERSION.SDK_INT < 16) {}
    }
    for (;;)
    {
      try
      {
        Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if (!paramBoolean) {
          break label202;
        }
        i = 1334;
        int j;
        if (paramBoolean) {
          j = GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext);
        } else {
          j = GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext);
        }
        ((RelativeLayout.LayoutParams)localObject).height = GdtUIUtils.a(paramInt, i, j);
        this.jdField_b_of_type_AndroidViewView.setBackground(GdtUIUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165673), 8, 80));
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initDesMaskPositions ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramBoolean);
        GdtLog.b("GdtMvElementsController", ((StringBuilder)localObject).toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        GdtLog.d("GdtMvElementsController", "initDesMaskPositions error! ", localThrowable);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
      label202:
      int i = 750;
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    paramGdtMotiveVideoPageData = a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a(), paramGdtMotiveVideoPageData, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a().a(), a());
    if ((this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().isHitDownloadLayer()) && (AdClickUtil.isValidForApp(GdtHandler.a(paramGdtMotiveVideoPageData))))
    {
      int i = AdUIUtils.getValueDependsOnScreenWidth(this.jdField_a_of_type_AndroidContentContext, 750, 584);
      int j = AdUIUtils.getValueDependsOnScreenWidth(this.jdField_a_of_type_AndroidContentContext, 750, 80);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView = new AdButtonView(this.jdField_a_of_type_AndroidContentContext, i, j);
      this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView.getButtonView().setId(2131367572);
      this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController = new AdButtonController(GdtHandler.a(paramGdtMotiveVideoPageData));
      this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController.registerView(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView), true);
      localLayoutParams.width = i;
      localLayoutParams.height = j;
      localLayoutParams.addRule(14);
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView.getButtonView(), localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      int i;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateScoreAndStar ");
        ((StringBuilder)localObject).append(paramString);
        GdtLog.a("GdtMvElementsController", ((StringBuilder)localObject).toString());
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (localObject != null) {
          ((LinearLayout)localObject).setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165537));
        float f = 0.0F;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null) {
          f = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
        }
        paramString = new StringBuilder();
        paramString.append("updateScoreAndStar ");
        paramString.append(this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
        paramString.append(" mw ");
        paramString.append(f);
        GdtLog.a("GdtMvElementsController", paramString.toString());
        i = Math.max((int)f, this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
        this.jdField_c_of_type_AndroidWidgetTextView.setWidth(i);
        return;
      }
      Object localObject = new StringBuilder(500);
      double d1;
      if (localGdtMotiveVideoPageData.appScore < 7.0D)
      {
        i = Double.compare(localGdtMotiveVideoPageData.appScore, 0.0D);
        paramString = "精品推荐 ";
        if (i == 0)
        {
          if (!GdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel)) {
            paramString = "精品内容 ";
          }
          ((StringBuilder)localObject).append(paramString);
        }
        else
        {
          ((StringBuilder)localObject).append("精品推荐 ");
        }
        paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
      else
      {
        paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramString != null)
        {
          paramString.setVisibility(0);
          a(localGdtMotiveVideoPageData.appScore, this.jdField_a_of_type_AndroidWidgetLinearLayout);
          paramString = new DecimalFormat("0.0");
          double d2 = localGdtMotiveVideoPageData.appScore;
          d1 = 10.0D;
          if (d2 <= 10.0D) {
            d1 = localGdtMotiveVideoPageData.appScore;
          }
          ((StringBuilder)localObject).append(paramString.format(d1));
          ((StringBuilder)localObject).append("分 ");
        }
      }
      if (localGdtMotiveVideoPageData.downloadNum < 100000L)
      {
        if (0L == localGdtMotiveVideoPageData.downloadNum)
        {
          if (GdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel)) {
            paramString = "热门下载";
          } else {
            paramString = "热门推荐";
          }
          ((StringBuilder)localObject).append(paramString);
        }
        else
        {
          ((StringBuilder)localObject).append("热门下载 ");
        }
      }
      else
      {
        if (localGdtMotiveVideoPageData.downloadNum < 100000000L)
        {
          d1 = localGdtMotiveVideoPageData.downloadNum;
          Double.isNaN(d1);
          ((StringBuilder)localObject).append(new BigDecimal(d1 / 10000.0D).setScale(0, 4));
          ((StringBuilder)localObject).append("万");
        }
        else
        {
          d1 = localGdtMotiveVideoPageData.downloadNum;
          Double.isNaN(d1);
          ((StringBuilder)localObject).append(new BigDecimal(d1 / 100000000.0D).setScale(1, 4));
          ((StringBuilder)localObject).append("亿");
        }
        if (GdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel)) {
          ((StringBuilder)localObject).append("次下载");
        } else {
          ((StringBuilder)localObject).append("次浏览");
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
    }
  }
  
  private void i()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        j();
        return;
      }
      l();
      return;
    }
    k();
  }
  
  private void j()
  {
    a(700, true);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = GdtUIUtils.a(140, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = GdtUIUtils.a(1054, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(1063, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(1111, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(1160, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    localLayoutParams.height = GdtUIUtils.a(80, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = GdtUIUtils.a(1224, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height = GdtUIUtils.a(315, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void k()
  {
    a(400, false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = GdtUIUtils.a(140, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = GdtUIUtils.a(580, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(589, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(637, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(685, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    localLayoutParams.height = GdtUIUtils.a(80, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = GdtUIUtils.a(611, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(1034, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = GdtUIUtils.a(30, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height = GdtUIUtils.a(200, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).topMargin = GdtUIUtils.a(742, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    this.jdField_a_of_type_AndroidWidgetButton.setHeight(GdtUIUtils.a(80, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext)));
    ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(1224, 1334, GdtUIUtils.d(this.jdField_a_of_type_AndroidContentContext));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(30, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((RelativeLayout.LayoutParams)localObject).leftMargin;
  }
  
  private void m()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      int i = GdtUIUtils.a(140, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
      int j = GdtUIUtils.a(21, 750, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
      localObject = this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a(), i, j);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(localGdtMotiveVideoPageData.bannerImgName);
    }
    a(a());
    e();
  }
  
  private void n()
  {
    GdtMvMiniAppReportHelper localGdtMvMiniAppReportHelper = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper;
    if (localGdtMvMiniAppReportHelper != null)
    {
      GdtMvViewController localGdtMvViewController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
      if ((localGdtMvViewController != null) && (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper != null)) {
        localGdtMvMiniAppReportHelper.a(localGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper);
      }
    }
  }
  
  public GdtHandler.Params a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Activity paramActivity, boolean paramBoolean)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.c = paramGdtMotiveVideoPageData.processId;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    if (paramAdInfo != null) {
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAdInfo);
    }
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidContentContext);
    }
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = paramBoolean;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    paramGdtMotiveVideoPageData = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramAdInfo = paramGdtMotiveVideoPageData;
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtMvElementsController", 1, "getClickParam refId is empty");
      paramAdInfo = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if (!TextUtils.isEmpty(paramAdInfo)) {
      localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramAdInfo);
    }
    return localParams;
  }
  
  public void a()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362259);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362150));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362169));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362086));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362159));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362177));
    a(localGdtMotiveVideoPageData, this.jdField_a_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null)
    {
      ((Button)localObject).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_a_of_type_AndroidWidgetButton);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362161));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380646));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367579);
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper.a((View)localObject);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnHoverListener(this);
    }
    if ((localGdtMotiveVideoPageData.vSize != 585) && (localGdtMotiveVideoPageData.screenOrientation == 1)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363716));
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362145));
    i();
    m();
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper.a(new GdtMvElementsController.1(this));
  }
  
  public void a(int paramInt)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustViewsPosition ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" style ");
    localStringBuilder.append(localGdtMotiveVideoPageData.style);
    GdtLog.b("GdtMvElementsController", localStringBuilder.toString());
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V == null)
        {
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V = new GdtMvAnimation585V(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V.a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V.a(paramInt);
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V == null)
        {
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V = new GdtMvAnimation185V(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetButton, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V.a(paramInt);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H == null)
      {
        this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H = new GdtMvAnimation185H(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H.a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetButton, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a();
    long l = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a();
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a().b(2);
    if ((paramInt == 1) || (paramInt == 2131367579) || (paramInt == 2131362177))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[click ad btn] ");
      ((StringBuilder)localObject).append(localAdInfo);
      GdtLog.a("GdtMvElementsController", ((StringBuilder)localObject).toString());
      Activity localActivity = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a().a();
      if ((localAdInfo != null) && (localActivity != null))
      {
        localObject = localAdInfo.report_info.click_url.get();
        paramString = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper.a((String)localObject, l, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.b(), paramString);
        localAdInfo.report_info.click_url.set(paramString);
        n();
        if (paramInt != 1) {
          paramBoolean = a();
        }
        paramString = new StringBuilder();
        paramString.append("appAutoDownload:");
        paramString.append(paramBoolean);
        QLog.i("GdtMvElementsController", 1, paramString.toString());
        paramString = a(localAdInfo, localGdtMotiveVideoPageData, localActivity, paramBoolean);
        if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.b()) {
          paramInt = 48;
        } else {
          paramInt = 47;
        }
        paramString.jdField_b_of_type_Int = paramInt;
        ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(paramString);
        paramString = (String)localObject;
        break label279;
      }
    }
    paramString = "";
    label279:
    if ((!TextUtils.isEmpty(paramString)) && (localAdInfo != null)) {
      localAdInfo.report_info.click_url.set(paramString);
    }
    if (GdtADFlyingStreamingReportHelper.a().a() == 2)
    {
      GdtADFlyingStreamingReportHelper.a().a(1020015L);
      return;
    }
    if (GdtADFlyingStreamingReportHelper.a().a() == 1) {
      GdtADFlyingStreamingReportHelper.a().a(1020014L);
    }
  }
  
  public void a(GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMvMiniAppReportHelper = paramGdtMvMiniAppReportHelper;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    GdtMotiveVideoClickCoordinateReportHelper localGdtMotiveVideoClickCoordinateReportHelper = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper;
    if (localGdtMotiveVideoClickCoordinateReportHelper != null) {
      localGdtMotiveVideoClickCoordinateReportHelper.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
    if (localObject == null)
    {
      QLog.i("GdtMvElementsController", 1, "appAutoDownload() model is null");
      return false;
    }
    localObject = ((GdtMotiveVideoModel)localObject).a();
    if (localObject == null)
    {
      QLog.i("GdtMvElementsController", 1, "appAutoDownload() pageData is null");
      return false;
    }
    int[] arrayOfInt;
    int i;
    if (((GdtMotiveVideoPageData)localObject).screenOrientation == 1) {
      if (((GdtMotiveVideoPageData)localObject).vSize == 185)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject == null) {
          break label235;
        }
        arrayOfInt = new int[2];
        ((ImageView)localObject).getLocationOnScreen(arrayOfInt);
        i = arrayOfInt[1];
        if (this.jdField_b_of_type_Float < i) {
          break label235;
        }
      }
      else
      {
        if (((GdtMotiveVideoPageData)localObject).vSize != 585) {
          break label235;
        }
      }
    }
    int k;
    float f;
    do
    {
      return true;
      if ((((GdtMotiveVideoPageData)localObject).screenOrientation != 0) && (((GdtMotiveVideoPageData)localObject).screenOrientation != 8)) {
        break;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject == null) {
        break;
      }
      arrayOfInt = new int[2];
      ((Button)localObject).getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[0];
      int j = arrayOfInt[1];
      k = this.jdField_a_of_type_AndroidWidgetButton.getMeasuredWidth();
      int m = this.jdField_a_of_type_AndroidWidgetButton.getMeasuredHeight();
      f = this.jdField_b_of_type_Float;
      if ((f < j) || (f > m + j)) {
        break;
      }
      f = this.jdField_a_of_type_Float;
    } while ((f >= i) && (f <= k + i));
    label235:
    return false;
  }
  
  public void b()
  {
    AdButtonView localAdButtonView = this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView;
    if ((localAdButtonView != null) && (localAdButtonView.getButtonView() != null)) {
      this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView.getButtonView().setVisibility(8);
    }
  }
  
  public void c()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130840282);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(localDrawable);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167266);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(i);
  }
  
  public void d()
  {
    GdtLog.b("GdtMvElementsController", "enableMvBtnUrlStyleDefault");
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null)
    {
      localButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130840274));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    }
  }
  
  public void e()
  {
    String str = GdtMvElementsHelper.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel);
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setText(str);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localObject != null) {
      ((GdtAppReceiver)localObject).unregister(this.jdField_a_of_type_AndroidContentContext);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView = null;
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).clearAnimation();
      this.jdField_b_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton = null;
    }
    localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      ((LinearLayout)localObject).clearAnimation();
      this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V;
    if (localObject != null)
    {
      ((GdtMvAnimation585V)localObject).b();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation585V = null;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V;
    if (localObject != null)
    {
      ((GdtMvAnimation185V)localObject).b();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185V = null;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H;
    if (localObject != null)
    {
      ((GdtMvAnimation185H)localObject).b();
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvAnimation185H = null;
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper;
    if (localObject != null) {
      ((GdtMotiveVideoClickCoordinateReportHelper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityDestoryed();
    }
  }
  
  public void g()
  {
    GdtLog.a("GdtMvElementsController", "onResume: ");
    e();
    AdButtonController localAdButtonController = this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
    if (localAdButtonController != null) {
      localAdButtonController.onActivityResume();
    }
  }
  
  public void h()
  {
    GdtLog.a("GdtMvElementsController", "onPause: ");
    Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoReportGdtMotiveVideoClickCoordinateReportHelper;
    if (localObject != null) {
      ((GdtMotiveVideoClickCoordinateReportHelper)localObject).b(true);
    }
    localObject = this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityPaused();
    }
  }
  
  public void onClick(View paramView)
  {
    a(paramView.getId(), null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 9)
    {
      paramView = new StringBuilder();
      paramView.append("onHover ");
      paramView.append(paramMotionEvent.getAction());
      GdtLog.d("GdtMvElementsController", paramView.toString());
      a((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController
 * JD-Core Version:    0.7.0.1
 */