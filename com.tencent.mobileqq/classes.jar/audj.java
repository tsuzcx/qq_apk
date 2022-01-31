import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;

public class audj
  implements DialogInterface.OnClickListener
{
  public audj(MsgBackupCompleteFragment paramMsgBackupCompleteFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MsgBackupCompleteFragment.a(this.a);
    if (MsgBackupCompleteFragment.a(this.a) == 1) {
      auff.a("0X800A253", 5);
    }
    while ((MsgBackupCompleteFragment.a(this.a) != 4) || (!MsgBackupCompleteFragment.a(this.a))) {
      return;
    }
    auff.a("0X800A267", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audj
 * JD-Core Version:    0.7.0.1
 */