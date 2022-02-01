import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class amlv
  implements EIPCResultCallback
{
  amlv(amoe paramamoe) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str1 = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static getApolloRoleInfo errMsg : " + str1);
    if (paramEIPCResult.isSuccess())
    {
      String str2 = paramEIPCResult.data.getString("apolloRoleDir");
      if (this.a != null) {
        this.a.a(str2, str1, paramEIPCResult.code);
      }
      anlx.a("apollo_role_info", String.valueOf(System.currentTimeMillis() - l), str1);
      if (!paramEIPCResult.isSuccess()) {
        break label182;
      }
    }
    label182:
    for (int i = 0;; i = paramEIPCResult.code)
    {
      if (paramEIPCResult.isSuccess()) {
        str1 = "";
      }
      anis.a(132, String.valueOf(l), 3, i, new Object[] { str1 });
      anis.b(132, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.a(null, str1, paramEIPCResult.code);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlv
 * JD-Core Version:    0.7.0.1
 */