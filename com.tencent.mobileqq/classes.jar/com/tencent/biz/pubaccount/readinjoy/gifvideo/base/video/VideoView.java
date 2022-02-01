package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import bgnt;
import bmqa;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import oat;
import och;
import org.json.JSONException;
import org.json.JSONObject;
import pgk;
import psr;
import pss;
import psu;
import psy;
import psz;
import pta;
import ptb;
import ptc;
import ptd;
import pte;
import ptf;
import ptg;
import pth;
import pti;
import ptl;
import ptm;
import pto;
import sfa;
import sjz;
import ska;

public class VideoView
  extends FrameLayout
  implements Runnable
{
  public static int AUTO_PLAYMODE_ALLPLAY = 0;
  public static int AUTO_PLAYMODE_WIFI_ONLY = 1;
  public static int PLAYMODE_AUTO = 1;
  public static int PLAYMODE_CLICK = 2;
  public static int PLAYMODE_DISABLE = 3;
  public static int PLAYMODE_SCROOL = 0;
  private static final String REPORT_PLAY_DURATION_ACTION_NAME = "0X8007408";
  private static final String TAG = "gifvideo.VideoView";
  private static Drawable mLoadingDrawable;
  private int autoPlayMode = AUTO_PLAYMODE_ALLPLAY;
  private long channelId;
  private String dtPgid;
  private long fileSize;
  private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ptc(this);
  private Runnable hideCoverRunnable = new VideoView.11(this);
  private int iconHeight;
  private int iconWidth;
  private boolean isLoop = true;
  private boolean isMute = true;
  private boolean isPlayIconVisible;
  public int[] lastLocation = new int[2];
  private AtomicInteger mAction = new AtomicInteger(0);
  private int mBusiType;
  private Context mContext;
  private NativeReadInjoyImageView mCoverImageView;
  private String mCoverUrl;
  private TVK_IProxyFactory mFactory;
  private pth mOnCheckShownListener;
  private pti mOnProgressChangedListener;
  private String mPlayIconUrl;
  private NativeReadInjoyImageView mPlayImageView;
  public Handler mProgressHandler = new Handler(Looper.getMainLooper());
  private AtomicInteger mState = new AtomicInteger(0);
  private ptl mStrategy;
  private String mVid;
  private TVK_IMediaPlayer mVideoPlayer;
  private String mVideoUrl;
  private IVideoViewBase mVideoView;
  public boolean needInterceptGlobalLayoutChanged;
  private psu onVideoPluginInstallListener = new psy(this);
  private String openingUrl = "";
  private String pUin;
  private ObjectAnimator playCoverAnimator;
  private ObjectAnimator playIconAnimator;
  private int playMode = PLAYMODE_SCROOL;
  private String playSessionId;
  private String preparedUrl = "";
  private List<String> reportList = new ArrayList();
  private String reportR5;
  private Runnable reportRunnable = new VideoView.12(this);
  private String rowKey;
  private long startTime;
  private boolean useVid = true;
  private psr videoPlayListener;
  private int xyaxis = 0;
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void changeState(int paramInt)
  {
    QLog.d("gifvideo.VideoView", 2, getTag() + " change state from " + this.mState.get() + " to " + paramInt);
    this.mState.set(paramInt);
  }
  
  private void commonOptimizeConfig(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (paramTVK_PlayerVideoInfo != null)
    {
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bmqa.b()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bmqa.q()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bmqa.r()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bmqa.e()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bmqa.f()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bmqa.c()));
    }
  }
  
  private IVideoViewBase createVideoView()
  {
    if (VersionUtils.isIceScreamSandwich()) {
      return this.mFactory.createVideoView_Scroll(this.mContext);
    }
    return this.mFactory.createVideoView(this.mContext);
  }
  
  private void disPlayCoverAndDoStop()
  {
    try
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " stopPlay");
      this.preparedUrl = "";
      this.openingUrl = "";
      if (getCurrentState() != 10) {
        reportDtVideoEnd();
      }
      displayCover();
      doStop();
      reportPlayDurtion();
      return;
    }
    finally {}
  }
  
  private void doDestroy()
  {
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.hideCoverRunnable);
      removeAutoPlayObserver();
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.release();
      }
      this.mAction.set(6);
      changeState(0);
      this.mVideoPlayer = null;
      this.mVideoView = null;
      this.mFactory = null;
      this.openingUrl = "";
      this.preparedUrl = "";
      this.mVideoUrl = "";
      this.mCoverUrl = "";
      this.videoPlayListener = null;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.reportRunnable);
      return;
    }
    finally {}
  }
  
  private void doIfInited()
  {
    for (;;)
    {
      try
      {
        if (this.mVideoPlayer == null) {
          break label70;
        }
        int i = this.mAction.get();
        switch (i)
        {
        case 4: 
        case 5: 
        default: 
          return;
        }
      }
      finally {}
      doStart();
      continue;
      doDestroy();
      continue;
      label70:
      QLog.d("gifvideo.VideoView", 1, "video player is null");
      changeState(-1);
    }
  }
  
  private void doIfInstalled()
  {
    switch (this.mAction.get())
    {
    default: 
      return;
    }
    doInit();
  }
  
  /* Error */
  private void doIfPrepared()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 340	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 132	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:mAction	Ljava/util/concurrent/atomic/AtomicInteger;
    //   13: invokevirtual 362	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   16: istore_1
    //   17: iload_1
    //   18: tableswitch	default:+18 -> 36, 3:+21->39
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: invokespecial 496	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:playVideo	()V
    //   43: goto -7 -> 36
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	VideoView
    //   16	2	1	i	int
    //   46	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	46	finally
    //   39	43	46	finally
  }
  
  private void doInit()
  {
    if (this.mVideoPlayer == null) {
      try
      {
        if (this.mVideoPlayer == null)
        {
          if (!pss.a()) {
            break label46;
          }
          changeState(3);
          initVideoPlayer(new VideoView.2(this));
          initAutoPlayObserver();
        }
        for (;;)
        {
          return;
          label46:
          doInstall();
        }
        changeState(4);
      }
      finally {}
    }
    doIfInited();
  }
  
  private void doInstall()
  {
    if (!pss.a())
    {
      QLog.d("gifvideo.VideoView", 1, "not installed, now install");
      changeState(1);
      if (!pss.a(this.onVideoPluginInstallListener)) {
        pss.a(this.onVideoPluginInstallListener);
      }
      pss.a();
      return;
    }
    changeState(2);
    doIfInstalled();
  }
  
  private void doPause()
  {
    if (this.mVideoPlayer != null)
    {
      if (this.mState.get() != 8) {
        this.mVideoPlayer.pause();
      }
      changeState(8);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
    changeState(-1);
  }
  
  private void doStart()
  {
    initVideoPlayerProperties(true);
  }
  
  private void doStop()
  {
    if (this.mVideoPlayer != null)
    {
      if (getCurrentState() != 9)
      {
        if (this.videoPlayListener != null) {
          this.videoPlayListener.b();
        }
        this.mVideoPlayer.stop();
        resetVideoView();
        changeState(9);
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
    changeState(-1);
  }
  
  private static Drawable getLoadingDrawable()
  {
    if (mLoadingDrawable == null) {
      mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850667);
    }
    return mLoadingDrawable;
  }
  
  private void hideCoverAnim()
  {
    if (this.mCoverImageView != null)
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " hidecover alpha: " + this.mCoverImageView.getAlpha());
      if (this.playIconAnimator == null)
      {
        this.playIconAnimator = ObjectAnimator.ofFloat(this.mCoverImageView, "alpha", new float[] { 1.0F, 0.0F });
        this.playIconAnimator.setDuration(300L);
        this.playIconAnimator.addListener(new pta(this));
      }
      if (this.playCoverAnimator == null)
      {
        this.playCoverAnimator = this.playIconAnimator.clone();
        this.playCoverAnimator.setTarget(this.mPlayImageView);
      }
      this.playIconAnimator.start();
      this.playCoverAnimator.start();
    }
  }
  
  private void init()
  {
    setTag(Integer.valueOf(new Random().nextInt()));
    this.mContext = getContext();
    doInit();
  }
  
  private void initAutoPlayObserver()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
      localViewTreeObserver.addOnGlobalLayoutListener(this.globalLayoutListener);
    }
  }
  
  private void initVideoPlayer(Runnable paramRunnable)
  {
    ThreadManager.post(new VideoView.4(this, paramRunnable), 10, null, false);
  }
  
  private void initVideoPlayerListeners()
  {
    if (this.mVideoPlayer != null)
    {
      this.mVideoPlayer.setOnVideoPreparedListener(new ptd(this));
      this.mVideoPlayer.setOnCompletionListener(new pte(this));
      this.mVideoPlayer.setOnSeekCompleteListener(new ptf(this));
      this.mVideoPlayer.setOnDownloadCallback(new ptg(this));
      this.mVideoPlayer.setOnErrorListener(new psz(this));
    }
  }
  
  private void initVideoPlayerProperties(boolean paramBoolean)
  {
    if (this.mVideoPlayer != null)
    {
      this.mVideoPlayer.setOutputMute(this.isMute);
      this.mVideoPlayer.setLoopback(this.isLoop);
      ThreadManager.getUIHandler().post(new VideoView.5(this, paramBoolean));
    }
  }
  
  private void initViews()
  {
    removeAllViews();
    setBackgroundColor(Color.parseColor("#000000"));
    if ((this.mVideoView != null) && (this.mVideoPlayer != null))
    {
      ((View)this.mVideoView).setBackgroundColor(Color.parseColor("#000000"));
      addView((View)this.mVideoView, -1, -1);
    }
    this.mCoverImageView = new NativeReadInjoyImageView(this.mContext);
    this.mCoverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.mCoverImageView, -1, -1);
    setVideoCover();
    this.mPlayImageView = new NativeReadInjoyImageView(this.mContext);
    this.mPlayImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    if (this.iconWidth != 0) {
      ((FrameLayout.LayoutParams)localObject).width = this.iconWidth;
    }
    if (this.iconHeight != 0) {
      ((FrameLayout.LayoutParams)localObject).height = this.iconHeight;
    }
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.mPlayImageView, (ViewGroup.LayoutParams)localObject);
    localObject = this.mPlayImageView;
    if (this.isPlayIconVisible) {}
    for (int i = 0;; i = 4)
    {
      ((NativeReadInjoyImageView)localObject).setVisibility(i);
      setPlayIcon();
      return;
    }
  }
  
  private boolean isValidState()
  {
    if ((this.mVideoPlayer == null) || (this.mVideoPlayer.getDuration() < 200L)) {}
    while ((this.mAction.get() == 5) || (this.mAction.get() == 4)) {
      return false;
    }
    return true;
  }
  
  private void playVideo()
  {
    if (this.mVideoPlayer != null)
    {
      if (this.mState.get() != 7)
      {
        reportLoadTime();
        changeState(7);
        this.mVideoPlayer.start();
        if (this.videoPlayListener != null) {
          this.videoPlayListener.a();
        }
        if (this.mCoverImageView.getVisibility() == 0) {
          hideCover();
        }
        reportDt();
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "video player is null");
    changeState(-1);
  }
  
  private void removeAutoPlayObserver()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.globalLayoutListener);
    }
  }
  
  private void reportDt()
  {
    if (!TextUtils.isEmpty(this.dtPgid))
    {
      if (this.isLoop) {
        ThreadManager.getSubThreadHandler().postDelayed(this.reportRunnable, 100L);
      }
    }
    else {
      return;
    }
    reportDtVideoStart();
  }
  
  private void reportDtVideoEnd()
  {
    if ((this.mVideoPlayer != null) && (this.mVideoView != null) && (this.playSessionId != null) && (!TextUtils.isEmpty(this.dtPgid)))
    {
      long l2 = this.mVideoPlayer.getCurrentPostion();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = this.mVideoPlayer.getDuration();
      }
      sjz.a(ska.a((VideoInfo)null).b(this.dtPgid).d(this.channelId).c(this.rowKey).d(this.pUin).e(this.mVideoPlayer.getDuration()).e(this.playSessionId).a(1).b(System.currentTimeMillis()).d(this.mVideoView.getViewWidth()).e(this.mVideoView.getViewHeight()).c(l1).a("dt_vdend"));
      this.playSessionId = null;
    }
  }
  
  private void reportDtVideoStart()
  {
    if ((this.mVideoPlayer != null) && (this.mVideoView != null) && (!TextUtils.isEmpty(this.dtPgid)))
    {
      this.playSessionId = och.b();
      sjz.a(ska.a((VideoInfo)null).b(this.dtPgid).d(this.channelId).c(this.rowKey).d(this.pUin).e(this.mVideoPlayer.getDuration()).e(this.playSessionId).a(1).a(System.currentTimeMillis()).d(this.mVideoView.getViewWidth()).e(this.mVideoView.getViewHeight()).a("dt_vdstart"));
    }
  }
  
  private void reportLoadTime()
  {
    if ((this.mCoverImageView.getVisibility() == 0) && (!this.reportList.contains(this.mVideoUrl)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.startTime;
      oat.a(null, "", "0X800A587", "0X800A587", 0, 0, this.fileSize + "", "", l1 - l2 + "", "", false);
      if (!TextUtils.isEmpty(this.mVideoUrl)) {
        this.reportList.add(this.mVideoUrl);
      }
    }
  }
  
  private void reportPlayDurtion()
  {
    long l1;
    long l2;
    if (!TextUtils.isEmpty(this.reportR5))
    {
      l1 = System.currentTimeMillis();
      l2 = this.startTime;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.reportR5);
      localJSONObject.put("playduration", l1 - l2);
      oat.a(null, "", "0X8007408", "0X8007408", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("gifvideo.VideoView", 1, localJSONException.getMessage());
    }
  }
  
  private void resetVideoView()
  {
    ThreadManager.getUIHandler().post(new VideoView.14(this));
  }
  
  private void selectUrlByVid()
  {
    if ((this.mBusiType == 2) || (this.mBusiType == 6)) {
      requestUrlByVid(pto.a(), new ptb(this));
    }
    while (!this.useVid) {
      return;
    }
    openVideoByVid(this.mVid);
  }
  
  private void setPlayIcon()
  {
    if ((this.mPlayImageView != null) && (!TextUtils.isEmpty(this.mPlayIconUrl))) {}
    try
    {
      this.mPlayImageView.setImagePlaceHolder(getLoadingDrawable()).setImage(new URL(this.mPlayIconUrl));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void setVideoCover()
  {
    if ((this.mCoverImageView != null) && (!TextUtils.isEmpty(this.mCoverUrl))) {}
    try
    {
      pgk.a(this.mCoverImageView, new URL(this.mCoverUrl), this.mContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean shouldPlay()
  {
    QLog.d("gifvideo.VideoView", 1, "auto play mode: " + this.autoPlayMode);
    return (this.autoPlayMode != AUTO_PLAYMODE_WIFI_ONLY) || (bgnt.b(BaseApplication.getContext()) == 1);
  }
  
  public void destroy()
  {
    QLog.d("gifvideo.VideoView", 1, "destroy");
    doDestroy();
  }
  
  public void displayCover()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.hideCoverRunnable);
    ThreadManager.getUIHandler().post(new VideoView.19(this));
  }
  
  public int getAction()
  {
    return this.mAction.get();
  }
  
  public int getCurrentState()
  {
    return this.mState.get();
  }
  
  public long getPercentage()
  {
    if (this.mVideoPlayer != null) {
      return this.mVideoPlayer.getPlayedTime();
    }
    return 0L;
  }
  
  public int getPlayMode()
  {
    return this.playMode;
  }
  
  public TVK_IMediaPlayer getVideoPlayer()
  {
    return this.mVideoPlayer;
  }
  
  public String getVideoUrl()
  {
    return this.mVideoUrl;
  }
  
  public String getVideoVid()
  {
    return this.mVid;
  }
  
  public void hideCover()
  {
    ThreadManager.getUIHandler().post(this.hideCoverRunnable);
  }
  
  public boolean isIDLE()
  {
    return getCurrentState() == 0;
  }
  
  public boolean isInited()
  {
    return getCurrentState() >= 4;
  }
  
  public boolean isMute()
  {
    return this.isMute;
  }
  
  public boolean isPlaying()
  {
    return getCurrentState() == 7;
  }
  
  public boolean isShown()
  {
    if (this.mOnCheckShownListener != null) {
      return (super.isShown()) && (this.mOnCheckShownListener.a());
    }
    return super.isShown();
  }
  
  public boolean isStop()
  {
    return getCurrentState() == 9;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.d("gifvideo.VideoView", 1, "detachedFromWindow");
    destroy();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    setVideoCover();
    setPlayIcon();
  }
  
  public void onScrollFromList(boolean paramBoolean)
  {
    if (this.playMode == PLAYMODE_AUTO)
    {
      if ((paramBoolean) && (this.mAction.get() != 3)) {
        startPlay();
      }
      if ((!paramBoolean) && (this.mAction.get() != 5)) {
        stop();
      }
    }
  }
  
  public void openVideo()
  {
    ThreadManager.post(new VideoView.17(this), 10, null, false);
  }
  
  public void openVideoByUrl(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", sfa.a);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    commonOptimizeConfig(localTVK_PlayerVideoInfo);
    if (this.mVideoPlayer != null)
    {
      QLog.d("gifvideo.VideoView", 2, getTag() + " opening " + getVideoVid() + " " + paramString);
      changeState(5);
      this.mVideoPlayer.openMediaPlayerByUrl(getContext(), new String[] { paramString }, 0L, 0L, localTVK_PlayerVideoInfo, null);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
  }
  
  public void openVideoByVid(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, paramString, "");
    localTVK_PlayerVideoInfo.setPreLoad(false);
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", sfa.a);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    if ((this.mContext != null) && (this.mVideoPlayer != null))
    {
      QLog.d("gifvideo.VideoView", 2, getTag() + " opening " + paramString);
      changeState(5);
      this.mVideoPlayer.openMediaPlayer(this.mContext, null, localTVK_PlayerVideoInfo, paramString, 0L, 0L);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
  }
  
  public void pause()
  {
    QLog.d("gifvideo.VideoView", 2, "pause");
    if ((this.mVideoPlayer != null) && (this.mState.get() == 7))
    {
      this.mAction.set(4);
      changeState(8);
      this.mVideoPlayer.pause();
      reportDtVideoEnd();
    }
  }
  
  public void requestUrlByVid(ptl paramptl, ptm paramptm)
  {
    this.mStrategy = paramptl;
    if (this.mStrategy != null) {
      this.mStrategy.a(this.mVid, paramptm);
    }
  }
  
  public void resume()
  {
    if (this.mVideoPlayer != null)
    {
      this.mVideoPlayer.start();
      reportDtVideoStart();
    }
  }
  
  public void run()
  {
    long l2;
    if ((this.mVideoPlayer != null) && (this.mOnProgressChangedListener != null))
    {
      this.mProgressHandler.postDelayed(this, 500L);
      l2 = 0L;
    }
    try
    {
      l1 = this.mVideoPlayer.getCurrentPostion();
      this.mOnProgressChangedListener.a(l1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("gifvideo.VideoView", 2, "run: " + QLog.getStackTraceString(localException));
          l1 = l2;
        }
      }
    }
  }
  
  public void setAutoPlayMode(int paramInt)
  {
    this.autoPlayMode = paramInt;
  }
  
  public void setChannelId(long paramLong)
  {
    this.channelId = paramLong;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    setVideoCover();
  }
  
  public void setDtPgid(String paramString)
  {
    this.dtPgid = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.isLoop = paramBoolean;
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setLoopback(this.isLoop);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.isMute = paramBoolean;
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void setOnCheckShownListener(pth parampth)
  {
    this.mOnCheckShownListener = parampth;
  }
  
  public void setOnProgressChangedListener(pti parampti)
  {
    this.mOnProgressChangedListener = parampti;
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    this.iconWidth = Utils.dp2px(paramInt1);
    this.iconHeight = Utils.dp2px(paramInt2);
    if (this.mPlayImageView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mPlayImageView.getLayoutParams();
      localLayoutParams.width = this.iconWidth;
      localLayoutParams.height = this.iconHeight;
      this.mPlayImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.mPlayIconUrl = paramString;
    setPlayIcon();
  }
  
  public void setPlayIconVisible(boolean paramBoolean)
  {
    this.isPlayIconVisible = paramBoolean;
    NativeReadInjoyImageView localNativeReadInjoyImageView;
    if (this.mPlayImageView != null)
    {
      localNativeReadInjoyImageView = this.mPlayImageView;
      if (!this.isPlayIconVisible) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 4)
    {
      localNativeReadInjoyImageView.setVisibility(i);
      return;
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.playMode = paramInt;
  }
  
  public void setPuin(String paramString)
  {
    this.pUin = paramString;
  }
  
  public void setReportR5(String paramString)
  {
    this.reportR5 = paramString;
  }
  
  public void setRowKey(String paramString)
  {
    this.rowKey = paramString;
  }
  
  public void setScaleType(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.xyaxis = 0;
        if (this.mVideoPlayer != null) {
          this.mVideoPlayer.setXYaxis(this.xyaxis);
        }
        return;
      }
      finally {}
      this.xyaxis = 1;
      continue;
      this.xyaxis = 2;
    }
  }
  
  public void setUseVid(boolean paramBoolean)
  {
    this.useVid = paramBoolean;
  }
  
  public void setVideoBusiType(int paramInt)
  {
    this.mBusiType = paramInt;
  }
  
  public void setVideoPlayListener(psr parampsr)
  {
    this.videoPlayListener = parampsr;
  }
  
  public void setVideoUrl(String paramString)
  {
    this.mVideoUrl = paramString;
  }
  
  public void setVideoVid(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(this.mVid)) {
        stop();
      }
      this.mVid = paramString;
      return;
    }
    finally {}
  }
  
  public boolean startPlay()
  {
    QLog.d("gifvideo.VideoView", 2, getTag() + "receive startPlay");
    if (!shouldPlay())
    {
      QLog.d("gifvideo.VideoView", 1, "should not play");
      return false;
    }
    if ((TextUtils.isEmpty(this.mVid)) && (TextUtils.isEmpty(this.mVideoUrl)))
    {
      QLog.d("gifvideo.VideoView", 1, "vid or url is null, reture");
      return false;
    }
    if (!isInited())
    {
      QLog.d("gifvideo.VideoView", 2, "has not inited, init");
      this.mAction.set(3);
      init();
      return true;
    }
    if ((getCurrentState() == 7) || (this.mAction.get() == 3))
    {
      QLog.d("gifvideo.VideoView", 2, "isPlaying or has started " + getCurrentState() + " " + this.mAction.get());
      return true;
    }
    if (((!TextUtils.isEmpty(this.preparedUrl)) && (!this.preparedUrl.equals(this.mVideoUrl))) || (getVisibility() != 0))
    {
      QLog.d("gifvideo.VideoView", 2, "preparedUrl != mVideoUrl, " + this.preparedUrl + " " + this.mVideoUrl + " " + getVisibility());
      return false;
    }
    this.mAction.set(3);
    ThreadManager.post(new VideoView.15(this), 10, null, false);
    return true;
  }
  
  public void stop()
  {
    QLog.d("gifvideo.VideoView", 2, getTag() + " receive stop current action is " + this.mAction.get());
    if (!isInited())
    {
      QLog.d("gifvideo.VideoView", 2, "has not inited, return");
      return;
    }
    ThreadManager.post(new VideoView.16(this), 10, null, false);
    this.mProgressHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView
 * JD-Core Version:    0.7.0.1
 */