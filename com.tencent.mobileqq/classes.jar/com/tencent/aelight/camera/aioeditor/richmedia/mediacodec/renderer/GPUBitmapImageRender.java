package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.QQEncodeFilterRender;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSVArtFilterNew;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglSurfaceBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.IntBuffer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GPUBitmapImageRender
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public EGLContext a;
  private QQEncodeFilterRender jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private EglCore jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  
  private void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.b();
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public Bitmap a(Bitmap paramBitmap, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    Object localObject = FilterFactory.a(0);
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
    if (localQQFilterRenderManager != null)
    {
      MusicItemInfo localMusicItemInfo = localQQFilterRenderManager.getBusinessOperation().getMusicItemInfo();
      this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender = new QQEncodeFilterRender(localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList(), localMusicItemInfo, this.b, this.c, null);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender != null) && (localObject != null))
    {
      try
      {
        paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
        ((GPUBaseFilter)localObject).init();
        this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender.a(this.b, this.c);
        paramBitmap = a(paramBitmap, (GPUBaseFilter)localObject);
        try
        {
          ((GPUBaseFilter)localObject).destroy();
          this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender.a();
          localObject = UIUtils.a(paramBitmap, 1.0F, -1.0F);
        }
        catch (OutOfMemoryError localOutOfMemoryError1) {}
        localObject = paramBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        paramBitmap = null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("renderEditVideoFilterBitmap OutOfMemoryError");
        ((StringBuilder)localObject).append(localOutOfMemoryError2.toString());
        QLog.e("GPUBitmapImageRender", 2, ((StringBuilder)localObject).toString());
        localObject = paramBitmap;
      }
    }
    else
    {
      localObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender = null;
    return localObject;
  }
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramGPUBaseFilter = this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender;
    int i;
    if ((paramGPUBaseFilter != null) && (paramGPUBaseFilter.jdField_a_of_type_Boolean)) {
      i = 30;
    } else {
      i = 2;
    }
    int j = 0;
    while (j < i)
    {
      onDrawFrame(null);
      j += 1;
    }
    paramGPUBaseFilter = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
    GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramGPUBaseFilter);
    paramGPUBaseFilter = paramGPUBaseFilter.array();
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramGPUBaseFilter));
    return paramBitmap;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, GPUBitmapImageRender paramGPUBitmapImageRender)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGPUBitmapImageRender.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramGPUBitmapImageRender.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      int j = 5;
      boolean bool = paramGPUBitmapImageRender.jdField_a_of_type_Boolean;
      int k = 0;
      int i = k;
      if (bool)
      {
        paramGPUBitmapImageRender.jdField_a_of_type_Boolean = false;
        j = 20;
        i = k;
      }
      while (i < j)
      {
        onDrawFrame(null);
        i += 1;
      }
      paramList = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
      GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramList);
      paramList = paramList.array();
      paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramList));
      return UIUtils.a(paramBitmap, 1.0F, -1.0F);
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, boolean paramBoolean)
  {
    GPUBaseFilter localGPUBaseFilter = FilterFactory.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
      localGPUBaseFilter.init();
      QQFilterRenderManager localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
      int i = this.b;
      int j = this.c;
      localQQFilterRenderManager.surfaceCreate(i, j, i, j);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(90));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
      return UIUtils.a(a(paramBitmap, localGPUBaseFilter), 1.0F, -1.0F);
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    if (localObject != null) {
      ((GPUBaseFilter)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (localObject != null)
    {
      ((QQFilterRenderManager)localObject).surfaceDestroyed();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = new EglCore(EGL14.eglGetCurrentContext(), 1);
    }
    d(paramInt1, paramInt2);
  }
  
  public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = new EglCore(paramEGLContext, 1);
    d(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = new EglCore(EGL14.EGL_NO_CONTEXT, 1);
    }
    d(paramInt1, paramInt2);
  }
  
  @TargetApi(17)
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglGetCurrentContext();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = FilterFactory.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    int i = this.b;
    int j = this.c;
    ((QQFilterRenderManager)localObject).surfaceCreate(i, j, i, j);
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramInt1, paramInt2);
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(90);
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    try
    {
      ((QQSVArtFilterNew)((List)localObject).get(0)).onSurfaceChange(paramInt1, paramInt2);
      label118:
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(90));
      return;
    }
    catch (Exception localException)
    {
      break label118;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() % 2 == 1)
    {
      paramGL10 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + 1, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramGL10);
      ((Canvas)localObject).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    }
    else
    {
      paramGL10 = null;
    }
    if (paramGL10 == null) {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    } else {
      localObject = paramGL10;
    }
    this.jdField_a_of_type_Int = GlUtil.createTexture(3553, (Bitmap)localObject);
    if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
      paramGL10.recycle();
    }
    paramGL10 = new float[16];
    Matrix.setIdentityM(paramGL10, 0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender;
    if (localObject != null) {
      this.jdField_a_of_type_Int = ((QQEncodeFilterRender)localObject).a(this.b, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (localObject != null)
    {
      ((QQFilterRenderManager)localObject).setParam("key_draw_screen", String.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_width", String.valueOf(this.b));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_height", String.valueOf(this.c));
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(this.jdField_a_of_type_Int);
      if (i != -1) {
        this.jdField_a_of_type_Int = i;
      }
    }
    GLES20.glFinish();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, paramGL10);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.getProgram());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (paramGL10 != null)
    {
      paramInt1 = this.b;
      paramInt2 = this.c;
      paramGL10.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender
 * JD-Core Version:    0.7.0.1
 */