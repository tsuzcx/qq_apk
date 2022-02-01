import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment;
import com.tencent.qphone.base.util.QLog;

public class axbn
  implements bivu
{
  public axbn(MsgBackupPCTransportFragment paramMsgBackupPCTransportFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    int i = awzh.a().a();
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "page is in pc Link page! click cancel! bizType = " + i + ", pcHandler = " + this.a.e);
      }
      this.a.ax_();
      return;
      awzs.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "backup is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + awzs.a + ", curSpeed = " + this.a.a + ", hasFinishedCount = " + this.a.d);
      }
      awzs.a().a().a(null);
      awzs.a().a(this.a.a, this.a.d, i, this.a.getActivity());
      if (this.a.b != 1) {
        break;
      }
    } while (!this.a.e);
    axct.a("0X800A260");
    return;
    axct.a("0X800A284");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbn
 * JD-Core Version:    0.7.0.1
 */