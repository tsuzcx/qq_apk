import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;

public class asmn
  implements View.OnClickListener
{
  public asmn(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if (MsgBackupDateFragment.a(this.a) == 0) {
      asog.a("0X800A236");
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      if (aslg.c) {
        asog.a("0X800A25B");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asmn
 * JD-Core Version:    0.7.0.1
 */