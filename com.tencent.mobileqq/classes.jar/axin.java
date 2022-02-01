import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;

public class axin
  implements DialogInterface.OnClickListener
{
  public axin(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = axjd.a().e();
    if (1 == paramInt)
    {
      this.a.l();
      if (this.a.a) {
        axjk.a("0X800A253", 3);
      }
    }
    while (2 != paramInt)
    {
      return;
      axjk.a("0X800A253", 1);
      return;
    }
    if (this.a.d) {
      axjk.a("0X800A244", 2);
    }
    for (;;)
    {
      this.a.l();
      return;
      axjk.a("0X800A244", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axin
 * JD-Core Version:    0.7.0.1
 */