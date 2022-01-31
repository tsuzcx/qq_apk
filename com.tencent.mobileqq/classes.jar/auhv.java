import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;

public class auhv
  implements View.OnClickListener
{
  public auhv(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if (MsgBackupDateFragment.a(this.a) == 0) {
      aujo.a("0X800A236");
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      if (augo.c) {
        aujo.a("0X800A25B");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auhv
 * JD-Core Version:    0.7.0.1
 */