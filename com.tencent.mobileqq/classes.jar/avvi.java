import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment;

public class avvi
  implements bhle
{
  public avvi(MsgBackupPCAuthFragment paramMsgBackupPCAuthFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1)
    {
      if (MsgBackupPCAuthFragment.a(this.a)) {
        this.a.k();
      }
      this.a.onBackEvent();
    }
    while (paramInt != 2) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvi
 * JD-Core Version:    0.7.0.1
 */