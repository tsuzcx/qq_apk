import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class bics
  implements EIPCOnGetConnectionListener
{
  bics(bicr parambicr) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bicr.a(this.a, paramEIPCConnection.procName);
    }
    bicr.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bicr.a(this.a, paramEIPCConnection.procName);
    }
    bicr.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bics
 * JD-Core Version:    0.7.0.1
 */