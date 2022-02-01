package com.tencent.avgame.videorecord;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.avgame.config.data.AvGameConfBean.RecordParam;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gameroom.video.AVGameVideoLayer;
import com.tencent.avgame.qav.videorecord.GameImageData;
import com.tencent.avgame.qav.videorecord.GameVideoDarkCoverFilter;
import com.tencent.avgame.qav.videorecord.GameVideoImageFilter;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.RecordUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qav.log.AVLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import mqq.os.MqqHandler;

@RequiresApi(api=17)
public class GuessSongGameRecordCtrl
  extends GameVideoRecordBaseCtrl
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private QavVideoAudioRecorder jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder = null;
  private AVGameVideoLayer jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
  private volatile GameImageData jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData;
  private GameVideoDarkCoverFilter jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter = new GameVideoDarkCoverFilter();
  private GameVideoImageFilter jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter = new GameVideoImageFilter();
  private SimpleGameRoomStatusListener jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener = new GuessSongGameRecordCtrl.1(this);
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final int jdField_b_of_type_Int = 720;
  private volatile long jdField_b_of_type_Long;
  private volatile GameImageData jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData;
  private GameVideoImageFilter jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter = new GameVideoImageFilter();
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 720;
  private long jdField_c_of_type_Long = 10000L;
  private GameVideoImageFilter jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter = new GameVideoImageFilter();
  private volatile String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 15000L;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private volatile boolean e = false;
  private volatile boolean f = false;
  private volatile boolean g = false;
  
  public GuessSongGameRecordCtrl(Context paramContext, AVGameVideoLayer paramAVGameVideoLayer)
  {
    super(paramContext);
    paramContext = RecordUtils.d();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Long = (paramContext.jdField_b_of_type_Int * 1000);
      this.jdField_d_of_type_Long = (paramContext.jdField_c_of_type_Int * 1000);
      long l = this.jdField_c_of_type_Long;
      if (l > 1000L) {
        this.jdField_c_of_type_Long = (l - 1000L);
      }
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = paramAVGameVideoLayer;
  }
  
  private boolean j()
  {
    int i = GameEngine.a().a().a();
    return (i != 10) && (i != 0);
  }
  
  private void r()
  {
    if (d()) {
      k();
    }
    s();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.b();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = null;
  }
  
  private void s()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.f = false;
    this.e = false;
  }
  
  protected String a()
  {
    return "GuessSongGameRecordCtrl";
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
        int i;
        if ((!this.jdField_b_of_type_Boolean) && (!bool)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          if (this.jdField_a_of_type_Long <= 0L) {
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L)
          {
            this.jdField_b_of_type_Boolean = true;
            AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
            i = 1;
          }
          else
          {
            AVLog.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
          }
        }
        else
        {
          this.jdField_b_of_type_Boolean = true;
        }
        if (i != 0) {
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
    this.g = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessSongGameRecordCtrl.3(this), 50L);
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
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.d = paramInt4;
      break label197;
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
      label197:
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void a(View paramView)
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onTopicViewDismiss ");
    a(null, 0, 0, 0, 0);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessSongGameRecordCtrl.4(this, paramInt, paramView), 500L);
    }
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
    if (this.g)
    {
      boolean bool1 = false;
      this.g = false;
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
    this.f = paramBoolean;
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enableDrawDefaultBg ");
    ((StringBuilder)localObject2).append(paramBoolean);
    AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = AVGameUtil.a("avgame_songfallback@2x.png");
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          localObject1 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject1).eraseColor(-1144611);
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter;
        ((GameVideoImageFilter)localObject2).a((Bitmap)localObject1, ((GameVideoImageFilter)localObject2).a(), this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.b(), 0, 0);
      }
    }
    else
    {
      this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e = paramBoolean;
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
  
  public int[] a()
  {
    if (!b())
    {
      this.jdField_a_of_type_Boolean = false;
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
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oom ");
        localStringBuilder.append(localOutOfMemoryError);
        AVLog.a((String)localObject, localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return new int[] { 0, 0 };
    }
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(720, 720);
    this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(720, 720);
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter.a(720, 720);
    this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(720, 720);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = b();
    this.jdField_c_of_type_JavaLangString = c();
    AVLog.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord rW=720, rH=720");
    EncodeConfig localEncodeConfig = new EncodeConfig(this.jdField_b_of_type_JavaLangString, 720, 720, 5120000, 1, false, 0);
    localEncodeConfig.a(EGL14.eglGetCurrentContext());
    Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localObject != null) {
      ((QavVideoAudioRecorder)localObject).a(localEncodeConfig, this);
    } else {
      a(5, null);
    }
    return new int[] { 720, 720 };
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
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData.d = paramInt4;
      break label198;
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
      label198:
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void b(View paramView)
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessSongGameRecordCtrl.5(this, paramView), 500L);
    }
  }
  
  public void c()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if (j())
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
  
  public void d()
  {
    AVLog.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void e()
  {
    boolean bool = d();
    ??? = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameOver ");
    localStringBuilder.append(bool);
    AVLog.c((String)???, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
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
  
  public boolean e()
  {
    if (super.e())
    {
      s();
      GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.g = false;
      return true;
    }
    return false;
  }
  
  public void f()
  {
    boolean bool = d();
    GameRecordInfo localGameRecordInfo = GameEngine.a().a().a();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameStart ");
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
  
  public boolean f()
  {
    return this.e;
  }
  
  public void g() {}
  
  public boolean g()
  {
    return this.f;
  }
  
  public void h() {}
  
  public boolean h()
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
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return true;
          }
          if (d())
          {
            AVLog.c(this.jdField_a_of_type_JavaLangString, "render call .");
            paramMessage = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
            if ((paramMessage != null) && (paramMessage.a() != null))
            {
              this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a().requestRender();
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 50L);
              return true;
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
            return true;
          }
        }
        else
        {
          AVLog.c(this.jdField_a_of_type_JavaLangString, "destroy");
          r();
          return true;
        }
      }
      else
      {
        paramMessage = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("end record come.");
        localStringBuilder.append(d());
        AVLog.c(paramMessage, localStringBuilder.toString());
        if (d())
        {
          k();
          paramMessage = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer;
          if ((paramMessage != null) && (paramMessage.a() != null))
          {
            this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a().requestRender();
            return true;
          }
        }
      }
    }
    else
    {
      AVLog.c(this.jdField_a_of_type_JavaLangString, "start record come.");
      if (d()) {
        k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (e())
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    return true;
  }
  
  public boolean i()
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
  
  public void k()
  {
    super.k();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavVideoAudioRecorder;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.a();
    }
    s();
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
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
    if (g()) {
      this.jdField_c_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.h();
    }
    if (h()) {
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.h();
    }
    if (f()) {
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameVideoDarkCoverFilter.h();
    }
    if (i()) {
      this.jdField_b_of_type_ComTencentAvgameQavVideorecordGameVideoImageFilter.h();
    }
    n();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
  }
  
  public void n()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      try
      {
        Object localObject = IntBuffer.allocate(518400);
        GLES20.glReadPixels(0, 0, 720, 720, 6408, 5121, (Buffer)localObject);
        localObject = ((IntBuffer)localObject).array();
        ThreadManager.getSubThreadHandler().post(new GuessSongGameRecordCtrl.2(this, (int[])localObject));
        return;
      }
      catch (Throwable localThrowable)
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFirstFramePhoto ");
        localStringBuilder.append(localThrowable);
        AVLog.c(str, localStringBuilder.toString());
      }
    }
  }
  
  public void p()
  {
    if (d())
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(720, 720, 33984);
        a(true);
        a();
        this.jdField_c_of_type_Boolean = true;
      }
      m();
      a(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
    }
  }
  
  public void q()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      AVLog.c(this.jdField_a_of_type_JavaLangString, "releaseGameTexture");
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
      localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      if (localObject != null)
      {
        ((RenderBuffer)localObject).destroy();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */