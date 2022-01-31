import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class asgk
  implements EIPClientConnectListener
{
  asgk(asgj paramasgj) {}
  
  public void connectFailed()
  {
    asgj.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      asgj.a(this.a, paramEIPCConnection.procName);
    }
    asgj.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgk
 * JD-Core Version:    0.7.0.1
 */