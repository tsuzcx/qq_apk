import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class boqk
  implements EIPClientConnectListener
{
  boqk(boqj paramboqj) {}
  
  public void connectFailed()
  {
    boqj.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      boqj.a(this.a, paramEIPCConnection.procName);
    }
    boqj.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectSuccess:" + boqj.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqk
 * JD-Core Version:    0.7.0.1
 */