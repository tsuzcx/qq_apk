import android.os.Bundle;
import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aqbr
  implements EIPCResultCallback
{
  aqbr(aqbo paramaqbo, String paramString, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("ArkApp.ArkMultiProcUtil", 1, new Object[] { "ArkMultiProc.download url=", this.jdField_a_of_type_JavaLangString, ", ipc call back code=", Integer.valueOf(paramEIPCResult.code) });
    int j = -1;
    int i = j;
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      i = j;
      if (paramEIPCResult != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
          i = paramEIPCResult.getInt("code");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onDownload(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbr
 * JD-Core Version:    0.7.0.1
 */