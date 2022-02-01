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
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
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
import com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber;
import com.tencent.qphone.base.util.QLog;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalItemView;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/AbsWSVideoItemView;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalVideoHolder;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/holder/WSVerticalVideoHolder;)V", "adBtnView", "Landroid/widget/TextView;", "adContentContainer", "Landroid/widget/LinearLayout;", "adIconView", "Landroid/widget/ImageView;", "adInfo", "LUserGrowth/stSimpleMetaGdtAdInfo;", "adWidgetContainer", "Landroid/view/ViewGroup;", "countdownLayout", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/gdt/GdtAdWSCountDownLayout;", "danmakuView", "Lcom/tencent/gdtad/views/canvas/components/danmaku/GdtDanmakuPresenter;", "descriptionView", "exposureResultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "feedData", "LUserGrowth/stSimpleMetaFeed;", "h5AdUrl", "", "industryLabelContainer", "industryLabelViews", "", "logoView", "Lcom/tencent/biz/pubaccount/weishi_new/view/RoundImageView;", "marketingPendantView", "Lcom/tencent/image/URLImageView;", "nameView", "negativeFeedbackView", "pbAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "position", "", "rootContainer", "Landroid/widget/RelativeLayout;", "webView", "Lcom/tencent/biz/ui/TouchWebView;", "addWebView", "", "getClickAreaID", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", "id", "(Ljava/lang/Integer;)Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", "initUI", "initView", "inflatedView", "Landroid/view/View;", "jumpToLandingPage", "autoDownloadApp", "componentID", "onClick", "v", "onMoreBtnClick", "onPageSelected", "currentPosition", "onVasEvent", "eventKey", "callback", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "data", "", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "onViewDetachedFromWindow", "oneSecondAndFiftyPercentageExposureReport", "recycle", "setData", "itemData", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "setPosition", "showCountDownView", "showDanmakuView", "showGdtWidgets", "showH5Ad", "showIndustryLabels", "showMarketingPendantView", "showNativeAd", "showNegativeFeedback", "updateAdButtonText", "updateUi", "type", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
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
  private GdtDanmakuPresenter jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private VasResultCallback<Boolean> jdField_a_of_type_ComTencentMobileqqVasAdvCommonCallbackVasResultCallback = (VasResultCallback)new VasAdvWSVerticalItemView.exposureResultCallback.1(this);
  private String jdField_a_of_type_JavaLangString;
  private List<TextView> jdField_a_of_type_JavaUtilList;
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
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
  
  private final VasAdvWSVerticalClickAreaId a(Integer paramInteger)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.AD_ICON;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((RoundImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.HOST_AVATAR;
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((TextView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.HOST_NAME;
    }
    localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((TextView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.AD_DESCRIPTION;
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((TextView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.AD_BUTTON;
    }
    localObject1 = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ViewGroup)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.INDUSTRY_LABEL;
    }
    localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.NEGATIVE_FEEDBACK;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((GdtAdWSCountDownLayout)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.COUNTDOWN_WIDGET;
    }
    localObject1 = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((URLImageView)localObject1).getId());
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(paramInteger, localObject1)) {
      return VasAdvWSVerticalClickAreaId.MARKETING_PENDANT_WIDGET;
    }
    GdtDanmakuPresenter localGdtDanmakuPresenter = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131380790));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370335));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131376773));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)paramView.findViewById(2131376635));
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
    if (localObject != null)
    {
      ((RoundImageView)localObject).setBorderWidth(8);
      ((RoundImageView)localObject).setBorderColor(jdField_b_of_type_Int);
      ((RoundImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379967));
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379966));
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369544));
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.c = ((TextView)paramView.findViewById(2131379965));
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367521));
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout = ((GdtAdWSCountDownLayout)paramView.findViewById(2131380377));
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localObject != null) {
      ((GdtAdWSCountDownLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131380379));
    localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject != null) {
      ((URLImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370267));
    localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this);
    }
    this.jdField_a_of_type_JavaUtilList = CollectionsKt.mutableListOf(new TextView[] { (TextView)paramView.findViewById(2131367576), (TextView)paramView.findViewById(2131367577), (TextView)paramView.findViewById(2131367578) });
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter = ((GdtDanmakuPresenter)paramView.findViewById(2131380378));
    paramView = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
    if (paramView != null) {
      paramView.setOnClickListener((View.OnClickListener)this);
    }
    g();
  }
  
  private final void a(boolean paramBoolean, VasAdvWSVerticalClickAreaId paramVasAdvWSVerticalClickAreaId)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      localObject = (Activity)localObject;
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
      if (localAdInfo != null)
      {
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
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
  
  private final boolean a()
  {
    GdtAdWSCountDownLayout localGdtAdWSCountDownLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localGdtAdWSCountDownLayout != null)
    {
      IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
      Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
      if (localObject != null) {
        localObject = ((stSimpleMetaGdtAdInfo)localObject).gdtTangramAdJson;
      } else {
        localObject = null;
      }
      int i = localIVasAdvApi.getGdtCountdownTime((String)localObject);
      if (i > 0) {
        return localGdtAdWSCountDownLayout.a(i);
      }
      localGdtAdWSCountDownLayout.c();
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
        Object localObject3 = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
        localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
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
      if (i != 0)
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
      int i = 0;
      continue;
      label124:
      i = 1;
    }
  }
  
  private final boolean c()
  {
    Object localObject1 = ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).getIndustryLabels(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    int k = 8;
    int i;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        boolean bool1 = false;
        i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          localObject3 = (TextView)localObject3;
          Object localObject4 = (VasAdvWSVerticalItemView)this;
          bool2 = bool1;
          if (localObject3 != null)
          {
            localObject4 = (CharSequence)CollectionsKt.getOrNull((List)localObject1, i);
            boolean bool3 = true;
            int j;
            if ((localObject4 != null) && (!StringsKt.isBlank((CharSequence)localObject4))) {
              j = 0;
            } else {
              j = 1;
            }
            int m = j ^ 0x1;
            if (m != 0) {
              j = 0;
            } else {
              j = 8;
            }
            ((TextView)localObject3).setVisibility(j);
            ((TextView)localObject3).setText((CharSequence)localObject4);
            bool2 = bool3;
            if (!bool1) {
              if (m != 0) {
                bool2 = bool3;
              } else {
                bool2 = false;
              }
            }
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
    boolean bool2 = false;
    localObject1 = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject1 != null)
    {
      i = k;
      if (bool2) {
        i = 0;
      }
      ((ViewGroup)localObject1).setVisibility(i);
    }
    return bool2;
  }
  
  private final boolean d()
  {
    GdtDanmakuPresenter localGdtDanmakuPresenter = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
    int i;
    if (localGdtDanmakuPresenter != null)
    {
      try
      {
        IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
        localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
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
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        label62:
        boolean bool;
        QLog.e("VasAdvWSVerticalItemView", 1, "fail to get danmaku contents", localThrowable);
        localGdtDanmakuPresenter.setVisibility(8);
      }
      if (i != 0)
      {
        if (localGdtDanmakuPresenter.b()) {
          localGdtDanmakuPresenter.a();
        }
        localGdtDanmakuPresenter.setVisibility(8);
        return false;
      }
      localGdtDanmakuPresenter.a(AdUIUtils.getScreenWidth(this.jdField_a_of_type_AndroidContentContext), (String[])localObject1);
      bool = localGdtDanmakuPresenter.a();
      if (!bool) {
        break label170;
      }
      i = 0;
    }
    for (;;)
    {
      localGdtDanmakuPresenter.setVisibility(i);
      return bool;
      return false;
      label146:
      Object localObject2 = null;
      break;
      label151:
      i = 0;
      if (i == 0)
      {
        i = 0;
        break label62;
      }
      label165:
      i = 1;
      break label62;
      label170:
      i = 8;
    }
  }
  
  private final void f()
  {
    if ((!a()) && (!b())) {
      c();
    }
    d();
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
    if (localObject != null) {
      bool = ((stSimpleMetaGdtAdInfo)localObject).isGdtAdImpressionReport;
    } else {
      bool = true;
    }
    if (!bool)
    {
      localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
      if (localObject != null) {
        localObject = ((stSimpleMetaGdtAdInfo)localObject).impressionUrl;
      } else {
        localObject = null;
      }
      if ((localObject != null) && (this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null))
      {
        IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
        View localView = this.jdField_a_of_type_AndroidViewView;
        Intrinsics.checkExpressionValueIsNotNull(localView, "mItemView");
        localIVasAdvApi.doExposure((String)localObject, localView, this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo, this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonCallbackVasResultCallback);
      }
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
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
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
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localObject != null) {
      ((GdtAdWSCountDownLayout)localObject).b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout = ((GdtAdWSCountDownLayout)null);
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter;
    if (localObject != null) {
      ((GdtDanmakuPresenter)localObject).a();
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter = ((GdtDanmakuPresenter)null);
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
    Object localObject2 = null;
    if (paramWSVerticalItemData != null) {
      localstSimpleMetaFeed = paramWSVerticalItemData.a();
    } else {
      localstSimpleMetaFeed = null;
    }
    Object localObject1 = localstSimpleMetaFeed;
    if (!(localstSimpleMetaFeed instanceof stSimpleMetaFeed)) {
      localObject1 = null;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localObject1);
    if (paramWSVerticalItemData != null) {
      paramWSVerticalItemData = paramWSVerticalItemData.a();
    } else {
      paramWSVerticalItemData = null;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo = paramWSVerticalItemData;
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = GdtAdUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if (localstSimpleMetaFeed != null)
    {
      paramWSVerticalItemData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
      Object localObject3;
      if (paramWSVerticalItemData != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext;
        localObject3 = (ImageView)paramWSVerticalItemData;
        paramWSVerticalItemData = localstSimpleMetaFeed.poster;
        if (paramWSVerticalItemData != null) {
          paramWSVerticalItemData = paramWSVerticalItemData.avatar;
        } else {
          paramWSVerticalItemData = null;
        }
        WSPicLoader.a((Context)localObject1, (ImageView)localObject3, paramWSVerticalItemData);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null)
      {
        localObject3 = localstSimpleMetaFeed.poster;
        paramWSVerticalItemData = localObject2;
        if (localObject3 != null) {
          paramWSVerticalItemData = ((stSimpleMetaPerson)localObject3).nick;
        }
        ((TextView)localObject1).setText((CharSequence)paramWSVerticalItemData);
      }
      paramWSVerticalItemData = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramWSVerticalItemData != null) {
        paramWSVerticalItemData.setText((CharSequence)localstSimpleMetaFeed.feed_desc);
      }
      e();
      f();
    }
    paramWSVerticalItemData = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (paramWSVerticalItemData != null)
    {
      ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).subscribe("ws_video_ad_h5_cover", (VasAdvWebEvent.Subscriber)this);
      if (paramWSVerticalItemData.getUrl() != null) {
        paramWSVerticalItemData.clearHistory();
      }
      paramWSVerticalItemData.loadUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b()
  {
    super.b();
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).getWebView((Activity)localObject);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)this);
    localObject = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380781);
    if (localObject != null)
    {
      ((ViewStub)localObject).setLayoutResource(2131563016);
      localObject = ((ViewStub)localObject).inflate();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "inflate()");
      a((View)localObject);
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if ((localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1))
    {
      localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((stSimpleMetaFeed)localObject1).gdt_ad_info;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
        if ((localObject1 == null) || (((stSimpleMetaGdtAdInfo)localObject1).isGdtAdOriginalImpressionReport != true))
        {
          IVasAdvApi localIVasAdvApi = (IVasAdvApi)QRoute.api(IVasAdvApi.class);
          Context localContext = this.jdField_a_of_type_AndroidContentContext;
          Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
          stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
          localObject1 = localObject2;
          if (localstSimpleMetaFeed != null) {
            localObject1 = localstSimpleMetaFeed.gdt_ad_info;
          }
          boolean bool = localIVasAdvApi.doOriginalExposure(localContext, (String)localObject1, this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
          localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
          if (localObject1 != null) {
            ((stSimpleMetaGdtAdInfo)localObject1).isGdtAdOriginalImpressionReport = bool;
          }
        }
        h();
      }
    }
  }
  
  public void c()
  {
    ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).unsubscribe("ws_video_ad_h5_cover", (VasAdvWebEvent.Subscriber)this);
  }
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public final void e()
  {
    Object localObject1 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
    if (localObject1 != null)
    {
      localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).product_type;
      if ((localObject1 != null) && (((PBUInt32Field)localObject1).get() == 12))
      {
        i = 1;
        break label34;
      }
    }
    int i = 0;
    label34:
    localObject1 = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
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
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
    boolean bool = ((IVasAdvApi)localObject3).isAppInstalled(localContext, (String)localObject1);
    if (i != 0)
    {
      if (bool) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131705324);
      } else {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131716389);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
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
        localObject3 = this.jdField_a_of_type_UserGrowthStSimpleMetaGdtAdInfo;
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
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131716102);
      }
    }
    localObject2 = (CharSequence)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = this.c;
      if (localObject3 != null) {
        ((TextView)localObject3).setText((CharSequence)localObject2);
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
  }
  
  public void onClick(@Nullable View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    Object localObject2 = null;
    if ((localObject1 != null) && (((stSimpleMetaFeed)localObject1).gdt_ad_type == 1))
    {
      localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      if (localObject1 != null) {
        localObject1 = ((stSimpleMetaFeed)localObject1).gdt_ad_info;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        h();
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
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 2131369544))
    {
      i();
      return;
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 2131370335))
    {
      a(true, localVasAdvWSVerticalClickAreaId);
      return;
    }
    a(false, localVasAdvWSVerticalClickAreaId);
  }
  
  public void onVasEvent(@NotNull String paramString, @Nullable VasAdvWebEvent.Callback paramCallback, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventKey");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "data");
    int j = paramString.hashCode();
    int i = 0;
    if (j != -62987789)
    {
      if (j != -39557675)
      {
        if (j != 1540946822) {
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
            i();
          }
        }
      }
      else if (paramString.equals("get_gdt_ad_data"))
      {
        paramString = this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
        if (paramString != null) {
          paramString = ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).convertPbToJson((PBField)paramString);
        } else {
          paramString = null;
        }
        paramVarArgs = (CharSequence)paramString;
        if ((paramVarArgs == null) || (paramVarArgs.length() == 0)) {
          i = 1;
        }
        if (i != 0)
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
        j();
        return;
      }
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalItemView
 * JD-Core Version:    0.7.0.1
 */