import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class awka
  implements DialogInterface.OnCancelListener
{
  public awka(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awka
 * JD-Core Version:    0.7.0.1
 */