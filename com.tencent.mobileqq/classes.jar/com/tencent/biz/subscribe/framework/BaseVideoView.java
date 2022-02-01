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
import com.tencent.biz.richframework.delegate.impl.RFLog;
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
  protected static long a;
  public static String a;
  private static final String jdField_e_of_type_JavaLangString;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected BaseVideoViewListenerSets a;
  protected URLImageView a;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private SuperPlayerVideoInfo jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  private ArrayList<QQCircleReport.SingleDcData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<Pair<Long, Long>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private volatile Timer jdField_a_of_type_JavaUtilTimer;
  protected boolean a;
  private long b;
  public String b;
  protected boolean b;
  private final int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  protected boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean = true;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private long jdField_j_of_type_Long;
  private boolean jdField_j_of_type_Boolean;
  private boolean k = false;
  private boolean l;
  private boolean m;
  
  static
  {
    jdField_a_of_type_JavaLangString = SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "key_sp_is_support_hevc");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getExternalCacheDir());
    localStringBuilder.append("/superplayer/170303102");
    jdField_e_of_type_JavaLangString = localStringBuilder.toString();
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
    this.jdField_b_of_type_JavaLangString = "0";
  }
  
  public static SuperPlayerVideoInfo a(String paramString1, String paramString2)
  {
    if ((!StringUtil.a(paramString1)) && ((paramString2 == null) || (a(paramString2)))) {
      return SuperPlayerFactory.createVideoInfoForTVideo(30301, paramString1);
    }
    if (!StringUtil.a(paramString2))
    {
      paramString1 = a(paramString2, paramString1);
      int n = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createSuperVideoInfo fileId:");
      localStringBuilder.append(paramString1);
      RFLog.i("BaseVideoView", n, localStringBuilder.toString());
      return SuperPlayerFactory.createVideoInfoForUrl(paramString2, 101, paramString1, "");
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
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
  
  private void a(TPPlayerMsg.TPCDNURLInfo paramTPCDNURLInfo)
  {
    this.jdField_c_of_type_JavaLangString = paramTPCDNURLInfo.cdnIp;
    this.jdField_d_of_type_JavaLangString = paramTPCDNURLInfo.uIp;
  }
  
  private void a(TPPlayerMsg.TPDownLoadProgressInfo paramTPDownLoadProgressInfo)
  {
    a(paramTPDownLoadProgressInfo.extraInfo);
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("hitDownloaded"))
        {
          int n = paramString.getInt("hitDownloaded");
          bool = true;
          if (n != 1) {
            break label85;
          }
          this.jdField_j_of_type_Boolean = bool;
        }
        if (paramString.has("localCacheSize")) {
          this.jdField_i_of_type_Long = paramString.getLong("localCacheSize");
        }
        if (paramString.has("httpAvgSpeedKB"))
        {
          this.jdField_j_of_type_Long = paramString.getLong("httpAvgSpeedKB");
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label85:
      boolean bool = false;
    }
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      String[] arrayOfString = ((String)VSConfigManager.a().a("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
      int i1 = arrayOfString.length;
      int n = 0;
      while (n < i1)
      {
        boolean bool = paramString.startsWith(arrayOfString[n]);
        if (bool) {
          return true;
        }
        n += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private long b()
  {
    return this.jdField_j_of_type_Long;
  }
  
  private long c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Pair localPair;
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((Long)localPair.second).longValue() - ((Long)localPair.first).longValue()) {
      localPair = (Pair)localIterator.next();
    }
    return l1;
  }
  
  private void c(long paramLong1, long paramLong2)
  {
    if (a()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    Pair localPair;
    while (((Iterator)localObject).hasNext())
    {
      localPair = (Pair)((Iterator)localObject).next();
      if ((((Long)localPair.first).longValue() <= paramLong1) && (((Long)localPair.second).longValue() >= paramLong2))
      {
        n = RFLog.USR;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addToVideoSoloPlayTimeRangeList: already contained [start=");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(", end=");
        ((StringBuilder)localObject).append(paramLong2);
        ((StringBuilder)localObject).append("]");
        RFLog.d("BaseVideoView", n, ((StringBuilder)localObject).toString());
        return;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPair = (Pair)((Iterator)localObject).next();
      if ((paramLong1 <= ((Long)localPair.first).longValue()) && (paramLong2 >= ((Long)localPair.second).longValue()))
      {
        n = RFLog.USR;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addToVideoSoloPlayTimeRangeList: remove [start=");
        localStringBuilder.append(localPair.first);
        localStringBuilder.append(", end=");
        localStringBuilder.append(localPair.second);
        localStringBuilder.append("]");
        RFLog.d("BaseVideoView", n, localStringBuilder.toString());
        ((Iterator)localObject).remove();
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
      n = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", end=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("]");
      RFLog.d("BaseVideoView", n, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_JavaUtilList.add(new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
      return;
    }
    int n = RFLog.USR;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", end=");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("]");
    RFLog.d("BaseVideoView", n, ((StringBuilder)localObject).toString());
  }
  
  private void m()
  {
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
  }
  
  private void n()
  {
    if ((a() != null) && (!this.jdField_f_of_type_Boolean))
    {
      addView((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView, 0, new FrameLayout.LayoutParams(-1, -1));
      if (!this.jdField_g_of_type_Boolean)
      {
        URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
        if (localURLImageView != null) {
          addView(localURLImageView);
        }
      }
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  private void o()
  {
    a().reset();
    a().setLoopback(this.jdField_h_of_type_Boolean);
    a().updatePlayerVideoView(this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
    a().setOutputMute(this.jdField_i_of_type_Boolean);
  }
  
  private void p()
  {
    this.m = true;
    if (b() == 0L) {
      this.jdField_j_of_type_Boolean = true;
    } else {
      jdField_a_of_type_Long = this.jdField_j_of_type_Long;
    }
    RFLog.d("BaseVideoView", RFLog.USR, String.format("DownloadComplete  DownLoadSpeed:%d kb/s", new Object[] { Long.valueOf(b()) }));
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public abstract SeekBar a();
  
  public ISuperPlayer a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      if (VideoPlaySDKManager.getInstance().isSDKReady())
      {
        this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
        this.k = (SharePreferenceUtils.a(getContext(), "key_sp_is_detect_hevc").equals("") ^ true);
        if (!this.k)
        {
          try
          {
            jdField_a_of_type_JavaLangString = String.valueOf(TPCapability.getThumbPlayerVCodecTypeMaxCapability(172, 102).getMaxLevel());
          }
          catch (TPNativeException localTPNativeException)
          {
            RFLog.e("BaseVideoView", RFLog.USR, new Object[] { "getThumbPlayerVCodecTypeMaxCapability() error,", localTPNativeException });
          }
          SharePreferenceUtils.a(getContext(), "key_sp_is_detect_hevc", "1");
          SharePreferenceUtils.a(getContext(), "key_sp_is_support_hevc", jdField_a_of_type_JavaLangString);
          RFLog.i("BaseVideoView", RFLog.USR, "this phone is support hevc");
        }
      }
      else
      {
        RFLog.w("BaseVideoView", RFLog.USR, "SuperPlayer is not installed");
      }
    }
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  }
  
  public ISPlayerVideoView a()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  }
  
  public void a()
  {
    if (!QQVideoPlaySDKManager.a())
    {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), new BaseVideoView.1(this));
      return;
    }
    a();
  }
  
  protected abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public void a(long paramLong)
  {
    try
    {
      if (a() != null)
      {
        long l2 = a().getDurationMs();
        long l1 = paramLong;
        if (paramLong > l2)
        {
          l1 = paramLong;
          if (l2 != 0L)
          {
            n = RFLog.USR;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("seek over position=");
            localStringBuilder.append(paramLong);
            localStringBuilder.append("duration=");
            localStringBuilder.append(l2);
            RFLog.d("BaseVideoView", n, localStringBuilder.toString());
            l1 = l2;
          }
        }
        paramLong = l1;
        if (l1 < 0L)
        {
          n = RFLog.USR;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("seek invalid position=");
          localStringBuilder.append(l1);
          localStringBuilder.append("duration=");
          localStringBuilder.append(a().getDurationMs());
          RFLog.d("BaseVideoView", n, localStringBuilder.toString());
          paramLong = 0L;
        }
        a().seekTo((int)paramLong, 3);
        int n = RFLog.USR;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seek position=");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("duration=");
        localStringBuilder.append(a().getDurationMs());
        RFLog.d("BaseVideoView", n, localStringBuilder.toString());
        this.jdField_d_of_type_Boolean = true;
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
    this.jdField_f_of_type_Boolean = false;
    a();
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    n();
    NetworkManager.registNetStatusListener(this);
  }
  
  protected void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo) {}
  
  protected boolean a()
  {
    RFLog.w("BaseVideoView", RFLog.USR, "biz has cancel perf report");
    return false;
  }
  
  public void b()
  {
    this.jdField_e_of_type_Boolean = true;
    if (a() != null)
    {
      a().stop();
      a().release();
    }
    this.jdField_a_of_type_Boolean = false;
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    NetworkManager.unregistNetStatusListener(this);
    if (a() != null)
    {
      a().setProgress(0);
      a().setOnSeekBarChangeListener(null);
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = null;
    a().removeCallbacksAndMessages(null);
  }
  
  protected abstract void b(long paramLong1, long paramLong2);
  
  protected void b(Context paramContext, int paramInt)
  {
    m();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  protected void c()
  {
    if ((a() != null) && (a().isPlaying())) {
      h();
    }
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "0";
    this.m = false;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    a().removeCallbacksAndMessages(null);
    a().post(new BaseVideoView.2(this));
  }
  
  protected void d()
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(0);
    }
  }
  
  protected void e()
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localURLImageView != null) {
      localURLImageView.setVisibility(8);
    }
  }
  
  public void f()
  {
    if ((a() != null) && (!a().isPlaying()))
    {
      setInterrupt(false);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_h_of_type_Long > 0L))
      {
        this.jdField_e_of_type_Long += System.currentTimeMillis() - this.jdField_h_of_type_Long;
        this.jdField_h_of_type_Long = 0L;
      }
      else if (!this.jdField_e_of_type_Boolean)
      {
        c(this.jdField_g_of_type_Long, a().getDurationMs());
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        this.jdField_e_of_type_Long = System.currentTimeMillis();
        this.jdField_g_of_type_Long = a().getCurrentPositionMs();
      }
      a().start();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      j();
      l();
    }
  }
  
  public void g()
  {
    if ((a() != null) && (a().isPlaying()))
    {
      a().pause();
      this.jdField_a_of_type_Boolean = true;
      c(this.jdField_g_of_type_Long, a().getCurrentPositionMs());
      b(System.currentTimeMillis() - this.jdField_e_of_type_Long, c());
      this.jdField_h_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void h()
  {
    this.jdField_e_of_type_Boolean = true;
    if (a() != null) {
      a().stop();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void i()
  {
    if (a() != null)
    {
      a().stop();
      this.jdField_a_of_type_Boolean = false;
      SuperPlayerVideoInfo localSuperPlayerVideoInfo = this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
      if (localSuperPlayerVideoInfo != null) {
        setVideoPath(localSuperPlayerVideoInfo.getVid(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.getPlayUrl(), 0);
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new BaseVideoView.TimeUpdateTimerTask(this), 0L, 33L);
  }
  
  @CallSuper
  protected void k()
  {
    if (a() != null)
    {
      double d1 = a().getCurrentPositionMs();
      float f1 = (float)a().getDurationMs();
      if ((!this.jdField_c_of_type_Boolean) && (d1 != 0.0D))
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        Message localMessage = Message.obtain();
        localMessage.what = -1001;
        localMessage.arg1 = ((int)d1);
        localMessage.arg2 = ((int)f1);
        localMessage.obj = Boolean.valueOf(true);
        a().sendMessage(localMessage);
        a().post(new BaseVideoView.7(this, f1, d1));
      }
    }
  }
  
  protected abstract void l();
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.l = false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getHandler().removeCallbacksAndMessages(null);
    this.l = true;
    b();
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = String.format("module:%d, errorType:%d, errorCode:%d, extraInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    RFLog.e("BaseVideoView", RFLog.USR, paramISuperPlayer);
    a(paramInt3, paramInt1, 0L, 0L);
    if ((String.valueOf(paramInt3).startsWith("140")) || (String.valueOf(paramInt3).startsWith("160"))) {
      this.jdField_b_of_type_JavaLangString = String.valueOf(paramInt3);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    int n = RFLog.USR;
    int i1 = hashCode();
    String str2 = BaseVideoUtils.a(paramInt);
    String str1 = "";
    if (paramObject == null) {
      paramISuperPlayer = "";
    } else {
      paramISuperPlayer = paramObject.toString();
    }
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
    if (localSuperPlayerVideoInfo != null) {
      str1 = localSuperPlayerVideoInfo.getPlayUrl();
    }
    RFLog.i("BaseVideoView", n, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(i1), str2, paramISuperPlayer, str1 }));
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
              if (!this.jdField_d_of_type_Boolean)
              {
                this.jdField_d_of_type_Int += 1;
                this.jdField_c_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
                a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
                RFLog.i("BaseVideoView", RFLog.USR, String.format("PLAYER_INFO_BUFFERING_END mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Long.valueOf(this.jdField_c_of_type_Long) }));
                return false;
              }
            }
            else
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
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
          RFLog.i("BaseVideoView", RFLog.USR, String.format("hashCode:%d,TPPlayerMsg.TPCDNURLInfo:cdnIp:%s, errStr:%s, ip:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), paramISuperPlayer.cdnIp, paramISuperPlayer.errorStr, paramISuperPlayer.uIp, paramISuperPlayer.url }));
          return false;
        }
      }
      else
      {
        p();
        return false;
      }
    }
    else {
      a().post(new BaseVideoView.4(this));
    }
    return false;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      EventControlUtils.a("setSeekBar", 100L, new BaseVideoView.6(this, paramSeekBar));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_f_of_type_Long > 0L)
    {
      this.jdField_e_of_type_Long += System.currentTimeMillis() - this.jdField_f_of_type_Long;
      this.jdField_f_of_type_Long = 0L;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    if (a() != null)
    {
      c(this.jdField_g_of_type_Long, a().getCurrentPositionMs());
      a(l1 - l2, c());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (a() != null)
    {
      int n = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)a().getDurationMs());
      long l1 = n;
      this.jdField_g_of_type_Long = l1;
      RFLog.d("BaseVideoView", RFLog.USR, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(n) }));
      a(l1);
    }
    this.jdField_c_of_type_Boolean = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    a().post(new BaseVideoView.5(this));
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void setBaseVideoViewListenerSets(BaseVideoViewListenerSets paramBaseVideoViewListenerSets)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoViewListenerSets = paramBaseVideoViewListenerSets;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().setLoopback(paramBoolean);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().setOutputMute(paramBoolean);
    }
  }
  
  public void setVideoCover(URLImageView paramURLImageView)
  {
    if (paramURLImageView != null)
    {
      URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localURLImageView != null) {
        removeView(localURLImageView);
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentImageURLImageView = paramURLImageView;
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    RFLog.i("BaseVideoView", RFLog.USR, "set Final VideoPath success");
    c();
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = a(paramString1, paramString2);
    if ((a() != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null))
    {
      o();
      paramString1 = SuperPlayerOption.obtain();
      paramString1.accurateSeekOnOpen = true;
      a().openMediaPlayer(getContext(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, paramInt, paramString1);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */