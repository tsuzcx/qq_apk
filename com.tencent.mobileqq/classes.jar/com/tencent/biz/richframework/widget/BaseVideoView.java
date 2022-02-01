package com.tencent.biz.richframework.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import azjl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import org.json.JSONObject;
import qqcircle.QQCircleReport.SingleDcData;
import zat;
import zaw;
import zax;
import zay;
import zaz;
import zvm;

public abstract class BaseVideoView
  extends BaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, SimpleEventReceiver, NetworkManager.NetStatusListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  public static String a;
  protected static long b;
  private static final String jdField_e_of_type_JavaLangString = BaseApplicationImpl.getContext().getExternalCacheDir() + "/superplayer/170303102";
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected URLImageView a;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private SuperPlayerVideoInfo jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  private ArrayList<QQCircleReport.SingleDcData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<Pair<Long, Long>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private volatile Timer jdField_a_of_type_JavaUtilTimer;
  public zaz a;
  public boolean a;
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
  private long jdField_k_of_type_Long;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  
  static
  {
    jdField_a_of_type_JavaLangString = SharePreferenceUtils.get(BaseApplicationImpl.getContext(), "key_sp_is_support_hevc");
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
    if ((!StringUtil.isEmpty(paramString1)) && ((paramString2 == null) || (a(paramString2)))) {
      return SuperPlayerFactory.createVideoInfoForTVideo(30301, paramString1);
    }
    if (!StringUtil.isEmpty(paramString2))
    {
      paramString1 = a(paramString2, paramString1);
      QLog.i("BaseVideoView", 1, "createSuperVideoInfo fileId:" + paramString1);
      return SuperPlayerFactory.createVideoInfoForUrl(paramString2, 101, paramString1, "");
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = (String)Uri.parse(paramString1).getPathSegments().get(0);
      paramString1 = paramString2;
      if (str.contains(".mp4")) {
        paramString1 = str.substring(0, str.indexOf(".mp4"));
      }
      return paramString1;
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
    boolean bool = true;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("hitDownloaded")) {
        if (paramString.getInt("hitDownloaded") != 1) {
          break label74;
        }
      }
      for (;;)
      {
        this.jdField_j_of_type_Boolean = bool;
        if (paramString.has("localCacheSize")) {
          this.jdField_j_of_type_Long = paramString.getLong("localCacheSize");
        }
        if (paramString.has("httpAvgSpeedKB")) {
          this.jdField_k_of_type_Long = paramString.getLong("httpAvgSpeedKB");
        }
        return;
        label74:
        bool = false;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      String[] arrayOfString = ((String)VSConfigManager.getInstance().getValue("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
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
    return this.jdField_k_of_type_Long;
  }
  
  private long c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Pair localPair;
    for (long l1 = 0L; localIterator.hasNext(); l1 = ((Long)localPair.second).longValue() - ((Long)localPair.first).longValue() + l1) {
      localPair = (Pair)localIterator.next();
    }
    return l1;
  }
  
  private void c(long paramLong1, long paramLong2)
  {
    if (b()) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Pair localPair;
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if ((((Long)localPair.first).longValue() <= paramLong1) && (((Long)localPair.second).longValue() >= paramLong2))
      {
        QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained [start=" + paramLong1 + ", end=" + paramLong2 + "]");
        return;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if ((paramLong1 <= ((Long)localPair.first).longValue()) && (paramLong2 >= ((Long)localPair.second).longValue()))
      {
        QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: remove [start=" + localPair.first + ", end=" + localPair.second + "]");
        localIterator.remove();
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
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
    if ((paramLong1 < 0L) || (paramLong1 > paramLong2))
    {
      QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + paramLong1 + ", end=" + paramLong2 + "]");
      return;
    }
    QLog.d("BaseVideoView", 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + paramLong1 + ", end=" + paramLong2 + "]");
    this.jdField_a_of_type_JavaUtilList.add(new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
  }
  
  private void n()
  {
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
  }
  
  private void o()
  {
    if ((a() != null) && (!this.jdField_f_of_type_Boolean))
    {
      addView((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView, 0, new FrameLayout.LayoutParams(-1, -1));
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentImageURLImageView != null)) {
        addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      }
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  private void p()
  {
    a().reset();
    a().setLoopback(this.jdField_h_of_type_Boolean);
    a().updatePlayerVideoView(this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
    a().setOutputMute(this.jdField_i_of_type_Boolean);
  }
  
  private void q()
  {
    this.m = true;
    if (b() == 0L) {
      this.jdField_j_of_type_Boolean = true;
    }
    for (;;)
    {
      QLog.d("BaseVideoView", 1, String.format("DownloadComplete  DownLoadSpeed:%d kb/s", new Object[] { Long.valueOf(b()) }));
      return;
      jdField_b_of_type_Long = this.jdField_k_of_type_Long;
    }
  }
  
  private void r()
  {
    String str;
    if (this.jdField_f_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
      c(this.jdField_h_of_type_Long, a().getCurrentPositionMs());
      a(0, 0, l1, c());
      this.jdField_f_of_type_Long = 0L;
      this.jdField_h_of_type_Long = 0L;
      if (a() != null)
      {
        double d1 = a().getDurationMs();
        d1 = Math.min(100.0D, l1 / d1 * 100.0D);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(QCircleReportHelper.newEntry("ret_code", "0"));
        localArrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)l1 / 1000.0F)));
        str = "";
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          localArrayList.add(QCircleReportHelper.newEntry("server_ip", this.jdField_c_of_type_JavaLangString));
          str = "" + "cdnIp:" + this.jdField_c_of_type_JavaLangString;
        }
        Object localObject = str;
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          localObject = str + ",ip:" + this.jdField_d_of_type_JavaLangString;
        }
        localArrayList.add(QCircleReportHelper.newEntry("attach_info", (String)localObject));
        a(this.jdField_a_of_type_Long, "video_play_ret", a(), localArrayList);
        long l2 = this.jdField_a_of_type_Long;
        localObject = a();
        if (!a()) {
          break label530;
        }
        str = "1";
        a(l2, "video_play_cache", localObject, Collections.singletonList(QCircleReportHelper.newEntry("ret_code", str)));
        a(this.jdField_a_of_type_Long, "video_download_avg_speed", a(), Collections.singletonList(QCircleReportHelper.newEntry("attach_info", String.valueOf(b()))));
        a(this.jdField_a_of_type_Long, "video_play_time_duration", a(), Collections.singletonList(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)l1 / 1000.0F))));
        a(this.jdField_a_of_type_Long, "video_play_complete_rate", a(), Collections.singletonList(QCircleReportHelper.newEntry("rate", String.format("%.2f", new Object[] { Double.valueOf(d1) }))));
        l();
      }
      if (this.jdField_d_of_type_Int <= 0) {
        break label537;
      }
      a(this.jdField_a_of_type_Long, "video_play_occur_buffer_times", a(), Collections.singletonList(QCircleReportHelper.newEntry("buffer_count", String.valueOf(this.jdField_d_of_type_Int))));
      a(this.jdField_a_of_type_Long, "video_buffer_time_consuming", a(), Collections.singletonList(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)this.jdField_d_of_type_Long / 1000.0F))));
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Long, "video_download_ret", a(), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", this.jdField_b_of_type_JavaLangString)));
      s();
      return;
      label530:
      str = "0";
      break;
      label537:
      a(this.jdField_a_of_type_Long, "video_play_occur_buffer_times", a(), Collections.singletonList(QCircleReportHelper.newEntry("buffer_count", "0")));
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      QLog.d("BaseVideoView", 1, "flushVideoReportEvents event size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      QCircleReporter.getInstance().flushVideoReport(new ArrayList(this.jdField_a_of_type_JavaUtilArrayList));
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
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
    boolean bool;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)
    {
      if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
        break label195;
      }
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      if (SharePreferenceUtils.get(getContext(), "key_sp_is_detect_hevc").equals("")) {
        break label190;
      }
      bool = true;
      this.jdField_k_of_type_Boolean = bool;
      if (!this.jdField_k_of_type_Boolean)
      {
        jdField_a_of_type_JavaLangString = String.valueOf(TPCapability.getThumbPlayerVCodecTypeMaxCapability(172, 102).getMaxLevel());
        SharePreferenceUtils.set(getContext(), "key_sp_is_detect_hevc", "1");
        SharePreferenceUtils.set(getContext(), "key_sp_is_support_hevc", jdField_a_of_type_JavaLangString);
        QLog.i("BaseVideoView", 1, "this phone is support hevc");
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      label190:
      bool = false;
      break;
      label195:
      QLog.w("BaseVideoView", 1, "SuperPlayer is not installed");
    }
  }
  
  public ISPlayerVideoView a()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  }
  
  public void a()
  {
    if (!azjl.a())
    {
      azjl.a(BaseApplicationImpl.getApplication(), new zax(this));
      return;
    }
    a();
  }
  
  protected abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public void a(long paramLong)
  {
    long l1 = 0L;
    label199:
    for (;;)
    {
      try
      {
        if (a() != null)
        {
          long l2 = a().getDurationMs();
          if ((paramLong <= l2) || (l2 == 0L)) {
            break label199;
          }
          QLog.d("BaseVideoView", 1, "seek over position=" + paramLong + "duration=" + l2);
          paramLong = l2;
          if (paramLong < 0L)
          {
            QLog.d("BaseVideoView", 1, "seek invalid position=" + paramLong + "duration=" + a().getDurationMs());
            paramLong = l1;
            a().seekTo((int)paramLong, 3);
            QLog.d("BaseVideoView", 1, "seek position=" + paramLong + "duration=" + a().getDurationMs());
            this.jdField_d_of_type_Boolean = true;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  protected abstract void a(long paramLong1, long paramLong2);
  
  protected void a(long paramLong, String paramString, Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(5530);
    if (paramObject == null)
    {
      QLog.w("BaseVideoView", 1, "reportVideoEvent feed is null");
      return;
    }
    localSingleDcData.report_data.addAll(zat.a(paramLong, paramString, paramObject));
    if ((paramList != null) && (!paramList.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localSingleDcData);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    n();
  }
  
  protected void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo) {}
  
  public boolean a()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  protected void b()
  {
    if ((a() != null) && (a().isPlaying())) {
      g();
    }
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "0";
    this.m = false;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    a().removeCallbacksAndMessages(null);
    a().post(new BaseVideoView.2(this));
  }
  
  protected abstract void b(long paramLong1, long paramLong2);
  
  public void b(Context paramContext, int paramInt)
  {
    super.b(paramContext, paramInt);
    this.jdField_f_of_type_Boolean = false;
    a();
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    o();
    NetworkManager.registNetStatusListener(this);
  }
  
  protected boolean b()
  {
    QLog.w("BaseVideoView", 1, "biz has cancel perf report");
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void e()
  {
    if ((a() != null) && (!a().isPlaying()))
    {
      setInterrupt(false);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_i_of_type_Long <= 0L)) {
        break label124;
      }
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_i_of_type_Long;
      this.jdField_i_of_type_Long = 0L;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        this.jdField_f_of_type_Long = System.currentTimeMillis();
        this.jdField_h_of_type_Long = a().getCurrentPositionMs();
      }
      a().start();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      j();
      m();
      return;
      label124:
      if (!this.jdField_e_of_type_Boolean) {
        c(this.jdField_h_of_type_Long, a().getDurationMs());
      }
    }
  }
  
  public void f()
  {
    if ((a() != null) && (a().isPlaying()))
    {
      a().pause();
      this.jdField_a_of_type_Boolean = true;
      c(this.jdField_h_of_type_Long, a().getCurrentPositionMs());
      b(System.currentTimeMillis() - this.jdField_f_of_type_Long, c());
      this.jdField_i_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void g()
  {
    this.jdField_e_of_type_Boolean = true;
    if (!b()) {
      r();
    }
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
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void h()
  {
    if (a() != null)
    {
      a().stop();
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null) {
        setVideoPath(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.getVid(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.getPlayUrl(), 0);
      }
    }
  }
  
  public void i()
  {
    this.jdField_e_of_type_Boolean = true;
    if (!b()) {
      r();
    }
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
    double d1;
    float f1;
    if (a() != null)
    {
      d1 = a().getCurrentPositionMs();
      f1 = (float)a().getDurationMs();
      if ((f1 == 0.0F) && (a() != null)) {
        a().setProgress(0);
      }
      if ((!this.jdField_c_of_type_Boolean) && (d1 != 0.0D) && (!this.jdField_a_of_type_Boolean)) {}
    }
    else
    {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = ((int)d1);
    localMessage.arg2 = ((int)f1);
    localMessage.obj = Boolean.valueOf(true);
    a().sendMessage(localMessage);
    a().post(new BaseVideoView.6(this, d1, f1));
  }
  
  protected void l()
  {
    if ((a() instanceof FeedCloudMeta.StFeed))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)a();
      long l1 = localStFeed.video.fileSize.get();
      ArrayList localArrayList = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoDuration").append("=").append(localStFeed.video.duration.get()).append("|");
      localStringBuilder.append("fileSize").append("=").append(l1);
      if ((this.jdField_j_of_type_Long > 0L) && (l1 > 0L))
      {
        double d1 = Math.min(100.0D, this.jdField_j_of_type_Long / l1 * 100.0D);
        QLog.d("BaseVideoView", 1, new Object[] { "reportVideoBufferPercent localCacheSize:", Long.valueOf(this.jdField_j_of_type_Long), ",FileSize:", Long.valueOf(l1), ",rate:", Double.valueOf(d1) });
        localArrayList.add(QCircleReportHelper.newEntry("rate", String.valueOf(d1)));
        localStringBuilder.append("|").append("cacheSize").append("=").append(this.jdField_j_of_type_Long).append("|");
        localStringBuilder.append("bufferRate").append("=").append(d1);
      }
      localArrayList.add(QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()));
      a(this.jdField_a_of_type_Long, "video_buffer_percent", a(), localArrayList);
    }
  }
  
  protected abstract void m();
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.l = false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getHandler().removeCallbacksAndMessages(null);
    this.l = true;
    i();
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = String.format("module:%d, errorType:%d, errorCode:%d, extraInfo:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    QLog.e("BaseVideoView", 1, paramString);
    a(paramInt3, paramInt1, 0L, 0L);
    if ((String.valueOf(paramInt3).startsWith("140")) || (String.valueOf(paramInt3).startsWith("160"))) {
      this.jdField_b_of_type_JavaLangString = String.valueOf(paramInt3);
    }
    while (b()) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt3)));
    paramISuperPlayer = paramString;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localArrayList.add(QCircleReportHelper.newEntry("server_ip", this.jdField_c_of_type_JavaLangString));
      paramISuperPlayer = paramString + ",cdnIp:" + this.jdField_c_of_type_JavaLangString;
    }
    paramString = paramISuperPlayer;
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      paramString = paramISuperPlayer + ",ip:" + this.jdField_d_of_type_JavaLangString;
    }
    localArrayList.add(QCircleReportHelper.newEntry("attach_info", paramString));
    a(this.jdField_a_of_type_Long, "video_play_ret", a(), localArrayList);
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    int n = hashCode();
    String str2 = zaw.a(paramInt);
    String str1;
    if (paramObject == null)
    {
      paramISuperPlayer = "";
      if (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null) {
        break label139;
      }
      str1 = "";
      label31:
      QLog.i("BaseVideoView", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(n), str2, paramISuperPlayer, str1 }));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return false;
      paramISuperPlayer = paramObject.toString();
      break;
      label139:
      str1 = this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo.getPlayUrl();
      break label31;
      a().post(new BaseVideoView.4(this));
      continue;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      continue;
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Int += 1;
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
        a(this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo);
        QLog.i("BaseVideoView", 1, String.format("PLAYER_INFO_BUFFERING_END mSecondBufferCount:%d, mSecondBufferTime:%d", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Long.valueOf(this.jdField_d_of_type_Long) }));
        continue;
        if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
        {
          a((TPPlayerMsg.TPDownLoadProgressInfo)paramObject);
          continue;
          q();
          continue;
          if ((paramObject instanceof TPPlayerMsg.TPCDNURLInfo))
          {
            a((TPPlayerMsg.TPCDNURLInfo)paramObject);
            QLog.i("BaseVideoView", 1, String.format("hashCode:%d,TPPlayerMsg.TPCDNURLInfo:cdnIp:%s, errStr:%s, ip:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), ((TPPlayerMsg.TPCDNURLInfo)paramObject).cdnIp, ((TPPlayerMsg.TPCDNURLInfo)paramObject).errorStr, ((TPPlayerMsg.TPCDNURLInfo)paramObject).uIp, ((TPPlayerMsg.TPCDNURLInfo)paramObject).url }));
          }
        }
      }
    }
  }
  
  public void onNetworkChanged(String paramString1, String paramString2) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      zvm.a("setSeekBar", 100L, new zay(this, paramSeekBar));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_g_of_type_Long > 0L)
    {
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_g_of_type_Long;
      this.jdField_g_of_type_Long = 0L;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_f_of_type_Long;
    if (a() != null)
    {
      c(this.jdField_h_of_type_Long, a().getCurrentPositionMs());
      a(l1 - l2, c());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (a() != null)
    {
      int n = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)a().getDurationMs());
      this.jdField_h_of_type_Long = n;
      QLog.d("BaseVideoView", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(n) }));
      a(n);
    }
    this.jdField_c_of_type_Boolean = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null) {
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView.setXYaxis(0);
    }
    if (a() != null) {
      a().setMax((int)a().getDurationMs());
    }
    if (!b())
    {
      paramISuperPlayer = new ArrayList();
      paramISuperPlayer.add(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)(System.currentTimeMillis() - this.jdField_e_of_type_Long) / 1000.0F)));
      a(this.jdField_a_of_type_Long, "video_first_buffer_time_consuming", a(), paramISuperPlayer);
    }
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void setBaseVideoViewListenerSets(zaz paramzaz)
  {
    this.jdField_a_of_type_Zaz = paramzaz;
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
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        removeView(this.jdField_a_of_type_ComTencentImageURLImageView);
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentImageURLImageView = paramURLImageView;
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("BaseVideoView", 1, "set Final VideoPath success");
    b();
    zat.a();
    this.jdField_a_of_type_Long = zat.a();
    this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = a(paramString1, paramString2);
    if ((a() != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo != null))
    {
      p();
      paramString1 = SuperPlayerOption.obtain();
      paramString1.accurateSeekOnOpen = true;
      a().openMediaPlayer(getContext(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, paramInt, paramString1);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      if (!b()) {
        a(this.jdField_a_of_type_Long, "video_start_play", a(), null);
      }
      a(this.jdField_a_of_type_Long, "video_resolution", a(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */