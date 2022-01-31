import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;

public class aueg
  implements best
{
  public aueg(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    int i = 2;
    if (paramInt == 1)
    {
      aufh.a("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", new Object[] { Integer.valueOf(MsgBackupSelectionFragment.a(this.a)), Boolean.valueOf(aucf.c) });
      if (MsgBackupSelectionFragment.a(this.a) != 0) {
        break label79;
      }
      paramInt = i;
      if (MsgBackupSelectionFragment.a(this.a)) {
        paramInt = 3;
      }
      auff.a("0X800A242", paramInt);
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      label79:
      if ((aucf.c) && (aubu.a().a() == 1)) {
        auff.a("0X800A266", 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aueg
 * JD-Core Version:    0.7.0.1
 */