import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.AuthorityControlFragment;

public class bbup
  implements DialogInterface.OnCancelListener
{
  public bbup(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.getActivity();
    if (paramDialogInterface != null) {
      paramDialogInterface.doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbup
 * JD-Core Version:    0.7.0.1
 */