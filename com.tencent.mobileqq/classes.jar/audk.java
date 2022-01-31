import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;

public class audk
  implements DialogInterface.OnClickListener
{
  public audk(MsgBackupCompleteFragment paramMsgBackupCompleteFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audk
 * JD-Core Version:    0.7.0.1
 */