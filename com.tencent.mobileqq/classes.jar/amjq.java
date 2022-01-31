import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

class amjq
  implements DialogInterface.OnClickListener
{
  amjq(amjp paramamjp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    amjt.d(BaseApplicationImpl.getContext());
    if (this.a.a.getActivity() != null)
    {
      this.a.a.getActivity().finish();
      this.a.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjq
 * JD-Core Version:    0.7.0.1
 */