import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class amky
  implements EIPCResultCallback
{
  amky(amkx paramamkx) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("DanmuDataIPCClient", 1, new Object[] { "get barrage list, IPC success, msgSeq:", Long.valueOf(paramEIPCResult.data.getLong("key_barrage_msg_seq")) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amky
 * JD-Core Version:    0.7.0.1
 */