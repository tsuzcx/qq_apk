package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController;
import com.tencent.gdtad.basics.motivevideo.js.GdtMvWebJsActionHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper;
import com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleHelper;
import com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleHelper.MvTitleListener;
import com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController;
import com.tencent.gdtad.basics.motivevideo.web.endcrad.GdtMVEndcardWebController;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionPolicy;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoReportListenerImp;
import com.tencent.gdtad.volume.VolumeChangeObserver;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class GdtMvViewController
  implements Handler.Callback, View.OnClickListener, ICmGameVideoCallback, GdtMvTitleHelper.MvTitleListener
{
  private GdtMotiveVideoModel A;
  private AudioManager B;
  private boolean C;
  private GdtMvViewController.SilentModeReceiver D;
  private VolumeChangeObserver E;
  private boolean F;
  private boolean G;
  private GdtMVEndcardWebController H;
  private GdtMVWebBottomCardController I;
  private AdExposureChecker J;
  private AdExposureChecker.ExposureCallback K;
  private int L;
  private boolean M;
  private int N;
  private WeakReference<GdtMvViewController.Listener> O;
  private final GdtImpressionReporter.GdtVideoReportInfo P;
  private boolean Q;
  private long R;
  private boolean S;
  private boolean T;
  boolean a;
  public int b;
  public final GdtMvTitleHelper c;
  public final GdtMvMiniAppReportHelper d;
  public GdtThirdProcessorProxy e;
  private IMotiveVideoView f;
  private View g;
  private ImageView h;
  private boolean i;
  private ICmGameVideoPlayer j;
  private WeakReferenceHandler k = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private long l;
  private boolean m;
  private boolean n;
  private RelativeLayout o;
  private boolean p;
  private boolean q;
  private long r;
  private String s;
  private boolean t;
  private GdtMvElementsController u;
  private QQCustomDialog v;
  private GdtVideoReportListenerImp w;
  private boolean x;
  private Context y;
  private boolean z;
  
  public GdtMvViewController(IMotiveVideoView paramIMotiveVideoView, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    boolean bool = false;
    this.a = false;
    this.r = 15L;
    this.t = false;
    this.b = 0;
    this.x = false;
    this.z = false;
    this.C = false;
    this.F = true;
    this.c = new GdtMvTitleHelper();
    this.K = null;
    this.d = new GdtMvMiniAppReportHelper();
    this.L = 0;
    this.M = false;
    this.N = 0;
    this.P = new GdtImpressionReporter.GdtVideoReportInfo();
    this.e = new GdtThirdProcessorProxy();
    this.Q = true;
    this.R = 0L;
    this.S = true;
    this.T = false;
    this.f = paramIMotiveVideoView;
    this.A = paramGdtMotiveVideoModel;
    this.G = paramBoolean;
    paramIMotiveVideoView = this.A.a();
    paramIMotiveVideoView.style = 0;
    paramBoolean = bool;
    if (paramIMotiveVideoView.screenOrientation == 1) {
      paramBoolean = true;
    }
    this.i = paramBoolean;
    this.r = GdtUtil.a(this.A);
    this.s = paramIMotiveVideoView.getRewardText();
    paramBoolean = this.A.b().exp_info.video_countdown_style.has();
    paramIMotiveVideoView = new StringBuilder();
    paramIMotiveVideoView.append("GdtMvViewController: video_countdown = ");
    paramIMotiveVideoView.append(this.r);
    paramIMotiveVideoView.append(", video_countdown_style has = ");
    paramIMotiveVideoView.append(paramBoolean);
    paramIMotiveVideoView.append(", rewardText = ");
    paramIMotiveVideoView.append(this.s);
    QLog.i("GdtMvViewController", 1, paramIMotiveVideoView.toString());
  }
  
  private void A()
  {
    if (this.C)
    {
      QLog.i("GdtMvViewController", 1, "refreshVoiceIconDrawable isSilentMode is true");
      this.a = true;
    }
    B();
  }
  
  private void B()
  {
    this.c.a(this.g.getContext(), this.a);
  }
  
  private boolean C()
  {
    if (GdtADFlyingStreamingReportHelper.a().b() != 1) {
      return false;
    }
    GdtMotiveVideoModel localGdtMotiveVideoModel = this.A;
    if (localGdtMotiveVideoModel != null)
    {
      if (localGdtMotiveVideoModel.d() == null) {
        return false;
      }
      if (this.A.d().isJumpToEndCardDirectlyExperiment())
      {
        GdtLog.b("GdtMvViewController", "jump to end card directly");
        this.j.stopPlay();
        I();
        return true;
      }
    }
    return false;
  }
  
  private void D()
  {
    Object localObject = this.A.a();
    localObject = this.e.b(this.y, ((GdtMotiveVideoPageData)localObject).previewImgUrl);
    ImageView localImageView = this.h;
    if ((localImageView != null) && (localObject != null)) {
      localImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void E()
  {
    QLog.i("VideoGdtGdtMvViewController", 1, "initVideoView");
    Object localObject = this.A.a();
    this.P.a(11);
    this.j = new CmGameGdtVideoPlayer();
    this.j.initVideoPlayer(this.g.getContext(), ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
    this.j.addPlayerCallback(this, 100L);
    View localView = this.j.getVideoContainer();
    if ((localView != null) && (this.o != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.o.addView(localView, localLayoutParams);
      this.j.startPlay(((GdtMotiveVideoPageData)localObject).url, "sd", 0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setViewStatus], videoView is null.");
    ((StringBuilder)localObject).append(this.o);
    QLog.i("VideoGdtGdtMvViewController", 1, ((StringBuilder)localObject).toString());
  }
  
  private void F()
  {
    if (QQVideoPlaySDKManager.isSDKReady())
    {
      E();
      return;
    }
    G();
  }
  
  private void G()
  {
    try
    {
      QLog.i("VideoGdtGdtMvViewController", 1, "installSDK");
      QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new GdtMvViewController.7(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoGdtGdtMvViewController", 1, "installSDK", localThrowable);
    }
  }
  
  private void H()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doPauseAction] mIsVideoPlayCompleted:");
    ((StringBuilder)localObject1).append(this.q);
    QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.A.c();
    f(false);
    Object localObject2;
    if (!this.q)
    {
      localObject2 = this.j;
      if (localObject2 != null)
      {
        this.x = false;
        if (((ICmGameVideoPlayer)localObject2).isPlaying())
        {
          localObject2 = this.w;
          if ((localObject2 != null) && (localObject1 != null)) {
            ((GdtVideoReportListenerImp)localObject2).b((GdtVideoData)localObject1, this.j.getCurrentPosition(), this.P);
          }
        }
        this.j.pause();
      }
    }
    localObject1 = this.H;
    if (localObject1 != null) {
      ((GdtMVEndcardWebController)localObject1).d();
    }
    localObject1 = this.I;
    if (localObject1 != null)
    {
      localObject2 = this.j;
      if (localObject2 != null) {
        ((GdtMVWebBottomCardController)localObject1).a(((ICmGameVideoPlayer)localObject2).getMuteValue(), this.j.getVideoDuration(), this.j.getCurrentPosition(), this.r, this.I.a(this.j));
      }
    }
  }
  
  private void I()
  {
    a(0L, 0L, 0L);
    a(0L, true);
    f(false);
    o();
  }
  
  private void J()
  {
    if (this.j != null)
    {
      if (this.o == null) {
        return;
      }
      Object localObject = this.A.a();
      this.o.setVisibility(0);
      a(this.o);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
      int i3 = this.j.getVideoWidth();
      int i4 = this.j.getVideoHeight();
      int i1;
      if (this.i) {
        i1 = GdtUIUtils.e(this.y);
      } else {
        i1 = GdtUIUtils.d(this.y);
      }
      int i2;
      if (this.i) {
        i2 = GdtUIUtils.d(this.y);
      } else {
        i2 = GdtUIUtils.e(this.y);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[VIDEO_PREPARED] mVideoSize ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" vW-");
      localStringBuilder.append(i3);
      localStringBuilder.append(" vH-");
      localStringBuilder.append(i4);
      localStringBuilder.append(" sW-");
      localStringBuilder.append(i1);
      localStringBuilder.append(" sH-");
      localStringBuilder.append(i2);
      QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
      if ((this.i) && (((GdtMotiveVideoPageData)localObject).vSize != 585))
      {
        int i5 = (int)(i1 * 1.0F * i4 / i3);
        int i6 = (int)(i2 * 150.0F / 1334.0F);
        localLayoutParams.height = i5;
        localLayoutParams.width = i1;
        localLayoutParams.topMargin = i6;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[VIDEO_PREPARED] newHeight ");
        localStringBuilder.append(i5);
        localStringBuilder.append(" newWidth-");
        localStringBuilder.append(i1);
        localStringBuilder.append(" newTop-");
        localStringBuilder.append(i6);
        QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
      }
      if ((((GdtMotiveVideoPageData)localObject).vSize == 585) && (!this.i) && (this.A.d().isHitNew585Style()))
      {
        localLayoutParams.height = i2;
        localLayoutParams.width = ((int)(i2 * 1.0F * i3 / i4));
        localLayoutParams.leftMargin = ((int)(i1 * 168.0F / 1334.0F));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[VIDEO_PREPARED] newHeight-");
        ((StringBuilder)localObject).append(localLayoutParams.height);
        ((StringBuilder)localObject).append(" newWidth-");
        ((StringBuilder)localObject).append(localLayoutParams.width);
        QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject).toString());
      }
      this.o.requestLayout();
      b(1020034L);
    }
  }
  
  private void K()
  {
    if (this.G)
    {
      k();
      m();
    }
  }
  
  private void L()
  {
    GdtMvElementsController localGdtMvElementsController = this.u;
    if (localGdtMvElementsController != null) {
      localGdtMvElementsController.d();
    }
  }
  
  private void M()
  {
    WeakReferenceHandler localWeakReferenceHandler = this.k;
    if (localWeakReferenceHandler != null) {
      localWeakReferenceHandler.post(new GdtMvViewController.11(this));
    }
  }
  
  private void N()
  {
    if (!this.T)
    {
      b(1020012L);
      this.T = true;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVoiceIconState volume =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" mVideoPlayer ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" isFromVolumeChanged = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", mIsMute = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", viewResumed = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", mIsVideoPlayCompleted = ");
    localStringBuilder.append(this.q);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    if (paramBoolean1)
    {
      if (this.j == null) {
        return;
      }
      B();
      if (!this.q) {
        f(this.a ^ true);
      }
    }
  }
  
  private void a(View paramView)
  {
    QLog.d("GdtMvViewController", 1, new Object[] { "initExpoReport isFirst=", Boolean.valueOf(this.S) });
    this.A.c();
    if ((this.S) && (paramView != null))
    {
      this.S = false;
      this.J = new AdExposureChecker(this.A.d(), new WeakReference(paramView));
      this.K = new GdtMvViewController.10(this);
      this.J.setCallback(new WeakReference(this.K));
      this.J.startCheck();
      paramView = this.d;
      ICmGameVideoPlayer localICmGameVideoPlayer = this.j;
      long l1;
      if (localICmGameVideoPlayer != null) {
        l1 = localICmGameVideoPlayer.getCurrentPosition();
      } else {
        l1 = 0L;
      }
      paramView.a(l1);
    }
  }
  
  @Nullable
  private View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    try
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = this.A.a();
      if (this.i)
      {
        if (localGdtMotiveVideoPageData.vSize == 585) {
          this.g = paramLayoutInflater.inflate(2131624945, paramViewGroup, false);
        } else {
          this.g = paramLayoutInflater.inflate(2131624943, paramViewGroup, false);
        }
      }
      else if ((localGdtMotiveVideoPageData.vSize == 585) && (this.A.d().isHitNew585Style())) {
        this.g = paramLayoutInflater.inflate(2131624944, paramViewGroup, false);
      } else {
        this.g = paramLayoutInflater.inflate(2131624942, paramViewGroup, false);
      }
      if (this.g == null) {
        return null;
      }
      this.u = new GdtMvElementsController(this, this.g, this.A, this.e);
      this.u.a(this.d);
      this.u.a(this.i);
      GdtUIUtils.b(this.g.findViewById(2131439329));
      this.u.a();
      this.h = ((ImageView)this.g.findViewById(2131427736));
      this.o = ((RelativeLayout)this.g.findViewById(2131449605));
      this.o.setOnClickListener(this);
      return this.g;
    }
    catch (Exception paramLayoutInflater)
    {
      QLog.e("GdtMvViewController", 1, " viewcontr initViews error", paramLayoutInflater);
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if (SystemClock.uptimeMillis() - this.R < 800L) {
      return;
    }
    if ((paramInt != this.b) && (this.u != null))
    {
      this.b = paramInt;
      this.R = SystemClock.uptimeMillis();
      this.u.a(paramInt);
    }
  }
  
  private void b(long paramLong)
  {
    GdtADFlyingStreamingReportHelper.a().a(paramLong);
  }
  
  private void e(boolean paramBoolean)
  {
    this.c.a(0);
    GdtMVWebBottomCardController localGdtMVWebBottomCardController = this.I;
    if (localGdtMVWebBottomCardController != null) {
      localGdtMVWebBottomCardController.a(paramBoolean);
    }
    GdtADFlyingStreamingReportHelper.a().a(1);
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.B != null)
    {
      if (paramBoolean)
      {
        QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] gain is called!");
        this.B.requestAudioFocus(null, 3, 2);
        return;
      }
      QLog.i("GdtMvViewController", 1, "[requestSystemAudioFocus] release is called!");
      this.B.abandonAudioFocus(null);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    GdtMvElementsController localGdtMvElementsController = this.u;
    if ((localGdtMvElementsController != null) && (paramBoolean)) {
      localGdtMvElementsController.e();
    }
  }
  
  private void s()
  {
    Object localObject = this.A;
    if ((localObject != null) && (((GdtMotiveVideoModel)localObject).d() != null) && (this.A.d().isValid()))
    {
      localObject = this.A.d();
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.y, (GdtAd)localObject);
      return;
    }
    QLog.e("GdtMvViewController", 1, "doAdPreload error");
  }
  
  private void t()
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      boolean bool;
      if (((AudioManager)localObject).getRingerMode() != 2) {
        bool = true;
      } else {
        bool = false;
      }
      this.C = bool;
    }
    this.D = new GdtMvViewController.SilentModeReceiver(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.media.RINGER_MODE_CHANGED");
    this.y.registerReceiver(this.D, (IntentFilter)localObject);
    this.E = new VolumeChangeObserver(this.y);
    this.E.a();
    this.E.a(new GdtMvViewController.1(this));
  }
  
  private void u()
  {
    if (this.u != null)
    {
      this.w = new GdtVideoReportListenerImp(11);
      return;
    }
    QLog.i("GdtMvViewController", 1, " initReports error");
  }
  
  private void v()
  {
    this.H = new GdtMVEndcardWebController(this.e);
    this.H.a(this.A, this.g, this.f.b(), this.i);
  }
  
  private void w()
  {
    this.I = new GdtMVWebBottomCardController(new GdtMvViewController.2(this), this.k);
    boolean bool = this.I.a(this.A, this.g, this.f.b(), this.i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("web bottom card result:");
    localStringBuilder.append(bool);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    if (bool)
    {
      x();
    }
    else
    {
      this.I.e();
      this.I = null;
      e(false);
    }
    GdtADFlyingStreamingReportHelper.a().a(1020030L);
  }
  
  private void x()
  {
    this.c.a(4);
    GdtMVWebBottomCardController localGdtMVWebBottomCardController = this.I;
    if (localGdtMVWebBottomCardController != null)
    {
      localGdtMVWebBottomCardController.a();
      this.I.f();
    }
  }
  
  private void y()
  {
    this.v = DialogUtil.a(this.g.getContext(), 0, null, "", HardCodeUtil.a(2131903195), HardCodeUtil.a(2131903192), new GdtMvViewController.3(this), new GdtMvViewController.4(this));
    this.v.setOnKeyListener(new GdtMvViewController.5(this));
  }
  
  private void z()
  {
    Object localObject = this.A.b();
    boolean bool2 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).exp_info.video_volume.has();
    int i1 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).exp_info.video_volume.get();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initMute] videoVolume = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(",isHasVideoVolume = ");
    ((StringBuilder)localObject).append(bool2);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = true;
    QLog.i("GdtMvViewController", 1, (String)localObject);
    if ((!bool2) || (i1 != 0)) {
      bool1 = false;
    }
    this.a = bool1;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    z();
    paramLayoutInflater = b(paramLayoutInflater, paramViewGroup);
    if (paramLayoutInflater == null)
    {
      QLog.i("GdtMvViewController", 1, "GdtMvViewController init:rootView==null error");
      return null;
    }
    this.y = paramLayoutInflater.getContext();
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("GdtMvViewController: init = ");
    paramViewGroup.append(this.G);
    paramViewGroup.append(", mContext = ");
    paramViewGroup.append(this.y);
    QLog.i("GdtMvViewController", 1, paramViewGroup.toString());
    this.B = ((AudioManager)this.y.getSystemService("audio"));
    paramViewGroup = this.y;
    if (((paramViewGroup instanceof Activity)) && (!this.G)) {
      ((Activity)paramViewGroup).setVolumeControlStream(3);
    }
    s();
    GdtADFlyingStreamingReportHelper.a().a(this.A);
    t();
    A();
    a();
    D();
    F();
    L();
    y();
    u();
    v();
    w();
    this.d.a(this.A);
    b(1020033L);
    b(1020006L);
    if (this.Q)
    {
      GdtOriginalExposureReporter.a(this.A.d(), this.y, this.L);
      this.Q = false;
    }
    return paramLayoutInflater;
  }
  
  public void a()
  {
    Object localObject = this.A;
    if (localObject == null) {
      return;
    }
    this.c.a(this.g, this, (GdtMotiveVideoModel)localObject, this.d);
    this.c.a(this.f.b(), this.i);
    if (this.A.d() == null) {
      return;
    }
    localObject = this.A.d().getExperimentParam(110814);
    try
    {
      this.N = Integer.parseInt((String)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("GdtMvViewController", 1, "[initTitle] NumberFormatException, ", localNumberFormatException);
    }
  }
  
  public void a(int paramInt)
  {
    this.L = paramInt;
    this.c.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoError], module:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",errorType:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",errorCode:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",msg:");
    localStringBuilder.append(paramString);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    paramString = this.A.c();
    if ((this.w != null) && (paramString != null))
    {
      this.P.a(paramInt2, paramInt3);
      this.w.a(paramString, this.j.getCurrentPosition(), this.P);
    }
    b(1020009L);
    b(1020007L);
    GdtReporter.reportPlayFail(this.A, paramInt2, paramInt3);
    this.k.sendEmptyMessage(4);
  }
  
  public void a(long paramLong)
  {
    this.r = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = this.A.c();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.k.post(new GdtMvViewController.9(this, paramLong1, paramLong2));
      return;
    }
    if (this.q) {
      return;
    }
    boolean bool;
    if (paramLong2 < this.r * 1000L) {
      bool = true;
    } else {
      bool = false;
    }
    this.t = bool;
    long l2 = paramLong2 - paramLong1;
    long l1;
    if (this.t) {
      l1 = paramLong1;
    } else {
      l1 = this.r * 1000L - l2;
    }
    long l3 = Math.min(l1 / 1000L + 1L, this.r);
    this.c.a(paramLong2, this.r * 1000L);
    a(l1, l3, l2);
    paramLong2 = l2 / 1000L;
    a(paramLong2, this.q);
    if (l1 <= 0L)
    {
      this.m = true;
      N();
    }
    if (paramLong2 == 2L) {
      g(true);
    }
    if (paramLong1 / 1000L == 3L) {
      g(false);
    }
    if (paramLong2 == this.N) {
      this.c.b();
    }
    Object localObject2;
    if (!this.x)
    {
      localObject2 = this.w;
      if ((localObject2 != null) && (this.j != null) && (localObject1 != null))
      {
        this.x = true;
        ((GdtVideoReportListenerImp)localObject2).a((GdtVideoData)localObject1, 0L);
      }
    }
    localObject1 = this.H;
    if (localObject1 != null)
    {
      localObject2 = this.j;
      if (localObject2 != null) {
        ((GdtMVEndcardWebController)localObject1).a(((ICmGameVideoPlayer)localObject2).getVideoDuration() - this.j.getCurrentPosition());
      }
    }
    localObject1 = this.I;
    if (localObject1 != null)
    {
      localObject2 = this.j;
      if (localObject2 != null) {
        ((GdtMVWebBottomCardController)localObject1).a(((ICmGameVideoPlayer)localObject2).getMuteValue(), this.j.getVideoDuration(), this.j.getCurrentPosition(), this.r, this.I.a(this.j));
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.c.a(paramLong1, paramLong2, paramLong3);
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    this.c.a(paramLong, paramBoolean);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = this.A.a();
    QLog.i("GdtMvViewController", 1, "GDT beforeFinish call stack:", new Throwable());
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", this.l);
    localIntent.putExtra("elapsed_time", this.l);
    localIntent.putExtra("profitable_flag", this.m);
    localIntent.putExtra("is_end", this.q);
    boolean bool = this.q;
    Object localObject2;
    if (bool)
    {
      localObject2 = this.e;
      long l1 = this.l;
      ((GdtThirdProcessorProxy)localObject2).a((GdtMotiveVideoPageData)localObject1, l1, l1, bool);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("true[beforeFinish] ");
      ((StringBuilder)localObject1).append(this.l);
      ((StringBuilder)localObject1).append(" /");
      ((StringBuilder)localObject1).append(this.l);
      QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = this.j;
      if (localObject2 != null)
      {
        localIntent.putExtra("elapsed_time", ((ICmGameVideoPlayer)localObject2).getCurrentPosition());
        this.e.a((GdtMotiveVideoPageData)localObject1, this.j.getCurrentPosition(), this.l, this.q);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.m);
        ((StringBuilder)localObject1).append("[beforeFinish] ");
        ((StringBuilder)localObject1).append(this.j.getCurrentPosition());
        ((StringBuilder)localObject1).append(" /");
        ((StringBuilder)localObject1).append(this.l);
        QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
      }
    }
    this.e.a(localIntent, paramString);
    this.f.a(-1, localIntent);
    K();
  }
  
  public void a(WeakReference<GdtMvViewController.Listener> paramWeakReference)
  {
    this.O = paramWeakReference;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.j == null) {
      return;
    }
    if (paramBoolean) {
      this.d.a(7, c());
    }
    paramBoolean = this.j.getMuteValue();
    this.a = (paramBoolean ^ true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioSwitch click is called isSilentMode = ");
    localStringBuilder.append(this.C);
    localStringBuilder.append(", isMute = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvViewController", 1, localStringBuilder.toString());
    this.j.setMute(this.a);
    a(this.a ^ true, true, false);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.i("GdtMvViewController", 1, " onClick close_ads");
    if (GdtADFlyingStreamingReportHelper.a().b() == 2) {
      GdtADFlyingStreamingReportHelper.a().a(1020016L);
    } else {
      GdtADFlyingStreamingReportHelper.a().a(1020028L);
    }
    if (!c(true))
    {
      if (paramBoolean) {
        this.d.a(4, c());
      }
      this.f.a();
    }
  }
  
  public boolean b()
  {
    return this.c.a();
  }
  
  public long c()
  {
    ICmGameVideoPlayer localICmGameVideoPlayer = this.j;
    if (localICmGameVideoPlayer != null)
    {
      if (this.q) {
        return this.l;
      }
      return localICmGameVideoPlayer.getCurrentPosition();
    }
    return 0L;
  }
  
  public boolean c(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onBackEvent] mHasWatchAds ");
    ((StringBuilder)localObject1).append(this.m);
    QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      try
      {
        if (this.m)
        {
          if (!C()) {}
        }
        else
        {
          g();
          if ((this.v == null) || (this.v.isShowing())) {
            continue;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showDialog mVideoDuration ");
          ((StringBuilder)localObject1).append(this.l);
          ((StringBuilder)localObject1).append(" mRewardTime ");
          ((StringBuilder)localObject1).append(this.r);
          ((StringBuilder)localObject1).append(" mRewardText ");
          ((StringBuilder)localObject1).append(this.s);
          QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuffer(HardCodeUtil.a(2131889976));
          if (TextUtils.isEmpty(this.s)) {
            ((StringBuffer)localObject1).append(HardCodeUtil.a(2131889966));
          } else {
            ((StringBuffer)localObject1).append(this.s);
          }
          localObject2 = this.v;
          if (this.l > this.r * 1000L)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131903190));
            localStringBuilder.append(this.r);
            localStringBuilder.append(((StringBuffer)localObject1).toString());
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localObject1 = HardCodeUtil.a(2131903191);
          }
          ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
          this.v.show();
          localObject1 = this.v.getWindow();
          if (localObject1 != null) {
            ((Window)localObject1).getDecorView().setSystemUiVisibility(7942);
          }
          GdtADFlyingStreamingReportHelper.a().a(1020029L);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("show dialog err, errInfo->");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("GdtMvViewController", 1, ((StringBuilder)localObject2).toString());
      }
    }
    return false;
  }
  
  public void d(boolean paramBoolean)
  {
    this.M = paramBoolean;
    this.c.a(paramBoolean);
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  public void e()
  {
    int i1 = 1;
    QLog.i("GdtMvViewController", 1, "[onClickFeedback]");
    Object localObject = this.A;
    if ((localObject != null) && (((GdtMotiveVideoModel)localObject).d() != null))
    {
      localObject = this.A.d().getUrlForFeedBack();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).replace("__ACT_TYPE__", "2001");
        ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).doCgiReport((String)localObject);
        QLog.i("GdtMvViewController", 1, "[onClickFeedback] report feedback");
        AdToast.show(this.y, 2, "反馈成功，后续将减少此品类广告", 0);
      }
      if ((!this.M) || (!"2".equals(this.A.d().getExperimentParam(109756))) || (this.L != 1)) {
        i1 = 0;
      }
      if (i1 != 0)
      {
        localObject = this.A.c();
        if (this.j.isPlaying())
        {
          GdtVideoReportListenerImp localGdtVideoReportListenerImp = this.w;
          if ((localGdtVideoReportListenerImp != null) && (localObject != null)) {
            localGdtVideoReportListenerImp.b((GdtVideoData)localObject, this.j.getCurrentPosition(), this.P);
          }
        }
        ThreadManager.getUIHandler().post(new GdtMvViewController.6(this));
      }
      return;
    }
    QLog.i("GdtMvViewController", 1, "[onClickFeedback] gdtAd is null");
  }
  
  public boolean f()
  {
    GdtMVEndcardWebController localGdtMVEndcardWebController = this.H;
    if ((localGdtMVEndcardWebController != null) && (localGdtMVEndcardWebController.b())) {
      return true;
    }
    return c(false);
  }
  
  protected void g()
  {
    ICmGameVideoPlayer localICmGameVideoPlayer = this.j;
    if ((localICmGameVideoPlayer != null) && (!localICmGameVideoPlayer.isPaused()))
    {
      this.n = true;
      H();
    }
    b(1020010L);
  }
  
  public void h()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoPrepared]");
    if (!this.p)
    {
      this.p = true;
      if (this.k != null)
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] send PREPARED msg");
        this.k.obtainMessage(1).sendToTarget();
      }
    }
    else if (!this.n)
    {
      ICmGameVideoPlayer localICmGameVideoPlayer = this.j;
      if ((localICmGameVideoPlayer != null) && (!localICmGameVideoPlayer.isPlaying()))
      {
        QLog.i("GdtMvViewController", 1, "[onVideoPrepared] resume VideoPlayer again");
        i();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return false;
          }
          QLog.i("GdtMvViewController", 1, "[VIDEO_FAIL] handle message");
          a(0L, true);
          return false;
        }
        QLog.i("GdtMvViewController", 1, "[VIDEO_SDK_INSTALLED] initVideoView");
        E();
        return false;
      }
      QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
      paramMessage = this.j;
      if (paramMessage != null) {
        paramMessage.removePlayerCallback(this);
      }
      I();
      b(1020013L);
      return false;
    }
    if (this.j == null) {
      return false;
    }
    J();
    paramMessage = this.j;
    if (paramMessage != null)
    {
      boolean bool;
      if ((!this.a) && (!this.C)) {
        bool = false;
      } else {
        bool = true;
      }
      paramMessage.setMute(bool);
      this.l = this.j.getVideoDuration();
      paramMessage = new StringBuilder();
      paramMessage.append("[mDuration]");
      paramMessage.append(this.l);
      paramMessage.append(", mIsMute = ");
      paramMessage.append(this.a);
      paramMessage.append(", isSilentMode = ");
      paramMessage.append(this.C);
      QLog.i("GdtMvViewController", 1, paramMessage.toString());
      this.A.c().setDurationMillis(this.l);
      i();
    }
    return false;
  }
  
  public void i()
  {
    if (this.z)
    {
      ICmGameVideoPlayer localICmGameVideoPlayer = this.j;
      if (localICmGameVideoPlayer != null)
      {
        localICmGameVideoPlayer.resume();
        f(this.a ^ true);
        B();
      }
    }
  }
  
  public void j()
  {
    QLog.i("GdtMvViewController", 1, "[onVideoCompletion]");
    Object localObject1 = this.A.c();
    this.p = false;
    this.q = true;
    this.m = true;
    Object localObject2 = this.k;
    if (localObject2 != null) {
      ((WeakReferenceHandler)localObject2).obtainMessage(2).sendToTarget();
    }
    localObject2 = this.w;
    if ((localObject2 != null) && (localObject1 != null)) {
      ((GdtVideoReportListenerImp)localObject2).a((GdtVideoData)localObject1, this.P);
    }
    localObject1 = this.I;
    if (localObject1 != null)
    {
      localObject2 = this.j;
      if (localObject2 != null) {
        ((GdtMVWebBottomCardController)localObject1).a(((ICmGameVideoPlayer)localObject2).getMuteValue(), this.j.getVideoDuration(), this.j.getCurrentPosition(), this.r, this.I.a(this.j));
      }
      ThreadManager.getUIHandler().post(new GdtMvViewController.8(this));
    }
  }
  
  public void k()
  {
    this.z = false;
    H();
    Object localObject = this.J;
    if (localObject != null) {
      ((AdExposureChecker)localObject).onActivityPause();
    }
    localObject = this.u;
    if (localObject != null) {
      ((GdtMvElementsController)localObject).j();
    }
  }
  
  public void l()
  {
    this.z = true;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onResume]");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append(" mIsVideoPlayCompleted ");
    ((StringBuilder)localObject).append(this.q);
    QLog.i("GdtMvViewController", 1, ((StringBuilder)localObject).toString());
    if ((!this.n) && (!this.q) && (this.p)) {
      i();
    }
    localObject = this.u;
    if (localObject != null) {
      ((GdtMvElementsController)localObject).i();
    }
    localObject = this.H;
    if (localObject != null) {
      ((GdtMVEndcardWebController)localObject).c();
    }
    GdtMvWebJsActionHelper.a(new GdtMvViewController.MvWebJsCallAction(this, null));
    localObject = this.J;
    if (localObject != null) {
      ((AdExposureChecker)localObject).onActivityResume();
    }
  }
  
  public void m()
  {
    QLog.i("GdtMvViewController", 1, "[onDestroy]");
    Object localObject = this.k;
    if (localObject != null) {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.E;
    if (localObject != null) {
      ((VolumeChangeObserver)localObject).b();
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((ICmGameVideoPlayer)localObject).removePlayerCallback(this);
      this.j.release();
      this.j = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((GdtMvElementsController)localObject).h();
      this.u = null;
    }
    localObject = this.H;
    if (localObject != null) {
      ((GdtMVEndcardWebController)localObject).b(this.f.b(), this.G);
    }
    localObject = this.I;
    if (localObject != null) {
      ((GdtMVWebBottomCardController)localObject).e();
    }
    if (this.w != null) {
      this.w = null;
    }
    localObject = this.y;
    if (localObject != null)
    {
      GdtMvViewController.SilentModeReceiver localSilentModeReceiver = this.D;
      if (localSilentModeReceiver != null) {
        ((Context)localObject).unregisterReceiver(localSilentModeReceiver);
      }
    }
    this.y = null;
    GdtImpressionPolicy.a().b();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 55);
    localObject = this.J;
    if (localObject != null)
    {
      ((AdExposureChecker)localObject).onActivityDestroy();
      this.J.setCallback(null);
    }
    GdtMvWebJsActionHelper.a();
  }
  
  public void n()
  {
    QLog.i("GdtMvViewController", 1, "[onCreate]");
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 55);
  }
  
  protected void o()
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      ((GdtMvElementsController)localObject).b();
      this.u.c();
    }
    b(1);
    localObject = this.H;
    if (localObject != null) {
      ((GdtMVEndcardWebController)localObject).a(this.f.b(), this.A, this.i);
    }
    localObject = this.A;
    if (localObject != null) {
      this.c.a(((GdtMotiveVideoModel)localObject).d());
    }
    GdtADFlyingStreamingReportHelper.a().a(1020035L);
    GdtADFlyingStreamingReportHelper.a().a(2);
  }
  
  public void onClick(View paramView) {}
  
  public void p()
  {
    a("");
  }
  
  public IMotiveVideoView q()
  {
    return this.f;
  }
  
  public GdtImpressionReporter.GdtVideoReportInfo r()
  {
    return this.P;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController
 * JD-Core Version:    0.7.0.1
 */