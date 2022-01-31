import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;

public class asmp
  implements View.OnClickListener
{
  public asmp(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MsgBackupDateFragment.a(this.a) != null) && (MsgBackupDateFragment.a(this.a).isShowing())) {
      MsgBackupDateFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asmp
 * JD-Core Version:    0.7.0.1
 */