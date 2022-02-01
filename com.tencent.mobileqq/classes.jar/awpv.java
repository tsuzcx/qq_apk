import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;

public class awpv
  implements DialogInterface.OnClickListener
{
  public awpv(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = awql.a().e();
    if (1 == paramInt)
    {
      this.a.l();
      if (this.a.a) {
        awqs.a("0X800A253", 3);
      }
    }
    while (2 != paramInt)
    {
      return;
      awqs.a("0X800A253", 1);
      return;
    }
    if (this.a.d) {
      awqs.a("0X800A244", 2);
    }
    for (;;)
    {
      this.a.l();
      return;
      awqs.a("0X800A244", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpv
 * JD-Core Version:    0.7.0.1
 */