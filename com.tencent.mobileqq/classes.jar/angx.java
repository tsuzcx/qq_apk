import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class angx
  implements EIPCResultCallback
{
  public angx(angz paramangz) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    QLog.i("CmShow_CmShowRenderView", 1, "changeApolloStatus ipc code:" + paramEIPCResult.code);
    ApolloUtil.b("changeApolloStatus code:" + paramEIPCResult.code);
    angz localangz;
    if (this.a != null)
    {
      localangz = this.a;
      if (paramEIPCResult.code != 0) {
        break label82;
      }
    }
    for (;;)
    {
      localangz.a(bool);
      return;
      label82:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angx
 * JD-Core Version:    0.7.0.1
 */