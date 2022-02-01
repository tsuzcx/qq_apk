package com.tencent.avgame.videorecord;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.avgame.config.data.AvGameConfBean.RecordParam;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.qav.videorecord.GameImageData;
import com.tencent.avgame.qav.videorecord.GuessPictureGamePaintLogic;
import com.tencent.avgame.qav.videorecord.GuessPictureGameResultMgr;
import com.tencent.avgame.qav.videorecord.IGuessPictureGameRecordCtrl;
import com.tencent.avgame.qav.videorecord.IGuessPictureGameRecordCtrl.GameImageDataProvider;
import com.tencent.avgame.util.RecordUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

@TargetApi(17)
public class GuessPictureGameRecordCtrl
  extends GameVideoRecordBaseCtrl
  implements IGuessPictureGameRecordCtrl
{
  private GuessPictureGamePaintLogic f = new GuessPictureGamePaintLogic();
  private GuessPictureGameResultMgr g = new GuessPictureGameResultMgr();
  private QavVideoAudioRecorder h;
  private IGuessPictureGameRecordCtrl.GameImageDataProvider i;
  private boolean j;
  private long k;
  private long l;
  private boolean m;
  private volatile boolean n;
  private volatile boolean o;
  private Runnable p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private EncodeConfig v;
  
  public GuessPictureGameRecordCtrl(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 720)
    {
      this.q = paramInt1;
      this.r = paramInt2;
    }
    else
    {
      this.q = 720;
      this.r = ((int)(paramInt2 * (720.0F / paramInt1)));
    }
    this.q = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(this.q);
    this.r = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(this.r);
  }
  
  private void b(IGuessPictureGameRecordCtrl.GameImageDataProvider paramGameImageDataProvider, int paramInt1, int paramInt2)
  {
    this.i = paramGameImageDataProvider;
    a(paramInt1, paramInt2);
    this.f.a(paramInt1, paramInt2, this.q, this.r);
    this.g.a(o(), p(), this.f);
    this.p = new GuessPictureGameRecordCtrl.1(this);
  }
  
  private boolean w()
  {
    return GameEngine.a().s().o() == 2;
  }
  
  private boolean x()
  {
    if ((this.i.f()) || (this.f.b()))
    {
      ArrayList localArrayList = this.i.g();
      this.u = this.f.a(localArrayList);
      this.g.a(localArrayList);
      this.f.c();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "addNextFrame, dataList size:", Integer.valueOf(localArrayList.size()) });
      }
    }
    if ((this.h != null) && (this.u > 0) && (System.currentTimeMillis() - this.l < this.t))
    {
      this.h.a(3553, this.u, null, null, SystemClock.elapsedRealtimeNanos());
      return true;
    }
    return false;
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "onVideoMuxerWaiting");
    }
    if (this.d)
    {
      try
      {
        Thread.sleep(300L);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GuessPictureGameRecordCtrl", 2, new Object[] { "onVideoMuxerWaiting", localException.getMessage() });
        }
      }
      x();
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.m = true;
    m();
    QLog.e("GuessPictureGameRecordCtrl", 1, paramThrowable, new Object[] { "onEncodeError, errorCode", Integer.valueOf(paramInt) });
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewShow, isRecording:", Boolean.valueOf(this.d) });
    }
    this.f.a(paramView, paramInt, paramBoolean);
    if ((!this.d) && (this.g.a)) {
      this.g.a(paramBoolean);
    }
  }
  
  public void a(IGuessPictureGameRecordCtrl.GameImageDataProvider paramGameImageDataProvider, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord");
    }
    if (!this.j)
    {
      this.j = true;
      b(paramGameImageDataProvider, paramInt1, paramInt2);
      long l1 = RecordUtils.b().b * 1000;
      paramGameImageDataProvider = GameEngine.a().s().v();
      if ((w()) && (paramGameImageDataProvider.startGameTimeMills > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord, gameRecordInfo:", paramGameImageDataProvider });
        }
        if ((paramGameImageDataProvider.videoFilePath != null) && (new File(paramGameImageDataProvider.videoFilePath).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord return, video file exists");
          }
          return;
        }
        this.k = paramGameImageDataProvider.startGameTimeMills;
        l1 = Math.min(Math.max(System.currentTimeMillis() - this.k, l1), 0L);
      }
      else
      {
        this.k = System.currentTimeMillis();
      }
      GameEngine.a().s().a(null, null, this.k);
      ThreadManager.getSubThreadHandler().postDelayed(this.p, l1);
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord indeed, delayTime:", Long.valueOf(l1) });
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      boolean bool2 = QLog.isColorLevel();
      boolean bool1 = false;
      if (bool2) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onEncodeFinish, mRecordStopped:", Boolean.valueOf(this.o) });
      }
      this.n = true;
      if ((this.n) && (this.o))
      {
        paramString = this.g;
        if (!this.m) {
          bool1 = true;
        }
        paramString.a(bool1, this.k);
      }
      return;
    }
    finally {}
  }
  
  public void a(ArrayList<GameImageData> paramArrayList)
  {
    if ((!this.d) && (this.g.a)) {
      this.g.a(paramArrayList);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.d)
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.h;
      if ((localQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
  }
  
  public void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewDismiss, isRecording:", Boolean.valueOf(this.d) });
    }
    this.f.a(paramView);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onActivityStop, mIsRecording:", Boolean.valueOf(this.d) });
    }
    u();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onGameOver, mIsRecording:", Boolean.valueOf(this.d) });
    }
    u();
  }
  
  protected String g()
  {
    return "GuessPictureGameRecordCtrl";
  }
  
  public boolean l()
  {
    super.l();
    v();
    this.m = false;
    this.l = System.currentTimeMillis();
    this.h = new QavVideoAudioRecorder();
    this.h.a(this.v, this);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "startRecord");
    }
    return true;
  }
  
  public void m()
  {
    if (!this.d)
    {
      QLog.e("GuessPictureGameRecordCtrl", 1, new Object[] { "endRecord, mIsRecording:", Boolean.valueOf(this.d) });
      return;
    }
    super.m();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.h;
    if (localQavVideoAudioRecorder != null)
    {
      localQavVideoAudioRecorder.a();
      this.h.d();
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onEncodeStart, mIsRecording:", Boolean.valueOf(this.d) });
    }
    if (this.d) {
      x();
    }
  }
  
  public void r()
  {
    if (!this.d)
    {
      QLog.e("GuessPictureGameRecordCtrl", 1, "onEncodeVideoFrame, mIsRecording false");
      m();
      return;
    }
    if (!x())
    {
      m();
      if (QLog.isColorLevel()) {
        QLog.e("GuessPictureGameRecordCtrl", 2, "onEncodeVideoFrame, stop record");
      }
    }
  }
  
  public void s() {}
  
  public void u()
  {
    for (;;)
    {
      try
      {
        boolean bool2 = QLog.isColorLevel();
        bool1 = true;
        if (bool2) {
          QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "stopScheduledRecord, mEncodeFinished:", Boolean.valueOf(this.n) });
        }
        this.o = true;
        if (!this.d)
        {
          ThreadManager.getSubThreadHandler().removeCallbacks(this.p);
          if ((this.n) && (this.o) && (this.j))
          {
            GuessPictureGameResultMgr localGuessPictureGameResultMgr = this.g;
            if (this.m) {
              break label125;
            }
            localGuessPictureGameResultMgr.a(bool1, this.k);
          }
        }
        else
        {
          m();
        }
        this.j = false;
        return;
      }
      finally {}
      label125:
      boolean bool1 = false;
    }
  }
  
  public void v()
  {
    this.s = 5120000;
    this.t = (RecordUtils.b().c * 1000);
    this.v = new EncodeConfig(this.g.b, this.q, this.r, this.s, 1, false, 0);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "initRecordCodecParams, bitRate:", Integer.valueOf(this.s) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessPictureGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */