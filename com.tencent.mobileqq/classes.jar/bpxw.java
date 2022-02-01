import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class bpxw
  implements EIPCOnGetConnectionListener
{
  bpxw(bpxu parambpxu) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bpxu.a(this.a, paramEIPCConnection.procName);
    }
    bpxu.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "onConnectBind!");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bpxu.a(this.a, paramEIPCConnection.procName);
    }
    bpxu.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "onConnectUnbind:" + bpxu.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxw
 * JD-Core Version:    0.7.0.1
 */