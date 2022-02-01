import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class bnsc
  extends RemoteCommand
{
  bnsc(bnrz parambnrz, String paramString)
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
      localBundle = this.a.b(paramBundle);
      if (localBundle != null) {
        localBundle.setClassLoader(getClass().getClassLoader());
      }
      paramBundle = localBundle;
    } while (paramOnInvokeFinishLinstener == null);
    paramOnInvokeFinishLinstener.onInvokeFinish(localBundle);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsc
 * JD-Core Version:    0.7.0.1
 */