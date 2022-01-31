import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

public class bcxk
{
  public static void a()
  {
    QLog.i("Q.quicklogin.OpenSdkQIPCClient", 1, "doPtloginCancel");
    QIPCClientHelper.getInstance().callServer("open_sdk_qipc_module", "action_ptlogin_cancel", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcxk
 * JD-Core Version:    0.7.0.1
 */