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
import com.tencent.avgame.config.data.AvGameConfBean.RecordParam;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
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
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import mqq.os.MqqHandler;

@RequiresApi(api=17)
public class GuessVideoGameRecordCtrl
  extends GameVideoRecordBaseCtrl
  implements Handler.Callback
{
  private GameVideoImageFilter A;
  private GameVideoDarkCoverFilter B;
  private Bitmap C;
  private volatile boolean D = false;
  private volatile long E;
  private Handler F;
  private long G = 10000L;
  private long H = 15000L;
  private AVGameVideoLayer I;
  private IStagePresenter J;
  private SimpleGameRoomStatusListener K = new GuessVideoGameRecordCtrl.1(this);
  private volatile int f;
  private volatile int g;
  private volatile int h;
  private volatile int i;
  private volatile String j = null;
  private volatile String k = null;
  private volatile boolean l = false;
  private volatile boolean m = false;
  private volatile boolean n = false;
  private volatile boolean o = false;
  private boolean p = false;
  private long q = 0L;
  private QavVideoAudioRecorder r = null;
  private volatile GameImageData s;
  private volatile GameImageData t;
  private Object u = new Object();
  private Object v = new Object();
  private volatile boolean w = false;
  private volatile boolean x = false;
  private GameVideoImageFilter y;
  private GameVideoImageFilter z;
  
  public GuessVideoGameRecordCtrl(Context paramContext, AVGameVideoLayer paramAVGameVideoLayer)
  {
    super(paramContext);
    this.I = paramAVGameVideoLayer;
    this.y = new GameVideoImageFilter();
    this.B = new GameVideoDarkCoverFilter();
    this.z = new GameVideoImageFilter();
    this.A = new GameVideoImageFilter();
    this.F = new Handler(this);
    paramContext = RecordUtils.c();
    if (paramContext != null)
    {
      this.G = (paramContext.b * 1000);
      this.H = (paramContext.c * 1000);
      long l1 = this.G;
      if (l1 > 1000L) {
        this.G = (l1 - 1000L);
      }
    }
  }
  
  private void C()
  {
    GameEngine.a().b(this.K);
    this.F.removeMessages(6);
    this.p = false;
    this.q = 0L;
    this.x = false;
    this.w = false;
  }
  
  private void D()
  {
    if (k()) {
      m();
    }
    C();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.r;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.d();
    }
    this.I = null;
    this.J = null;
  }
  
  private boolean E()
  {
    return GameEngine.a().s().o() == 3;
  }
  
  private boolean G()
  {
    int i1 = GameEngine.a().s().j();
    return (i1 != 10) && (i1 != 0);
  }
  
  public boolean A()
  {
    for (;;)
    {
      synchronized (this.v)
      {
        if ((this.t != null) && (this.t.a != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void B()
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((GameVideoImageFilter)localObject).d();
    }
    localObject = this.B;
    if (localObject != null) {
      ((GameVideoDarkCoverFilter)localObject).d();
    }
    localObject = this.z;
    if (localObject != null) {
      ((GameVideoImageFilter)localObject).d();
    }
    localObject = this.A;
    if (localObject != null) {
      ((GameVideoImageFilter)localObject).d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (k())
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.r;
      if (localQavVideoAudioRecorder != null)
      {
        boolean bool = localQavVideoAudioRecorder.b();
        if (!bool) {
          AVLog.c(this.a, "videoFrameAvailable check audio not ready");
        }
        int i1;
        if ((!this.p) && (!bool)) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i1 == 0)
        {
          if (this.q <= 0L) {
            this.q = System.currentTimeMillis();
          }
          if (System.currentTimeMillis() - this.q > 1000L)
          {
            this.p = true;
            AVLog.c(this.a, "videoFrameAvailable check timeout");
            i1 = 1;
          }
          else
          {
            AVLog.c(this.a, "videoFrameAvailable checking");
          }
        }
        else
        {
          this.p = true;
        }
        if (i1 != 0) {
          this.r.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        }
      }
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeError ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramThrowable);
    AVLog.a(str, localStringBuilder.toString());
    this.D = true;
    this.F.sendEmptyMessage(2);
    this.F.postDelayed(new GuessVideoGameRecordCtrl.3(this), 50L);
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.a;
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
    localObject = this.u;
    if (paramBitmap != null) {}
    try
    {
      if (this.s == null) {
        this.s = new GameImageData();
      }
      this.s.a = paramBitmap;
      this.s.b = paramInt1;
      this.s.c = paramInt2;
      this.s.d = paramInt3;
      this.s.e = paramInt4;
      break label202;
      this.s = null;
      label202:
      this.y.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void a(View paramView)
  {
    if (E())
    {
      AVLog.c(this.a, "onTopicViewDismiss ");
      a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (E())
    {
      paramBoolean = k();
      String str = this.a;
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
        this.F.postDelayed(new GuessVideoGameRecordCtrl.5(this, paramInt, paramView), 500L);
      }
    }
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.J = paramIStagePresenter;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeFinish ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.k);
    AVLog.c((String)localObject, localStringBuilder.toString());
    if (this.D)
    {
      boolean bool1 = false;
      this.D = false;
      try
      {
        boolean bool2 = new File(paramString).delete();
        bool1 = bool2;
      }
      catch (Exception paramString)
      {
        AVLog.a(this.a, "onEncodeFinish", paramString);
      }
      this.j = null;
      paramString = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeFinish delete=");
      ((StringBuilder)localObject).append(bool1);
      AVLog.c(paramString, ((StringBuilder)localObject).toString());
    }
    GameEngine.a().s().a(this.j, this.k, this.E);
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableDrawDefaultBg ");
    localStringBuilder.append(paramBoolean);
    AVLog.c((String)localObject, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (this.C == null) {
        this.C = AVGameUtil.c("avgame_actfallback@2x.png");
      }
      this.A.a(this.C, this.h, this.i, 0, 0);
      localObject = this.I;
      if ((localObject != null) && (((AVGameVideoLayer)localObject).i() != null)) {
        this.I.i().requestRender();
      }
    }
    else
    {
      this.A.a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.w = paramBoolean;
    this.B.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (k())
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.r;
      if ((localQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    this.y.a(paramInt1, paramInt2);
    this.z.a(paramInt1, paramInt2);
    this.B.a(paramInt1, paramInt2);
    this.A.a(paramInt1, paramInt2);
    this.h = paramInt1;
    this.i = paramInt2;
    this.k = p();
    this.l = false;
    this.j = null;
    this.p = false;
    if (!i())
    {
      this.d = false;
      this.n = true;
      return new int[] { 0, 0 };
    }
    if (this.r == null) {
      try
      {
        if (h()) {
          this.r = new QavVideoAudioRecorder();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.r = null;
        localObject2 = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oom ");
        localStringBuilder.append(localOutOfMemoryError);
        AVLog.a((String)localObject2, localStringBuilder.toString());
      }
    }
    if (this.r == null)
    {
      this.d = false;
      this.n = true;
      return new int[] { 0, 0 };
    }
    this.j = o();
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doNeedStartRecord path=");
    ((StringBuilder)localObject2).append(this.j);
    ((StringBuilder)localObject2).append(", w=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", h=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", rh=");
    ((StringBuilder)localObject2).append(paramInt2);
    AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    int i3 = this.b.g;
    int i2 = paramInt1;
    int i1 = paramInt2;
    if (paramInt1 > i3)
    {
      float f1 = i3 * 1.0F / paramInt1;
      i1 = (int)(paramInt2 * f1);
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doNeedStartRecord calc size, maxWidth=");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(", realWidth=");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(", realHeight=");
      ((StringBuilder)localObject2).append(i1);
      AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
      i2 = i3;
    }
    paramInt1 = i1;
    if (i1 % 2 == 1) {
      paramInt1 = i1 + 1;
    }
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doNeedStartRecord rW=");
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append(", rH=");
    ((StringBuilder)localObject2).append(paramInt1);
    AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    this.f = i2;
    this.g = paramInt1;
    localObject1 = new EncodeConfig(this.j, i2, paramInt1, 5120000, 1, false, 0);
    ((EncodeConfig)localObject1).a(EGL14.eglGetCurrentContext());
    localObject2 = this.r;
    if (localObject2 != null) {
      ((QavVideoAudioRecorder)localObject2).a((EncodeConfig)localObject1, this);
    } else {
      a(5, null);
    }
    return new int[] { i2, paramInt1 };
  }
  
  public void b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.a;
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
    localObject = this.v;
    if (paramBitmap != null) {}
    try
    {
      if (this.t == null) {
        this.t = new GameImageData();
      }
      this.t.a = paramBitmap;
      this.t.b = paramInt1;
      this.t.c = paramInt2;
      this.t.d = paramInt3;
      this.t.e = paramInt4;
      break label202;
      this.t = null;
      label202:
      this.z.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void b(View paramView)
  {
    if (E())
    {
      boolean bool = k();
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTopicViewSwitch ");
      localStringBuilder.append(bool);
      AVLog.c(str, localStringBuilder.toString());
      if (paramView != null)
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        this.F.postDelayed(new GuessVideoGameRecordCtrl.4(this, paramView), 500L);
      }
    }
  }
  
  public void b(String paramString)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPushVideoFirstFrame ");
    localStringBuilder.append(paramString);
    AVLog.c(str, localStringBuilder.toString());
    this.o = false;
    if (k()) {
      this.F.removeMessages(6);
    }
  }
  
  public void c()
  {
    AVLog.c(this.a, "onActivityStart ");
    if ((E()) && (G()))
    {
      Object localObject1 = GameEngine.a().s().v();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((GameRecordInfo)localObject1).startGameTimeMills > 0L)
        {
          this.E = ((GameRecordInfo)localObject1).startGameTimeMills;
          this.j = ((GameRecordInfo)localObject1).videoFilePath;
          this.k = ((GameRecordInfo)localObject1).photoFilePath;
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
      Object localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStart ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(" ");
      localStringBuilder.append(bool1);
      AVLog.c((String)localObject2, localStringBuilder.toString());
      if (!bool1)
      {
        long l1 = this.G - (System.currentTimeMillis() - this.E);
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityStart remainTime:");
        ((StringBuilder)localObject2).append(l1);
        AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
        l1 = Math.max(l1, 1000L);
        this.F.sendEmptyMessageDelayed(1, l1);
      }
    }
  }
  
  public void c(View paramView)
  {
    if (E())
    {
      boolean bool = k();
      paramView = this.a;
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
  
  public void c(String paramString)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPushVideoFrameEnd ");
    localStringBuilder.append(paramString);
    AVLog.c(str, localStringBuilder.toString());
    this.o = true;
    if (k()) {
      this.F.sendEmptyMessageDelayed(6, 50L);
    }
  }
  
  public void d()
  {
    AVLog.c(this.a, "onActivityStop ");
    if (E())
    {
      this.F.removeCallbacksAndMessages(null);
      this.F.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    if (E())
    {
      boolean bool = k();
      ??? = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGameOver ");
      localStringBuilder.append(bool);
      AVLog.c((String)???, localStringBuilder.toString());
      this.F.removeCallbacksAndMessages(null);
      this.F.sendEmptyMessage(2);
      synchronized (this.v)
      {
        this.t = null;
        synchronized (this.u)
        {
          this.s = null;
          return;
        }
      }
    }
  }
  
  public void f()
  {
    if (E())
    {
      boolean bool = k();
      GameRecordInfo localGameRecordInfo = GameEngine.a().s().v();
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGameStart ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.E);
      localStringBuilder.append(" ");
      localStringBuilder.append(localGameRecordInfo);
      AVLog.c(str, localStringBuilder.toString());
      if (localGameRecordInfo.startGameTimeMills == 0L)
      {
        this.E = System.currentTimeMillis();
        this.k = null;
        this.j = null;
        GameEngine.a().s().a(this.j, this.k, this.E);
        this.F.removeCallbacksAndMessages(null);
        this.F.sendEmptyMessageDelayed(1, this.G);
      }
    }
  }
  
  protected String g()
  {
    return "GuessVideoGameRecordCtrl";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 6: 
      if ((k()) && (this.o))
      {
        AVLog.c(this.a, "render no call .");
        paramMessage = this.I;
        if ((paramMessage != null) && (paramMessage.i() != null))
        {
          this.I.i().requestRender();
          this.F.sendEmptyMessageDelayed(6, 50L);
          return true;
        }
      }
      else
      {
        this.F.removeMessages(6);
        return true;
      }
      break;
    case 5: 
      if (k())
      {
        a(false);
        return true;
      }
      break;
    case 4: 
      this.m = false;
      return true;
    case 3: 
      AVLog.c(this.a, "destroy");
      D();
      return true;
    case 2: 
      paramMessage = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end record come.");
      localStringBuilder.append(k());
      AVLog.c(paramMessage, localStringBuilder.toString());
      if (k())
      {
        m();
        return true;
      }
      break;
    case 1: 
      AVLog.c(this.a, "start record come.");
      if (k()) {
        m();
      }
      this.F.removeCallbacksAndMessages(null);
      if (l()) {
        this.F.sendEmptyMessageDelayed(2, this.H);
      } else {
        this.n = true;
      }
      this.m = true;
      this.F.sendEmptyMessageDelayed(4, 200L);
      paramMessage = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start record come videoEnding ");
      localStringBuilder.append(this.o);
      AVLog.c(paramMessage, localStringBuilder.toString());
      if (this.o) {
        this.F.sendEmptyMessageDelayed(6, 10L);
      }
      break;
    }
    return true;
  }
  
  public boolean l()
  {
    if (super.l())
    {
      C();
      GameEngine.a().a(this.K);
      this.j = null;
      this.k = null;
      this.D = false;
      return true;
    }
    return false;
  }
  
  public void m()
  {
    super.m();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.r;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.a();
    }
    C();
  }
  
  public void n()
  {
    AVLog.c(this.a, "onDestroy ");
    super.n();
    this.F.removeCallbacksAndMessages(null);
    D();
  }
  
  public void t()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeRealStart ");
    localStringBuilder.append(this.j);
    AVLog.c(str, localStringBuilder.toString());
  }
  
  public void u()
  {
    if ((!this.l) && (!this.m))
    {
      this.l = true;
      try
      {
        Object localObject = IntBuffer.allocate(this.h * this.i);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, (Buffer)localObject);
        localObject = ((IntBuffer)localObject).array();
        ThreadManager.getSubThreadHandler().post(new GuessVideoGameRecordCtrl.2(this, (int[])localObject));
      }
      catch (Throwable localThrowable)
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFirstFramePhoto ");
        localStringBuilder.append(localThrowable);
        AVLog.c(str, localStringBuilder.toString());
      }
      if (this.n)
      {
        AVLog.c(this.a, "checkFirstFramePhoto record first photo done");
        this.n = false;
      }
    }
  }
  
  public void v()
  {
    if (y()) {
      this.A.l();
    }
    if (z()) {
      this.y.l();
    }
    if (x()) {
      this.B.l();
    }
    if (A()) {
      this.z.l();
    }
  }
  
  public boolean w()
  {
    return this.n;
  }
  
  public boolean x()
  {
    return this.w;
  }
  
  public boolean y()
  {
    return this.x;
  }
  
  public boolean z()
  {
    for (;;)
    {
      synchronized (this.u)
      {
        if ((this.s != null) && (this.s.a != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */