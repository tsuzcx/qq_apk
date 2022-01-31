import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class bivb
  extends alvc
{
  bivb(biva parambiva, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new Bundle();
    paramString.putBoolean("isSuccess", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivb
 * JD-Core Version:    0.7.0.1
 */