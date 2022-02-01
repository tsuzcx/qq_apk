import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class axbv
  implements EIPClientConnectListener
{
  axbv(axbu paramaxbu) {}
  
  public void connectFailed()
  {
    axbu.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      axbu.a(this.a, paramEIPCConnection.procName);
    }
    axbu.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbv
 * JD-Core Version:    0.7.0.1
 */