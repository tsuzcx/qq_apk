import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloResManager.ApolloDressInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class amlt
  implements EIPCResultCallback
{
  amlt(amof paramamof) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = paramEIPCResult.data.getString("apolloErrMsg");
    long l = paramEIPCResult.data.getLong("startTime");
    QLog.d("cm_res", 1, "static getApolloUserRes errMsg : " + str);
    if (paramEIPCResult.isSuccess())
    {
      ApolloResManager.ApolloDressInfo localApolloDressInfo = (ApolloResManager.ApolloDressInfo)paramEIPCResult.data.getParcelable("apolloUserDressInfo");
      if (this.a != null) {
        this.a.a(localApolloDressInfo, str, paramEIPCResult.code);
      }
      anlx.a("apollo_user_res", String.valueOf(System.currentTimeMillis() - l), str);
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
      anis.a(132, String.valueOf(l), 1, i, new Object[] { str });
      anis.b(132, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.a(null, str, paramEIPCResult.code);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlt
 * JD-Core Version:    0.7.0.1
 */