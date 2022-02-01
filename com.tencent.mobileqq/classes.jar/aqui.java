import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

public class aqui
  implements DialogInterface.OnClickListener
{
  public aqui(ColorNoteSmallScreenPermissionDialogFragment paramColorNoteSmallScreenPermissionDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aquk.d(BaseApplicationImpl.getContext());
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
    bdll.b(null, "dc00898", "", "", "0X800AB3C", "0X800AB3C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqui
 * JD-Core Version:    0.7.0.1
 */