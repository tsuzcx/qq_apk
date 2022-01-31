import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;

public class asnh
  implements bctk
{
  public asnh(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    int i = 2;
    if (paramInt == 1)
    {
      asoi.a("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", new Object[] { Integer.valueOf(MsgBackupSelectionFragment.a(this.a)), Boolean.valueOf(aslg.c) });
      if (MsgBackupSelectionFragment.a(this.a) != 0) {
        break label79;
      }
      paramInt = i;
      if (MsgBackupSelectionFragment.a(this.a)) {
        paramInt = 3;
      }
      asog.a("0X800A242", paramInt);
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      label79:
      if ((aslg.c) && (askv.a().a() == 1)) {
        asog.a("0X800A266", 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asnh
 * JD-Core Version:    0.7.0.1
 */