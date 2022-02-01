import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class angu
  implements EIPCResultCallback
{
  public angu(anps paramanps) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      this.a.a(1);
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk resp == null");
      return;
    }
    annv.au = paramEIPCResult.getString("sApolloBaseScriptId");
    amsx.q = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    amsx.r = paramEIPCResult.getBoolean("sApolloEngineLockEnable");
    annv.av = annv.a + "/script/" + annv.au + "/";
    if (anpq.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      anpq.b(this.a);
      anpq.a(this.a);
      anpq.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angu
 * JD-Core Version:    0.7.0.1
 */