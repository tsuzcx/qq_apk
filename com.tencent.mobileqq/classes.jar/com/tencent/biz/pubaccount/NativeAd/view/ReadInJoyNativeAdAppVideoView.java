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
  private ReadInJoyNativeAdAppVideoView.VolumeChangedObserver A;
  private AudioManager B;
  private AdvertisementInfo C;
  private int D = 0;
  private int E = 0;
  private int F = 1;
  private int G = 0;
  private int H = 1;
  private int I = 1;
  private int J = 0;
  private AppInterface K;
  private boolean L = false;
  private boolean M = false;
  private long N = 0L;
  private NativeAdVideoSetting O;
  private ReadInJoyAdVideoGuide P;
  private FrameLayout Q;
  private ImageView R;
  private boolean S = false;
  private int T;
  private int U;
  private int V;
  private int W;
  private int Z;
  Runnable a = new ReadInJoyNativeAdAppVideoView.4(this);
  private int aa;
  private int ab;
  private Runnable ac = new ReadInJoyNativeAdAppVideoView.1(this);
  private INetInfoHandler ad = new ReadInJoyNativeAdAppVideoView.5(this);
  private ReadInJoyNativeAdAppVideoView.VideoFullScreenListener ae;
  Runnable b = new ReadInJoyNativeAdAppVideoView.6(this);
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private ResizeURLImageView j;
  private SeekBar k;
  private TextView l;
  private View m;
  private LinearLayout n;
  private RelativeLayout o;
  private Handler p;
  private int q;
  private TVK_IProxyFactory r;
  private TVK_IMediaPlayer s;
  private TVK_ICacheMgr t;
  private View u;
  private boolean v = false;
  private long w;
  private int x = 10000;
  private AdModuleVideo y;
  private Context z;
  
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
    int i1 = this.q;
    if ((i1 == 5) || (i1 == 4))
    {
      this.p.removeCallbacks(this.ac);
      if (paramBoolean)
      {
        this.n.setVisibility(0);
        this.f.setVisibility(0);
        this.p.postDelayed(this.ac, 3000L);
        return;
      }
      this.n.setVisibility(8);
      this.f.setVisibility(8);
    }
  }
  
  private void c(Context paramContext)
  {
    inflate(getContext(), 2131626099, this);
    this.p = new Handler(Looper.getMainLooper());
    this.z = paramContext;
    d();
    d(paramContext);
  }
  
  private void d()
  {
    this.c = ((ImageView)findViewById(2131430808));
    this.c.setOnClickListener(this);
    this.d = ((ImageView)findViewById(2131449983));
    this.d.setOnClickListener(this);
    this.d.setVisibility(8);
    this.e = ((ImageView)findViewById(2131449442));
    this.e.setOnClickListener(this);
    this.f = ((ImageView)findViewById(2131449441));
    this.f.setOnClickListener(this);
    this.h = ((TextView)findViewById(2131440664));
    this.i = ((TextView)findViewById(2131447787));
    this.k = ((SeekBar)findViewById(2131428510));
    this.k.setMax(this.x);
    this.j = ((ResizeURLImageView)findViewById(2131428505));
    this.l = ((TextView)findViewById(2131428506));
    this.l.setOnClickListener(this);
    this.m = findViewById(2131428509);
    this.m.setOnClickListener(this);
    this.n = ((LinearLayout)findViewById(2131428511));
    this.o = ((RelativeLayout)findViewById(2131449512));
    this.g = ((ImageView)findViewById(2131449447));
    this.Q = ((FrameLayout)findViewById(2131433908));
    this.R = ((ImageView)findViewById(2131433909));
    this.Q.setOnClickListener(this);
    this.P = ((ReadInJoyAdVideoGuide)findViewById(2131427698));
    this.P.setAdGuideClickListener(this);
  }
  
  private void d(Context paramContext)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(paramContext.getApplicationContext(), this.ad);
    this.B = ((AudioManager)getContext().getSystemService("audio"));
    this.A = new ReadInJoyNativeAdAppVideoView.VolumeChangedObserver(this, new Handler());
    getContext().getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A);
    this.k.setOnSeekBarChangeListener(this);
  }
  
  private void e()
  {
    NativeAdVideoSetting localNativeAdVideoSetting = this.O;
    if (localNativeAdVideoSetting != null)
    {
      if (localNativeAdVideoSetting.a) {
        this.c.setVisibility(0);
      } else {
        this.c.setVisibility(8);
      }
      if (this.O.b)
      {
        this.Q.setVisibility(0);
        return;
      }
      this.Q.setVisibility(8);
    }
  }
  
  private void e(Context paramContext)
  {
    this.q = 3;
    f();
    this.r = TVK_SDKMgr.getProxyFactory();
    Object localObject1 = this.r;
    if (localObject1 != null)
    {
      this.t = ((TVK_IProxyFactory)localObject1).getCacheMgr(paramContext);
      this.u = ((View)this.r.createVideoView_Scroll(paramContext));
      localObject1 = this.u;
      if (localObject1 != null)
      {
        ((View)localObject1).setBackgroundColor(-16777216);
        this.o.removeAllViews();
        this.o.addView(this.u, 0);
        localObject1 = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(this.y.p), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject2);
        this.s = this.r.createMediaPlayer(paramContext, (IVideoViewBase)this.u);
        this.s.setOnVideoPreparedListener(this);
        this.s.setOnErrorListener(this);
        this.s.setOnCompletionListener(this);
        localObject2 = this.O;
        boolean bool;
        if (localObject2 != null) {
          bool = ((NativeAdVideoSetting)localObject2).c;
        } else {
          bool = true;
        }
        this.s.setLoopback(bool);
        this.s.openMediaPlayerByUrl(paramContext, this.y.p, this.N, 0L, (TVK_UserInfo)localObject1, localTVK_PlayerVideoInfo);
        this.s.setOutputMute(false);
        this.p.post(this.a);
      }
    }
  }
  
  private void f()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.p.post(new ReadInJoyNativeAdAppVideoView.3(this));
      return;
    }
    Object localObject;
    switch (this.q)
    {
    default: 
      return;
    case 8: 
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.l.setVisibility(0);
      this.j.setVisibility(8);
      this.n.setVisibility(8);
      this.g.setVisibility(8);
      this.P.setVisibility(8);
      this.g.clearAnimation();
      return;
    case 7: 
      this.g.setVisibility(8);
      this.l.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.j.setVisibility(0);
      this.n.setVisibility(8);
      localObject = this.O;
      if ((localObject != null) && (((NativeAdVideoSetting)localObject).d))
      {
        g();
        return;
      }
      this.P.setVisibility(8);
      return;
    case 6: 
      this.g.setVisibility(8);
      this.g.clearAnimation();
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      this.l.setVisibility(8);
      this.j.setVisibility(8);
      this.n.setVisibility(0);
      this.P.setVisibility(8);
      this.E = ((int)this.s.getCurrentPostion());
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.K).a(getContext()).a(6).b(7).a(this.C).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(this.D, this.E, this.F, this.G, this.H, this.I, (int)this.w, 10, 0, this.J, ReportConstants.VideoEndType.CLICK_PAUSE)));
      this.H = 2;
      this.D = ((int)this.s.getCurrentPostion());
      this.F = 0;
      return;
    case 4: 
    case 5: 
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.l.setVisibility(8);
      this.j.setVisibility(8);
      this.n.setVisibility(8);
      this.g.setVisibility(8);
      this.P.setVisibility(8);
      this.g.clearAnimation();
      return;
    case 3: 
      this.g.setVisibility(0);
      this.g.clearAnimation();
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.l.setVisibility(8);
      this.j.setVisibility(0);
      this.n.setVisibility(8);
      this.P.setVisibility(8);
      localObject = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      ((RotateAnimation)localObject).setDuration(500L);
      ((RotateAnimation)localObject).setRepeatCount(-1);
      ((RotateAnimation)localObject).setRepeatMode(1);
      ((RotateAnimation)localObject).setStartTime(-1L);
      ((RotateAnimation)localObject).setInterpolator(new LinearInterpolator());
      this.g.startAnimation((Animation)localObject);
      return;
    }
    this.f.setVisibility(8);
    this.e.setVisibility(8);
    this.j.setVisibility(0);
    this.l.setVisibility(8);
    this.g.setVisibility(8);
    this.P.setVisibility(8);
    this.g.clearAnimation();
  }
  
  private void f(Context paramContext)
  {
    this.q = 1;
    ThreadManager.post(new ReadInJoyNativeAdAppVideoView.2(this, paramContext), 2, null, false);
  }
  
  private void g()
  {
    this.P.setVisibility(0);
  }
  
  private void h()
  {
    if (!NetworkUtil.isNetworkAvailable(this.z))
    {
      QQToast.makeText(this.z, 2131892102, 0).show();
      return;
    }
    if ((PublicFragmentActivity.class.isInstance(this.z)) && (!((PublicFragmentActivity)this.z).isFinishing())) {
      FMDialogUtil.a(this.z, 2131889584, 2131886194, new ReadInJoyNativeAdAppVideoView.7(this));
    }
  }
  
  private void i()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.s;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.s.release();
      this.s = null;
    }
    this.r = null;
    e(getContext());
    this.J += 1;
  }
  
  public void a()
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.ad;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    if (this.A != null) {
      getContext().getApplicationContext().getApplicationContext().getContentResolver().unregisterContentObserver(this.A);
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((TVK_IMediaPlayer)localObject).stop();
      this.s.release();
      this.s = null;
    }
    this.t = null;
    this.r = null;
  }
  
  public void a(Context paramContext)
  {
    if (!this.v)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.v = true;
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
      i();
      return;
    }
    ReadInJoyNativeAdAppVideoView.VideoFullScreenListener localVideoFullScreenListener = this.ae;
    if (localVideoFullScreenListener != null) {
      localVideoFullScreenListener.a(paramView, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt));
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.t;
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
      int i3 = localTVK_ICacheMgr.isVideoCached(this.z, paramString1, localTVK_UserInfo, localTVK_PlayerVideoInfo, str);
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
    if (this.q != 7)
    {
      TVK_IMediaPlayer localTVK_IMediaPlayer = this.s;
      if (localTVK_IMediaPlayer != null)
      {
        localTVK_IMediaPlayer.pause();
        this.q = 6;
        f();
        this.p.removeCallbacksAndMessages(null);
      }
    }
  }
  
  public void b(Context paramContext)
  {
    if (!NetworkUtil.isWifiConnected(paramContext)) {
      return;
    }
    if (this.q != 7)
    {
      paramContext = this.s;
      if (paramContext != null)
      {
        paramContext.start();
        this.q = 5;
        f();
        this.p.post(this.a);
      }
    }
  }
  
  public boolean c()
  {
    return this.S;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131449983: 
      paramView = this.s;
      if (paramView != null)
      {
        if (paramView.getOutputMute())
        {
          this.d.setImageResource(2130842579);
          this.s.setOutputMute(false);
          return;
        }
        this.d.setImageResource(2130842578);
        this.s.setOutputMute(true);
        return;
      }
      break;
    case 2131449442: 
      paramView = this.s;
      if ((paramView != null) && (paramView.isPauseing()))
      {
        if (NetworkUtil.isWifiConnected(this.z))
        {
          this.s.start();
          this.q = 4;
          f();
          this.p.post(this.a);
          this.I = 2;
          return;
        }
        h();
        return;
      }
      break;
    case 2131449441: 
      paramView = this.s;
      if ((paramView != null) && (paramView.isPlaying()))
      {
        this.s.pause();
        this.q = 6;
        f();
        return;
      }
      break;
    case 2131433908: 
      paramView = this.ae;
      if (paramView != null)
      {
        if (this.S)
        {
          paramView.d();
          return;
        }
        paramView.e();
        return;
      }
      break;
    case 2131430808: 
      if ((getContext() instanceof Activity))
      {
        ((Activity)getContext()).finish();
        return;
      }
      break;
    case 2131428509: 
      if (this.n.getVisibility() == 0)
      {
        a(false);
        return;
      }
      a(true);
      return;
    case 2131428506: 
      if (NetworkUtil.isWifiConnected(this.z))
      {
        this.s.start();
        this.q = 4;
        f();
        this.p.post(this.a);
        return;
      }
      h();
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "onCompletion");
    }
    this.q = 7;
    f();
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
    this.q = 8;
    f();
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.K).a(getContext()).a(6).b(7).a(this.C).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 0, 0, 0, 0, (int)this.w, 10, 2, 0, ReportConstants.VideoEndType.OTHER)));
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
      localStringBuilder.append(this.q);
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, localStringBuilder.toString());
    }
    int i1 = (int)(paramSeekBar.getProgress() * this.w / this.x);
    if (QLog.isColorLevel())
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("seek position millions = ");
      paramSeekBar.append(i1);
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, paramSeekBar.toString());
    }
    int i2 = this.q;
    if ((i2 == 5) || (i2 == 4) || (i2 == 6)) {
      this.s.seekTo(i1);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setAdSetting(NativeAdVideoSetting paramNativeAdVideoSetting)
  {
    this.O = paramNativeAdVideoSetting;
  }
  
  public void setOnVideoFullScreen(ReadInJoyNativeAdAppVideoView.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.ae = paramVideoFullScreenListener;
  }
  
  public void setVideoData(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, AppInterface paramAppInterface)
  {
    this.y = paramAdModuleVideo;
    try
    {
      paramAdModuleVideo = new URL(this.y.r);
      this.j.setImage(paramAdModuleVideo);
    }
    catch (MalformedURLException paramAdModuleVideo)
    {
      paramAdModuleVideo.printStackTrace();
    }
    this.C = paramAdvertisementInfo;
    this.K = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    this.h.setText(((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).getDisplayDuration((int)this.y.q));
    e();
    paramAdModuleVideo = this.P;
    if (paramAdModuleVideo != null)
    {
      paramAppInterface = this.C;
      if (paramAppInterface != null) {
        paramAdModuleVideo.setAppInfo(paramAppInterface.mAdProductType, this.C.mAdCorporateLogo, this.C.mAdCorporationName, "", ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramAdvertisementInfo), paramAdvertisementInfo);
      }
    }
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.N = paramLong;
    this.D = ((int)(this.N / 1000L));
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.S != paramBoolean)
    {
      this.S = paramBoolean;
      Object localObject1;
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = (Activity)getContext();
        localObject2 = ((Activity)localObject1).getWindow();
        ((Window)localObject2).setFlags(1024, 1024);
        ((Activity)localObject1).setRequestedOrientation(0);
        localObject2 = ((Window)localObject2).getDecorView();
        this.V = ((View)localObject2).getSystemUiVisibility();
        ((View)localObject2).setSystemUiVisibility(3846);
        localObject2 = getLayoutParams();
        this.T = ((ViewGroup.LayoutParams)localObject2).width;
        this.U = ((ViewGroup.LayoutParams)localObject2).height;
        localObject1 = GdtUIUtils.a((Activity)localObject1);
        paramInt = localObject1[0];
        ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
        ((ViewGroup.LayoutParams)localObject2).height = paramInt;
        setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.R.setImageDrawable(getResources().getDrawable(2130842771));
        localObject1 = getParent();
        if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
        {
          localObject1 = (ViewGroup)localObject1;
          this.W = ((ViewGroup)localObject1).getPaddingTop();
          this.Z = ((ViewGroup)localObject1).getPaddingBottom();
          this.aa = ((ViewGroup)localObject1).getPaddingLeft();
          this.ab = ((ViewGroup)localObject1).getPaddingRight();
          ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
        }
      }
      else
      {
        localObject1 = (Activity)getContext();
        ((Activity)localObject1).getWindow().setFlags(1024, 8);
        ((Activity)localObject1).setRequestedOrientation(1);
        ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.V);
        localObject1 = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.T;
        ((ViewGroup.LayoutParams)localObject1).height = this.U;
        localObject2 = getParent();
        if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
          ((ViewGroup)localObject2).setPadding(this.aa, this.W, this.ab, this.Z);
        }
        setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.R.setImageDrawable(getResources().getDrawable(2130842770));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView
 * JD-Core Version:    0.7.0.1
 */