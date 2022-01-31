import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class arkr
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "ACTION_QUIT_WATCH_FLOATING_WINDOWS result=", Integer.valueOf(paramEIPCResult.code) });
    }
    if (paramEIPCResult.code != 0) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkr
 * JD-Core Version:    0.7.0.1
 */