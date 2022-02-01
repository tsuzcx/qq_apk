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
  public EGLContext a;
  private EglCore b;
  private EglSurfaceBase c;
  private GPUBaseFilter d;
  private Bitmap e;
  private int f;
  private int g;
  private int h;
  private QQFilterRenderManager i;
  private QQEncodeFilterRender j;
  private long k = 0L;
  private boolean l = true;
  
  private void d(int paramInt1, int paramInt2)
  {
    this.c = new EglSurfaceBase(this.b);
    this.c.a(paramInt1, paramInt2);
    this.c.b();
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public Bitmap a(Bitmap paramBitmap, long paramLong)
  {
    this.k = paramLong;
    Object localObject = FilterFactory.a(0);
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
    if (localQQFilterRenderManager != null)
    {
      MusicItemInfo localMusicItemInfo = localQQFilterRenderManager.getBusinessOperation().getMusicItemInfo();
      this.j = new QQEncodeFilterRender(localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList(), localMusicItemInfo, this.g, this.h, null);
    }
    else
    {
      this.j = null;
    }
    if ((this.j != null) && (localObject != null))
    {
      try
      {
        paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
        ((GPUBaseFilter)localObject).init();
        this.j.a(this.g, this.h);
        paramBitmap = a(paramBitmap, (GPUBaseFilter)localObject);
        try
        {
          ((GPUBaseFilter)localObject).destroy();
          this.j.a();
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
    this.j = null;
    return localObject;
  }
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.e = paramBitmap;
    this.d = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramGPUBaseFilter = this.j;
    int m;
    if ((paramGPUBaseFilter != null) && (paramGPUBaseFilter.a)) {
      m = 30;
    } else {
      m = 2;
    }
    int n = 0;
    while (n < m)
    {
      onDrawFrame(null);
      n += 1;
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
    this.d = paramGPUBitmapImageRender.d;
    this.i = paramGPUBitmapImageRender.i;
    if ((this.i != null) && (this.d != null) && (paramList != null))
    {
      paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
      this.i.getBusinessOperation().setFilterEffectList(paramList);
      this.e = paramBitmap;
      int n = 5;
      boolean bool = paramGPUBitmapImageRender.l;
      int i1 = 0;
      int m = i1;
      if (bool)
      {
        paramGPUBitmapImageRender.l = false;
        n = 20;
        m = i1;
      }
      while (m < n)
      {
        onDrawFrame(null);
        m += 1;
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
    this.i = QQFilterRenderManagerHolder.a();
    if ((this.i != null) && (localGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
      localGPUBaseFilter.init();
      QQFilterRenderManager localQQFilterRenderManager = this.i;
      int m = this.g;
      int n = this.h;
      localQQFilterRenderManager.surfaceCreate(m, n, m, n);
      this.i.setParam("key_orientation_degree", String.valueOf(90));
      this.i.getBusinessOperation().setFilterEffectList(paramList);
      return UIUtils.a(a(paramBitmap, localGPUBaseFilter), 1.0F, -1.0F);
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.c = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.b = null;
    }
    localObject = this.d;
    if (localObject != null) {
      ((GPUBaseFilter)localObject).destroy();
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((QQFilterRenderManager)localObject).surfaceDestroyed();
      this.i = null;
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.b = new EglCore(EGL14.eglGetCurrentContext(), 1);
    }
    d(paramInt1, paramInt2);
  }
  
  public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.b = new EglCore(paramEGLContext, 1);
    d(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.b = new EglCore(EGL14.EGL_NO_CONTEXT, 1);
    }
    d(paramInt1, paramInt2);
  }
  
  @TargetApi(17)
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.a = EGL14.eglGetCurrentContext();
    this.d = FilterFactory.a(0);
    this.i = QQFilterRenderManagerHolder.b();
    this.d.init();
    Object localObject = this.i;
    int m = this.g;
    int n = this.h;
    ((QQFilterRenderManager)localObject).surfaceCreate(m, n, m, n);
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramInt1, paramInt2);
    localObject = this.i.getQQFilters(90);
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    try
    {
      ((QQSVArtFilterNew)((List)localObject).get(0)).onSurfaceChange(paramInt1, paramInt2);
      label118:
      this.i.setParam("key_orientation_degree", String.valueOf(90));
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
    if (this.e.getWidth() % 2 == 1)
    {
      paramGL10 = Bitmap.createBitmap(this.e.getWidth() + 1, this.e.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramGL10);
      ((Canvas)localObject).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject).drawBitmap(this.e, 0.0F, 0.0F, null);
    }
    else
    {
      paramGL10 = null;
    }
    if (paramGL10 == null) {
      localObject = this.e;
    } else {
      localObject = paramGL10;
    }
    this.f = GlUtil.createTexture(3553, (Bitmap)localObject);
    if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
      paramGL10.recycle();
    }
    paramGL10 = new float[16];
    Matrix.setIdentityM(paramGL10, 0);
    Object localObject = this.j;
    if (localObject != null) {
      this.f = ((QQEncodeFilterRender)localObject).a(this.g, this.h, this.f, this.k);
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((QQFilterRenderManager)localObject).setParam("key_draw_screen", String.valueOf(false));
      this.i.setParam("key_width", String.valueOf(this.g));
      this.i.setParam("key_height", String.valueOf(this.h));
      int m = this.i.drawFrame(this.f);
      if (m != -1) {
        this.f = m;
      }
    }
    GLES20.glFinish();
    this.d.drawTexture(this.f, null, paramGL10);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.d.getProgram());
    this.d.onOutputSizeChanged(paramInt1, paramInt2);
    paramGL10 = this.i;
    if (paramGL10 != null)
    {
      paramInt1 = this.g;
      paramInt2 = this.h;
      paramGL10.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender
 * JD-Core Version:    0.7.0.1
 */