import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;

class bmxn
  implements AECameraManager.CameraOpenCallback
{
  bmxn(bmxa parambmxa) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.c()) {
        bbhk.a(paramInt);
      }
      if (this.a.a) {
        this.a.s();
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
 * Qualified Name:     bmxn
 * JD-Core Version:    0.7.0.1
 */