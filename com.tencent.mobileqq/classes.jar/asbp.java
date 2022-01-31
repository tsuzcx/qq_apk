import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class asbp
  implements Handler.Callback
{
  public asbp(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbp
 * JD-Core Version:    0.7.0.1
 */