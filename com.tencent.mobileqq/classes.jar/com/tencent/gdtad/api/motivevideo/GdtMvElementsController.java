package com.tencent.gdtad.api.motivevideo;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragment4CmGame;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
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
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private GdtMotiveVideoClickCoordinateReportHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
  private GdtMvAnimation185H jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H;
  private GdtMvAnimation185V jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V;
  private GdtMvAnimation585V jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V;
  private GdtMvAppBtnView jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private GdtMvButtonHighLight jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight;
  private GdtMvDownloadBtnManager jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager;
  private GdtMvMiniAppReportHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper;
  private GdtMvViewController jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController;
  private String jdField_a_of_type_JavaLangString = null;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private GdtMvAppBtnView jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private String jdField_b_of_type_JavaLangString = null;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  
  public GdtMvElementsController(GdtMvViewController paramGdtMvViewController, View paramView, GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    GdtLog.a("GdtMvElementsController", "GdtMvElementsController: ");
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController = paramGdtMvViewController;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidContentContext = a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel = paramGdtMotiveVideoModel;
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper = new GdtMotiveVideoClickCoordinateReportHelper();
  }
  
  private static Context a(Context paramContext)
  {
    if ((paramContext == null) || ((paramContext instanceof Activity)) || (!(paramContext instanceof ContextThemeWrapper))) {
      return paramContext;
    }
    return a(((ContextThemeWrapper)paramContext).getBaseContext());
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidViewView.getContext());
    if (2 == paramInt) {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838622));
    }
    do
    {
      return localImageView;
      if (1 == paramInt)
      {
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838616));
        return localImageView;
      }
    } while (3 != paramInt);
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130838617));
    return localImageView;
  }
  
  private URLDrawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130845777);
    localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130845777);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int i = GdtUIUtils.a(140, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    paramString.setTag(URLDrawableDecodeHandler.b(i, i, GdtUIUtils.a(21, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext))));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.c);
    return paramString;
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    TextView localTextView;
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
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label85;
      }
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return this.jdField_b_of_type_JavaLangString;
      label85:
      localObject = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout)
  {
    int n = 0;
    if ((paramLinearLayout == null) || (paramDouble < 7.0D)) {}
    for (;;)
    {
      return;
      int j;
      int i;
      int m;
      LinearLayout.LayoutParams localLayoutParams;
      if (paramDouble < 8.0D)
      {
        j = 0;
        k = 4;
        i = 1;
        m = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidViewView.getResources());
        localLayoutParams = new LinearLayout.LayoutParams(m, m);
        m = 0;
        label63:
        if (m >= k) {
          break label153;
        }
        if (m != 0) {
          break label133;
        }
      }
      label133:
      for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidViewView.getResources()))
      {
        paramLinearLayout.addView(a(1), localLayoutParams);
        m += 1;
        break label63;
        if (paramDouble < 9.0D)
        {
          j = 1;
          k = 4;
          i = 0;
          break;
        }
        j = 0;
        k = 5;
        i = 0;
        break;
      }
      label153:
      int k = 0;
      for (;;)
      {
        m = n;
        if (k >= j) {
          break;
        }
        paramLinearLayout.addView(a(2), localLayoutParams);
        k += 1;
      }
      while (m < i)
      {
        paramLinearLayout.addView(a(3), localLayoutParams);
        m += 1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      localObject2 = new Rect();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getGlobalVisibleRect((Rect)localObject2);
      if ((this.jdField_c_of_type_AndroidViewView == null) || (!((Rect)localObject2).contains(paramInt1, paramInt2))) {
        break label63;
      }
      this.jdField_c_of_type_AndroidViewView.setContentDescription(b());
    }
    label63:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
        this.jdField_a_of_type_AndroidWidgetTextView.getGlobalVisibleRect((Rect)localObject2);
        if ((this.jdField_c_of_type_AndroidViewView != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
        {
          this.jdField_c_of_type_AndroidViewView.setContentDescription(((GdtMotiveVideoPageData)localObject1).bannerImgName);
          return;
        }
      } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
      this.jdField_b_of_type_AndroidWidgetTextView.getGlobalVisibleRect((Rect)localObject2);
    } while ((this.jdField_c_of_type_AndroidViewView == null) || (!((Rect)localObject2).contains(paramInt1, paramInt2)));
    Object localObject2 = this.jdField_c_of_type_AndroidViewView;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (localObject1 = ((GdtMotiveVideoPageData)localObject1).bannerBaseInfoText;; localObject1 = this.jdField_a_of_type_JavaLangString)
    {
      ((View)localObject2).setContentDescription((CharSequence)localObject1);
      return;
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
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if (!paramBoolean) {
          break label184;
        }
        i = 1334;
        if (paramBoolean)
        {
          j = GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext);
          localLayoutParams.height = GdtUIUtils.a(paramInt, i, j);
          this.jdField_b_of_type_AndroidViewView.setBackground(GdtUIUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165685), 8, 80));
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          GdtLog.b("GdtMvElementsController", "initDesMaskPositions " + paramInt + "|" + paramBoolean);
          return;
        }
        int j = GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext);
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      catch (Throwable localThrowable)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        GdtLog.d("GdtMvElementsController", "initDesMaskPositions error! ", localThrowable);
        return;
      }
      return;
      label184:
      int i = 750;
    }
  }
  
  private void a(String paramString)
  {
    double d1 = 10.0D;
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        GdtLog.a("GdtMvElementsController", "updateScoreAndStar " + paramString);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165561));
        float f = 0.0F;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null) {
          f = this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
        }
        GdtLog.a("GdtMvElementsController", "updateScoreAndStar " + this.jdField_b_of_type_AndroidWidgetTextView.getWidth() + " mw " + f);
        int i = Math.max((int)f, this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
        this.jdField_c_of_type_AndroidWidgetTextView.setWidth(i);
      }
    }
    else {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(500);
    if (localGdtMotiveVideoPageData.appScore < 7.0D) {
      if (Double.compare(localGdtMotiveVideoPageData.appScore, 0.0D) == 0) {
        if (b())
        {
          paramString = "精品推荐 ";
          localStringBuilder.append(paramString);
          label264:
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          label280:
          if (localGdtMotiveVideoPageData.downloadNum >= 100000L) {
            break label451;
          }
          if (0L != localGdtMotiveVideoPageData.downloadNum) {
            break label439;
          }
          if (!b()) {
            break label432;
          }
          paramString = "热门下载";
          label313:
          localStringBuilder.append(paramString);
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      return;
      paramString = "精品内容 ";
      break;
      localStringBuilder.append("精品推荐 ");
      break label264;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label280;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      a(localGdtMotiveVideoPageData.appScore, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      paramString = new DecimalFormat("0.0");
      if (localGdtMotiveVideoPageData.appScore > 10.0D) {}
      for (;;)
      {
        localStringBuilder.append(paramString.format(d1)).append("分 ");
        break;
        d1 = localGdtMotiveVideoPageData.appScore;
      }
      label432:
      paramString = "热门推荐";
      break label313;
      label439:
      localStringBuilder.append("热门下载 ");
      continue;
      label451:
      if (localGdtMotiveVideoPageData.downloadNum < 100000000L) {
        localStringBuilder.append(new BigDecimal(localGdtMotiveVideoPageData.downloadNum / 10000.0D).setScale(0, 4)).append("万");
      }
      for (;;)
      {
        if (!b()) {
          break label553;
        }
        localStringBuilder.append("次下载");
        break;
        localStringBuilder.append(new BigDecimal(localGdtMotiveVideoPageData.downloadNum / 100000000.0D).setScale(1, 4)).append("亿");
      }
      label553:
      localStringBuilder.append("次浏览");
    }
  }
  
  private String b()
  {
    String str2 = HardCodeUtil.a(2131705223);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (!((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get().isEmpty())
      {
        str2 = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.button_info.get(0)).txt.get();
        localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).app_info.app_package_name.get();
        GdtLog.b("GdtMvElementsController", "getContentStrByStyle pushName " + str2);
        if (TextUtils.isEmpty(str2)) {
          break label165;
        }
        str1 = str2;
        if (b())
        {
          str1 = str2;
          if (NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject))
          {
            if (!localGdtMotiveVideoPageData.isStyleC()) {
              break label158;
            }
            str1 = HardCodeUtil.a(2131705218);
          }
        }
      }
    }
    return str1;
    label158:
    return HardCodeUtil.a(2131705219);
    label165:
    if (b())
    {
      if (NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject)) {
        return HardCodeUtil.a(2131705220);
      }
      return HardCodeUtil.a(2131705222);
    }
    return HardCodeUtil.a(2131705224);
  }
  
  private boolean b()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    return (localGdtMotiveVideoPageData.productType == 12) || (localGdtMotiveVideoPageData.productType == 19);
  }
  
  private void i()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
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
    localLayoutParams.width = GdtUIUtils.a(140, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = GdtUIUtils.a(1054, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(1063, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(1111, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(1160, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    localLayoutParams.height = GdtUIUtils.a(80, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = GdtUIUtils.a(1224, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    localLayoutParams.height = GdtUIUtils.a(129, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = GdtUIUtils.a(1199, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(5, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    GdtLog.a("GdtMvElementsController", "inti585Vpositions() urlBtnLp2.topMargin = " + localLayoutParams.topMargin + ", urlBtnLp2.height = " + localLayoutParams.height);
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height = GdtUIUtils.a(315, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void k()
  {
    a(400, false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = GdtUIUtils.a(140, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = GdtUIUtils.a(580, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(589, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(637, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.a(685, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(196, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    localLayoutParams.height = GdtUIUtils.a(80, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = GdtUIUtils.a(611, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(1034, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = GdtUIUtils.a(30, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    localLayoutParams.height = GdtUIUtils.a(129, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.topMargin = GdtUIUtils.a(586, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(1009, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = GdtUIUtils.a(5, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height = GdtUIUtils.a(200, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).topMargin = GdtUIUtils.a(742, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLayoutParams();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setHeight(GdtUIUtils.a(80, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    localLayoutParams.topMargin = GdtUIUtils.a(1224, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(30, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    this.jdField_a_of_type_AndroidWidgetButton.setHeight(GdtUIUtils.a(129, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext)));
    localLayoutParams.topMargin = GdtUIUtils.a(1199, 1334, GdtUIUtils.e(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.leftMargin = GdtUIUtils.a(5, 750, GdtUIUtils.f(this.jdField_a_of_type_AndroidContentContext));
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
  }
  
  private void m()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (TextUtils.isEmpty(localGdtMotiveVideoPageData.bannerLogo)) {
        break label111;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(localGdtMotiveVideoPageData.bannerLogo));
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a(localGdtMotiveVideoPageData.bannerLogo));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localGdtMotiveVideoPageData.bannerImgName);
        if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localGdtMotiveVideoPageData.bannerImgName);
        }
      }
      a(a());
      d();
      return;
      label111:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845777);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845777);
      }
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper != null)) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper);
    }
  }
  
  private void o()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    Activity localActivity = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a().a();
    if (localActivity != null)
    {
      GdtLog.b("GdtMvElementsController", "doHandleClick");
      GdtHandler.a(a(localAdInfo, localGdtMotiveVideoPageData, localActivity));
    }
  }
  
  public GdtHandler.Params a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Activity paramActivity)
  {
    return a(paramAdInfo, paramGdtMotiveVideoPageData, paramActivity, true);
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
    localParams.jdField_a_of_type_JavaLangClass = null;
    localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragment4CmGame.class;
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
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362236);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362119));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362121));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362139));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362141));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362057));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362060));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362130));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight = ((GdtMvButtonHighLight)this.jdField_a_of_type_AndroidViewView.findViewById(2131362148));
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = ((GdtMvAppBtnView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362153));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = ((GdtMvAppBtnView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362152));
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView);
    }
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
    {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362149));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362132));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381389));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367811);
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnHoverListener(this);
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367812);
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    }
    if ((((GdtMotiveVideoPageData)localObject).vSize != 585) && (((GdtMotiveVideoPageData)localObject).screenOrientation == 1)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363786));
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362117));
    i();
    m();
    localObject = b();
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a((String)localObject);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a((String)localObject);
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = new GdtMvDownloadBtnManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a(), (String)localObject, this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.f();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(new GdtMvElementsController.1(this));
  }
  
  public void a(int paramInt)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    GdtLog.b("GdtMvElementsController", "adjustViewsPosition " + paramInt + " style " + localGdtMotiveVideoPageData.style);
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.a();
    }
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V == null)
        {
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V = new GdtMvAnimation585V(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V.a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V.a(paramInt);
      }
      while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V == null)
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V = new GdtMvAnimation185V(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V.a(paramInt);
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H == null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H = new GdtMvAnimation185H(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H.a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_c_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H.a(paramInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
    long l = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a();
    String str2 = "";
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a().b(2);
    String str1;
    switch (paramInt)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str1)) && (localAdInfo != null)) {
        localAdInfo.report_info.click_url.set(str1);
      }
      return;
      GdtLog.a("GdtMvElementsController", "[click ad btn] " + localAdInfo);
      Activity localActivity = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a().a();
      str1 = str2;
      if (localAdInfo != null)
      {
        str1 = str2;
        if (localActivity != null)
        {
          str1 = localAdInfo.report_info.click_url.get();
          paramString = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(str1, l, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.b(), paramString);
          localAdInfo.report_info.click_url.set(paramString);
          n();
          if (paramInt == 1)
          {
            label254:
            QLog.i("GdtMvElementsController", 1, "appAutoDownload:" + paramBoolean);
            paramString = a(localAdInfo, localGdtMotiveVideoPageData, localActivity, paramBoolean);
            if (!this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.b()) {
              break label325;
            }
          }
          label325:
          for (paramInt = 48;; paramInt = 47)
          {
            paramString.jdField_b_of_type_Int = paramInt;
            GdtHandler.a(paramString);
            break;
            paramBoolean = a();
            break label254;
          }
          GdtLog.a("GdtMvElementsController", "[click ad download btn] ");
          str1 = str2;
          if (localAdInfo != null)
          {
            str1 = localAdInfo.report_info.click_url.get();
            paramString = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(str1, l, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.b(), paramString);
            localAdInfo.report_info.click_url.set(paramString);
            n();
            if ((localAdInfo.exp_info.reward_video_download_type.get() == 1) && (localAdInfo.product_type.get() == 12) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null))
            {
              paramString = localAdInfo.app_info.app_package_name.get();
              if (NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString)) {
                o();
              } else {
                this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a();
              }
            }
            else
            {
              o();
            }
          }
        }
      }
    }
  }
  
  public void a(GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvMiniAppReportHelper = paramGdtMvMiniAppReportHelper;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) {
      QLog.i("GdtMvElementsController", 1, "appAutoDownload() model is null");
    }
    label127:
    do
    {
      do
      {
        do
        {
          return false;
          localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a();
          if (localObject == null)
          {
            QLog.i("GdtMvElementsController", 1, "appAutoDownload() pageData is null");
            return false;
          }
          if (((GdtMotiveVideoPageData)localObject).screenOrientation != 1) {
            break label127;
          }
          if (((GdtMotiveVideoPageData)localObject).vSize != 185) {
            break;
          }
        } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
        localObject = new int[2];
        this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
        i = localObject[1];
        if (this.jdField_b_of_type_Float >= i) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      } while (((GdtMotiveVideoPageData)localObject).vSize != 585);
      return true;
    } while (((((GdtMotiveVideoPageData)localObject).screenOrientation != 0) && (((GdtMotiveVideoPageData)localObject).screenOrientation != 8)) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight == null));
    Object localObject = new int[2];
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    int k = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getMeasuredWidth();
    int m = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.getMeasuredHeight();
    if ((this.jdField_b_of_type_Float >= j) && (this.jdField_b_of_type_Float <= m + j) && (this.jdField_a_of_type_Float >= i) && (this.jdField_a_of_type_Float <= k + i)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void b()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130840411);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setBackgroundDrawable(localDrawable);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167235);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setTextColor(i);
  }
  
  public void c()
  {
    GdtLog.b("GdtMvElementsController", "enableMvBtnUrlStyleDefault");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setBackgroundDrawable(this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130840400));
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167374));
    }
  }
  
  public void d()
  {
    String str = b();
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null) && (this.jdField_a_of_type_AndroidWidgetButton != null))
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    if (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(str);
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(str);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight.a();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvButtonHighLight = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V.b();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation585V = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V.b();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185V = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H.b();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAnimation185H = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null)
    {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.b();
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.a();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.c();
    }
  }
  
  public void g()
  {
    GdtLog.a("GdtMvElementsController", "onResume: ");
    d();
    f();
  }
  
  public void h()
  {
    GdtLog.a("GdtMvElementsController", "onPause: ");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoClickCoordinateReportHelper.b(true);
    }
  }
  
  public void onClick(View paramView)
  {
    a(paramView.getId(), null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      GdtLog.d("GdtMvElementsController", "onHover " + paramMotionEvent.getAction());
      a((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvElementsController
 * JD-Core Version:    0.7.0.1
 */