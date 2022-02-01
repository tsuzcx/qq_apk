import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ancw
  implements EIPCResultCallback
{
  public ancw(anmd paramanmd) {}
  
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
    anka.H = paramEIPCResult.getString("sApolloBaseScriptId");
    amme.q = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    amme.r = paramEIPCResult.getBoolean("sApolloEngineLockEnable");
    anka.I = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/" + anka.H + "/";
    if (anmb.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      anmb.b(this.a);
      anmb.a(this.a);
      anmb.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancw
 * JD-Core Version:    0.7.0.1
 */