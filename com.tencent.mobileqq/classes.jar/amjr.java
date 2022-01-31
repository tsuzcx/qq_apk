import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

class amjr
  implements DialogInterface.OnClickListener
{
  amjr(amjq paramamjq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    amju.d(BaseApplicationImpl.getContext());
    if (this.a.a.getActivity() != null)
    {
      this.a.a.getActivity().finish();
      this.a.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjr
 * JD-Core Version:    0.7.0.1
 */