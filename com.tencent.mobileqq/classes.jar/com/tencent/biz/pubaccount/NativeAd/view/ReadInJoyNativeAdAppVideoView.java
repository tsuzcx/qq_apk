package com.tencent.biz.pubaccount.NativeAd.view;

import aatp;
import akwd;
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
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import arre;
import bdin;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
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
import nnx;
import nom;
import noy;
import npj;
import npk;
import npl;
import npm;
import nrt;
import obk;
import oee;
import oge;
import orc;
import rjm;

public class ReadInJoyNativeAdAppVideoView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, oge
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
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new npj(this);
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.4(this);
  private nnx jdField_a_of_type_Nnx;
  private nom jdField_a_of_type_Nom;
  private npl jdField_a_of_type_Npl;
  private npm jdField_a_of_type_Npm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10000;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public Runnable b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.1(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private int g = 1;
  private int h = 1;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public ReadInJoyNativeAdAppVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.6(this);
    c(paramContext);
  }
  
  public ReadInJoyNativeAdAppVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.6(this);
    c(paramContext);
  }
  
  public ReadInJoyNativeAdAppVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_JavaLangRunnable = new ReadInJoyNativeAdAppVideoView.6(this);
    c(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 4))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 3000L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364329));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380080));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379590));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379589));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372292));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378220));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131362683));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131362678));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362679));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362682);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362684));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379653));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379595));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366996));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366997));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)findViewById(2131362002));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(this);
  }
  
  private void c(Context paramContext)
  {
    inflate(getContext(), 2131559880, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    d(paramContext);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Nnx != null)
    {
      if (!this.jdField_a_of_type_Nnx.jdField_a_of_type_Boolean) {
        break label44;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    while (this.jdField_a_of_type_Nnx.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      label44:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void d(Context paramContext)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(paramContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
    this.jdField_a_of_type_Npm = new npm(this, new Handler());
    getContext().getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.jdField_a_of_type_Npm);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyNativeAdAppVideoView.3(this));
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      return;
    case 6: 
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      noy.a(new obk().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(getContext()).a(noy.jdField_f_of_type_Int).b(noy.O).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(noy.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.g, this.h, (int)this.jdField_a_of_type_Long, noy.aG, 0)).a());
      this.g = 2;
      this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      this.jdField_e_of_type_Int = 0;
      return;
    case 4: 
    case 5: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      return;
    case 8: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      return;
    case 3: 
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setRepeatMode(1);
      localRotateAnimation.setStartTime(-1L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.jdField_e_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if ((this.jdField_a_of_type_Nnx != null) && (this.jdField_a_of_type_Nnx.jdField_d_of_type_Boolean))
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(8);
  }
  
  private void e(Context paramContext)
  {
    this.jdField_a_of_type_Int = 3;
    e();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    TVK_UserInfo localTVK_UserInfo;
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(paramContext);
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        localTVK_UserInfo = new TVK_UserInfo("", "");
        localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, noy.a(this.jdField_a_of_type_Nom.d), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rjm.a);
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        HashMap localHashMap = new HashMap();
        localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
        if (this.jdField_a_of_type_Nnx == null) {
          break label304;
        }
      }
    }
    label304:
    for (boolean bool = this.jdField_a_of_type_Nnx.jdField_c_of_type_Boolean;; bool = true)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(bool);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, this.jdField_a_of_type_Nom.d, this.jdField_b_of_type_Long, 0L, localTVK_UserInfo, localTVK_PlayerVideoInfo);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setVisibility(0);
  }
  
  private void f(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    ThreadManager.post(new ReadInJoyNativeAdAppVideoView.2(this, paramContext), 2, null, false);
  }
  
  private void g()
  {
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694766, 0).a();
    }
    while ((!PublicFragmentActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)) || (((PublicFragmentActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      return;
    }
    arre.a(this.jdField_a_of_type_AndroidContentContext, 2131692754, 2131689625, new npk(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
    e(getContext());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Npm != null) {
      getContext().getApplicationContext().getApplicationContext().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_Npm);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
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
    if (paramInt == noy.ax) {
      h();
    }
    while (this.jdField_a_of_type_Npl == null) {
      return;
    }
    this.jdField_a_of_type_Npl.a(paramView);
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
    String str1 = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        str1 = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        str1 = noy.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str1, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rjm.a);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str2 = arrayOfString[i1];
      int i3 = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, localTVK_PlayerVideoInfo, str2);
      if ((i3 == 2) || (i3 == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNativeAdAppVideoView", 2, str1 + " checkIsVideoCached(), definition = " + str2 + ", cacheStatus = " + i3 + ", return TRUE");
        }
        return true;
      }
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, str1 + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int != 7) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      e();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(Context paramContext)
  {
    if (!bdin.h(paramContext)) {}
    while ((this.jdField_a_of_type_Int == 7) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    this.jdField_a_of_type_Int = 5;
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing()));
            if (bdin.h(this.jdField_a_of_type_AndroidContentContext))
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
          } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()));
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
          this.jdField_a_of_type_Int = 6;
          e();
          return;
        } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute())
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841276);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841275);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        return;
        if (bdin.h(this.jdField_a_of_type_AndroidContentContext))
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
          this.jdField_a_of_type_Int = 4;
          e();
          this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
          return;
        }
        g();
        return;
      } while (!(getContext() instanceof Activity));
      ((Activity)getContext()).finish();
      return;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        a(false);
        return;
      }
      a(true);
      return;
    } while (this.jdField_a_of_type_Npl == null);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Npl.d();
      return;
    }
    this.jdField_a_of_type_Npl.e();
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
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "error msg = " + paramString);
    }
    this.jdField_a_of_type_Int = 8;
    e();
    noy.a(new obk().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(getContext()).a(noy.jdField_f_of_type_Int).b(noy.O).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(noy.a(0, 0, 0, 0, 0, 0, (int)this.jdField_a_of_type_Long, noy.aG, 2)).a());
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
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "on stop touch,video state = " + this.jdField_a_of_type_Int);
    }
    int i1 = (int)(paramSeekBar.getProgress() * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "seek position millions = " + i1);
    }
    if ((this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(i1);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    int i1 = 1;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyNativeAdAppVideoView.8(this));
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      boolean bool = a(this.jdField_a_of_type_Nom.d, this.jdField_a_of_type_Nom.d);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdAppVideoView", 2, "native ad preload cache state: " + bool);
      }
      paramTVK_IMediaPlayer = "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdUin;
      if (!bool) {
        break label177;
      }
    }
    for (;;)
    {
      nrt.a(null, paramTVK_IMediaPlayer, "0X80093B8", "0X80093B8", 0, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId, null, null, null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_a_of_type_Int = 4;
      e();
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label177:
      i1 = 0;
    }
  }
  
  public void setAdSetting(nnx paramnnx)
  {
    this.jdField_a_of_type_Nnx = paramnnx;
  }
  
  public void setOnVideoFullScreen(npl paramnpl)
  {
    this.jdField_a_of_type_Npl = paramnpl;
  }
  
  public void setVideoData(nom paramnom, AdvertisementInfo paramAdvertisementInfo, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Nom = paramnom;
    try
    {
      paramnom = new URL(this.jdField_a_of_type_Nom.e);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a(paramnom);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = akwd.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(orc.a((int)this.jdField_a_of_type_Nom.jdField_a_of_type_Long));
      d();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdVideoGuide.setAppInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporationName, "", oee.e(paramAdvertisementInfo));
      }
      return;
    }
    catch (MalformedURLException paramnom)
    {
      for (;;)
      {
        paramnom.printStackTrace();
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
      if (!paramBoolean) {
        break label203;
      }
      localObject1 = (Activity)getContext();
      localObject2 = ((Activity)localObject1).getWindow();
      ((Window)localObject2).setFlags(1024, 1024);
      ((Activity)localObject1).setRequestedOrientation(0);
      localObject2 = ((Window)localObject2).getDecorView();
      this.k = ((View)localObject2).getSystemUiVisibility();
      ((View)localObject2).setSystemUiVisibility(3846);
      localObject2 = getLayoutParams();
      this.i = ((ViewGroup.LayoutParams)localObject2).width;
      this.j = ((ViewGroup.LayoutParams)localObject2).height;
      localObject1 = aatp.a((Activity)localObject1);
      paramInt = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = paramInt;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841448));
      localObject1 = getParent();
      if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
      {
        localObject1 = (ViewGroup)localObject1;
        this.l = ((ViewGroup)localObject1).getPaddingTop();
        this.m = ((ViewGroup)localObject1).getPaddingBottom();
        this.n = ((ViewGroup)localObject1).getPaddingLeft();
        this.o = ((ViewGroup)localObject1).getPaddingRight();
        ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
      }
    }
    return;
    label203:
    Object localObject1 = (Activity)getContext();
    ((Activity)localObject1).getWindow().setFlags(1024, 8);
    ((Activity)localObject1).setRequestedOrientation(1);
    ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.k);
    localObject1 = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = this.i;
    ((ViewGroup.LayoutParams)localObject1).height = this.j;
    Object localObject2 = getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
      ((ViewGroup)localObject2).setPadding(this.n, this.l, this.o, this.m);
    }
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841447));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView
 * JD-Core Version:    0.7.0.1
 */