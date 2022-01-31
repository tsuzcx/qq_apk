import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class avzx
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private avyy jdField_a_of_type_Avyy;
  private avyz jdField_a_of_type_Avyz;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private int b;
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    onDrawFrame(null);
    onDrawFrame(null);
    paramGPUBaseFilter = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
    GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramGPUBaseFilter);
    paramGPUBaseFilter = paramGPUBaseFilter.array();
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramGPUBaseFilter));
    return paramBitmap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avyz != null)
    {
      this.jdField_a_of_type_Avyz.a();
      this.jdField_a_of_type_Avyz = null;
    }
    if (this.jdField_a_of_type_Avyy != null)
    {
      this.jdField_a_of_type_Avyy.a();
      this.jdField_a_of_type_Avyy = null;
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Avyy = new avyy(EGL14.eglGetCurrentContext(), 1);
    }
    this.jdField_a_of_type_Avyz = new avyz(this.jdField_a_of_type_Avyy);
    this.jdField_a_of_type_Avyz.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Avyz.b();
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
        break label144;
      }
    }
    label144:
    for (Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;; localObject = paramGL10)
    {
      this.b = GlUtil.createTexture(3553, (Bitmap)localObject);
      if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
        paramGL10.recycle();
      }
      paramGL10 = new float[16];
      Matrix.setIdentityM(paramGL10, 0);
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
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzx
 * JD-Core Version:    0.7.0.1
 */