import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class bkeo
  implements EIPCOnGetConnectionListener
{
  bkeo(bken parambken) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bken.a(this.a, paramEIPCConnection.procName);
    }
    bken.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      bken.a(this.a, paramEIPCConnection.procName);
    }
    bken.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkeo
 * JD-Core Version:    0.7.0.1
 */