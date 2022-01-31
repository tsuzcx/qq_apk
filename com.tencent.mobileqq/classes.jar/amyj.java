import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qqreader.QRRemoteAsynCommond;

public class amyj
  extends PublicAccountObserver
{
  public amyj(QRRemoteAsynCommond paramQRRemoteAsynCommond, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    paramString = new Bundle();
    paramString.putBoolean("isSuccess", paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener.onInvokeFinish(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyj
 * JD-Core Version:    0.7.0.1
 */