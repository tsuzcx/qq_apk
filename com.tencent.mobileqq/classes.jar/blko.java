import android.graphics.SurfaceTexture;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;

class blko
  implements AECameraGLSurfaceView.AEGLSurfaceListener
{
  blko(bljy parambljy) {}
  
  public void onFirstFrameDone()
  {
    bmau.a().a("onFirstFrameDone");
    bljy.b(this.a);
  }
  
  public void onOrientionChanged(int paramInt)
  {
    this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setActivityOrientation(paramInt);
  }
  
  public void onPreviewSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setFocusOperatorMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onPreviewSurfaceTextureCreate(SurfaceTexture paramSurfaceTexture)
  {
    this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    bmbx.b(this.a.jdField_a_of_type_JavaLangString, "onPreviewSurfaceTextureCreate---" + this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.a.l();
  }
  
  public void onPreviewSurfaceTextureRelease()
  {
    bmbx.b(this.a.jdField_a_of_type_JavaLangString, "onPreviewSurfaceTextureRelease---" + this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blko
 * JD-Core Version:    0.7.0.1
 */