import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class amlw
  implements EIPCResultCallback
{
  amlw(anfj paramanfj) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static checkDownloadFaceData errMsg : " + str);
    if (paramEIPCResult.isSuccess())
    {
      if (this.a != null) {
        this.a.onDownloadFinish(true, paramEIPCResult.code);
      }
      anlx.a("apollo_face_data", String.valueOf(System.currentTimeMillis() - l), str);
      if (!paramEIPCResult.isSuccess()) {
        break label166;
      }
    }
    label166:
    for (int i = 0;; i = paramEIPCResult.code)
    {
      if (paramEIPCResult.isSuccess()) {
        str = "";
      }
      anis.a(132, String.valueOf(l), 4, i, new Object[] { str });
      anis.b(132, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.onDownloadFinish(false, paramEIPCResult.code);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlw
 * JD-Core Version:    0.7.0.1
 */