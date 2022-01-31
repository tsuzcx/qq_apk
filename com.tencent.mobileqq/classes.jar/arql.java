import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;

public class arql
  implements View.OnClickListener
{
  public arql(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MsgBackupDateFragment.a(this.a) != null) && (MsgBackupDateFragment.a(this.a).isShowing())) {
      MsgBackupDateFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arql
 * JD-Core Version:    0.7.0.1
 */