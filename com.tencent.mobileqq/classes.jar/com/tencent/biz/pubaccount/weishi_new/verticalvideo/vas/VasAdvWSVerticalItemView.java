package com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas;

import NS_MOBILE_FEEDS.s_button;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalDialogListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSCountDownLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.LandingPageParams;
import cooperation.vip.VasAdvSupport;
import cooperation.vip.VasAdvSupport.Companion;
import cooperation.vip.VasResultCallback;
import cooperation.vip.web.VasAdvWebEvent.Callback;
import cooperation.vip.web.VasAdvWebEvent.Subscriber;
import cooperation.vip.web.VasAdvWebManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalItemView;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/AbsWSVideoItemView;", "Lcooperation/vip/web/VasAdvWebEvent$Subscriber;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalVideoHolder;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalVideoHolder;)V", "adBtnView", "Landroid/widget/TextView;", "adContentContainer", "Landroid/widget/LinearLayout;", "adInfo", "LUserGrowth/stSimpleMetaGdtAdInfo;", "adWidgetContainer", "Landroid/view/ViewGroup;", "countdownLayout", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/gdt/GdtAdWSCountDownLayout;", "descriptionView", "exposureResultCallback", "Lcooperation/vip/VasResultCallback;", "", "feedData", "LUserGrowth/stSimpleMetaFeed;", "h5AdUrl", "", "industryLabelContainer", "industryLabelViews", "", "logoView", "Lcom/tencent/biz/pubaccount/weishi_new/view/RoundImageView;", "marketingPendantView", "Lcom/tencent/image/URLImageView;", "nameView", "negativeFeedbackView", "Landroid/widget/ImageView;", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "position", "", "rootContainer", "Landroid/widget/RelativeLayout;", "webView", "Lcom/tencent/biz/ui/TouchWebView;", "addWebView", "", "initUI", "initView", "inflatedView", "Landroid/view/View;", "jumpToLandingPage", "autoDownloadApp", "onClick", "v", "onMoreBtnClick", "onPageSelected", "currentPosition", "onVasEvent", "eventKey", "callback", "Lcooperation/vip/web/VasAdvWebEvent$Callback;", "data", "", "", "(Ljava/lang/String;Lcooperation/vip/web/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "onViewDetachedFromWindow", "oneSecondAndFiftyPercentageExposureReport", "recycle", "setData", "itemData", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "setPosition", "showCountDownView", "showGdtWidgets", "showH5Ad", "showIndustryLabels", "showMarketingPendantView", "showNativeAd", "showNegativeFeedback", "updateAdButtonText", "updateUi", "type", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWSVerticalItemView
  extends AbsWSVideoItemView
  implements View.OnClickListener, VasAdvWebEvent.Subscriber
{
  public static final VasAdvWSVerticalItemView.Companion a;
  private static final int jdField_b_of_type_Int = Color.parseColor("#66FFFFFF");
  private int jdField_a_of_type_Int = -1;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private stSimpleMetaGdtAdInfo jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtAdWSCountDownLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private VasResultCallback<Boolean> jdField_a_of_type_CooperationVipVasResultCallback = (VasResultCallback)new VasAdvWSVerticalItemView.exposureResultCallback.1(this);
  private String jdField_a_of_type_JavaLangString;
  private List<TextView> jdField_a_of_type_JavaUtilList;
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoVasVasAdvWSVerticalItemView$Companion = new VasAdvWSVerticalItemView.Companion(null);
  }
  
  public VasAdvWSVerticalItemView(@NotNull Context paramContext, @NotNull WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private final void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381554));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370696));
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131377319));
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)paramView.findViewById(2131377154));
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
    if (localObject != null)
    {
      ((RoundImageView)localObject).setBorderWidth(8);
      ((RoundImageView)localObject).setBorderColor(jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380693));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380692));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369858));
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.c = ((TextView)paramView.findViewById(2131380691));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout = ((GdtAdWSCountDownLayout)paramView.findViewById(2131381123));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131381124));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370614));
    this.jdField_a_of_type_JavaUtilList = CollectionsKt.mutableListOf(new TextView[] { (TextView)paramView.findViewById(2131367808), (TextView)paramView.findViewById(2131367809), (TextView)paramView.findViewById(2131367810) });
    g();
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
    localObject1 = (Activity)localObject1;
    Object localObject2 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
    if (localObject2 != null)
    {
      stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
      if (localstSimpleMetaGdtAdInfo != null) {
        localstSimpleMetaGdtAdInfo.isGdtAdclicked = true;
      }
      localObject2 = new LandingPageParams((qq_ad_get.QQAdGetRsp.AdInfo)localObject2, 8, 6, paramBoolean, "biz_src_gzh_weishi");
      VasAdvSupport.a.a().a((Activity)localObject1, (LandingPageParams)localObject2);
    }
  }
  
  private final boolean a()
  {
    GdtAdWSCountDownLayout localGdtAdWSCountDownLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localGdtAdWSCountDownLayout != null)
    {
      VasAdvSupport localVasAdvSupport = VasAdvSupport.a.a();
      Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
      if (localObject != null) {}
      for (localObject = ((stSimpleMetaGdtAdInfo)localObject).gdtTangramAdJson;; localObject = null)
      {
        int i = localVasAdvSupport.a((String)localObject);
        if (i <= 0) {
          break;
        }
        return localGdtAdWSCountDownLayout.a(i);
      }
      localGdtAdWSCountDownLayout.c();
      return false;
    }
    return false;
  }
  
  private final boolean b()
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localURLImageView != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = VasAdvSupport.a.a();
        localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
        if (localObject1 == null) {
          break label113;
        }
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).gdtTangramAdJson;
        localObject1 = ((VasAdvSupport)localObject3).b((String)localObject1);
        localObject3 = (CharSequence)localObject1;
        if (localObject3 == null) {
          break label108;
        }
        if (((CharSequence)localObject3).length() != 0) {
          break label118;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        QLog.e("VasAdvWSVerticalItemView", 1, "fail to get marketing pendant url", localThrowable);
        localURLImageView.setVisibility(8);
        return false;
      }
      if (i != 0)
      {
        localURLImageView.setVisibility(8);
        return false;
      }
      localURLImageView.setImageURL((String)localObject1);
      localURLImageView.setVisibility(0);
      return true;
      return false;
      label108:
      int i = 1;
      continue;
      label113:
      Object localObject2 = null;
      continue;
      label118:
      i = 0;
    }
  }
  
  private final boolean c()
  {
    int m = 0;
    Object localObject1 = VasAdvSupport.a.a().a(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    boolean bool2;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        boolean bool1 = false;
        bool2 = bool1;
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          localObject3 = (TextView)localObject3;
          Object localObject4 = (VasAdvWSVerticalItemView)this;
          int j;
          label132:
          label138:
          int k;
          if (localObject3 != null)
          {
            localObject4 = (String)CollectionsKt.getOrNull((List)localObject1, i);
            CharSequence localCharSequence = (CharSequence)localObject4;
            if ((localCharSequence == null) || (StringsKt.isBlank(localCharSequence)))
            {
              j = 1;
              if (j != 0) {
                break label184;
              }
              j = 1;
              if (j == 0) {
                break label189;
              }
              k = 0;
              label144:
              ((TextView)localObject3).setVisibility(k);
              ((TextView)localObject3).setText((CharSequence)localObject4);
              if ((!bool1) && (j == 0)) {
                break label195;
              }
              bool1 = true;
            }
          }
          for (;;)
          {
            i += 1;
            break;
            j = 0;
            break label132;
            label184:
            j = 0;
            break label138;
            label189:
            k = 8;
            break label144;
            label195:
            bool1 = false;
          }
        }
      }
      else
      {
        bool2 = false;
      }
      localObject1 = this.jdField_b_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        if (!bool2) {
          break label241;
        }
      }
    }
    label241:
    for (int i = m;; i = 8)
    {
      ((ViewGroup)localObject1).setVisibility(i);
      return bool2;
      bool2 = false;
      break;
    }
  }
  
  private final void f()
  {
    if ((!a()) && (!b())) {
      c();
    }
  }
  
  private final void g()
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView != null)
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null) {
        localRelativeLayout.addView((View)localTouchWebView);
      }
    }
  }
  
  private final void h()
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
    boolean bool;
    if (localObject != null)
    {
      bool = ((stSimpleMetaGdtAdInfo)localObject).isGdtAdImpressionReport;
      if (!bool)
      {
        localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
        if (localObject == null) {
          break label85;
        }
      }
    }
    label85:
    for (localObject = ((stSimpleMetaGdtAdInfo)localObject).impressionUrl;; localObject = null)
    {
      if ((localObject != null) && (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null))
      {
        VasAdvSupport localVasAdvSupport = VasAdvSupport.a.a();
        View localView = this.jdField_a_of_type_AndroidViewView;
        Intrinsics.checkExpressionValueIsNotNull(localView, "mItemView");
        localVasAdvSupport.a((String)localObject, localView, this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo, this.jdField_a_of_type_CooperationVipVasResultCallback);
      }
      return;
      bool = true;
      break;
    }
  }
  
  private final void i()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    localWSShareParam.jdField_a_of_type_Int = 2;
    localWSShareParam.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    WSVerticalPageFragment localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    Intrinsics.checkExpressionValueIsNotNull(localWSVerticalPageFragment, "mFragment");
    localWSShareParam.jdField_a_of_type_JavaLangString = WSVerticalBeaconReport.a(localWSVerticalPageFragment.a());
    localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    Intrinsics.checkExpressionValueIsNotNull(localWSVerticalPageFragment, "mFragment");
    localWSShareParam.jdField_b_of_type_JavaLangString = localWSVerticalPageFragment.b();
    localWSShareParam.c = "more_operations";
    localWSShareParam.a((WSVerticalDialogListener)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    WeishiShareUtil.a(this.jdField_a_of_type_AndroidContentContext, localWSShareParam);
  }
  
  private final void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null) {
      ((TouchWebView)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(4);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  private final void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null) {
      ((TouchWebView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  public void a()
  {
    GdtAdWSCountDownLayout localGdtAdWSCountDownLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localGdtAdWSCountDownLayout != null) {
      localGdtAdWSCountDownLayout.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout = ((GdtAdWSCountDownLayout)null);
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@Nullable WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    stSimpleMetaFeed localstSimpleMetaFeed;
    Object localObject;
    if (paramWSVerticalItemData != null)
    {
      localstSimpleMetaFeed = paramWSVerticalItemData.a();
      localObject = localstSimpleMetaFeed;
      if (!(localstSimpleMetaFeed instanceof stSimpleMetaFeed)) {
        localObject = null;
      }
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localObject);
      if (paramWSVerticalItemData == null) {
        break label238;
      }
      paramWSVerticalItemData = paramWSVerticalItemData.a();
      label39:
      this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo = paramWSVerticalItemData;
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = GdtAdUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      if (localstSimpleMetaFeed != null)
      {
        paramWSVerticalItemData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
        if (paramWSVerticalItemData != null)
        {
          localObject = this.jdField_a_of_type_AndroidContentContext;
          ImageView localImageView = (ImageView)paramWSVerticalItemData;
          paramWSVerticalItemData = localstSimpleMetaFeed.poster;
          if (paramWSVerticalItemData == null) {
            break label243;
          }
          paramWSVerticalItemData = paramWSVerticalItemData.avatar;
          label98:
          WeishiUtils.a((Context)localObject, localImageView, paramWSVerticalItemData);
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null)
        {
          paramWSVerticalItemData = localstSimpleMetaFeed.poster;
          if (paramWSVerticalItemData == null) {
            break label248;
          }
          paramWSVerticalItemData = paramWSVerticalItemData.nick;
          label128:
          ((TextView)localObject).setText((CharSequence)paramWSVerticalItemData);
        }
        paramWSVerticalItemData = this.jdField_b_of_type_AndroidWidgetTextView;
        if (paramWSVerticalItemData != null) {
          paramWSVerticalItemData.setText((CharSequence)localstSimpleMetaFeed.feed_desc);
        }
        localObject = this.c;
        if (localObject != null)
        {
          paramWSVerticalItemData = localstSimpleMetaFeed.new_icon;
          if (paramWSVerticalItemData == null) {
            break label253;
          }
        }
      }
    }
    label238:
    label243:
    label248:
    label253:
    for (paramWSVerticalItemData = paramWSVerticalItemData.title;; paramWSVerticalItemData = null)
    {
      ((TextView)localObject).setText((CharSequence)paramWSVerticalItemData);
      f();
      paramWSVerticalItemData = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (paramWSVerticalItemData != null)
      {
        VasAdvWebManager.a.a("ws_video_ad_h5_cover", (VasAdvWebEvent.Subscriber)this);
        if (paramWSVerticalItemData.getUrl() != null) {
          paramWSVerticalItemData.clearHistory();
        }
        paramWSVerticalItemData.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
      localstSimpleMetaFeed = null;
      break;
      paramWSVerticalItemData = null;
      break label39;
      paramWSVerticalItemData = null;
      break label98;
      paramWSVerticalItemData = null;
      break label128;
    }
  }
  
  public void a(@NotNull String paramString, @Nullable VasAdvWebEvent.Callback paramCallback, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventKey");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "data");
    label86:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      ;;
    case -39557675: 
    case -62987789: 
    case 1540946822: 
      label107:
      do
      {
        do
        {
          do
          {
            while (!paramString.equals("get_gdt_ad_data")) {}
            paramString = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
            if (paramString == null) {
              break;
            }
            paramString = VasAdvSupport.a.a().a((PBField)paramString);
            paramVarArgs = (CharSequence)paramString;
            if ((paramVarArgs != null) && (paramVarArgs.length() != 0)) {
              break label251;
            }
            i = 1;
            if (i == 0) {
              break label257;
            }
          } while (paramCallback == null);
          paramCallback.a(null, "adInfo is null");
          return;
        } while (!paramString.equals("notify_web_status"));
        paramCallback = paramVarArgs[0];
        paramString = paramCallback;
        if (!(paramCallback instanceof Integer)) {
          paramString = null;
        }
        paramString = (Integer)paramString;
        if (paramString != null) {
          break;
        }
        k();
        return;
      } while (!paramString.equals("handle_web_click"));
      label161:
      paramCallback = paramVarArgs[0];
      paramString = paramCallback;
      if (!(paramCallback instanceof Integer)) {
        paramString = null;
      }
      paramString = (Integer)paramString;
      if (paramString == null) {
        label200:
        if (paramString != null) {
          break label300;
        }
      }
      break;
    }
    label208:
    label212:
    label251:
    while (paramString.intValue() != 1)
    {
      if (paramString != null) {
        break label314;
      }
      if (paramString != null) {
        break label325;
      }
      if (paramString != null) {
        break label336;
      }
      if ((paramString == null) || (paramString.intValue() != 5)) {
        break;
      }
      i();
      return;
      if (paramString.intValue() != 2) {
        break label161;
      }
      j();
      return;
      paramString = null;
      break label86;
      i = 0;
      break label107;
      if (paramCallback == null) {
        break;
      }
      paramVarArgs = new JSONObject();
      paramVarArgs.put("adInfo", paramString);
      paramCallback.a(paramVarArgs, null);
      return;
      if (paramString.intValue() != 0) {
        break label200;
      }
      a(false);
      return;
    }
    for (;;)
    {
      label257:
      label300:
      a(true);
      return;
      label314:
      if (paramString.intValue() != 2) {
        break label208;
      }
      continue;
      label325:
      if (paramString.intValue() != 3) {
        break label212;
      }
      continue;
      label336:
      if (paramString.intValue() != 4) {
        break;
      }
    }
  }
  
  public void b()
  {
    VasAdvWebManager.a.b("ws_video_ad_h5_cover", (VasAdvWebEvent.Subscriber)this);
  }
  
  public void b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if ((localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1))
    {
      localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      if (localObject1 == null) {
        break label129;
      }
    }
    label129:
    for (localObject1 = ((stSimpleMetaFeed)localObject1).gdt_ad_info;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
        if ((localObject1 == null) || (((stSimpleMetaGdtAdInfo)localObject1).isGdtAdOriginalImpressionReport != true))
        {
          VasAdvSupport localVasAdvSupport = VasAdvSupport.a.a();
          Context localContext = this.jdField_a_of_type_AndroidContentContext;
          Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
          stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
          localObject1 = localObject2;
          if (localstSimpleMetaFeed != null) {
            localObject1 = localstSimpleMetaFeed.gdt_ad_info;
          }
          boolean bool = localVasAdvSupport.a(localContext, (String)localObject1, this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
          localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
          if (localObject1 != null) {
            ((stSimpleMetaGdtAdInfo)localObject1).isGdtAdOriginalImpressionReport = bool;
          }
        }
        h();
      }
      return;
    }
  }
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void d()
  {
    super.d();
    Object localObject = WSVerticalDataManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSVerticalDataManager.getInstance()");
    this.jdField_a_of_type_JavaLangString = ((WSVerticalDataManager)localObject).a();
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if ((!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) && (localObject != null)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = VasAdvWebManager.a.a((Activity)localObject);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)this);
    localObject = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381546);
    if (localObject != null)
    {
      ((ViewStub)localObject).setLayoutResource(2131563193);
      localObject = ((ViewStub)localObject).inflate();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "inflate()");
      a((View)localObject);
    }
  }
  
  public final void e()
  {
    Object localObject1 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
    label61:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).product_type;
      if ((localObject1 != null) && (((PBUInt32Field)localObject1).get() == 12))
      {
        i = 1;
        localObject1 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
        if (localObject1 == null) {
          break label176;
        }
        localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).app_info;
        if (localObject1 == null) {
          break label176;
        }
        localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo.AppInfo)localObject1).app_package_name;
        if (localObject1 == null) {
          break label176;
        }
        localObject1 = ((PBStringField)localObject1).get();
        localObject2 = VasAdvSupport.a.a();
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
        boolean bool = ((VasAdvSupport)localObject2).a(localContext, (String)localObject1);
        if ((i == 0) || (!bool)) {
          break label181;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131705247);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.c;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
        localObject2 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
        if (localObject2 != null)
        {
          localObject2 = ((stSimpleMetaFeed)localObject2).new_icon;
          if (localObject2 != null) {
            ((stNewIconStyle)localObject2).title = ((String)localObject1);
          }
        }
      }
      return;
      i = 0;
      break;
      label176:
      localObject1 = null;
      break label61;
      label181:
      localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).bottomButton;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((s_button)localObject1).text;; localObject1 = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label250;
        }
        localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
        if (localObject1 == null) {
          break label245;
        }
        localObject1 = ((stSimpleMetaGdtAdInfo)localObject1).bottomButton;
        if (localObject1 == null) {
          break label245;
        }
        localObject1 = ((s_button)localObject1).text;
        break;
      }
      label245:
      localObject1 = null;
    }
    label250:
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if (i != 0) {}
    for (int i = 2131716177;; i = 2131716179)
    {
      localObject1 = ((Context)localObject1).getString(i);
      break;
    }
  }
  
  public void onClick(@Nullable View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if ((localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1))
    {
      localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      if (localObject1 == null) {
        break label76;
      }
      localObject1 = ((stSimpleMetaFeed)localObject1).gdt_ad_info;
      if (localObject1 != null) {
        h();
      }
    }
    localObject1 = localObject2;
    if (paramView != null) {
      localObject1 = Integer.valueOf(paramView.getId());
    }
    if (localObject1 == null)
    {
      label59:
      if (localObject1 != null) {
        break label97;
      }
      label63:
      a(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label76:
      localObject1 = null;
      break;
      if (((Integer)localObject1).intValue() != 2131369858) {
        break label59;
      }
      i();
      continue;
      label97:
      if (((Integer)localObject1).intValue() != 2131370696) {
        break label63;
      }
      a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalItemView
 * JD-Core Version:    0.7.0.1
 */