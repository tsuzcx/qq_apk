import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ancy
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("CmShow_CmShowRenderView", 1, "openCmShowStore CmShow code:" + paramEIPCResult.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancy
 * JD-Core Version:    0.7.0.1
 */