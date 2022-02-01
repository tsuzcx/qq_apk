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
import com.tencent.av.wtogether.data.WTFileInfo;
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
import mxf;
import myg;
import myi;
import myj;
import myk;
import myu;
import myv;
import mzk;
import mzl;
import mzm;
import nad;
import naf;
import zqb;

public class WatchTogetherMediaPlayCtrl
  implements SeekBar.OnSeekBarChangeListener, ISuperPlayer.OnAudioFrameOutputListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener, myj
{
  private float jdField_a_of_type_Float = 1.0F;
  public final int a;
  private long jdField_a_of_type_Long = -1L;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private volatile ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private String jdField_a_of_type_JavaLangString;
  private volatile Timer jdField_a_of_type_JavaUtilTimer;
  private CopyOnWriteArrayList<Runnable> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private mxf jdField_a_of_type_Mxf;
  @NonNull
  private myg jdField_a_of_type_Myg;
  @NonNull
  private myi jdField_a_of_type_Myi;
  private myu jdField_a_of_type_Myu;
  private myv jdField_a_of_type_Myv;
  private mzk jdField_a_of_type_Mzk;
  private mzl jdField_a_of_type_Mzl;
  private mzm jdField_a_of_type_Mzm;
  private naf jdField_a_of_type_Naf;
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  private String jdField_b_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<myk>> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  public final int c;
  private boolean c;
  public final int d;
  private boolean d;
  public final int e;
  private boolean e;
  public final int f;
  private boolean f;
  public final int g = 264;
  public final int h = 265;
  public final int i = 288;
  public final int j = 289;
  private final int k = 720;
  private int l = 1;
  private int m = 1;
  private int n;
  private int o = 1;
  private int p;
  
  public WatchTogetherMediaPlayCtrl(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Int = 256;
    this.jdField_b_of_type_Int = 257;
    this.jdField_c_of_type_Int = 258;
    this.jdField_d_of_type_Int = 259;
    this.jdField_e_of_type_Int = 260;
    this.jdField_f_of_type_Int = 261;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Mzk = new mzk();
    this.jdField_a_of_type_Naf = new naf();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("WatchTogetherMediaPlayCtrl_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Mzl = new mzl(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Mzl.sendEmptyMessage(256);
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
      int i1 = Math.min(Integer.valueOf(paramString[0]).intValue(), Integer.valueOf(paramString[1]).intValue());
      return i1;
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
    int i1 = 1;
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "seekTo expectPositionMs:=" + paramInt + ",sync:=" + paramBoolean);
    this.jdField_a_of_type_Mzl.removeMessages(260);
    mzl localmzl = this.jdField_a_of_type_Mzl;
    if (paramBoolean) {
      i1 = 0;
    }
    localmzl.obtainMessage(260, i1, 0, Integer.valueOf(paramInt)).sendToTarget();
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
    m();
    Object localObject = new SuperPlayerAudioInfo();
    ((SuperPlayerAudioInfo)localObject).setAudioSampleRateHZ(48000);
    ((SuperPlayerAudioInfo)localObject).setAudioChannelLayout(4L);
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = nad.a(this.jdField_a_of_type_Myu);
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    localSuperPlayerOption.enableAudioFrameOutput = true;
    localSuperPlayerOption.audioFrameOutputOption = ((SuperPlayerAudioInfo)localObject);
    localObject = a();
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_Mzm.a());
    ((ISuperPlayer)localObject).setSurface(this.jdField_a_of_type_AndroidViewSurface);
    ((ISuperPlayer)localObject).setOutputMute(true);
    ((ISuperPlayer)localObject).openMediaPlayer(BaseApplicationImpl.getContext(), localSuperPlayerVideoInfo, paramInt, localSuperPlayerOption);
    if (!paramBoolean) {
      j();
    }
  }
  
  private void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  private void d(int paramInt)
  {
    this.m = paramInt;
  }
  
  private void i()
  {
    int i2 = -1;
    if ((this.n != 2) && (this.n != 1)) {}
    TPProgramInfo[] arrayOfTPProgramInfo;
    do
    {
      return;
      arrayOfTPProgramInfo = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getProgramInfo();
    } while (arrayOfTPProgramInfo == null);
    int i4 = 2147483647;
    int i6 = -2147483648;
    int i8 = arrayOfTPProgramInfo.length;
    int i5 = 0;
    int i3 = 0;
    int i1 = -1;
    int i7;
    if (i5 < i8)
    {
      i7 = a(arrayOfTPProgramInfo[i5].resolution) - 720;
      if ((i7 >= 0) && (i7 < i4))
      {
        i4 = i3;
        i1 = i2;
        i2 = i7;
      }
    }
    for (;;)
    {
      i7 = i5 + 1;
      i3 += 1;
      i5 = i4;
      i4 = i2;
      i2 = i1;
      i1 = i5;
      i5 = i7;
      break;
      if ((i7 < 0) && (i7 > i6))
      {
        i6 = i7;
        i2 = i4;
        i7 = i3;
        i4 = i1;
        i1 = i7;
        continue;
        if (i1 >= 0) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.selectProgram(i1, 0L);
          return;
          if (i2 >= 0) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
      }
      else
      {
        i7 = i1;
        i1 = i2;
        i2 = i4;
        i4 = i7;
      }
    }
  }
  
  private void j()
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
  
  private void k()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopTimer");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  private void l()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopVideoInternal");
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.stop();
    }
    c(8);
    k();
  }
  
  private boolean l()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_a_of_type_Long > 500L)
    {
      this.jdField_a_of_type_Long = l1;
      return true;
    }
    return false;
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Mzm == null) {
      this.jdField_a_of_type_Mzm = mzm.a("watchTogetherVideoDispatch");
    }
  }
  
  private void n()
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
    k();
    this.jdField_a_of_type_Myu = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Myi = null;
    this.jdField_a_of_type_Myg = null;
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Mzm != null)
    {
      this.jdField_a_of_type_Mzm.c();
      this.jdField_a_of_type_Mzm = null;
    }
    this.jdField_c_of_type_Boolean = false;
    c(1);
  }
  
  private void o()
  {
    if (this.l == 1) {
      return;
    }
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.9(this));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.o;
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
    if (this.jdField_a_of_type_Myv != null) {
      return this.jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public mzk a()
  {
    return this.jdField_a_of_type_Mzk;
  }
  
  public naf a()
  {
    return this.jdField_a_of_type_Naf;
  }
  
  public void a()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "pausePlay");
    this.jdField_a_of_type_Mzl.removeMessages(259);
    this.jdField_a_of_type_Mzl.obtainMessage(259).sendToTarget();
  }
  
  public void a(float paramFloat)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "setPlaySpeedRatio ratio:=" + paramFloat);
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Mzl.removeMessages(289);
    this.jdField_a_of_type_Mzl.obtainMessage(289, 0, 0, Float.valueOf(paramFloat)).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramRunnable);
  }
  
  public void a(String paramString, myi parammyi)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "removeVideoSink Thread.currentThread()):=" + Thread.currentThread() + ",from:=" + paramString);
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.2(this, parammyi));
  }
  
  public void a(myi parammyi)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "setVideoSink Thread.currentThread()):=" + Thread.currentThread());
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.1(this, parammyi));
  }
  
  public void a(myk parammyk)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (parammyk == localWeakReference.get())) {
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(parammyk));
  }
  
  public void a(myv parammyv, int paramInt)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "play videoInfo:=" + parammyv.toString(), new Throwable("call play"));
    if (!l())
    {
      QLog.d("WatchTogetherMediaPlayCtrl", 1, "play video interval-time short");
      return;
    }
    myu localmyu = parammyv.jdField_a_of_type_Myu;
    this.jdField_a_of_type_Myv = parammyv;
    this.jdField_a_of_type_Myu = localmyu;
    this.n = localmyu.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = localmyu.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = localmyu.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Mzl.obtainMessage(257, paramInt, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
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
    if (this.jdField_a_of_type_Mxf != null) {
      this.jdField_a_of_type_Mxf.a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "setWatchTogetherEnable enable:=" + paramBoolean1 + ",admin:=" + paramBoolean2);
    if (this.jdField_f_of_type_Boolean == paramBoolean1) {
      return;
    }
    this.jdField_f_of_type_Boolean = paramBoolean1;
    a(paramBoolean2, "setWatchTogetherEnable");
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_Mxf == null) {
        this.jdField_a_of_type_Mxf = new mxf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramBoolean2, this);
      }
      a(this.jdField_a_of_type_Mxf);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mzk.a(paramBoolean1);
      d();
      return;
      if (!paramBoolean1)
      {
        b(this.jdField_a_of_type_Mxf);
        this.jdField_a_of_type_Mxf = null;
      }
    }
  }
  
  public boolean a()
  {
    return this.l == 5;
  }
  
  public int b()
  {
    if (this.l == 7) {
      return (int)a() + 50;
    }
    if (this.l == 10) {
      return this.p - 50;
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
  
  public void b(myk parammyk)
  {
    if (parammyk == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while ((localWeakReference == null) || (parammyk != localWeakReference.get()));
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "resumePlay mCurrentState:=" + this.l, new Throwable("call resumePlay"));
    if ((this.l == 9) || (this.l == 10))
    {
      this.jdField_a_of_type_Mzl.removeMessages(257);
      this.jdField_a_of_type_Mzl.obtainMessage(257, 0, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
      return;
    }
    this.jdField_a_of_type_Mzl.removeMessages(258);
    this.jdField_a_of_type_Mzl.obtainMessage(258).sendToTarget();
  }
  
  public boolean c()
  {
    return this.l == 10;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10005), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    }
  }
  
  public boolean d()
  {
    return this.l == 9;
  }
  
  public void e()
  {
    if (this.l == 5) {}
    int i1;
    do
    {
      return;
      i1 = b();
    } while (this.l != 7);
    a(i1, false);
  }
  
  public boolean e()
  {
    return this.l == 4;
  }
  
  public void f()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "stopPlay");
    this.jdField_a_of_type_Mzl.removeMessages(261);
    this.jdField_a_of_type_Mzl.obtainMessage(261).sendToTarget();
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Myu != null) && ((this.jdField_a_of_type_Myu.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Myu.jdField_a_of_type_Int == 4));
  }
  
  public void g()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "releaseMediaPlayer");
    this.jdField_a_of_type_Mzl.removeMessages(265);
    this.jdField_a_of_type_Mzl.obtainMessage(265).sendToTarget();
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_Myu != null) && (this.jdField_a_of_type_Myu.jdField_a_of_type_Int == 0);
  }
  
  public void h()
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "exitDoubleTalk");
    g();
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_Naf.a();
  }
  
  public boolean h()
  {
    return this.jdField_f_of_type_Boolean;
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
    return this.jdField_a_of_type_Myi == null;
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.jdField_a_of_type_Mzk.onAudioFrameOutput(paramTPAudioFrameBuffer);
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onCompletion url:=" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.8(this));
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("WatchTogetherMediaPlayCtrl", 1, "PlayerCaptureProxy onError: module = " + paramInt1 + ", errorType = " + paramInt2 + ", errorCode = " + paramInt3 + ", extraInfo = " + paramString);
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.5(this, paramInt1, paramInt2, paramInt3, paramString));
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherMediaPlayCtrl", 1, String.format("onInfo: hashCode:%d, what:%s, extra:%s, url:%s", new Object[] { Integer.valueOf(hashCode()), zqb.a(paramInt), null, null }));
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.4(this, paramInt, paramLong1, paramLong2, paramObject));
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
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (!(localWeakReference.get() instanceof mxf))) {
          ((myk)localWeakReference.get()).a(paramInt, (int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
        }
      }
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onSeekComplete currentTimeMills:=" + paramISuperPlayer.getCurrentPositionMs());
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.7(this));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onStartTrackingTouch ");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onStopTrackingTouch ");
    int i1;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      i1 = (int)(paramSeekBar.getProgress() / (paramSeekBar.getMax() * 1.0F) * (float)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs());
      QLog.d("WatchTogetherMediaPlayCtrl", 1, String.format("seek onStopTrackingTouch seekBar progress:%d, position:%d", new Object[] { Integer.valueOf(paramSeekBar.getProgress()), Integer.valueOf(i1) }));
      if (this.l == 10) {
        break label104;
      }
      b(i1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      label104:
      this.jdField_a_of_type_Mzl.removeMessages(257);
      this.jdField_a_of_type_Mzl.obtainMessage(257, i1, 0, this.jdField_b_of_type_JavaLangString).sendToTarget();
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoPrepared");
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.3(this, paramISuperPlayer));
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("WatchTogetherMediaPlayCtrl", 1, "onVideoSizeChanged");
    this.jdField_a_of_type_Mzk.a();
    this.jdField_a_of_type_Mzl.post(new WatchTogetherMediaPlayCtrl.6(this, paramISuperPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl
 * JD-Core Version:    0.7.0.1
 */