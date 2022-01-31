import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.app.AppRuntime;

public class biva
  extends RemoteCommand
{
  public biva()
  {
    super("qqreader_plugin_asyn_cmd");
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    switch (paramBundle.getInt("CommondType"))
    {
    }
    for (;;)
    {
      return null;
      if (a() != null)
      {
        paramBundle = paramBundle.getString("publicaccount_uin");
        syb.a(a(), a().getApp(), paramBundle, new bivb(this, paramOnInvokeFinishLinstener));
        continue;
        QWalletHelper.preloadQWallet(a());
      }
    }
  }
  
  public boolean isSynchronized()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biva
 * JD-Core Version:    0.7.0.1
 */