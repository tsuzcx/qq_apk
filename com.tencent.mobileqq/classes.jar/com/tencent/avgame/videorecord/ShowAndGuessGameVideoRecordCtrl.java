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
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.avgame.config.data.AvGameConfBean.RecordParam;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.video.AVGameVideoLayer;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.AVGameCameraAssistant.CameraEventListener;
import com.tencent.avgame.qav.videorecord.GameImageData;
import com.tencent.avgame.qav.videorecord.GameVideoDarkCoverFilter;
import com.tencent.avgame.qav.videorecord.GameVideoImageFilter;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.RecordUtils;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qav.log.AVLog;
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

@RequiresApi(api=17)
public class ShowAndGuessGameVideoRecordCtrl
  extends GameVideoRecordBaseCtrl
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
  private IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private AVGameVideoLayer jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
  private AVGameCameraAssistant.CameraEventListener jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener = new ShowAndGuessGameVideoRecordCtrl.2(this);
  private volatile GameImageData jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData;
  private GameVideoDarkCoverFilter jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter;
  private GameVideoImageFilter jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
  private SimpleGameRoomStatusListener jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener = new ShowAndGuessGameVideoRecordCtrl.1(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private volatile GameImageData jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData;
  private GameVideoImageFilter jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString = null;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private volatile int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 10000L;
  private GameVideoImageFilter jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
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
  
  public ShowAndGuessGameVideoRecordCtrl(Context paramContext, AVGameVideoLayer paramAVGameVideoLayer)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = paramAVGameVideoLayer;
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter = new GameVideoImageFilter();
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter = new GameVideoDarkCoverFilter();
    this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter = new GameVideoImageFilter();
    this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter = new GameVideoImageFilter();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    paramContext = AVGameBusinessCtrl.b().a();
    if (paramContext != null) {
      paramContext.a(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener);
    }
    paramContext = RecordUtils.a();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Long = (paramContext.jdField_b_of_type_Int * 1000);
      this.jdField_d_of_type_Long = (paramContext.jdField_c_of_type_Int * 1000);
      long l = this.jdField_c_of_type_Long;
      if (l > 2000L) {
        this.jdField_c_of_type_Long = (l - 2000L);
      }
    }
  }
  
  private boolean l()
  {
    Player localPlayer = GameEngine.a().a().b();
    if (localPlayer != null) {
      return GameEngine.a().a().getAccount().equals(localPlayer.uin);
    }
    return false;
  }
  
  private boolean m()
  {
    return GameEngine.a().a().c() == 1;
  }
  
  private boolean n()
  {
    int j = GameEngine.a().a().a();
    return (j != 10) && (j != 0);
  }
  
  private void q()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.f = false;
    this.jdField_a_of_type_Long = 0L;
    this.h = false;
    this.g = false;
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (d()) {
      k();
    }
    q();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.b();
    }
  }
  
  protected String a()
  {
    return "ShowAndGuessGameVideoRecordCtrl";
  }
  
  public void a()
  {
    if (m())
    {
      boolean bool = d();
      GameRecordInfo localGameRecordInfo = GameEngine.a().a().a();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfGuessActionStart ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append(" ");
      localStringBuilder.append(localGameRecordInfo);
      AVLog.c(str, localStringBuilder.toString());
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
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (d())
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
      if (localQavVideoAudioRecorder != null)
      {
        boolean bool = localQavVideoAudioRecorder.a();
        if (!bool) {
          AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check audio not ready");
        }
        int j;
        if ((!this.f) && (!bool)) {
          j = 0;
        } else {
          j = 1;
        }
        if (j == 0)
        {
          if (this.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L)
          {
            this.f = true;
            AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
            j = 1;
          }
          else
          {
            AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
          }
        }
        else
        {
          this.f = true;
        }
        if (j != 0) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        }
      }
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeError ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramThrowable);
    AVLog.a(str, localStringBuilder.toString());
    this.i = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ShowAndGuessGameVideoRecordCtrl.4(this), 50L);
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDrawGameTopicTextureData ");
    boolean bool;
    if (paramBitmap != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" w:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" h:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" l:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" t:");
    localStringBuilder.append(paramInt4);
    AVLog.c((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramBitmap != null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData == null) {
        this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData = new GameImageData();
      }
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_c_of_type_Int = paramInt3;
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_d_of_type_Int = paramInt4;
      break label202;
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
      label202:
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void a(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      paramView = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTopicViewDismiss ");
      localStringBuilder.append(bool);
      AVLog.c(paramView, localStringBuilder.toString());
      a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if ((m()) && (l()))
    {
      paramBoolean = d();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnswerViewShow ");
      localStringBuilder.append(paramBoolean);
      AVLog.c(str, localStringBuilder.toString());
      if ((paramBoolean) && (paramView != null))
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        paramView.requestLayout();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ShowAndGuessGameVideoRecordCtrl.6(this, paramInt, paramView), 500L);
      }
    }
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeFinish ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    AVLog.c((String)localObject, localStringBuilder.toString());
    if (this.i)
    {
      boolean bool1 = false;
      this.i = false;
      try
      {
        boolean bool2 = new File(paramString).delete();
        bool1 = bool2;
      }
      catch (Exception paramString)
      {
        AVLog.a(this.jdField_a_of_type_JavaLangString, "onEncodeFinish", paramString);
      }
      this.jdField_b_of_type_JavaLangString = null;
      paramString = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeFinish delete=");
      ((StringBuilder)localObject).append(bool1);
      AVLog.c(paramString, ((StringBuilder)localObject).toString());
    }
    GameEngine.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableDrawDefaultBg ");
    localStringBuilder.append(paramBoolean);
    AVLog.c(str, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = AVGameUtil.a("avgame_actfallback@2x.png");
      }
      this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, 0, 0);
      return;
    }
    this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(null, 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (d())
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
      if ((localQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramInt1, paramInt2);
    this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter.a(paramInt1, paramInt2);
    this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null) {
      try
      {
        if (a()) {
          this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = new QavVideoAudioRecorder();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
        localObject2 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oom ");
        localStringBuilder.append(localOutOfMemoryError);
        AVLog.a((String)localObject2, localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      return new int[] { 0, 0 };
    }
    this.jdField_b_of_type_JavaLangString = b();
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doNeedStartRecord path=");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(", w=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", h=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", rh=");
    ((StringBuilder)localObject2).append(paramInt2);
    AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    int m = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.f;
    int k = paramInt1;
    int j = paramInt2;
    if (paramInt1 > m)
    {
      float f1 = m * 1.0F / paramInt1;
      j = (int)(paramInt2 * f1);
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doNeedStartRecord calc size, maxWidth=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(", realWidth=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(", realHeight=");
      ((StringBuilder)localObject2).append(j);
      AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
      k = m;
    }
    paramInt1 = j;
    if (j % 2 == 1) {
      paramInt1 = j + 1;
    }
    localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doNeedStartRecord rW=");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append(", rH=");
    ((StringBuilder)localObject2).append(paramInt1);
    AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    this.jdField_b_of_type_Int = k;
    this.jdField_c_of_type_Int = paramInt1;
    localObject1 = new EncodeConfig(this.jdField_b_of_type_JavaLangString, k, paramInt1, 5120000, 1, false, 0);
    ((EncodeConfig)localObject1).a(EGL14.eglGetCurrentContext());
    localObject2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localObject2 != null) {
      ((QavVideoAudioRecorder)localObject2).a((EncodeConfig)localObject1, this);
    } else {
      a(5, null);
    }
    return new int[] { k, paramInt1 };
  }
  
  public void b()
  {
    if (m())
    {
      boolean bool = d();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfGuessActionEnd ");
      localStringBuilder.append(bool);
      AVLog.c(str, localStringBuilder.toString());
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDrawGameAnswerTextureData ");
    boolean bool;
    if (paramBitmap != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" w:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" h:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" l:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" t:");
    localStringBuilder.append(paramInt4);
    AVLog.c((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramBitmap != null) {}
    try
    {
      if (this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData == null) {
        this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData = new GameImageData();
      }
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_b_of_type_Int = paramInt2;
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_c_of_type_Int = paramInt3;
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_d_of_type_Int = paramInt4;
      break label202;
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
      label202:
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void b(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTopicViewSwitch ");
      localStringBuilder.append(bool);
      AVLog.c(str, localStringBuilder.toString());
      if (paramView != null)
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ShowAndGuessGameVideoRecordCtrl.5(this, paramView), 500L);
      }
    }
  }
  
  public void c()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if ((m()) && (l()) && (n()))
    {
      Object localObject1 = GameEngine.a().a().a();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((GameRecordInfo)localObject1).startGameTimeMills > 0L)
        {
          this.jdField_b_of_type_Long = ((GameRecordInfo)localObject1).startGameTimeMills;
          this.jdField_b_of_type_JavaLangString = ((GameRecordInfo)localObject1).videoFilePath;
          this.jdField_c_of_type_JavaLangString = ((GameRecordInfo)localObject1).photoFilePath;
          bool1 = bool2;
          if (((GameRecordInfo)localObject1).photoFilePath != null)
          {
            bool1 = bool2;
            if (new File(((GameRecordInfo)localObject1).photoFilePath).exists()) {
              bool1 = true;
            }
          }
        }
      }
      Object localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStart ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(" ");
      localStringBuilder.append(bool1);
      AVLog.c((String)localObject2, localStringBuilder.toString());
      if (!bool1)
      {
        long l = this.jdField_c_of_type_Long - (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityStart remainTime:");
        ((StringBuilder)localObject2).append(l);
        AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
        l = Math.max(l, 1000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l);
      }
    }
  }
  
  public void c(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      paramView = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnswerViewDismiss ");
      localStringBuilder.append(bool);
      AVLog.c(paramView, localStringBuilder.toString());
      if (bool)
      {
        b(null, 0, 0, 0, 0);
        a(false, 0.0F, 0.0F, 0.0F, 0.0F);
      }
    }
  }
  
  public void d()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    if (m())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onGameOver ");
    if (m())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
          return;
        }
      }
    }
  }
  
  public boolean e()
  {
    if ((l()) && (super.e()))
    {
      q();
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.i = false;
      GameEngine.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
      GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
      return true;
    }
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    boolean bool3 = false;
    StringBuilder localStringBuilder;
    switch (j)
    {
    default: 
      return true;
    case 6: 
      if ((d()) && (f()))
      {
        a(false);
        return true;
      }
      break;
    case 5: 
      this.jdField_c_of_type_Boolean = false;
      return true;
    case 4: 
      AVLog.c(this.jdField_a_of_type_JavaLangString, "destroy");
      r();
      return true;
    case 3: 
      paramMessage = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("render no camera come.");
      localStringBuilder.append(f());
      localStringBuilder.append(d());
      AVLog.c(paramMessage, localStringBuilder.toString());
      if (f())
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        return true;
      }
      if (d())
      {
        paramMessage = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
        boolean bool1;
        if ((paramMessage != null) && (paramMessage.a())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramMessage = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
        boolean bool2 = bool3;
        if (paramMessage != null)
        {
          bool2 = bool3;
          if (paramMessage.b()) {
            bool2 = true;
          }
        }
        paramMessage = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("render no camera .");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" ");
        localStringBuilder.append(bool2);
        AVLog.c(paramMessage, localStringBuilder.toString());
        paramMessage = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
        if ((paramMessage != null) && (paramMessage.a() != null))
        {
          this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a().requestRender();
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
          return true;
        }
      }
      else
      {
        paramMessage = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("render no camera .");
        localStringBuilder.append(this.jdField_d_of_type_Boolean);
        AVLog.c(paramMessage, localStringBuilder.toString());
        if (this.jdField_d_of_type_Boolean)
        {
          paramMessage = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
          if ((paramMessage != null) && (paramMessage.a() != null))
          {
            this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a().requestRender();
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
            return true;
          }
        }
      }
      break;
    case 2: 
      paramMessage = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end record come.");
      localStringBuilder.append(d());
      AVLog.c(paramMessage, localStringBuilder.toString());
      if (d()) {
        k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      return true;
    case 1: 
      paramMessage = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start record come.");
      localStringBuilder.append(d());
      AVLog.c(paramMessage, localStringBuilder.toString());
      if (d()) {
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      paramMessage = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramMessage != null) {
        this.jdField_e_of_type_Boolean = CameraUtils.a(paramMessage).isCameraOpened(-1L);
      }
      if (e()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Long);
      } else {
        this.jdField_d_of_type_Boolean = true;
      }
      if (!f())
      {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "start record but camera close");
        a(true);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 200L);
      this.jdField_c_of_type_Boolean = true;
    }
    return true;
  }
  
  public boolean i()
  {
    return this.h;
  }
  
  public void j()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeRealStart ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    AVLog.c(str, localStringBuilder.toString());
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData != null) && (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap != null))
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
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.a();
    }
    q();
  }
  
  public boolean k()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData != null) && (this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void l()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onDestroy ");
    super.l();
    r();
    AVGameCameraAssistant localAVGameCameraAssistant = AVGameBusinessCtrl.b().a();
    if (localAVGameCameraAssistant != null) {
      localAVGameCameraAssistant.b(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = null;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = null;
  }
  
  public void m()
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      try
      {
        Object localObject = IntBuffer.allocate(this.jdField_d_of_type_Int * this.jdField_e_of_type_Int);
        GLES20.glReadPixels(0, 0, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int, 6408, 5121, (Buffer)localObject);
        localObject = ((IntBuffer)localObject).array();
        ThreadManager.getSubThreadHandler().post(new ShowAndGuessGameVideoRecordCtrl.3(this, (int[])localObject));
      }
      catch (Throwable localThrowable)
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFirstFramePhoto ");
        localStringBuilder.append(localThrowable);
        AVLog.c(str, localStringBuilder.toString());
      }
      if (this.jdField_d_of_type_Boolean)
      {
        AVLog.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto record first photo done");
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  public void n()
  {
    if (i()) {
      this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.h();
    }
    if (j()) {
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.h();
    }
    if (h()) {
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter.h();
    }
    if (k()) {
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.h();
    }
  }
  
  public void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
    if (localObject != null) {
      ((GameVideoImageFilter)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter;
    if (localObject != null) {
      ((GameVideoDarkCoverFilter)localObject).d();
    }
    localObject = this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
    if (localObject != null) {
      ((GameVideoImageFilter)localObject).d();
    }
    localObject = this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
    if (localObject != null) {
      ((GameVideoImageFilter)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl
 * JD-Core Version:    0.7.0.1
 */