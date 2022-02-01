import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnlq
  implements Observer<bnpr>
{
  bnlq(bnln parambnln) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    if (parambnpr == null) {}
    AECaptureMode localAECaptureMode;
    do
    {
      do
      {
        return;
        localAECaptureMode = parambnpr.b;
        if (localAECaptureMode == AECaptureMode.NORMAL)
        {
          bnln.a(this.a).setVisibility(8);
          bnln.a(this.a).setVisibility(8);
          return;
        }
        if (localAECaptureMode != AECaptureMode.GIF) {
          break;
        }
        bnln.a(this.a);
        bnlh.a().a();
        bnqm.a().ag();
      } while ((parambnpr.a == null) || (TextUtils.isEmpty(bnln.a(this.a))));
      bnqq.a().l(bnln.a(this.a));
      bnqm.a().aj();
      return;
    } while (localAECaptureMode != AECaptureMode.PLAY);
    bnln.a(this.a).setVisibility(8);
    bnln.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlq
 * JD-Core Version:    0.7.0.1
 */