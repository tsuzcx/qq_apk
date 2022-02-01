package com.tencent.aelight.camera.ae.album.nocropper;

class AECropperView$TouchGestureCallback
  implements AECropperImageView.GestureCallback
{
  private AECropperView$TouchGestureCallback(AECropperView paramAECropperView) {}
  
  public void a()
  {
    Object localObject = this.a;
    boolean bool = true;
    AECropperView.a((AECropperView)localObject, true);
    if (AECropperView.a(this.a) != null)
    {
      localObject = AECropperView.a(this.a);
      if (((AECropperView.b(this.a) != null) && (!AECropperView.b(this.a).a())) || (this.a.a == null) || (!this.a.a.e())) {
        bool = false;
      }
      ((AECropperGridView)localObject).setShowGrid(bool);
    }
  }
  
  public void b()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    AECropperView.a((AECropperView)localObject, false);
    if (AECropperView.a(this.a) != null)
    {
      localObject = AECropperView.a(this.a);
      boolean bool1 = bool2;
      if (AECropperView.b(this.a) != null)
      {
        bool1 = bool2;
        if (AECropperView.b(this.a).b()) {
          bool1 = true;
        }
      }
      ((AECropperGridView)localObject).setShowGrid(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperView.TouchGestureCallback
 * JD-Core Version:    0.7.0.1
 */