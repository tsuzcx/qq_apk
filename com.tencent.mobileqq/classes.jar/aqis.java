import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aqis
  implements EIPCResultCallback
{
  aqis(aqir paramaqir) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aqip.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      aqir.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    aqir.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqis
 * JD-Core Version:    0.7.0.1
 */