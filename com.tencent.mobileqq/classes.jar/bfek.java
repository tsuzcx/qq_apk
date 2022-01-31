import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

public class bfek
  extends RemoteCommand
{
  private QQAppInterface a;
  
  public bfek(QQAppInterface paramQQAppInterface)
  {
    super("common.get_qq_app_interface_data");
    this.a = paramQQAppInterface;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("param_data_type", 0);
    paramOnInvokeFinishLinstener = new Bundle();
    switch (i)
    {
    default: 
      return paramOnInvokeFinishLinstener;
    case 1: 
      paramBundle = paramBundle.getString("param_uin");
      paramOnInvokeFinishLinstener.putString("result_key", babh.h(this.a, paramBundle));
      return paramOnInvokeFinishLinstener;
    }
    String str = paramBundle.getString("param_uin");
    boolean bool = paramBundle.getBoolean("param_fetch_if_not_exist", false);
    paramOnInvokeFinishLinstener.putString("result_key", babh.b(this.a, str, bool));
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfek
 * JD-Core Version:    0.7.0.1
 */