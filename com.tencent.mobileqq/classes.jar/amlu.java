import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

final class amlu
  implements EIPCResultCallback
{
  amlu(amod paramamod) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static getApolloDressInfo errMsg : " + str);
    if (paramEIPCResult.isSuccess())
    {
      HashMap localHashMap = (HashMap)paramEIPCResult.data.getSerializable("apolloDressInfo");
      if (this.a != null) {
        this.a.onGetApolloDressInfo(localHashMap, str, paramEIPCResult.code);
      }
      anlx.a("apollo_dress_info", String.valueOf(System.currentTimeMillis() - l), str);
      if (!paramEIPCResult.isSuccess()) {
        break label185;
      }
    }
    label185:
    for (int i = 0;; i = paramEIPCResult.code)
    {
      if (paramEIPCResult.isSuccess()) {
        str = "";
      }
      anis.a(132, String.valueOf(l), 2, i, new Object[] { str });
      anis.b(132, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.onGetApolloDressInfo(null, str, paramEIPCResult.code);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlu
 * JD-Core Version:    0.7.0.1
 */