package com.tencent.biz.pubaccount.NativeAd.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.data.NativeAdVideoSetting;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide.AdGuideClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReadInJoyNativeAdAppVideoView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ReadInJoyAdVideoGuide.AdGuideClickListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NativeAdVideoSetting jdField_a_of_type_ComTencentBizPubaccountNativeAdDataNativeAdVideoSetting;
  private AdModuleVideo jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo;
  private ReadInJoyNativeAdAppVideoView.VideoFullScreenListener jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VideoFullScreenListener;
  private ReadInJoyNativeAdAppVideoView.VolumeChangedObserver jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VolumeChangedObserver;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ResizeURLImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ReadInJoyNativeAdAppVideoView.5(this);
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.4(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 10000;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.6(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.1(this);
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int jdField_f_of_type_Int = 0;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private int g = 1;
  private int h = 1;
  private int i = 0;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public ReadInJoyNativeAdAppVideoView(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ReadInJoyNativeAdAppVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ReadInJoyNativeAdAppVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = this.jdField_a_of_type_Int;
    if ((i1 == 5) || (i1 == 4))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364705));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380990));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380489));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380488));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373077));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379063));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131362823));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView = ((ResizeURLImageView)findViewById(2131362818));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362819));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362822);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362824));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380555));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380493));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131367407));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367408));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)findViewById(2131362119));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(this);
  }
  
  private void c(Context paramContext)
  {
    inflate(getContext(), 2131560054, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    d(paramContext);
  }
  
  private void d()
  {
    NativeAdVideoSetting localNativeAdVideoSetting = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataNativeAdVideoSetting;
    if (localNativeAdVideoSetting != null)
    {
      if (localNativeAdVideoSetting.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataNativeAdVideoSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  private void d(Context paramContext)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(paramContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VolumeChangedObserver = new ReadInJoyNativeAdAppVideoView.VolumeChangedObserver(this, new Handler());
    getContext().getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VolumeChangedObserver);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyNativeAdAppVideoView.3(this));
      return;
    }
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 8: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      return;
    case 7: 
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataNativeAdVideoSetting;
      if ((localObject != null) && (((NativeAdVideoSetting)localObject).jdField_d_of_type_Boolean))
      {
        f();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
      return;
    case 6: 
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(getContext()).a(6).b(7).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.g, this.h, (int)this.jdField_a_of_type_Long, 10, 0, this.i, ReportConstants.VideoEndType.CLICK_PAUSE)));
      this.g = 2;
      this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      this.jdField_e_of_type_Int = 0;
      return;
    case 4: 
    case 5: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      return;
    case 3: 
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
      localObject = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      ((RotateAnimation)localObject).setDuration(500L);
      ((RotateAnimation)localObject).setRepeatCount(-1);
      ((RotateAnimation)localObject).setRepeatMode(1);
      ((RotateAnimation)localObject).setStartTime(-1L);
      ((RotateAnimation)localObject).setInterpolator(new LinearInterpolator());
      this.jdField_e_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
  }
  
  private void e(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    e();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    Object localObject1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = ((TVK_IProxyFactory)localObject1).getCacheMgr(paramContext);
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        ((View)localObject1).setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        localObject1 = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject2);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataNativeAdVideoSetting;
        boolean bool;
        if (localObject2 != null) {
          bool = ((NativeAdVideoSetting)localObject2).jdField_c_of_type_Boolean;
        } else {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(bool);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.d, this.jdField_b_of_type_Long, 0L, (TVK_UserInfo)localObject1, localTVK_PlayerVideoInfo);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setVisibility(0);
  }
  
  private void f(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    ThreadManager.post(new ReadInJoyNativeAdAppVideoView.2(this, paramContext), 2, null, false);
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694422, 0).a();
      return;
    }
    if ((PublicFragmentActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)) && (!((PublicFragmentActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692561, 2131689584, new ReadInJoyNativeAdAppVideoView.7(this));
    }
  }
  
  private void h()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
    e(getContext());
    this.i += 1;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VolumeChangedObserver != null) {
      getContext().getApplicationContext().getApplicationContext().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VolumeChangedObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localObject != null)
    {
      ((TVK_IMediaPlayer)localObject).stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      e(paramContext);
      return;
    }
    f(paramContext);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 21)
    {
      h();
      return;
    }
    ReadInJoyNativeAdAppVideoView.VideoFullScreenListener localVideoFullScreenListener = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VideoFullScreenListener;
    if (localVideoFullScreenListener != null) {
      localVideoFullScreenListener.a(paramView, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt));
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
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
      int i3 = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString1, localTVK_UserInfo, localTVK_PlayerVideoInfo, str);
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
          QLog.d("ReadInJoyNativeAdAppVideoView", 2, paramString1.toString());
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" checkIsVideoCached() return FALSE");
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, paramString1.toString());
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 7)
    {
      TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if (localTVK_IMediaPlayer != null)
      {
        localTVK_IMediaPlayer.pause();
        this.jdField_a_of_type_Int = 6;
        e();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
  }
  
  public void b(Context paramContext)
  {
    if (!NetworkUtil.isWifiConnected(paramContext)) {
      return;
    }
    if (this.jdField_a_of_type_Int != 7)
    {
      paramContext = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if (paramContext != null)
      {
        paramContext.start();
        this.jdField_a_of_type_Int = 5;
        e();
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131380990: 
      paramView = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if (paramView != null)
      {
        if (paramView.getOutputMute())
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841664);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841663);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        return;
      }
      break;
    case 2131380489: 
      paramView = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if ((paramView != null) && (paramView.isPauseing()))
      {
        if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
          this.jdField_a_of_type_Int = 4;
          e();
          this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
          this.h = 2;
          return;
        }
        g();
        return;
      }
      break;
    case 2131380488: 
      paramView = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
      if ((paramView != null) && (paramView.isPlaying()))
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
        this.jdField_a_of_type_Int = 6;
        e();
        return;
      }
      break;
    case 2131367407: 
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VideoFullScreenListener;
      if (paramView != null)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          paramView.d();
          return;
        }
        paramView.e();
        return;
      }
      break;
    case 2131364705: 
      if ((getContext() instanceof Activity))
      {
        ((Activity)getContext()).finish();
        return;
      }
      break;
    case 2131362822: 
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        a(false);
        return;
      }
      a(true);
      return;
    case 2131362819: 
      if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        this.jdField_a_of_type_Int = 4;
        e();
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        return;
      }
      g();
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "onCompletion");
    }
    this.jdField_a_of_type_Int = 7;
    e();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("error msg = ");
      paramTVK_IMediaPlayer.append(paramString);
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, paramTVK_IMediaPlayer.toString());
    }
    this.jdField_a_of_type_Int = 8;
    e();
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(getContext()).a(6).b(7).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 0, 0, 0, 0, (int)this.jdField_a_of_type_Long, 10, 2, 0, ReportConstants.VideoEndType.OTHER)));
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("on stop touch,video state = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, localStringBuilder.toString());
    }
    int i1 = (int)(paramSeekBar.getProgress() * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int);
    if (QLog.isColorLevel())
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("seek position millions = ");
      paramSeekBar.append(i1);
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, paramSeekBar.toString());
    }
    int i2 = this.jdField_a_of_type_Int;
    if ((i2 == 5) || (i2 == 4) || (i2 == 6)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(i1);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setAdSetting(NativeAdVideoSetting paramNativeAdVideoSetting)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataNativeAdVideoSetting = paramNativeAdVideoSetting;
  }
  
  public void setOnVideoFullScreen(ReadInJoyNativeAdAppVideoView.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView$VideoFullScreenListener = paramVideoFullScreenListener;
  }
  
  public void setVideoData(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = paramAdModuleVideo;
    try
    {
      paramAdModuleVideo = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.e);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setImage(paramAdModuleVideo);
    }
    catch (MalformedURLException paramAdModuleVideo)
    {
      paramAdModuleVideo.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration((int)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo.jdField_a_of_type_Long));
    d();
    paramAdModuleVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
    if (paramAdModuleVideo != null)
    {
      paramAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if (paramAppInterface != null) {
        paramAdModuleVideo.setAppInfo(paramAppInterface.mAdProductType, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporationName, "", ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramAdvertisementInfo), paramAdvertisementInfo);
      }
    }
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = ((int)(this.jdField_b_of_type_Long / 1000L));
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      Object localObject1;
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = (Activity)getContext();
        localObject2 = ((Activity)localObject1).getWindow();
        ((Window)localObject2).setFlags(1024, 1024);
        ((Activity)localObject1).setRequestedOrientation(0);
        localObject2 = ((Window)localObject2).getDecorView();
        this.l = ((View)localObject2).getSystemUiVisibility();
        ((View)localObject2).setSystemUiVisibility(3846);
        localObject2 = getLayoutParams();
        this.j = ((ViewGroup.LayoutParams)localObject2).width;
        this.k = ((ViewGroup.LayoutParams)localObject2).height;
        localObject1 = GdtUIUtils.a((Activity)localObject1);
        paramInt = localObject1[0];
        ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
        ((ViewGroup.LayoutParams)localObject2).height = paramInt;
        setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841854));
        localObject1 = getParent();
        if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
        {
          localObject1 = (ViewGroup)localObject1;
          this.m = ((ViewGroup)localObject1).getPaddingTop();
          this.n = ((ViewGroup)localObject1).getPaddingBottom();
          this.o = ((ViewGroup)localObject1).getPaddingLeft();
          this.p = ((ViewGroup)localObject1).getPaddingRight();
          ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
        }
      }
      else
      {
        localObject1 = (Activity)getContext();
        ((Activity)localObject1).getWindow().setFlags(1024, 8);
        ((Activity)localObject1).setRequestedOrientation(1);
        ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.l);
        localObject1 = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.j;
        ((ViewGroup.LayoutParams)localObject1).height = this.k;
        localObject2 = getParent();
        if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
          ((ViewGroup)localObject2).setPadding(this.o, this.m, this.p, this.n);
        }
        setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841853));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView
 * JD-Core Version:    0.7.0.1
 */