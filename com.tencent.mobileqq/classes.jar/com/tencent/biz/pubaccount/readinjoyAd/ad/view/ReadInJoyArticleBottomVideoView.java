package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.VideoStateCallback;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;

public class ReadInJoyArticleBottomVideoView
  extends ViewBase
  implements View.OnClickListener
{
  public static String a;
  public static boolean a = false;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdModuleVideo jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ProteusBannerVideoItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
  private VideoStateCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoStateCallback = new ReadInJoyArticleBottomVideoView.1(this);
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = true;
  private boolean e = false;
  
  public ReadInJoyArticleBottomVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    a(paramVafContext.getContext());
  }
  
  private int a()
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.isCommentAd())) {
      return 38;
    }
    return 1;
  }
  
  private Context a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  private void a(Context paramContext)
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bottomView create:");
    localStringBuilder.append(hashCode());
    localIRIJAdLogService.d("VideoPlayerWrapper_AD", localStringBuilder.toString());
    if (paramContext == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560081, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext.getApplicationContext());
    d();
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)
    {
      Object localObject2 = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_b_of_type_Boolean)
      {
        AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        localObject1 = localObject2;
        if (localAdvertisementInfo != null) {
          localObject1 = localAdvertisementInfo;
        }
      }
      if (localObject1 != null) {
        localObject1.clickPos = paramInt;
      }
      localObject2 = ReadinJoyActionUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData, localObject1);
      if (((Integer)localObject2).intValue() != -1) {
        return;
      }
      if (LiujinAdJump.isFromLiuJin(localObject1)) {
        localObject2 = LiujinAdJump.doJumpAction(localObject1, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramBoolean);
      }
      if (((Integer)localObject2).intValue() != -1)
      {
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, (Integer)localObject2, localObject1, 1, 1, 3);
        return;
      }
      boolean bool = a();
      localObject2 = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramView.getContext(), localObject1, null, 2, paramBoolean, new AdJumpParams(bool));
      if (localObject2 == null) {
        return;
      }
      ((GdtHandler.Params)localObject2).f = ReadInJoyAdSwitchUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
      ((GdtHandler.Params)localObject2).jdField_a_of_type_Long = FastWebVideoPlayManager.a.a();
      if (localObject1 != null) {
        localObject1.setClickPos(paramInt);
      }
      paramView = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localObject2, paramView.getContext(), localObject1);
      if (localObject1 != null) {
        localObject1.setClickPos(paramInt);
      }
      WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject2;
      long l;
      if (WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {
        l = SystemClock.elapsedRealtime();
      } else {
        l = -2147483648L;
      }
      WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_Long = l;
      if ((localObject1 != null) && (!localObject1.isCommentAd())) {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(BaseApplication.getContext()).a(1).b(8).b(paramView).a(localObject1).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData)).c(paramInt));
      }
      a(true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131380489));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362818));
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362819));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131362822);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131362824));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131380555));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_c_of_type_AndroidViewView.findViewById(2131362119));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(new ReadInJoyArticleBottomVideoView.2(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewView.findViewById(2131380490));
    this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131380696);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381294));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    b(false);
  }
  
  private void e()
  {
    if (this.e)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoStartUI  with hasShowCompleteGuide");
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoStartUI");
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidViewViewGroup);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetImageView);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentImageURLImageView);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetTextView);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void f()
  {
    if (this.e)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoPauseUI  with hasShowCompleteGuide");
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoPauseUI");
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (NetworkState.isWifiConn())
    {
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidViewViewGroup);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    else
    {
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidViewViewGroup);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (FastWebVideoPlayManager.a.a() == 7) {
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView);
    } else {
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetTextView);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private void g()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoCompleteUI");
    this.e = true;
    ProteusBannerVideoItemData localProteusBannerVideoItemData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
    if (localProteusBannerVideoItemData != null) {
      localProteusBannerVideoItemData.jdField_a_of_type_Boolean = true;
    }
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidViewViewGroup);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetImageView);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetTextView);
    AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView);
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
  }
  
  private void h()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoErrorUI");
    f();
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView);
  }
  
  private void i()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "initCoverView");
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.e)))
      {
        jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.e;
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "fast_web";
        localObject = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(jdField_a_of_type_JavaLangString, 4), (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
          ((URLDrawable)localObject).restartDownload();
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void j()
  {
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
    if (localReadInJoyAdVideoGuide != null)
    {
      ProteusBannerVideoItemData localProteusBannerVideoItemData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
      if (localProteusBannerVideoItemData != null) {
        localReadInJoyAdVideoGuide.setAppInfo(localProteusBannerVideoItemData.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.J, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.q, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.p, FastWeqAdUtils.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      String str = HardCodeUtil.a(2131712986);
      Object localObject;
      if (CUKingCardUtils.a() == 1)
      {
        localObject = HardCodeUtil.a(2131712729);
      }
      else
      {
        ProteusBannerVideoItemData localProteusBannerVideoItemData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
        localObject = str;
        if (localProteusBannerVideoItemData != null)
        {
          localObject = str;
          if (localProteusBannerVideoItemData.jdField_a_of_type_Long > 0L)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).fileSizeToString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_a_of_type_Long));
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131712753));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_a_of_type_Boolean = false;
    this.e = false;
    this.d = true;
    FastWebVideoPlayManager.a.a(true);
    FastWebVideoPlayManager.a.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
  }
  
  public void a() {}
  
  public void a(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (FastWebVideoPlayManager.a.a(paramProteusBannerVideoItemData1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = paramAdModuleVideo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData = paramProteusBannerVideoItemData1;
    i();
    j();
    k();
    paramAdvertisementInfo = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramProteusBannerVideoItemData2 = new StringBuilder();
    paramProteusBannerVideoItemData2.append("view videoContainer is ");
    paramProteusBannerVideoItemData2.append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.hashCode());
    paramAdvertisementInfo.d("VideoPlayerWrapper_AD", paramProteusBannerVideoItemData2.toString());
    FastWebVideoPlayManager.a.a(paramProteusBannerVideoItemData1.w, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoStateCallback);
    FastWebVideoPlayManager.a.a(false);
    FastWebVideoPlayManager.a.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramAdModuleVideo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramProteusBannerVideoItemData1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    } else {
      FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    }
    FastWebVideoPlayManager.a.g();
  }
  
  public boolean a()
  {
    return FastWebVideoPlayManager.a.a();
  }
  
  public void b()
  {
    FastWebVideoPlayManager.a.f();
  }
  
  public void c() {}
  
  public int getComMeasuredHeight()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getMeasuredWidth();
    }
    return 0;
  }
  
  public View getNativeView()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (a()) {
      i = 6;
    } else {
      i = 5;
    }
    a(paramView, false, i);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.measure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView
 * JD-Core Version:    0.7.0.1
 */