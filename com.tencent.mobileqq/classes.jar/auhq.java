import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;

public class auhq
  implements DialogInterface.OnClickListener
{
  public auhq(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.b == 2) {
      MsgBackupCompleteFragment.d(this.a.getActivity(), this.a.c, this.a.d);
    }
    while (this.a.b != 3) {
      return;
    }
    MsgBackupCompleteFragment.j(this.a.getActivity(), this.a.c, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auhq
 * JD-Core Version:    0.7.0.1
 */