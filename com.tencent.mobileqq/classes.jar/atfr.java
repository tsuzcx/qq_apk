import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class atfr
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "ACTION_QUIT_WATCH_FLOATING_WINDOWS result=", Integer.valueOf(paramEIPCResult.code) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfr
 * JD-Core Version:    0.7.0.1
 */