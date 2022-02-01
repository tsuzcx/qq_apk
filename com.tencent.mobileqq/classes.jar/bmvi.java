import dov.com.qq.im.ae.camera.core.AECameraManager.CameraOpenCallback;

class bmvi
  implements AECameraManager.CameraOpenCallback
{
  bmvi(bmvf parambmvf) {}
  
  public void onOpenResult(int paramInt, boolean paramBoolean)
  {
    bnrh.b(this.a.jdField_a_of_type_JavaLangString, "tryOpenCamera result=" + paramBoolean + ", whichCamera=" + paramInt + ", mActivityResume=" + this.a.jdField_a_of_type_Boolean);
    if (paramBoolean)
    {
      if (this.a.c()) {
        bbhk.a(paramInt);
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.d(false);
      }
    }
    else
    {
      return;
    }
    this.a.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvi
 * JD-Core Version:    0.7.0.1
 */