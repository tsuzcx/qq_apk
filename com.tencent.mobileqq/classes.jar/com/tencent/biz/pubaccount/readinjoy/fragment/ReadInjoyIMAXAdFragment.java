package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ClipLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsResourceLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInjoyIMAXAdFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static long a = -1L;
  public static Drawable a;
  public static long b = -1L;
  public static boolean b = false;
  public static boolean d = false;
  public static boolean e = false;
  public static boolean f = false;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdModuleVideo jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo;
  private ActionEntity jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity;
  private ReadInjoyIMAXAdFragment.Param jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param;
  private ClipLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString = "3";
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int jdField_f_of_type_Int = 1;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private int jdField_g_of_type_Int = 1;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int = 0;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean = false;
  private boolean o = false;
  private boolean p = false;
  
  public ReadInjoyIMAXAdFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  private ReportConstants.VideoEndType a(int paramInt)
  {
    ReportConstants.VideoEndType localVideoEndType = ReportConstants.VideoEndType.NORMAL_COMPLETE;
    if (paramInt == 20) {
      return ReportConstants.VideoEndType.CLICK_PAUSE;
    }
    if (paramInt == 23) {
      return ReportConstants.VideoEndType.AD_AREA_CLICK;
    }
    if (paramInt == 17) {
      return ReportConstants.VideoEndType.SLIDE_LEAVE;
    }
    if (paramInt == 19) {
      localVideoEndType = ReportConstants.VideoEndType.AD_AREA_CLICK;
    }
    return localVideoEndType;
  }
  
  private void a(int paramInt)
  {
    a(paramInt);
    ReadInjoyIMAXAdFragment.Param localParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param;
    if ((localParam != null) && (localParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!this.p) && (paramInt >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImgDisplayMs))
    {
      this.p = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxJumpLandingPage == 1) {
        e(this);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startIMAX: time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_m_of_type_Boolean = true;
    if (this.jdField_g_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject != null) {
        ((URLDrawable)localObject).setURLDrawableListener(null);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setAlpha(1.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setNeedClip(true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viewHeight =");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",viewWidth =");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startLeft =");
      ((StringBuilder)localObject).append(this.jdField_j_of_type_Int);
      ((StringBuilder)localObject).append(",startTop =");
      ((StringBuilder)localObject).append(this.jdField_k_of_type_Int);
      ((StringBuilder)localObject).append(",startRight =");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
      ((StringBuilder)localObject).append(",startBottom =");
      ((StringBuilder)localObject).append(this.jdField_i_of_type_Int);
      QLog.d("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ReadInjoyIMAXAdFragment.3(this, paramInt1, paramInt2));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ReadInjoyIMAXAdFragment.4(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param;
    if ((localObject != null) && (((ReadInjoyIMAXAdFragment.Param)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if (localObject != null)
      {
        long l1 = ((TVK_IMediaPlayer)localObject).getDuration() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowSlipAllowMs;
        if ((l1 > 0L) && (l1 < paramLong)) {
          m();
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowSlipAllowMs < paramLong)
      {
        m();
      }
    }
  }
  
  public static void a(Context paramContext, ReadInjoyIMAXAdFragment.Param paramParam)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("w", paramParam.jdField_c_of_type_Int);
    localIntent.putExtra("h", paramParam.jdField_d_of_type_Int);
    localIntent.putExtra("top", paramParam.jdField_b_of_type_Int);
    localIntent.putExtra("left", paramParam.jdField_a_of_type_Int);
    localIntent.putExtra("ad", paramParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, ReadInjoyIMAXAdFragment.class);
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg))
    {
      f(this);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(getBaseActivity());
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, 0, (ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
    paramAdvertisementInfo = URLDrawable.getDrawable(paramAdvertisementInfo.mImaxImg, (URLDrawable.URLDrawableOptions)localObject);
    localObject = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      ((Display)localObject).getRealMetrics(localDisplayMetrics);
    } else {
      ((Display)localObject).getMetrics(localDisplayMetrics);
    }
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels + this.jdField_n_of_type_Int;
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.getStatus() == 2))
    {
      paramAdvertisementInfo.restartDownload();
      return;
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.getStatus() == 1))
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(paramAdvertisementInfo);
      a(i1, i2);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(-2);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(-2);
      return;
    }
    if (paramAdvertisementInfo != null)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(paramAdvertisementInfo);
      paramAdvertisementInfo.setURLDrawableListener(new ReadInjoyIMAXAdFragment.2(this, i1, i2));
    }
  }
  
  private void a(AppInterface paramAppInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", this.jdField_a_of_type_JavaLangString);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramAppInterface).a(a()).a(paramInt).b(27).a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity).b(Integer.valueOf(23)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(localHashMap)));
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = ((int)((TVK_IMediaPlayer)localObject).getCurrentPostion());
      localObject = a(paramInt);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramAppInterface).a(a()).a(6).b(27).a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, (int)this.jdField_c_of_type_Long, 2, 0, 0, (ReportConstants.VideoEndType)localObject)).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(localHashMap)));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("ReadInjoyIMAXAdFragment", 1, "preloadToolsProcess running");
    if (paramQQAppInterface == null)
    {
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
        paramQQAppInterface = (IWebProcessManagerService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IWebProcessManagerService.class, "multi");
      } else {
        paramQQAppInterface = null;
      }
    }
    else {
      paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.startWebProcess(200, null);
    }
  }
  
  public static boolean a()
  {
    return true;
  }
  
  private boolean a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    boolean bool = true;
    if (paramProteusBannerVideoItemData1 != null)
    {
      if (paramProteusBannerVideoItemData2 == null) {
        return true;
      }
      if ((!TextUtils.isEmpty(paramProteusBannerVideoItemData1.w)) && (!paramProteusBannerVideoItemData1.w.equals(paramProteusBannerVideoItemData2.w))) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new ReadInjoyIMAXAdFragment.ProgressUIHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout = ((ClipLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131380555));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131368587));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131368586));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131368590));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131380040));
    this.jdField_a_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131370277);
    this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131370331);
    this.jdField_c_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131376764);
    this.jdField_d_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131376763);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131372084));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131380563));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    paramContext = new ReadInjoyIMAXAdFragment.1(this, new GestureDetector(getBaseActivity(), new ReadInjoyIMAXAdFragment.GestureDelectorSimlpeListener(this)));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(paramContext);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(paramContext);
    ((FrameLayout)getBaseActivity().findViewById(16908290)).setForeground(new ColorDrawable(0));
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    i();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    Object localObject1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
    if ((localObject1 != null) && (paramContext != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo != null))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = ((TVK_IProxyFactory)localObject1).getCacheMgr(paramContext);
      Object localObject2 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      localObject1 = new ReadInjoyIMAXAdFragment.WeakListener(this);
      ((IVideoViewBase)localObject2).addViewCallBack((IVideoViewBase.IVideoViewCallBack)localObject1);
      this.jdField_e_of_type_AndroidViewView = ((View)localObject2);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout != null)
      {
        this.jdField_e_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.addView(this.jdField_e_of_type_AndroidViewView, 0);
        localObject2 = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        Object localObject3 = new HashMap();
        ((Map)localObject3).put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject3);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), (IVideoViewBase)this.jdField_e_of_type_AndroidViewView);
        localObject3 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (localObject3 != null)
        {
          ((TVK_IMediaPlayer)localObject3).setOnVideoPreparedListener((TVK_IMediaPlayer.OnVideoPreparedListener)localObject1);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener((TVK_IMediaPlayer.OnErrorListener)localObject1);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener((TVK_IMediaPlayer.OnCompletionListener)localObject1);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d, 0L, 0L, (TVK_UserInfo)localObject2, localTVK_PlayerVideoInfo);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("openMediaPlayerByUrl: time=");
            paramContext.append(System.currentTimeMillis());
            QLog.d("ReadInjoyIMAXAdFragment", 2, paramContext.toString());
          }
        }
      }
    }
  }
  
  private void d(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      TVK_SDKMgr.installPlugin(paramContext.getApplicationContext(), new ReadInjoyIMAXAdFragment.7(this));
      return;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installSDK t==");
      localStringBuilder.append(paramContext.toString());
      GdtLog.a("ReadInjoyIMAXAdFragment", localStringBuilder.toString());
    }
  }
  
  private static void e(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    paramReadInjoyIMAXAdFragment.jdField_a_of_type_Int = 9;
    jdField_f_of_type_Boolean = true;
    TVK_IMediaPlayer localTVK_IMediaPlayer = paramReadInjoyIMAXAdFragment.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
    if (paramReadInjoyIMAXAdFragment.jdField_k_of_type_Boolean) {
      return;
    }
    paramReadInjoyIMAXAdFragment.jdField_k_of_type_Boolean = true;
    f(paramReadInjoyIMAXAdFragment);
    paramReadInjoyIMAXAdFragment.a(paramReadInjoyIMAXAdFragment.getBaseActivity().app, 23);
  }
  
  private static void f(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    if (paramReadInjoyIMAXAdFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param != null)
    {
      if (paramReadInjoyIMAXAdFragment.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startImaxNativeLoadingPage(paramReadInjoyIMAXAdFragment.getBaseActivity(), paramReadInjoyIMAXAdFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdLandingPage, paramReadInjoyIMAXAdFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      paramReadInjoyIMAXAdFragment.jdField_b_of_type_AndroidOsHandler.postDelayed(new ReadInjoyIMAXAdFragment.8(paramReadInjoyIMAXAdFragment), 400L);
    }
  }
  
  private void j()
  {
    e(this);
  }
  
  private void k()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoPreparedInitialization: time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("ReadInjoyIMAXAdFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("native ad preload cache state: ");
        localStringBuilder.append(bool);
        QLog.d("ReadInjoyIMAXAdFragment", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 4;
      this.jdField_g_of_type_Int = 2;
      i();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(4);
      if (!this.jdField_m_of_type_Boolean)
      {
        this.jdField_m_of_type_Boolean = true;
        a(((IVideoViewBase)this.jdField_e_of_type_AndroidViewView).getViewWidth(), ((IVideoViewBase)this.jdField_e_of_type_AndroidViewView).getViewHeight());
      }
      if (QLog.isColorLevel()) {
        QLog.i("ReadInjoyIMAXAdFragment", 2, "ReadInjoyIMAXAdFragment onVideoPrepared isRetry start");
      }
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(-2);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(-2);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
  }
  
  private void l()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localTVK_IMediaPlayer != null) && (!jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_Int = 6;
      localTVK_IMediaPlayer.pause();
      i();
    }
  }
  
  private void m()
  {
    Object localObject = this.jdField_e_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getAnimation() != null)) {
      return;
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (this.jdField_e_of_type_AndroidWidgetImageView != null))
    {
      ((View)localObject).setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 0.2F);
      ((TranslateAnimation)localObject).setDuration(900L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.2F, 1, 0.0F);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new ReadInjoyIMAXAdFragment.9(this, localTranslateAnimation));
      localTranslateAnimation.setAnimationListener(new ReadInjoyIMAXAdFragment.10(this, (TranslateAnimation)localObject));
      this.jdField_e_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    }
  }
  
  public void a()
  {
    Object localObject1 = getBaseActivity().getIntent();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param = new ReadInjoyIMAXAdFragment.Param();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("w", 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("h", 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("top", 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("left", 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)((Intent)localObject1).getParcelableExtra("ad"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = getBaseActivity().app;
    this.jdField_l_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxShowAdType;
    this.jdField_j_of_type_Int = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_Int + 0);
    this.jdField_k_of_type_Int = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_b_of_type_Int + 0);
    this.jdField_h_of_type_Int = (this.jdField_j_of_type_Int + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_c_of_type_Int - 0);
    this.jdField_i_of_type_Int = (this.jdField_k_of_type_Int + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_d_of_type_Int - 0);
    localObject1 = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject1 != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_c_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject1).height = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_d_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.jdField_k_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.jdField_j_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(0.97F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(0.97F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setAlpha(0.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.setNeedClip(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt);
    }
    int i1 = this.jdField_l_of_type_Int;
    if (i1 == 1001)
    {
      this.jdField_a_of_type_JavaLangString = "3";
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = new AdModuleVideo();
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxVideoUrl;
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = ActionEntity.ImaxVideo;
      a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, null);
    }
    else if (i1 == 1002)
    {
      this.jdField_a_of_type_JavaLangString = "10";
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = ActionEntity.ImaxPic;
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(getBaseActivity().app);
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdLandingPage;
    Object localObject2 = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent(((Application)localObject2).getBaseContext(), PreloadWebService.class);
    localIntent.putExtra("url", (String)localObject1);
    try
    {
      ((Application)localObject2).getBaseContext().startService(localIntent);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("preDownloadIfNecessary=>");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", this.jdField_a_of_type_JavaLangString);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getBaseActivity()).a(2).b(27).a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment$Param.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(localHashMap)));
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_g_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext.getApplicationContext()))
    {
      c(paramContext);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInjoyIMAXAdFragment.6(this, paramContext));
  }
  
  public void a(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (paramAdModuleVideo == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = new AdModuleVideo();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d = paramAdvertisementInfo.mImaxVideoUrl;
    if ((jdField_a_of_type_Long == -1L) || (System.currentTimeMillis() - jdField_a_of_type_Long > 1000L) || (a(paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2)))
    {
      a(a());
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg)) {
      return;
    }
    this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(getBaseActivity());
    paramAdModuleVideo = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.getChildCount() == 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout.addView(this.jdField_g_of_type_AndroidWidgetImageView, i1, paramAdModuleVideo);
    this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    paramAdModuleVideo = URLDrawable.URLDrawableOptions.obtain();
    paramAdModuleVideo.mPlayGifImage = true;
    paramAdModuleVideo.mLoadingDrawable = new ColorDrawable(-16777216);
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramAdvertisementInfo.mImaxImg, paramAdModuleVideo);
    paramAdModuleVideo = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay();
    paramAdvertisementInfo = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      paramAdModuleVideo.getRealMetrics(paramAdvertisementInfo);
    } else {
      paramAdModuleVideo.getMetrics(paramAdvertisementInfo);
    }
    int i1 = paramAdvertisementInfo.widthPixels;
    int i2 = paramAdvertisementInfo.heightPixels + this.jdField_n_of_type_Int;
    paramAdModuleVideo = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((paramAdModuleVideo != null) && (paramAdModuleVideo.getStatus() == 2))
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      return;
    }
    paramAdModuleVideo = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((paramAdModuleVideo != null) && (paramAdModuleVideo.getStatus() == 1))
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      a(i1, i2);
      return;
    }
    paramAdModuleVideo = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramAdModuleVideo != null)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(paramAdModuleVideo);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ReadInjoyIMAXAdFragment.5(this, i1, i2));
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    if ((paramString1 != null) && ((paramString2 == null) || (paramString1.equals(paramString2)))) {
      paramString2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString1);
    }
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, paramString2, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int i1 = arrayOfString.length;
    int i2 = 0;
    while (i2 < i1)
    {
      String str = arrayOfString[i2];
      int i3 = localTVK_ICacheMgr.isVideoCached(a(), paramString1, localTVK_UserInfo, localTVK_PlayerVideoInfo, str);
      if ((i3 != 2) && (i3 != 1))
      {
        i2 += 1;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append(" checkIsVideoCached(), definition = ");
          paramString1.append(str);
          paramString1.append(", cacheStatus = ");
          paramString1.append(i3);
          paramString1.append(", return TRUE");
          QLog.d("ReadInjoyIMAXAdFragment", 2, paramString1.toString());
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" checkIsVideoCached() return FALSE");
      QLog.d("ReadInjoyIMAXAdFragment", 2, paramString1.toString());
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
      }
      Object localObject1;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler;
        if (localObject1 != null) {
          ((Handler)localObject1).post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this, 5));
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout;
        if (localObject1 != null)
        {
          ((ClipLayout)localObject1).removeAllViews();
          this.jdField_e_of_type_AndroidViewView = null;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewClipLayout = null;
          jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        }
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      jdField_f_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    i();
  }
  
  public void e()
  {
    k();
  }
  
  public void f()
  {
    l();
  }
  
  public void g()
  {
    c(a());
  }
  
  public void h()
  {
    b();
  }
  
  public void i()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null)
      {
        localHandler.post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this, 1));
        return;
      }
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 7: 
    default: 
    case 4: 
    case 5: 
      if (this.jdField_g_of_type_AndroidWidgetImageView != null) {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithAlphaAnimation(this.jdField_g_of_type_AndroidWidgetImageView, 8, 300);
      }
      break;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().setSoftInputMode(17);
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368587: 
      getBaseActivity().finish();
      if (this.jdField_l_of_type_Boolean) {
        return;
      }
      this.jdField_l_of_type_Boolean = true;
      a(getBaseActivity().app, 20);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramView == null) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      paramView.setOutputMute(true);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843028));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    paramView.setOutputMute(false);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843029));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_f_of_type_AndroidViewView = ((IVideoFeedsResourceLoader)QRoute.api(IVideoFeedsResourceLoader.class)).inflate(2131560218, true, new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = paramViewGroup.getContext();
    this.jdField_a_of_type_AndroidContentContext = paramLayoutInflater;
    b(paramLayoutInflater);
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(getBaseActivity());
    getBaseActivity().getWindow().setFlags(1024, 1024);
    LiuHaiUtils.a(getBaseActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getBaseActivity());
    }
    if (LiuHaiUtils.b())
    {
      this.jdField_n_of_type_Int = LiuHaiUtils.b(getBaseActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      int i1 = paramLayoutInflater.topMargin + this.jdField_n_of_type_Int;
      paramLayoutInflater.topMargin = i1;
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramLayoutInflater.topMargin = i1;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramLayoutInflater);
    }
    a();
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    b();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_j_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    localObject = this.jdField_e_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getBaseActivity().overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(getBaseActivity());
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPauseing())) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment
 * JD-Core Version:    0.7.0.1
 */