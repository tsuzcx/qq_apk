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
  public static long c = -1L;
  public static boolean d = false;
  public static Drawable e;
  public static boolean g = false;
  public static boolean h = false;
  public static boolean i = false;
  private View A;
  private boolean B = false;
  private long C;
  private AdModuleVideo D;
  private int E = 0;
  private int F = 0;
  private int G = 1;
  private int H = 0;
  private int I = 1;
  private int J = 1;
  private AppInterface K;
  private boolean L = false;
  private boolean M = false;
  private boolean N = false;
  private View O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private ReadInjoyIMAXAdFragment.Param T;
  private int U;
  private ValueAnimator V;
  private int W = 0;
  private int X;
  private boolean Y = false;
  private ImageView Z;
  private ImageView aa;
  private String ab = "3";
  private boolean ac;
  private URLDrawable ad;
  private boolean ae = false;
  private ActionEntity af;
  private boolean ag = false;
  private boolean ah = false;
  private Handler ai;
  private boolean aj = false;
  public boolean b = false;
  public boolean f = false;
  private Context j;
  private ClipLayout k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private TextView q;
  private View r;
  private View s;
  private View t;
  private View u;
  private Handler v;
  private int w;
  private TVK_IProxyFactory x;
  private TVK_IMediaPlayer y;
  private TVK_ICacheMgr z;
  
  private static void A(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    paramReadInjoyIMAXAdFragment.w = 9;
    i = true;
    TVK_IMediaPlayer localTVK_IMediaPlayer = paramReadInjoyIMAXAdFragment.y;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
    if (paramReadInjoyIMAXAdFragment.Y) {
      return;
    }
    paramReadInjoyIMAXAdFragment.Y = true;
    B(paramReadInjoyIMAXAdFragment);
    paramReadInjoyIMAXAdFragment.a(paramReadInjoyIMAXAdFragment.getBaseActivity().app, 23);
  }
  
  private static void B(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    if (paramReadInjoyIMAXAdFragment.T != null)
    {
      if (paramReadInjoyIMAXAdFragment.j == null) {
        return;
      }
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).startImaxNativeLoadingPage(paramReadInjoyIMAXAdFragment.getBaseActivity(), paramReadInjoyIMAXAdFragment.T.e.mAdLandingPage, paramReadInjoyIMAXAdFragment.T.e);
      paramReadInjoyIMAXAdFragment.ai.postDelayed(new ReadInjoyIMAXAdFragment.8(paramReadInjoyIMAXAdFragment), 400L);
    }
  }
  
  private void a(int paramInt)
  {
    a(paramInt);
    ReadInjoyIMAXAdFragment.Param localParam = this.T;
    if ((localParam != null) && (localParam.e != null) && (!this.aj) && (paramInt >= this.T.e.mImaxImgDisplayMs))
    {
      this.aj = true;
      if (this.T.e.mImaxJumpLandingPage == 1) {
        A(this);
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
    this.ae = true;
    if (this.aa != null)
    {
      localObject = this.ad;
      if (localObject != null) {
        ((URLDrawable)localObject).setURLDrawableListener(null);
      }
    }
    this.k.setAlpha(1.0F);
    this.p.setVisibility(0);
    this.V = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F });
    this.V.setDuration(500L);
    this.k.setNeedClip(true);
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
      ((StringBuilder)localObject).append(this.R);
      ((StringBuilder)localObject).append(",startTop =");
      ((StringBuilder)localObject).append(this.S);
      ((StringBuilder)localObject).append(",startRight =");
      ((StringBuilder)localObject).append(this.P);
      ((StringBuilder)localObject).append(",startBottom =");
      ((StringBuilder)localObject).append(this.Q);
      QLog.d("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.V.addUpdateListener(new ReadInjoyIMAXAdFragment.3(this, paramInt1, paramInt2));
    this.V.setInterpolator(new AccelerateDecelerateInterpolator());
    this.V.addListener(new ReadInjoyIMAXAdFragment.4(this));
    this.V.start();
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.T;
    if ((localObject != null) && (((ReadInjoyIMAXAdFragment.Param)localObject).e != null))
    {
      localObject = this.y;
      if (localObject != null)
      {
        long l1 = ((TVK_IMediaPlayer)localObject).getDuration() - this.T.e.mImaxShowSlipAllowMs;
        if ((l1 > 0L) && (l1 < paramLong)) {
          o();
        }
      }
      else if (this.T.e.mImaxShowSlipAllowMs < paramLong)
      {
        o();
      }
    }
  }
  
  public static void a(Context paramContext, ReadInjoyIMAXAdFragment.Param paramParam)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("w", paramParam.c);
    localIntent.putExtra("h", paramParam.d);
    localIntent.putExtra("top", paramParam.b);
    localIntent.putExtra("left", paramParam.a);
    localIntent.putExtra("ad", paramParam.e);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, ReadInjoyIMAXAdFragment.class);
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg))
    {
      B(this);
      return;
    }
    this.Z = new ImageView(getBaseActivity());
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.k.removeAllViews();
    this.k.addView(this.Z, 0, (ViewGroup.LayoutParams)localObject);
    this.Z.setScaleType(ImageView.ScaleType.FIT_XY);
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
    int i2 = localDisplayMetrics.heightPixels + this.X;
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.getStatus() == 2))
    {
      paramAdvertisementInfo.restartDownload();
      return;
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.getStatus() == 1))
    {
      this.Z.setImageDrawable(paramAdvertisementInfo);
      a(i1, i2);
      this.ai.removeMessages(-2);
      this.ai.sendEmptyMessage(-2);
      return;
    }
    if (paramAdvertisementInfo != null)
    {
      this.Z.setImageDrawable(paramAdvertisementInfo);
      paramAdvertisementInfo.setURLDrawableListener(new ReadInjoyIMAXAdFragment.2(this, i1, i2));
    }
  }
  
  private void a(AppInterface paramAppInterface, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("stat_src", this.ab);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramAppInterface).a(k()).a(paramInt).b(27).a(this.af).b(Integer.valueOf(23)).a(this.T.e).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(localHashMap)));
    Object localObject = this.y;
    if (localObject != null)
    {
      this.F = ((int)((TVK_IMediaPlayer)localObject).getCurrentPostion());
      localObject = b(paramInt);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramAppInterface).a(k()).a(6).b(27).a(this.af).a(this.T.e).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(this.E, this.F, this.G, this.H, this.I, this.J, (int)this.C, 2, 0, 0, (ReportConstants.VideoEndType)localObject)).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(localHashMap)));
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
  
  private boolean a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    boolean bool = true;
    if (paramProteusBannerVideoItemData1 != null)
    {
      if (paramProteusBannerVideoItemData2 == null) {
        return true;
      }
      if ((!TextUtils.isEmpty(paramProteusBannerVideoItemData1.G)) && (!paramProteusBannerVideoItemData1.G.equals(paramProteusBannerVideoItemData2.G))) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private ReportConstants.VideoEndType b(int paramInt)
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
  
  private void b(Context paramContext)
  {
    this.v = new Handler(Looper.getMainLooper());
    this.ai = new ReadInjoyIMAXAdFragment.ProgressUIHandler(Looper.getMainLooper(), this);
    this.k = ((ClipLayout)this.O.findViewById(2131449512));
    this.n = ((ImageView)this.O.findViewById(2131435499));
    this.o = ((ImageView)this.O.findViewById(2131435498));
    this.p = ((ImageView)this.O.findViewById(2131435502));
    this.q = ((TextView)this.O.findViewById(2131448946));
    this.r = this.O.findViewById(2131437501);
    this.s = this.O.findViewById(2131437588);
    this.t = this.O.findViewById(2131445057);
    this.u = this.O.findViewById(2131445056);
    this.l = ((ImageView)this.O.findViewById(2131439549));
    this.m = ((ImageView)this.O.findViewById(2131449520));
    this.k.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.s.setVisibility(8);
    this.r.setVisibility(8);
    this.u.setVisibility(8);
    this.n.setVisibility(8);
    this.o.setVisibility(8);
    paramContext = new ReadInjoyIMAXAdFragment.1(this, new GestureDetector(getBaseActivity(), new ReadInjoyIMAXAdFragment.GestureDelectorSimlpeListener(this)));
    this.u.setOnTouchListener(paramContext);
    this.t.setOnTouchListener(paramContext);
    ((FrameLayout)getBaseActivity().findViewById(16908290)).setForeground(new ColorDrawable(0));
  }
  
  private void c(Context paramContext)
  {
    this.w = 3;
    j();
    this.x = TVK_SDKMgr.getProxyFactory();
    Object localObject1 = this.x;
    if ((localObject1 != null) && (paramContext != null) && (this.D != null))
    {
      this.z = ((TVK_IProxyFactory)localObject1).getCacheMgr(paramContext);
      Object localObject2 = this.x.createVideoView_Scroll(paramContext);
      localObject1 = new ReadInjoyIMAXAdFragment.WeakListener(this);
      ((IVideoViewBase)localObject2).addViewCallBack((IVideoViewBase.IVideoViewCallBack)localObject1);
      this.A = ((View)localObject2);
      if (this.k != null)
      {
        this.A.setBackgroundColor(-16777216);
        this.k.addView(this.A, 0);
        localObject2 = new TVK_UserInfo("", "");
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(this.D.p), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
        localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        Object localObject3 = new HashMap();
        ((Map)localObject3).put("shouq_bus_type", "bus_type_kandian_feeds");
        localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject3);
        this.y = this.x.createMediaPlayer(paramContext.getApplicationContext(), (IVideoViewBase)this.A);
        localObject3 = this.y;
        if (localObject3 != null)
        {
          ((TVK_IMediaPlayer)localObject3).setOnVideoPreparedListener((TVK_IMediaPlayer.OnVideoPreparedListener)localObject1);
          this.y.setOnErrorListener((TVK_IMediaPlayer.OnErrorListener)localObject1);
          this.y.setOnCompletionListener((TVK_IMediaPlayer.OnCompletionListener)localObject1);
          this.y.setLoopback(false);
          this.y.openMediaPlayerByUrl(paramContext, this.D.p, 0L, 0L, (TVK_UserInfo)localObject2, localTVK_PlayerVideoInfo);
          this.y.setOutputMute(false);
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
    this.w = 1;
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
  
  public static boolean d()
  {
    return true;
  }
  
  private Context k()
  {
    return this.j;
  }
  
  private void l()
  {
    A(this);
  }
  
  private void m()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoPreparedInitialization: time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("ReadInjoyIMAXAdFragment", 2, localStringBuilder.toString());
    }
    if (this.y != null)
    {
      boolean bool = a(this.D.p, this.D.p);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("native ad preload cache state: ");
        localStringBuilder.append(bool);
        QLog.d("ReadInjoyIMAXAdFragment", 2, localStringBuilder.toString());
      }
      this.y.setOutputMute(false);
      h = true;
      this.y.start();
      this.w = 4;
      this.J = 2;
      j();
      this.y.setXYaxis(4);
      if (!this.ae)
      {
        this.ae = true;
        a(((IVideoViewBase)this.A).getViewWidth(), ((IVideoViewBase)this.A).getViewHeight());
      }
      if (QLog.isColorLevel()) {
        QLog.i("ReadInjoyIMAXAdFragment", 2, "ReadInjoyIMAXAdFragment onVideoPrepared isRetry start");
      }
      this.ai.removeMessages(-2);
      this.ai.sendEmptyMessage(-2);
      this.C = this.y.getDuration();
    }
  }
  
  private void n()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.y;
    if ((localTVK_IMediaPlayer != null) && (!i))
    {
      this.w = 6;
      localTVK_IMediaPlayer.pause();
      j();
    }
  }
  
  private void o()
  {
    Object localObject = this.p;
    if ((localObject != null) && (((ImageView)localObject).getAnimation() != null)) {
      return;
    }
    localObject = this.r;
    if ((localObject != null) && (this.p != null))
    {
      ((View)localObject).setVisibility(0);
      this.p.setVisibility(0);
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 0.2F);
      ((TranslateAnimation)localObject).setDuration(900L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.2F, 1, 0.0F);
      localTranslateAnimation.setDuration(900L);
      localTranslateAnimation.setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new ReadInjoyIMAXAdFragment.9(this, localTranslateAnimation));
      localTranslateAnimation.setAnimationListener(new ReadInjoyIMAXAdFragment.10(this, (TranslateAnimation)localObject));
      this.p.startAnimation((Animation)localObject);
    }
  }
  
  public void a()
  {
    Object localObject1 = getBaseActivity().getIntent();
    this.T = new ReadInjoyIMAXAdFragment.Param();
    this.T.c = ((Intent)localObject1).getIntExtra("w", 0);
    this.T.d = ((Intent)localObject1).getIntExtra("h", 0);
    this.T.b = ((Intent)localObject1).getIntExtra("top", 0);
    this.T.a = ((Intent)localObject1).getIntExtra("left", 0);
    this.T.e = ((AdvertisementInfo)((Intent)localObject1).getParcelableExtra("ad"));
    if (this.T.e == null) {
      return;
    }
    this.K = getBaseActivity().app;
    this.U = this.T.e.mImaxShowAdType;
    this.R = (this.T.a + 0);
    this.S = (this.T.b + 0);
    this.P = (this.R + this.T.c - 0);
    this.Q = (this.S + this.T.d - 0);
    localObject1 = e;
    if (localObject1 != null) {
      this.l.setImageDrawable((Drawable)localObject1);
    }
    localObject1 = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = this.T.c;
    ((RelativeLayout.LayoutParams)localObject1).height = this.T.d;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.S;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.R;
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.l.setScaleX(0.97F);
    this.l.setScaleY(0.97F);
    this.k.setAlpha(0.0F);
    this.k.setNeedClip(true);
    this.k.a(this.R, this.S, this.P, this.Q);
    if (!TextUtils.isEmpty(this.T.e.mAdBtnTxt)) {
      this.q.setText(this.T.e.mAdBtnTxt);
    }
    int i1 = this.U;
    if (i1 == 1001)
    {
      this.ab = "3";
      this.D = new AdModuleVideo();
      this.D.p = this.T.e.mImaxVideoUrl;
      this.af = ActionEntity.ImaxVideo;
      a(null, this.T.e, null, null);
    }
    else if (i1 == 1002)
    {
      this.ab = "10";
      this.af = ActionEntity.ImaxPic;
      a(this.T.e);
      this.o.setVisibility(8);
    }
    a(getBaseActivity().app);
    localObject1 = this.T.e.mAdLandingPage;
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
    localHashMap.put("stat_src", this.ab);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getBaseActivity()).a(2).b(27).a(this.af).a(this.T.e).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(localHashMap)));
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!this.B)
    {
      TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.B = true;
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
      this.D = new AdModuleVideo();
    }
    this.D.p = paramAdvertisementInfo.mImaxVideoUrl;
    if ((a == -1L) || (System.currentTimeMillis() - a > 1000L) || (a(paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2)))
    {
      a(k());
      a = System.currentTimeMillis();
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mImaxImg)) {
      return;
    }
    this.aa = new ImageView(getBaseActivity());
    paramAdModuleVideo = new RelativeLayout.LayoutParams(-1, -1);
    if (this.k.getChildCount() == 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.k.addView(this.aa, i1, paramAdModuleVideo);
    this.aa.setScaleType(ImageView.ScaleType.FIT_XY);
    this.ad = null;
    paramAdModuleVideo = URLDrawable.URLDrawableOptions.obtain();
    paramAdModuleVideo.mPlayGifImage = true;
    paramAdModuleVideo.mLoadingDrawable = new ColorDrawable(-16777216);
    this.ad = URLDrawable.getDrawable(paramAdvertisementInfo.mImaxImg, paramAdModuleVideo);
    paramAdModuleVideo = ((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay();
    paramAdvertisementInfo = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      paramAdModuleVideo.getRealMetrics(paramAdvertisementInfo);
    } else {
      paramAdModuleVideo.getMetrics(paramAdvertisementInfo);
    }
    int i1 = paramAdvertisementInfo.widthPixels;
    int i2 = paramAdvertisementInfo.heightPixels + this.X;
    paramAdModuleVideo = this.ad;
    if ((paramAdModuleVideo != null) && (paramAdModuleVideo.getStatus() == 2))
    {
      this.ad.restartDownload();
      return;
    }
    paramAdModuleVideo = this.ad;
    if ((paramAdModuleVideo != null) && (paramAdModuleVideo.getStatus() == 1))
    {
      this.aa.setImageDrawable(this.ad);
      a(i1, i2);
      return;
    }
    paramAdModuleVideo = this.ad;
    if (paramAdModuleVideo != null)
    {
      this.aa.setImageDrawable(paramAdModuleVideo);
      this.ad.setURLDrawableListener(new ReadInjoyIMAXAdFragment.5(this, i1, i2));
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.z;
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
      int i3 = localTVK_ICacheMgr.isVideoCached(k(), paramString1, localTVK_UserInfo, localTVK_PlayerVideoInfo, str);
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
      if (this.y != null)
      {
        this.y.stop();
        this.y.release();
        this.y = null;
        this.x = null;
      }
      Object localObject1;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        localObject1 = this.v;
        if (localObject1 != null) {
          ((Handler)localObject1).post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this, 5));
        }
      }
      else
      {
        localObject1 = this.k;
        if (localObject1 != null)
        {
          ((ClipLayout)localObject1).removeAllViews();
          this.A = null;
          this.k = null;
          e = null;
        }
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.y;
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying()))
    {
      this.y.pause();
      i = true;
    }
  }
  
  public void e()
  {
    j();
  }
  
  public void f()
  {
    m();
  }
  
  public void g()
  {
    n();
  }
  
  public void h()
  {
    c(k());
  }
  
  public void i()
  {
    b();
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
  
  public void j()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      Handler localHandler = this.v;
      if (localHandler != null)
      {
        localHandler.post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this, 1));
        return;
      }
    }
    switch (this.w)
    {
    case 7: 
    default: 
    case 4: 
    case 5: 
      if (this.aa != null) {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).changeVisibilityWithAlphaAnimation(this.aa, 8, 300);
      }
      break;
    }
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
    case 2131435499: 
      getBaseActivity().finish();
      if (this.ac) {
        return;
      }
      this.ac = true;
      a(getBaseActivity().app, 20);
      return;
    }
    paramView = this.y;
    if (paramView == null) {
      return;
    }
    if (!this.f)
    {
      this.f = true;
      paramView.setOutputMute(true);
      this.o.setImageDrawable(getResources().getDrawable(2130843984));
      return;
    }
    this.f = false;
    paramView.setOutputMute(false);
    this.o.setImageDrawable(getResources().getDrawable(2130843985));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.O = ((IVideoFeedsResourceLoader)QRoute.api(IVideoFeedsResourceLoader.class)).inflate(2131626265, true, new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = paramViewGroup.getContext();
    this.j = paramLayoutInflater;
    b(paramLayoutInflater);
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(getBaseActivity());
    getBaseActivity().getWindow().setFlags(1024, 1024);
    LiuHaiUtils.f(getBaseActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getBaseActivity());
    }
    if (LiuHaiUtils.b())
    {
      this.X = LiuHaiUtils.e(getBaseActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
      int i1 = paramLayoutInflater.topMargin + this.X;
      paramLayoutInflater.topMargin = i1;
      this.o.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
      paramLayoutInflater.topMargin = i1;
      this.n.setLayoutParams(paramLayoutInflater);
    }
    a();
    return this.O;
  }
  
  public void onDestroy()
  {
    b();
    Object localObject = this.v;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.ai;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.z = null;
    this.b = false;
    this.j = null;
    this.N = false;
    localObject = this.V;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.V = null;
    }
    localObject = this.p;
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
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.y;
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPauseing())) {
      this.y.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment
 * JD-Core Version:    0.7.0.1
 */