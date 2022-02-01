import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bosb
  implements Observer<bowc>
{
  bosb(bory parambory) {}
  
  public void a(@Nullable bowc parambowc)
  {
    if (parambowc == null) {}
    AECaptureMode localAECaptureMode;
    do
    {
      do
      {
        return;
        localAECaptureMode = parambowc.b;
        if (localAECaptureMode == AECaptureMode.NORMAL)
        {
          bory.a(this.a).setVisibility(8);
          bory.a(this.a).setVisibility(8);
          return;
        }
        if (localAECaptureMode != AECaptureMode.GIF) {
          break;
        }
        bory.a(this.a);
        bory.b(this.a);
        bozr.a().ac();
      } while ((parambowc.a == null) || (TextUtils.isEmpty(bory.a(this.a))));
      bozr.a().h(bory.a(this.a));
      return;
    } while (localAECaptureMode != AECaptureMode.PLAY);
    bory.a(this.a).setVisibility(8);
    bory.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosb
 * JD-Core Version:    0.7.0.1
 */