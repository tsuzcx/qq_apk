package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kuy;
import kuz;
import kva;
import kvb;
import kvc;
import kvd;
import kvg;
import kvh;
import kvi;
import kvj;
import kvk;
import mqq.os.MqqHandler;

public class VideoCoverView
  extends RelativeLayout
{
  public int a;
  public long a;
  private AnimatorListenerAdapter jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  public ProgressControler a;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private TVK_IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public TVK_PlayerVideoInfo a;
  public TVK_UserInfo a;
  Runnable jdField_a_of_type_JavaLangRunnable = new kva(this);
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private kvk jdField_a_of_type_Kvk;
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  public VideoCoverView(Context paramContext, VideoCoverItem paramVideoCoverItem, int paramInt, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener, ArrayList paramArrayList, AdvertisementItem paramAdvertisementItem, TroopMemberApiClient paramTroopMemberApiClient)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2130969202, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365579));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131362725));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362951);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364671);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new kuy(this, paramContext));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131365580);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(new kvb(this));
    this.jdField_c_of_type_Int = paramVideoCoverItem.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramVideoCoverItem.b;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = paramOnCompletionListener;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setTotalCount(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler = new ProgressControler(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar);
    paramContext = getResources().getDisplayMetrics();
    this.jdField_e_of_type_Int = paramContext.widthPixels;
    this.jdField_d_of_type_Int = paramContext.heightPixels;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = paramTroopMemberApiClient;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.jdField_a_of_type_Kvk = new kvk(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new kvc(this);
    if (this.jdField_c_of_type_Boolean)
    {
      paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.getLayoutParams();
      paramContext.width = this.jdField_e_of_type_Int;
      paramContext.height = ((int)(this.jdField_e_of_type_Int * 0.5626F));
    }
    if (!TextUtils.isEmpty(paramVideoCoverItem.jdField_a_of_type_JavaLangString)) {}
    try
    {
      paramContext = new URL(paramVideoCoverItem.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!VideoCoverFragment.jdField_b_of_type_Boolean)
    {
      b(paramBoolean);
      return;
    }
    if (VideoCoverFragment.jdField_a_of_type_Boolean)
    {
      b(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    b(paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, this.jdField_a_of_type_JavaLangString + " playByNet hasCache:" + bool + " isStop" + paramBoolean);
    }
    if (bool)
    {
      b(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    int i = NetUtil.a(null);
    if (i == 0)
    {
      FMToastUtil.a(2131438958);
      this.jdField_a_of_type_Int = 6;
      g();
      return;
    }
    if (i == 1)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_Int == 5))
      {
        d();
        return;
      }
      b(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    a();
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    ThreadManager.post(new kvd(this, paramContext), 2, null, false);
  }
  
  private void d(Context paramContext)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
        if (!this.jdField_c_of_type_Boolean) {
          break label229;
        }
      }
    }
    label229:
    for (RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_e_of_type_Int, (int)(this.jdField_e_of_type_Int * 0.5626F));; localLayoutParams = new RelativeLayout.LayoutParams(-1, -1))
    {
      localLayoutParams.addRule(13, -1);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new kvg(this));
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_Kvk);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kvh(this), 3000L);
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new kvi(this));
      a(false);
      return;
    }
  }
  
  private void h() {}
  
  public long a()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Timer", 2, "time = " + l1);
    }
    return l1;
  }
  
  public TVK_IMediaPlayer a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public void a()
  {
    if ((PublicAccountAdvertisementActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)) && (!((PublicAccountAdvertisementActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      this.jdField_d_of_type_Boolean = true;
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131428241, 2131438953, new kvj(this));
    }
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      h();
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      this.jdField_b_of_type_Boolean = true;
      d(paramContext);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    c(paramContext);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverView", 2, "stopVideo mVideoPlayer.isPlaying() =" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_Int = 6;
      g();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void b(Context paramContext)
  {
    boolean bool2;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        bool2 = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, this.jdField_a_of_type_JavaLangString, "");
        Object localObject = new HashMap();
        ((Map)localObject).put("shouq_bus_type", "bus_type_pa_advertisement");
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(-1));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20170807));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("file_dir", AdvertisementVideoPreloadManager.a());
        localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
        if (this.jdField_b_of_type_Int != 1) {
          break label497;
        }
        bool1 = true;
        ((TVK_IMediaPlayer)localObject).setLoopback(bool1);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
        if (!bool2) {
          break label502;
        }
        localObject = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, (String)localObject, 0L, 0L);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverView", 2, "playVideo,openMediaPlayer with LocalCache = " + (String)localObject);
        }
        label245:
        this.jdField_a_of_type_Int = 3;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverView", 2, "playVideo,isVideoMute =" + VideoCoverFragment.jdField_c_of_type_Boolean + " isCached " + bool2 + " mVideoSrc " + this.jdField_a_of_type_JavaLangString);
        }
        if (!VideoCoverFragment.jdField_c_of_type_Boolean) {
          break label544;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
        label326:
        g();
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        paramContext = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString;
        if (!bool2) {
          break label558;
        }
      }
    }
    label544:
    label558:
    for (int i = 1;; i = 0)
    {
      ReportController.b(null, "dc00898", "", paramContext, "0X8008F78", "0X8008F78", 0, 0, String.valueOf(i), "", this.jdField_a_of_type_JavaLangString, "");
      AdvertisementStatistics.a().a(this.jdField_a_of_type_JavaLangString, bool2);
      if (this.jdField_c_of_type_Int + 1 < this.jdField_b_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverView", 2, "start to preload next video,vid =" + ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int + 1)).b);
        }
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int + 1);
        }
      }
      return;
      label497:
      bool1 = false;
      break;
      label502:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(paramContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, "", 0L, 0L);
      if (!QLog.isColorLevel()) {
        break label245;
      }
      QLog.d("VideoCoverView", 2, "playVideo,openMediaPlayer with no LocalCache");
      break label245;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      break label326;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 5;
      g();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if ((!VideoCoverFragment.jdField_b_of_type_Boolean) || (VideoCoverFragment.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Int = 4;
        g();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      }
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      if (this.jdField_b_of_type_Int == 1) {
        PublicAccountAdvertisementActivity.a = System.currentTimeMillis();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.d();
    e();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
  }
  
  public void g()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new kuz(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "updateView mVideoState=" + this.jdField_a_of_type_Int);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView
 * JD-Core Version:    0.7.0.1
 */