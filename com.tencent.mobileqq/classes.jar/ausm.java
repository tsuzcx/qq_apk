import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class ausm
  implements DialogInterface.OnCancelListener
{
  public ausm(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausm
 * JD-Core Version:    0.7.0.1
 */