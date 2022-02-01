import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class bmqn
  implements EIPCOnGetConnectionListener
{
  bmqn(bmqm parambmqm) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bmqm.a(this.a, paramEIPCConnection.procName);
    }
    bmqm.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bmqm.a(this.a, paramEIPCConnection.procName);
    }
    bmqm.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqn
 * JD-Core Version:    0.7.0.1
 */