import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bmcr
  implements EIPCResultCallback
{
  bmcr(bnck parambnck) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEIPCResult != null)
    {
      bool1 = bool2;
      if (paramEIPCResult.data != null) {
        bool1 = paramEIPCResult.data.getBoolean("key_result");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcController", 2, "cancelSendVideoOrPhoto result:" + bool1 + ", uinseq:" + this.a.a + ", status:" + this.a.b + ", progress:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcr
 * JD-Core Version:    0.7.0.1
 */