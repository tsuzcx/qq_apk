import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;

public class atnf
  implements DialogInterface.OnDismissListener
{
  public atnf(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!ListenTogetherOverlayFragment.a(this.a)) && (!ListenTogetherOverlayFragment.a(this.a).isFinishing())) {
      ListenTogetherOverlayFragment.a(this.a).finish();
    }
    ListenTogetherOverlayFragment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnf
 * JD-Core Version:    0.7.0.1
 */