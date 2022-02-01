import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bpxv
  implements EIPClientConnectListener
{
  bpxv(bpxu parambpxu) {}
  
  public void connectFailed()
  {
    bpxu.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bpxu.a(this.a, paramEIPCConnection.procName);
    }
    bpxu.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectSuccess:" + bpxu.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxv
 * JD-Core Version:    0.7.0.1
 */