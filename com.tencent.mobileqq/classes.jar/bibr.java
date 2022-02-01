import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bibr
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLDrawableDownloadHelper", 2, "requestDownloadDepends success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibr
 * JD-Core Version:    0.7.0.1
 */