import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class axwy
  implements EIPClientConnectListener
{
  axwy(axwx paramaxwx) {}
  
  public void connectFailed()
  {
    axwx.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      axwx.a(this.a, paramEIPCConnection.procName);
    }
    axwx.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    axwx.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwy
 * JD-Core Version:    0.7.0.1
 */