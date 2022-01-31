package com.tencent.biz.qqcircle.widgets;

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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import bdnn;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import feedcloud.FeedCloudMeta.StFeed;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import org.json.JSONObject;
import tqb;
import tzy;
import uaf;
import uca;
import ucb;
import unk;
import vwa;
import vwb;
import vwc;
import vwd;
import vwe;
import vwf;
import vxe;
import yiw;
import yiy;
import ymv;
import ymw;
import yxt;
import yyw;
import zaj;

public abstract class BaseVideoView
  extends BaseWidgetView
  implements Handler.Callback, SeekBar.OnSeekBarChangeListener, NetworkManager.NetStatusListener, TVK_IMediaPlayer.OnSeekCompleteListener, vwb, vwc, vwd, vwe, vwf, yiy
{
  private static final String jdField_a_of_type_JavaLangString = BaseVideoView.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public URLImageView a;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private List<Pair<Long, Long>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private vxe jdField_a_of_type_Vxe;
  private ymv jdField_a_of_type_Ymv;
  private ymw jdField_a_of_type_Ymw;
  protected boolean a;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  private long c;
  protected boolean c;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  private long g;
  
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
  
  private long a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Pair localPair;
    for (long l = 0L; localIterator.hasNext(); l = ((Long)localPair.second).longValue() - ((Long)localPair.first).longValue() + l) {
      localPair = (Pair)localIterator.next();
    }
    return l;
  }
  
  private File a(String paramString)
  {
    return new File(tqb.g + paramString + ".stmp");
  }
  
  private String a(String paramString)
  {
    File localFile = new File(tqb.g + paramString);
    paramString = a(paramString);
    if (localFile.exists()) {
      return localFile.getAbsolutePath();
    }
    return paramString.getAbsolutePath();
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String[] arrayOfString = ((String)yyw.a().a("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|")).split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString.startsWith(arrayOfString[i]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void c(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Pair localPair;
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if ((((Long)localPair.first).longValue() <= paramLong1) && (((Long)localPair.second).longValue() >= paramLong2))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "addToVideoSoloPlayTimeRangeList: already contained [start=" + paramLong1 + ", end=" + paramLong2 + "]");
        return;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      if ((paramLong1 <= ((Long)localPair.first).longValue()) && (paramLong2 >= ((Long)localPair.second).longValue()))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "addToVideoSoloPlayTimeRangeList: remove [start=" + localPair.first + ", end=" + localPair.second + "]");
        localIterator.remove();
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      long l = paramLong1;
      if (paramLong1 >= ((Long)localPair.first).longValue())
      {
        l = paramLong1;
        if (paramLong1 <= ((Long)localPair.second).longValue()) {
          l = ((Long)localPair.second).longValue();
        }
      }
      paramLong1 = l;
      if (paramLong2 >= ((Long)localPair.first).longValue())
      {
        paramLong1 = l;
        if (paramLong2 <= ((Long)localPair.second).longValue())
        {
          paramLong2 = ((Long)localPair.first).longValue();
          paramLong1 = l;
        }
      }
    }
    if ((paramLong1 < 0L) || (paramLong1 > paramLong2))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + paramLong1 + ", end=" + paramLong2 + "]");
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + paramLong1 + ", end=" + paramLong2 + "]");
    this.jdField_a_of_type_JavaUtilList.add(new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
  }
  
  private void k()
  {
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    a().removeCallbacksAndMessages(null);
  }
  
  private void m()
  {
    if (this.jdField_d_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      c(this.jdField_f_of_type_Long, a().a());
      a(0, 0, l, a());
      this.jdField_d_of_type_Long = 0L;
      this.jdField_f_of_type_Long = 0L;
      if (a() != null)
      {
        double d1 = a().b();
        d1 = Math.min(100.0D, l / d1 * 100.0D);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(tzy.a("ret_code", "0"));
        localArrayList.add(tzy.a("time_cost", String.valueOf((float)l / 1000.0F)));
        uaf.a("video_play_ret", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, localArrayList);
        uaf.a("video_play_time_duration", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("time_cost", String.valueOf((float)l / 1000.0F))));
        uaf.a("video_play_complete_rate", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("rate", String.format("%.2f", new Object[] { Double.valueOf(d1) }))));
      }
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      uaf.a("video_play_occur_buffer_times", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("buffer_count", String.valueOf(this.jdField_a_of_type_Int))));
      uaf.a("video_buffer_time_consuming", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("time_cost", String.valueOf((float)this.jdField_b_of_type_Long / 1000.0F))));
      return;
    }
    uaf.a("video_play_occur_buffer_times", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("buffer_count", "0")));
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public abstract SeekBar a();
  
  public URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  protected IVideoViewBase a()
  {
    return (IVideoViewBase)a().a();
  }
  
  public vxe a()
  {
    if (this.jdField_a_of_type_Vxe == null)
    {
      if (!TVK_SDKMgr.isInstalled(getContext())) {
        break label113;
      }
      zaj.a("subscribe_tvk_install_event_name", zaj.a(0L, 0L));
      this.jdField_a_of_type_Vxe = new vxe(getContext(), String.valueOf(System.identityHashCode(this)));
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a("bus_type_subscribe");
    }
    for (;;)
    {
      return this.jdField_a_of_type_Vxe;
      label113:
      zaj.a("subscribe_tvk_install_event_name", zaj.a(-1L, 0L));
      QLog.w(jdField_a_of_type_JavaLangString, 1, "tvk is not installed");
    }
  }
  
  public void a()
  {
    this.jdField_f_of_type_Boolean = true;
    m();
    if (a() != null) {
      a().e();
    }
    if (this.jdField_a_of_type_Ymv != null) {
      this.jdField_a_of_type_Ymv.a();
    }
    this.jdField_a_of_type_Boolean = false;
    yiw.a().b(this);
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
  
  protected abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public void a(long paramLong)
  {
    long l1 = 0L;
    if (a() != null)
    {
      long l2 = a().b();
      if ((paramLong <= l2) || (l2 == 0L)) {
        break label184;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "seek over position=" + paramLong + "duration=" + l2);
      paramLong = l2;
    }
    label184:
    for (;;)
    {
      if (paramLong < 0L)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "seek invalid position=" + paramLong + "duration=" + a().b());
        paramLong = l1;
      }
      for (;;)
      {
        a().a(paramLong);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "seek position=" + paramLong + "duration=" + a().b());
        this.jdField_e_of_type_Boolean = true;
        return;
      }
    }
  }
  
  protected abstract void a(long paramLong1, long paramLong2);
  
  public void a(Context paramContext)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_d_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext)) {
      a();
    }
  }
  
  public void a(Context paramContext, int paramInt) {}
  
  public void a(String paramString, File paramFile, int paramInt, JSONObject paramJSONObject) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    uaf.a("video_download_ret", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("ret_code", String.valueOf(paramInt))));
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    uaf.a("video_download_ret", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, Collections.singletonList(tzy.a("ret_code", "0")));
    unk.a(a(paramString1));
  }
  
  public void a(vwa paramvwa)
  {
    a().setXYaxis(0);
    if (a() != null) {
      a().setMax((int)paramvwa.b());
    }
    paramvwa = new ArrayList();
    paramvwa.add(tzy.a("time_cost", String.valueOf((float)(System.currentTimeMillis() - this.jdField_c_of_type_Long) / 1000.0F)));
    uaf.a("video_first_buffer_time_consuming", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, paramvwa);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(vwa paramvwa, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramvwa = "what:" + paramInt2 + ",model:" + paramInt1 + ",extra:" + paramString;
    QLog.e(jdField_a_of_type_JavaLangString, 1, paramvwa);
    a(paramInt2, paramInt1, 0L, 0L);
    paramString = new ArrayList();
    paramString.add(tzy.a("ret_code", String.valueOf(paramInt2)));
    paramString.add(tzy.a("attach_info", paramvwa));
    uaf.a("video_play_ret", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, paramString);
    return false;
  }
  
  public boolean a(vwa paramvwa, int paramInt, Object paramObject)
  {
    if (paramInt == 2) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      return false;
      if ((paramInt == 3) && (!this.jdField_e_of_type_Boolean))
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
      }
    }
  }
  
  public void b()
  {
    if ((a() != null) && (a().a()))
    {
      a().c();
      this.jdField_a_of_type_Boolean = true;
      c(this.jdField_f_of_type_Long, a().a());
      b(System.currentTimeMillis() - this.jdField_d_of_type_Long, a());
      this.g = System.currentTimeMillis();
    }
  }
  
  protected abstract void b(long paramLong1, long paramLong2);
  
  public void b(Context paramContext, int paramInt)
  {
    super.b(paramContext, paramInt);
    a(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (a() != null)
    {
      addView(a().a(), new FrameLayout.LayoutParams(-1, -1));
      addView(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
    NetworkManager.registNetStatusListener(this);
    this.jdField_a_of_type_Ymv = new ymv();
    k();
  }
  
  public void b(vwa paramvwa) {}
  
  public boolean b()
  {
    if (a() != null) {
      return a().b();
    }
    return false;
  }
  
  public void c()
  {
    if (a() != null)
    {
      setInterrupt(false);
      if (this.jdField_a_of_type_Ymv != null) {
        this.jdField_a_of_type_Ymv.a(a().a(), new uca(this));
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.g <= 0L)) {
        break label137;
      }
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.g;
      this.g = 0L;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
      {
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        this.jdField_f_of_type_Long = a().a();
      }
      a().b();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      i();
      f();
      return;
      label137:
      if (!this.jdField_f_of_type_Boolean) {
        c(this.jdField_f_of_type_Long, a().b());
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public abstract void d();
  
  public void e()
  {
    if (a() != null)
    {
      a().f();
      this.jdField_a_of_type_Boolean = false;
      a().g();
    }
  }
  
  protected abstract void f();
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void h()
  {
    this.jdField_f_of_type_Boolean = true;
    m();
    if (a() != null) {
      a().f();
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
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new BaseVideoView.TimeUpdateTimerTask(this), 0L, 33L);
  }
  
  @CallSuper
  protected void j()
  {
    if (a() != null)
    {
      double d1 = a().a();
      float f1 = (float)a().b();
      if ((f1 == 0.0F) && (a() != null)) {
        a().setProgress(0);
      }
      if ((!this.jdField_c_of_type_Boolean) && (d1 != 0.0D))
      {
        Object localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).arg1 = ((int)d1);
        ((Message)localObject).arg2 = ((int)f1);
        ((Message)localObject).obj = Boolean.valueOf(true);
        a().sendMessage((Message)localObject);
        if (a() != null)
        {
          localObject = a();
          double d2 = a().getMax();
          ((SeekBar)localObject).setProgress((int)(d1 / f1 * d2));
        }
      }
    }
  }
  
  public void onNetworkChanged(String paramString1, String paramString2) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      yxt.a("setSeekBar", 100L, new ucb(this, paramSeekBar));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_e_of_type_Long > 0L)
    {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      this.jdField_e_of_type_Long = 0L;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_d_of_type_Long;
    if (a() != null)
    {
      c(this.jdField_f_of_type_Long, a().a());
      a(l1 - l2, a());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (a() != null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "seek onStopTrackingTouch seekBar progress" + paramSeekBar.getProgress());
      int i = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)a().b());
      this.jdField_f_of_type_Long = i;
      a(i);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setDarkFrameCheckListener(ymw paramymw)
  {
    this.jdField_a_of_type_Ymw = paramymw;
  }
  
  public void setInterrupt(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (a() != null) {
      a().a(paramBoolean);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (a() != null) {
      a().b(paramBoolean);
    }
  }
  
  public void setVideoCover(URLImageView paramURLImageView)
  {
    if (paramURLImageView != null)
    {
      removeView(this.jdField_a_of_type_ComTencentImageURLImageView);
      this.jdField_a_of_type_ComTencentImageURLImageView = paramURLImageView;
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)a());
    l();
    uaf.a();
    Object localObject1 = "auto";
    Object localObject2 = localObject1;
    String str = paramString1;
    if (!bdnn.a(paramString3))
    {
      localObject2 = localObject1;
      str = paramString1;
      if (a(paramString3))
      {
        localObject2 = Uri.parse(paramString3);
        paramString2 = paramString1;
        if (localObject2 != null)
        {
          str = ((Uri)localObject2).getQueryParameter("playerformat");
          localObject1 = str;
          paramString2 = paramString1;
          if (bdnn.a(paramString1))
          {
            paramString2 = ((Uri)localObject2).getQueryParameter("vid");
            localObject1 = str;
          }
        }
        localObject2 = localObject1;
        str = paramString2;
        if (!bdnn.a(paramString2))
        {
          paramString1 = null;
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      if (paramString1 != null) {}
      for (this.jdField_b_of_type_JavaLangString = paramString1;; this.jdField_b_of_type_JavaLangString = paramString2)
      {
        if (a() != null)
        {
          a().a(paramString2, a(paramString2), paramString1, (String)localObject2, paramInt1, paramInt2, paramInt3);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          uaf.a("video_start_play", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null);
        }
        return;
      }
      paramString1 = paramString3;
      paramString2 = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */