import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class ayxh
  implements EIPClientConnectListener
{
  ayxh(ayxg paramayxg) {}
  
  public void connectFailed()
  {
    ayxg.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      ayxg.a(this.a, paramEIPCConnection.procName);
    }
    ayxg.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    ayxg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxh
 * JD-Core Version:    0.7.0.1
 */