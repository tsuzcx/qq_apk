import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "eipcResult", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class amut
  implements EIPCResultCallback
{
  amut(amus paramamus) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramEIPCResult, "eipcResult");
    if (paramEIPCResult.isSuccess())
    {
      this.a.e();
      return;
    }
    QLog.e(amup.a.a(), 1, "[AEKit]AECMShowQipcModule initStepDownloadAEKitResource error");
    this.a.a(-5032, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amut
 * JD-Core Version:    0.7.0.1
 */