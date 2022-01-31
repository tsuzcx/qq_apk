import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class bjnb
  implements EIPClientConnectListener
{
  bjnb(bjna parambjna) {}
  
  public void connectFailed()
  {
    bjna.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bjna.a(this.a, paramEIPCConnection.procName);
    }
    bjna.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectSuccess:" + bjna.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnb
 * JD-Core Version:    0.7.0.1
 */