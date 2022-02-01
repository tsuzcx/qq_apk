import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;
import java.util.List;
import mqq.os.MqqHandler;

public class axbs
  implements awzl
{
  public axbs(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void a(List<RecentBaseData> paramList)
  {
    MsgBackupSelectionFragment.a(this.a, true);
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a.a.clear();
      this.a.a.addAll(paramList);
    }
    for (;;)
    {
      paramList = MsgBackupSelectionFragment.a(this.a).obtainMessage(10000);
      MsgBackupSelectionFragment.a(this.a).sendMessage(paramList);
      return;
      if (MsgBackupSelectionFragment.a(this.a) == 0) {
        axct.a("0X800A232");
      } else if (awzs.c) {
        axct.a("0X800A257");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbs
 * JD-Core Version:    0.7.0.1
 */