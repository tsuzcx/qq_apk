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
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = -1L;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private WTogetherMngHelper jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper;
  @NonNull
  private AudioSink jdField_a_of_type_ComTencentAvWtogetherCallbackAudioSink;
  @NonNull
  private VideoSink jdField_a_of_type_ComTencentAvWtogetherCallbackVideoSink;
  private WTVideoInfo jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
  private WTogetherPlayInfo jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo;
  private WatchTogetherAudioDecodeHelper jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherAudioDecodeHelper;
  private WatchTogetherMediaPlayCtrl.CustomHandler jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler;
  private WatchTogetherVideoDecodeHelper jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper;
  private WatchTogetherDataReportHelper jdField_a_of_type_ComTencentAvWtogetherUtilWatchTogetherDataReportHelper;
  private volatile ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private String jdField_a_of_type_JavaLangString;
  private volatile Timer jdField_a_of_type_JavaUtilTimer;
  private CopyOnWriteArrayList<Runnable> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<WatchTogetherMediaPlayerStatusCallback>> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  public WatchTogetherMediaPlayCtrl(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherAudioDecodeHelper = new WatchTogetherAudioDecodeHelper();
    this.jdField_a_of_type_ComTencentAvWtogetherUtilWatchTogetherDataReportHelper = new WatchTogetherDataReportHelper();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WatchTogetherMediaPlayCtrl_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler = new WatchTogetherMediaPlayCtrl.CustomHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.sendEmptyMessage(256);
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
        int i = Math.min(Integer.valueOf(paramString[0]).intValue(), Integer.valueOf(paramString[1]).intValue());
        return i;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
  
  private ISuperPlayer a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 115, null);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnTVideoNetInfoUpdateListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoSizeChangedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnAudioFrameOutputListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoSizeChangedListener(this);
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo expectPositionMs:=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",sync:=");
    localStringBuilder.append(paramBoolean);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(260);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(260, paramBoolean ^ true, 0, Integer.valueOf(paramInt)).sendToTarget();
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "playVideoInternal");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewSurface;
    if (localObject1 != null)
    {
      ((Surface)localObject1).release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    n();
    Object localObject2 = new SuperPlayerAudioInfo();
    ((SuperPlayerAudioInfo)localObject2).setAudioSampleRateHZ(48000);
    ((SuperPlayerAudioInfo)localObject2).setAudioChannelLayout(4L);
    localObject1 = WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = true;
    localSuperPlayerOption.audioFrameOutputOption = ((SuperPlayerAudioInfo)localObject2);
    localObject2 = a();
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper.a());
    ((ISuperPlayer)localObject2).setSurface(this.jdField_a_of_type_AndroidViewSurface);
    ((ISuperPlayer)localObject2).setOutputMute(true);
    ((ISuperPlayer)localObject2).openMediaPlayer(BaseApplicationImpl.getContext(), (SuperPlayerVideoInfo)localObject1, paramInt, localSuperPlayerOption);
    if (!paramBoolean) {
      k();
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void j()
  {
    int i = this.jdField_c_of_type_Int;
    if ((i != 2) && (i != 1)) {
      return;
    }
    TPProgramInfo[] arrayOfTPProgramInfo = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getProgramInfo();
    if (arrayOfTPProgramInfo == null) {
      return;
    }
    int i7 = arrayOfTPProgramInfo.length;
    int j = -1;
    int i1 = 0;
    int k = -1;
    int n = 2147483647;
    int m = -2147483648;
    i = 0;
    while (i1 < i7)
    {
      int i6 = a(arrayOfTPProgramInfo[i1].resolution) - 720;
      int i3;
      int i4;
      int i2;
      int i5;
      if ((i6 >= 0) && (i6 < n))
      {
        i3 = i;
        i4 = i6;
        i2 = k;
        i5 = m;
      }
      else
      {
        i2 = k;
        i3 = j;
        i4 = n;
        i5 = m;
        if (i6 < 0)
        {
          i2 = k;
          i3 = j;
          i4 = n;
          i5 = m;
          if (i6 > m)
          {
            i2 = i;
            i5 = i6;
            i4 = n;
            i3 = j;
          }
        }
      }
      i += 1;
      i1 += 1;
      k = i2;
      j = i3;
      n = i4;
      m = i5;
    }
    if (j >= 0) {
      k = j;
    } else if (k < 0) {
      k = 0;
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.selectProgram(k, 0L);
  }
  
  private void k()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "playTimer");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new WatchTogetherMediaPlayCtrl.TimeUpdateTimerTask(this), 0L, 200L);
  }
  
  private void l()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopTimer");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  private boolean l()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L)
    {
      this.jdField_a_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  private void m()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopVideoInternal");
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.stop();
    }
    c(8);
    l();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper == null) {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper = WatchTogetherVideoDecodeHelper.a("watchTogetherVideoDispatch");
    }
  }
  
  private void o()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "releaseInternal");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    l();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackVideoSink = null;
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackAudioSink = null;
    Object localObject = this.jdField_a_of_type_AndroidViewSurface;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper;
    if (localObject != null)
    {
      ((WatchTogetherVideoDecodeHelper)localObject).c();
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper = null;
    }
    this.jdField_c_of_type_Boolean = false;
    c(1);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.10(this));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public WTFileInfo a()
  {
    WTogetherPlayInfo localWTogetherPlayInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo;
    if (localWTogetherPlayInfo != null) {
      return localWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo;
    }
    return null;
  }
  
  public WatchTogetherAudioDecodeHelper a()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherAudioDecodeHelper;
  }
  
  public WatchTogetherDataReportHelper a()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherUtilWatchTogetherDataReportHelper;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "pausePlay");
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(259);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(259).sendToTarget();
  }
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlaySpeedRatio ratio:=");
    localStringBuilder.append(paramFloat);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(289);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(289, 0, 0, Float.valueOf(paramFloat)).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(VideoSink paramVideoSink)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoSink Thread.currentThread()):=");
    localStringBuilder.append(Thread.currentThread());
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.1(this, paramVideoSink));
  }
  
  public void a(WatchTogetherMediaPlayerStatusCallback paramWatchTogetherMediaPlayerStatusCallback)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramWatchTogetherMediaPlayerStatusCallback == localWeakReference.get())) {
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramWatchTogetherMediaPlayerStatusCallback));
  }
  
  public void a(WTogetherPlayInfo paramWTogetherPlayInfo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play videoInfo:=");
    ((StringBuilder)localObject).append(paramWTogetherPlayInfo.toString());
    QLog.d("WatchTogetherMediaPlayCtrl", 1, ((StringBuilder)localObject).toString(), new Throwable("call play"));
    if (!l())
    {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "play video interval-time short");
      return;
    }
    localObject = paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo = paramWTogetherPlayInfo;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo = ((WTVideoInfo)localObject);
    this.jdField_c_of_type_Int = ((WTVideoInfo)localObject).jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = ((WTVideoInfo)localObject).jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = ((WTVideoInfo)localObject).jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(257, paramInt, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramRunnable);
  }
  
  public void a(String paramString, VideoSink paramVideoSink)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeVideoSink Thread.currentThread()):=");
    localStringBuilder.append(Thread.currentThread());
    localStringBuilder.append(",from:=");
    localStringBuilder.append(paramString);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.2(this, paramVideoSink));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateAdminFlag, [");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        ((StringBuilder)localObject).append("-->");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("], from[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.i("WatchTogetherMediaPlayCtrl", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_d_of_type_Boolean = paramBoolean;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper;
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
    if (this.f == paramBoolean1) {
      return;
    }
    this.f = paramBoolean1;
    a(paramBoolean2, "setWatchTogetherEnable");
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper == null) {
        this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper = new WTogetherMngHelper(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramBoolean2, this);
      }
      a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper);
    }
    else if (!paramBoolean1)
    {
      b(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper);
      this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper = null;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherAudioDecodeHelper.a(paramBoolean1);
    d();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 5;
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 7) {
      return (int)a() + 50;
    }
    if (i == 10) {
      return this.jdField_e_of_type_Int - 50;
    }
    return 0;
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
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramWatchTogetherMediaPlayerStatusCallback == localWeakReference.get())) {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumePlay mCurrentState:=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, localStringBuilder.toString(), new Throwable("call resumePlay"));
    int i = this.jdField_a_of_type_Int;
    if ((i != 9) && (i != 10))
    {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(258);
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(258).sendToTarget();
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(257);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(257, 0, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 10;
  }
  
  public void d()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null) {
      localVideoAppInterface.a(new Object[] { Integer.valueOf(10005), Boolean.valueOf(this.f), Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 9;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 5) {
      return;
    }
    int i = b();
    if (this.jdField_a_of_type_Int == 7) {
      a(i, false);
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Int == 4;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.3(this));
  }
  
  public boolean f()
  {
    WTVideoInfo localWTVideoInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    return (localWTVideoInfo != null) && ((localWTVideoInfo.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_a_of_type_Int == 4));
  }
  
  public void g()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopPlay");
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(261);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(261).sendToTarget();
  }
  
  public boolean g()
  {
    WTVideoInfo localWTVideoInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    return (localWTVideoInfo != null) && (localWTVideoInfo.jdField_a_of_type_Int == 0);
  }
  
  public void h()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "releaseMediaPlayer");
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(265);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(265).sendToTarget();
  }
  
  public boolean h()
  {
    return this.f;
  }
  
  public void i()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "exitDoubleTalk");
    h();
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherUtilWatchTogetherDataReportHelper.a();
  }
  
  public boolean i()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean j()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean k()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherCallbackVideoSink == null;
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherAudioDecodeHelper.onAudioFrameOutput(paramTPAudioFrameBuffer);
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onCompletion url:=");
    paramISuperPlayer.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("WatchTogetherMediaPlayCtrl", 1, paramISuperPlayer.toString());
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.9(this));
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
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.6(this, paramInt1, paramInt2, paramInt3, paramString));
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherMediaPlayCtrl", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), BaseVideoUtils.a(paramInt), null, null }));
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.5(this, paramInt, paramLong1, paramLong2, paramObject));
    return false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProgressChanged progress:=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("WatchTogetherMediaPlayCtrl", 1, ((StringBuilder)localObject).toString());
      paramInt = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
      paramSeekBar = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramSeekBar.hasNext())
      {
        localObject = (WeakReference)paramSeekBar.next();
        if ((localObject != null) && (((WeakReference)localObject).get() != null) && (!(((WeakReference)localObject).get() instanceof WTogetherMngHelper))) {
          ((WatchTogetherMediaPlayerStatusCallback)((WeakReference)localObject).get()).a(paramInt, (int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
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
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.8(this));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onStartTrackingTouch ");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onStopTrackingTouch ");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      int i = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
      QLog.d("WatchTogetherMediaPlayCtrl", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(i) }));
      if (this.jdField_a_of_type_Int != 10)
      {
        b(i);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(257);
        this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(257, i, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
      }
    }
    this.jdField_a_of_type_Boolean = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoPrepared");
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.4(this, paramISuperPlayer));
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoSizeChanged");
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.7(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl
 * JD-Core Version:    0.7.0.1
 */