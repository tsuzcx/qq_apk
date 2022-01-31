import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment;
import com.tencent.qphone.base.util.QLog;

public class auij
  implements bexc
{
  public auij(MsgBackupPCTransportFragment paramMsgBackupPCTransportFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    int i = augd.a().a();
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "page is in pc Link page! click cancel! bizType = " + i + ", pcHandler = " + this.a.e);
      }
      this.a.aI_();
      return;
      augo.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "backup is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + augo.a + ", curSpeed = " + this.a.a + ", hasFinishedCount = " + this.a.d);
      }
      augo.a().a().a(null);
      augo.a().a(this.a.a, this.a.d, i, this.a.getActivity());
      if (this.a.b != 1) {
        break;
      }
    } while (!this.a.e);
    aujo.a("0X800A260");
    return;
    aujo.a("0X800A284");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auij
 * JD-Core Version:    0.7.0.1
 */