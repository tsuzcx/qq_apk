import dov.com.qq.im.ae.album.nocropper.AECropperGridView;
import dov.com.qq.im.ae.album.nocropper.AECropperImageView;
import dov.com.qq.im.ae.album.nocropper.AECropperView;

public class blnk
  implements blnf
{
  private blnk(AECropperView paramAECropperView) {}
  
  public void a()
  {
    boolean bool = true;
    AECropperView.a(this.a, true);
    AECropperGridView localAECropperGridView;
    if (AECropperView.a(this.a) != null)
    {
      localAECropperGridView = AECropperView.a(this.a);
      if (((AECropperView.a(this.a) != null) && (!AECropperView.a(this.a).a())) || (this.a.a == null) || (!this.a.a.b())) {
        break label83;
      }
    }
    for (;;)
    {
      localAECropperGridView.setShowGrid(bool);
      return;
      label83:
      bool = false;
    }
  }
  
  public void b()
  {
    boolean bool2 = false;
    AECropperView.a(this.a, false);
    if (AECropperView.a(this.a) != null)
    {
      AECropperGridView localAECropperGridView = AECropperView.a(this.a);
      boolean bool1 = bool2;
      if (AECropperView.a(this.a) != null)
      {
        bool1 = bool2;
        if (AECropperView.a(this.a).b()) {
          bool1 = true;
        }
      }
      localAECropperGridView.setShowGrid(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnk
 * JD-Core Version:    0.7.0.1
 */