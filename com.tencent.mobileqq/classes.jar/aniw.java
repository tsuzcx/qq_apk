import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.InsetDrawable;
import android.widget.Button;
import com.tencent.mobileqq.utils.ViewUtils;
import dov.com.qq.im.QIMCameraCaptureUnit;

class aniw
  implements Runnable
{
  aniw(aniv paramaniv) {}
  
  public void run()
  {
    if ((QIMCameraCaptureUnit.a(this.a.a) != null) && (this.a.a.e != null))
    {
      int i = ViewUtils.a(7.5F);
      InsetDrawable localInsetDrawable = new InsetDrawable(new BitmapDrawable(QIMCameraCaptureUnit.a(this.a.a)), i, i, i, i);
      this.a.a.e.setBackgroundDrawable(localInsetDrawable);
      this.a.a.e.setVisibility(0);
      this.a.a.e.setEnabled(true);
      return;
    }
    this.a.a.e.setVisibility(8);
    this.a.a.e.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aniw
 * JD-Core Version:    0.7.0.1
 */