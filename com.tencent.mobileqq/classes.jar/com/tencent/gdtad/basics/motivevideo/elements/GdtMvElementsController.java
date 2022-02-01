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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
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
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer.Params;
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
import tencent.gdt.qq_common.FloatingTip;

public class GdtMvElementsController
  implements View.OnClickListener, View.OnHoverListener
{
  private GdtMvAnimation585V A;
  private GdtMvAnimation185V B;
  private GdtMvAnimation185H C;
  private GdtMvAnimation585HNew D;
  private String E = null;
  private String F = null;
  public GdtThirdProcessorProxy a;
  private GdtMvViewController b;
  private Context c;
  private View d;
  private RelativeLayout e;
  private View f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private Button j;
  private TextView k;
  private LinearLayout l;
  private RelativeLayout m;
  private LinearLayout n;
  private View o;
  private FrameLayout p;
  private FrameLayout q;
  private GdtAppReceiver r;
  private float s;
  private float t;
  private GdtMotiveVideoModel u;
  private GdtMotiveVideoClickCoordinateReportHelper v;
  private GdtMvMiniAppReportHelper w;
  private AdButtonView x;
  private AdButtonController y;
  private boolean z;
  
  public GdtMvElementsController(GdtMvViewController paramGdtMvViewController, View paramView, GdtMotiveVideoModel paramGdtMotiveVideoModel, GdtThirdProcessorProxy paramGdtThirdProcessorProxy)
  {
    GdtLog.a("GdtMvElementsController", "GdtMvElementsController: ");
    this.b = paramGdtMvViewController;
    this.d = paramView;
    this.c = paramView.getContext();
    this.c = a(this.c);
    this.u = paramGdtMotiveVideoModel;
    this.v = new GdtMotiveVideoClickCoordinateReportHelper();
    this.a = paramGdtThirdProcessorProxy;
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
  
  private static AdFloatTipsViewContainer.Params a(Context paramContext, qq_common.FloatingTip paramFloatingTip, boolean paramBoolean)
  {
    AdFloatTipsViewContainer.Params localParams = new AdFloatTipsViewContainer.Params();
    if ((paramFloatingTip != null) && (!TextUtils.isEmpty(paramFloatingTip.text.get()))) {
      localParams.text = paramFloatingTip.text.get();
    }
    int i1;
    if ((paramFloatingTip != null) && (paramBoolean)) {
      i1 = -1;
    } else {
      i1 = 0;
    }
    localParams.textColor = i1;
    localParams.textSize = GdtUIUtils.b(16, 1624, GdtUIUtils.d(paramContext));
    localParams.iconSize = b(paramContext);
    if ((paramFloatingTip != null) && (paramBoolean)) {
      paramContext = ((qq_common.FloatingTip)paramFloatingTip.get()).icon_url.get();
    } else {
      paramContext = null;
    }
    localParams.iconUrl = paramContext;
    return localParams;
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout != null)
    {
      if (paramDouble < 7.0D) {
        return;
      }
      int i1 = 4;
      int i5 = 0;
      int i2;
      int i3;
      if (paramDouble < 8.0D)
      {
        i2 = 0;
        i3 = 1;
      }
      else
      {
        if (paramDouble < 9.0D)
        {
          i2 = 1;
        }
        else
        {
          i1 = 5;
          i2 = 0;
        }
        i3 = 0;
      }
      int i4 = ViewUtils.dip2px(15.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i4, i4);
      i4 = 0;
      while (i4 < i1)
      {
        if (i4 == 0) {
          localLayoutParams.leftMargin = 0;
        } else {
          localLayoutParams.leftMargin = ViewUtils.dip2px(3.0F);
        }
        paramLinearLayout.addView(b(1), localLayoutParams);
        i4 += 1;
      }
      i1 = 0;
      for (;;)
      {
        i4 = i5;
        if (i1 >= i2) {
          break;
        }
        paramLinearLayout.addView(b(2), localLayoutParams);
        i1 += 1;
      }
      while (i4 < i3)
      {
        paramLinearLayout.addView(b(3), localLayoutParams);
        i4 += 1;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.u.a();
    if (this.j != null)
    {
      Object localObject2 = new Rect();
      this.j.getGlobalVisibleRect((Rect)localObject2);
      if ((this.o != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
      {
        this.o.setContentDescription(GdtMvElementsHelper.a(this.u));
        return;
      }
      TextView localTextView = this.h;
      if (localTextView != null)
      {
        localTextView.getGlobalVisibleRect((Rect)localObject2);
        if ((this.o != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
        {
          this.o.setContentDescription(((GdtMotiveVideoPageData)localObject1).bannerImgName);
          return;
        }
        localTextView = this.i;
        if (localTextView != null)
        {
          localTextView.getGlobalVisibleRect((Rect)localObject2);
          if ((this.o != null) && (((Rect)localObject2).contains(paramInt1, paramInt2)))
          {
            localObject2 = this.o;
            if (TextUtils.isEmpty(this.E)) {
              localObject1 = ((GdtMotiveVideoPageData)localObject1).bannerBaseInfoText;
            } else {
              localObject1 = this.E;
            }
            ((View)localObject2).setContentDescription((CharSequence)localObject1);
          }
        }
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.f != null) {
      if (Build.VERSION.SDK_INT < 16) {}
    }
    for (;;)
    {
      try
      {
        Object localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        if (!paramBoolean) {
          break label203;
        }
        i1 = 1334;
        int i2;
        if (paramBoolean) {
          i2 = GdtUIUtils.d(this.c);
        } else {
          i2 = GdtUIUtils.e(this.c);
        }
        ((RelativeLayout.LayoutParams)localObject).height = GdtUIUtils.b(paramInt, i1, i2);
        this.f.setBackground(GdtUIUtils.a(this.c.getResources().getColor(2131166136), 8, 80));
        this.f.setVisibility(0);
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
        this.f.setVisibility(8);
        GdtLog.d("GdtMvElementsController", "initDesMaskPositions error! ", localThrowable);
        return;
      }
      this.f.setVisibility(8);
      return;
      label203:
      int i1 = 750;
    }
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    paramGdtMotiveVideoPageData = a(this.u.b(), paramGdtMotiveVideoPageData, this.b.q().b(), g());
    if ((this.u.d().isHitDownloadLayer()) && (AdClickUtil.isValidForApp(GdtHandler.b(paramGdtMotiveVideoPageData))))
    {
      int i1 = AdUIUtils.getValueDependsOnScreenWidth(this.c, 750, 584);
      int i2 = AdUIUtils.getValueDependsOnScreenWidth(this.c, 750, 80);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      this.x = new AdButtonView(this.c, i1, i2);
      this.x.getButtonView().setId(2131434114);
      this.y = new AdButtonController(GdtHandler.b(paramGdtMotiveVideoPageData));
      this.y.registerView(new WeakReference(this.x), true);
      localLayoutParams.width = i1;
      localLayoutParams.height = i2;
      localLayoutParams.addRule(14);
      ((ViewGroup)this.d).addView(this.x.getButtonView(), localLayoutParams);
      this.j.setVisibility(4);
    }
  }
  
  private void a(String paramString)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.u.a();
    if (this.k != null)
    {
      int i1;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateScoreAndStar ");
        ((StringBuilder)localObject).append(paramString);
        GdtLog.a("GdtMvElementsController", ((StringBuilder)localObject).toString());
        localObject = this.l;
        if (localObject != null) {
          ((LinearLayout)localObject).setVisibility(8);
        }
        this.k.setText(paramString);
        this.k.setTextSize(14.0F);
        this.k.setTextColor(this.c.getResources().getColor(2131165877));
        float f1 = 0.0F;
        if (this.i.getText() != null) {
          f1 = this.i.getPaint().measureText(this.i.getText().toString());
        }
        paramString = new StringBuilder();
        paramString.append("updateScoreAndStar ");
        paramString.append(this.i.getWidth());
        paramString.append(" mw ");
        paramString.append(f1);
        GdtLog.a("GdtMvElementsController", paramString.toString());
        i1 = Math.max((int)f1, this.i.getWidth());
        this.k.setWidth(i1);
        return;
      }
      Object localObject = new StringBuilder(500);
      double d1;
      if (localGdtMotiveVideoPageData.appScore < 7.0D)
      {
        i1 = Double.compare(localGdtMotiveVideoPageData.appScore, 0.0D);
        paramString = "精品推荐 ";
        if (i1 == 0)
        {
          if (!GdtMvElementsHelper.b(this.u)) {
            paramString = "精品内容 ";
          }
          ((StringBuilder)localObject).append(paramString);
        }
        else
        {
          ((StringBuilder)localObject).append("精品推荐 ");
        }
        paramString = this.l;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
      else
      {
        paramString = this.l;
        if (paramString != null)
        {
          paramString.setVisibility(0);
          a(localGdtMotiveVideoPageData.appScore, this.l);
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
          if (GdtMvElementsHelper.b(this.u)) {
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
        if (GdtMvElementsHelper.b(this.u)) {
          ((StringBuilder)localObject).append("次下载");
        } else {
          ((StringBuilder)localObject).append("次浏览");
        }
      }
      this.k.setText(((StringBuilder)localObject).toString());
    }
  }
  
  private static int b(Context paramContext)
  {
    return GdtUIUtils.b(20, 1624, GdtUIUtils.d(paramContext));
  }
  
  private ImageView b(int paramInt)
  {
    ImageView localImageView = new ImageView(this.d.getContext());
    if (2 == paramInt)
    {
      localImageView.setImageDrawable(this.d.getContext().getResources().getDrawable(2130838522));
      return localImageView;
    }
    if (1 == paramInt)
    {
      localImageView.setImageDrawable(this.d.getContext().getResources().getDrawable(2130838516));
      return localImageView;
    }
    if (3 == paramInt) {
      localImageView.setImageDrawable(this.d.getContext().getResources().getDrawable(2130838517));
    }
    return localImageView;
  }
  
  private static int c(Context paramContext)
  {
    return GdtUIUtils.b(20, 1624, GdtUIUtils.d(paramContext));
  }
  
  private void k()
  {
    Object localObject1 = this.u.d().getFloatingTips(1);
    Object localObject2 = this.u.d().getFloatingTips(2);
    this.p = ((FrameLayout)this.d.findViewById(2131427749));
    this.q = ((FrameLayout)this.d.findViewById(2131434122));
    if ((localObject1 == null) && (localObject2 == null))
    {
      this.p.setVisibility(8);
      this.q.setVisibility(8);
      return;
    }
    Object localObject3 = this.c;
    localObject3 = new AdFloatTipsViewContainer((Context)localObject3, a((Context)localObject3, (qq_common.FloatingTip)localObject1, true), a(this.c, (qq_common.FloatingTip)localObject2, true));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.p.addView((View)localObject3, localLayoutParams);
    if (localObject2 == null)
    {
      this.q.setVisibility(8);
      return;
    }
    localObject3 = this.c;
    localObject1 = new AdFloatTipsViewContainer((Context)localObject3, a((Context)localObject3, (qq_common.FloatingTip)localObject1, false), a(this.c, (qq_common.FloatingTip)localObject2, false));
    localObject2 = new FrameLayout.LayoutParams(-1, -1);
    this.q.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((AdFloatTipsViewContainer)localObject1).getIndustrialView().setOnClickListener(new GdtMvElementsController.2(this));
  }
  
  private void l()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.u.a();
    if (localGdtMotiveVideoPageData.screenOrientation == 1)
    {
      if (localGdtMotiveVideoPageData.vSize == 585)
      {
        m();
        return;
      }
      p();
      return;
    }
    if ((localGdtMotiveVideoPageData.vSize == 585) && (this.u.d().isHitNew585Style()))
    {
      o();
      return;
    }
    n();
  }
  
  private void m()
  {
    a(700, true);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams1.width = GdtUIUtils.b(140, 750, GdtUIUtils.e(this.c));
    localLayoutParams1.height = localLayoutParams1.width;
    localLayoutParams1.topMargin = (GdtUIUtils.b(1054, 1334, GdtUIUtils.d(this.c)) - b(this.c) - c(this.c));
    localLayoutParams1.leftMargin = GdtUIUtils.b(30, 750, GdtUIUtils.e(this.c));
    localLayoutParams1 = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams1.topMargin = (GdtUIUtils.b(1063, 1334, GdtUIUtils.d(this.c)) - b(this.c) - c(this.c));
    localLayoutParams1.leftMargin = GdtUIUtils.b(196, 750, GdtUIUtils.e(this.c));
    localLayoutParams1 = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams1.topMargin = (GdtUIUtils.b(1111, 1334, GdtUIUtils.d(this.c)) - b(this.c) - c(this.c));
    localLayoutParams1.leftMargin = GdtUIUtils.b(196, 750, GdtUIUtils.e(this.c));
    localLayoutParams1 = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    localLayoutParams1.topMargin = (GdtUIUtils.b(1160, 1334, GdtUIUtils.d(this.c)) - b(this.c) - c(this.c));
    localLayoutParams1.leftMargin = GdtUIUtils.b(196, 750, GdtUIUtils.e(this.c));
    localLayoutParams1 = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams1.height = GdtUIUtils.b(80, 1334, GdtUIUtils.d(this.c));
    localLayoutParams1.topMargin = (GdtUIUtils.b(1224, 1334, GdtUIUtils.d(this.c)) - b(this.c) - c(this.c));
    localLayoutParams1.leftMargin = GdtUIUtils.b(30, 750, GdtUIUtils.e(this.c));
    localLayoutParams1.rightMargin = localLayoutParams1.leftMargin;
    ((RelativeLayout.LayoutParams)this.o.getLayoutParams()).height = (GdtUIUtils.b(315, 1334, GdtUIUtils.d(this.c)) + b(this.c) + c(this.c));
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    localLayoutParams2.height = b(this.c);
    localLayoutParams2.topMargin = c(this.c);
    localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2 = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
    localLayoutParams2.height = b(this.c);
    localLayoutParams2.topMargin = c(this.c);
    localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
  }
  
  private void n()
  {
    a(400, false);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams1.width = GdtUIUtils.b(140, 750, GdtUIUtils.e(this.c));
    localLayoutParams1.height = localLayoutParams1.width;
    localLayoutParams1.topMargin = (GdtUIUtils.b(580, 750, GdtUIUtils.e(this.c)) - b(this.c) - c(this.c));
    localLayoutParams1.leftMargin = GdtUIUtils.b(30, 1334, GdtUIUtils.d(this.c));
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams2.topMargin = (GdtUIUtils.b(589, 750, GdtUIUtils.e(this.c)) - b(this.c) - c(this.c));
    localLayoutParams2.leftMargin = GdtUIUtils.b(196, 1334, GdtUIUtils.d(this.c));
    localLayoutParams2 = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams2.topMargin = (GdtUIUtils.b(637, 750, GdtUIUtils.e(this.c)) - b(this.c) - c(this.c));
    localLayoutParams2.leftMargin = GdtUIUtils.b(196, 1334, GdtUIUtils.d(this.c));
    localLayoutParams2 = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    localLayoutParams2.topMargin = (GdtUIUtils.b(685, 750, GdtUIUtils.e(this.c)) - b(this.c) - c(this.c));
    localLayoutParams2.leftMargin = GdtUIUtils.b(196, 1334, GdtUIUtils.d(this.c));
    localLayoutParams2 = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams2.height = GdtUIUtils.b(80, 1334, GdtUIUtils.d(this.c));
    localLayoutParams2.topMargin = (GdtUIUtils.b(611, 750, GdtUIUtils.e(this.c)) - b(this.c) - c(this.c));
    localLayoutParams2.leftMargin = GdtUIUtils.b(1034, 1334, GdtUIUtils.d(this.c));
    localLayoutParams2.rightMargin = GdtUIUtils.b(30, 1334, GdtUIUtils.d(this.c));
    ((RelativeLayout.LayoutParams)this.o.getLayoutParams()).height = (GdtUIUtils.b(200, 750, GdtUIUtils.e(this.c)) + b(this.c) + c(this.c));
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    localLayoutParams3.height = b(this.c);
    localLayoutParams3.topMargin = c(this.c);
    localLayoutParams3.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams3.rightMargin = localLayoutParams2.rightMargin;
    localLayoutParams3 = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
    localLayoutParams3.height = b(this.c);
    localLayoutParams3.topMargin = c(this.c);
    localLayoutParams3.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams3.rightMargin = localLayoutParams2.rightMargin;
  }
  
  private void o()
  {
    ((RelativeLayout.LayoutParams)((RelativeLayout)this.d.findViewById(2131427663)).getLayoutParams()).height = GdtUIUtils.b(750, 750, GdtUIUtils.e(this.c));
    a(400, false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams.width = GdtUIUtils.b(172, 750, GdtUIUtils.e(this.c));
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.topMargin = GdtUIUtils.b(128, 750, GdtUIUtils.e(this.c));
    ((RelativeLayout.LayoutParams)this.h.getLayoutParams()).topMargin = GdtUIUtils.b(14, 750, GdtUIUtils.e(this.c));
    localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams.topMargin = GdtUIUtils.b(18, 750, GdtUIUtils.e(this.c));
    localLayoutParams.leftMargin = GdtUIUtils.b(97, 1334, GdtUIUtils.d(this.c));
    localLayoutParams.rightMargin = GdtUIUtils.b(97, 1334, GdtUIUtils.d(this.c));
    localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    this.j.setHeight(GdtUIUtils.b(80, 1334, GdtUIUtils.d(this.c)));
    localLayoutParams.width = GdtUIUtils.b(440, 1334, GdtUIUtils.d(this.c));
    localLayoutParams.topMargin = GdtUIUtils.b(76, 750, GdtUIUtils.e(this.c));
    localLayoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    localLayoutParams.height = b(this.c);
    localLayoutParams.topMargin = GdtUIUtils.b(691, 750, GdtUIUtils.e(this.c));
    localLayoutParams.leftMargin = GdtUIUtils.b(30, 1334, GdtUIUtils.d(this.c));
    localLayoutParams.rightMargin = GdtUIUtils.b(30, 1334, GdtUIUtils.d(this.c));
    localLayoutParams = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
    localLayoutParams.height = b(this.c);
    localLayoutParams.topMargin = GdtUIUtils.b(691, 750, GdtUIUtils.e(this.c));
    localLayoutParams.leftMargin = GdtUIUtils.b(30, 1334, GdtUIUtils.d(this.c));
    localLayoutParams.rightMargin = GdtUIUtils.b(30, 1334, GdtUIUtils.d(this.c));
  }
  
  private void p()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).topMargin = GdtUIUtils.b(742, 1334, GdtUIUtils.d(this.c));
    }
    localObject = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    this.j.setHeight(GdtUIUtils.b(80, 1334, GdtUIUtils.d(this.c)));
    ((RelativeLayout.LayoutParams)localObject).topMargin = (GdtUIUtils.b(1224, 1334, GdtUIUtils.d(this.c)) - b(this.c) - c(this.c));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.b(30, 750, GdtUIUtils.e(this.c));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((RelativeLayout.LayoutParams)localObject).leftMargin;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    localLayoutParams.height = b(this.c);
    localLayoutParams.topMargin = c(this.c);
    localLayoutParams.leftMargin = ((RelativeLayout.LayoutParams)localObject).leftMargin;
    localLayoutParams.rightMargin = ((RelativeLayout.LayoutParams)localObject).rightMargin;
    localLayoutParams = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
    localLayoutParams.height = b(this.c);
    localLayoutParams.topMargin = c(this.c);
    localLayoutParams.leftMargin = ((RelativeLayout.LayoutParams)localObject).leftMargin;
    localLayoutParams.rightMargin = ((RelativeLayout.LayoutParams)localObject).rightMargin;
  }
  
  private void q()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.u.a();
    if (this.g != null)
    {
      int i1 = GdtUIUtils.b(140, 750, GdtUIUtils.e(this.c));
      int i2 = GdtUIUtils.b(21, 750, GdtUIUtils.e(this.c));
      localObject = this.a.a(this.c, this.u.a(), i1, i2);
      if (localObject != null) {
        this.g.setImageDrawable((Drawable)localObject);
      }
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((TextView)localObject).setText(localGdtMotiveVideoPageData.bannerImgName);
    }
    a(r());
    f();
  }
  
  private String r()
  {
    Object localObject = this.u.a();
    if (this.i != null)
    {
      localObject = ((GdtMotiveVideoPageData)localObject).bannerBaseInfoText;
      if (this.u.d().isHitNew585Style())
      {
        localTextView = this.i;
        if (!TextUtils.isEmpty(this.E)) {
          localObject = this.E;
        }
        localTextView.setText((CharSequence)localObject);
        return null;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i1 = ((String)localObject).length();
        if (i1 > 16)
        {
          this.E = ((String)localObject).substring(0, 16);
          this.F = ((String)localObject).substring(16, i1);
        }
      }
      TextView localTextView = this.i;
      if (!TextUtils.isEmpty(this.E)) {
        localObject = this.E;
      }
      localTextView.setText((CharSequence)localObject);
    }
    return this.F;
  }
  
  private void s()
  {
    GdtMvMiniAppReportHelper localGdtMvMiniAppReportHelper = this.w;
    if (localGdtMvMiniAppReportHelper != null)
    {
      GdtMvViewController localGdtMvViewController = this.b;
      if ((localGdtMvViewController != null) && (this.v != null)) {
        localGdtMvMiniAppReportHelper.a(localGdtMvViewController.c(), this.v);
      }
    }
  }
  
  public GdtHandler.Params a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Activity paramActivity, boolean paramBoolean)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.q = paramGdtMotiveVideoPageData.processId;
    localParams.r = new WeakReference(paramActivity);
    if (paramAdInfo != null) {
      localParams.a = new GdtAd(paramAdInfo);
    }
    if (this.r == null)
    {
      this.r = new GdtAppReceiver();
      this.r.register(this.c);
    }
    localParams.b = true;
    localParams.e = paramBoolean;
    localParams.s = new WeakReference(this.r);
    localParams.p = new Bundle();
    paramGdtMotiveVideoPageData = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
    paramAdInfo = paramGdtMotiveVideoPageData;
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtMvElementsController", 1, "getClickParam refId is empty");
      paramAdInfo = paramActivity.getIntent().getStringExtra("big_brother_source_key");
    }
    if (!TextUtils.isEmpty(paramAdInfo)) {
      localParams.p.putString("big_brother_ref_source_key", paramAdInfo);
    }
    return localParams;
  }
  
  public void a()
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.u.a();
    this.f = this.d.findViewById(2131427846);
    this.g = ((ImageView)this.d.findViewById(2131427729));
    this.h = ((TextView)this.d.findViewById(2131427750));
    this.i = ((TextView)this.d.findViewById(2131427664));
    this.k = ((TextView)this.d.findViewById(2131427738));
    this.j = ((Button)this.d.findViewById(2131427758));
    a(localGdtMotiveVideoPageData, this.z);
    Object localObject = this.j;
    if (localObject != null)
    {
      ((Button)localObject).setOnClickListener(this);
      this.v.a(this.j);
    }
    this.l = ((LinearLayout)this.d.findViewById(2131427740));
    this.m = ((RelativeLayout)this.d.findViewById(2131449605));
    this.o = this.d.findViewById(2131434121);
    localObject = this.o;
    if (localObject != null)
    {
      this.v.a((View)localObject);
      this.o.setOnClickListener(this);
      this.o.setOnHoverListener(this);
    }
    k();
    if ((localGdtMotiveVideoPageData.vSize != 585) && (localGdtMotiveVideoPageData.screenOrientation == 1)) {
      this.e = ((RelativeLayout)this.d.findViewById(2131429639));
    }
    this.n = ((LinearLayout)this.d.findViewById(2131427724));
    l();
    q();
    this.v.a(new GdtMvElementsController.1(this));
  }
  
  public void a(int paramInt)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.u.a();
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
        if (this.A == null)
        {
          this.A = new GdtMvAnimation585V(this.c);
          this.A.a(this.f, this.m, this.j, this.g, this.h, this.i, this.n, this.o);
        }
        this.A.a(paramInt);
        return;
      }
      if (this.e != null)
      {
        if (this.B == null)
        {
          this.B = new GdtMvAnimation185V(this.c);
          this.B.a(this.e, this.j, this.m, this.o);
        }
        this.B.a(paramInt);
      }
    }
    else if ((localGdtMotiveVideoPageData.vSize == 585) && (this.u.d().isHitNew585Style()))
    {
      if (this.D == null)
      {
        this.D = new GdtMvAnimation585HNew(this.c);
        this.D.a(this.m, (ViewGroup)this.d.findViewById(2131427663), this.j, this.g, this.h, this.i, this.o);
      }
    }
    else
    {
      if (this.C == null)
      {
        this.C = new GdtMvAnimation185H(this.c);
        this.C.a(this.f, this.m, this.j, this.g, this.h, this.i, this.n, this.o);
      }
      this.C.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.u.a();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.u.b();
    long l1 = this.b.c();
    this.b.r().b(2);
    if ((paramInt == 1) || (paramInt == 2131434121) || (paramInt == 2131427758))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[click ad btn] ");
      ((StringBuilder)localObject).append(localAdInfo);
      GdtLog.a("GdtMvElementsController", ((StringBuilder)localObject).toString());
      Activity localActivity = this.b.q().b();
      if ((localAdInfo != null) && (localActivity != null))
      {
        localObject = localAdInfo.report_info.click_url.get();
        paramString = this.v.a((String)localObject, l1, this.b.b(), this.b.d(), paramString);
        localAdInfo.report_info.click_url.set(paramString);
        s();
        if (paramInt != 1) {
          paramBoolean = g();
        }
        paramString = new StringBuilder();
        paramString.append("appAutoDownload:");
        paramString.append(paramBoolean);
        QLog.i("GdtMvElementsController", 1, paramString.toString());
        paramString = a(localAdInfo, localGdtMotiveVideoPageData, localActivity, paramBoolean);
        paramInt = GdtADFlyingStreamingReportHelper.a().b();
        if (paramInt == 2) {
          paramString.d = 48;
        } else if (paramInt == 1) {
          paramString.d = 47;
        }
        ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(paramString);
        paramString = (String)localObject;
        break label287;
      }
    }
    paramString = "";
    label287:
    if ((!TextUtils.isEmpty(paramString)) && (localAdInfo != null)) {
      localAdInfo.report_info.click_url.set(paramString);
    }
    if (GdtADFlyingStreamingReportHelper.a().b() == 2)
    {
      GdtADFlyingStreamingReportHelper.a().a(1020015L);
      return;
    }
    if (GdtADFlyingStreamingReportHelper.a().b() == 1) {
      GdtADFlyingStreamingReportHelper.a().a(1020014L);
    }
  }
  
  public void a(GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    this.w = paramGdtMvMiniAppReportHelper;
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
    GdtMotiveVideoClickCoordinateReportHelper localGdtMotiveVideoClickCoordinateReportHelper = this.v;
    if (localGdtMotiveVideoClickCoordinateReportHelper != null) {
      localGdtMotiveVideoClickCoordinateReportHelper.a(paramBoolean);
    }
  }
  
  public void b()
  {
    AdButtonView localAdButtonView = this.x;
    if ((localAdButtonView != null) && (localAdButtonView.getButtonView() != null)) {
      this.x.getButtonView().setVisibility(8);
    }
  }
  
  public void c()
  {
    FrameLayout localFrameLayout = this.p;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
    localFrameLayout = this.q;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    Drawable localDrawable = this.d.getResources().getDrawable(2130840600);
    this.j.setBackgroundDrawable(localDrawable);
    int i1 = this.c.getResources().getColor(2131168264);
    this.j.setTextColor(i1);
  }
  
  public void e()
  {
    GdtLog.b("GdtMvElementsController", "enableMvBtnUrlStyleDefault");
    Button localButton = this.j;
    if (localButton != null)
    {
      localButton.setBackgroundDrawable(this.d.getResources().getDrawable(2130840592));
      this.j.setTextColor(this.c.getResources().getColor(2131168464));
    }
  }
  
  public void f()
  {
    String str = GdtMvElementsHelper.a(this.u);
    Button localButton = this.j;
    if (localButton != null) {
      localButton.setText(str);
    }
  }
  
  public boolean g()
  {
    Object localObject = this.u;
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
    int i1;
    if (((GdtMotiveVideoPageData)localObject).screenOrientation == 1) {
      if (((GdtMotiveVideoPageData)localObject).vSize == 185)
      {
        localObject = this.g;
        if (localObject == null) {
          break label235;
        }
        arrayOfInt = new int[2];
        ((ImageView)localObject).getLocationOnScreen(arrayOfInt);
        i1 = arrayOfInt[1];
        if (this.t < i1) {
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
    int i3;
    float f1;
    do
    {
      return true;
      if ((((GdtMotiveVideoPageData)localObject).screenOrientation != 0) && (((GdtMotiveVideoPageData)localObject).screenOrientation != 8)) {
        break;
      }
      localObject = this.j;
      if (localObject == null) {
        break;
      }
      arrayOfInt = new int[2];
      ((Button)localObject).getLocationOnScreen(arrayOfInt);
      i1 = arrayOfInt[0];
      int i2 = arrayOfInt[1];
      i3 = this.j.getMeasuredWidth();
      int i4 = this.j.getMeasuredHeight();
      f1 = this.t;
      if ((f1 < i2) || (f1 > i4 + i2)) {
        break;
      }
      f1 = this.s;
    } while ((f1 >= i1) && (f1 <= i3 + i1));
    label235:
    return false;
  }
  
  public void h()
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((GdtAppReceiver)localObject).unregister(this.c);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((ImageView)localObject).clearAnimation();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((TextView)localObject).clearAnimation();
      this.h = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((TextView)localObject).clearAnimation();
      this.i = null;
    }
    if (this.j != null) {
      this.j = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.m = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.e = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((LinearLayout)localObject).clearAnimation();
      this.n = null;
    }
    localObject = this.A;
    if (localObject != null)
    {
      ((GdtMvAnimation585V)localObject).b();
      this.A = null;
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((GdtMvAnimation185V)localObject).b();
      this.B = null;
    }
    localObject = this.C;
    if (localObject != null)
    {
      ((GdtMvAnimation185H)localObject).b();
      this.C = null;
    }
    localObject = this.v;
    if (localObject != null) {
      ((GdtMotiveVideoClickCoordinateReportHelper)localObject).b();
    }
    localObject = this.y;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityDestoryed();
    }
  }
  
  public void i()
  {
    GdtLog.a("GdtMvElementsController", "onResume: ");
    f();
    AdButtonController localAdButtonController = this.y;
    if (localAdButtonController != null) {
      localAdButtonController.onActivityResume();
    }
  }
  
  public void j()
  {
    GdtLog.a("GdtMvElementsController", "onPause: ");
    Object localObject = this.v;
    if (localObject != null) {
      ((GdtMotiveVideoClickCoordinateReportHelper)localObject).b(true);
    }
    localObject = this.y;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController
 * JD-Core Version:    0.7.0.1
 */