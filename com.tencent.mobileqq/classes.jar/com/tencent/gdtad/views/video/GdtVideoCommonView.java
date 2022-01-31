package com.tencent.gdtad.views.video;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasMutiVideoManager;
import com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.lang.ref.WeakReference;
import java.net.URL;
import qmu;
import qmv;
import qmx;
import qmy;
import qmz;
import qna;
import qnb;
import qnc;
import qnd;
import qne;
import qnf;
import qnh;

public class GdtVideoCommonView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, GdtCanvasVideoListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ResizeURLImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private GdtCanvasMutiVideoManager jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager;
  private GdtVideoCommonView.LoadListener jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener;
  private GdtVideoCommonView.VideoFullScreenListener jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener;
  private GdtVideoData jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qnc(this);
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable = new qmz(this);
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private qne jdField_a_of_type_Qne;
  private qnf jdField_a_of_type_Qnf;
  private qnh jdField_a_of_type_Qnh;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10000;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new qna(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new qnb(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int k;
  
  public GdtVideoCommonView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2130969004, this);
    i();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2130969004, this);
    i();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    GdtLog.a("GdtVideoCommonView", "setStateOfMediaSound volume =" + paramInt + " viewReusmed " + paramBoolean);
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        if (paramInt <= 0) {
          break;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130839227);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      } while (!AppSetting.jdField_b_of_type_Boolean);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription("关闭视频声音");
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130839226);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
    } while (!AppSetting.jdField_b_of_type_Boolean);
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription("打开视频声音");
  }
  
  private void a(long paramLong)
  {
    GdtLog.a("GdtVideoCommonView", "playVideo startElapsed -->" + paramLong + "|" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (this.jdField_a_of_type_Int != 3))
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getUrl(), paramLong, 0L);
      if (this.jdField_a_of_type_Int == 8) {
        GdtLog.a("GdtVideoCommonView", "playVideo STATE_ERROR return -->" + paramLong);
      }
    }
    else
    {
      return;
    }
    d();
  }
  
  private void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      c(paramContext);
      return;
    }
    b(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    GdtLog.a("GdtVideoCommonView", "letsShowOff " + paramBoolean + " " + this.jdField_a_of_type_JavaLangString + " mVideoState " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      TVK_SDKMgr.installPlugin(paramContext, new qmv(this, paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      GdtLog.a("GdtVideoCommonView", "installSDK t==" + paramContext.toString() + " " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Int == 5);
  }
  
  private void c(Context paramContext)
  {
    GdtLog.a("GdtVideoCommonView", "initVideo " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_c_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        addView(this.jdField_c_of_type_AndroidViewView, 0);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)this.jdField_c_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
        if (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) {
          break label211;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3), true);
      a(this.jdField_b_of_type_Long);
      return;
      label211:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(false);
    }
  }
  
  private void i()
  {
    if (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      GdtLog.a("GdtVideoCommonView", "netType " + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)findViewById(2131364669));
      this.jdField_d_of_type_AndroidViewView = findViewById(2131362951);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131364671);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131364670);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364677));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364673));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364672));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364678));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131364679));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364680));
      int m = GdtUIUtils.a(5.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364681));
      GdtUIUtils.a(this.jdField_d_of_type_AndroidWidgetImageView, m, m, m, m);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364682));
      GdtUIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, m, m, m, m);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362868));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131364674);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364675));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131364676);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getContext().getSystemService("audio"));
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setVolumeControlStream(3);
      this.jdField_a_of_type_Qnf = new qnf(this, new Handler());
      getContext().getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.jdField_a_of_type_Qnf);
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_Qne = new qne(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Qne, localIntentFilter);
      c();
      return;
      if (NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
        this.jdField_c_of_type_Int = 2;
      }
    }
  }
  
  private void j()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || ((localObject instanceof QQAppInterface)) || (AppSetting.jdField_b_of_type_Boolean)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = (AccessibilityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          AppSetting.jdField_b_of_type_Boolean = bool1;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private void k()
  {
    this.jdField_c_of_type_Boolean = true;
    p();
    if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 4))
    {
      a(2, this.jdField_e_of_type_Boolean, false);
      return;
    }
    a(this.jdField_b_of_type_Long);
  }
  
  private void l()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new qmy(this));
      return;
    }
    GdtLog.a("GdtVideoCommonView", "doStartPlay " + this.jdField_a_of_type_JavaLangString);
    v();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    this.jdField_a_of_type_Int = 5;
    d();
  }
  
  private void m()
  {
    if (b())
    {
      GdtLog.a("GdtVideoCommonView", "pauseVideoInternal " + this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 6;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      d();
      return;
    }
    GdtLog.a("GdtVideoCommonView", "pauseVideoInternal return " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void n()
  {
    GdtLog.a("GdtVideoCommonView", "resumeVideByNet netType " + this.jdField_c_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      FMToastUtil.a(2131438958);
      this.jdField_a_of_type_Int = 8;
      d();
      return;
    case 1: 
      l();
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      l();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void p()
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.jdField_a_of_type_AndroidViewView = this;
    }
  }
  
  private void q()
  {
    long l = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.isLoop()) || (!this.jdField_e_of_type_Boolean)) {
      return;
    }
    if (Math.abs(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() - l) < 1000L) {
      if (!this.jdField_j_of_type_Boolean) {
        u();
      }
    }
    for (this.jdField_j_of_type_Boolean = true;; this.jdField_j_of_type_Boolean = false)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new qnd(this), 300L);
      return;
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Qnh != null) {
      this.jdField_a_of_type_Qnh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Qnh != null)
    {
      if (this.jdField_d_of_type_Int <= 0) {
        break label40;
      }
      this.jdField_a_of_type_Qnh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      q();
      return;
      label40:
      this.jdField_a_of_type_Qnh.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Qnh != null) {
      this.jdField_a_of_type_Qnh.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Qnh != null) {
      this.jdField_a_of_type_Qnh.b(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
      }
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.a(this.jdField_a_of_type_JavaLangRefWeakReference);
      GdtLog.a("GdtVideoCommonView", "playBindController " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a()
  {
    GdtLog.c("GdtVideoCommonView", "play from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    f();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" doResumeVideo " + paramInt);
    localStringBuilder.append(" isViewResume " + paramBoolean1);
    localStringBuilder.append(" stopPlayByUser " + paramBoolean2);
    localStringBuilder.append(" mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    GdtLog.a("GdtVideoCommonView", localStringBuilder.toString());
    if ((paramBoolean2) || (!paramBoolean1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager != null) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.jdField_a_of_type_AndroidViewView != this))
    {
      GdtLog.a("GdtVideoCommonView", "returned FocusedVideo " + this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.jdField_a_of_type_AndroidViewView + "!=this " + hashCode());
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    default: 
      return;
    }
    n();
  }
  
  public boolean a()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void b()
  {
    GdtLog.c("GdtVideoCommonView", "pause from OUT_CONTROL " + this.jdField_a_of_type_JavaLangString);
    e();
  }
  
  public void c()
  {
    j();
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("点击播放视频");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription("拖动视频");
    }
  }
  
  public void d()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new qmu(this));
      return;
    }
    GdtLog.a("GdtVideoCommonView", "updateView " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("暂停播放");
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      o();
      return;
    case 3: 
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      o();
      return;
    case 5: 
      this.jdField_d_of_type_Boolean = false;
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      o();
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
      s();
      return;
    case 8: 
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      o();
      r();
      return;
    case 7: 
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      o();
      u();
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      o();
      t();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setVisibility(0);
    }
  }
  
  public void e()
  {
    GdtLog.a("GdtVideoCommonView", "pauseVideo " + this.jdField_a_of_type_JavaLangString);
    this.jdField_e_of_type_Boolean = false;
    m();
  }
  
  public void f()
  {
    GdtLog.a("GdtVideoCommonView", "resumeVideo " + this.jdField_a_of_type_JavaLangString);
    p();
    a(1, this.jdField_e_of_type_Boolean, this.jdField_d_of_type_Boolean);
    if (this.jdField_h_of_type_Boolean) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
  }
  
  public void g()
  {
    GdtLog.a("GdtVideoCommonView", "releaseMediaPlayer");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void h()
  {
    GdtLog.a("GdtVideoCommonView", "onDestroy");
    g();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Qnf != null) {
      getContext().getApplicationContext().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_Qnf);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Qne != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Qne);
    }
    if (this.jdField_a_of_type_Qnh != null) {
      this.jdField_a_of_type_Qnh = null;
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_d_of_type_Long < 350L) {
      GdtLog.a("GdtVideoCommonView", "onClick too fast not allowed  " + this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_Long = l;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131362868: 
          GdtLog.a("GdtVideoCommonView", "onClick  closeBtn exitFullScreen " + this.jdField_h_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
        }
      } while (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener == null);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener.h();
      return;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        a(false);
        return;
      }
      a(true);
      return;
      GdtLog.a("GdtVideoCommonView", "onClick  gdt_video_center_stop mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
      k();
      return;
      GdtLog.a("GdtVideoCommonView", "onClick  gdt_video_center_pause mVideoState " + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = true;
      m();
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute())
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
        a(1, true);
        return;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
      a(0, true);
      return;
      a(this.jdField_b_of_type_Long);
      return;
    } while (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener == null);
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener.h();
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener.i();
    return;
    k();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Int = 7;
    d();
    GdtLog.a("GdtVideoCommonView", "onCompletion" + this.jdField_a_of_type_Int);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    GdtLog.a("GdtVideoCommonView", "onError errorType " + paramInt1 + " errorCode " + paramInt2);
    this.jdField_a_of_type_Int = 8;
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener.b(false);
    }
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, "出错了~", 0).show();
    d();
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    this.jdField_c_of_type_Long = paramTVK_NetVideoInfo.getFileSize();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    GdtLog.a("GdtVideoCommonView", "onNetVideoInfo size:" + this.jdField_c_of_type_Long + " hasShowTips " + this.jdField_i_of_type_Boolean);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(GdtUIUtils.a(paramInt * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    GdtLog.a("GdtVideoCommonView", "onStartTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    GdtLog.a("GdtVideoCommonView", "onStopTrackingTouch " + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Int = ((int)(paramSeekBar.getProgress() * this.jdField_a_of_type_Long / this.jdField_b_of_type_Int));
    p();
    if ((this.jdField_a_of_type_Int < 4) || (this.jdField_a_of_type_Int > 6))
    {
      a(this.jdField_d_of_type_Int);
      return;
    }
    if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 4))
    {
      if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6)) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      }
      v();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Int = 5;
      d();
      return;
    }
    GdtLog.a("GdtVideoCommonView", "onStopTrackingTouch no answer " + this.jdField_a_of_type_Int);
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    GdtLog.a("GdtVideoCommonView", "onVideoPrepared " + this.jdField_a_of_type_Int + " isViewResume " + this.jdField_e_of_type_Boolean + " " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener != null) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener.b(true);
    }
    if (this.jdField_a_of_type_Long < 0L)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getDurationMillis() <= 0L) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setDurationMillis(this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new qmx(this));
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    }
    this.jdField_a_of_type_Int = 4;
    a(3, this.jdField_e_of_type_Boolean, this.jdField_d_of_type_Boolean);
  }
  
  public void setData(GdtVideoData paramGdtVideoData, GdtCanvasMutiVideoManager paramGdtCanvasMutiVideoManager)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager = paramGdtCanvasMutiVideoManager;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = paramGdtVideoData;
    this.jdField_b_of_type_Long = paramGdtVideoData.getStartPositionMillis();
    a(this.jdField_a_of_type_AndroidContentContext);
    if (!TextUtils.isEmpty(paramGdtVideoData.getCoverUrl())) {}
    try
    {
      paramGdtVideoData = new URL(paramGdtVideoData.getCoverUrl());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.a(paramGdtVideoData);
      this.jdField_a_of_type_Qnh = new qnh(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.getPlayScene());
      return;
    }
    catch (Exception paramGdtVideoData)
    {
      for (;;)
      {
        paramGdtVideoData.printStackTrace();
      }
    }
  }
  
  public void setGdtVideoCloseIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
  }
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(GdtVideoCommonView.LoadListener paramLoadListener)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$LoadListener = paramLoadListener;
  }
  
  public void setOnVideoFullScreen(GdtVideoCommonView.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$VideoFullScreenListener = paramVideoFullScreenListener;
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_h_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label215;
      }
      localObject1 = (Activity)getContext();
      localObject2 = ((Activity)localObject1).getWindow();
      ((Window)localObject2).setFlags(1024, 1024);
      ((Activity)localObject1).setRequestedOrientation(0);
      localObject2 = ((Window)localObject2).getDecorView();
      this.jdField_g_of_type_Int = ((View)localObject2).getSystemUiVisibility();
      ((View)localObject2).setSystemUiVisibility(3846);
      localObject2 = getLayoutParams();
      this.jdField_e_of_type_Int = ((ViewGroup.LayoutParams)localObject2).width;
      this.jdField_f_of_type_Int = ((ViewGroup.LayoutParams)localObject2).height;
      localObject1 = GdtUIUtils.a((Activity)localObject1);
      int m = localObject1[0];
      ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
      ((ViewGroup.LayoutParams)localObject2).height = m;
      setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setGdtVideoFcIcon(2130839766);
      setGdtVideoCloseIcon(paramInt);
      localObject1 = getParent();
      if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
      {
        localObject1 = (ViewGroup)localObject1;
        this.jdField_h_of_type_Int = ((ViewGroup)localObject1).getPaddingTop();
        this.jdField_i_of_type_Int = ((ViewGroup)localObject1).getPaddingBottom();
        this.jdField_j_of_type_Int = ((ViewGroup)localObject1).getPaddingLeft();
        this.k = ((ViewGroup)localObject1).getPaddingRight();
        ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
      }
    }
    return;
    label215:
    Object localObject1 = (Activity)getContext();
    ((Activity)localObject1).getWindow().setFlags(1024, 8);
    ((Activity)localObject1).setRequestedOrientation(1);
    ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.jdField_g_of_type_Int);
    localObject1 = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = this.jdField_e_of_type_Int;
    ((ViewGroup.LayoutParams)localObject1).height = this.jdField_f_of_type_Int;
    Object localObject2 = getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
      ((ViewGroup)localObject2).setPadding(this.jdField_j_of_type_Int, this.jdField_h_of_type_Int, this.k, this.jdField_i_of_type_Int);
    }
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
    setGdtVideoFcIcon(2130839765);
    setGdtVideoCloseIcon(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */