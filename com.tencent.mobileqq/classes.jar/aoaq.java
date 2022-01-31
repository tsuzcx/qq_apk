import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

public class aoaq
  implements DialogInterface.OnCancelListener
{
  public aoaq(ColorNoteSmallScreenPermissionDialogFragment paramColorNoteSmallScreenPermissionDialogFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
    azmj.b(null, "dc00898", "", "", "0X800AB3B", "0X800AB3B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoaq
 * JD-Core Version:    0.7.0.1
 */