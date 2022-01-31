import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class bjnc
  implements EIPCOnGetConnectionListener
{
  bjnc(bjna parambjna) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bjna.a(this.a, paramEIPCConnection.procName);
    }
    bjna.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "onConnectBind!");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bjna.a(this.a, paramEIPCConnection.procName);
    }
    bjna.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "onConnectUnbind:" + bjna.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnc
 * JD-Core Version:    0.7.0.1
 */