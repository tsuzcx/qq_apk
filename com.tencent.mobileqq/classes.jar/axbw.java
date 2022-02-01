import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class axbw
  implements EIPCOnGetConnectionListener
{
  axbw(axbu paramaxbu) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      axbu.a(this.a, paramEIPCConnection.procName);
    }
    axbu.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      axbu.a(this.a, paramEIPCConnection.procName);
    }
    axbu.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbw
 * JD-Core Version:    0.7.0.1
 */