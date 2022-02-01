import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blwg
  implements Observer<bmah>
{
  blwg(blwd paramblwd) {}
  
  public void a(@Nullable bmah parambmah)
  {
    if (parambmah == null) {}
    AECaptureMode localAECaptureMode;
    do
    {
      do
      {
        return;
        localAECaptureMode = parambmah.b;
        if (localAECaptureMode == AECaptureMode.NORMAL)
        {
          blwd.a(this.a).setVisibility(8);
          blwd.a(this.a).setVisibility(8);
          return;
        }
        if (localAECaptureMode != AECaptureMode.GIF) {
          break;
        }
        blwd.a(this.a);
        blwd.b(this.a);
        bmbc.a().ag();
      } while ((parambmah.a == null) || (TextUtils.isEmpty(blwd.a(this.a))));
      bmbg.a().l(blwd.a(this.a));
      bmbc.a().aj();
      return;
    } while (localAECaptureMode != AECaptureMode.PLAY);
    blwd.a(this.a).setVisibility(8);
    blwd.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwg
 * JD-Core Version:    0.7.0.1
 */