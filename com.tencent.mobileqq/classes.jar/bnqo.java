import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnqo
  implements Observer<bnuq>
{
  bnqo(bnqm parambnqm) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    if (parambnuq == null) {}
    do
    {
      return;
      parambnuq = parambnuq.b;
      if (parambnuq == AECaptureMode.NORMAL)
      {
        bnqm.a(this.a).setVisibility(8);
        return;
      }
      if (parambnuq == AECaptureMode.GIF)
      {
        bnqm.a(this.a);
        return;
      }
    } while (parambnuq != AECaptureMode.PLAY);
    bnqm.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqo
 * JD-Core Version:    0.7.0.1
 */