package com.tencent.av.wtogether.media;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.annotation.NonNull;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.wtogether.WTogetherMngHelper;
import com.tencent.av.wtogether.callback.AudioSink;
import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTVideoInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
import com.tencent.biz.subscribe.framework.BaseVideoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

public class WatchTogetherMediaPlayCtrl
  implements SeekBar.OnSeekBarChangeListener, WatchTogetherMediaPlayerProxy, ISuperPlayer.OnAudioFrameOutputListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private int A = 0;
  private VideoAppInterface B;
  private WTogetherMngHelper C;
  private CopyOnWriteArrayList<Runnable> D = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<WeakReference<WatchTogetherMediaPlayerStatusCallback>> E = new CopyOnWriteArrayList();
  private int a = 1;
  private int b = 1;
  private HandlerThread c;
  private WatchTogetherMediaPlayCtrl.CustomHandler d;
  private WTogetherPlayInfo e;
  private WTVideoInfo f;
  private int g;
  private String h;
  private String i;
  private Surface j;
  @NonNull
  private VideoSink k;
  @NonNull
  private AudioSink l;
  private float m = 1.0F;
  private boolean n;
  private boolean o = true;
  private volatile ISuperPlayer p;
  private volatile Timer q;
  private WatchTogetherVideoDecodeHelper r;
  private WatchTogetherAudioDecodeHelper s;
  private boolean t;
  private WatchTogetherDataReportHelper u;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private long y = -1L;
  private int z = 1;
  
  public WatchTogetherMediaPlayCtrl(VideoAppInterface paramVideoAppInterface)
  {
    this.B = paramVideoAppInterface;
    this.s = new WatchTogetherAudioDecodeHelper();
    this.u = new WatchTogetherDataReportHelper();
    this.c = new HandlerThread("WatchTogetherMediaPlayCtrl_thread");
    this.c.start();
    this.d = new WatchTogetherMediaPlayCtrl.CustomHandler(this, this.c.getLooper());
    this.d.sendEmptyMessage(256);
  }
  
  private boolean E()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.y > 500L)
    {
      this.y = l1;
      return true;
    }
    return false;
  }
  
  private void F()
  {
    int i1 = this.g;
    if ((i1 != 2) && (i1 != 1)) {
      return;
    }
    TPProgramInfo[] arrayOfTPProgramInfo = this.p.getProgramInfo();
    if (arrayOfTPProgramInfo == null) {
      return;
    }
    int i12 = arrayOfTPProgramInfo.length;
    int i2 = -1;
    int i6 = 0;
    int i3 = -1;
    int i5 = 2147483647;
    int i4 = -2147483648;
    i1 = 0;
    while (i6 < i12)
    {
      int i11 = a(arrayOfTPProgramInfo[i6].resolution) - 720;
      int i8;
      int i9;
      int i7;
      int i10;
      if ((i11 >= 0) && (i11 < i5))
      {
        i8 = i1;
        i9 = i11;
        i7 = i3;
        i10 = i4;
      }
      else
      {
        i7 = i3;
        i8 = i2;
        i9 = i5;
        i10 = i4;
        if (i11 < 0)
        {
          i7 = i3;
          i8 = i2;
          i9 = i5;
          i10 = i4;
          if (i11 > i4)
          {
            i7 = i1;
            i10 = i11;
            i9 = i5;
            i8 = i2;
          }
        }
      }
      i1 += 1;
      i6 += 1;
      i3 = i7;
      i2 = i8;
      i5 = i9;
      i4 = i10;
    }
    if (i2 >= 0) {
      i3 = i2;
    } else if (i3 < 0) {
      i3 = 0;
    }
    this.p.selectProgram(i3, 0L);
  }
  
  private ISuperPlayer G()
  {
    if (this.p == null)
    {
      ISuperPlayer localISuperPlayer;
      if (QQVideoPlaySDKManager.isSDKReady()) {
        localISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 115, null);
      } else {
        localISuperPlayer = null;
      }
      this.p = localISuperPlayer;
    }
    if (this.p == null)
    {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "getSuperPlayer return null");
      return null;
    }
    this.p.setOnVideoPreparedListener(this);
    this.p.setOnCaptureImageListener(this);
    this.p.setOnInfoListener(this);
    this.p.setOnErrorListener(this);
    this.p.setOnDefinitionInfoListener(this);
    this.p.setOnTVideoNetInfoUpdateListener(this);
    this.p.setOnCompletionListener(this);
    this.p.setOnVideoSizeChangedListener(this);
    this.p.setOnSeekCompleteListener(this);
    this.p.setOnAudioFrameOutputListener(this);
    this.p.setOnVideoSizeChangedListener(this);
    return this.p;
  }
  
  private void H()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "playTimer");
    if (this.q != null)
    {
      this.q.cancel();
      this.q.purge();
    }
    this.q = new Timer();
    this.q.schedule(new WatchTogetherMediaPlayCtrl.TimeUpdateTimerTask(this), 0L, 200L);
  }
  
  private void I()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopTimer");
    if (this.q != null)
    {
      this.q.cancel();
      this.q = null;
    }
  }
  
  private void J()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopVideoInternal");
    ISuperPlayer localISuperPlayer = this.p;
    if (localISuperPlayer != null) {
      localISuperPlayer.stop();
    }
    d(8);
    I();
  }
  
  private void K()
  {
    if (this.r == null) {
      this.r = WatchTogetherVideoDecodeHelper.a("watchTogetherVideoDispatch");
    }
  }
  
  private void L()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "releaseInternal");
    if (this.p != null)
    {
      this.p.stop();
      this.p.release();
      this.p = null;
    }
    this.D.clear();
    this.E.clear();
    I();
    this.f = null;
    this.y = -1L;
    this.k = null;
    this.l = null;
    Object localObject = this.j;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.j = null;
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((WatchTogetherVideoDecodeHelper)localObject).d();
      this.r = null;
    }
    this.t = false;
    d(1);
  }
  
  private void M()
  {
    if (this.a == 1) {
      return;
    }
    this.d.post(new WatchTogetherMediaPlayCtrl.10(this));
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = paramString.split("x");
    if ((paramString != null) && (paramString.length == 2)) {
      try
      {
        int i1 = Math.min(Integer.valueOf(paramString[0]).intValue(), Integer.valueOf(paramString[1]).intValue());
        return i1;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo expectPositionMs:=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",sync:=");
    localStringBuilder.append(paramBoolean);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.d.removeMessages(260);
    this.d.obtainMessage(260, paramBoolean ^ true, 0, Integer.valueOf(paramInt)).sendToTarget();
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "playVideoInternal");
    if (this.p != null)
    {
      this.p.stop();
      this.p.reset();
    }
    Object localObject1 = this.j;
    if (localObject1 != null)
    {
      ((Surface)localObject1).release();
      this.j = null;
    }
    K();
    Object localObject2 = new SuperPlayerAudioInfo();
    ((SuperPlayerAudioInfo)localObject2).setAudioSampleRateHZ(48000);
    ((SuperPlayerAudioInfo)localObject2).setAudioChannelLayout(4L);
    boolean bool = QAVConfigUtils.n();
    localObject1 = WTogetherUtil.a(this.f);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = (bool ^ true);
    localSuperPlayerOption.audioFrameOutputOption = ((SuperPlayerAudioInfo)localObject2);
    localObject2 = G();
    if (localObject2 == null) {
      return;
    }
    this.j = new Surface(this.r.b());
    ((ISuperPlayer)localObject2).setSurface(this.j);
    ((ISuperPlayer)localObject2).setOutputMute(true ^ bool);
    ((ISuperPlayer)localObject2).openMediaPlayer(BaseApplicationImpl.getContext(), (SuperPlayerVideoInfo)localObject1, paramInt, localSuperPlayerOption);
    if (!paramBoolean) {
      H();
    }
  }
  
  private void d(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void e(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void A()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "releaseMediaPlayer");
    this.d.removeMessages(265);
    this.d.obtainMessage(265).sendToTarget();
  }
  
  public void B()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "exitDoubleTalk");
    A();
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.c.quitSafely();
      this.c = null;
    }
    this.u.a();
  }
  
  public int C()
  {
    return this.s.d();
  }
  
  public int D()
  {
    return this.s.c();
  }
  
  public void a()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "pausePlay");
    this.d.removeMessages(259);
    this.d.obtainMessage(259).sendToTarget();
  }
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlaySpeedRatio ratio:=");
    localStringBuilder.append(paramFloat);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.m = paramFloat;
    this.t = true;
    this.d.removeMessages(289);
    this.d.obtainMessage(289, 0, 0, Float.valueOf(paramFloat)).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void a(VideoSink paramVideoSink)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoSink Thread.currentThread()):=");
    localStringBuilder.append(Thread.currentThread());
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.d.post(new WatchTogetherMediaPlayCtrl.1(this, paramVideoSink));
  }
  
  public void a(WatchTogetherMediaPlayerStatusCallback paramWatchTogetherMediaPlayerStatusCallback)
  {
    Iterator localIterator = this.E.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramWatchTogetherMediaPlayerStatusCallback == localWeakReference.get())) {
        return;
      }
    }
    this.E.add(new WeakReference(paramWatchTogetherMediaPlayerStatusCallback));
  }
  
  public void a(WTogetherPlayInfo paramWTogetherPlayInfo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play videoInfo:=");
    ((StringBuilder)localObject).append(paramWTogetherPlayInfo.toString());
    QLog.d("WatchTogetherMediaPlayCtrl", 1, ((StringBuilder)localObject).toString(), new Throwable("call play"));
    if (!E())
    {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "play video interval-time short");
      return;
    }
    localObject = paramWTogetherPlayInfo.b;
    this.e = paramWTogetherPlayInfo;
    this.f = ((WTVideoInfo)localObject);
    this.g = ((WTVideoInfo)localObject).a;
    this.h = ((WTVideoInfo)localObject).c;
    this.i = ((WTVideoInfo)localObject).b;
    this.d.obtainMessage(257, paramInt, 0, this.i).sendToTarget();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.D.add(paramRunnable);
  }
  
  public void a(String paramString, VideoSink paramVideoSink)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeVideoSink Thread.currentThread()):=");
    localStringBuilder.append(Thread.currentThread());
    localStringBuilder.append(",from:=");
    localStringBuilder.append(paramString);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.d.post(new WatchTogetherMediaPlayCtrl.2(this, paramVideoSink));
  }
  
  public void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.v != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateAdminFlag, [");
        ((StringBuilder)localObject).append(this.v);
        ((StringBuilder)localObject).append("-->");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("], from[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.i("WatchTogetherMediaPlayCtrl", 2, ((StringBuilder)localObject).toString());
      }
      this.v = paramBoolean;
    }
    Object localObject = this.C;
    if (localObject != null) {
      ((WTogetherMngHelper)localObject).a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setWatchTogetherEnable enable:=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(",admin:=");
    localStringBuilder.append(paramBoolean2);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    if (this.x == paramBoolean1) {
      return;
    }
    this.x = paramBoolean1;
    a(paramBoolean2, "setWatchTogetherEnable");
    if (paramBoolean1)
    {
      if (this.C == null) {
        this.C = new WTogetherMngHelper(this.B, paramBoolean2, this);
      }
      a(this.C);
    }
    else if (!paramBoolean1)
    {
      b(this.C);
      this.C = null;
    }
    this.s.a(paramBoolean1);
    p();
  }
  
  public void b()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "replay");
    c();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void b(WatchTogetherMediaPlayerStatusCallback paramWatchTogetherMediaPlayerStatusCallback)
  {
    if (paramWatchTogetherMediaPlayerStatusCallback == null) {
      return;
    }
    Iterator localIterator = this.E.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramWatchTogetherMediaPlayerStatusCallback == localWeakReference.get())) {
        this.E.remove(localWeakReference);
      }
    }
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumePlay mCurrentState:=");
    localStringBuilder.append(this.a);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString(), new Throwable("call resumePlay"));
    int i1 = this.a;
    if ((i1 != 9) && (i1 != 10))
    {
      this.d.removeMessages(258);
      this.d.obtainMessage(258).sendToTarget();
      return;
    }
    this.d.removeMessages(257);
    this.d.obtainMessage(257, 0, 0, this.i).sendToTarget();
  }
  
  public void c(int paramInt)
  {
    this.s.a(paramInt);
  }
  
  public boolean d()
  {
    return this.a == 5;
  }
  
  public long e()
  {
    if (this.p != null) {
      return this.p.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public boolean f()
  {
    return this.t;
  }
  
  public float g()
  {
    return this.m;
  }
  
  public boolean h()
  {
    return this.a == 10;
  }
  
  public boolean i()
  {
    return this.a == 9;
  }
  
  public boolean j()
  {
    return this.a == 4;
  }
  
  public String k()
  {
    return this.i;
  }
  
  public WTFileInfo l()
  {
    WTogetherPlayInfo localWTogetherPlayInfo = this.e;
    if (localWTogetherPlayInfo != null) {
      return localWTogetherPlayInfo.a;
    }
    return null;
  }
  
  public WatchTogetherDataReportHelper m()
  {
    return this.u;
  }
  
  public boolean n()
  {
    WTVideoInfo localWTVideoInfo = this.f;
    return (localWTVideoInfo != null) && ((localWTVideoInfo.a == 2) || (this.f.a == 4));
  }
  
  public boolean o()
  {
    WTVideoInfo localWTVideoInfo = this.f;
    return (localWTVideoInfo != null) && (localWTVideoInfo.a == 0);
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.s.onAudioFrameOutput(paramTPAudioFrameBuffer);
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onCompletion url:=");
    paramISuperPlayer.append(this.h);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, paramISuperPlayer.toString());
    this.d.post(new WatchTogetherMediaPlayCtrl.9(this));
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("PlayerCaptureProxy onError: module = ");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(", errorType = ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(", errorCode = ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(", extraInfo = ");
    paramISuperPlayer.append(paramString);
    QLog.e("WatchTogetherMediaPlayCtrl", 1, paramISuperPlayer.toString());
    this.d.post(new WatchTogetherMediaPlayCtrl.6(this, paramInt1, paramInt2, paramInt3, paramString));
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherMediaPlayCtrl", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), BaseVideoUtils.a(paramInt), null, null }));
    this.d.post(new WatchTogetherMediaPlayCtrl.5(this, paramInt, paramLong1, paramLong2, paramObject));
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((this.n) && (this.p != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProgressChanged progress:=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("WatchTogetherMediaPlayCtrl", 1, ((StringBuilder)localObject).toString());
      paramInt = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.p.getDurationMs());
      paramSeekBar = this.E.iterator();
      while (paramSeekBar.hasNext())
      {
        localObject = (WeakReference)paramSeekBar.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!(((WeakReference)localObject).get() instanceof WTogetherMngHelper))) {
          ((WatchTogetherMediaPlayerStatusCallback)((WeakReference)localObject).get()).a(paramInt, (int)this.p.getDurationMs());
        }
      }
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSeekComplete currentTimeMills:=");
    localStringBuilder.append(paramISuperPlayer.getCurrentPositionMs());
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.d.post(new WatchTogetherMediaPlayCtrl.8(this));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onStartTrackingTouch ");
    this.n = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onStopTrackingTouch ");
    if (this.p != null)
    {
      int i1 = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.p.getDurationMs());
      QLog.d("WatchTogetherMediaPlayCtrl", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(i1) }));
      if (this.a != 10)
      {
        b(i1);
      }
      else
      {
        this.d.removeMessages(257);
        this.d.obtainMessage(257, i1, 0, this.i).sendToTarget();
      }
    }
    this.n = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoPrepared");
    this.d.post(new WatchTogetherMediaPlayCtrl.4(this, paramISuperPlayer));
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoSizeChanged");
    this.d.post(new WatchTogetherMediaPlayCtrl.7(this, paramInt1, paramInt2));
  }
  
  public void p()
  {
    VideoAppInterface localVideoAppInterface = this.B;
    if (localVideoAppInterface != null) {
      localVideoAppInterface.a(new Object[] { Integer.valueOf(10005), Boolean.valueOf(this.x), Boolean.valueOf(this.v) });
    }
  }
  
  public boolean q()
  {
    return this.x;
  }
  
  public boolean r()
  {
    return this.v;
  }
  
  public int s()
  {
    return this.z;
  }
  
  public boolean t()
  {
    return this.w;
  }
  
  public boolean u()
  {
    return this.k == null;
  }
  
  public WatchTogetherAudioDecodeHelper v()
  {
    return this.s;
  }
  
  public int w()
  {
    int i1 = this.a;
    if (i1 == 7) {
      return (int)e() + 50;
    }
    if (i1 == 10) {
      return this.A - 50;
    }
    return 0;
  }
  
  public void x()
  {
    if (this.a == 5) {
      return;
    }
    int i1 = w();
    if (this.a == 7) {
      a(i1, false);
    }
  }
  
  public void y()
  {
    this.d.post(new WatchTogetherMediaPlayCtrl.3(this));
  }
  
  public void z()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopPlay");
    this.d.removeMessages(261);
    this.d.obtainMessage(261).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl
 * JD-Core Version:    0.7.0.1
 */