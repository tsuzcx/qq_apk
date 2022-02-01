import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;

class blkg
  implements AECameraManager.CameraOpenCallback
{
  blkg(bljy parambljy) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.b()) {
        babb.a(paramInt);
      }
      if (this.a.a) {
        this.a.l();
      }
    }
    else
    {
      return;
    }
    this.a.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkg
 * JD-Core Version:    0.7.0.1
 */