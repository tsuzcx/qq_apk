package com.tencent.avgame.videorecord;

import android.content.Context;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer;
import com.tencent.avgame.qav.videorecord.IGameVideoRecordPresenterWrapper;
import com.tencent.avgame.qav.videorecord.IGuessPictureGameRecordCtrl;
import com.tencent.avgame.util.AvGameMachineLevelUtils;
import com.tencent.qav.log.AVLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

@RequiresApi(api=18)
public class GameVideoRecordPresenterWrapper
  implements IGameVideoRecordPresenterWrapper
{
  private ShowAndGuessGameVideoRecordCtrl a;
  private GuessPictureGameRecordCtrl b;
  private GuessVideoGameRecordCtrl c;
  private GuessSongGameRecordCtrl d;
  private TextureRender e;
  private RenderBuffer f;
  private RenderBuffer g;
  private boolean h = false;
  private int i;
  private int j;
  private float[] k = new float[16];
  private float[] l = new float[16];
  private AVGameBusinessVideoLayer m;
  private IStagePresenter n;
  
  public GameVideoRecordPresenterWrapper(Context paramContext, AVGameBusinessVideoLayer paramAVGameBusinessVideoLayer)
  {
    this.m = paramAVGameBusinessVideoLayer;
    int i1 = AvGameMachineLevelUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("machineLevel ");
    localStringBuilder.append(i1);
    AVLog.d("GameVideoRecordPresenterWrapper", localStringBuilder.toString());
    if ((i1 != 1) && (i1 != 0))
    {
      if (GameEngine.a().A())
      {
        AVLog.d("GameVideoRecordPresenterWrapper", "survival not record");
        return;
      }
      this.a = new ShowAndGuessGameVideoRecordCtrl(paramContext, paramAVGameBusinessVideoLayer);
      this.b = new GuessPictureGameRecordCtrl(paramContext);
      this.c = new GuessVideoGameRecordCtrl(paramContext, paramAVGameBusinessVideoLayer);
      this.d = new GuessSongGameRecordCtrl(paramContext, paramAVGameBusinessVideoLayer);
      return;
    }
    AVLog.d("GameVideoRecordPresenterWrapper", "machineLevel low, don't init ctrl");
  }
  
  private void a(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    float f3 = paramRectF.right;
    float f4 = paramRectF.left;
    float f1 = paramRectF.bottom;
    float f2 = paramRectF.top;
    paramFloat1 = (f3 - f4) * (paramFloat2 / paramFloat1);
    paramFloat2 = (f1 - f2) / paramFloat1;
    paramFloat1 = paramRectF.top / paramFloat1;
    this.l = new float[16];
    Matrix.setIdentityM(this.l, 0);
    Matrix.translateM(this.l, 0, 0.0F, 1.0F - paramFloat2 - paramFloat1, 0.0F);
    Matrix.scaleM(this.l, 0, 1.0F, paramFloat2, 1.0F);
    this.k = new float[16];
    Matrix.setIdentityM(this.k, 0);
  }
  
  public void a()
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.a();
    }
  }
  
  public void a(View paramView)
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.a(paramView);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    int i1 = GameEngine.a().s().o();
    if (i1 == 1)
    {
      c(paramGLCanvas);
      return;
    }
    if (i1 == 3)
    {
      d(paramGLCanvas);
      return;
    }
    if (i1 == 4) {
      b(paramGLCanvas);
    }
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.n = paramIStagePresenter;
    Object localObject = this.a;
    if (localObject != null) {
      ((ShowAndGuessGameVideoRecordCtrl)localObject).a(paramIStagePresenter);
    }
    localObject = this.c;
    if (localObject != null) {
      ((GuessVideoGameRecordCtrl)localObject).a(paramIStagePresenter);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.c != null) && (GameEngine.a().s().o() == 3)) {
      this.c.b(paramString);
    }
  }
  
  public void b()
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.b();
    }
  }
  
  public void b(View paramView)
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.b(paramView);
    }
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    GLES20.glViewport(0, 0, paramGLCanvas.b(), paramGLCanvas.c());
    this.m.g(paramGLCanvas);
    this.d.B();
  }
  
  public void b(String paramString)
  {
    if ((this.c != null) && (GameEngine.a().s().o() == 3)) {
      this.c.c(paramString);
    }
  }
  
  public void c()
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.c();
    }
  }
  
  public void c(View paramView)
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.c(paramView);
    }
  }
  
  protected void c(GLCanvas paramGLCanvas)
  {
    if (!this.h)
    {
      Object localObject = this.n;
      if (localObject != null)
      {
        localObject = ((IStagePresenter)localObject).b();
        if (localObject == null)
        {
          AVLog.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init fail. no stage rect");
          return;
        }
        this.h = true;
        int i1 = (int)(((RectF)localObject).right - ((RectF)localObject).left);
        int i2 = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealWithRecordFBORenderForGuessShow init:");
        localStringBuilder.append(paramGLCanvas.b());
        localStringBuilder.append(" ");
        localStringBuilder.append(paramGLCanvas.c());
        localStringBuilder.append(" ");
        localStringBuilder.append(localObject);
        AVLog.d("GameVideoRecordPresenterWrapper", localStringBuilder.toString());
        this.f = new RenderBuffer(paramGLCanvas.b(), paramGLCanvas.c(), 33984);
        this.g = new RenderBuffer(i1, i2, 33985);
        this.e = new TextureRender();
        a((RectF)localObject, paramGLCanvas.b(), paramGLCanvas.c());
        localObject = this.a.a(i1, i2);
        this.i = localObject[0];
        this.j = localObject[1];
      }
    }
    if (this.h)
    {
      this.f.bind();
      this.m.g(paramGLCanvas);
      this.f.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.f.getWidth(), this.f.getHeight());
      this.e.drawTexture(3553, this.f.getTexId(), null, null);
      this.g.bind();
      GLES20.glViewport(0, 0, this.g.getWidth(), this.g.getHeight());
      this.e.drawTexture(3553, this.f.getTexId(), this.l, this.k);
      this.a.w();
      this.a.v();
      this.g.unbind();
      this.a.a(3553, this.g.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.m.g(paramGLCanvas);
  }
  
  public void d()
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.d();
    }
  }
  
  protected void d(GLCanvas paramGLCanvas)
  {
    if (!this.h)
    {
      Object localObject = this.n;
      if (localObject != null)
      {
        localObject = ((IStagePresenter)localObject).b();
        if (localObject == null)
        {
          AVLog.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init fail. no stage rect");
          return;
        }
        this.h = true;
        int i1 = (int)(((RectF)localObject).right - ((RectF)localObject).left);
        int i2 = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealWithRecordFBORenderForGuessVideo init:");
        localStringBuilder.append(paramGLCanvas.b());
        localStringBuilder.append(" ");
        localStringBuilder.append(paramGLCanvas.c());
        localStringBuilder.append(" ");
        localStringBuilder.append(localObject);
        AVLog.d("GameVideoRecordPresenterWrapper", localStringBuilder.toString());
        this.f = new RenderBuffer(paramGLCanvas.b(), paramGLCanvas.c(), 33984);
        this.g = new RenderBuffer(i1, i2, 33985);
        this.e = new TextureRender();
        a((RectF)localObject, paramGLCanvas.b(), paramGLCanvas.c());
        localObject = this.c.a(i1, i2);
        this.i = localObject[0];
        this.j = localObject[1];
      }
    }
    if (this.h)
    {
      this.f.bind();
      this.m.g(paramGLCanvas);
      this.f.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.f.getWidth(), this.f.getHeight());
      this.e.drawTexture(3553, this.f.getTexId(), null, null);
      this.g.bind();
      GLES20.glViewport(0, 0, this.g.getWidth(), this.g.getHeight());
      this.e.drawTexture(3553, this.f.getTexId(), this.l, this.k);
      this.c.v();
      this.c.u();
      this.g.unbind();
      this.c.a(3553, this.g.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.m.g(paramGLCanvas);
  }
  
  public void e()
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.e();
    }
  }
  
  public void f()
  {
    IStageRecordPresenter localIStageRecordPresenter = h();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.f();
    }
  }
  
  public IGuessPictureGameRecordCtrl g()
  {
    return this.b;
  }
  
  protected IStageRecordPresenter h()
  {
    int i1 = GameEngine.a().s().o();
    if (i1 == 1) {
      return this.a;
    }
    if (i1 == 2) {
      return this.b;
    }
    if (i1 == 3) {
      return this.c;
    }
    if (i1 == 4) {
      return this.d;
    }
    return null;
  }
  
  public boolean i()
  {
    int i1 = GameEngine.a().s().o();
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    Object localObject;
    if (i1 == 1)
    {
      localObject = this.a;
      bool1 = bool2;
      if (localObject != null) {
        if (!((ShowAndGuessGameVideoRecordCtrl)localObject).k())
        {
          bool1 = bool2;
          if (!this.a.x()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (i1 == 3)
    {
      localObject = this.c;
      bool1 = bool3;
      if (localObject != null) {
        if (!((GuessVideoGameRecordCtrl)localObject).k())
        {
          bool1 = bool3;
          if (!this.c.w()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = bool4;
    if (i1 == 4)
    {
      localObject = this.d;
      bool1 = bool4;
      if (localObject != null)
      {
        bool1 = bool4;
        if (((GuessSongGameRecordCtrl)localObject).k()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void j()
  {
    if (this.h)
    {
      this.h = false;
      this.f.destroy();
      this.f = null;
      this.g.destroy();
      this.g = null;
      this.e.release();
      this.e = null;
      this.i = 0;
      this.j = 0;
      int i1 = GameEngine.a().s().o();
      if (i1 == 1) {
        this.a.C();
      } else if (i1 == 3) {
        this.c.B();
      }
    }
    if (GameEngine.a().s().o() == 4)
    {
      GuessSongGameRecordCtrl localGuessSongGameRecordCtrl = this.d;
      if (localGuessSongGameRecordCtrl != null) {
        localGuessSongGameRecordCtrl.C();
      }
    }
  }
  
  public void k()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ShowAndGuessGameVideoRecordCtrl)localObject).n();
    }
    localObject = this.b;
    if (localObject != null) {
      ((GuessPictureGameRecordCtrl)localObject).n();
    }
    localObject = this.c;
    if (localObject != null) {
      ((GuessVideoGameRecordCtrl)localObject).n();
    }
    localObject = this.d;
    if (localObject != null) {
      ((GuessSongGameRecordCtrl)localObject).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoRecordPresenterWrapper
 * JD-Core Version:    0.7.0.1
 */