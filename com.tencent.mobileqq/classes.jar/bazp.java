import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bazp
  implements EIPClientConnectListener
{
  bazp(bazo parambazo) {}
  
  public void connectFailed()
  {
    bazo.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bazo.a(this.a, paramEIPCConnection.procName);
    }
    bazo.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    bazo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazp
 * JD-Core Version:    0.7.0.1
 */