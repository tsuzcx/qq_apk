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

public class boac
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public EGLContext a;
  private bafv jdField_a_of_type_Bafv;
  private bafw jdField_a_of_type_Bafw;
  private bobz jdField_a_of_type_Bobz;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  
  private void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bafw = new bafw(this.jdField_a_of_type_Bafv);
    this.jdField_a_of_type_Bafw.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Bafw.b();
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public Bitmap a(Bitmap paramBitmap, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    Object localObject = boab.a(0);
    QQFilterRenderManager localQQFilterRenderManager = blik.a(blik.c);
    if (localQQFilterRenderManager != null)
    {
      MusicItemInfo localMusicItemInfo = localQQFilterRenderManager.getBusinessOperation().getMusicItemInfo();
      this.jdField_a_of_type_Bobz = new bobz(localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList(), localMusicItemInfo, this.b, this.c, null);
      this.jdField_a_of_type_Bobz.a(true);
      if ((this.jdField_a_of_type_Bobz == null) || (localObject == null)) {
        break label210;
      }
    }
    for (;;)
    {
      try
      {
        paramBitmap = UIUtils.generateScaleBitmap(paramBitmap, 1.0F, -1.0F);
        ((GPUBaseFilter)localObject).init();
        this.jdField_a_of_type_Bobz.a(this.b, this.c);
        paramBitmap = a(paramBitmap, (GPUBaseFilter)localObject);
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        paramBitmap = null;
      }
      try
      {
        ((GPUBaseFilter)localObject).destroy();
        this.jdField_a_of_type_Bobz.a();
        localObject = UIUtils.generateScaleBitmap(paramBitmap, 1.0F, -1.0F);
        this.jdField_a_of_type_Bobz = null;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        break label161;
      }
      this.jdField_a_of_type_Bobz = null;
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
    if ((this.jdField_a_of_type_Bobz != null) && (this.jdField_a_of_type_Bobz.jdField_a_of_type_Boolean)) {}
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
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, boac paramboac)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramboac.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramboac.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = UIUtils.generateScaleBitmap(paramBitmap, 1.0F, -1.0F);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      int i = 5;
      if (paramboac.jdField_a_of_type_Boolean)
      {
        paramboac.jdField_a_of_type_Boolean = false;
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
      return UIUtils.generateScaleBitmap(paramBitmap, 1.0F, -1.0F);
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, List<FilterDesc> paramList, boolean paramBoolean)
  {
    GPUBaseFilter localGPUBaseFilter = boab.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = blik.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = UIUtils.generateScaleBitmap(paramBitmap, 1.0F, -1.0F);
      localGPUBaseFilter.init();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.b, this.c, this.b, this.c);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(90));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramList);
      return UIUtils.generateScaleBitmap(a(paramBitmap, localGPUBaseFilter), 1.0F, -1.0F);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bafw != null)
    {
      this.jdField_a_of_type_Bafw.a();
      this.jdField_a_of_type_Bafw = null;
    }
    if (this.jdField_a_of_type_Bafv != null)
    {
      this.jdField_a_of_type_Bafv.a();
      this.jdField_a_of_type_Bafv = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Bafv = new bafv(EGL14.eglGetCurrentContext(), 1);
    }
    d(paramInt1, paramInt2);
  }
  
  public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bafv = new bafv(paramEGLContext, 1);
    d(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Bafv = new bafv(EGL14.EGL_NO_CONTEXT, 1);
    }
    d(paramInt1, paramInt2);
  }
  
  @TargetApi(17)
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglGetCurrentContext();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = boab.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = blik.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.b, this.c, this.b, this.c);
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
    Object localObject;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() % 2 == 1)
    {
      paramGL10 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + 1, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramGL10);
      ((Canvas)localObject).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    }
    for (;;)
    {
      if (paramGL10 == null) {}
      for (localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;; localObject = paramGL10)
      {
        this.jdField_a_of_type_Int = GlUtil.createTexture(3553, (Bitmap)localObject);
        if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
          paramGL10.recycle();
        }
        paramGL10 = new float[16];
        Matrix.setIdentityM(paramGL10, 0);
        if (this.jdField_a_of_type_Bobz != null) {
          this.jdField_a_of_type_Int = this.jdField_a_of_type_Bobz.a(this.b, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(false));
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_width", String.valueOf(this.b));
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_height", String.valueOf(this.c));
          int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(this.jdField_a_of_type_Int);
          if (i != -1) {
            this.jdField_a_of_type_Int = i;
          }
        }
        GLES20.glFinish();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, paramGL10);
        return;
      }
      paramGL10 = null;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.getProgram());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.b, this.c, this.b, this.c);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boac
 * JD-Core Version:    0.7.0.1
 */