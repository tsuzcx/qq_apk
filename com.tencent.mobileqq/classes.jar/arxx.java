import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class arxx
  implements EIPCResultCallback
{
  arxx(arxw paramarxw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      bool = true;
      if (!bool)
      {
        if (paramEIPCResult != null) {
          break label57;
        }
        QLog.d("FlutterMainQIPCModule", 1, "ipc callback, result == null");
      }
    }
    for (;;)
    {
      QLog.d("FlutterMainQIPCModule", 1, new Object[] { "ipc callback , isSuccess: %s", Boolean.valueOf(bool) });
      return;
      bool = false;
      break;
      label57:
      QLog.d("FlutterMainQIPCModule", 1, "ipc callback, errCode: " + paramEIPCResult.code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxx
 * JD-Core Version:    0.7.0.1
 */