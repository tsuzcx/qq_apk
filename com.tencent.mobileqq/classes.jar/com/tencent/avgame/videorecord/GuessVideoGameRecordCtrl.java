package com.tencent.avgame.videorecord;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.video.AVGameVideoLayer;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameConfBean.RecordParam;
import com.tencent.avgame.util.RecordUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.qav.log.AVLog;
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import mqq.os.MqqHandler;

@RequiresApi(api=17)
public class GuessVideoGameRecordCtrl
  extends GameVideoRecordBaseCtrl
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
  private IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private AVGameVideoLayer jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
  private volatile GameImageData jdField_a_of_type_ComTencentAvgameVideorecordGameImageData;
  private GameVideoDarkCoverFilter jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter;
  private GameVideoImageFilter jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter;
  private SimpleGameRoomStatusListener jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener = new GuessVideoGameRecordCtrl.1(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private volatile GameImageData jdField_b_of_type_ComTencentAvgameVideorecordGameImageData;
  private GameVideoImageFilter jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString = null;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private volatile int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 10000L;
  private GameVideoImageFilter jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter;
  private volatile String jdField_c_of_type_JavaLangString = null;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private volatile int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = 15000L;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private volatile int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  private volatile boolean g = false;
  private volatile boolean h = false;
  private volatile boolean i = false;
  
  public GuessVideoGameRecordCtrl(Context paramContext, AVGameVideoLayer paramAVGameVideoLayer)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = paramAVGameVideoLayer;
    this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter = new GameVideoImageFilter();
    this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter = new GameVideoDarkCoverFilter();
    this.jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter = new GameVideoImageFilter();
    this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter = new GameVideoImageFilter();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    paramContext = RecordUtils.c();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Long = (paramContext.jdField_b_of_type_Int * 1000);
      this.jdField_d_of_type_Long = (paramContext.jdField_c_of_type_Int * 1000);
      if (this.jdField_c_of_type_Long > 1000L) {
        this.jdField_c_of_type_Long -= 1000L;
      }
    }
  }
  
  private boolean k()
  {
    return GameEngine.a().a().c() == 3;
  }
  
  private boolean l()
  {
    int j = GameEngine.a().a().a();
    return (j != 10) && (j != 0);
  }
  
  private void q()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.f = false;
    this.jdField_a_of_type_Long = 0L;
    this.h = false;
    this.g = false;
  }
  
  private void r()
  {
    if (d()) {
      k();
    }
    q();
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.b();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = null;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = null;
  }
  
  protected String a()
  {
    return "GuessVideoGameRecordCtrl";
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    int k = 1;
    int j;
    if ((d()) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a();
      if (!bool) {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check audio not ready");
      }
      if ((!this.f) && (!bool)) {
        break label129;
      }
      j = 1;
      if (j != 0) {
        break label147;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) {
        break label135;
      }
      this.f = true;
      AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
      j = k;
    }
    for (;;)
    {
      if (j != 0) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      }
      return;
      label129:
      j = 0;
      break;
      label135:
      AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
      continue;
      label147:
      this.f = true;
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    AVLog.a(this.jdField_a_of_type_JavaLangString, "onEncodeError " + this.jdField_b_of_type_JavaLangString + " " + paramInt + " " + paramThrowable);
    this.i = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessVideoGameRecordCtrl.3(this), 50L);
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setDrawGameTopicTextureData ");
    boolean bool;
    if (paramBitmap != null)
    {
      bool = true;
      AVLog.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
      localObject = this.jdField_a_of_type_JavaLangObject;
      if (paramBitmap == null) {
        break label177;
      }
    }
    for (;;)
    {
      label177:
      try
      {
        if (this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData == null) {
          this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData = new GameImageData();
        }
        this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData.jdField_c_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData.jdField_d_of_type_Int = paramInt4;
        this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData = null;
    }
  }
  
  public void a(View paramView)
  {
    if (k())
    {
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onTopicViewDismiss ");
      a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (k())
    {
      paramBoolean = d();
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewShow " + paramBoolean);
      if ((paramBoolean) && (paramView != null))
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        paramView.requestLayout();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessVideoGameRecordCtrl.5(this, paramInt, paramView), 500L);
      }
    }
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
  }
  
  public void a(String paramString)
  {
    boolean bool1 = false;
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish " + this.jdField_b_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString);
    if (this.i) {
      this.i = false;
    }
    try
    {
      boolean bool2 = new File(paramString).delete();
      bool1 = bool2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        AVLog.a(this.jdField_a_of_type_JavaLangString, "onEncodeFinish", paramString);
      }
    }
    this.jdField_b_of_type_JavaLangString = null;
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish delete=" + bool1);
    GameEngine.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    AVLog.c(this.jdField_a_of_type_JavaLangString, "enableDrawDefaultBg " + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = AVGameUtils.a("avgame_actfallback@2x.png");
      }
      this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, 0, 0);
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a() != null)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a().requestRender();
      }
      return;
    }
    this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(null, 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((d()) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(paramInt1, paramInt2);
    this.jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter.a(paramInt1, paramInt2);
    this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(paramInt1, paramInt2);
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.f = false;
    if (!b())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      return new int[] { 0, 0 };
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null) {}
    int j;
    try
    {
      if (a()) {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
      }
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = true;
        return new int[] { 0, 0 };
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
        AVLog.a(this.jdField_a_of_type_JavaLangString, "oom " + localOutOfMemoryError);
      }
      this.jdField_b_of_type_JavaLangString = b();
      AVLog.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord path=" + this.jdField_b_of_type_JavaLangString + ", w=" + paramInt1 + ", h=" + paramInt2 + ", rh=" + paramInt2);
      j = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.f;
      if (paramInt1 <= j) {
        break label460;
      }
    }
    paramInt2 = (int)(1.0F * j / paramInt1 * paramInt2);
    AVLog.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord calc size, maxWidth=" + j + ", realWidth=" + j + ", realHeight=" + paramInt2);
    paramInt1 = j;
    label460:
    for (;;)
    {
      if (paramInt2 % 2 == 1) {
        paramInt2 += 1;
      }
      for (;;)
      {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord rW=" + paramInt1 + ", rH=" + paramInt2);
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = paramInt2;
        EncodeConfig localEncodeConfig = new EncodeConfig(this.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, 5120000, 1, false, 0);
        localEncodeConfig.a(EGL14.eglGetCurrentContext());
        if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(localEncodeConfig, this);
        }
        for (;;)
        {
          return new int[] { paramInt1, paramInt2 };
          a(5, null);
        }
      }
    }
  }
  
  public void b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setDrawGameAnswerTextureData ");
    boolean bool;
    if (paramBitmap != null)
    {
      bool = true;
      AVLog.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
      localObject = this.jdField_b_of_type_JavaLangObject;
      if (paramBitmap == null) {
        break label178;
      }
    }
    for (;;)
    {
      label178:
      try
      {
        if (this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData == null) {
          this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData = new GameImageData();
        }
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData.jdField_b_of_type_Int = paramInt2;
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData.jdField_c_of_type_Int = paramInt3;
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData.jdField_d_of_type_Int = paramInt4;
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData = null;
    }
  }
  
  public void b(View paramView)
  {
    if (k())
    {
      boolean bool = d();
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onTopicViewSwitch " + bool);
      if (paramView != null)
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessVideoGameRecordCtrl.4(this, paramView), 500L);
      }
    }
  }
  
  public void b(String paramString)
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onPushVideoFirstFrame " + paramString);
    this.jdField_e_of_type_Boolean = false;
    if (d()) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    }
  }
  
  public void c()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if ((k()) && (l()))
    {
      GameRecordInfo localGameRecordInfo = GameEngine.a().a().a();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localGameRecordInfo != null)
      {
        bool1 = bool2;
        if (localGameRecordInfo.startGameTimeMills > 0L)
        {
          this.jdField_b_of_type_Long = localGameRecordInfo.startGameTimeMills;
          this.jdField_b_of_type_JavaLangString = localGameRecordInfo.videoFilePath;
          this.jdField_c_of_type_JavaLangString = localGameRecordInfo.photoFilePath;
          bool1 = bool2;
          if (localGameRecordInfo.photoFilePath != null)
          {
            bool1 = bool2;
            if (new File(localGameRecordInfo.photoFilePath).exists()) {
              bool1 = true;
            }
          }
        }
      }
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStart " + localGameRecordInfo + " " + bool1);
      if (!bool1)
      {
        long l = this.jdField_c_of_type_Long - (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStart remainTime:" + l);
        l = Math.max(l, 1000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l);
      }
    }
  }
  
  public void c(View paramView)
  {
    if (k())
    {
      boolean bool = d();
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewDismiss " + bool);
      if (bool)
      {
        b(null, 0, 0, 0, 0);
        a(false, 0.0F, 0.0F, 0.0F, 0.0F);
      }
    }
  }
  
  public void c(String paramString)
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onPushVideoFrameEnd " + paramString);
    this.jdField_e_of_type_Boolean = true;
    if (d()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 50L);
    }
  }
  
  public void d()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    if (k())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    if (k())
    {
      boolean bool = d();
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onGameOver " + bool);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData = null;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData = null;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (super.e())
    {
      q();
      GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.i = false;
      bool = true;
    }
    return bool;
  }
  
  public void f()
  {
    if (k())
    {
      boolean bool = d();
      GameRecordInfo localGameRecordInfo = GameEngine.a().a().a();
      AVLog.c(this.jdField_a_of_type_JavaLangString, "onGameStart " + bool + " " + this.jdField_b_of_type_Long + " " + localGameRecordInfo);
      if (localGameRecordInfo.startGameTimeMills == 0L)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        GameEngine.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.jdField_c_of_type_Long);
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          AVLog.c(this.jdField_a_of_type_JavaLangString, "start record come.");
          if (d()) {
            k();
          }
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          if (e()) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Long);
          }
          for (;;)
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 200L);
            AVLog.c(this.jdField_a_of_type_JavaLangString, "start record come videoEnding " + this.jdField_e_of_type_Boolean);
            if (!this.jdField_e_of_type_Boolean) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 10L);
            return true;
            this.jdField_d_of_type_Boolean = true;
          }
          AVLog.c(this.jdField_a_of_type_JavaLangString, "end record come." + d());
        } while (!d());
        k();
        return true;
        AVLog.c(this.jdField_a_of_type_JavaLangString, "destroy");
        r();
        return true;
        this.jdField_c_of_type_Boolean = false;
        return true;
      } while (!d());
      a(false);
      return true;
      if ((!d()) || (!this.jdField_e_of_type_Boolean)) {
        break;
      }
      AVLog.c(this.jdField_a_of_type_JavaLangString, "render no call .");
    } while ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a() == null));
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a().requestRender();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 50L);
    return true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    return true;
  }
  
  public boolean i()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData != null) && (this.jdField_a_of_type_ComTencentAvgameVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void j()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onEncodeRealStart " + this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData != null) && (this.jdField_b_of_type_ComTencentAvgameVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void k()
  {
    super.k();
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a();
    }
    q();
  }
  
  public void l()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onDestroy ");
    super.l();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    r();
  }
  
  public void m()
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = true;
    }
    try
    {
      Object localObject = IntBuffer.allocate(this.jdField_d_of_type_Int * this.jdField_e_of_type_Int);
      GLES20.glReadPixels(0, 0, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int, 6408, 5121, (Buffer)localObject);
      localObject = ((IntBuffer)localObject).array();
      ThreadManager.getSubThreadHandler().post(new GuessVideoGameRecordCtrl.2(this, (int[])localObject));
      if (this.jdField_d_of_type_Boolean)
      {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto record first photo done");
        this.jdField_d_of_type_Boolean = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto " + localThrowable);
      }
    }
  }
  
  public void n()
  {
    if (h()) {
      this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.h();
    }
    if (i()) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.h();
    }
    if (g()) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter.h();
    }
    if (j()) {
      this.jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.h();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter != null) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.d();
    }
    if (this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter != null) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGameVideoDarkCoverFilter.d();
    }
    if (this.jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter != null) {
      this.jdField_b_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.d();
    }
    if (this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter != null) {
      this.jdField_c_of_type_ComTencentAvgameVideorecordGameVideoImageFilter.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */