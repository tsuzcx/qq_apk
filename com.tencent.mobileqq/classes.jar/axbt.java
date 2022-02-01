import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;

public class axbt
  implements bivu
{
  public axbt(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    int i = 2;
    if (paramInt == 1)
    {
      axcw.a("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", new Object[] { Integer.valueOf(MsgBackupSelectionFragment.a(this.a)), Boolean.valueOf(awzs.c) });
      if (MsgBackupSelectionFragment.a(this.a) != 0) {
        break label79;
      }
      paramInt = i;
      if (MsgBackupSelectionFragment.a(this.a)) {
        paramInt = 3;
      }
      axct.a("0X800A242", paramInt);
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      label79:
      if ((awzs.c) && (awzh.a().a() == 1)) {
        axct.a("0X800A266", 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbt
 * JD-Core Version:    0.7.0.1
 */