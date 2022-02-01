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
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/open/downloadnew/DownloadListener;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/SoftReference;", "setActivity", "(Ljava/lang/ref/SoftReference;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "dialog", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;", "getDialog", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;", "setDialog", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;)V", "downloadBtn", "Landroid/widget/TextView;", "getDownloadBtn", "()Landroid/widget/TextView;", "setDownloadBtn", "(Landroid/widget/TextView;)V", "downloadContainer", "getDownloadContainer", "()Landroid/widget/FrameLayout;", "setDownloadContainer", "(Landroid/widget/FrameLayout;)V", "downloadScene", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "getDownloadScene", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "setDownloadScene", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;)V", "downloadStyle", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "getDownloadStyle", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setDownloadStyle", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;)V", "hasRefreshBtn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "horizontalProgress", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "getHorizontalProgress", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "setHorizontalProgress", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "setImageIcon", "(Landroid/widget/ImageView;)V", "inFloatingBar", "", "getInFloatingBar", "()Z", "setInFloatingBar", "(Z)V", "inPtsCard", "getInPtsCard", "setInPtsCard", "needCallInit", "roundProgress", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "getRoundProgress", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "setRoundProgress", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;)V", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "setViewRoot", "(Landroid/view/View;)V", "changeToHighLightBtn", "", "clickBtnForDownloadAd", "doNotCallDownloadInit", "getAdInfo", "getDownloadData", "getEx5", "", "getGamePkgName", "getProgressView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "inDownloadingState", "initBtnText", "installSucceed", "appid", "packageName", "needRlForDownload", "onAttachedToWindow", "onBtnCLickEvent", "onDetachedFromWindow", "onDownloadCancel", "info", "Lcom/tencent/open/downloadnew/DownloadInfo;", "onDownloadClickEvent", "adClickPos", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/AdClickPos;", "clickPos", "", "onDownloadError", "errorCode", "errorMsg", "state", "onDownloadFinish", "onDownloadPause", "onDownloadUpdate", "infos", "", "onDownloadWait", "onPause", "onProgressClickEvent", "onQueryCallback", "wadlResults", "Ljava/util/ArrayList;", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "onQueryCallbackVia", "onReceiveYYBInstall", "url", "sourceId", "onResult", "isSuccess", "advertisementInfo", "pkgName", "onResume", "onWadlTaskStatusChanged", "wadlResult", "packageReplaced", "realSetDownloadData", "downloadData", "refreshBtnText", "force", "setAdvertisementInfo", "setDownloadData", "setHorizontalProgressStyle", "iDownloadStyle", "setProgressStyle", "setRoundProgressStyle", "shouldShowStartImageIcon", "showButton", "showCenterImageIconWhenShowProgress", "showProgress", "showCenterImageIcon", "showStartImageIcon", "showTwoBtnText", "uninstallSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    paramAttributeSet = paramContext.getSystemService("layout_inflater");
    paramContext = paramAttributeSet;
    if (!(paramAttributeSet instanceof LayoutInflater)) {
      paramContext = null;
    }
    paramAttributeSet = (LayoutInflater)paramContext;
    paramContext = localObject;
    if (paramAttributeSet != null) {
      paramContext = paramAttributeSet.inflate(2131560177, (ViewGroup)this);
    }
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362864));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress = ((RIJHorizontalProgress)paramContext.findViewById(2131368526));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar = ((RIJRoundProgressBar)paramContext.findViewById(2131377394));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext.findViewById(2131370889));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131368810));
    }
  }
  
  private final void a(IDownloadStyle paramIDownloadStyle)
  {
    if (!(paramIDownloadStyle instanceof HorizontalProgressStyle)) {
      paramIDownloadStyle = null;
    }
    for (;;)
    {
      paramIDownloadStyle = (HorizontalProgressStyle)paramIDownloadStyle;
      if (paramIDownloadStyle != null) {}
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
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
          float f = paramIDownloadStyle.getBtnDrawableNormalRadius();
          Context localContext = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
          localGradientDrawable.setCornerRadius(AIOUtils.a(f, localContext.getResources()));
          ((TextView)localObject).setBackgroundDrawable((Drawable)localGradientDrawable);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
        if (localObject != null) {
          ((RIJHorizontalProgress)localObject).setProgressStyle((IDownloadStyle)paramIDownloadStyle);
        }
        return;
        paramIDownloadStyle = HorizontalProgressStyle.DefaultHorizontalStyle;
      }
    }
  }
  
  private final void a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = RIJAdDownloadCache.a.a(paramADVideoAppDownloadData.d);
    if (localADVideoAppDownloadData != null) {
      b(localADVideoAppDownloadData);
    }
    for (;;)
    {
      QLog.d("AD_DOWNLOAD_TAG", 1, "setDownloadData: packageName = " + paramADVideoAppDownloadData.d + " view = " + hashCode());
      onAttachedToWindow();
      return;
      b(paramADVideoAppDownloadData);
      RIJAdDownloadCache.a.a(paramADVideoAppDownloadData);
    }
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
      return AdReportManager.a().b();
    }
    return AdReportManager.a().a();
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
    if (!(paramIDownloadStyle instanceof RoundProgressStyle)) {
      paramIDownloadStyle = null;
    }
    for (;;)
    {
      paramIDownloadStyle = (RoundProgressStyle)paramIDownloadStyle;
      if (paramIDownloadStyle != null) {}
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
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
          float f = paramIDownloadStyle.getBtnDrawableNormalRadius();
          Context localContext = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
          localGradientDrawable.setCornerRadius(AIOUtils.a(f, localContext.getResources()));
          ((TextView)localObject).setBackgroundDrawable((Drawable)localGradientDrawable);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
        if (localObject != null) {
          ((RIJRoundProgressBar)localObject).setProgressStyle((IDownloadStyle)paramIDownloadStyle);
        }
        i = AIOUtils.a(paramIDownloadStyle.getRoundSize(), getResources());
        paramIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
        if (paramIDownloadStyle != null)
        {
          localObject = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          paramIDownloadStyle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        i = (int)(0.5F * i);
        paramIDownloadStyle = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramIDownloadStyle != null)
        {
          localObject = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          paramIDownloadStyle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        paramIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
        if (paramIDownloadStyle != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        paramIDownloadStyle = RoundProgressStyle.DefaultRoundStyle;
      }
      int i = ((RoundProgressStyle)paramIDownloadStyle).getBtnResource();
      if (i != -1)
      {
        paramIDownloadStyle = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramIDownloadStyle != null) {
          paramIDownloadStyle.setBackgroundResource(i);
        }
      }
      return;
    }
  }
  
  private final void b(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null)
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "data = null , so setNewDownloadData");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = paramADVideoAppDownloadData;
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject != null) {}
    for (localObject = ((ADVideoAppDownloadData)localObject).d;; localObject = null)
    {
      if (paramADVideoAppDownloadData != null) {
        str = paramADVideoAppDownloadData.d;
      }
      if (!(Intrinsics.areEqual(localObject, str) ^ true)) {
        break;
      }
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "data packageName is not same , so setNewDownloadData");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = paramADVideoAppDownloadData;
      return;
    }
  }
  
  private final void g()
  {
    TextView localTextView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        if (!c()) {
          break label36;
        }
        localObject = (CharSequence)"查看";
        localTextView.setText((CharSequence)localObject);
      }
    }
    label36:
    label93:
    do
    {
      return;
      localObject = (CharSequence)"查看详情";
      break;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if (localObject != null) {}
      for (localObject = ((AdvertisementInfo)localObject).mAdBtnTxt;; localObject = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label93;
        }
        localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localTextView == null) {
          break;
        }
        localTextView.setText((CharSequence)localObject);
        return;
      }
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    } while (localTextView == null);
    if (c()) {}
    for (Object localObject = (CharSequence)"查看";; localObject = (CharSequence)"查看详情")
    {
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private final void h()
  {
    Object localObject2 = new StringBuilder().append("clickBtn : packageName = ");
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject1 != null)
    {
      localObject1 = ((ADVideoAppDownloadData)localObject1).d;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" currentState = ");
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject1 == null) {
        break label95;
      }
      localObject1 = Integer.valueOf(((ADVideoAppDownloadData)localObject1).jdField_a_of_type_Int);
      label60:
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", localObject1);
      if (!RIJAdDownloadExKt.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        break label100;
      }
      i();
    }
    label95:
    label100:
    while ((RIJAdDownloadExKt.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (!RIJAdDownloadExKt.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label60;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if ((localObject1 != null) && (((ADVideoAppDownloadData)localObject1).jdField_b_of_type_Boolean == true))
    {
      localObject2 = RIJAdDownloadUtil.a;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      boolean bool2;
      if (localObject1 != null)
      {
        localObject1 = ((ADVideoAppDownloadData)localObject1).d;
        bool2 = ((RIJAdDownloadUtil)localObject2).a((String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localObject1 == null) {
          break label265;
        }
        localObject1 = RIJAdDownloadExKt.a((ADVideoAppDownloadData)localObject1);
        if (localObject1 == null) {
          break label265;
        }
      }
      label265:
      for (boolean bool1 = ((IDownloadEngine)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);; bool1 = false)
      {
        if ((bool2) || (!bool1)) {
          break label270;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localObject1 != null)
        {
          localObject1 = RIJAdDownloadExKt.a((ADVideoAppDownloadData)localObject1);
          if (localObject1 != null) {
            ((IDownloadEngine)localObject1).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
          }
        }
        localObject1 = RIJAdDownloadReport.a;
        localObject2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
        RIJAdDownloadReport.a((RIJAdDownloadReport)localObject1, (Context)localObject2, DownloadClickState.INSTALL_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 8, null);
        return;
        localObject1 = null;
        break;
      }
      label270:
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "do not found local game pkg file");
    }
    if ((getContext() instanceof Activity))
    {
      localObject1 = getContext();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      localObject1 = (Activity)localObject1;
    }
    for (;;)
    {
      RIJAdGameGiftUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Context)localObject1, this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      GameComponentReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, -1, b());
      return;
      localObject1 = this.jdField_a_of_type_JavaLangRefSoftReference;
      if (localObject1 != null) {
        localObject1 = (Activity)((SoftReference)localObject1).get();
      } else {
        localObject1 = null;
      }
    }
  }
  
  private final void i()
  {
    Context localContext = null;
    Object localObject2 = RIJAdDownloadUtil.a;
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject1 != null) {
      localObject1 = ((ADVideoAppDownloadData)localObject1).d;
    }
    int i;
    for (;;)
    {
      if (((RIJAdDownloadUtil)localObject2).a((String)localObject1)) {
        if ((getContext() instanceof Activity))
        {
          localObject1 = getContext();
          if (localObject1 == null)
          {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            localObject1 = null;
            continue;
          }
          localObject1 = (Activity)localObject1;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
          if (localObject2 == null) {
            break label176;
          }
          i = ((AdvertisementInfo)localObject2).clickPos;
          label88:
          if (!RIJAdDownloadUtil.a.a((Activity)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break label182;
          }
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
          if (localObject1 != null) {
            ((AdvertisementInfo)localObject1).clickPos = i;
          }
          localObject1 = RIJAdDownloadReport.a;
          localContext = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
          ((RIJAdDownloadReport)localObject1).a(localContext, DownloadClickState.OPEN_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
        }
      }
    }
    for (;;)
    {
      return;
      localObject1 = this.jdField_a_of_type_JavaLangRefSoftReference;
      if (localObject1 != null)
      {
        localObject1 = (Activity)((SoftReference)localObject1).get();
        break;
      }
      localObject1 = null;
      break;
      label176:
      i = 8;
      break label88;
      label182:
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      localObject1 = localContext;
      if (localObject2 != null) {
        localObject1 = RIJAdDownloadExKt.a((ADVideoAppDownloadData)localObject2);
      }
      if ((localObject1 != null) && (((IDownloadEngine)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData) == true) && (((IDownloadEngine)localObject1).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData)))
      {
        localObject1 = RIJAdDownloadReport.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        ((RIJAdDownloadReport)localObject1).a(localContext, DownloadClickState.INSTALL_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
        return;
      }
      boolean bool;
      if (RIJAdDownloadExKt.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        bool = RIJAdDownloadUtil.a.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      }
      while (bool)
      {
        localObject1 = RIJAdDownloadReport.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        ((RIJAdDownloadReport)localObject1).a(localContext, DownloadClickState.START_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
        return;
        if (RIJAdDownloadExKt.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          bool = RIJAdDownloadUtil.a.b(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
        } else {
          bool = RIJAdDownloadUtil.a.c(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
        }
      }
    }
  }
  
  private final void j()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(0);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    localObject1 = localObject2;
    if (!(localObject2 instanceof RoundProgressStyle)) {
      localObject1 = null;
    }
    localObject1 = (RoundProgressStyle)localObject1;
    if (localObject1 != null) {}
    for (float f = ((RoundProgressStyle)localObject1).getRoundSize();; f = 28.0F)
    {
      int i = (int)(AIOUtils.a(f, getResources()) * 0.5F);
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null)
      {
        localObject2 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setAlpha(0.5F);
      }
      return;
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
  public final IProgressView a()
  {
    IDownloadStyle localIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    if ((localIDownloadStyle != null) && (localIDownloadStyle.getStyleType() == 2)) {
      return (IProgressView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
    }
    return (IProgressView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
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
    return ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public final void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onResume : packageName = ");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject != null) {}
    for (localObject = ((ADVideoAppDownloadData)localObject).d;; localObject = null)
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", (String)localObject + " view = " + hashCode());
      a(this, false, 1, null);
      return;
    }
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
  
  public final void a(boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) || (paramBoolean))
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localADVideoAppDownloadData != null) {
        RIJAdDownloadExKt.a(localADVideoAppDownloadData).a(this, localADVideoAppDownloadData);
      }
    }
  }
  
  public final void a(boolean paramBoolean, @Nullable AdvertisementInfo paramAdvertisementInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pkgName");
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty((CharSequence)paramString)) && (Intrinsics.areEqual(paramString, a()))) {}
    try
    {
      paramAdvertisementInfo = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "BaseApplicationImpl.getContext()");
      paramAdvertisementInfo = paramAdvertisementInfo.getResources().getString(2131718254);
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
    StringBuilder localStringBuilder = new StringBuilder().append("onPause : packageName = ");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localObject != null) {}
    for (localObject = ((ADVideoAppDownloadData)localObject).d;; localObject = null)
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", (String)localObject + " view = " + hashCode());
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
      if (localObject != null) {
        ((GiftPackageDialog)localObject).dismiss();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    if ((localObject != null) && (((IDownloadStyle)localObject).getStyleType() == 2))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
      if (localObject != null) {
        ((RIJRoundProgressBar)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
      if (localObject != null) {
        ((RIJHorizontalProgress)localObject).setVisibility(8);
      }
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle instanceof RoundProgressStyle)) && (paramBoolean))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        }
        if (((RoundProgressStyle)localObject).getBtnResource() != -1) {
          j();
        }
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      } while (localObject == null);
      ((ImageView)localObject).setVisibility(8);
      return;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
      if (localObject != null) {
        ((RIJHorizontalProgress)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
      if (localObject != null) {
        ((RIJRoundProgressBar)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    } while (localObject == null);
    ((ImageView)localObject).setVisibility(8);
  }
  
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
        float f = ((HorizontalProgressStyle)localObject3).getBtnDrawableActiveRadius();
        localObject3 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
        ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.a(f, ((Context)localObject3).getResources()));
        ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      }
    }
  }
  
  public final boolean c()
  {
    boolean bool = false;
    IDownloadStyle localIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    if (localIDownloadStyle != null) {}
    for (int i = localIDownloadStyle.getBtnTextLength();; i = 0)
    {
      if (i < 4) {
        bool = true;
      }
      return bool;
    }
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
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
    localObject1 = localObject2;
    if (!(localObject2 instanceof RoundProgressStyle)) {
      localObject1 = null;
    }
    localObject1 = (RoundProgressStyle)localObject1;
    int i;
    if (localObject1 != null)
    {
      f = ((RoundProgressStyle)localObject1).getImageIconWidth();
      i = AIOUtils.a(f, getResources());
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
      localObject1 = localObject2;
      if (!(localObject2 instanceof RoundProgressStyle)) {
        localObject1 = null;
      }
      localObject1 = (RoundProgressStyle)localObject1;
      if (localObject1 == null) {
        break label231;
      }
    }
    label231:
    for (float f = ((RoundProgressStyle)localObject1).getImageIconHeight();; f = 16.0F)
    {
      int j = AIOUtils.a(f, getResources());
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
      return;
      f = 14.0F;
      break;
    }
  }
  
  public final boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle instanceof RoundProgressStyle))
    {
      IDownloadStyle localIDownloadStyle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadStyleIDownloadStyle;
      if (localIDownloadStyle == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      }
      if (((RoundProgressStyle)localIDownloadStyle).getBtnResource() != -1) {
        return true;
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
    boolean bool2 = false;
    ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
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
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AdDownloadLifeEvent.OnAttachedToWindow.onEvent(this);
    a(this, false, 1, null);
    GiftPackageDialog localGiftPackageDialog = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
    if (localGiftPackageDialog != null) {
      localGiftPackageDialog.dismiss();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AdDownloadLifeEvent.OnDetachedFromWindow.onEvent(this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public void onDownloadCancel(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    Object localObject3 = RIJAdDownloadUtil.a;
    if (paramDownloadInfo != null) {}
    for (Object localObject1 = paramDownloadInfo.e; ((RIJAdDownloadUtil)localObject3).a((String)localObject1); localObject1 = null) {
      return;
    }
    localObject3 = AdDownloadStateHandler.OnCancelDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    localObject1 = localObject2;
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
    if (paramDownloadInfo != null)
    {
      str = paramDownloadInfo.e;
      localAdDownloadInfo.a(str);
      localAdDownloadInfo.c(localAdDownloadInfo.c());
      if (paramDownloadInfo == null) {
        break label85;
      }
    }
    label85:
    for (paramInt2 = paramDownloadInfo.f;; paramInt2 = 0)
    {
      localAdDownloadInfo.b(paramInt2);
      localAdDownloadInfo.c(paramInt1);
      localAdDownloadInfo.b(paramString);
      localAdDownloadStateHandler.doCallBack(this, localAdDownloadInfo);
      return;
      str = null;
      break;
    }
  }
  
  public void onDownloadFinish(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    Object localObject3 = AdDownloadStateHandler.OnSuccessDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    if (paramDownloadInfo != null) {}
    for (Object localObject1 = paramDownloadInfo.e;; localObject1 = null)
    {
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
      return;
    }
  }
  
  public void onDownloadPause(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    AdDownloadStateHandler localAdDownloadStateHandler = AdDownloadStateHandler.OnPauseDownload;
    AdDownloadInfo localAdDownloadInfo = new AdDownloadInfo();
    StringBuilder localStringBuilder;
    if (paramDownloadInfo != null)
    {
      localObject1 = paramDownloadInfo.e;
      localAdDownloadInfo.a((String)localObject1);
      localAdDownloadInfo.c(localAdDownloadInfo.c());
      localStringBuilder = new StringBuilder().append("urlStr = ");
      if (paramDownloadInfo == null) {
        break label135;
      }
    }
    label135:
    for (Object localObject1 = paramDownloadInfo.d;; localObject1 = null)
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", (String)localObject1);
      localStringBuilder = new StringBuilder().append("urlPath = ");
      localObject1 = localObject2;
      if (paramDownloadInfo != null) {
        localObject1 = paramDownloadInfo.i;
      }
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", (String)localObject1);
      localAdDownloadStateHandler.doCallBack(this, localAdDownloadInfo);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public void onDownloadUpdate(@Nullable List<DownloadInfo> paramList)
  {
    Object localObject2;
    Object localObject1;
    if (paramList != null)
    {
      localObject2 = ((Iterable)paramList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label141;
      }
      localObject1 = ((Iterator)localObject2).next();
      String str = ((DownloadInfo)localObject1).d;
      paramList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (paramList == null) {
        break label136;
      }
      paramList = paramList.c;
      label53:
      if (!Intrinsics.areEqual(str, paramList)) {
        break label139;
      }
    }
    label136:
    label139:
    label141:
    for (paramList = (List<DownloadInfo>)localObject1;; paramList = null)
    {
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
      return;
      paramList = null;
      break label53;
      break;
    }
  }
  
  public void onDownloadWait(@Nullable DownloadInfo paramDownloadInfo) {}
  
  public void onQueryCallback(@Nullable ArrayList<WadlResult> paramArrayList)
  {
    AdDownloadStateHandler localAdDownloadStateHandler = null;
    AdDownloadInfo localAdDownloadInfo = null;
    Object localObject3;
    Object localObject2;
    if (paramArrayList != null)
    {
      localObject3 = ((Iterable)paramArrayList).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        paramArrayList = ((WadlResult)localObject2).a;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.e;
          label58:
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
          if (localObject1 == null) {
            break label209;
          }
          localObject1 = ((ADVideoAppDownloadData)localObject1).c;
          label76:
          if (!Intrinsics.areEqual(paramArrayList, localObject1)) {
            break label213;
          }
          paramArrayList = (ArrayList<WadlResult>)localObject2;
        }
      }
    }
    label88:
    for (paramArrayList = (WadlResult)paramArrayList;; paramArrayList = null)
    {
      if (paramArrayList == null) {
        break label225;
      }
      localObject1 = paramArrayList.a.f;
      int i = RIJAdDownloadStateUtil.a.a(paramArrayList);
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
      RIJAdDownloadExKt.a((AdDownloadInfo)localObject2);
      localAdDownloadStateHandler.doCallBack(this, (AdDownloadInfo)localObject2);
      return;
      paramArrayList = null;
      break label58;
      localObject1 = null;
      break label76;
      break;
      paramArrayList = null;
      break label88;
    }
    label209:
    label213:
    label225:
    Object localObject1 = AdDownloadStateHandler.OnQueryResult;
    localAdDownloadInfo = new AdDownloadInfo();
    paramArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.d;
      localAdDownloadInfo.a(paramArrayList);
      paramArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (paramArrayList == null) {
        break label331;
      }
    }
    label331:
    for (paramArrayList = paramArrayList.jdField_a_of_type_JavaLangString;; paramArrayList = null)
    {
      localAdDownloadInfo.c(paramArrayList);
      localAdDownloadInfo.a(0);
      localAdDownloadInfo.b(0);
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      paramArrayList = localAdDownloadStateHandler;
      if (localObject2 != null) {
        paramArrayList = ((ADVideoAppDownloadData)localObject2).i;
      }
      localAdDownloadInfo.d(paramArrayList);
      ((AdDownloadStateHandler)localObject1).doCallBack(this, localAdDownloadInfo);
      return;
      paramArrayList = null;
      break;
    }
  }
  
  public void onQueryCallbackVia(@Nullable ArrayList<WadlResult> paramArrayList) {}
  
  public void onWadlTaskStatusChanged(@Nullable WadlResult paramWadlResult)
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
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
          if (localObject2 == null) {
            break label76;
          }
          localObject2 = ((ADVideoAppDownloadData)localObject2).d;
          label60:
          if (!(Intrinsics.areEqual(localObject1, localObject2) ^ true)) {
            break label81;
          }
        }
      }
    }
    label76:
    label81:
    label93:
    label97:
    label101:
    label105:
    label113:
    do
    {
      return;
      break label113;
      localObject1 = null;
      break;
      localObject2 = null;
      break label60;
      if (paramWadlResult != null)
      {
        localObject2 = Integer.valueOf(paramWadlResult.jdField_b_of_type_Int);
        if (localObject2 != null) {
          break label193;
        }
        if (localObject2 != null) {
          break label275;
        }
        if (localObject2 != null) {
          break label354;
        }
        if (localObject2 != null) {
          break label412;
        }
      }
      for (;;)
      {
        if (localObject2 == null)
        {
          if ((localObject2 == null) || (((Integer)localObject2).intValue() != 7)) {
            break;
          }
          localObject2 = AdDownloadStateHandler.OnErrorDownload;
          localObject3 = new AdDownloadInfo();
          ((AdDownloadInfo)localObject3).a((String)localObject1);
          localWadlParams = paramWadlResult.a;
          localObject1 = localAdDownloadInfo;
          if (localWadlParams != null) {
            localObject1 = localWadlParams.jdField_a_of_type_JavaLangString;
          }
          ((AdDownloadInfo)localObject3).c((String)localObject1);
          ((AdDownloadInfo)localObject3).c(paramWadlResult.c);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, (AdDownloadInfo)localObject3);
          return;
          localObject2 = null;
          break label93;
          if (((Integer)localObject2).intValue() != 4) {
            break label97;
          }
          localObject2 = AdDownloadStateHandler.OnProgressUpdate;
          localAdDownloadInfo = new AdDownloadInfo();
          localAdDownloadInfo.a((String)localObject1);
          localWadlParams = paramWadlResult.a;
          localObject1 = localObject3;
          if (localWadlParams != null) {
            localObject1 = localWadlParams.jdField_a_of_type_JavaLangString;
          }
          localAdDownloadInfo.c((String)localObject1);
          localAdDownloadInfo.a(RIJAdDownloadStateUtil.a.a(paramWadlResult));
          localAdDownloadInfo.b(paramWadlResult.d);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
          return;
          if (((Integer)localObject2).intValue() != 6) {
            break label101;
          }
          localObject2 = AdDownloadStateHandler.OnSuccessDownload;
          localAdDownloadInfo = new AdDownloadInfo();
          localAdDownloadInfo.a((String)localObject1);
          localObject3 = paramWadlResult.a;
          localObject1 = localWadlParams;
          if (localObject3 != null) {
            localObject1 = ((WadlParams)localObject3).jdField_a_of_type_JavaLangString;
          }
          localAdDownloadInfo.c((String)localObject1);
          ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
          if (localObject1 == null) {
            break;
          }
          ((ADVideoAppDownloadData)localObject1).i = paramWadlResult.jdField_b_of_type_JavaLangString;
          return;
          if (((Integer)localObject2).intValue() != 5) {
            break label105;
          }
          localObject2 = AdDownloadStateHandler.OnPauseDownload;
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
          if (((Integer)localObject2).intValue() == 9)
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
        }
      }
    } while (((Integer)localObject2).intValue() != 10);
    label193:
    label354:
    Object localObject2 = AdDownloadStateHandler.OnInstallSucceed;
    label275:
    label412:
    localAdDownloadInfo = new AdDownloadInfo();
    localAdDownloadInfo.a((String)localObject1);
    Object localObject1 = paramWadlResult.a;
    paramWadlResult = localObject6;
    if (localObject1 != null) {
      paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
    }
    localAdDownloadInfo.c(paramWadlResult);
    ((AdDownloadStateHandler)localObject2).doCallBack(this, localAdDownloadInfo);
  }
  
  public void packageReplaced(@Nullable String paramString1, @Nullable String paramString2) {}
  
  public final void setActivity(@Nullable SoftReference<Activity> paramSoftReference)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = paramSoftReference;
  }
  
  public final void setAdvertisementInfo(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    g();
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
    if ((paramAdvertisementInfo != null) && (RIJAdDownloadExKt.d(paramAdvertisementInfo) == true))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene == AdDownloadScene.PTSCard) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.SoftButton;
      }
      paramAdvertisementInfo = ADVideoAppDownloadData.a(paramAdvertisementInfo.mAdvertisementSoftInfo, 0);
      if (paramAdvertisementInfo != null) {
        a(paramAdvertisementInfo);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        AdDownloadStateHandler.OnInitDownload.doCallBack(this, new AdDownloadInfo());
      }
      return;
      if (((paramAdvertisementInfo != null) && (RIJAdDownloadExKt.e(paramAdvertisementInfo) == true)) || ((paramAdvertisementInfo != null) && (RIJAdDownloadExKt.g(paramAdvertisementInfo) == true)))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene == AdDownloadScene.PTSCard) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.GameButton;
        }
        paramAdvertisementInfo = ADVideoAppDownloadData.a(paramAdvertisementInfo.gameAdComData);
        if (paramAdvertisementInfo != null) {
          a(paramAdvertisementInfo);
        }
      }
      else if (AdvertisementInfo.isAppAdvertisementInfo((BaseArticleInfo)paramAdvertisementInfo))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView
 * JD-Core Version:    0.7.0.1
 */