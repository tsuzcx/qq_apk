import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;

class bmvg
  implements AECameraManager.CameraOpenCallback
{
  bmvg(bmvf parambmvf) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a.onChangeCamera(paramInt);
      if (this.a.c()) {
        bbhk.a(paramInt);
      }
      this.a.m();
      this.a.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvg
 * JD-Core Version:    0.7.0.1
 */