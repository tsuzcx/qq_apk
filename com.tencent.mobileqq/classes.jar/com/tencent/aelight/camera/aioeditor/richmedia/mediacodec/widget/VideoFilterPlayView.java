package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Pair;
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
  public static int k;
  private GpuImagePartsFilterGroup jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup;
  private QQVideoGaussianBlurFilter jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final LinkedList<Runnable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private byte[] jdField_a_of_type_ArrayOfByte;
  private GPUBaseFilter jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private GPUBaseFilter c;
  protected boolean c;
  protected boolean d;
  public boolean e;
  private boolean f;
  private boolean g;
  private boolean h = false;
  private boolean i = false;
  public int l = 0;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    i();
    int j = k + 1;
    k = j;
    this.l = j;
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
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
    QQFilterRenderManagerHolder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    localObject = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    if (localObject != null)
    {
      ((GPUBaseFilter)localObject).destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter;
    if (localObject != null) {
      ((QQVideoGaussianBlurFilter)localObject).a();
    }
    localObject = this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    if (localObject != null)
    {
      ((GPUBaseFilter)localObject).destroy();
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup;
    if (localObject != null)
    {
      ((GpuImagePartsFilterGroup)localObject).destroy();
      this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (localObject != null)
    {
      ((QQFilterRenderManager)localObject).surfaceDestroyed();
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
      QQFilterRenderManagerHolder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter = new QQVideoGaussianBlurFilter(paramInt);
  }
  
  public void a(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2)
  {
    int j;
    if (paramRenderBuffer != null) {
      j = paramRenderBuffer.getTexId();
    } else {
      j = 0;
    }
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      paramRenderBuffer = this.jdField_a_of_type_JavaNioByteBuffer;
      if (paramRenderBuffer != null)
      {
        paramRenderBuffer.rewind();
        if (j != 0) {}
        try
        {
          paramRenderBuffer = new int[1];
          GLES20.glGenFramebuffers(1, paramRenderBuffer, 0);
          GLES20.glBindFramebuffer(36160, paramRenderBuffer[0]);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, j, 0);
          GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glDeleteFramebuffers(1, paramRenderBuffer, 0);
          paramRenderBuffer[0] = 0;
          break label129;
          GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
          label129:
          this.i = false;
          return;
        }
        catch (Exception paramRenderBuffer)
        {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
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
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRunnable);
      return;
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    Object localObject = paramArrayOfFloat2;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = paramArrayOfFloat2;
      if (this.jdField_d_of_type_Boolean) {
        if (this.jdField_e_of_type_Boolean)
        {
          localObject = new float[16];
          Matrix.setIdentityM((float[])localObject, 0);
        }
        else
        {
          localObject = GPUBaseFilter.caculateFitCenterMvpMatrix(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
    }
    a(this.jdField_a_of_type_JavaUtilLinkedList);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    Matrix.rotateM((float[])localObject, 0, this.jdField_g_of_type_Int, 0.0F, 0.0F, 1.0F);
    Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    super.a(paramArrayOfFloat1, (float[])localObject);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    int m = ((RenderBuffer)localObject).getTexId();
    int j = m;
    if (this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter != null)
    {
      ((RenderBuffer)localObject).bind();
      j = this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter.a(m);
      ((RenderBuffer)localObject).unbind();
    }
    paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    m = j;
    if (paramArrayOfFloat1 != null)
    {
      paramArrayOfFloat1.setParam("key_draw_screen", String.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_width", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_height", String.valueOf(this.jdField_d_of_type_Int));
      int n = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(j);
      m = j;
      if (n != -1) {
        m = n;
      }
    }
    paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (localObject == paramArrayOfFloat2) {
      paramArrayOfFloat1 = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    }
    paramArrayOfFloat1.bind();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(m, null, null);
    m = paramArrayOfFloat1.getTexId();
    paramArrayOfFloat1.unbind();
    this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup.a();
    paramArrayOfFloat2 = paramArrayOfFloat1;
    j = m;
    if (this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup.a())
    {
      localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      paramArrayOfFloat2 = (float[])localObject;
      if (paramArrayOfFloat1 == localObject) {
        paramArrayOfFloat2 = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      }
      paramArrayOfFloat2.bind();
      this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup.drawTexture(m, null, null);
      j = paramArrayOfFloat2.getTexId();
      paramArrayOfFloat2.unbind();
    }
    if (this.i) {
      a(paramArrayOfFloat2, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramArrayOfFloat1 = new float[16];
    Matrix.setIdentityM(paramArrayOfFloat1, 0);
    Matrix.scaleM(paramArrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(j, null, paramArrayOfFloat1);
  }
  
  public void h() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    super.onDecodeFrame(paramLong1, paramLong2);
    QQFilterRenderManager localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (localQQFilterRenderManager != null) {
      localQQFilterRenderManager.getBusinessOperation().SetTimeStamp(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat");
    super.onDecodeRepeat();
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
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 33984);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 33984);
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup;
    if (paramGL10 != null) {
      paramGL10.onOutputSizeChanged(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter;
    if (paramGL10 != null) {
      paramGL10.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      try
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int * this.jdField_d_of_type_Int * 4];
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte);
      }
      catch (OutOfMemoryError paramGL10)
      {
        QLog.e("VideoFilterPlayView", 1, "init trackByteBuffer failed ", paramGL10);
        paramGL10 = this.jdField_a_of_type_JavaNioByteBuffer;
        if (paramGL10 != null)
        {
          paramGL10.clear();
          this.jdField_a_of_type_JavaNioByteBuffer = null;
        }
      }
    }
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (paramGL10 != null)
    {
      paramGL10.surfaceChange(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_f_of_type_Boolean = false;
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
      this.jdField_g_of_type_Boolean = false;
      QLog.e("VideoFilterPlayView", 1, "onSurfaceCreated : Load so fail");
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    paramGL10 = FilterFactory.a(101);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGL10;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGL10;
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
    paramGL10 = this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    if (paramGL10 != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGL10;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.initForce();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup = new GpuImagePartsFilterGroup();
    this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup.init();
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter;
    if (paramGL10 != null) {
      paramGL10.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (paramGL10 != null)
    {
      paramGL10.surfaceCreate(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_f_of_type_Boolean = false;
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
    GpuImagePartsFilterGroup localGpuImagePartsFilterGroup = this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup;
    if (localGpuImagePartsFilterGroup != null)
    {
      if ((!localGpuImagePartsFilterGroup.a()) && (paramInt == 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup.a(paramInt, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilterGpuImagePartsFilterGroup.a(paramInt1, paramInt2, paramFloat, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    super.setFilePath(paramString1, paramString2);
  }
  
  public void setFilePath(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_e_of_type_Boolean = paramBoolean3;
    setFilePath(paramString1, paramString2);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      paramString1 = VideoUtils.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
      this.jdField_c_of_type_Int = ((Integer)paramString1.first).intValue();
      this.jdField_d_of_type_Int = ((Integer)paramString1.second).intValue();
    }
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = null;
      return;
    }
    if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter == null)
    {
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = FilterFactory.a(106);
      a(new VideoFilterPlayView.1(this));
    }
    ((GPUImagePixelationFilter)this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter).a(paramBitmap);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */