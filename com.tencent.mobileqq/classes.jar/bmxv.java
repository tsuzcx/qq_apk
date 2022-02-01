import android.graphics.SurfaceTexture;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;

class bmxv
  implements AECameraGLSurfaceView.AEGLSurfaceListener
{
  bmxv(bmxa parambmxa) {}
  
  public void onDrawFrameWithEffect(int paramInt, AEFilterManager paramAEFilterManager)
  {
    this.a.a(paramInt, paramAEFilterManager);
  }
  
  public void onFirstFrameDone()
  {
    bnqe.a().a("onFirstFrameDone");
    this.a.a();
  }
  
  public void onOrientionChanged(int paramInt)
  {
    this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setActivityOrientation(paramInt);
  }
  
  public void onPreviewSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setFocusOperatorMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onPreviewSurfaceTextureCreate(SurfaceTexture paramSurfaceTexture)
  {
    this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    bnrh.b(this.a.jdField_a_of_type_JavaLangString, "onPreviewSurfaceTextureCreate---" + this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.a.s();
  }
  
  public void onPreviewSurfaceTextureRelease()
  {
    bnrh.b(this.a.jdField_a_of_type_JavaLangString, "onPreviewSurfaceTextureRelease---" + this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxv
 * JD-Core Version:    0.7.0.1
 */