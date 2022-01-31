import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blbg
  implements bmeo<blfi>
{
  blbg(blbe paramblbe) {}
  
  public void a(@Nullable blfi paramblfi)
  {
    if (paramblfi == null) {}
    do
    {
      return;
      paramblfi = paramblfi.a;
      if (paramblfi == AECaptureMode.NORMAL)
      {
        blbe.a(this.a).setVisibility(8);
        return;
      }
      if (paramblfi == AECaptureMode.GIF)
      {
        blbe.a(this.a);
        return;
      }
    } while (paramblfi != AECaptureMode.PLAY);
    blbe.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbg
 * JD-Core Version:    0.7.0.1
 */