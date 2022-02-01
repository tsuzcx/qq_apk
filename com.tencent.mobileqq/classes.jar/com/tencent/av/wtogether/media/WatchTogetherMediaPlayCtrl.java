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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = paramString.split("x");
    } while ((paramString == null) || (paramString.length != 2));
    try
    {
      int i = Math.min(Integer.valueOf(paramString[0]).intValue(), Integer.valueOf(paramString[1]).intValue());
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
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
    int i = 1;
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "seekTo expectPositionMs:=" + paramInt + ",sync:=" + paramBoolean);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(260);
    WatchTogetherMediaPlayCtrl.CustomHandler localCustomHandler = this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler;
    if (paramBoolean) {
      i = 0;
    }
    localCustomHandler.obtainMessage(260, i, 0, Integer.valueOf(paramInt)).sendToTarget();
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "playVideoInternal");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
    }
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    n();
    Object localObject = new SuperPlayerAudioInfo();
    ((SuperPlayerAudioInfo)localObject).setAudioSampleRateHZ(48000);
    ((SuperPlayerAudioInfo)localObject).setAudioChannelLayout(4L);
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = true;
    localSuperPlayerOption.audioFrameOutputOption = ((SuperPlayerAudioInfo)localObject);
    localObject = a();
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper.a());
    ((ISuperPlayer)localObject).setSurface(this.jdField_a_of_type_AndroidViewSurface);
    ((ISuperPlayer)localObject).setOutputMute(true);
    ((ISuperPlayer)localObject).openMediaPlayer(BaseApplicationImpl.getContext(), localSuperPlayerVideoInfo, paramInt, localSuperPlayerOption);
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
    int j = -1;
    if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 1)) {}
    TPProgramInfo[] arrayOfTPProgramInfo;
    do
    {
      return;
      arrayOfTPProgramInfo = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getProgramInfo();
    } while (arrayOfTPProgramInfo == null);
    int m = 2147483647;
    int i1 = -2147483648;
    int i3 = arrayOfTPProgramInfo.length;
    int n = 0;
    int k = 0;
    int i = -1;
    int i2;
    if (n < i3)
    {
      i2 = a(arrayOfTPProgramInfo[n].resolution) - 720;
      if ((i2 >= 0) && (i2 < m))
      {
        m = k;
        i = j;
        j = i2;
      }
    }
    for (;;)
    {
      i2 = n + 1;
      k += 1;
      n = m;
      m = j;
      j = i;
      i = n;
      n = i2;
      break;
      if ((i2 < 0) && (i2 > i1))
      {
        i1 = i2;
        j = m;
        i2 = k;
        m = i;
        i = i2;
        continue;
        if (i >= 0) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.selectProgram(i, 0L);
          return;
          if (j >= 0) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      else
      {
        i2 = i;
        i = j;
        j = m;
        m = i2;
      }
    }
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
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherVideoDecodeHelper.c();
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
    if (this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo != null) {
      return this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo;
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
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "setPlaySpeedRatio ratio:=" + paramFloat);
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
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "setVideoSink Thread.currentThread()):=" + Thread.currentThread());
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
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "play videoInfo:=" + paramWTogetherPlayInfo.toString(), new Throwable("call play"));
    if (!l())
    {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "play video interval-time short");
      return;
    }
    WTVideoInfo localWTVideoInfo = paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo = paramWTogetherPlayInfo;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo = localWTVideoInfo;
    this.jdField_c_of_type_Int = localWTVideoInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = localWTVideoInfo.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = localWTVideoInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(257, paramInt, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramRunnable);
  }
  
  public void a(String paramString, VideoSink paramVideoSink)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "removeVideoSink Thread.currentThread()):=" + Thread.currentThread() + ",from:=" + paramString);
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
      if (QLog.isColorLevel()) {
        QLog.i("WatchTogetherMediaPlayCtrl", 2, "updateAdminFlag, [" + this.jdField_d_of_type_Boolean + "-->" + paramBoolean + "], from[" + paramString + "]");
      }
      this.jdField_d_of_type_Boolean = paramBoolean;
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper.a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "setWatchTogetherEnable enable:=" + paramBoolean1 + ",admin:=" + paramBoolean2);
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
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherAudioDecodeHelper.a(paramBoolean1);
      d();
      return;
      if (!paramBoolean1)
      {
        b(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper);
        this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMngHelper = null;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 5;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Int == 7) {
      return (int)a() + 50;
    }
    if (this.jdField_a_of_type_Int == 10) {
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
    if (paramWatchTogetherMediaPlayerStatusCallback == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while ((localWeakReference == null) || (paramWatchTogetherMediaPlayerStatusCallback != localWeakReference.get()));
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "resumePlay mCurrentState:=" + this.jdField_a_of_type_Int, new Throwable("call resumePlay"));
    if ((this.jdField_a_of_type_Int == 9) || (this.jdField_a_of_type_Int == 10))
    {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(257);
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(257, 0, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(258);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(258).sendToTarget();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 10;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10005), Boolean.valueOf(this.f), Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 9;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 5) {}
    int i;
    do
    {
      return;
      i = b();
    } while (this.jdField_a_of_type_Int != 7);
    a(i, false);
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
    return (this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo != null) && ((this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_a_of_type_Int == 4));
  }
  
  public void g()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopPlay");
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(261);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(261).sendToTarget();
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo != null) && (this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_a_of_type_Int == 0);
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
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onCompletion url:=" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.post(new WatchTogetherMediaPlayCtrl.9(this));
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("WatchTogetherMediaPlayCtrl", 1, "PlayerCaptureProxy onError: module = " + paramInt1 + ", errorType = " + paramInt2 + ", errorCode = " + paramInt3 + ", extraInfo = " + paramString);
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
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "onProgressChanged progress:=" + paramInt);
      paramInt = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
      paramSeekBar = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramSeekBar.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)paramSeekBar.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (!(localWeakReference.get() instanceof WTogetherMngHelper))) {
          ((WatchTogetherMediaPlayerStatusCallback)localWeakReference.get()).a(paramInt, (int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
        }
      }
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onSeekComplete currentTimeMills:=" + paramISuperPlayer.getCurrentPositionMs());
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
    int i;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      i = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
      QLog.d("WatchTogetherMediaPlayCtrl", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(i) }));
      if (this.jdField_a_of_type_Int == 10) {
        break label102;
      }
      b(i);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      label102:
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.removeMessages(257);
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl$CustomHandler.obtainMessage(257, i, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl
 * JD-Core Version:    0.7.0.1
 */