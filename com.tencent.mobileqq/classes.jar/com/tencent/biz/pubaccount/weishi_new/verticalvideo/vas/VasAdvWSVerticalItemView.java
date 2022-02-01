package com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas;

import NS_MOBILE_FEEDS.s_button;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer.Params;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSCountDownLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.api.feedback.StartGdtFeedbackParams;
import com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_common.FloatingTip;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalItemView;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/AbsWSVideoItemView;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalVideoHolder;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalVideoHolder;)V", "adBtnView", "Landroid/widget/TextView;", "adContentContainer", "Landroid/widget/LinearLayout;", "adIconView", "Landroid/widget/ImageView;", "adInfo", "LUserGrowth/stSimpleMetaGdtAdInfo;", "adWidgetContainer", "Landroid/view/ViewGroup;", "countdownLayout", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/gdt/GdtAdWSCountDownLayout;", "danmakuView", "Lcom/tencent/gdtad/views/canvas/components/danmaku/GdtDanmakuPresenter;", "descriptionView", "exposureResultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "feedData", "LUserGrowth/stSimpleMetaFeed;", "floatTipsContainer", "Lcom/tencent/ad/tangram/views/floattips/AdFloatTipsViewContainer;", "gdtAd", "Lcom/tencent/gdtad/aditem/GdtAd;", "h5AdUrl", "", "industryLabelContainer", "industryLabelViews", "", "logoView", "Lcom/tencent/biz/pubaccount/weishi_new/view/RoundImageView;", "mainHandler", "Landroid/os/Handler;", "marketingPendantView", "Lcom/tencent/image/URLImageView;", "nameView", "negativeFeedbackView", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "position", "", "rootContainer", "Landroid/widget/RelativeLayout;", "showButtonRunnable", "Ljava/lang/Runnable;", "webView", "Lcom/tencent/biz/ui/TouchWebView;", "addWebView", "", "getClickAreaID", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", "id", "(Ljava/lang/Integer;)Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", "initUI", "initView", "inflatedView", "Landroid/view/View;", "jumpToLandingPage", "autoDownloadApp", "componentID", "onClick", "v", "onMoreBtnClick", "onPageSelected", "currentPosition", "onPageUnselected", "onVasEvent", "eventKey", "callback", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "data", "", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "onViewDetachedFromWindow", "oneSecondAndFiftyPercentageExposureReport", "recycle", "setData", "itemData", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "setPosition", "showCountDownView", "showDanmakuView", "showFloatTips", "showGdtWidgets", "showH5Ad", "showIndustryLabels", "showMarketingPendantView", "showNativeAd", "showNegativeFeedback", "updateAdButtonStyle", "updateAdButtonText", "updateUi", "type", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWSVerticalItemView
  extends AbsWSVideoItemView
  implements View.OnClickListener, VasAdvWebEvent.Subscriber
{
  private static final int F = Color.parseColor("#66FFFFFF");
  public static final VasAdvWSVerticalItemView.Companion a = new VasAdvWSVerticalItemView.Companion(null);
  private GdtDanmakuPresenter A;
  private AdFloatTipsViewContainer B;
  private final Handler C = new Handler(Looper.getMainLooper());
  private final Runnable D = (Runnable)new VasAdvWSVerticalItemView.showButtonRunnable.1(this);
  private VasResultCallback<Boolean> E = (VasResultCallback)new VasAdvWSVerticalItemView.exposureResultCallback.1(this);
  private String b;
  private TouchWebView c;
  private stSimpleMetaFeed i;
  private stSimpleMetaGdtAdInfo j;
  private qq_ad_get.QQAdGetRsp.AdInfo k;
  private GdtAd l;
  private int m = -1;
  private RelativeLayout n;
  private LinearLayout o;
  private ViewGroup p;
  private RoundImageView q;
  private TextView r;
  private TextView s;
  private ImageView t;
  private ImageView u;
  private ViewGroup v;
  private List<TextView> w;
  private TextView x;
  private URLImageView y;
  private GdtAdWSCountDownLayout z;
  
  public VasAdvWSVerticalItemView(@NotNull Context paramContext, @NotNull WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private final VasAdvWSVerticalClickAreaId a(Integer paramInteger)
  {
    Object localObject1 = this.t;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.AD_ICON;
    }
    localObject1 = this.q;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((RoundImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.HOST_AVATAR;
    }
    localObject1 = this.r;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((TextView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.HOST_NAME;
    }
    localObject1 = this.s;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((TextView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.AD_DESCRIPTION;
    }
    localObject1 = this.x;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((TextView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.AD_BUTTON;
    }
    localObject1 = this.v;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ViewGroup)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.INDUSTRY_LABEL;
    }
    localObject1 = this.u;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.NEGATIVE_FEEDBACK;
    }
    localObject1 = this.z;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((GdtAdWSCountDownLayout)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.COUNTDOWN_WIDGET;
    }
    localObject1 = this.y;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((URLImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.MARKETING_PENDANT_WIDGET;
    }
    GdtDanmakuPresenter localGdtDanmakuPresenter = this.A;
    localObject1 = localObject2;
    if (localGdtDanmakuPresenter != null) {
      localObject1 = Integer.valueOf(localGdtDanmakuPresenter.getId());
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.DANMAKU_WIDGET;
    }
    return VasAdvWSVerticalClickAreaId.AD_VIDEO;
  }
  
  private final void a(View paramView)
  {
    this.n = ((RelativeLayout)paramView.findViewById(2131449760));
    Object localObject = this.n;
    if (localObject != null) {
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.o = ((LinearLayout)paramView.findViewById(2131437593));
    this.p = ((ViewGroup)paramView.findViewById(2131445067));
    this.q = ((RoundImageView)paramView.findViewById(2131444895));
    localObject = this.q;
    if (localObject != null)
    {
      ((RoundImageView)localObject).setBorderWidth(8);
      ((RoundImageView)localObject).setBorderColor(F);
      ((RoundImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.r = ((TextView)paramView.findViewById(2131448860));
    localObject = this.r;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.s = ((TextView)paramView.findViewById(2131448859));
    localObject = this.s;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.u = ((ImageView)paramView.findViewById(2131436646));
    localObject = this.u;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.x = ((TextView)paramView.findViewById(2131448858));
    localObject = this.x;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.t = ((ImageView)paramView.findViewById(2131434063));
    localObject = this.t;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.z = ((GdtAdWSCountDownLayout)paramView.findViewById(2131449324));
    localObject = this.z;
    if (localObject != null) {
      ((GdtAdWSCountDownLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.y = ((URLImageView)paramView.findViewById(2131449326));
    localObject = this.y;
    if (localObject != null) {
      ((URLImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.v = ((ViewGroup)paramView.findViewById(2131437476));
    localObject = this.v;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.w = CollectionsKt.mutableListOf(new TextView[] { (TextView)paramView.findViewById(2131434118), (TextView)paramView.findViewById(2131434119), (TextView)paramView.findViewById(2131434120) });
    this.A = ((GdtDanmakuPresenter)paramView.findViewById(2131449325));
    paramView = this.A;
    if (paramView != null) {
      paramView.setOnClickListener((View.OnClickListener)this);
    }
    r();
  }
  
  private final void a(boolean paramBoolean, VasAdvWSVerticalClickAreaId paramVasAdvWSVerticalClickAreaId)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = (Activity)localObject;
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.k;
      if (localAdInfo != null)
      {
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = this.j;
        if (localstSimpleMetaGdtAdInfo != null) {
          localstSimpleMetaGdtAdInfo.isGdtAdclicked = true;
        }
        paramVasAdvWSVerticalClickAreaId = new LandingPageParams(localAdInfo, 8, paramVasAdvWSVerticalClickAreaId.getValue(), paramBoolean, "biz_src_gzh_weishi");
        ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).toLandingPage((Activity)localObject, paramVasAdvWSVerticalClickAreaId);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
  
  private final void l()
  {
    if ((!n()) && (!o())) {
      p();
    }
    q();
    m();
  }
  
  private final void m()
  {
    Object localObject1 = this.l;
    if (localObject1 != null)
    {
      Object localObject3 = ((GdtAd)localObject1).getFloatingTips();
      if (localObject3 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "gdtAd?.floatingTips ?: return");
        if (((List)localObject3).isEmpty())
        {
          localObject1 = this.B;
          if (localObject1 != null) {
            ((AdFloatTipsViewContainer)localObject1).onRecycle();
          }
          return;
        }
        Object localObject2 = this.f.c;
        localObject1 = localObject2;
        if (!(localObject2 instanceof AbsWSVideoItemView)) {
          localObject1 = null;
        }
        localObject1 = (AbsWSVideoItemView)localObject1;
        if (localObject1 != null)
        {
          AbsWsUIGroup localAbsWsUIGroup = ((AbsWSVideoItemView)localObject1).h();
          if (localAbsWsUIGroup != null)
          {
            localObject2 = (AdFloatTipsViewContainer.Params)null;
            Iterator localIterator = ((List)localObject3).iterator();
            localObject1 = localObject2;
            while (localIterator.hasNext())
            {
              qq_common.FloatingTip localFloatingTip = (qq_common.FloatingTip)localIterator.next();
              localObject3 = new AdFloatTipsViewContainer.Params();
              ((AdFloatTipsViewContainer.Params)localObject3).text = localFloatingTip.text.get();
              ((AdFloatTipsViewContainer.Params)localObject3).textColor = Color.parseColor("#FFFFFFFF");
              Object localObject4 = this.g;
              if (localObject4 != null) {
                localObject4 = ((Context)localObject4).getResources();
              } else {
                localObject4 = null;
              }
              ((AdFloatTipsViewContainer.Params)localObject3).textSize = AdUIUtils.dp2px(9.0F, (Resources)localObject4);
              localObject4 = this.g;
              if (localObject4 != null) {
                localObject4 = ((Context)localObject4).getResources();
              } else {
                localObject4 = null;
              }
              ((AdFloatTipsViewContainer.Params)localObject3).iconSize = AdUIUtils.dp2px(9.0F, (Resources)localObject4);
              ((AdFloatTipsViewContainer.Params)localObject3).iconUrl = localFloatingTip.icon_url.get();
              if (localFloatingTip.type.get() == 1) {
                localObject2 = localObject3;
              } else if (localFloatingTip.type.get() == 2) {
                localObject1 = localObject3;
              }
            }
            localObject3 = this.B;
            if (localObject3 == null)
            {
              localObject2 = new AdFloatTipsViewContainer(this.g, (AdFloatTipsViewContainer.Params)localObject2, (AdFloatTipsViewContainer.Params)localObject1);
              localObject3 = new RelativeLayout.LayoutParams(-1, -2);
              ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131449754);
              localObject1 = this.g;
              if (localObject1 != null) {
                localObject1 = ((Context)localObject1).getResources();
              } else {
                localObject1 = null;
              }
              int i1 = AdUIUtils.dp2px(8.0F, (Resources)localObject1);
              localObject1 = this.g;
              if (localObject1 != null) {
                localObject1 = ((Context)localObject1).getResources();
              } else {
                localObject1 = null;
              }
              int i2 = AdUIUtils.dp2px(10.0F, (Resources)localObject1);
              localObject1 = this.g;
              if (localObject1 != null) {
                localObject1 = ((Context)localObject1).getResources();
              } else {
                localObject1 = null;
              }
              int i3 = AdUIUtils.dp2px(8.0F, (Resources)localObject1);
              localObject1 = this.g;
              if (localObject1 != null) {
                localObject1 = ((Context)localObject1).getResources();
              } else {
                localObject1 = null;
              }
              ((RelativeLayout.LayoutParams)localObject3).setMargins(i1, i2, i3, AdUIUtils.dp2px(10.0F, (Resources)localObject1));
              localObject1 = ((AdFloatTipsViewContainer)localObject2).getIndustrialView();
              if (localObject1 != null) {
                ((View)localObject1).setOnClickListener(null);
              }
              ((AdFloatTipsViewContainer)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.B = ((AdFloatTipsViewContainer)localObject2);
              localAbsWsUIGroup.a((View)localObject2);
              QLog.i("VasAdvWSVerticalItemView", 4, "[showFloatTips] container is added");
              return;
            }
            if (localObject3 != null) {
              ((AdFloatTipsViewContainer)localObject3).resetTipsView((AdFloatTipsViewContainer.Params)localObject2, (AdFloatTipsViewContainer.Params)localObject1);
            }
            QLog.i("VasAdvWSVerticalItemView", 4, "[showFloatTips] container is reused");
          }
        }
      }
    }
  }
  
  private final boolean n()
  {
    GdtAdWSCountDownLayout localGdtAdWSCountDownLayout = this.z;
    if (localGdtAdWSCountDownLayout != null)
    {
      IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
      Object localObject = this.j;
      if (localObject != null) {
        localObject = ((stSimpleMetaGdtAdInfo)localObject).gdtTangramAdJson;
      } else {
        localObject = null;
      }
      int i1 = localIVasAdvApi.getGdtCountdownTime((String)localObject);
      if (i1 > 0) {
        return localGdtAdWSCountDownLayout.a(i1);
      }
      localGdtAdWSCountDownLayout.c();
    }
    return false;
  }
  
  private final boolean o()
  {
    URLImageView localURLImageView = this.y;
    if (localURLImageView != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
        localObject1 = this.j;
        if (localObject1 == null) {
          break label114;
        }
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).gdtTangramAdJson;
        localObject1 = ((IVasAdvApi)localObject3).getMarketPendantImgUrl((String)localObject1);
        localObject3 = (CharSequence)localObject1;
        if (localObject3 == null) {
          break label124;
        }
        if (((CharSequence)localObject3).length() != 0) {
          break label119;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        QLog.e("VasAdvWSVerticalItemView", 1, "fail to get marketing pendant url", localThrowable);
        localURLImageView.setVisibility(8);
      }
      if (i1 != 0)
      {
        localURLImageView.setVisibility(8);
        return false;
      }
      localURLImageView.setImageURL((String)localObject1);
      localURLImageView.setVisibility(0);
      return true;
      return false;
      label114:
      Object localObject2 = null;
      continue;
      label119:
      int i1 = 0;
      continue;
      label124:
      i1 = 1;
    }
  }
  
  private final boolean p()
  {
    Object localObject1 = ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).getIndustryLabels(this.k);
    int i3 = 8;
    int i1;
    if (localObject1 != null)
    {
      Object localObject2 = this.w;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        boolean bool1 = false;
        i1 = 0;
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          Object localObject3 = ((Iterator)localObject2).next();
          if (i1 < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          localObject3 = (TextView)localObject3;
          Object localObject4 = (VasAdvWSVerticalItemView)this;
          bool2 = bool1;
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)CollectionsKt.getOrNull((List)localObject1, i1);
            boolean bool3 = true;
            int i2;
            if ((localObject4 != null) && (!StringsKt.isBlank((CharSequence)localObject4))) {
              i2 = 0;
            } else {
              i2 = 1;
            }
            int i4 = i2 ^ 0x1;
            if (i4 != 0) {
              i2 = 0;
            } else {
              i2 = 8;
            }
            ((TextView)localObject3).setVisibility(i2);
            ((TextView)localObject3).setText((CharSequence)localObject4);
            bool2 = bool3;
            if (!bool1) {
              if (i4 != 0) {
                bool2 = bool3;
              } else {
                bool2 = false;
              }
            }
          }
          i1 += 1;
          bool1 = bool2;
        }
      }
    }
    boolean bool2 = false;
    localObject1 = this.v;
    if (localObject1 != null)
    {
      i1 = i3;
      if (bool2) {
        i1 = 0;
      }
      ((ViewGroup)localObject1).setVisibility(i1);
    }
    return bool2;
  }
  
  private final boolean q()
  {
    GdtDanmakuPresenter localGdtDanmakuPresenter = this.A;
    int i1;
    if (localGdtDanmakuPresenter != null)
    {
      try
      {
        IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
        localObject1 = this.j;
        if (localObject1 == null) {
          break label146;
        }
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).gdtTangramAdJson;
        localObject1 = localIVasAdvApi.getGdtDanmakuStrContents((String)localObject1);
        if (localObject1 == null) {
          break label165;
        }
        if (localObject1.length != 0) {
          break label151;
        }
        i1 = 1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        label62:
        boolean bool;
        QLog.e("VasAdvWSVerticalItemView", 1, "fail to get danmaku contents", localThrowable);
        localGdtDanmakuPresenter.setVisibility(8);
      }
      if (i1 != 0)
      {
        if (localGdtDanmakuPresenter.c()) {
          localGdtDanmakuPresenter.b();
        }
        localGdtDanmakuPresenter.setVisibility(8);
        return false;
      }
      localGdtDanmakuPresenter.a(AdUIUtils.getScreenWidth(this.g), (String[])localObject1);
      bool = localGdtDanmakuPresenter.a();
      if (!bool) {
        break label170;
      }
      i1 = 0;
    }
    for (;;)
    {
      localGdtDanmakuPresenter.setVisibility(i1);
      return bool;
      return false;
      label146:
      Object localObject2 = null;
      break;
      label151:
      i1 = 0;
      if (i1 == 0)
      {
        i1 = 0;
        break label62;
      }
      label165:
      i1 = 1;
      break label62;
      label170:
      i1 = 8;
    }
  }
  
  private final void r()
  {
    TouchWebView localTouchWebView = this.c;
    if (localTouchWebView != null)
    {
      RelativeLayout localRelativeLayout = this.n;
      if (localRelativeLayout != null) {
        localRelativeLayout.addView((View)localTouchWebView);
      }
    }
  }
  
  private final void s()
  {
    Object localObject1 = this.j;
    boolean bool;
    if (localObject1 != null) {
      bool = ((stSimpleMetaGdtAdInfo)localObject1).isGdtAdImpressionReport;
    } else {
      bool = true;
    }
    if (!bool)
    {
      localObject1 = this.j;
      if (localObject1 != null) {
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).impressionUrl;
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (this.k != null))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&slot=");
        ((StringBuilder)localObject2).append(this.m + 1);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
        View localView = this.h;
        Intrinsics.checkExpressionValueIsNotNull(localView, "mItemView");
        ((IVasAdvApi)localObject2).doExposure((String)localObject1, localView, this.k, this.E);
      }
    }
  }
  
  private final void t()
  {
    GdtFeedbackListener localGdtFeedbackListener = (GdtFeedbackListener)new VasAdvWSVerticalItemView.showNegativeFeedback.listener.1(this);
    Object localObject2 = this.g;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    localObject1 = StartGdtFeedbackParams.a(new WeakReference((Activity)localObject1), new WeakReference(localGdtFeedbackListener), new GdtAd(this.k), 0, QQTheme.isNowThemeIsNight());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StartGdtFeedbackParams.b…heme.isNowThemeIsNight())");
    localObject2 = this.u;
    if (localObject2 != null) {
      ((ImageView)localObject2).setTag(localGdtFeedbackListener);
    }
    ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtFeedbackFragment((StartGdtFeedbackParams)localObject1);
  }
  
  private final void u()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((TouchWebView)localObject).setVisibility(0);
    }
    localObject = this.o;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(4);
    }
    localObject = this.u;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  private final void v()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((TouchWebView)localObject).setVisibility(8);
    }
    localObject = this.o;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = this.u;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  public void a()
  {
    Object localObject = this.z;
    if (localObject != null) {
      ((GdtAdWSCountDownLayout)localObject).b();
    }
    this.z = ((GdtAdWSCountDownLayout)null);
    localObject = this.A;
    if (localObject != null) {
      ((GdtDanmakuPresenter)localObject).b();
    }
    this.A = ((GdtDanmakuPresenter)null);
    this.C.removeCallbacks(this.D);
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.m = paramInt;
  }
  
  public void a(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    Object localObject2 = null;
    if (paramWSVerticalItemData != null) {
      localstSimpleMetaFeed = paramWSVerticalItemData.b();
    } else {
      localstSimpleMetaFeed = null;
    }
    Object localObject1 = localstSimpleMetaFeed;
    if (!(localstSimpleMetaFeed instanceof stSimpleMetaFeed)) {
      localObject1 = null;
    }
    this.i = ((stSimpleMetaFeed)localObject1);
    if (paramWSVerticalItemData != null) {
      paramWSVerticalItemData = paramWSVerticalItemData.e();
    } else {
      paramWSVerticalItemData = null;
    }
    this.j = paramWSVerticalItemData;
    this.k = GdtAdUtil.a(this.i);
    this.l = new GdtAd(this.k);
    stSimpleMetaFeed localstSimpleMetaFeed = this.i;
    if (localstSimpleMetaFeed != null)
    {
      paramWSVerticalItemData = this.q;
      Object localObject3;
      if (paramWSVerticalItemData != null)
      {
        localObject1 = WSPicLoader.a();
        localObject3 = this.g;
        ImageView localImageView = (ImageView)paramWSVerticalItemData;
        paramWSVerticalItemData = localstSimpleMetaFeed.poster;
        if (paramWSVerticalItemData != null) {
          paramWSVerticalItemData = paramWSVerticalItemData.avatar;
        } else {
          paramWSVerticalItemData = null;
        }
        ((WSPicLoader)localObject1).a((Context)localObject3, localImageView, paramWSVerticalItemData);
      }
      localObject1 = this.r;
      if (localObject1 != null)
      {
        localObject3 = localstSimpleMetaFeed.poster;
        paramWSVerticalItemData = localObject2;
        if (localObject3 != null) {
          paramWSVerticalItemData = ((stSimpleMetaPerson)localObject3).nick;
        }
        ((TextView)localObject1).setText((CharSequence)paramWSVerticalItemData);
      }
      paramWSVerticalItemData = this.s;
      if (paramWSVerticalItemData != null) {
        paramWSVerticalItemData.setText((CharSequence)localstSimpleMetaFeed.feed_desc);
      }
      l();
    }
    paramWSVerticalItemData = this.c;
    if (paramWSVerticalItemData != null)
    {
      ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).subscribe("ws_video_ad_h5_cover", (VasAdvWebEvent.Subscriber)this);
      if (paramWSVerticalItemData.getUrl() != null) {
        paramWSVerticalItemData.clearHistory();
      }
      paramWSVerticalItemData.loadUrl(this.b);
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject = WSVerticalDataManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSVerticalDataManager.getInstance()");
    this.b = ((WSVerticalDataManager)localObject).b();
    Context localContext = this.g;
    localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if ((!TextUtils.isEmpty((CharSequence)this.b)) && (localObject != null)) {
      this.c = ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).getWebView((Activity)localObject);
    }
    this.h.setOnClickListener((View.OnClickListener)this);
    localObject = (ViewStub)this.h.findViewById(2131449751);
    if (localObject != null)
    {
      ((ViewStub)localObject).setLayoutResource(2131629624);
      localObject = ((ViewStub)localObject).inflate();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "inflate()");
      a((View)localObject);
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = this.i;
    if ((localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1))
    {
      localObject1 = this.i;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((stSimpleMetaFeed)localObject1).gdt_ad_info;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = this.j;
        if ((localObject1 == null) || (((stSimpleMetaGdtAdInfo)localObject1).isGdtAdOriginalImpressionReport != true))
        {
          IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
          Context localContext = this.g;
          Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
          stSimpleMetaFeed localstSimpleMetaFeed = this.i;
          localObject1 = localObject2;
          if (localstSimpleMetaFeed != null) {
            localObject1 = localstSimpleMetaFeed.gdt_ad_info;
          }
          boolean bool = localIVasAdvApi.doOriginalExposure(localContext, (String)localObject1, this.k, this.m + 1);
          localObject1 = this.j;
          if (localObject1 != null) {
            ((stSimpleMetaGdtAdInfo)localObject1).isGdtAdOriginalImpressionReport = bool;
          }
        }
        s();
      }
    }
    e();
  }
  
  public void c()
  {
    ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).unsubscribe("ws_video_ad_h5_cover", (VasAdvWebEvent.Subscriber)this);
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    Object localObject = this.l;
    if (localObject != null) {
      localObject = Long.valueOf(((GdtAd)localObject).getButtonDelayTime() * 1000L);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Long)localObject).longValue() > 0L))
    {
      this.C.removeCallbacks(this.D);
      localObject = this.x;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
    }
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateUi] ");
    localStringBuilder.append(this.m);
    QLog.i("VasAdvWSVerticalItemView", 4, localStringBuilder.toString());
  }
  
  public final void e()
  {
    f();
    Object localObject = this.l;
    if (localObject != null) {
      localObject = Long.valueOf(((GdtAd)localObject).getButtonDelayTime() * 1000L);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Long)localObject).longValue() > 0L))
    {
      this.C.removeCallbacks(this.D);
      TextView localTextView = this.x;
      if (localTextView != null) {
        localTextView.setVisibility(4);
      }
      this.C.postDelayed(this.D, ((Long)localObject).longValue());
    }
  }
  
  public final void f()
  {
    Object localObject1 = this.k;
    if (localObject1 != null)
    {
      localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).product_type;
      if ((localObject1 != null) && (((PBUInt32Field)localObject1).get() == 12))
      {
        i1 = 1;
        break label34;
      }
    }
    int i1 = 0;
    label34:
    localObject1 = this.k;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info;
      if (localObject1 != null)
      {
        localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject1).app_package_name;
        if (localObject1 != null)
        {
          localObject1 = ((PBStringField)localObject1).get();
          break label74;
        }
      }
    }
    localObject1 = null;
    label74:
    Object localObject3 = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
    Context localContext = this.g;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
    boolean bool = ((IVasAdvApi)localObject3).isAppInstalled(localContext, (String)localObject1);
    if (i1 != 0)
    {
      if (bool) {
        localObject1 = this.g.getString(2131903207);
      } else {
        localObject1 = this.g.getString(2131913829);
      }
    }
    else
    {
      localObject1 = this.j;
      if (localObject1 != null)
      {
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).bottomButton;
        if (localObject1 != null)
        {
          localObject1 = ((s_button)localObject1).text;
          break label174;
        }
      }
      localObject1 = null;
      label174:
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = this.j;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((stSimpleMetaGdtAdInfo)localObject3).bottomButton;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((s_button)localObject3).text;
          }
        }
      }
      else
      {
        localObject1 = this.g.getString(2131913551);
      }
    }
    localObject2 = (CharSequence)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = this.x;
      if (localObject3 != null) {
        ((TextView)localObject3).setText((CharSequence)localObject2);
      }
      localObject2 = this.i;
      if (localObject2 != null)
      {
        localObject2 = ((stSimpleMetaFeed)localObject2).new_icon;
        if (localObject2 != null) {
          ((stNewIconStyle)localObject2).title = ((String)localObject1);
        }
      }
    }
  }
  
  public void onClick(@Nullable View paramView)
  {
    Object localObject1 = this.i;
    Object localObject2 = null;
    if ((localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1))
    {
      localObject1 = this.i;
      if (localObject1 != null) {
        localObject1 = ((stSimpleMetaFeed)localObject1).gdt_ad_info;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        s();
      }
    }
    if (paramView != null) {
      localObject1 = Integer.valueOf(paramView.getId());
    } else {
      localObject1 = null;
    }
    VasAdvWSVerticalClickAreaId localVasAdvWSVerticalClickAreaId = a((Integer)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("click on pos ");
    ((StringBuilder)localObject1).append(localVasAdvWSVerticalClickAreaId.name());
    QLog.i("VasAdvWSVerticalItemView", 4, ((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (paramView != null) {
      localObject1 = Integer.valueOf(paramView.getId());
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 2131436646)) {
      t();
    } else if ((localObject1 != null) && (((Integer)localObject1).intValue() == 2131437593)) {
      a(true, localVasAdvWSVerticalClickAreaId);
    } else {
      a(false, localVasAdvWSVerticalClickAreaId);
    }
    if ((paramView == null) || (paramView.getId() != 2131436646))
    {
      e();
      this.C.removeCallbacks(this.D);
    }
  }
  
  public void onVasEvent(@NotNull String paramString, @Nullable VasAdvWebEvent.Callback paramCallback, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventKey");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "data");
    int i2 = paramString.hashCode();
    int i1 = 0;
    if (i2 != -62987789)
    {
      if (i2 != -39557675)
      {
        if (i2 != 1540946822) {
          return;
        }
        if (paramString.equals("handle_web_click"))
        {
          paramCallback = paramVarArgs[0];
          paramString = paramCallback;
          if (!(paramCallback instanceof Integer)) {
            paramString = null;
          }
          paramString = (Integer)paramString;
          if ((paramString != null) && (paramString.intValue() == 0))
          {
            a(false, VasAdvWSVerticalClickAreaId.AD_VIDEO);
            return;
          }
          if (((paramString != null) && (paramString.intValue() == 1)) || ((paramString != null) && (paramString.intValue() == 2)) || ((paramString != null) && (paramString.intValue() == 3)) || ((paramString != null) && (paramString.intValue() == 4)))
          {
            a(true, VasAdvWSVerticalClickAreaId.AD_BUTTON);
            return;
          }
          if (paramString == null) {
            return;
          }
          if (paramString.intValue() == 5) {
            t();
          }
        }
      }
      else if (paramString.equals("get_gdt_ad_data"))
      {
        paramString = this.k;
        if (paramString != null) {
          paramString = ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).convertPbToJson((PBField)paramString);
        } else {
          paramString = null;
        }
        paramVarArgs = (CharSequence)paramString;
        if ((paramVarArgs == null) || (paramVarArgs.length() == 0)) {
          i1 = 1;
        }
        if (i1 != 0)
        {
          if (paramCallback != null) {
            paramCallback.onResult(null, "adInfo is null");
          }
        }
        else if (paramCallback != null)
        {
          paramVarArgs = new JSONObject();
          paramVarArgs.put("adInfo", paramString);
          paramCallback.onResult(paramVarArgs, null);
        }
      }
    }
    else if (paramString.equals("notify_web_status"))
    {
      paramCallback = paramVarArgs[0];
      paramString = paramCallback;
      if (!(paramCallback instanceof Integer)) {
        paramString = null;
      }
      paramString = (Integer)paramString;
      if ((paramString != null) && (paramString.intValue() == 2))
      {
        u();
        return;
      }
      v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalItemView
 * JD-Core Version:    0.7.0.1
 */