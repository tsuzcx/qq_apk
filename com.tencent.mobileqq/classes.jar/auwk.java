import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class auwk
  implements Handler.Callback
{
  public auwk(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    MsgBackupSettingFragment.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwk
 * JD-Core Version:    0.7.0.1
 */