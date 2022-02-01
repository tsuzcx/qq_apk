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
import bmqi;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadCallBack;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcooperation.wadl.ipc.WadlResult;>;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.open.downloadnew.DownloadInfo;>;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import oix;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ueb;
import uet;
import uev;
import uex;
import ufa;
import ufc;
import ufd;
import uff;
import ufg;
import ufi;
import ufm;
import ukq;
import uks;
import ule;
import ulx;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/open/downloadnew/DownloadListener;", "Lcooperation/wadl/ipc/WadlProxyServiceCallBackInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/SoftReference;", "setActivity", "(Ljava/lang/ref/SoftReference;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "dialog", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;", "getDialog", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;", "setDialog", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/GiftPackageDialog;)V", "downloadBtn", "Landroid/widget/TextView;", "getDownloadBtn", "()Landroid/widget/TextView;", "setDownloadBtn", "(Landroid/widget/TextView;)V", "downloadContainer", "getDownloadContainer", "()Landroid/widget/FrameLayout;", "setDownloadContainer", "(Landroid/widget/FrameLayout;)V", "downloadScene", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "getDownloadScene", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "setDownloadScene", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;)V", "downloadStyle", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "getDownloadStyle", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setDownloadStyle", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;)V", "hasRefreshBtn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "horizontalProgress", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "getHorizontalProgress", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "setHorizontalProgress", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "setImageIcon", "(Landroid/widget/ImageView;)V", "inFloatingBar", "", "getInFloatingBar", "()Z", "setInFloatingBar", "(Z)V", "inPtsCard", "getInPtsCard", "setInPtsCard", "needCallInit", "roundProgress", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "getRoundProgress", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "setRoundProgress", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;)V", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "setViewRoot", "(Landroid/view/View;)V", "changeToHighLightBtn", "", "clickBtnForDownloadAd", "doNotCallDownloadInit", "getAdInfo", "getDownloadData", "getEx5", "", "getGamePkgName", "getProgressView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "inDownloadingState", "initBtnText", "installSucceed", "appid", "packageName", "onAttachedToWindow", "onBtnCLickEvent", "onDetachedFromWindow", "onDownloadCancel", "info", "Lcom/tencent/open/downloadnew/DownloadInfo;", "onDownloadClickEvent", "adClickPos", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/AdClickPos;", "clickPos", "", "onDownloadError", "errorCode", "errorMsg", "state", "onDownloadFinish", "onDownloadPause", "onDownloadUpdate", "infos", "", "onDownloadWait", "onPause", "onProgressClickEvent", "onQueryCallback", "wadlResults", "Ljava/util/ArrayList;", "Lcooperation/wadl/ipc/WadlResult;", "onQueryCallbackVia", "onReceiveYYBInstall", "url", "sourceId", "onResult", "isSuccess", "advertisementInfo", "pkgName", "onResume", "onWadlTaskStatusChanged", "wadlResult", "packageReplaced", "realSetDownloadData", "downloadData", "refreshBtnText", "force", "setAdvertisementInfo", "setDownloadData", "setHorizontalProgressStyle", "iDownloadStyle", "setProgressStyle", "setRoundProgressStyle", "shouldShowStartImageIcon", "showButton", "showCenterImageIconWhenShowProgress", "showProgress", "showCenterImageIcon", "showStartImageIcon", "showTwoBtnText", "uninstallSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJDownloadView
  extends FrameLayout
  implements bmqi, DownloadListener
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
  private RIJHorizontalProgress jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
  @Nullable
  private RIJRoundProgressBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
  @Nullable
  private SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  @Nullable
  private ufa jdField_a_of_type_Ufa;
  private volatile ule jdField_a_of_type_Ule;
  @Nullable
  private ulx jdField_a_of_type_Ulx;
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
      paramContext = paramAttributeSet.inflate(2131560098, (ViewGroup)this);
    }
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362826));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress = ((RIJHorizontalProgress)paramContext.findViewById(2131368308));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar = ((RIJRoundProgressBar)paramContext.findViewById(2131376985));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext.findViewById(2131370601));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131368580));
    }
  }
  
  private final void a(ufa paramufa)
  {
    if (!(paramufa instanceof HorizontalProgressStyle)) {
      paramufa = null;
    }
    for (;;)
    {
      paramufa = (HorizontalProgressStyle)paramufa;
      if (paramufa != null) {}
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setTextSize(paramufa.getBtnTextSize());
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setTextColor(oix.a(paramufa.getBtnTextColor(), "#FF12B7F5"));
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null)
        {
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(oix.a(paramufa.getBtnDrawableNormalColor(), "#00000000"));
          float f = paramufa.getBtnDrawableNormalRadius();
          Context localContext = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
          localGradientDrawable.setCornerRadius(AIOUtils.dp2px(f, localContext.getResources()));
          ((TextView)localObject).setBackgroundDrawable((Drawable)localGradientDrawable);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
        if (localObject != null) {
          ((RIJHorizontalProgress)localObject).setProgressStyle((ufa)paramufa);
        }
        return;
        paramufa = HorizontalProgressStyle.DefaultHorizontalStyle;
      }
    }
  }
  
  private final void a(ule paramule)
  {
    ule localule = uet.a.a(paramule.d);
    if (localule != null) {
      b(localule);
    }
    for (;;)
    {
      QLog.d("AD_DOWNLOAD_TAG", 1, "setDownloadData: packageName = " + paramule.d + " view = " + hashCode());
      onAttachedToWindow();
      return;
      b(paramule);
      uet.a.a(paramule);
    }
  }
  
  private final String b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return "1";
    }
    return "2";
  }
  
  private final void b(ufa paramufa)
  {
    if (!(paramufa instanceof RoundProgressStyle)) {
      paramufa = null;
    }
    for (;;)
    {
      paramufa = (RoundProgressStyle)paramufa;
      if (paramufa != null) {}
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setTextSize(paramufa.getBtnTextSize());
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setTextColor(oix.a(paramufa.getBtnTextColor(), "#FF12B7F5"));
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null)
        {
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(oix.a(paramufa.getBtnDrawableNormalColor(), "#00000000"));
          float f = paramufa.getBtnDrawableNormalRadius();
          Context localContext = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
          localGradientDrawable.setCornerRadius(AIOUtils.dp2px(f, localContext.getResources()));
          ((TextView)localObject).setBackgroundDrawable((Drawable)localGradientDrawable);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
        if (localObject != null) {
          ((RIJRoundProgressBar)localObject).setProgressStyle((ufa)paramufa);
        }
        i = AIOUtils.dp2px(paramufa.getRoundSize(), getResources());
        paramufa = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
        if (paramufa != null)
        {
          localObject = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          paramufa.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        i = (int)(0.5F * i);
        paramufa = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramufa != null)
        {
          localObject = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          paramufa.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        paramufa = this.jdField_a_of_type_Ufa;
        if (paramufa != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        paramufa = RoundProgressStyle.DefaultRoundStyle;
      }
      int i = ((RoundProgressStyle)paramufa).getBtnResource();
      if (i != -1)
      {
        paramufa = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramufa != null) {
          paramufa.setBackgroundResource(i);
        }
      }
      return;
    }
  }
  
  private final void b(ule paramule)
  {
    String str = null;
    if (this.jdField_a_of_type_Ule == null)
    {
      ukq.a("AD_DOWNLOAD_TAG", "data = null , so setNewDownloadData");
      this.jdField_a_of_type_Ule = paramule;
      return;
    }
    Object localObject = this.jdField_a_of_type_Ule;
    if (localObject != null) {}
    for (localObject = ((ule)localObject).d;; localObject = null)
    {
      if (paramule != null) {
        str = paramule.d;
      }
      if (!(Intrinsics.areEqual(localObject, str) ^ true)) {
        break;
      }
      ukq.a("AD_DOWNLOAD_TAG", "data packageName is not same , so setNewDownloadData");
      this.jdField_a_of_type_Ule = paramule;
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
    Object localObject1 = this.jdField_a_of_type_Ule;
    if (localObject1 != null)
    {
      localObject1 = ((ule)localObject1).d;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" currentState = ");
      localObject1 = this.jdField_a_of_type_Ule;
      if (localObject1 == null) {
        break label95;
      }
      localObject1 = Integer.valueOf(((ule)localObject1).jdField_a_of_type_Int);
      label60:
      ukq.a("AD_DOWNLOAD_TAG", localObject1);
      if (!ufc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        break label100;
      }
      i();
    }
    label95:
    label100:
    while ((ufc.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (!ufc.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label60;
    }
    localObject1 = this.jdField_a_of_type_Ule;
    if ((localObject1 != null) && (((ule)localObject1).jdField_b_of_type_Boolean == true))
    {
      localObject2 = ufg.a;
      localObject1 = this.jdField_a_of_type_Ule;
      boolean bool2;
      if (localObject1 != null)
      {
        localObject1 = ((ule)localObject1).d;
        bool2 = ((ufg)localObject2).a((String)localObject1);
        localObject1 = this.jdField_a_of_type_Ule;
        if (localObject1 == null) {
          break label265;
        }
        localObject1 = ufc.a((ule)localObject1);
        if (localObject1 == null) {
          break label265;
        }
      }
      label265:
      for (boolean bool1 = ((uex)localObject1).a(this.jdField_a_of_type_Ule);; bool1 = false)
      {
        if ((bool2) || (!bool1)) {
          break label270;
        }
        localObject1 = this.jdField_a_of_type_Ule;
        if (localObject1 != null)
        {
          localObject1 = ufc.a((ule)localObject1);
          if (localObject1 != null) {
            ((uex)localObject1).b(this.jdField_a_of_type_Ule);
          }
        }
        localObject1 = ufd.a;
        localObject2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
        ufd.a((ufd)localObject1, (Context)localObject2, DownloadClickState.INSTALL_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 8, null);
        return;
        localObject1 = null;
        break;
      }
      label270:
      ukq.a("AD_DOWNLOAD_TAG", "do not found local game pkg file");
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
      ufi.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Context)localObject1, this, this.jdField_a_of_type_Ule);
      ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, -1, b());
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
    Object localObject2 = ufg.a;
    Object localObject1 = this.jdField_a_of_type_Ule;
    if (localObject1 != null) {
      localObject1 = ((ule)localObject1).d;
    }
    int i;
    for (;;)
    {
      if (((ufg)localObject2).a((String)localObject1)) {
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
          if (!ufg.a.a((Activity)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break label182;
          }
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
          if (localObject1 != null) {
            ((AdvertisementInfo)localObject1).clickPos = i;
          }
          localObject1 = ufd.a;
          localContext = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
          ((ufd)localObject1).a(localContext, DownloadClickState.OPEN_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
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
      localObject2 = this.jdField_a_of_type_Ule;
      localObject1 = localContext;
      if (localObject2 != null) {
        localObject1 = ufc.a((ule)localObject2);
      }
      if ((localObject1 != null) && (((uex)localObject1).a(this.jdField_a_of_type_Ule) == true) && (((uex)localObject1).b(this.jdField_a_of_type_Ule)))
      {
        localObject1 = ufd.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        ((ufd)localObject1).a(localContext, DownloadClickState.INSTALL_APP, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
        return;
      }
      boolean bool;
      if (ufc.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        bool = ufg.a.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Ule);
      }
      while (bool)
      {
        localObject1 = ufd.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        ((ufd)localObject1).a(localContext, DownloadClickState.START_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
        return;
        if (ufc.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          bool = ufg.a.b(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Ule);
        } else {
          bool = ufg.a.c(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_Ule);
        }
      }
    }
  }
  
  private final void j()
  {
    Context localContext = null;
    StringBuilder localStringBuilder = new StringBuilder().append("clickProgress : packageName = ");
    Object localObject = this.jdField_a_of_type_Ule;
    if (localObject != null) {}
    for (localObject = ((ule)localObject).d;; localObject = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject).append(" currentState = ");
      ule localule = this.jdField_a_of_type_Ule;
      localObject = localContext;
      if (localule != null) {
        localObject = Integer.valueOf(localule.jdField_a_of_type_Int);
      }
      ukq.a("AD_DOWNLOAD_TAG", localObject + "  width = " + getWidth());
      localObject = this.jdField_a_of_type_Ule;
      if ((localObject == null) || (((ule)localObject).jdField_a_of_type_Int != 4)) {
        break;
      }
      localObject = this.jdField_a_of_type_Ule;
      if (localObject != null)
      {
        localObject = ufc.a((ule)localObject);
        if (localObject != null) {
          ((uex)localObject).b(this, this.jdField_a_of_type_Ule);
        }
      }
      localObject = ufd.a;
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      ((ufd)localObject).a(localContext, DownloadClickState.RESUME_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
      return;
    }
    localObject = this.jdField_a_of_type_Ule;
    if (localObject != null)
    {
      localObject = ufc.a((ule)localObject);
      if (localObject != null) {
        ((uex)localObject).c(this, this.jdField_a_of_type_Ule);
      }
    }
    localObject = ufd.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((ufd)localObject).a(localContext, DownloadClickState.PAUSE_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, b());
  }
  
  private final void k()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(0);
    }
    Object localObject2 = this.jdField_a_of_type_Ufa;
    localObject1 = localObject2;
    if (!(localObject2 instanceof RoundProgressStyle)) {
      localObject1 = null;
    }
    localObject1 = (RoundProgressStyle)localObject1;
    if (localObject1 != null) {}
    for (float f = ((RoundProgressStyle)localObject1).getRoundSize();; f = 28.0F)
    {
      int i = (int)(AIOUtils.dp2px(f, getResources()) * 0.5F);
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
  protected final String a()
  {
    return uks.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  @Nullable
  public final ufm a()
  {
    ufa localufa = this.jdField_a_of_type_Ufa;
    if ((localufa != null) && (localufa.getStyleType() == 2)) {
      return (ufm)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
    }
    return (ufm)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
  }
  
  @Nullable
  public final ule a()
  {
    return this.jdField_a_of_type_Ule;
  }
  
  @Nullable
  public final ulx a()
  {
    return this.jdField_a_of_type_Ulx;
  }
  
  public final void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onResume : packageName = ");
    Object localObject = this.jdField_a_of_type_Ule;
    if (localObject != null) {}
    for (localObject = ((ule)localObject).d;; localObject = null)
    {
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject + " view = " + hashCode());
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
    paramAdClickPos = this.jdField_a_of_type_Ule;
    if (paramAdClickPos != null)
    {
      paramAdClickPos = Integer.valueOf(paramAdClickPos.jdField_a_of_type_Int);
      if (paramAdClickPos != null) {
        break label63;
      }
      label49:
      if (paramAdClickPos != null) {
        break label76;
      }
    }
    label63:
    label76:
    while (paramAdClickPos.intValue() != 4)
    {
      h();
      return;
      paramAdClickPos = null;
      break;
      if (paramAdClickPos.intValue() != 3) {
        break label49;
      }
      j();
      return;
    }
    j();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_Ule != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))) || (paramBoolean))
    {
      ule localule = this.jdField_a_of_type_Ule;
      if (localule != null) {
        ufc.a(localule).a(this, localule);
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
      paramAdvertisementInfo = paramAdvertisementInfo.getResources().getString(2131717752);
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
    Object localObject = this.jdField_a_of_type_Ule;
    if (localObject != null) {}
    for (localObject = ((ule)localObject).d;; localObject = null)
    {
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject + " view = " + hashCode());
      localObject = this.jdField_a_of_type_Ulx;
      if (localObject != null) {
        ((ulx)localObject).dismiss();
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
    localObject = this.jdField_a_of_type_Ufa;
    if ((localObject != null) && (((ufa)localObject).getStyleType() == 2))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJRoundProgressBar;
      if (localObject != null) {
        ((RIJRoundProgressBar)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJHorizontalProgress;
      if (localObject != null) {
        ((RIJHorizontalProgress)localObject).setVisibility(8);
      }
      if (((this.jdField_a_of_type_Ufa instanceof RoundProgressStyle)) && (paramBoolean))
      {
        localObject = this.jdField_a_of_type_Ufa;
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        }
        if (((RoundProgressStyle)localObject).getBtnResource() != -1) {
          k();
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
    Object localObject2 = this.jdField_a_of_type_Ufa;
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
        ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(f, ((Context)localObject3).getResources()));
        ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      }
    }
  }
  
  public final boolean c()
  {
    boolean bool = false;
    ufa localufa = this.jdField_a_of_type_Ufa;
    if (localufa != null) {}
    for (int i = localufa.getBtnTextLength();; i = 0)
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
    Object localObject2 = this.jdField_a_of_type_Ufa;
    localObject1 = localObject2;
    if (!(localObject2 instanceof RoundProgressStyle)) {
      localObject1 = null;
    }
    localObject1 = (RoundProgressStyle)localObject1;
    int i;
    if (localObject1 != null)
    {
      f = ((RoundProgressStyle)localObject1).getImageIconWidth();
      i = AIOUtils.dp2px(f, getResources());
      localObject2 = this.jdField_a_of_type_Ufa;
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
      int j = AIOUtils.dp2px(f, getResources());
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
    if ((this.jdField_a_of_type_Ufa instanceof RoundProgressStyle))
    {
      ufa localufa = this.jdField_a_of_type_Ufa;
      if (localufa == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      }
      if (((RoundProgressStyle)localufa).getBtnResource() != -1) {
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
    ule localule = this.jdField_a_of_type_Ule;
    boolean bool1 = bool2;
    if (localule != null)
    {
      int i = localule.jdField_a_of_type_Int;
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
    AdDownloadCallBack localAdDownloadCallBack = AdDownloadCallBack.OnInstallSucceed;
    uev localuev = new uev();
    localuev.a(paramString2);
    localuev.c(paramString1);
    localAdDownloadCallBack.doCallBack(this, localuev);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AdDownloadLifeEvent.OnAttachedToWindow.onEvent(this);
    a(this, false, 1, null);
    ulx localulx = this.jdField_a_of_type_Ulx;
    if (localulx != null) {
      localulx.dismiss();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AdDownloadLifeEvent.OnDetachedFromWindow.onEvent(this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
  }
  
  public void onDownloadCancel(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    Object localObject3 = ufg.a;
    if (paramDownloadInfo != null) {}
    for (Object localObject1 = paramDownloadInfo.e; ((ufg)localObject3).a((String)localObject1); localObject1 = null) {
      return;
    }
    localObject3 = AdDownloadCallBack.OnCancelDownload;
    uev localuev = new uev();
    localObject1 = localObject2;
    if (paramDownloadInfo != null) {
      localObject1 = paramDownloadInfo.e;
    }
    localuev.a((String)localObject1);
    localuev.c(localuev.c());
    ((AdDownloadCallBack)localObject3).doCallBack(this, localuev);
  }
  
  public void onDownloadError(@Nullable DownloadInfo paramDownloadInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    AdDownloadCallBack localAdDownloadCallBack = AdDownloadCallBack.OnErrorDownload;
    uev localuev = new uev();
    String str;
    if (paramDownloadInfo != null)
    {
      str = paramDownloadInfo.e;
      localuev.a(str);
      localuev.c(localuev.c());
      if (paramDownloadInfo == null) {
        break label85;
      }
    }
    label85:
    for (paramInt2 = paramDownloadInfo.f;; paramInt2 = 0)
    {
      localuev.b(paramInt2);
      localuev.c(paramInt1);
      localuev.b(paramString);
      localAdDownloadCallBack.doCallBack(this, localuev);
      return;
      str = null;
      break;
    }
  }
  
  public void onDownloadFinish(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    Object localObject3 = AdDownloadCallBack.OnSuccessDownload;
    uev localuev = new uev();
    if (paramDownloadInfo != null) {}
    for (Object localObject1 = paramDownloadInfo.e;; localObject1 = null)
    {
      localuev.a((String)localObject1);
      localuev.c(localuev.c());
      ((AdDownloadCallBack)localObject3).doCallBack(this, localuev);
      localObject3 = this.jdField_a_of_type_Ule;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (paramDownloadInfo != null) {
          localObject1 = paramDownloadInfo.l;
        }
        ((ule)localObject3).i = ((String)localObject1);
      }
      return;
    }
  }
  
  public void onDownloadPause(@Nullable DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    AdDownloadCallBack localAdDownloadCallBack = AdDownloadCallBack.OnPauseDownload;
    uev localuev = new uev();
    StringBuilder localStringBuilder;
    if (paramDownloadInfo != null)
    {
      localObject1 = paramDownloadInfo.e;
      localuev.a((String)localObject1);
      localuev.c(localuev.c());
      localStringBuilder = new StringBuilder().append("urlStr = ");
      if (paramDownloadInfo == null) {
        break label135;
      }
    }
    label135:
    for (Object localObject1 = paramDownloadInfo.d;; localObject1 = null)
    {
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject1);
      localStringBuilder = new StringBuilder().append("urlPath = ");
      localObject1 = localObject2;
      if (paramDownloadInfo != null) {
        localObject1 = paramDownloadInfo.i;
      }
      ukq.a("AD_DOWNLOAD_TAG", (String)localObject1);
      localAdDownloadCallBack.doCallBack(this, localuev);
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
      paramList = this.jdField_a_of_type_Ule;
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
        localObject1 = AdDownloadCallBack.OnProgressUpdate;
        localObject2 = new uev();
        ((uev)localObject2).a(paramList.e);
        ((uev)localObject2).c(((uev)localObject2).c());
        ((uev)localObject2).a(3);
        ((uev)localObject2).b(paramList.f);
        if (((uev)localObject2).b() > 100) {
          ((uev)localObject2).b(100);
        }
        ((AdDownloadCallBack)localObject1).doCallBack(this, (uev)localObject2);
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
    AdDownloadCallBack localAdDownloadCallBack = null;
    uev localuev = null;
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
          localObject1 = this.jdField_a_of_type_Ule;
          if (localObject1 == null) {
            break label209;
          }
          localObject1 = ((ule)localObject1).c;
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
      int i = uff.a.a(paramArrayList);
      int j = paramArrayList.d;
      localAdDownloadCallBack = AdDownloadCallBack.OnQueryResult;
      localObject2 = new uev();
      ((uev)localObject2).a((String)localObject1);
      localObject3 = paramArrayList.a;
      localObject1 = localuev;
      if (localObject3 != null) {
        localObject1 = ((WadlParams)localObject3).jdField_a_of_type_JavaLangString;
      }
      ((uev)localObject2).c((String)localObject1);
      ((uev)localObject2).a(i);
      ((uev)localObject2).b(j);
      ((uev)localObject2).d(paramArrayList.jdField_b_of_type_JavaLangString);
      ufc.a((uev)localObject2);
      localAdDownloadCallBack.doCallBack(this, (uev)localObject2);
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
    Object localObject1 = AdDownloadCallBack.OnQueryResult;
    localuev = new uev();
    paramArrayList = this.jdField_a_of_type_Ule;
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.d;
      localuev.a(paramArrayList);
      paramArrayList = this.jdField_a_of_type_Ule;
      if (paramArrayList == null) {
        break label331;
      }
    }
    label331:
    for (paramArrayList = paramArrayList.jdField_a_of_type_JavaLangString;; paramArrayList = null)
    {
      localuev.c(paramArrayList);
      localuev.a(0);
      localuev.b(0);
      localObject2 = this.jdField_a_of_type_Ule;
      paramArrayList = localAdDownloadCallBack;
      if (localObject2 != null) {
        paramArrayList = ((ule)localObject2).i;
      }
      localuev.d(paramArrayList);
      ((AdDownloadCallBack)localObject1).doCallBack(this, localuev);
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
    uev localuev = null;
    if (paramWadlResult != null)
    {
      localObject1 = paramWadlResult.a;
      if (localObject1 != null)
      {
        localObject1 = ((WadlParams)localObject1).f;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = this.jdField_a_of_type_Ule;
          if (localObject2 == null) {
            break label76;
          }
          localObject2 = ((ule)localObject2).d;
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
          localObject2 = AdDownloadCallBack.OnErrorDownload;
          localObject3 = new uev();
          ((uev)localObject3).a((String)localObject1);
          localWadlParams = paramWadlResult.a;
          localObject1 = localuev;
          if (localWadlParams != null) {
            localObject1 = localWadlParams.jdField_a_of_type_JavaLangString;
          }
          ((uev)localObject3).c((String)localObject1);
          ((uev)localObject3).c(paramWadlResult.c);
          ((AdDownloadCallBack)localObject2).doCallBack(this, (uev)localObject3);
          return;
          localObject2 = null;
          break label93;
          if (((Integer)localObject2).intValue() != 4) {
            break label97;
          }
          localObject2 = AdDownloadCallBack.OnProgressUpdate;
          localuev = new uev();
          localuev.a((String)localObject1);
          localWadlParams = paramWadlResult.a;
          localObject1 = localObject3;
          if (localWadlParams != null) {
            localObject1 = localWadlParams.jdField_a_of_type_JavaLangString;
          }
          localuev.c((String)localObject1);
          localuev.a(uff.a.a(paramWadlResult));
          localuev.b(paramWadlResult.d);
          ((AdDownloadCallBack)localObject2).doCallBack(this, localuev);
          return;
          if (((Integer)localObject2).intValue() != 6) {
            break label101;
          }
          localObject2 = AdDownloadCallBack.OnSuccessDownload;
          localuev = new uev();
          localuev.a((String)localObject1);
          localObject3 = paramWadlResult.a;
          localObject1 = localWadlParams;
          if (localObject3 != null) {
            localObject1 = ((WadlParams)localObject3).jdField_a_of_type_JavaLangString;
          }
          localuev.c((String)localObject1);
          ((AdDownloadCallBack)localObject2).doCallBack(this, localuev);
          localObject1 = this.jdField_a_of_type_Ule;
          if (localObject1 == null) {
            break;
          }
          ((ule)localObject1).i = paramWadlResult.jdField_b_of_type_JavaLangString;
          return;
          if (((Integer)localObject2).intValue() != 5) {
            break label105;
          }
          localObject2 = AdDownloadCallBack.OnPauseDownload;
          localuev = new uev();
          localuev.a((String)localObject1);
          localObject1 = paramWadlResult.a;
          paramWadlResult = localObject4;
          if (localObject1 != null) {
            paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
          }
          localuev.c(paramWadlResult);
          ((AdDownloadCallBack)localObject2).doCallBack(this, localuev);
          return;
          if (((Integer)localObject2).intValue() == 9)
          {
            localObject2 = AdDownloadCallBack.OnInstallSucceed;
            localuev = new uev();
            localuev.a((String)localObject1);
            localObject1 = paramWadlResult.a;
            paramWadlResult = localObject5;
            if (localObject1 != null) {
              paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
            }
            localuev.c(paramWadlResult);
            ((AdDownloadCallBack)localObject2).doCallBack(this, localuev);
            return;
          }
        }
      }
    } while (((Integer)localObject2).intValue() != 10);
    label193:
    label354:
    Object localObject2 = AdDownloadCallBack.OnInstallSucceed;
    label275:
    label412:
    localuev = new uev();
    localuev.a((String)localObject1);
    Object localObject1 = paramWadlResult.a;
    paramWadlResult = localObject6;
    if (localObject1 != null) {
      paramWadlResult = ((WadlParams)localObject1).jdField_a_of_type_JavaLangString;
    }
    localuev.c(paramWadlResult);
    ((AdDownloadCallBack)localObject2).doCallBack(this, localuev);
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
    if ((paramAdvertisementInfo != null) && (ufc.d(paramAdvertisementInfo) == true))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene == AdDownloadScene.PTSCard) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.SoftButton;
      }
      paramAdvertisementInfo = ule.a(paramAdvertisementInfo.mAdvertisementSoftInfo, 0);
      Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "downloadData");
      a(paramAdvertisementInfo);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        AdDownloadCallBack.OnInitDownload.doCallBack(this, new uev());
      }
      return;
      if (((paramAdvertisementInfo != null) && (ufc.e(paramAdvertisementInfo) == true)) || ((paramAdvertisementInfo != null) && (ufc.g(paramAdvertisementInfo) == true)))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene == AdDownloadScene.PTSCard) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadAdDownloadScene = AdDownloadScene.GameButton;
        }
        paramAdvertisementInfo = ule.a(paramAdvertisementInfo.gameAdComData);
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "downloadData");
        a(paramAdvertisementInfo);
      }
      else if (AdvertisementInfo.isAppAdvertisementInfo((BaseArticleInfo)paramAdvertisementInfo))
      {
        paramAdvertisementInfo = ule.a(paramAdvertisementInfo, true);
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "downloadData");
        a(paramAdvertisementInfo);
      }
      else
      {
        this.jdField_a_of_type_Ule = ((ule)null);
      }
    }
  }
  
  public final void setDialog(@Nullable ulx paramulx)
  {
    this.jdField_a_of_type_Ulx = paramulx;
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
  
  public final void setDownloadStyle(@Nullable ufa paramufa)
  {
    this.jdField_a_of_type_Ufa = paramufa;
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
  
  public final void setProgressStyle(@Nullable ufa paramufa)
  {
    if (paramufa == null) {
      return;
    }
    this.jdField_a_of_type_Ufa = paramufa;
    if (paramufa.getStyleType() == 2)
    {
      b(paramufa);
      return;
    }
    a(paramufa);
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
    AdDownloadCallBack localAdDownloadCallBack = AdDownloadCallBack.OnUninstallSucceed;
    uev localuev = new uev();
    localuev.a(paramString2);
    localuev.c(paramString1);
    localAdDownloadCallBack.doCallBack(this, localuev);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView
 * JD-Core Version:    0.7.0.1
 */