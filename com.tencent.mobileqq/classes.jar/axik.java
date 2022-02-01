import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;

public class axik
  implements bjey
{
  public axik(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    int i = 2;
    if (paramInt == 1)
    {
      axjn.a("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", new Object[] { Integer.valueOf(MsgBackupSelectionFragment.a(this.a)), Boolean.valueOf(axgj.c) });
      if (MsgBackupSelectionFragment.a(this.a) != 0) {
        break label79;
      }
      paramInt = i;
      if (MsgBackupSelectionFragment.a(this.a)) {
        paramInt = 3;
      }
      axjk.a("0X800A242", paramInt);
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      label79:
      if ((axgj.c) && (axfy.a().a() == 1)) {
        axjk.a("0X800A266", 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axik
 * JD-Core Version:    0.7.0.1
 */