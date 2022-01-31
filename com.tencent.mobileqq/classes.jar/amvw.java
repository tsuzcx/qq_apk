import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class amvw
  extends RemoteCommand
{
  public amvw(DatalineRemoteManager paramDatalineRemoteManager, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {
      paramBundle = null;
    }
    Bundle localBundle;
    do
    {
      return paramBundle;
      paramBundle.setClassLoader(getClass().getClassLoader());
      localBundle = DatalineRemoteManager.a(this.a, paramBundle);
      if (localBundle != null) {
        localBundle.setClassLoader(getClass().getClassLoader());
      }
      paramBundle = localBundle;
    } while (paramOnInvokeFinishLinstener == null);
    paramOnInvokeFinishLinstener.onInvokeFinish(localBundle);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvw
 * JD-Core Version:    0.7.0.1
 */