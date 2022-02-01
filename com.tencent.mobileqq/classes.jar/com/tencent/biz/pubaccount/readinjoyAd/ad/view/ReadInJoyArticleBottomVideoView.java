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
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
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
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;

public class ReadInJoyArticleBottomVideoView
  extends ViewBase
  implements View.OnClickListener
{
  public static String a;
  public static boolean a;
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
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public ReadInJoyArticleBottomVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    a(paramVafContext.getContext());
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd())) {
      return 38;
    }
    return 1;
  }
  
  private Context a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private void a(Context paramContext)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "bottomView create:" + hashCode());
    if (paramContext == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560194, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext.getApplicationContext());
    d();
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)
    {
      localObject2 = ReadInJoyBottomAdVideoUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.g)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        }
      }
      if (localObject1 != null) {
        ((AdvertisementInfo)localObject1).clickPos = paramInt;
      }
      localObject2 = ReadinJoyActionUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData, (AdvertisementInfo)localObject1);
      if (((Integer)localObject2).intValue() == -1) {
        break label83;
      }
    }
    label83:
    do
    {
      return;
      if (LiujinAdJump.isFromLiuJin((AdvertisementInfo)localObject1)) {
        localObject2 = LiujinAdJump.doJumpAction((AdvertisementInfo)localObject1, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramBoolean);
      }
      if (((Integer)localObject2).intValue() != -1)
      {
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, (Integer)localObject2, (AdvertisementInfo)localObject1, 1, 1, 3);
        return;
      }
      boolean bool = a();
      localObject2 = ReadinJoyActionUtil.a(paramView.getContext(), (AdvertisementInfo)localObject1, null, 2, paramBoolean, new AdJumpParams(bool));
    } while (localObject2 == null);
    ((GdtHandler.Params)localObject2).jdField_f_of_type_Boolean = ReadInJoyAdSwitchUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
    ((GdtHandler.Params)localObject2).jdField_a_of_type_Long = FastWebVideoPlayManager.a.a();
    if (localObject1 != null) {
      ((AdvertisementInfo)localObject1).setClickPos(paramInt);
    }
    paramView = ReadinJoyActionUtil.a((GdtHandler.Params)localObject2, paramView.getContext(), (AdvertisementInfo)localObject1);
    if (localObject1 != null) {
      ((AdvertisementInfo)localObject1).setClickPos(paramInt);
    }
    WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject2;
    if (WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_Long = l;
      if ((localObject1 != null) && (!((AdvertisementInfo)localObject1).isCommentAd())) {
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(BaseApplication.getContext()).a(1).b(8).b(paramView).a((AdvertisementInfo)localObject1).d(NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData)).c(paramInt));
      }
      a(true);
      return;
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
    if (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381233));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362866));
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362867));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131362870);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131362872));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131381300));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_c_of_type_AndroidViewView.findViewById(2131362091));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(new ReadInJoyArticleBottomVideoView.2(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewView.findViewById(2131381234));
    this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131381441);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131382092));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    b(false);
  }
  
  private void e()
  {
    if (this.e)
    {
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoStartUI  with hasShowCompleteGuide");
      return;
    }
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoStartUI");
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
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoPauseUI  with hasShowCompleteGuide");
      return;
    }
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoPauseUI");
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (NetworkState.isWifiConn())
    {
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidViewViewGroup);
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView);
      if (FastWebVideoPlayManager.a.a() != 7) {
        break label108;
      }
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
    for (;;)
    {
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetTextView);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
      AdVideoButtonUIUtils.a(this.jdField_a_of_type_AndroidViewViewGroup);
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_AndroidWidgetImageView);
      break;
      label108:
      AdVideoButtonUIUtils.b(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
  }
  
  private void g()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoCompleteUI");
    this.e = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Boolean = true;
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
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoErrorUI");
    f();
    AdVideoButtonUIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView);
  }
  
  private void i()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "initCoverView");
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {}
    for (;;)
    {
      return;
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
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setAppInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.B, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.h, FastWeqAdUtils.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    }
  }
  
  private void k()
  {
    String str2;
    String str1;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      str2 = HardCodeUtil.a(2131713011);
      if (CUKingCardHelper.a() != 1) {
        break label37;
      }
      str1 = HardCodeUtil.a(2131712754);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      return;
      label37:
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Long > 0L) {
          str1 = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Long) + HardCodeUtil.a(2131712778);
        }
      }
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Boolean = false;
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
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "view videoContainer is " + this.jdField_a_of_type_AndroidWidgetRelativeLayout.hashCode());
    FastWebVideoPlayManager.a.a(paramProteusBannerVideoItemData1.o, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoStateCallback);
    FastWebVideoPlayManager.a.a(false);
    FastWebVideoPlayManager.a.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramAdModuleVideo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramProteusBannerVideoItemData1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    for (;;)
    {
      FastWebVideoPlayManager.a.g();
      return;
      FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    }
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
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.getMeasuredWidth();
    }
    return 0;
  }
  
  public View getNativeView()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    int i = 5;
    if (a()) {
      i = 6;
    }
    a(paramView, false, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.measure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView
 * JD-Core Version:    0.7.0.1
 */