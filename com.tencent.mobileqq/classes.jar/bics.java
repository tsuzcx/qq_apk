import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

public class bics
{
  public static void a(Runnable paramRunnable)
  {
    QLog.d("OpenSdkQIPCClient", 1, "installWBSdk process=" + bjht.r());
    QIPCClientHelper.getInstance().callServer("weibo_qipc_module", "action_install_weibo_sdk", new Bundle(), new bict(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bics
 * JD-Core Version:    0.7.0.1
 */