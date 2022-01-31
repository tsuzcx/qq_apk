import android.graphics.drawable.BitmapDrawable;
import android.widget.Button;
import dov.com.qq.im.QIMCameraCaptureUnit;

class anrd
  implements Runnable
{
  anrd(anrc paramanrc) {}
  
  public void run()
  {
    if ((QIMCameraCaptureUnit.a(this.a.a) != null) && (this.a.a.e != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(QIMCameraCaptureUnit.a(this.a.a));
      this.a.a.e.setBackgroundDrawable(localBitmapDrawable);
      this.a.a.e.setVisibility(0);
      this.a.a.e.setEnabled(true);
      return;
    }
    this.a.a.e.setVisibility(8);
    this.a.a.e.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrd
 * JD-Core Version:    0.7.0.1
 */