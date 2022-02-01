package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.gamecenter.wadl.biz.entity.WadlResult;>;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.open.downloadnew.DownloadInfo;>;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/open/downloadnew/DownloadListener;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/SoftReference;", "setActivity", "(Ljava/lang/ref/SoftReference;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "dialog", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;", "getDialog", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;", "setDialog", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;)V", "downloadBtn", "Landroid/widget/TextView;", "getDownloadBtn", "()Landroid/widget/TextView;", "setDownloadBtn", "(Landroid/widget/TextView;)V", "downloadContainer", "getDownloadContainer", "()Landroid/widget/FrameLayout;", "setDownloadContainer", "(Landroid/widget/FrameLayout;)V", "downloadScene", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "getDownloadScene", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "setDownloadScene", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;)V", "downloadStyle", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "getDownloadStyle", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setDownloadStyle", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;)V", "hasRefreshBtn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "horizontalProgress", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "getHorizontalProgress", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "setHorizontalProgress", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "setImageIcon", "(Landroid/widget/ImageView;)V", "inFloatingBar", "", "getInFloatingBar", "()Z", "setInFloatingBar", "(Z)V", "inPtsCard", "getInPtsCard", "setInPtsCard", "needCallInit", "roundProgress", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "getRoundProgress", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "setRoundProgress", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;)V", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "setViewRoot", "(Landroid/view/View;)V", "changeToHighLightBtn", "", "clickBtnForDownloadAd", "doNotCallDownloadInit", "getAdInfo", "getDownloadData", "getEx5", "", "getGamePkgName", "getProgressView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "inDownloadingState", "initBtnText", "installSucceed", "appid", "packageName", "needRlForDownload", "onAttachedToWindow", "onBtnCLickEvent", "onDetachedFromWindow", "onDownloadCancel", "info", "Lcom/tencent/open/downloadnew/DownloadInfo;", "onDownloadClickEvent", "adClickPos", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/AdClickPos;", "clickPos", "", "onDownloadError", "errorCode", "errorMsg", "state", "onDownloadFinish", "onDownloadPause", "onDownloadUpdate", "infos", "", "onDownloadWait", "onPause", "onProgressClickEvent", "onQueryCallback", "wadlResults", "Ljava/util/ArrayList;", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "onQueryCallbackVia", "onResult", "isSuccess", "advertisementInfo", "pkgName", "onResume", "onWadlTaskStatusChanged", "wadlResult", "packageReplaced", "realSetDownloadData", "downloadData", "refreshBtnText", "force", "setAdvertisementInfo", "setDownloadData", "setHorizontalProgressStyle", "iDownloadStyle", "setProgressStyle", "setRoundProgressStyle", "shouldShowStartImageIcon", "showButton", "showCenterImageIconWhenShowProgress", "showProgress", "showCenterImageIcon", "showStartImageIcon", "showTwoBtnText", "uninstallSucceed", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class RIJDownloadView
  extends FrameLayout
  implements WadlProxyServiceCallBackInterface, DownloadListener
{
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  @Nullable
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @Nullable
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  @NotNull
  private AdDownloadScene jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.PTSCard;
  @Nullable
  private IDownloadStyle jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
  @Nullable
  private RIJHorizontalProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
  @Nullable
  private RIJRoundProgressBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
  private volatile ADVideoAppDownloadData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  @Nullable
  private GiftPackageDialog jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
  @Nullable
  private SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private boolean jdField_b_of_type_Boolean;
  
  public RIJDownloadView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getSystemService("layout_inflater");
    boolean bool = paramContext instanceof LayoutInflater;
    paramAttributeSet = null;
    if (!bool) {
      paramContext = null;
    }
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext;
    paramContext = paramAttributeSet;
    if (localLayoutInflater != null) {
      paramContext = localLayoutInflater.inflate(2131560064, (ViewGroup)this);
    }
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362816));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress = ((RIJHorizontalProgress)paramContext.findViewById(2131368271));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar = ((RIJRoundProgressBar)paramContext.findViewById(2131376844));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext.findViewById(2131370523));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131368538));
    }
  }
  
  private final void a(IDownloadStyle paramIDownloadStyle)
  {
    Object localObject = paramIDownloadStyle;
    if (!(paramIDownloadStyle instanceof HorizontalProgressStyle)) {
      localObject = null;
    }
    paramIDownloadStyle = (HorizontalProgressStyle)localObject;
    if (paramIDownloadStyle == null) {
      paramIDownloadStyle = HorizontalProgressStyle.DefaultHorizontalStyle;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(paramIDownloadStyle.getBtnTextSize());
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(ParseUtil.a(paramIDownloadStyle.getBtnTextColor(), "#FF12B7F5"));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(ParseUtil.a(paramIDownloadStyle.getBtnDrawableNormalColor(), "#00000000"));
      IRIJAdUIService localIRIJAdUIService = (IRIJAdUIService)QRoute.api(IRIJAdUIService.class);
      float f = paramIDownloadStyle.getBtnDrawableNormalRadius();
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localGradientDrawable.setCornerRadius(localIRIJAdUIService.dp2px(f, localContext.getResources()));
      ((TextView)localObject).setBackgroundDrawable((Drawable)localGradientDrawable);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
    if (localObject != null) {
      ((RIJHorizontalProgress)localObject).setProgressStyle((IDownloadStyle)paramIDownloadStyle);
    }
  }
  
  private final void a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Object localObject = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).getDownloadCache(paramADVideoAppDownloadData.d);
    if (localObject != null)
    {
      b((ADVideoAppDownloadData)localObject);
    }
    else
    {
      b(paramADVideoAppDownloadData);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).addDownloadCache(paramADVideoAppDownloadData);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDownloadData: packageName = ");
    ((StringBuilder)localObject).append(paramADVideoAppDownloadData.d);
    ((StringBuilder)localObject).append(" view = ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("AD_DOWNLOAD_TAG", 1, ((StringBuilder)localObject).toString());
    onAttachedToWindow();
  }
  
  private final boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    int i = 0;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if (paramAdvertisementInfo.mSoftAdType != 0) {
      i = 1;
    }
    if (i != 0) {
      return ((IRIJAdService)QRoute.api(IRIJAdService.class)).needReportSoftNew();
    }
    return ((IRIJAdService)QRoute.api(IRIJAdService.class)).needReportNew();
  }
  
  private final String b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return "1";
    }
    return "2";
  }
  
  private final void b(IDownloadStyle paramIDownloadStyle)
  {
    Object localObject = paramIDownloadStyle;
    if (!(paramIDownloadStyle instanceof RoundProgressStyle)) {
      localObject = null;
    }
    paramIDownloadStyle = (RoundProgressStyle)localObject;
    if (paramIDownloadStyle == null) {
      paramIDownloadStyle = RoundProgressStyle.DefaultRoundStyle;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(paramIDownloadStyle.getBtnTextSize());
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(ParseUtil.a(paramIDownloadStyle.getBtnTextColor(), "#FF12B7F5"));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(ParseUtil.a(paramIDownloadStyle.getBtnDrawableNormalColor(), "#00000000"));
      IRIJAdUIService localIRIJAdUIService = (IRIJAdUIService)QRoute.api(IRIJAdUIService.class);
      float f = paramIDownloadStyle.getBtnDrawableNormalRadius();
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localGradientDrawable.setCornerRadius(localIRIJAdUIService.dp2px(f, localContext.getResources()));
      ((TextView)localObject).setBackgroundDrawable((Drawable)localGradientDrawable);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
    if (localObject != null) {
      ((RIJRoundProgressBar)localObject).setProgressStyle((IDownloadStyle)paramIDownloadStyle);
    }
    int i = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(paramIDownloadStyle.getRoundSize(), getResources());
    paramIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
    if (paramIDownloadStyle != null)
    {
      localObject = new FrameLayout.LayoutParams(i, i);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      paramIDownloadStyle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    i = (int)(i * 0.5F);
    paramIDownloadStyle = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramIDownloadStyle != null)
    {
      localObject = new FrameLayout.LayoutParams(i, i);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      paramIDownloadStyle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    if (paramIDownloadStyle != null)
    {
      i = ((RoundProgressStyle)paramIDownloadStyle).getBtnResource();
      if (i != -1)
      {
        paramIDownloadStyle = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramIDownloadStyle != null) {
          paramIDownloadStyle.setBackgroundResource(i);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
  }
  
  private final void b(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AD_DOWNLOAD_TAG", "data = null , so setNewDownloadData");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = paramADVideoAppDownloadData;
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    String str = null;
    if (localObject != null) {
      localObject = ((ADVideoAppDownloadData)localObject).d;
    } else {
      localObject = null;
    }
    if (paramADVideoAppDownloadData != null) {
      str = paramADVideoAppDownloadData.d;
    }
    if ((Intrinsics.areEqual(localObject, str) ^ true))
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AD_DOWNLOAD_TAG", "data packageName is not same , so setNewDownloadData");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = paramADVideoAppDownloadData;
    }
  }
  
  private final void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        if (c()) {
          localObject = (CharSequence)"查看";
        } else {
          localObject = (CharSequence)"查看详情";
        }
        localTextView.setText((CharSequence)localObject);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject != null) {
      localObject = ((AdvertisementInfo)localObject).mAdBtnTxt;
    } else {
      localObject = null;
    }
    localObject = (CharSequence)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject);
      }
      return;
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (c()) {
        localObject = (CharSequence)"查看";
      } else {
        localObject = (CharSequence)"查看详情";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private final void h()
  {
    Object localObject3 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clickBtn : packageName = ");
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ADVideoAppDownloadData)localObject1).d;
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" currentState = ");
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ADVideoAppDownloadData)localObject1).jdField_a_of_type_Int);
    } else {
      localObject1 = null;
    }
    localStringBuilder.append(localObject1);
    ((IRIJAdLogService)localObject3).d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isDownloadAd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      i();
      return;
    }
    if ((!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameSubscribeAd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameGiftAd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if ((localObject1 != null) && (((ADVideoAppDownloadData)localObject1).jdField_b_of_type_Boolean == true))
      {
        localObject3 = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localObject1 != null) {
          localObject1 = ((ADVideoAppDownloadData)localObject1).d;
        } else {
          localObject1 = null;
        }
        boolean bool2 = ((IRIJAdUtilService)localObject3).isAppInstall((String)localObject1);
        localObject1 = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).getDownloadEngine(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
        boolean bool1;
        if (localObject1 != null) {
          bool1 = ((IDownloadEngine)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
        } else {
          bool1 = false;
        }
        if ((!bool2) && (bool1))
        {
          localObject1 = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).getDownloadEngine(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
          if (localObject1 != null) {
            ((IDownloadEngine)localObject1).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
          }
          ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportAdDownloadClick(getContext(), DownloadClickState.INSTALL_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          return;
        }
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AD_DOWNLOAD_TAG", "do not found local game pkg file");
      }
      if ((getContext() instanceof Activity))
      {
        localObject1 = getContext();
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
      }
      else
      {
        localObject3 = this.jdField_a_of_type_JavaLangRefSoftReference;
        localObject1 = localObject2;
        if (localObject3 == null) {
          break label416;
        }
        localObject1 = ((SoftReference)localObject3).get();
      }
      localObject1 = (Activity)localObject1;
      label416:
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).showGiftDialog(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Context)localObject1, this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportGameGiftClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, -1, b());
    }
  }
  
  private final void i()
  {
    Object localObject2 = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    AdvertisementInfo localAdvertisementInfo = null;
    if (localObject1 != null) {
      localObject1 = ((ADVideoAppDownloadData)localObject1).d;
    } else {
      localObject1 = null;
    }
    if (((IRIJAdUtilService)localObject2).isAppInstall((String)localObject1))
    {
      if ((getContext() instanceof Activity))
      {
        localObject1 = getContext();
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_JavaLangRefSoftReference;
        localObject1 = localAdvertisementInfo;
        if (localObject2 == null) {
          break label102;
        }
        localObject1 = ((SoftReference)localObject2).get();
      }
      localObject1 = (Activity)localObject1;
      label102:
      localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      int i;
      if (localAdvertisementInfo != null) {
        i = localAdvertisementInfo.clickPos;
      } else {
        i = 8;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).openApp((Activity)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        if (localObject1 != null) {
          ((AdvertisementInfo)localObject1).clickPos = i;
        }
        ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportAdDownloadClick(getContext(), DownloadClickState.OPEN_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
        return;
      }
    }
    localObject1 = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).getDownloadEngine(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    if ((localObject1 != null) && (((IDownloadEngine)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData) == true) && (((IDownloadEngine)localObject1).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData)))
    {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportAdDownloadClick(getContext(), DownloadClickState.INSTALL_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
      return;
    }
    boolean bool;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameDownloadAd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      bool = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).doGameDownload(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    } else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSoftDownloadAd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      bool = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).doSoftAppDownload(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    } else {
      bool = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).doNormalAppDownload(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    }
    if (bool) {
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).reportAdDownloadClick(getContext(), DownloadClickState.START_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
    }
  }
  
  @Nullable
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final AdvertisementInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  }
  
  @NotNull
  public final AdDownloadScene a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene;
  }
  
  @Nullable
  public final ADVideoAppDownloadData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  }
  
  @Nullable
  public final GiftPackageDialog a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
  }
  
  @Nullable
  protected final String a()
  {
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getGamePkgName(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public final void a()
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume : packageName = ");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject != null) {
      localObject = ((ADVideoAppDownloadData)localObject).d;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" view = ");
    localStringBuilder.append(hashCode());
    localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    a(this, false, 1, null);
  }
  
  public final void a(int paramInt)
  {
    a(null, paramInt);
  }
  
  public final void a(@Nullable AdClickPos paramAdClickPos, int paramInt)
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localAdvertisementInfo != null) {
      localAdvertisementInfo.setClickPos(paramInt);
    }
    localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localAdvertisementInfo != null) {
      localAdvertisementInfo.setAdClickPos(paramAdClickPos);
    }
    h();
  }
  
  public void a(@Nullable WadlResult paramWadlResult)
  {
    Object localObject3 = null;
    WadlParams localWadlParams = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    AdDownloadInfo localAdDownloadInfo = null;
    if (paramWadlResult != null)
    {
      localObject1 = paramWadlResult.a;
      if (localObject1 != null)
      {
        localObject1 = ((WadlParams)localObject1).f;
        break label41;
      }
    }
    Object localObject1 = null;
    label41:
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject2 != null) {
        localObject2 = ((ADVideoAppDownloadData)localObject2).d;
      } else {
        localObject2 = null;
      }
      if ((Intrinsics.areEqual(localObject1, localObject2) ^ true)) {
        return;
      }
      if (paramWadlResult != null) {
        localObject2 = Integer.valueOf(paramWadlResult.jdField_b_of_type_Int);
      } else {
        localObject2 = null;
      }
      if ((localObject2 != null) && (((Integer)localObject2).intValue() == 4))
      {
        localObject2 = AdDownloadStateHandler.OnProgressUpdate;
        localObject3 = new AdDownloadInfo();
        ((AdDownloadInfo)localObject3).a((String)localObject1);
        localWadlParams = paramWadlResult.a;
        localObject1 = localAdDownloadInfo;
        if (localWadlParams != null) {
          localObject1 = localWadlParams.jdField_a_of_type_JavaLangString;
        }
        ((AdDownloadInfo)localObject3).c((String)localObject1);
        ((AdDownloadInfo)localObject3).a(((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).convertToDownloadState(paramWadlResult));
        ((AdDownloadInfo)localObject3).b(paramWadlResult.d);
        ((AdDownloadStateHandler)localObject2).doCallBack(this, (AdDownloadInfo)localObject3);
        return;
      }
      if ((localObject2 != null) && (((Integer)localObject2).intValue() == 6))
      {
        localObject2 = AdDownloadStateHandler.OnSuccessDownload;
        localAdDownloadInfo = new AdDownloadInfo();
        localAdDownloadInfo.a((String)localObject1);
        localWadlParams = paramWadlResult.a;
        localObject1 = localObject3;
        if (localWadlParams != null) {
          localObject1 = localWadlParams.jdField_a_of_type_JavaLangString;
        }
        localAdDownloadInfo.c((String)localObject1);
        ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localObject1 != null) {
          ((ADVideoAppDownloadData)localObject1).i = paramWadlResult.jdField_b_of_type_JavaLangString;
        }
      }
      else
      {
        if ((localObject2 != null) && (((Integer)localObject2).intValue() == 5))
        {
          localObject2 = AdDownloadStateHandler.OnPauseDownload;
          localAdDownloadInfo = new AdDownloadInfo();
          localAdDownloadInfo.a((String)localObject1);
          localObject1 = paramWadlResult.a;
          paramWadlResult = localWadlParams;
          if (localObject1 != null) {
            paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
          }
          localAdDownloadInfo.c(paramWadlResult);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
          return;
        }
        if ((localObject2 != null) && (((Integer)localObject2).intValue() == 9))
        {
          localObject2 = AdDownloadStateHandler.OnInstallSucceed;
          localAdDownloadInfo = new AdDownloadInfo();
          localAdDownloadInfo.a((String)localObject1);
          localObject1 = paramWadlResult.a;
          paramWadlResult = localObject4;
          if (localObject1 != null) {
            paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
          }
          localAdDownloadInfo.c(paramWadlResult);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
          return;
        }
        if ((localObject2 != null) && (((Integer)localObject2).intValue() == 10))
        {
          localObject2 = AdDownloadStateHandler.OnInstallSucceed;
          localAdDownloadInfo = new AdDownloadInfo();
          localAdDownloadInfo.a((String)localObject1);
          localObject1 = paramWadlResult.a;
          paramWadlResult = localObject5;
          if (localObject1 != null) {
            paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
          }
          localAdDownloadInfo.c(paramWadlResult);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
          return;
        }
        if (localObject2 == null) {
          return;
        }
        if (((Integer)localObject2).intValue() == 7)
        {
          localObject2 = AdDownloadStateHandler.OnErrorDownload;
          localAdDownloadInfo = new AdDownloadInfo();
          localAdDownloadInfo.a((String)localObject1);
          localObject3 = paramWadlResult.a;
          localObject1 = localObject6;
          if (localObject3 != null) {
            localObject1 = ((WadlParams)localObject3).jdField_a_of_type_JavaLangString;
          }
          localAdDownloadInfo.c((String)localObject1);
          localAdDownloadInfo.c(paramWadlResult.c);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
        }
      }
    }
  }
  
  public void a(@Nullable ArrayList<WadlResult> paramArrayList)
  {
    AdDownloadStateHandler localAdDownloadStateHandler = null;
    AdDownloadInfo localAdDownloadInfo = null;
    Object localObject3;
    if (paramArrayList != null)
    {
      localObject3 = ((Iterable)paramArrayList).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        paramArrayList = ((WadlResult)localObject2).a;
        if (paramArrayList != null) {
          paramArrayList = paramArrayList.e;
        } else {
          paramArrayList = null;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localObject1 != null) {
          localObject1 = ((ADVideoAppDownloadData)localObject1).c;
        } else {
          localObject1 = null;
        }
        if (Intrinsics.areEqual(paramArrayList, localObject1))
        {
          paramArrayList = (ArrayList<WadlResult>)localObject2;
          break label104;
        }
      }
      paramArrayList = null;
      label104:
      paramArrayList = (WadlResult)paramArrayList;
    }
    else
    {
      paramArrayList = null;
    }
    if (paramArrayList != null)
    {
      localObject1 = paramArrayList.a.f;
      int i = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).convertToDownloadState(paramArrayList);
      int j = paramArrayList.d;
      localAdDownloadStateHandler = AdDownloadStateHandler.OnQueryResult;
      localObject2 = new AdDownloadInfo();
      ((AdDownloadInfo)localObject2).a((String)localObject1);
      localObject3 = paramArrayList.a;
      localObject1 = localAdDownloadInfo;
      if (localObject3 != null) {
        localObject1 = ((WadlParams)localObject3).jdField_a_of_type_JavaLangString;
      }
      ((AdDownloadInfo)localObject2).c((String)localObject1);
      ((AdDownloadInfo)localObject2).a(i);
      ((AdDownloadInfo)localObject2).b(j);
      ((AdDownloadInfo)localObject2).d(paramArrayList.jdField_b_of_type_JavaLangString);
      ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).checkRealState((AdDownloadInfo)localObject2);
      localAdDownloadStateHandler.doCallBack(this, (AdDownloadInfo)localObject2);
      return;
    }
    Object localObject1 = AdDownloadStateHandler.OnQueryResult;
    localAdDownloadInfo = new AdDownloadInfo();
    paramArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (paramArrayList != null) {
      paramArrayList = paramArrayList.d;
    } else {
      paramArrayList = null;
    }
    localAdDownloadInfo.a(paramArrayList);
    paramArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (paramArrayList != null) {
      paramArrayList = paramArrayList.jdField_a_of_type_JavaLangString;
    } else {
      paramArrayList = null;
    }
    localAdDownloadInfo.c(paramArrayList);
    localAdDownloadInfo.a(0);
    localAdDownloadInfo.b(0);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    paramArrayList = localAdDownloadStateHandler;
    if (localObject2 != null) {
      paramArrayList = ((ADVideoAppDownloadData)localObject2).i;
    }
    localAdDownloadInfo.d(paramArrayList);
    ((AdDownloadStateHandler)localObject1).doCallBack(this, localAdDownloadInfo);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) || (paramBoolean))
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localADVideoAppDownloadData != null) {
        ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).getDownloadEngine(localADVideoAppDownloadData).a(this, localADVideoAppDownloadData);
      }
    }
  }
  
  public final void a(boolean paramBoolean, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pkgName");
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty((CharSequence)paramString)) && (Intrinsics.areEqual(paramString, a()))) {}
    try
    {
      paramAdvertisementInfo = QRoute.api(IRIJAdUtilService.class);
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "QRoute.api(IRIJAdUtilService::class.java)");
      paramAdvertisementInfo = ((IRIJAdUtilService)paramAdvertisementInfo).getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "QRoute.api(IRIJAdUtilSer…::class.java).application");
      paramAdvertisementInfo = paramAdvertisementInfo.getResources().getString(2131717919);
      paramString = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramString != null) {
        paramString.setText((CharSequence)paramAdvertisementInfo);
      }
      paramAdvertisementInfo = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setTextColor(-6447715);
      }
      paramAdvertisementInfo = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickable(false);
      }
      paramAdvertisementInfo = getRootView();
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "rootView");
      paramAdvertisementInfo.setClickable(false);
      return;
    }
    catch (Throwable paramAdvertisementInfo) {}
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void b()
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause : packageName = ");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject != null) {
      localObject = ((ADVideoAppDownloadData)localObject).d;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" view = ");
    localStringBuilder.append(hashCode());
    localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
    if (localObject != null) {
      ((GiftPackageDialog)localObject).dismiss();
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public void b(@Nullable ArrayList<WadlResult> paramArrayList) {}
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final void c()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof HorizontalProgressStyle)) {
      localObject1 = null;
    }
    Object localObject3 = (HorizontalProgressStyle)localObject1;
    if (localObject3 != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setColor(Color.parseColor(((HorizontalProgressStyle)localObject3).getBtnDrawableActiveColor()));
        IRIJAdUIService localIRIJAdUIService = (IRIJAdUIService)QRoute.api(IRIJAdUIService.class);
        float f = ((HorizontalProgressStyle)localObject3).getBtnDrawableActiveRadius();
        localObject3 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
        ((GradientDrawable)localObject2).setCornerRadius(localIRIJAdUIService.dp2px(f, ((Context)localObject3).getResources()));
        ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      }
    }
  }
  
  public final boolean c()
  {
    IDownloadStyle localIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    boolean bool = false;
    int i;
    if (localIDownloadStyle != null) {
      i = localIDownloadStyle.getBtnTextLength();
    } else {
      i = 0;
    }
    if (i < 4) {
      bool = true;
    }
    return bool;
  }
  
  public final void d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
    if (localObject1 != null) {
      ((RIJRoundProgressBar)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
    if (localObject1 != null) {
      ((RIJHorizontalProgress)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(0);
    }
    IRIJAdUIService localIRIJAdUIService = (IRIJAdUIService)QRoute.api(IRIJAdUIService.class);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    localObject1 = localObject2;
    if (!(localObject2 instanceof RoundProgressStyle)) {
      localObject1 = null;
    }
    localObject1 = (RoundProgressStyle)localObject1;
    float f;
    if (localObject1 != null) {
      f = ((RoundProgressStyle)localObject1).getImageIconWidth();
    } else {
      f = 14.0F;
    }
    int i = localIRIJAdUIService.dp2px(f, getResources());
    localIRIJAdUIService = (IRIJAdUIService)QRoute.api(IRIJAdUIService.class);
    localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    localObject1 = localObject2;
    if (!(localObject2 instanceof RoundProgressStyle)) {
      localObject1 = null;
    }
    localObject1 = (RoundProgressStyle)localObject1;
    if (localObject1 != null) {
      f = ((RoundProgressStyle)localObject1).getImageIconHeight();
    } else {
      f = 16.0F;
    }
    int j = localIRIJAdUIService.dp2px(f, getResources());
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject1 != null)
    {
      localObject2 = new FrameLayout.LayoutParams(i, j);
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      ((ImageView)localObject1).setAlpha(1.0F);
    }
  }
  
  public final boolean d()
  {
    IDownloadStyle localIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    if ((localIDownloadStyle instanceof RoundProgressStyle)) {
      if (localIDownloadStyle != null)
      {
        if (((RoundProgressStyle)localIDownloadStyle).getBtnResource() != -1) {
          return true;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      }
    }
    return false;
  }
  
  public final void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
    if (localObject != null) {
      ((RIJRoundProgressBar)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
    if (localObject != null) {
      ((RIJHorizontalProgress)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public final boolean e()
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localADVideoAppDownloadData != null)
    {
      int i = localADVideoAppDownloadData.jdField_a_of_type_Int;
      if (i != 3)
      {
        bool1 = bool2;
        if (i != 4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void f()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public void installSucceed(@Nullable String paramString1, @Nullable String paramString2)
  {
    AdDownloadStateHandler localAdDownloadStateHandler = AdDownloadStateHandler.OnInstallSucceed;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    localAdDownloadInfo.a(paramString2);
    localAdDownloadInfo.c(paramString1);
    localAdDownloadStateHandler.doCallBack(this, localAdDownloadInfo);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadEventOnAttachedToWindow(this);
    a(this, false, 1, null);
    GiftPackageDialog localGiftPackageDialog = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
    if (localGiftPackageDialog != null) {
      localGiftPackageDialog.dismiss();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).downloadEventOnDetachedFromWindow(this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public void onDownloadCancel(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject3 = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
    Object localObject2 = null;
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.e;
    } else {
      localObject1 = null;
    }
    if (((IRIJAdUtilService)localObject3).isAppInstall((String)localObject1)) {
      return;
    }
    localObject3 = AdDownloadStateHandler.OnCancelDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    Object localObject1 = localObject2;
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.e;
    }
    localAdDownloadInfo.a((String)localObject1);
    localAdDownloadInfo.c(localAdDownloadInfo.c());
    ((AdDownloadStateHandler)localObject3).doCallBack(this, localAdDownloadInfo);
  }
  
  public void onDownloadError(@Nullable DownloadInfo paramDownloadInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    AdDownloadStateHandler localAdDownloadStateHandler = AdDownloadStateHandler.OnErrorDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    String str;
    if (paramDownloadInfo != null) {
      str = paramDownloadInfo.e;
    } else {
      str = null;
    }
    localAdDownloadInfo.a(str);
    localAdDownloadInfo.c(localAdDownloadInfo.c());
    if (paramDownloadInfo != null) {
      paramInt2 = paramDownloadInfo.f;
    } else {
      paramInt2 = 0;
    }
    localAdDownloadInfo.b(paramInt2);
    localAdDownloadInfo.c(paramInt1);
    localAdDownloadInfo.b(paramString);
    localAdDownloadStateHandler.doCallBack(this, localAdDownloadInfo);
  }
  
  public void onDownloadFinish(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject3 = AdDownloadStateHandler.OnSuccessDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    Object localObject2 = null;
    Object localObject1;
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.e;
    } else {
      localObject1 = null;
    }
    localAdDownloadInfo.a((String)localObject1);
    localAdDownloadInfo.c(localAdDownloadInfo.c());
    ((AdDownloadStateHandler)localObject3).doCallBack(this, localAdDownloadInfo);
    localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (paramDownloadInfo != null) {
        localObject1 = paramDownloadInfo.l;
      }
      ((ADVideoAppDownloadData)localObject3).i = ((String)localObject1);
    }
  }
  
  public void onDownloadPause(@Nullable DownloadInfo paramDownloadInfo)
  {
    AdDownloadStateHandler localAdDownloadStateHandler = AdDownloadStateHandler.OnPauseDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    Object localObject2 = null;
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.e;
    } else {
      localObject1 = null;
    }
    localAdDownloadInfo.a((String)localObject1);
    localAdDownloadInfo.c(localAdDownloadInfo.c());
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("urlStr = ");
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.d;
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("urlPath = ");
    Object localObject1 = localObject2;
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.i;
    }
    localStringBuilder.append((String)localObject1);
    localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
    localAdDownloadStateHandler.doCallBack(this, localAdDownloadInfo);
  }
  
  public void onDownloadUpdate(@Nullable List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      Object localObject2 = ((Iterable)paramList).iterator();
      Object localObject1;
      String str;
      do
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        paramList = null;
        if (!bool) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        str = ((DownloadInfo)localObject1).d;
        ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localADVideoAppDownloadData != null) {
          paramList = localADVideoAppDownloadData.c;
        }
      } while (!Intrinsics.areEqual(str, paramList));
      paramList = (List<DownloadInfo>)localObject1;
      break label79;
      paramList = null;
      label79:
      paramList = (DownloadInfo)paramList;
      if (paramList != null)
      {
        localObject1 = AdDownloadStateHandler.OnProgressUpdate;
        localObject2 = new AdDownloadInfo();
        ((AdDownloadInfo)localObject2).a(paramList.e);
        ((AdDownloadInfo)localObject2).c(((AdDownloadInfo)localObject2).c());
        ((AdDownloadInfo)localObject2).a(3);
        ((AdDownloadInfo)localObject2).b(paramList.f);
        if (((AdDownloadInfo)localObject2).b() > 100) {
          ((AdDownloadInfo)localObject2).b(100);
        }
        ((AdDownloadStateHandler)localObject1).doCallBack(this, (AdDownloadInfo)localObject2);
      }
    }
  }
  
  public void onDownloadWait(@Nullable DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(@Nullable String paramString1, @Nullable String paramString2) {}
  
  public final void setActivity(@Nullable SoftReference<Activity> paramSoftReference)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = paramSoftReference;
  }
  
  public final void setAdvertisementInfo(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    g();
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setVisibility(0);
    }
    boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSoftDownloadAd(paramAdvertisementInfo);
    Object localObject2 = null;
    localObject1 = null;
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene == AdDownloadScene.PTSCard) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.SoftButton;
      }
      if (paramAdvertisementInfo != null) {
        localObject1 = paramAdvertisementInfo.mAdvertisementSoftInfo;
      }
      paramAdvertisementInfo = ADVideoAppDownloadData.a((AdvertisementSoftInfo)localObject1, 0);
      if (paramAdvertisementInfo != null) {
        a(paramAdvertisementInfo);
      }
    }
    else if ((!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameDownloadAd(paramAdvertisementInfo)) && (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameGiftAd(paramAdvertisementInfo)))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo((AbsBaseArticleInfo)paramAdvertisementInfo))
      {
        paramAdvertisementInfo = ADVideoAppDownloadData.a(paramAdvertisementInfo, a(paramAdvertisementInfo));
        if (paramAdvertisementInfo != null) {
          a(paramAdvertisementInfo);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = ((ADVideoAppDownloadData)null);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene == AdDownloadScene.PTSCard) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.GameButton;
      }
      localObject1 = localObject2;
      if (paramAdvertisementInfo != null) {
        localObject1 = paramAdvertisementInfo.gameAdComData;
      }
      paramAdvertisementInfo = ADVideoAppDownloadData.a((GameAdComData)localObject1);
      if (paramAdvertisementInfo != null) {
        a(paramAdvertisementInfo);
      }
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      AdDownloadStateHandler.OnInitDownload.doCallBack(this, new AdDownloadInfo());
    }
  }
  
  public final void setDialog(@Nullable GiftPackageDialog paramGiftPackageDialog)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog = paramGiftPackageDialog;
  }
  
  public final void setDownloadBtn(@Nullable TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void setDownloadContainer(@Nullable FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
  }
  
  public final void setDownloadScene(@NotNull AdDownloadScene paramAdDownloadScene)
  {
    Intrinsics.checkParameterIsNotNull(paramAdDownloadScene, "<set-?>");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = paramAdDownloadScene;
  }
  
  public final void setDownloadStyle(@Nullable IDownloadStyle paramIDownloadStyle)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle = paramIDownloadStyle;
  }
  
  public final void setHorizontalProgress(@Nullable RIJHorizontalProgress paramRIJHorizontalProgress)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress = paramRIJHorizontalProgress;
  }
  
  public final void setImageIcon(@Nullable ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void setInFloatingBar(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final void setInPtsCard(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void setProgressStyle(@Nullable IDownloadStyle paramIDownloadStyle)
  {
    if (paramIDownloadStyle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle = paramIDownloadStyle;
    if (paramIDownloadStyle.getStyleType() == 2)
    {
      b(paramIDownloadStyle);
      return;
    }
    a(paramIDownloadStyle);
  }
  
  public final void setRoundProgress(@Nullable RIJRoundProgressBar paramRIJRoundProgressBar)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar = paramRIJRoundProgressBar;
  }
  
  public final void setViewRoot(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void uninstallSucceed(@Nullable String paramString1, @Nullable String paramString2)
  {
    AdDownloadStateHandler localAdDownloadStateHandler = AdDownloadStateHandler.OnUninstallSucceed;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    localAdDownloadInfo.a(paramString2);
    localAdDownloadInfo.c(paramString1);
    localAdDownloadStateHandler.doCallBack(this, localAdDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView
 * JD-Core Version:    0.7.0.1
 */