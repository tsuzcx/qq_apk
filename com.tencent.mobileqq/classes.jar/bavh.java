import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class bavh
  implements EIPCOnGetConnectionListener
{
  bavh(bavf parambavf) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bavf.a(this.a, paramEIPCConnection.procName);
    }
    bavf.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bavf.a(this.a, paramEIPCConnection.procName);
    }
    bavf.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavh
 * JD-Core Version:    0.7.0.1
 */