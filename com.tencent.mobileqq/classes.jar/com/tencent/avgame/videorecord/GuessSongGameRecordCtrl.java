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
  private volatile boolean A = false;
  private volatile long B;
  private Handler C = new Handler(this);
  private long D = 10000L;
  private long E = 15000L;
  private AVGameVideoLayer F;
  private SimpleGameRoomStatusListener G = new GuessSongGameRecordCtrl.1(this);
  private final int f = 720;
  private final int g = 720;
  private volatile String h = null;
  private volatile String i = null;
  private boolean j = false;
  private boolean k = false;
  private long l = 0L;
  private volatile boolean m = false;
  private QavVideoAudioRecorder n = null;
  private volatile GameImageData o;
  private volatile GameImageData p;
  private Object q = new Object();
  private Object r = new Object();
  private volatile boolean s = false;
  private volatile boolean t = false;
  private GameVideoImageFilter u = new GameVideoImageFilter();
  private GameVideoImageFilter v = new GameVideoImageFilter();
  private GameVideoImageFilter w = new GameVideoImageFilter();
  private GameVideoDarkCoverFilter x = new GameVideoDarkCoverFilter();
  private RenderBuffer y;
  private Bitmap z;
  
  public GuessSongGameRecordCtrl(Context paramContext, AVGameVideoLayer paramAVGameVideoLayer)
  {
    super(paramContext);
    paramContext = RecordUtils.d();
    if (paramContext != null)
    {
      this.D = (paramContext.b * 1000);
      this.E = (paramContext.c * 1000);
      long l1 = this.D;
      if (l1 > 1000L) {
        this.D = (l1 - 1000L);
      }
    }
    this.F = paramAVGameVideoLayer;
  }
  
  private void D()
  {
    if (k()) {
      m();
    }
    G();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.n;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.d();
    }
    this.F = null;
  }
  
  private boolean E()
  {
    int i1 = GameEngine.a().s().j();
    return (i1 != 10) && (i1 != 0);
  }
  
  private void G()
  {
    GameEngine.a().b(this.G);
    this.C.removeMessages(4);
    this.j = false;
    this.l = 0L;
    this.t = false;
    this.s = false;
  }
  
  public int[] A()
  {
    if (!i())
    {
      this.d = false;
      return new int[] { 0, 0 };
    }
    if (this.n == null) {
      try
      {
        if (h()) {
          this.n = new QavVideoAudioRecorder();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.n = null;
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oom ");
        localStringBuilder.append(localOutOfMemoryError);
        AVLog.a((String)localObject, localStringBuilder.toString());
      }
    }
    if (this.n == null)
    {
      this.d = false;
      return new int[] { 0, 0 };
    }
    this.u.a(720, 720);
    this.v.a(720, 720);
    this.x.a(720, 720);
    this.w.a(720, 720);
    this.j = false;
    this.h = o();
    this.i = p();
    AVLog.c(this.a, "doNeedStartRecord rW=720, rH=720");
    EncodeConfig localEncodeConfig = new EncodeConfig(this.h, 720, 720, 5120000, 1, false, 0);
    localEncodeConfig.a(EGL14.eglGetCurrentContext());
    Object localObject = this.n;
    if (localObject != null) {
      ((QavVideoAudioRecorder)localObject).a(localEncodeConfig, this);
    } else {
      a(5, null);
    }
    return new int[] { 720, 720 };
  }
  
  public void B()
  {
    if (k())
    {
      if (!this.k)
      {
        this.y = new RenderBuffer(720, 720, 33984);
        a(true);
        A();
        this.k = true;
      }
      u();
      a(3553, this.y.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
    }
  }
  
  public void C()
  {
    if (this.k)
    {
      AVLog.c(this.a, "releaseGameTexture");
      Object localObject = this.u;
      if (localObject != null) {
        ((GameVideoImageFilter)localObject).d();
      }
      localObject = this.x;
      if (localObject != null) {
        ((GameVideoDarkCoverFilter)localObject).d();
      }
      localObject = this.v;
      if (localObject != null) {
        ((GameVideoImageFilter)localObject).d();
      }
      localObject = this.w;
      if (localObject != null) {
        ((GameVideoImageFilter)localObject).d();
      }
      localObject = this.y;
      if (localObject != null)
      {
        ((RenderBuffer)localObject).destroy();
        this.y = null;
      }
      this.k = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (k())
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.n;
      if (localQavVideoAudioRecorder != null)
      {
        boolean bool = localQavVideoAudioRecorder.b();
        if (!bool) {
          AVLog.c(this.a, "videoFrameAvailable check audio not ready");
        }
        int i1;
        if ((!this.j) && (!bool)) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i1 == 0)
        {
          if (this.l <= 0L) {
            this.l = System.currentTimeMillis();
          }
          if (System.currentTimeMillis() - this.l > 1000L)
          {
            this.j = true;
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
          this.j = true;
        }
        if (i1 != 0) {
          this.n.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        }
      }
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeError ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramThrowable);
    AVLog.a(str, localStringBuilder.toString());
    this.A = true;
    this.C.sendEmptyMessage(2);
    this.C.postDelayed(new GuessSongGameRecordCtrl.3(this), 50L);
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
    localObject = this.q;
    if (paramBitmap != null) {}
    try
    {
      if (this.o == null) {
        this.o = new GameImageData();
      }
      this.o.a = paramBitmap;
      this.o.b = paramInt1;
      this.o.c = paramInt2;
      this.o.d = paramInt3;
      this.o.e = paramInt4;
      break label202;
      this.o = null;
      label202:
      this.u.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void a(View paramView)
  {
    AVLog.c(this.a, "onTopicViewDismiss ");
    a(null, 0, 0, 0, 0);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
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
      this.C.postDelayed(new GuessSongGameRecordCtrl.4(this, paramInt, paramView), 500L);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEncodeFinish ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.i);
    AVLog.c((String)localObject, localStringBuilder.toString());
    if (this.A)
    {
      boolean bool1 = false;
      this.A = false;
      try
      {
        boolean bool2 = new File(paramString).delete();
        bool1 = bool2;
      }
      catch (Exception paramString)
      {
        AVLog.a(this.a, "onEncodeFinish", paramString);
      }
      this.h = null;
      paramString = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeFinish delete=");
      ((StringBuilder)localObject).append(bool1);
      AVLog.c(paramString, ((StringBuilder)localObject).toString());
    }
    GameEngine.a().s().a(this.h, this.i, this.B);
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enableDrawDefaultBg ");
    ((StringBuilder)localObject2).append(paramBoolean);
    AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramBoolean)
    {
      if (this.z == null)
      {
        this.z = AVGameUtil.c("avgame_songfallback@2x.png");
        if (this.z == null)
        {
          localObject1 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject1).eraseColor(-1144611);
          this.z = ((Bitmap)localObject1);
        }
      }
      localObject1 = this.z;
      if (localObject1 != null)
      {
        localObject2 = this.w;
        ((GameVideoImageFilter)localObject2).a((Bitmap)localObject1, ((GameVideoImageFilter)localObject2).g(), this.w.h(), 0, 0);
      }
    }
    else
    {
      this.w.a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.s = paramBoolean;
    this.x.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (k())
    {
      QavVideoAudioRecorder localQavVideoAudioRecorder = this.n;
      if ((localQavVideoAudioRecorder != null) && (paramArrayOfByte != null)) {
        localQavVideoAudioRecorder.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
      }
    }
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
    localObject = this.r;
    if (paramBitmap != null) {}
    try
    {
      if (this.p == null) {
        this.p = new GameImageData();
      }
      this.p.a = paramBitmap;
      this.p.b = paramInt1;
      this.p.c = paramInt2;
      this.p.d = paramInt3;
      this.p.e = paramInt4;
      break label202;
      this.p = null;
      label202:
      this.v.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    finally {}
  }
  
  public void b(View paramView)
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
      this.C.postDelayed(new GuessSongGameRecordCtrl.5(this, paramView), 500L);
    }
  }
  
  public void c()
  {
    AVLog.c(this.a, "onActivityStart ");
    if (E())
    {
      Object localObject1 = GameEngine.a().s().v();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((GameRecordInfo)localObject1).startGameTimeMills > 0L)
        {
          this.B = ((GameRecordInfo)localObject1).startGameTimeMills;
          this.h = ((GameRecordInfo)localObject1).videoFilePath;
          this.i = ((GameRecordInfo)localObject1).photoFilePath;
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
        long l1 = this.D - (System.currentTimeMillis() - this.B);
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityStart remainTime:");
        ((StringBuilder)localObject2).append(l1);
        AVLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
        l1 = Math.max(l1, 1000L);
        this.C.sendEmptyMessageDelayed(1, l1);
      }
    }
  }
  
  public void c(View paramView)
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
  
  public void d()
  {
    AVLog.c(this.a, "onActivityStop ");
    this.C.removeCallbacksAndMessages(null);
    this.C.sendEmptyMessage(2);
  }
  
  public void e()
  {
    boolean bool = k();
    ??? = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameOver ");
    localStringBuilder.append(bool);
    AVLog.c((String)???, localStringBuilder.toString());
    this.C.removeCallbacksAndMessages(null);
    this.C.sendEmptyMessage(2);
    synchronized (this.r)
    {
      this.p = null;
      synchronized (this.q)
      {
        this.o = null;
        return;
      }
    }
  }
  
  public void f()
  {
    boolean bool = k();
    GameRecordInfo localGameRecordInfo = GameEngine.a().s().v();
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameStart ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.B);
    localStringBuilder.append(" ");
    localStringBuilder.append(localGameRecordInfo);
    AVLog.c(str, localStringBuilder.toString());
    if (localGameRecordInfo.startGameTimeMills == 0L)
    {
      this.B = System.currentTimeMillis();
      this.i = null;
      this.h = null;
      GameEngine.a().s().a(this.h, this.i, this.B);
      this.C.removeCallbacksAndMessages(null);
      this.C.sendEmptyMessageDelayed(1, this.D);
    }
  }
  
  protected String g()
  {
    return "GuessSongGameRecordCtrl";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return true;
          }
          if (k())
          {
            AVLog.c(this.a, "render call .");
            paramMessage = this.F;
            if ((paramMessage != null) && (paramMessage.i() != null))
            {
              this.F.i().requestRender();
              this.C.sendEmptyMessageDelayed(4, 50L);
              return true;
            }
          }
          else
          {
            this.C.removeMessages(4);
            return true;
          }
        }
        else
        {
          AVLog.c(this.a, "destroy");
          D();
          return true;
        }
      }
      else
      {
        paramMessage = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("end record come.");
        localStringBuilder.append(k());
        AVLog.c(paramMessage, localStringBuilder.toString());
        if (k())
        {
          m();
          paramMessage = this.F;
          if ((paramMessage != null) && (paramMessage.i() != null))
          {
            this.F.i().requestRender();
            return true;
          }
        }
      }
    }
    else
    {
      AVLog.c(this.a, "start record come.");
      if (k()) {
        m();
      }
      this.C.removeCallbacksAndMessages(null);
      if (l())
      {
        this.C.sendEmptyMessageDelayed(2, this.E);
        this.C.sendEmptyMessage(4);
      }
    }
    return true;
  }
  
  public boolean l()
  {
    if (super.l())
    {
      G();
      GameEngine.a().a(this.G);
      this.h = null;
      this.i = null;
      this.A = false;
      return true;
    }
    return false;
  }
  
  public void m()
  {
    super.m();
    QavVideoAudioRecorder localQavVideoAudioRecorder = this.n;
    if (localQavVideoAudioRecorder != null) {
      localQavVideoAudioRecorder.a();
    }
    G();
  }
  
  public void n()
  {
    AVLog.c(this.a, "onDestroy ");
    super.n();
    this.C.removeCallbacksAndMessages(null);
    D();
  }
  
  public void q() {}
  
  public void r() {}
  
  public void u()
  {
    this.y.bind();
    GLES20.glViewport(0, 0, this.y.getWidth(), this.y.getHeight());
    if (x()) {
      this.w.l();
    }
    if (y()) {
      this.u.l();
    }
    if (w()) {
      this.x.l();
    }
    if (z()) {
      this.v.l();
    }
    v();
    this.y.unbind();
  }
  
  public void v()
  {
    if (!this.m)
    {
      this.m = true;
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
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFirstFramePhoto ");
        localStringBuilder.append(localThrowable);
        AVLog.c(str, localStringBuilder.toString());
      }
    }
  }
  
  public boolean w()
  {
    return this.s;
  }
  
  public boolean x()
  {
    return this.t;
  }
  
  public boolean y()
  {
    for (;;)
    {
      synchronized (this.q)
      {
        if ((this.o != null) && (this.o.a != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean z()
  {
    for (;;)
    {
      synchronized (this.r)
      {
        if ((this.p != null) && (this.p.a != null))
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
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl
 * JD-Core Version:    0.7.0.1
 */