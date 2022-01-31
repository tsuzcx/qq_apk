import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;

public class anri
  implements DialogInterface.OnDismissListener
{
  public anri(JumpConfirmFragment paramJumpConfirmFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    JefsClass.getInstance().b(JumpConfirmFragment.a(this.a), JumpConfirmFragment.a(this.a), JumpConfirmFragment.b(this.a));
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anri
 * JD-Core Version:    0.7.0.1
 */