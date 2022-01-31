import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.dingdong.DingdongPluginRemoteCmdHandler;

public class amsj
  extends RemoteCommand
{
  public amsj(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if ((paramBundle.getBoolean("_async_call_", true)) && (Thread.currentThread() != Looper.getMainLooper().getThread()))
    {
      new Handler(Looper.getMainLooper()).post(new amsk(this, paramBundle, paramOnInvokeFinishLinstener));
      paramBundle.putInt("_result_code_", 0);
      return paramBundle;
    }
    return this.a.a(paramBundle, paramOnInvokeFinishLinstener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsj
 * JD-Core Version:    0.7.0.1
 */