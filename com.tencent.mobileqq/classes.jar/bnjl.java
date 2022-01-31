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
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSVArtFilterNew;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.IntBuffer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bnjl
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public EGLContext a;
  private axqx jdField_a_of_type_Axqx;
  private axqy jdField_a_of_type_Axqy;
  private bnmc jdField_a_of_type_Bnmc;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c = bkka.jdField_a_of_type_Int;
  private int d;
  private int e;
  
  private void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Axqy = new axqy(this.jdField_a_of_type_Axqx);
    this.jdField_a_of_type_Axqy.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Axqy.b();
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public Bitmap a(Bitmap paramBitmap, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    Object localObject = bnjk.a(0);
    QQFilterRenderManager localQQFilterRenderManager = bkka.a(bkka.c);
    if (localQQFilterRenderManager != null)
    {
      MusicItemInfo localMusicItemInfo = localQQFilterRenderManager.getBusinessOperation().getMusicItemInfo();
      this.jdField_a_of_type_Bnmc = new bnmc(localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList(), localMusicItemInfo, this.d, this.e, null);
      this.jdField_a_of_type_Bnmc.a(true);
      if ((this.jdField_a_of_type_Bnmc == null) || (localObject == null)) {
        break label210;
      }
    }
    for (;;)
    {
      try
      {
        paramBitmap = xod.a(paramBitmap, 1.0F, -1.0F);
        ((GPUBaseFilter)localObject).init();
        this.jdField_a_of_type_Bnmc.a(this.d, this.e);
        paramBitmap = a(paramBitmap, (GPUBaseFilter)localObject);
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        paramBitmap = null;
      }
      try
      {
        ((GPUBaseFilter)localObject).destroy();
        this.jdField_a_of_type_Bnmc.a();
        localObject = xod.a(paramBitmap, 1.0F, -1.0F);
        this.jdField_a_of_type_Bnmc = null;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        break label161;
      }
      this.jdField_a_of_type_Bnmc = null;
      break;
      label161:
      localObject = paramBitmap;
      if (QLog.isColorLevel())
      {
        QLog.e("GPUBitmapImageRender", 2, "renderEditVideoFilterBitmap OutOfMemoryError" + localOutOfMemoryError1.toString());
        localObject = paramBitmap;
        continue;
        label210:
        localObject = null;
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    if ((this.jdField_a_of_type_Bnmc != null) && (this.jdField_a_of_type_Bnmc.jdField_a_of_type_Boolean)) {}
    for (int i = 30;; i = 2)
    {
      int j = 0;
      while (j < i)
      {
        onDrawFrame(null);
        j += 1;
      }
    }
    paramGPUBaseFilter = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
    GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramGPUBaseFilter);
    paramGPUBaseFilter = paramGPUBaseFilter.array();
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramGPUBaseFilter));
    return paramBitmap;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, bnjl parambnjl)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = parambnjl.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = parambnjl.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = xod.a(paramBitmap, 1.0F, -1.0F);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      int i = 5;
      if (parambnjl.jdField_a_of_type_Boolean)
      {
        parambnjl.jdField_a_of_type_Boolean = false;
        i = 20;
      }
      int j = 0;
      while (j < i)
      {
        onDrawFrame(null);
        j += 1;
      }
      paramList = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
      GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramList);
      paramList = paramList.array();
      paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramList));
      return xod.a(paramBitmap, 1.0F, -1.0F);
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, boolean paramBoolean)
  {
    GPUBaseFilter localGPUBaseFilter = bnjk.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = bkka.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = xod.a(paramBitmap, 1.0F, -1.0F);
      localGPUBaseFilter.init();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.d, this.e, this.d, this.e);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(90));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
      return xod.a(a(paramBitmap, localGPUBaseFilter), 1.0F, -1.0F);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axqy != null)
    {
      this.jdField_a_of_type_Axqy.a();
      this.jdField_a_of_type_Axqy = null;
    }
    if (this.jdField_a_of_type_Axqx != null)
    {
      this.jdField_a_of_type_Axqx.a();
      this.jdField_a_of_type_Axqx = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.c = bkka.jdField_a_of_type_Int;
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Axqx = new axqx(EGL14.eglGetCurrentContext(), 1);
    }
    d(paramInt1, paramInt2);
  }
  
  public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Axqx = new axqx(paramEGLContext, 1);
    d(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Axqx = new axqx(EGL14.EGL_NO_CONTEXT, 1);
    }
    d(paramInt1, paramInt2);
  }
  
  @TargetApi(17)
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglGetCurrentContext();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = bnjk.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = bkka.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.d, this.e, this.d, this.e);
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramInt1, paramInt2);
    List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(90);
    if ((localList != null) && (localList.size() > 0)) {}
    try
    {
      ((QQSVArtFilterNew)localList.get(0)).onSurfaceChange(paramInt1, paramInt2);
      label109:
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(90));
      return;
    }
    catch (Exception localException)
    {
      break label109;
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
      this.jdField_a_of_type_Int = 1;
      if (paramGL10 != null) {
        break label258;
      }
    }
    label258:
    for (Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;; localObject = paramGL10)
    {
      this.b = GlUtil.createTexture(3553, (Bitmap)localObject);
      if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
        paramGL10.recycle();
      }
      paramGL10 = new float[16];
      Matrix.setIdentityM(paramGL10, 0);
      if (this.jdField_a_of_type_Bnmc != null) {
        this.b = this.jdField_a_of_type_Bnmc.a(this.d, this.e, this.b, this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(false));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_width", String.valueOf(this.d));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_height", String.valueOf(this.e));
        int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(this.b);
        if (i != -1) {
          this.b = i;
        }
      }
      GLES20.glFinish();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.b, null, paramGL10);
      return;
      this.jdField_a_of_type_Int = 0;
      paramGL10 = null;
      break;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.getProgram());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.d, this.e, this.d, this.e);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjl
 * JD-Core Version:    0.7.0.1
 */