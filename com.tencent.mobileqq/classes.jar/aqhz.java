import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class aqhz
  implements Handler.Callback
{
  public aqhz(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    MsgBackupSettingFragment.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhz
 * JD-Core Version:    0.7.0.1
 */