import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class biuq
  extends RemoteCommand
{
  biuq(biup parambiup, String paramString)
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
      localBundle = biup.a(this.a, paramBundle);
      if (localBundle != null) {
        localBundle.setClassLoader(getClass().getClassLoader());
      }
      paramBundle = localBundle;
    } while (paramOnInvokeFinishLinstener == null);
    paramOnInvokeFinishLinstener.onInvokeFinish(localBundle);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biuq
 * JD-Core Version:    0.7.0.1
 */