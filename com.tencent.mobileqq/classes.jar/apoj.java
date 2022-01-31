import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class apoj
  implements Handler.Callback
{
  public apoj(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    MsgBackupSettingFragment.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apoj
 * JD-Core Version:    0.7.0.1
 */