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
  private int jdField_a_of_type_Int;
  private IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private AVGameBusinessVideoLayer jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer;
  private GuessPictureGameRecordCtrl jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl;
  private GuessSongGameRecordCtrl jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl;
  private GuessVideoGameRecordCtrl jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl;
  private ShowAndGuessGameVideoRecordCtrl jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  
  public GameVideoRecordPresenterWrapper(Context paramContext, AVGameBusinessVideoLayer paramAVGameBusinessVideoLayer)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer = paramAVGameBusinessVideoLayer;
    int i = AvGameMachineLevelUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("machineLevel ");
    localStringBuilder.append(i);
    AVLog.d("GameVideoRecordPresenterWrapper", localStringBuilder.toString());
    if ((i != 1) && (i != 0))
    {
      if (GameEngine.a().f())
      {
        AVLog.d("GameVideoRecordPresenterWrapper", "survival not record");
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl = new ShowAndGuessGameVideoRecordCtrl(paramContext, paramAVGameBusinessVideoLayer);
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl = new GuessPictureGameRecordCtrl(paramContext);
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl = new GuessVideoGameRecordCtrl(paramContext, paramAVGameBusinessVideoLayer);
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl = new GuessSongGameRecordCtrl(paramContext, paramAVGameBusinessVideoLayer);
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
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 1.0F - paramFloat2 - paramFloat1, 0.0F);
    Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, paramFloat2, 1.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  protected IStageRecordPresenter a()
  {
    int i = GameEngine.a().a().c();
    if (i == 1) {
      return this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl;
    }
    if (i == 2) {
      return this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl;
    }
    if (i == 3) {
      return this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl;
    }
    if (i == 4) {
      return this.jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl;
    }
    return null;
  }
  
  public IGuessPictureGameRecordCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl;
  }
  
  public void a()
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.a();
    }
  }
  
  public void a(View paramView)
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.a(paramView);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    int i = GameEngine.a().a().c();
    if (i == 1)
    {
      c(paramGLCanvas);
      return;
    }
    if (i == 3)
    {
      d(paramGLCanvas);
      return;
    }
    if (i == 4) {
      b(paramGLCanvas);
    }
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
    Object localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl;
    if (localObject != null) {
      ((ShowAndGuessGameVideoRecordCtrl)localObject).a(paramIStagePresenter);
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl;
    if (localObject != null) {
      ((GuessVideoGameRecordCtrl)localObject).a(paramIStagePresenter);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl != null) && (GameEngine.a().a().c() == 3)) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.b(paramString);
    }
  }
  
  public boolean a()
  {
    int i = GameEngine.a().a().c();
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    Object localObject;
    if (i == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl;
      bool1 = bool2;
      if (localObject != null) {
        if (!((ShowAndGuessGameVideoRecordCtrl)localObject).d())
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl.g()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (i == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl;
      bool1 = bool3;
      if (localObject != null) {
        if (!((GuessVideoGameRecordCtrl)localObject).d())
        {
          bool1 = bool3;
          if (!this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.f()) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = bool4;
    if (i == 4)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl;
      bool1 = bool4;
      if (localObject != null)
      {
        bool1 = bool4;
        if (((GuessSongGameRecordCtrl)localObject).d()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.b();
    }
  }
  
  public void b(View paramView)
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.b(paramView);
    }
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    GLES20.glViewport(0, 0, paramGLCanvas.a(), paramGLCanvas.b());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.g(paramGLCanvas);
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl.p();
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl != null) && (GameEngine.a().a().c() == 3)) {
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.c(paramString);
    }
  }
  
  public void c()
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.c();
    }
  }
  
  public void c(View paramView)
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.c(paramView);
    }
  }
  
  protected void c(GLCanvas paramGLCanvas)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
      if (localObject != null)
      {
        localObject = ((IStagePresenter)localObject).a();
        if (localObject == null)
        {
          AVLog.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessShow init fail. no stage rect");
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
        int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealWithRecordFBORenderForGuessShow init:");
        localStringBuilder.append(paramGLCanvas.a());
        localStringBuilder.append(" ");
        localStringBuilder.append(paramGLCanvas.b());
        localStringBuilder.append(" ");
        localStringBuilder.append(localObject);
        AVLog.d("GameVideoRecordPresenterWrapper", localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramGLCanvas.a(), paramGLCanvas.b(), 33984);
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        a((RectF)localObject, paramGLCanvas.a(), paramGLCanvas.b());
        localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl.a(i, j);
        this.jdField_a_of_type_Int = localObject[0];
        this.jdField_b_of_type_Int = localObject[1];
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.g(paramGLCanvas);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl.n();
      this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.g(paramGLCanvas);
  }
  
  public void d()
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.d();
    }
  }
  
  protected void d(GLCanvas paramGLCanvas)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
      if (localObject != null)
      {
        localObject = ((IStagePresenter)localObject).a();
        if (localObject == null)
        {
          AVLog.d("GameVideoRecordPresenterWrapper", "dealWithRecordFBORenderForGuessVideo init fail. no stage rect");
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        int i = (int)(((RectF)localObject).right - ((RectF)localObject).left);
        int j = (int)(((RectF)localObject).bottom - ((RectF)localObject).top);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealWithRecordFBORenderForGuessVideo init:");
        localStringBuilder.append(paramGLCanvas.a());
        localStringBuilder.append(" ");
        localStringBuilder.append(paramGLCanvas.b());
        localStringBuilder.append(" ");
        localStringBuilder.append(localObject);
        AVLog.d("GameVideoRecordPresenterWrapper", localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramGLCanvas.a(), paramGLCanvas.b(), 33984);
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(i, j, 33985);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        a((RectF)localObject, paramGLCanvas.a(), paramGLCanvas.b());
        localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.a(i, j);
        this.jdField_a_of_type_Int = localObject[0];
        this.jdField_b_of_type_Int = localObject[1];
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.g(paramGLCanvas);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES20.glViewport(0, 0, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.n();
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.m();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.a(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.g(paramGLCanvas);
  }
  
  public void e()
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.e();
    }
  }
  
  public void f()
  {
    IStageRecordPresenter localIStageRecordPresenter = a();
    if (localIStageRecordPresenter != null) {
      localIStageRecordPresenter.f();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      int i = GameEngine.a().a().c();
      if (i == 1) {
        this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl.p();
      } else if (i == 3) {
        this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl.p();
      }
    }
    if (GameEngine.a().a().c() == 4)
    {
      GuessSongGameRecordCtrl localGuessSongGameRecordCtrl = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl;
      if (localGuessSongGameRecordCtrl != null) {
        localGuessSongGameRecordCtrl.q();
      }
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordShowAndGuessGameVideoRecordCtrl;
    if (localObject != null) {
      ((ShowAndGuessGameVideoRecordCtrl)localObject).l();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl;
    if (localObject != null) {
      ((GuessPictureGameRecordCtrl)localObject).l();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessVideoGameRecordCtrl;
    if (localObject != null) {
      ((GuessVideoGameRecordCtrl)localObject).l();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameVideorecordGuessSongGameRecordCtrl;
    if (localObject != null) {
      ((GuessSongGameRecordCtrl)localObject).l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoRecordPresenterWrapper
 * JD-Core Version:    0.7.0.1
 */