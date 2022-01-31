import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class asgl
  implements EIPCOnGetConnectionListener
{
  asgl(asgj paramasgj) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      asgj.a(this.a, paramEIPCConnection.procName);
    }
    asgj.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      asgj.a(this.a, paramEIPCConnection.procName);
    }
    asgj.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgl
 * JD-Core Version:    0.7.0.1
 */