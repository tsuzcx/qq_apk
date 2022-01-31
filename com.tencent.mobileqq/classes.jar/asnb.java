import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment;
import com.tencent.qphone.base.util.QLog;

public class asnb
  implements bctk
{
  public asnb(MsgBackupPCTransportFragment paramMsgBackupPCTransportFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    int i = askv.a().a();
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "page is in pc Link page! click cancel! bizType = " + i + ", pcHandler = " + this.a.e);
      }
      this.a.aK_();
      return;
      aslg.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "backup is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + aslg.a + ", curSpeed = " + this.a.a + ", hasFinishedCount = " + this.a.d);
      }
      aslg.a().a().a(null);
      aslg.a().a(this.a.a, this.a.d, i, this.a.getActivity());
      if (this.a.b != 1) {
        break;
      }
    } while (!this.a.e);
    asog.a("0X800A260");
    return;
    asog.a("0X800A284");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asnb
 * JD-Core Version:    0.7.0.1
 */