import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class awvh
  implements EIPClientConnectListener
{
  awvh(awvg paramawvg) {}
  
  public void connectFailed()
  {
    awvg.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      awvg.a(this.a, paramEIPCConnection.procName);
    }
    awvg.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "connectSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvh
 * JD-Core Version:    0.7.0.1
 */