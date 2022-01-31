import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class asbo
  implements Handler.Callback
{
  public asbo(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    MsgBackupSettingFragment.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbo
 * JD-Core Version:    0.7.0.1
 */