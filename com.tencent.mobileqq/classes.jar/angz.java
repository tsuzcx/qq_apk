import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ar.view.ARScanEntryView;

public class angz
  implements DialogInterface.OnDismissListener
{
  public angz(ARScanEntryView paramARScanEntryView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ARScanEntryView.a(this.a, null);
    ARScanEntryView.a(this.a).g();
    ARScanEntryView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angz
 * JD-Core Version:    0.7.0.1
 */