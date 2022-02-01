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
  private long jdField_a_of_type_Long;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
  private GuessPictureGamePaintLogic jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic = new GuessPictureGamePaintLogic();
  private GuessPictureGameResultMgr jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr = new GuessPictureGameResultMgr();
  private IGuessPictureGameRecordCtrl.GameImageDataProvider jdField_a_of_type_ComTencentAvgameQavVideorecordIGuessPictureGameRecordCtrl$GameImageDataProvider;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private int f;
  
  public GuessPictureGameRecordCtrl(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 720)
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
    }
    else
    {
      this.jdField_b_of_type_Int = 720;
      this.jdField_c_of_type_Int = ((int)(paramInt2 * (720.0F / paramInt1)));
    }
    this.jdField_b_of_type_Int = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(this.jdField_c_of_type_Int);
  }
  
  private void b(IGuessPictureGameRecordCtrl.GameImageDataProvider paramGameImageDataProvider, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordIGuessPictureGameRecordCtrl$GameImageDataProvider = paramGameImageDataProvider;
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a(paramInt1, paramInt2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.a(b(), c(), this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic);
    this.jdField_a_of_type_JavaLangRunnable = new GuessPictureGameRecordCtrl.1(this);
  }
  
  private boolean f()
  {
    return GameEngine.a().a().c() == 2;
  }
  
  private boolean g()
  {
    if ((this.jdField_a_of_type_ComTencentAvgameQavVideorecordIGuessPictureGameRecordCtrl$GameImageDataProvider.b()) || (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.b()))
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvgameQavVideorecordIGuessPictureGameRecordCtrl$GameImageDataProvider.a();
      this.f = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a(localArrayList);
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.a(localArrayList);
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "addNextFrame, dataList size:", Integer.valueOf(localArrayList.size()) });
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) && (this.f > 0) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < this.jdField_e_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(3553, this.f, null, null, SystemClock.elapsedRealtimeNanos());
      return true;
    }
    return false;
  }
  
  protected String a()
  {
    return "GuessPictureGameRecordCtrl";
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.jdField_c_of_type_Boolean = true;
    k();
    QLog.e("GuessPictureGameRecordCtrl", 1, paramThrowable, new Object[] { "onEncodeError, errorCode", Integer.valueOf(paramInt) });
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewShow, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a(paramView, paramInt, paramBoolean);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.a(paramBoolean);
    }
  }
  
  public void a(IGuessPictureGameRecordCtrl.GameImageDataProvider paramGameImageDataProvider, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramGameImageDataProvider, paramInt1, paramInt2);
      long l = RecordUtils.b().jdField_b_of_type_Int * 1000;
      paramGameImageDataProvider = GameEngine.a().a().a();
      if ((f()) && (paramGameImageDataProvider.startGameTimeMills > 0L))
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
        this.jdField_a_of_type_Long = paramGameImageDataProvider.startGameTimeMills;
        l = Math.min(Math.max(System.currentTimeMillis() - this.jdField_a_of_type_Long, l), 0L);
      }
      else
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      GameEngine.a().a().a(null, null, this.jdField_a_of_type_Long);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord indeed, delayTime:", Long.valueOf(l) });
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
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onEncodeFinish, mRecordStopped:", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
      }
      this.jdField_d_of_type_Boolean = true;
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        paramString = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr;
        if (!this.jdField_c_of_type_Boolean) {
          bool1 = true;
        }
        paramString.a(bool1, this.jdField_a_of_type_Long);
      }
      return;
    }
    finally {}
  }
  
  public void a(ArrayList<GameImageData> paramArrayList)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.a(paramArrayList);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
      if ((localQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
  }
  
  public void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewDismiss, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a(paramView);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onActivityStop, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    m();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onGameOver, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    m();
  }
  
  public boolean e()
  {
    super.e();
    n();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig, this);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "startRecord");
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onEncodeStart, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
  }
  
  public void h()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.e("GuessPictureGameRecordCtrl", 1, "onEncodeVideoFrame, mIsRecording false");
      k();
      return;
    }
    if (!g())
    {
      k();
      if (QLog.isColorLevel()) {
        QLog.e("GuessPictureGameRecordCtrl", 2, "onEncodeVideoFrame, stop record");
      }
    }
  }
  
  public void i() {}
  
  public void k()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.e("GuessPictureGameRecordCtrl", 1, new Object[] { "endRecord, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    super.k();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null)
    {
      localQavVideoAudioRecorder.a();
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.b();
    }
  }
  
  public void m()
  {
    for (;;)
    {
      try
      {
        boolean bool2 = QLog.isColorLevel();
        bool1 = true;
        if (bool2) {
          QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "stopScheduledRecord, mEncodeFinished:", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
        }
        this.jdField_e_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean)
        {
          ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
          {
            GuessPictureGameResultMgr localGuessPictureGameResultMgr = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr;
            if (this.jdField_c_of_type_Boolean) {
              break label125;
            }
            localGuessPictureGameResultMgr.a(bool1, this.jdField_a_of_type_Long);
          }
        }
        else
        {
          k();
        }
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      finally {}
      label125:
      boolean bool1 = false;
    }
  }
  
  public void n()
  {
    this.jdField_d_of_type_Int = 5120000;
    this.jdField_e_of_type_Int = (RecordUtils.b().jdField_c_of_type_Int * 1000);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = new EncodeConfig(this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGameResultMgr.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 1, false, 0);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "initRecordCodecParams, bitRate:", Integer.valueOf(this.jdField_d_of_type_Int) });
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "onVideoMuxerWaiting");
    }
    if (this.jdField_a_of_type_Boolean)
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
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessPictureGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */