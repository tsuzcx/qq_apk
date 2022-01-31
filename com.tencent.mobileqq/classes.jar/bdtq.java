import android.os.Bundle;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule.Params;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class bdtq
  implements EIPCResultCallback
{
  public bdtq(bdtn parambdtn) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code != 0)
    {
      this.a.a(2, "", "");
      return;
    }
    paramEIPCResult = (QuickUpdateIPCModule.Params)paramEIPCResult.data.getSerializable("params");
    this.a.a(paramEIPCResult.intVal, paramEIPCResult.strVal1, paramEIPCResult.strVal2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtq
 * JD-Core Version:    0.7.0.1
 */