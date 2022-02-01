package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View.MeasureSpec;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.GPUImagePixelationFilter;
import com.tencent.mobileqq.filter.GpuImagePartsFilterGroup;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.filter.QQVideoGaussianBlurFilter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int x;
  private GpuImagePartsFilterGroup A;
  private GPUBaseFilter B;
  private GPUBaseFilter C;
  private GPUBaseFilter D;
  private RenderBuffer E;
  private RenderBuffer F;
  private final LinkedList<Runnable> G = new LinkedList();
  private QQFilterRenderManager H;
  private boolean I = false;
  private boolean J = true;
  private ByteBuffer K;
  private byte[] L;
  private boolean M = false;
  private boolean N = false;
  protected boolean u;
  protected boolean v;
  public boolean w;
  public int y = 0;
  private QQVideoGaussianBlurFilter z;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
    int i = x + 1;
    x = i;
    this.y = i;
  }
  
  private void a(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void j()
  {
    this.H = QQFilterRenderManagerHolder.a();
    QQFilterRenderManagerHolder.a(this.H);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = this.E;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.F;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.K;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.K = null;
    }
    localObject = this.C;
    if (localObject != null)
    {
      ((GPUBaseFilter)localObject).destroy();
      this.C = null;
    }
    localObject = this.z;
    if (localObject != null) {
      ((QQVideoGaussianBlurFilter)localObject).a();
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((GPUBaseFilter)localObject).destroy();
      this.D = null;
    }
    localObject = this.A;
    if (localObject != null)
    {
      ((GpuImagePartsFilterGroup)localObject).destroy();
      this.A = null;
    }
    localObject = this.H;
    if (localObject != null)
    {
      ((QQFilterRenderManager)localObject).surfaceDestroyed();
      this.I = true;
      this.H = QQFilterRenderManagerHolder.a();
      QQFilterRenderManagerHolder.a(this.H);
    }
  }
  
  public void a(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2)
  {
    int i;
    if (paramRenderBuffer != null) {
      i = paramRenderBuffer.getTexId();
    } else {
      i = 0;
    }
    if (this.L != null)
    {
      paramRenderBuffer = this.K;
      if (paramRenderBuffer != null)
      {
        paramRenderBuffer.rewind();
        if (i != 0) {}
        try
        {
          paramRenderBuffer = new int[1];
          GLES20.glGenFramebuffers(1, paramRenderBuffer, 0);
          GLES20.glBindFramebuffer(36160, paramRenderBuffer[0]);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.K);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glDeleteFramebuffers(1, paramRenderBuffer, 0);
          paramRenderBuffer[0] = 0;
          break label129;
          GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.K);
          label129:
          this.N = false;
          return;
        }
        catch (Exception paramRenderBuffer)
        {
          this.K.clear();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("readTextureToBuffer error ");
            localStringBuilder.append(paramRenderBuffer.toString());
            QLog.e("VideoFilterPlayView", 2, localStringBuilder.toString());
          }
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer trackData is null ");
    }
  }
  
  protected void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.G)
    {
      this.G.add(paramRunnable);
      return;
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (this.I) {
      return;
    }
    Object localObject = paramArrayOfFloat2;
    if (this.u)
    {
      localObject = paramArrayOfFloat2;
      if (this.v) {
        if (this.w)
        {
          localObject = new float[16];
          Matrix.setIdentityM((float[])localObject, 0);
        }
        else
        {
          localObject = GPUBaseFilter.caculateFitCenterMvpMatrix(this.e, this.f, this.c, this.d);
        }
      }
    }
    a(this.G);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    Matrix.rotateM((float[])localObject, 0, this.j, 0.0F, 0.0F, 1.0F);
    Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
    this.E.bind();
    super.a(paramArrayOfFloat1, (float[])localObject);
    this.E.unbind();
    localObject = this.E;
    int j = ((RenderBuffer)localObject).getTexId();
    int i = j;
    if (this.z != null)
    {
      ((RenderBuffer)localObject).bind();
      i = this.z.a(j);
      ((RenderBuffer)localObject).unbind();
    }
    paramArrayOfFloat1 = this.H;
    j = i;
    if (paramArrayOfFloat1 != null)
    {
      paramArrayOfFloat1.setParam("key_draw_screen", String.valueOf(false));
      this.H.setParam("key_width", String.valueOf(this.e));
      this.H.setParam("key_height", String.valueOf(this.f));
      int k = this.H.drawFrame(i);
      j = i;
      if (k != -1) {
        j = k;
      }
    }
    paramArrayOfFloat2 = this.E;
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (localObject == paramArrayOfFloat2) {
      paramArrayOfFloat1 = this.F;
    }
    paramArrayOfFloat1.bind();
    this.C.drawTexture(j, null, null);
    j = paramArrayOfFloat1.getTexId();
    paramArrayOfFloat1.unbind();
    this.A.b();
    paramArrayOfFloat2 = paramArrayOfFloat1;
    i = j;
    if (this.A.a())
    {
      localObject = this.E;
      paramArrayOfFloat2 = (float[])localObject;
      if (paramArrayOfFloat1 == localObject) {
        paramArrayOfFloat2 = this.F;
      }
      paramArrayOfFloat2.bind();
      this.A.drawTexture(j, null, null);
      i = paramArrayOfFloat2.getTexId();
      paramArrayOfFloat2.unbind();
    }
    if (this.N) {
      a(paramArrayOfFloat2, this.e, this.f);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.c, this.d);
    paramArrayOfFloat1 = new float[16];
    Matrix.setIdentityM(paramArrayOfFloat1, 0);
    Matrix.scaleM(paramArrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
    this.B.drawTexture(i, null, paramArrayOfFloat1);
  }
  
  public void b(int paramInt)
  {
    this.z = new QQVideoGaussianBlurFilter(paramInt);
  }
  
  public void i() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    super.onDecodeFrame(paramLong1, paramLong2);
    QQFilterRenderManager localQQFilterRenderManager = this.H;
    if (localQQFilterRenderManager != null) {
      localQQFilterRenderManager.getBusinessOperation().SetTimeStamp(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat");
    super.onDecodeRepeat();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.g)
    {
      int j = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getSize(paramInt2);
      i = paramInt2;
      if (this.e * this.f > 0)
      {
        i = paramInt2;
        if (this.f * j != this.e * k) {
          i = View.MeasureSpec.makeMeasureSpec((int)(j * this.f / this.e), 1073741824);
        }
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSurfaceChanged : ");
      localStringBuilder.append(paramGL10.hashCode());
      QLog.e("VideoFilterPlayView", 4, localStringBuilder.toString());
    }
    if (!this.J) {
      return;
    }
    if ((this.q) && (this.c == paramInt1) && (this.d == paramInt2)) {
      return;
    }
    this.q = true;
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    this.E = new RenderBuffer(this.e, this.f, 33984);
    this.F = new RenderBuffer(this.e, this.f, 33984);
    paramGL10 = this.A;
    if (paramGL10 != null) {
      paramGL10.onOutputSizeChanged(this.e, this.f);
    }
    paramGL10 = this.z;
    if (paramGL10 != null) {
      paramGL10.a(this.e, this.f);
    }
    this.B.onOutputSizeChanged(this.e, this.f);
    if (this.K == null) {
      try
      {
        this.L = new byte[this.e * this.f * 4];
        this.K = ByteBuffer.wrap(this.L);
      }
      catch (OutOfMemoryError paramGL10)
      {
        QLog.e("VideoFilterPlayView", 1, "init trackByteBuffer failed ", paramGL10);
        paramGL10 = this.K;
        if (paramGL10 != null)
        {
          paramGL10.clear();
          this.K = null;
        }
      }
    }
    paramGL10 = this.H;
    if (paramGL10 != null)
    {
      paramGL10.surfaceChange(this.e, this.f, this.c, this.d);
      this.I = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterPlayView", 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    ((IAEResUtil)QRoute.api(IAEResUtil.class)).loadAEBaseSo();
    if (VideoEnvironment.loadAVCodecSo() != 0)
    {
      ThreadManager.getUIHandler().post(new VideoFilterPlayView.2(this));
      this.J = false;
      QLog.e("VideoFilterPlayView", 1, "onSurfaceCreated : Load so fail");
      return;
    }
    this.q = false;
    paramGL10 = FilterFactory.a(101);
    this.C = paramGL10;
    this.B = paramGL10;
    this.C.init();
    paramGL10 = this.D;
    if (paramGL10 != null)
    {
      this.B = paramGL10;
      this.B.initForce();
    }
    this.A = new GpuImagePartsFilterGroup();
    this.A.init();
    paramGL10 = this.z;
    if (paramGL10 != null) {
      paramGL10.a(this.h, this.i, this.e, this.f);
    }
    paramGL10 = this.H;
    if (paramGL10 != null)
    {
      paramGL10.surfaceCreate(this.e, this.f, this.c, this.d);
      this.I = false;
      if (QLog.isColorLevel()) {
        QLog.w("VideoFilterPlayView", 2, "mFilterProcess, surfaceCreated success");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterPlayView", 2, "onSurfaceCreated");
    }
  }
  
  public void setColorFilterType(int paramInt)
  {
    GpuImagePartsFilterGroup localGpuImagePartsFilterGroup = this.A;
    if (localGpuImagePartsFilterGroup != null)
    {
      if ((!localGpuImagePartsFilterGroup.a()) && (paramInt == 0)) {
        return;
      }
      this.A.a(paramInt, this.c, this.d);
    }
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.A.a(paramInt1, paramInt2, paramFloat, paramInt3, this.c, this.d);
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    super.setFilePath(paramString1, paramString2);
  }
  
  public void setFilePath(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.u = paramBoolean1;
    this.v = paramBoolean2;
    this.w = paramBoolean3;
    setFilePath(paramString1, paramString2);
    if ((this.u) && (this.w))
    {
      paramString1 = VideoUtils.b(this.e, this.f, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
      this.e = ((Integer)paramString1.first).intValue();
      this.f = ((Integer)paramString1.second).intValue();
    }
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.B = this.C;
      this.D = null;
      return;
    }
    if (this.D == null)
    {
      this.D = FilterFactory.a(106);
      a(new VideoFilterPlayView.1(this));
    }
    ((GPUImagePixelationFilter)this.D).a(paramBitmap);
    this.B = this.D;
  }
  
  public void setSpeedType(int paramInt)
  {
    super.setSpeedType(paramInt);
    a(new VideoFilterPlayView.3(this, paramInt));
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    a(new VideoFilterPlayView.4(this, paramTransferData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */