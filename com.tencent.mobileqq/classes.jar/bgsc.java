import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

public class bgsc
{
  public static void a(Runnable paramRunnable)
  {
    QLog.d("OpenSdkQIPCClient", 1, "installWBSdk process=" + bhwr.r());
    QIPCClientHelper.getInstance().callServer("weibo_qipc_module", "action_install_weibo_sdk", new Bundle(), new bgsd(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgsc
 * JD-Core Version:    0.7.0.1
 */