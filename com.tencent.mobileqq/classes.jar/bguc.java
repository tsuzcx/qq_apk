import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

class bguc
  extends akdn
{
  bguc(bgub parambgub, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new Bundle();
    paramString.putBoolean("isSuccess", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguc
 * JD-Core Version:    0.7.0.1
 */