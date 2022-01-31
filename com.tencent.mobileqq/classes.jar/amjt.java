import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

class amjt
  implements DialogInterface.OnDismissListener
{
  amjt(amjq paramamjq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a.getActivity() != null)
    {
      this.a.a.getActivity().finish();
      this.a.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjt
 * JD-Core Version:    0.7.0.1
 */