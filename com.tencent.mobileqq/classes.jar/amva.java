import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class amva
  implements EIPCResultCallback
{
  public amva(andx paramandx) {}
  
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
    ancb.au = paramEIPCResult.getString("sApolloBaseScriptId");
    amhd.q = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    amhd.r = paramEIPCResult.getBoolean("sApolloEngineLockEnable");
    ancb.av = ancb.a + "/script/" + ancb.au + "/";
    if (andw.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      andw.b(this.a);
      andw.a(this.a);
      andw.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amva
 * JD-Core Version:    0.7.0.1
 */