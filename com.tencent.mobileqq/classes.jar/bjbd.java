import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.AuthorityControlFragment;

public class bjbd
  implements DialogInterface.OnCancelListener
{
  public bjbd(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.getActivity();
    if (paramDialogInterface != null) {
      paramDialogInterface.doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbd
 * JD-Core Version:    0.7.0.1
 */