import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bkwz
  implements bmac<blbb>
{
  bkwz(bkwx parambkwx) {}
  
  public void a(@Nullable blbb paramblbb)
  {
    if (paramblbb == null) {}
    do
    {
      return;
      paramblbb = paramblbb.a;
      if (paramblbb == AECaptureMode.NORMAL)
      {
        bkwx.a(this.a).setVisibility(8);
        return;
      }
      if (paramblbb == AECaptureMode.GIF)
      {
        bkwx.a(this.a);
        return;
      }
    } while (paramblbb != AECaptureMode.PLAY);
    bkwx.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwz
 * JD-Core Version:    0.7.0.1
 */