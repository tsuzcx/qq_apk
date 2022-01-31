import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkServiceManager;

public class amvc
  extends RemoteCommand
{
  public amvc(QlinkServiceManager paramQlinkServiceManager, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    QlinkServiceManager.a(this.a).a().c(paramBundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvc
 * JD-Core Version:    0.7.0.1
 */