import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bavg
  implements EIPClientConnectListener
{
  bavg(bavf parambavf) {}
  
  public void connectFailed()
  {
    bavf.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bavf.a(this.a, paramEIPCConnection.procName);
    }
    bavf.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    bavf.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavg
 * JD-Core Version:    0.7.0.1
 */