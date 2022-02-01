package com.tencent.biz.subscribe.framework;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.videostory.EventControlUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPNativeException;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import org.json.JSONObject;
import qqcircle.QQCircleReport.SingleDcData;

public abstract class BaseVideoView
  extends BaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, SimpleEventReceiver, NetworkManager.NetStatusListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private static final String O;
  public static String c = SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "key_sp_is_support_hevc");
  protected static long j;
  private SuperPlayerVideoInfo A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private long G;
  private String H;
  private String I;
  private ArrayList<QQCircleReport.SingleDcData> J = new ArrayList();
  private boolean K = false;
  private boolean L;
  private long M;
  private boolean N;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected URLImageView g;
  protected BaseVideoViewListenerSets h;
  public String i = "0";
  private boolean k;
  private Handler l;
  private ISPlayerVideoView m;
  private final int n = 1;
  private long o;
  private int p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private volatile Timer v;
  private long w;
  private List<Pair<Long, Long>> x = new LinkedList();
  private boolean y = true;
  private ISuperPlayer z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getExternalCacheDir());
    localStringBuilder.append("/superplayer/170303102");
    O = localStringBuilder.toString();
  }
  
  public BaseVideoView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static SuperPlayerVideoInfo a(String paramString1, String paramString2)
  {
    if ((!StringUtil.isEmpty(paramString1)) && ((paramString2 == null) || (a(paramString2)))) {
      return SuperPlayerFactory.createVideoInfoForTVideo(30301, paramString1);
    }
    if (!StringUtil.isEmpty(paramString2))
    {
      paramString1 = b(paramString2, paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createSuperVideoInfo fileId:");
      localStringBuilder.append(paramString1);
      QLog.i("BaseVideoView", 1, localStringBuilder.toString());
      return SuperPlayerFactory.createVideoInfoForUrl(paramString2, 101, paramString1, "");
    }
    return null;
  }
  
  private void a(TPPlayerMsg.TPCDNURLInfo paramTPCDNURLInfo)
  {
    this.H = paramTPCDNURLInfo.cdnIp;
    this.I = paramTPCDNURLInfo.uIp;
  }
  
  private void a(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    b(paramTPDownLoadProgressInfo.extraInfo);
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      String[] arrayOfString = ((String)VSConfigManager.a().a("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        boolean bool = paramString.startsWith(arrayOfString[i1]);
        if (bool) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Uri.parse(paramString1).getPathSegments().get(0);
      if (paramString1.contains(".mp4"))
      {
        paramString1 = paramString1.substring(0, paramString1.indexOf(".mp4"));
        return paramString1;
      }
      return paramString2;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("hitDownloaded"))
        {
          int i1 = paramString.getInt("hitDownloaded");
          bool = true;
          if (i1 != 1) {
            break label91;
          }
          this.F = bool;
        }
        if (paramString.has("localCacheSize")) {
          this.G = paramString.getLong("localCacheSize");
        }
        if (paramString.has("httpAvgSpeedKB"))
        {
          this.M = paramString.getLong("httpAvgSpeedKB");
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label91:
      boolean bool = false;
    }
  }
  
  private void c(long paramLong1, long paramLong2)
  {
    if (n()) {
      return;
    }
    Object localObject = this.x.iterator();
    Pair localPair;
    while (((Iterator)localObject).hasNext())
    {
      localPair = (Pair)((Iterator)localObject).next();
      if ((((Long)localPair.first).longValue() <= paramLong1) && (((Long)localPair.second).longValue() >= paramLong2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addToVideoSoloPlayTimeRangeList: already contained [start=");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(", end=");
        ((StringBuilder)localObject).append(paramLong2);
        ((StringBuilder)localObject).append("]");
        QLog.d("BaseVideoView", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    localObject = this.x.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPair = (Pair)((Iterator)localObject).next();
      if ((paramLong1 <= ((Long)localPair.first).longValue()) && (paramLong2 >= ((Long)localPair.second).longValue()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addToVideoSoloPlayTimeRangeList: remove [start=");
        localStringBuilder.append(localPair.first);
        localStringBuilder.append(", end=");
        localStringBuilder.append(localPair.second);
        localStringBuilder.append("]");
        QLog.d("BaseVideoView", 1, localStringBuilder.toString());
        ((Iterator)localObject).remove();
      }
    }
    localObject = this.x.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPair = (Pair)((Iterator)localObject).next();
      long l1 = paramLong1;
      if (paramLong1 >= ((Long)localPair.first).longValue())
      {
        l1 = paramLong1;
        if (paramLong1 <= ((Long)localPair.second).longValue()) {
          l1 = ((Long)localPair.second).longValue();
        }
      }
      paramLong1 = l1;
      if (paramLong2 >= ((Long)localPair.first).longValue())
      {
        paramLong1 = l1;
        if (paramLong2 <= ((Long)localPair.second).longValue())
        {
          paramLong2 = ((Long)localPair.first).longValue();
          paramLong1 = l1;
        }
      }
    }
    if ((paramLong1 >= 0L) && (paramLong1 <= paramLong2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", end=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("]");
      QLog.d("BaseVideoView", 1, ((StringBuilder)localObject).toString());
      this.x.add(new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", end=");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("]");
    QLog.d("BaseVideoView", 1, ((StringBuilder)localObject).toString());
  }
  
  private long getAverageDownloadSpeeds()
  {
    return this.M;
  }
  
  private long getVideoSoloPlayTime()
  {
    Iterator localIterator = this.x.iterator();
    Pair localPair;
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((Long)localPair.second).longValue() - ((Long)localPair.first).longValue()) {
      localPair = (Pair)localIterator.next();
    }
    return l1;
  }
  
  private void p()
  {
    if (getProgressBar() != null) {
      getProgressBar().setOnSeekBarChangeListener(this);
    }
  }
  
  private void q()
  {
    if ((getSuperPlayer() != null) && (!this.B))
    {
      addView((View)this.m, 0, new FrameLayout.LayoutParams(-1, -1));
      if (!this.C)
      {
        URLImageView localURLImageView = this.g;
        if (localURLImageView != null) {
          addView(localURLImageView);
        }
      }
      this.B = true;
    }
  }
  
  private void r()
  {
    getSuperPlayer().reset();
    getSuperPlayer().setLoopback(this.D);
    getSuperPlayer().updatePlayerVideoView(this.m);
    getSuperPlayer().setOutputMute(this.E);
  }
  
  private void s()
  {
    this.N = true;
    if (getAverageDownloadSpeeds() == 0L) {
      this.F = true;
    } else {
      j = this.M;
    }
    QLog.d("BaseVideoView", 1, String.format("DownloadComplete  DownLoadSpeed:%d kb/s", new Object[] { Long.valueOf(getAverageDownloadSpeeds()) }));
  }
  
  public void a()
  {
    if (!QQVideoPlaySDKManager.isSDKReady())
    {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new BaseVideoView.1(this));
      return;
    }
    getSuperPlayer();
  }
  
  protected abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public void a(long paramLong)
  {
    try
    {
      if (getSuperPlayer() != null)
      {
        long l2 = getSuperPlayer().getDurationMs();
        long l1 = paramLong;
        if (paramLong > l2)
        {
          l1 = paramLong;
          if (l2 != 0L)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("seek over position=");
            localStringBuilder.append(paramLong);
            localStringBuilder.append("duration=");
            localStringBuilder.append(l2);
            QLog.d("BaseVideoView", 1, localStringBuilder.toString());
            l1 = l2;
          }
        }
        paramLong = l1;
        if (l1 < 0L)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("seek invalid position=");
          localStringBuilder.append(l1);
          localStringBuilder.append("duration=");
          localStringBuilder.append(getSuperPlayer().getDurationMs());
          QLog.d("BaseVideoView", 1, localStringBuilder.toString());
          paramLong = 0L;
        }
        getSuperPlayer().seekTo((int)paramLong, 3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seek position=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("duration=");
        localStringBuilder.append(getSuperPlayer().getDurationMs());
        QLog.d("BaseVideoView", 1, localStringBuilder.toString());
        this.k = true;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected abstract void a(long paramLong1, long paramLong2);
  
  protected void a(Context paramContext, int paramInt)
  {
    super.a(paramContext, paramInt);
    this.B = false;
    a();
    this.g = new URLImageView(getContext());
    this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    q();
    NetworkManager.registNetStatusListener(this);
  }
  
  protected void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo) {}
  
  protected void b()
  {
    if ((getSuperPlayer() != null) && (getSuperPlayer().isPlaying())) {
      i();
    }
    this.F = false;
    this.A = null;
    this.k = false;
    this.o = 0L;
    this.p = 0;
    this.q = 0L;
    this.i = "0";
    this.N = false;
    this.M = 0L;
    this.G = 0L;
    this.H = null;
    this.I = null;
    if (this.v != null) {
      this.v.cancel();
    }
    getMainHandler().removeCallbacksAndMessages(null);
    getMainHandler().post(new BaseVideoView.2(this));
  }
  
  protected abstract void b(long paramLong1, long paramLong2);
  
  protected void b(Context paramContext, int paramInt)
  {
    p();
  }
  
  protected void c()
  {
    URLImageView localURLImageView = this.g;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(0);
    }
  }
  
  protected void d()
  {
    URLImageView localURLImageView = this.g;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(8);
    }
  }
  
  public void e()
  {
    if ((getSuperPlayer() != null) && (!getSuperPlayer().isPlaying()))
    {
      setInterrupt(false);
      if ((this.d) && (this.w > 0L))
      {
        this.s += System.currentTimeMillis() - this.w;
        this.w = 0L;
      }
      else if (!this.y)
      {
        c(this.u, getSuperPlayer().getDurationMs());
      }
      if ((!this.d) && (this.y))
      {
        this.s = System.currentTimeMillis();
        this.u = getSuperPlayer().getCurrentPositionMs();
      }
      getSuperPlayer().start();
      this.d = false;
      this.y = false;
      k();
      m();
    }
  }
  
  public void g()
  {
    this.y = true;
    if (getSuperPlayer() != null)
    {
      getSuperPlayer().stop();
      getSuperPlayer().release();
    }
    this.d = false;
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    NetworkManager.unregistNetStatusListener(this);
    if (getProgressBar() != null)
    {
      getProgressBar().setProgress(0);
      getProgressBar().setOnSeekBarChangeListener(null);
    }
    if (this.v != null) {
      this.v.cancel();
    }
    this.g = null;
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public long getBufferBeginTime()
  {
    return this.o;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public Handler getMainHandler()
  {
    if (this.l == null) {
      this.l = new Handler(Looper.getMainLooper(), this);
    }
    return this.l;
  }
  
  public boolean getOutPutMute()
  {
    if (getSuperPlayer() != null) {
      return getSuperPlayer().isOutputMute();
    }
    return false;
  }
  
  public ISPlayerVideoView getPlayerVideoView()
  {
    return this.m;
  }
  
  public abstract SeekBar getProgressBar();
  
  public int getSecondBufferCount()
  {
    return this.p;
  }
  
  public long getSecondBufferTime()
  {
    return this.q;
  }
  
  public long getStartPreparedTime()
  {
    return this.r;
  }
  
  public ISuperPlayer getSuperPlayer()
  {
    if (this.z == null) {
      if (VideoPlaySDKManager.getInstance().isSDKReady())
      {
        this.m = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
        this.z = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, this.m);
        this.z.setOnVideoPreparedListener(this);
        this.z.setOnErrorListener(this);
        this.z.setOnInfoListener(this);
        this.z.setOnCompletionListener(this);
        this.z.setOnSeekCompleteListener(this);
        this.z.setOnInfoListener(this);
        this.K = (SharePreferenceUtils.a(getContext(), "key_sp_is_detect_hevc").equals("") ^ true);
        if (!this.K)
        {
          try
          {
            c = String.valueOf(TPCapability.getThumbPlayerVCodecTypeMaxCapability(172, 102).getMaxLevel());
          }
          catch (TPNativeException localTPNativeException)
          {
            QLog.e("BaseVideoView", 1, "getThumbPlayerVCodecTypeMaxCapability() error,", localTPNativeException);
          }
          SharePreferenceUtils.a(getContext(), "key_sp_is_detect_hevc", "1");
          SharePreferenceUtils.a(getContext(), "key_sp_is_support_hevc", c);
          QLog.i("BaseVideoView", 1, "this phone is support hevc");
        }
      }
      else
      {
        QLog.w("BaseVideoView", 1, "SuperPlayer is not installed");
      }
    }
    return this.z;
  }
  
  public URLImageView getVideoCover()
  {
    return this.g;
  }
  
  public void h()
  {
    if ((getSuperPlayer() != null) && (getSuperPlayer().isPlaying()))
    {
      getSuperPlayer().pause();
      this.d = true;
      c(this.u, getSuperPlayer().getCurrentPositionMs());
      b(System.currentTimeMillis() - this.s, getVideoSoloPlayTime());
      this.w = System.currentTimeMillis();
    }
  }
  
  public void i()
  {
    this.y = true;
    if (getSuperPlayer() != null) {
      getSuperPlayer().stop();
    }
    this.d = false;
    if (this.v != null)
    {
      this.v.cancel();
      this.v = null;
    }
  }
  
  public void j()
  {
    if (getSuperPlayer() != null)
    {
      getSuperPlayer().stop();
      this.d = false;
      SuperPlayerVideoInfo localSuperPlayerVideoInfo = this.A;
      if (localSuperPlayerVideoInfo != null) {
        setVideoPath(localSuperPlayerVideoInfo.getVid(), this.A.getPlayUrl(), 0);
      }
    }
  }
  
  public void k()
  {
    if (this.v != null)
    {
      this.v.cancel();
      this.v.purge();
    }
    this.v = new Timer();
    this.v.schedule(new BaseVideoView.TimeUpdateTimerTask(this), 0L, 33L);
  }
  
  @CallSuper
  protected void l()
  {
    if (getSuperPlayer() != null)
    {
      double d1 = getSuperPlayer().getCurrentPositionMs();
      float f1 = (float)getSuperPlayer().getDurationMs();
      if ((!this.f) && (d1 != 0.0D))
      {
        if (this.d) {
          return;
        }
        Message localMessage = Message.obtain();
        localMessage.what = -1001;
        localMessage.arg1 = ((int)d1);
        localMessage.arg2 = ((int)f1);
        localMessage.obj = Boolean.valueOf(true);
        getMainHandler().sendMessage(localMessage);
        getMainHandler().post(new BaseVideoView.7(this, f1, d1));
      }
    }
  }
  
  protected abstract void m();
  
  protected boolean n()
  {
    QLog.w("BaseVideoView", 1, "biz has cancel perf report");
    return false;
  }
  
  protected boolean o()
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.L = false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getHandler().removeCallbacksAndMessages(null);
    this.L = true;
    g();
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("BaseVideoView", 1, String.format("module:%d, errorType:%d, errorCode:%d, extraInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    a(paramInt3, paramInt1, 0L, 0L);
    if ((String.valueOf(paramInt3).startsWith("140")) || (String.valueOf(paramInt3).startsWith("160"))) {
      this.i = String.valueOf(paramInt3);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    int i1 = hashCode();
    String str2 = BaseVideoUtils.a(paramInt);
    String str1 = "";
    if (paramObject == null) {
      paramISuperPlayer = "";
    } else {
      paramISuperPlayer = paramObject.toString();
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = this.A;
    if (localSuperPlayerVideoInfo != null) {
      str1 = localSuperPlayerVideoInfo.getPlayUrl();
    }
    QLog.i("BaseVideoView", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(i1), str2, paramISuperPlayer, str1 }));
    if (paramInt != 105)
    {
      if (paramInt != 201)
      {
        if (paramInt != 204)
        {
          if (paramInt != 207)
          {
            if (paramInt != 112)
            {
              if (paramInt != 113) {
                return false;
              }
              if (!this.k)
              {
                this.p += 1;
                this.q += System.currentTimeMillis() - this.o;
                a(this.A);
                QLog.i("BaseVideoView", 1, String.format("PLAYER_INFO_BUFFERING_END mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.p), Long.valueOf(this.q) }));
                return false;
              }
            }
            else
            {
              this.o = System.currentTimeMillis();
              return false;
            }
          }
          else if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
          {
            a((TPPlayerMsg.TPDownLoadProgressInfo)paramObject);
            return false;
          }
        }
        else if ((paramObject instanceof TPPlayerMsg.TPCDNURLInfo))
        {
          paramISuperPlayer = (TPPlayerMsg.TPCDNURLInfo)paramObject;
          a(paramISuperPlayer);
          QLog.i("BaseVideoView", 1, String.format("hashCode:%d,TPPlayerMsg.TPCDNURLInfo:cdnIp:%s, errStr:%s, ip:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), paramISuperPlayer.cdnIp, paramISuperPlayer.errorStr, paramISuperPlayer.uIp, paramISuperPlayer.url }));
          return false;
        }
      }
      else
      {
        s();
        return false;
      }
    }
    else {
      getMainHandler().post(new BaseVideoView.4(this));
    }
    return false;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.f) {
      EventControlUtils.a("setSeekBar", 100L, new BaseVideoView.6(this, paramSeekBar));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.k = false;
    if (this.t > 0L)
    {
      this.s += System.currentTimeMillis() - this.t;
      this.t = 0L;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.f = true;
    this.t = System.currentTimeMillis();
    long l1 = System.currentTimeMillis();
    long l2 = this.s;
    if (getSuperPlayer() != null)
    {
      c(this.u, getSuperPlayer().getCurrentPositionMs());
      a(l1 - l2, getVideoSoloPlayTime());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (getSuperPlayer() != null)
    {
      int i1 = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)getSuperPlayer().getDurationMs());
      long l1 = i1;
      this.u = l1;
      QLog.d("BaseVideoView", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(i1) }));
      a(l1);
    }
    this.f = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    getMainHandler().post(new BaseVideoView.5(this));
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void setBaseVideoViewListenerSets(BaseVideoViewListenerSets paramBaseVideoViewListenerSets)
  {
    this.h = paramBaseVideoViewListenerSets;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    this.D = paramBoolean;
    if (getSuperPlayer() != null) {
      getSuperPlayer().setLoopback(paramBoolean);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    this.E = paramBoolean;
    if (getSuperPlayer() != null) {
      getSuperPlayer().setOutputMute(paramBoolean);
    }
  }
  
  public void setVideoCover(URLImageView paramURLImageView)
  {
    if (paramURLImageView != null)
    {
      URLImageView localURLImageView = this.g;
      if (localURLImageView != null) {
        removeView(localURLImageView);
      }
      this.C = true;
      this.g = paramURLImageView;
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("BaseVideoView", 1, "set Final VideoPath success");
    b();
    this.A = a(paramString1, paramString2);
    if ((getSuperPlayer() != null) && (this.A != null))
    {
      r();
      paramString1 = SuperPlayerOption.obtain();
      paramString1.accurateSeekOnOpen = true;
      getSuperPlayer().openMediaPlayer(getContext(), this.A, paramInt, paramString1);
      this.r = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */