import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aogf
  implements EIPCResultCallback
{
  aogf(aoge paramaoge) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("DanmuDataIPCClient", 1, new Object[] { "get barrage list, IPC success, msgSeq:", Long.valueOf(paramEIPCResult.data.getLong("key_barrage_msg_seq")) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogf
 * JD-Core Version:    0.7.0.1
 */