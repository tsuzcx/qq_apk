package com.tencent.gdtad.views.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.ad.tangram.Ad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.util.GdtAppOpenUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.volume.VolumeChangeObserver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class GdtVideoCommonView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  private TextView A;
  private View B;
  private View C;
  private long D = 0L;
  private boolean E = false;
  private int F;
  private int G;
  private int H;
  private int I;
  private View J;
  private Button K;
  private Button L;
  private TextView M;
  private ImageView N;
  private int O = -16777216;
  private boolean P;
  private GdtVideoCommonView.SilentModeReceiver Q;
  private boolean R = true;
  private View S;
  private final GdtImpressionReporter.GdtVideoReportInfo T = new GdtImpressionReporter.GdtVideoReportInfo();
  private GdtVideoReportListenerImp U;
  private ArrayList<GdtVideoCommonView.VideoListener> V = new ArrayList();
  private ResizeURLImageView W;
  private ISPlayerVideoView Z;
  public boolean a = false;
  private View aa;
  private View ab;
  private ImageView ac;
  private ImageView ad;
  private SeekBar ae;
  private SeekBar af;
  private LinearLayout ag;
  private TextView ah;
  private TextView ai;
  private ImageView aj;
  private boolean ak = true;
  private View al;
  private AudioManager am;
  private VolumeChangeObserver an;
  private GdtVideoCommonView.HeadsetDetectReceiver ao;
  private long ap = -1L;
  private Runnable aq = new GdtVideoCommonView.6(this);
  private Runnable ar = new GdtVideoCommonView.7(this);
  private Runnable as = new GdtVideoCommonView.8(this);
  private INetInfoHandler at = new GdtVideoCommonView.9(this);
  private boolean au = false;
  private GdtVideoCommonView.VideoFullScreenListener av;
  public String b = "0";
  public boolean c = false;
  private ISuperPlayer d;
  private int e;
  private long f = -1L;
  private Context g;
  private Handler h;
  private GdtVideoData i;
  private long j = 0L;
  private int k = 10000;
  private boolean l;
  private int m = 0;
  private boolean n = false;
  private boolean o = false;
  private GdtVideoCommonView.LoadListener p;
  private int q = -1;
  private boolean r = false;
  private boolean s = false;
  private volatile boolean t = false;
  private ImageView u;
  private RelativeLayout v;
  private int w;
  private int x;
  private int y;
  private boolean z = false;
  
  public GdtVideoCommonView(Context paramContext)
  {
    super(paramContext);
    this.g = paramContext;
    this.h = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131624926, this);
    k();
  }
  
  public GdtVideoCommonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = paramContext;
    this.h = new Handler(Looper.getMainLooper());
    View.inflate(paramContext, 2131624926, this);
    k();
  }
  
  private void A()
  {
    Object localObject = this.U;
    if (localObject != null) {
      ((GdtVideoReportListenerImp)localObject).a(this.i, this.T);
    }
    localObject = this.V.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GdtVideoCommonView.VideoListener)((Iterator)localObject).next()).d(this);
    }
    b(false);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (this.d == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStateOfMediaSound volume =");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" viewReusmed ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isFromVolumeChanged ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" isSilentMode = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", isVolumOpen = ");
      localStringBuilder.append(this.ak);
      localStringBuilder.append(", hasNotifyCompleted = ");
      localStringBuilder.append(this.au);
      localStringBuilder.append("，isOutputMute = ");
      localStringBuilder.append(paramBoolean3);
      QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
      if (paramInt > 0)
      {
        if ((paramBoolean3) && (!paramBoolean2))
        {
          this.ak = false;
          this.aj.setBackgroundResource(2130841249);
        }
        else
        {
          this.aj.setBackgroundResource(2130841250);
          this.ak = true;
          if (AppSetting.e) {
            this.aj.setContentDescription(HardCodeUtil.a(2131903203));
          }
        }
      }
      else
      {
        this.aj.setBackgroundResource(2130841249);
        this.ak = false;
        if (AppSetting.e) {
          this.aj.setContentDescription(HardCodeUtil.a(2131903210));
        }
      }
      paramInt = this.e;
      if ((paramInt != 6) && (paramInt != 8) && (paramInt != 7)) {
        b(this.ak);
      }
      u();
    }
  }
  
  private void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playVideo startElapsed -->");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    localObject = this.d;
    if ((localObject != null) && (!((ISuperPlayer)localObject).isPlaying()) && (this.e != 3))
    {
      this.e = 3;
      String str = this.i.getAd().getTencent_video_id();
      localObject = this.i.getUrl();
      StringBuffer localStringBuffer = new StringBuffer("playVideo url=");
      localStringBuffer.append((String)localObject);
      localStringBuffer.append(",vid=");
      localStringBuffer.append(str);
      if (ImaxAdVideoPreloadManager.b(str))
      {
        localObject = ImaxAdVideoPreloadManager.d(str);
        localStringBuffer.append(",changeUrl=");
        localStringBuffer.append((String)localObject);
      }
      QLog.i("GdtVideoCommonView", 1, localStringBuffer.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = SuperPlayerFactory.createVideoInfoForUrl((String)localObject, 104, str, null);
      }
      else
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject = SuperPlayerFactory.createVideoInfoForTVideo(str);
      }
      this.d.reset();
      o();
      this.d.openMediaPlayer(this.g, (SuperPlayerVideoInfo)localObject, paramLong);
      if (this.e == 8)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo STATE_ERROR return -->");
        ((StringBuilder)localObject).append(paramLong);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      c();
    }
  }
  
  private void a(Context paramContext)
  {
    if (QQVideoPlaySDKManager.isSDKReady())
    {
      c(paramContext);
      return;
    }
    b(paramContext);
  }
  
  private void a(View paramView)
  {
    Iterator localIterator = this.V.iterator();
    while (localIterator.hasNext()) {
      ((GdtVideoCommonView.VideoListener)localIterator.next()).a(paramView);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("letsShowOff ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mVideoState ");
    localStringBuilder.append(this.e);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    if (this.e != 5) {
      return;
    }
    this.h.removeCallbacks(this.as);
    if (paramBoolean)
    {
      this.af.setVisibility(4);
      this.ag.setVisibility(0);
      this.ad.setVisibility(0);
      this.h.postDelayed(this.as, 2000L);
    }
    else
    {
      this.af.setVisibility(0);
      this.ag.setVisibility(8);
      this.ad.setVisibility(8);
    }
    u();
  }
  
  private void b(Context paramContext)
  {
    this.e = 1;
    try
    {
      QLog.i("VideoGdtGdtVideoCommonView", 1, "installSDK");
      QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new GdtVideoCommonView.3(this, paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VideoGdtGdtVideoCommonView", 1, "installSDK", paramContext);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] gain is called!");
      this.am.requestAudioFocus(null, 3, 2);
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "[requestSystemAudioFocus] release is called!");
    this.am.abandonAudioFocus(null);
  }
  
  private void c(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("initVideo ");
    paramContext.append(this.b);
    QLog.i("GdtVideoCommonView", 1, paramContext.toString());
    this.e = 2;
    this.Z = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
    if (this.Z != null)
    {
      setBackgroundColor(this.O);
      this.S.setBackgroundColor(this.O);
      paramContext = this.Z;
      if ((paramContext instanceof View))
      {
        paramContext = (View)paramContext;
        paramContext.setBackgroundColor(this.O);
        paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(paramContext, 0);
      }
      else
      {
        QLog.i("GdtVideoCommonView", 1, "!mVideoView instanceof View)");
      }
      this.d = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 110, this.Z);
      paramContext = this.d;
      if (paramContext == null)
      {
        QLog.i("GdtVideoCommonView", 1, "initVideo return mVideoPlayer == null");
        return;
      }
      paramContext.setOnVideoPreparedListener(this);
      this.d.setOnCompletionListener(this);
      this.d.setOnTVideoNetInfoUpdateListener(this);
      this.d.setOnErrorListener(this);
      o();
      paramContext = new StringBuilder();
      paramContext.append("initVideo isSilentMode = ");
      paramContext.append(this.c);
      paramContext.append(", isVolumOpen = ");
      paramContext.append(this.ak);
      QLog.i("GdtVideoCommonView", 1, paramContext.toString());
      if (this.c) {
        this.ak = false;
      }
      this.d.setOutputMute(this.ak ^ true);
      a(this.am.getStreamVolume(3), true, false, this.ak ^ true);
      a(this.j);
    }
  }
  
  private void k()
  {
    if (NetworkUtil.isWifiEnabled(this.g)) {
      this.m = 1;
    } else if (NetworkUtil.isNetSupport(this.g)) {
      this.m = 2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("netType ");
    ((StringBuilder)localObject).append(this.m);
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    this.W = ((ResizeURLImageView)findViewById(2131434138));
    this.aa = findViewById(2131437664);
    this.ab = findViewById(2131432778);
    this.al = findViewById(2131434142);
    this.ag = ((LinearLayout)findViewById(2131434134));
    this.ad = ((ImageView)findViewById(2131434132));
    this.ac = ((ImageView)findViewById(2131434133));
    this.ai = ((TextView)findViewById(2131440735));
    this.ae = ((SeekBar)findViewById(2131445496));
    this.af = ((SeekBar)findViewById(2131445499));
    this.ae.setMax(this.k);
    this.af.setMax(this.k);
    this.ah = ((TextView)findViewById(2131447787));
    int i1 = GdtUIUtils.a(5.0F, getResources());
    this.aj = ((ImageView)findViewById(2131434141));
    GdtUIUtils.a(this.aj, i1, i1, i1, i1);
    this.u = ((ImageView)findViewById(2131434139));
    GdtUIUtils.a(this.u, i1, i1, i1, i1);
    this.u.setOnClickListener(this);
    this.v = ((RelativeLayout)findViewById(2131430806));
    this.v.setOnClickListener(this);
    this.C = findViewById(2131434137);
    this.A = ((TextView)findViewById(2131434135));
    this.A.setOnClickListener(this);
    this.B = findViewById(2131434136);
    this.B.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    this.al.setOnClickListener(this);
    this.aj.setOnClickListener(this);
    this.ae.setOnSeekBarChangeListener(this);
    this.ab.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.am = ((AudioManager)getContext().getSystemService("audio"));
    ((Activity)this.g).setVolumeControlStream(3);
    this.an = new VolumeChangeObserver(this.g);
    this.an.a();
    this.an.a(new GdtVideoCommonView.1(this));
    AppNetConnInfo.registerConnectionChangeReceiver(this.g.getApplicationContext(), this.at);
    this.ao = new GdtVideoCommonView.HeadsetDetectReceiver(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.HEADSET_PLUG");
    this.g.registerReceiver(this.ao, (IntentFilter)localObject);
    this.Q = new GdtVideoCommonView.SilentModeReceiver(this, null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.media.RINGER_MODE_CHANGED");
    this.g.registerReceiver(this.Q, (IntentFilter)localObject);
    this.J = findViewById(2131428625);
    this.K = ((Button)findViewById(2131434083));
    this.L = ((Button)findViewById(2131434081));
    this.M = ((TextView)findViewById(2131434084));
    this.N = ((ImageView)findViewById(2131434082));
    this.K.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.S = findViewById(2131449543);
    a();
  }
  
  private void l()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!(localObject instanceof QQAppInterface))) {
      if (AppSetting.e) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = (AccessibilityManager)this.g.getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((!bool1) || (!bool2)) {
          break label80;
        }
        bool1 = true;
        AppSetting.e = bool1;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GdtVideoCommonView", 1, "initAppSettingInOntherProcess", localThrowable);
      }
      return;
      label80:
      boolean bool1 = false;
    }
  }
  
  private void m()
  {
    if (!j())
    {
      localGdtVideoData = this.i;
      if ((localGdtVideoData != null) && (!localGdtVideoData.isLoop()) && (this.i.getAd().getProductType() != 19))
      {
        this.aa.setVisibility(8);
        this.ab.setVisibility(8);
        this.ad.setVisibility(8);
        this.ag.setVisibility(4);
        this.aj.setVisibility(4);
        this.ac.setVisibility(8);
        s();
        this.W.setVisibility(0);
        this.S.setVisibility(0);
        this.J.setVisibility(0);
        n();
        break label223;
      }
    }
    this.J.setVisibility(8);
    this.aa.setVisibility(8);
    this.ab.setVisibility(8);
    this.ad.setVisibility(8);
    this.aj.setVisibility(4);
    s();
    GdtVideoData localGdtVideoData = this.i;
    if ((localGdtVideoData != null) && (localGdtVideoData.getPlayScene() == 7) && (this.d != null))
    {
      b();
    }
    else
    {
      this.W.setVisibility(0);
      this.ac.setVisibility(0);
    }
    label223:
    u();
  }
  
  private void n()
  {
    if ((this.J.getVisibility() == 0) && (this.i != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDownloadBtnLable ");
      ((StringBuilder)localObject).append(this.b);
      QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
      if ((this.i.getAd() instanceof GdtAd)) {
        localObject = (GdtAd)this.i.getAd();
      } else {
        localObject = null;
      }
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateDownloadBtnLable gdtAd == null ");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (((GdtAd)localObject).isAppProductType())
      {
        String str = ((GdtAd)localObject).getAppPackageName();
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(this.g, str))
        {
          this.L.setText(HardCodeUtil.a(2131903208));
          return;
        }
        if (GdtAppOpenUtil.a(this.g, ((GdtAd)localObject).getAppPackageName()))
        {
          this.L.setText(HardCodeUtil.a(2131903201));
          return;
        }
        this.L.setText(HardCodeUtil.a(2131903204));
        return;
      }
      this.L.setText(HardCodeUtil.a(2131903211));
    }
  }
  
  private void o()
  {
    Object localObject = this.i;
    if ((localObject != null) && (this.d != null))
    {
      if (((GdtVideoData)localObject).isLoop()) {
        this.d.setLoopback(true);
      } else {
        this.d.setLoopback(false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVideoPlayByData dataLoop=");
      ((StringBuilder)localObject).append(this.i.isLoop());
      ((StringBuilder)localObject).append(",videoLoop = ");
      ((StringBuilder)localObject).append(this.d.isLoopBack());
      QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.i("GdtVideoCommonView", 1, "setVideoPlayByData failed");
  }
  
  private void p()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.h.post(new GdtVideoCommonView.5(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doStartPlay ");
    localStringBuilder.append(this.b);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    if (this.d == null)
    {
      QLog.i("GdtVideoCommonView", 1, "doStartPlay return mVideoPlayer == null");
      return;
    }
    if (this.c)
    {
      QLog.i("GdtVideoCommonView", 1, "doStartPlay isSilentMode is true");
      this.ak = false;
    }
    this.d.setOutputMute(this.ak ^ true);
    this.d.start();
    this.e = 5;
    c();
    a(this.am.getStreamVolume(3), true, false, this.ak ^ true);
  }
  
  private void q()
  {
    StringBuilder localStringBuilder;
    if (i())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseVideoInternal ");
      localStringBuilder.append(this.b);
      QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
      this.d.pause();
      this.e = 6;
      this.h.removeCallbacksAndMessages(null);
      c();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseVideoInternal return ");
      localStringBuilder.append(this.b);
      QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    }
    b(false);
  }
  
  private void r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeVideByNet netType ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    int i1 = this.m;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        if (this.n)
        {
          p();
          return;
        }
        this.h.removeCallbacks(this.aq);
        this.h.postDelayed(this.aq, 500L);
        return;
      }
      p();
      return;
    }
    FMToastUtil.a(2131886196);
    this.e = 8;
    this.T.c(2);
    c();
  }
  
  private void s()
  {
    this.C.setVisibility(8);
  }
  
  private void t()
  {
    this.a = true;
  }
  
  private void u()
  {
    if (this.P)
    {
      this.af.setVisibility(8);
      this.ae.setVisibility(8);
      this.ag.setVisibility(8);
      this.ad.setVisibility(8);
      findViewById(2131437436).setVisibility(8);
      this.aj.setVisibility(8);
      this.ac.setVisibility(8);
    }
  }
  
  private void v()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.post(new GdtVideoCommonView.10(this));
    }
  }
  
  private void w()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      QLog.i("GdtVideoCommonView", 1, "checkIsCompleted return mVideoPlayer == null");
      return;
    }
    long l1 = ((ISuperPlayer)localObject).getCurrentPositionMs();
    localObject = this.i;
    if ((localObject != null) && (((GdtVideoData)localObject).isLoop()))
    {
      if (!this.a) {
        return;
      }
      if (Math.abs(this.i.getDurationMillis() - l1) < 1000L)
      {
        if (!this.au) {
          A();
        }
        this.au = true;
      }
      else
      {
        this.au = false;
      }
      this.h.postDelayed(new GdtVideoCommonView.11(this), 300L);
    }
  }
  
  private void x()
  {
    GdtVideoReportListenerImp localGdtVideoReportListenerImp = this.U;
    if (localGdtVideoReportListenerImp != null) {
      localGdtVideoReportListenerImp.a(this.i, this.d.getCurrentPositionMs(), this.T);
    }
    b(false);
  }
  
  private void y()
  {
    Object localObject = this.U;
    if (localObject != null)
    {
      int i1 = this.q;
      if (i1 > 0)
      {
        ((GdtVideoReportListenerImp)localObject).a(this.i, i1);
        this.q = -1;
      }
      else
      {
        ISuperPlayer localISuperPlayer = this.d;
        if (localISuperPlayer == null)
        {
          QLog.i("GdtVideoCommonView", 1, "notifyStarted return mVideoPlayer == null");
          return;
        }
        ((GdtVideoReportListenerImp)localObject).a(this.i, localISuperPlayer.getCurrentPositionMs());
      }
      w();
    }
    localObject = this.V.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GdtVideoCommonView.VideoListener)((Iterator)localObject).next()).b(this);
    }
  }
  
  private void z()
  {
    Object localObject = this.U;
    if (localObject != null)
    {
      ISuperPlayer localISuperPlayer = this.d;
      if (localISuperPlayer != null) {
        ((GdtVideoReportListenerImp)localObject).b(this.i, localISuperPlayer.getCurrentPositionMs(), this.T);
      }
    }
    localObject = this.V.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GdtVideoCommonView.VideoListener)((Iterator)localObject).next()).c(this);
    }
    b(false);
  }
  
  public void a()
  {
    l();
    if (AppSetting.e)
    {
      this.ac.setContentDescription(HardCodeUtil.a(2131903212));
      this.ae.setContentDescription(HardCodeUtil.a(2131903213));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" doResumeVideo ");
    localStringBuilder2.append(paramInt);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" isViewResume ");
    localStringBuilder2.append(paramBoolean1);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" stopPlayByUser ");
    localStringBuilder2.append(paramBoolean2);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mVideoState ");
    localStringBuilder2.append(this.e);
    localStringBuilder2.append(" ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    QLog.i("GdtVideoCommonView", 1, localStringBuilder1.toString());
    if (!paramBoolean2)
    {
      if (!paramBoolean1) {
        return;
      }
      switch (this.e)
      {
      default: 
      case 4: 
      case 6: 
        r();
      }
    }
  }
  
  public void a(GdtVideoCommonView.VideoListener paramVideoListener)
  {
    if (!this.V.contains(paramVideoListener)) {
      this.V.add(paramVideoListener);
    }
  }
  
  public void b()
  {
    this.o = false;
    this.n = true;
    t();
    int i1 = this.e;
    if ((i1 != 6) && (i1 != 4))
    {
      a(this.j);
      return;
    }
    a(2, this.a, false);
  }
  
  public void c()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.h.post(new GdtVideoCommonView.2(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateView ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    if (AppSetting.e) {
      this.ad.setContentDescription(HardCodeUtil.a(2131903205));
    }
    this.S.setVisibility(8);
    int i1 = this.e;
    if (i1 != 3)
    {
      if (i1 != 5)
      {
        if (i1 != 6)
        {
          if (i1 != 7)
          {
            if (i1 != 8)
            {
              this.J.setVisibility(8);
              this.aa.setVisibility(8);
              this.ab.setVisibility(8);
              this.W.setVisibility(0);
              this.ac.setVisibility(8);
              this.ad.setVisibility(0);
              this.aj.setVisibility(4);
              s();
            }
            else
            {
              this.J.setVisibility(8);
              this.aa.setVisibility(8);
              this.ab.setVisibility(0);
              this.W.setVisibility(8);
              this.ac.setVisibility(8);
              this.ad.setVisibility(8);
              this.aj.setVisibility(0);
              s();
              x();
            }
          }
          else
          {
            m();
            A();
          }
        }
        else
        {
          this.J.setVisibility(8);
          this.aa.setVisibility(8);
          this.ab.setVisibility(8);
          if (this.o)
          {
            this.W.setVisibility(8);
          }
          else
          {
            localObject = this.g;
            if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
              this.W.setVisibility(0);
            }
          }
          this.ad.setVisibility(8);
          this.af.setVisibility(4);
          this.ag.setVisibility(4);
          this.aj.setVisibility(4);
          this.ac.setVisibility(0);
          s();
          z();
        }
      }
      else
      {
        this.J.setVisibility(8);
        this.o = false;
        this.aa.setVisibility(8);
        this.ab.setVisibility(8);
        this.W.setVisibility(8);
        this.ac.setVisibility(8);
        this.aj.setVisibility(0);
        s();
        a(false);
        this.h.post(this.ar);
        y();
      }
    }
    else
    {
      this.J.setVisibility(8);
      this.aa.setVisibility(8);
      this.ab.setVisibility(8);
      this.W.setVisibility(0);
      this.ac.setVisibility(0);
      this.ad.setVisibility(8);
      this.aj.setVisibility(0);
      s();
    }
    u();
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseVideo ");
    localStringBuilder.append(this.b);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    this.a = false;
    q();
  }
  
  public void e()
  {
    this.o = true;
    q();
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeVideo ");
    localStringBuilder.append(this.b);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    t();
    a(1, this.a, this.o);
    if (this.z) {
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(3846);
    }
    n();
  }
  
  public void g()
  {
    QLog.i("GdtVideoCommonView", 1, "releaseMediaPlayer");
    ISuperPlayer localISuperPlayer = this.d;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.stop();
      this.d.release();
      this.d = null;
    }
  }
  
  public long getCurrentPosition()
  {
    ISuperPlayer localISuperPlayer = this.d;
    if (localISuperPlayer == null) {
      return 0L;
    }
    return localISuperPlayer.getCurrentPositionMs();
  }
  
  public GdtImpressionReporter.GdtVideoReportInfo getVideoReportInfo()
  {
    return this.T;
  }
  
  public void h()
  {
    QLog.i("GdtVideoCommonView", 1, "onDestroy");
    g();
    this.h.removeCallbacksAndMessages(null);
    Object localObject1 = this.an;
    if (localObject1 != null) {
      ((VolumeChangeObserver)localObject1).b();
    }
    localObject1 = this.at;
    if (localObject1 != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject1);
    }
    localObject1 = this.g;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.ao;
      if (localObject2 != null) {
        ((Context)localObject1).unregisterReceiver((BroadcastReceiver)localObject2);
      }
    }
    localObject1 = this.g;
    if (localObject1 != null)
    {
      localObject2 = this.Q;
      if (localObject2 != null) {
        ((Context)localObject1).unregisterReceiver((BroadcastReceiver)localObject2);
      }
    }
    if (this.U != null) {
      this.U = null;
    }
  }
  
  public boolean i()
  {
    return (this.d != null) && (this.e == 5);
  }
  
  public boolean j()
  {
    return this.z;
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (l1 - this.ap < 350L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick too fast not allowed  ");
      ((StringBuilder)localObject).append(this.b);
      QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      this.ap = l1;
      int i2 = paramView.getId();
      int i1 = 0;
      switch (i2)
      {
      default: 
        break;
      case 2131434142: 
        if (this.ad.getVisibility() == 0) {
          i1 = 1;
        }
        a(i1 ^ 0x1);
        a(paramView);
        break;
      case 2131434141: 
        localObject = this.d;
        if (localObject == null)
        {
          QLog.i("GdtVideoCommonView", 1, "gdt_video_volume_switch click return mVideoPlayer == null");
        }
        else if (((ISuperPlayer)localObject).isOutputMute())
        {
          this.d.setOutputMute(false);
          a(1, true, false, false);
        }
        else
        {
          this.d.setOutputMute(true);
          a(0, true, false, true);
        }
        break;
      case 2131434139: 
        localObject = this.av;
        if (localObject != null) {
          if (this.z) {
            ((GdtVideoCommonView.VideoFullScreenListener)localObject).a();
          } else {
            ((GdtVideoCommonView.VideoFullScreenListener)localObject).b();
          }
        }
        break;
      case 2131434135: 
      case 2131434136: 
        b();
        break;
      case 2131434133: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick  gdt_video_center_play mVideoState ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        b();
        break;
      case 2131434132: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick  gdt_video_center_pause mVideoState ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        this.T.b(1);
        e();
        break;
      case 2131434083: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click playagain mVideoState ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        this.J.setVisibility(8);
        b();
        break;
      case 2131434081: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click download mVideoState ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        localObject = this.g;
        if ((localObject != null) && ((localObject instanceof Activity)))
        {
          localObject = (Activity)localObject;
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.q = 7;
          localParams.r = new WeakReference(localObject);
          localParams.a = ((GdtAd)this.i.getAd());
          localParams.b = false;
          localParams.e = true;
          GdtHandler.a(localParams);
        }
        break;
      case 2131432778: 
        a(this.j);
        break;
      case 2131430806: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick  closeBtn exitFullScreen ");
        ((StringBuilder)localObject).append(this.z);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
        if (this.z)
        {
          localObject = this.av;
          if (localObject != null) {
            ((GdtVideoCommonView.VideoFullScreenListener)localObject).a();
          }
        }
        else
        {
          localObject = this.g;
          if (localObject != null)
          {
            localObject = (Activity)localObject;
            ((Activity)localObject).finish();
            ((Activity)localObject).overridePendingTransition(17432576, 17432577);
          }
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.e = 7;
    c();
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onCompletion");
    paramISuperPlayer.append(this.e);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onError errorType ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(" errorCode ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(" extraInfo ");
    paramISuperPlayer.append(paramString);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
    this.e = 8;
    this.T.a(paramInt2, paramInt3);
    paramISuperPlayer = this.p;
    if ((paramISuperPlayer != null) && (!this.s))
    {
      this.s = true;
      paramISuperPlayer.a(false);
    }
    Toast.makeText(this.g, HardCodeUtil.a(2131903202), 0).show();
    c();
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l = true;
      this.ai.setText(GdtUIUtils.a(paramInt * this.f / this.k));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    paramSeekBar = new StringBuilder();
    paramSeekBar.append("onStartTrackingTouch ");
    paramSeekBar.append(this.e);
    QLog.i("GdtVideoCommonView", 1, paramSeekBar.toString());
    this.h.removeCallbacksAndMessages(null);
    this.l = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStopTrackingTouch ");
    localStringBuilder.append(this.e);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    this.l = false;
    this.q = ((int)(paramSeekBar.getProgress() * this.f / this.k));
    t();
    int i1 = this.e;
    if ((i1 >= 4) && (i1 <= 6))
    {
      if (this.d == null)
      {
        QLog.i("GdtVideoCommonView", 1, "onStopTrackingTouch return mVideoPlayer == null");
      }
      else if ((i1 != 6) && (i1 != 5) && (i1 != 4))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onStopTrackingTouch no answer ");
        localStringBuilder.append(this.e);
        QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
      }
      else
      {
        i1 = this.e;
        if ((i1 == 4) || (i1 == 6)) {
          this.d.start();
        }
        this.d.seekTo(this.q);
        this.e = 5;
        c();
      }
    }
    else {
      a(this.q);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    if (paramTVideoNetInfo == null)
    {
      QLog.i("GdtVideoCommonView", 1, "onTVideoNetInfoUpdate netInfo == null");
      return;
    }
    this.D = paramTVideoNetInfo.getVideoSize();
    this.h.removeCallbacks(this.aq);
    this.h.post(this.aq);
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onTVideoNetInfoUpdate size:");
    paramISuperPlayer.append(this.D);
    paramISuperPlayer.append(" hasShowTips ");
    paramISuperPlayer.append(this.E);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onVideoPrepared ");
    paramISuperPlayer.append(this.e);
    paramISuperPlayer.append(" isViewResume ");
    paramISuperPlayer.append(this.a);
    paramISuperPlayer.append(" ");
    paramISuperPlayer.append(this.b);
    QLog.i("GdtVideoCommonView", 1, paramISuperPlayer.toString());
    paramISuperPlayer = this.p;
    if ((paramISuperPlayer != null) && (!this.s))
    {
      this.s = true;
      paramISuperPlayer.a(true);
    }
    if (this.f < 0L)
    {
      paramISuperPlayer = this.d;
      if (paramISuperPlayer != null)
      {
        this.f = paramISuperPlayer.getDurationMs();
        if (this.i.getDurationMillis() <= 0L) {
          this.i.setDurationMillis(this.f);
        }
        if ((this.f < 1000L) && (!this.t))
        {
          this.t = true;
          QLog.i("GdtVideoCommonView", 1, "Video error for reason:<1s ");
          if (this.U != null)
          {
            this.T.c(3);
            this.U.a(this.i, this.d.getCurrentPositionMs(), this.T);
          }
        }
        this.h.post(new GdtVideoCommonView.4(this));
      }
    }
    switch (this.e)
    {
    default: 
      break;
    case 3: 
    case 5: 
      this.e = 4;
      a(3, this.a, this.o);
    }
    paramISuperPlayer = this.V.iterator();
    while (paramISuperPlayer.hasNext()) {
      ((GdtVideoCommonView.VideoListener)paramISuperPlayer.next()).a(this);
    }
  }
  
  public void setData(GdtVideoData paramGdtVideoData)
  {
    this.i = paramGdtVideoData;
    this.n = this.i.isDirectPlay();
    this.O = paramGdtVideoData.getVideoDefaultBackgroundColor();
    this.P = paramGdtVideoData.isForceNotShowControllerView();
    int i1;
    if ((!this.n) && (this.m != 1)) {
      i1 = 12;
    } else {
      i1 = 11;
    }
    this.T.a(i1);
    this.j = paramGdtVideoData.getStartPositionMillis();
    this.ak = paramGdtVideoData.isVolumOpen();
    boolean bool;
    if (this.am.getRingerMode() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    a(this.g);
    if (!TextUtils.isEmpty(paramGdtVideoData.getCoverUrl())) {
      try
      {
        URL localURL = new URL(paramGdtVideoData.getCoverUrl());
        this.W.setImage(localURL);
      }
      catch (Exception localException)
      {
        QLog.e("GdtVideoCommonView", 1, "getCoverUrl", localException);
      }
    }
    Object localObject = this.i.getAd().getAdvertiser_corporate_logo();
    String str = this.i.getAd().getAdvertiser_corporate_image_name();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Resources localResources = getResources();
      localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130847114);
      localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130847114);
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      i1 = AIOUtils.b(55.0F, localResources);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(i1, i1, GdtUIUtils.b(21, 750, GdtUIUtils.e(this.g))));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.d);
      this.N.setImageDrawable((Drawable)localObject);
    }
    if (!TextUtils.isEmpty(str)) {
      this.M.setText(str);
    }
    if (paramGdtVideoData.needReport()) {
      this.U = new GdtVideoReportListenerImp(this.i.getPlayScene());
    }
    u();
  }
  
  public void setGdtVideoCloseIcon(int paramInt) {}
  
  public void setGdtVideoFcIcon(int paramInt)
  {
    this.u.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setLoadListener(GdtVideoCommonView.LoadListener paramLoadListener)
  {
    this.p = paramLoadListener;
  }
  
  public void setOnVideoFullScreen(GdtVideoCommonView.VideoFullScreenListener paramVideoFullScreenListener)
  {
    this.av = paramVideoFullScreenListener;
  }
  
  public void setisFullScreen(boolean paramBoolean, int paramInt)
  {
    if (this.z != paramBoolean)
    {
      this.z = paramBoolean;
      Object localObject1;
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = (Activity)getContext();
        localObject2 = ((Activity)localObject1).getWindow();
        ((Window)localObject2).setFlags(1024, 1024);
        ((Activity)localObject1).setRequestedOrientation(0);
        localObject2 = ((Window)localObject2).getDecorView();
        this.y = ((View)localObject2).getSystemUiVisibility();
        ((View)localObject2).setSystemUiVisibility(3846);
        localObject2 = getLayoutParams();
        this.w = ((ViewGroup.LayoutParams)localObject2).width;
        this.x = ((ViewGroup.LayoutParams)localObject2).height;
        localObject1 = GdtUIUtils.a((Activity)localObject1);
        int i1 = localObject1[0];
        ((ViewGroup.LayoutParams)localObject2).width = localObject1[1];
        ((ViewGroup.LayoutParams)localObject2).height = i1;
        setLayoutParams((ViewGroup.LayoutParams)localObject2);
        setGdtVideoFcIcon(2130842768);
        setGdtVideoCloseIcon(paramInt);
        localObject1 = getParent();
        if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
        {
          localObject1 = (ViewGroup)localObject1;
          this.F = ((ViewGroup)localObject1).getPaddingTop();
          this.G = ((ViewGroup)localObject1).getPaddingBottom();
          this.H = ((ViewGroup)localObject1).getPaddingLeft();
          this.I = ((ViewGroup)localObject1).getPaddingRight();
          ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
        }
      }
      else
      {
        localObject1 = (Activity)getContext();
        ((Activity)localObject1).getWindow().setFlags(1024, 8);
        ((Activity)localObject1).setRequestedOrientation(1);
        ((Activity)localObject1).getWindow().getDecorView().setSystemUiVisibility(this.y);
        localObject1 = getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.w;
        ((ViewGroup.LayoutParams)localObject1).height = this.x;
        localObject2 = getParent();
        if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
          ((ViewGroup)localObject2).setPadding(this.H, this.F, this.I, this.G);
        }
        setLayoutParams((ViewGroup.LayoutParams)localObject1);
        setGdtVideoFcIcon(2130842769);
        setGdtVideoCloseIcon(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView
 * JD-Core Version:    0.7.0.1
 */