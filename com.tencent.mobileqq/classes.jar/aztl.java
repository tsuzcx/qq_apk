import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aztl
  implements EIPCResultCallback
{
  aztl(aztk paramaztk) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "eipcResult=", Integer.valueOf(paramEIPCResult.code), paramEIPCResult.data });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aztl
 * JD-Core Version:    0.7.0.1
 */