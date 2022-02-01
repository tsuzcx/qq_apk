import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;

public class awou
  implements DialogInterface.OnClickListener
{
  public awou(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().setResult(1001);
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awou
 * JD-Core Version:    0.7.0.1
 */