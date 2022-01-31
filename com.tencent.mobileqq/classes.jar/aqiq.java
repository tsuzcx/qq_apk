import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aqiq
  implements EIPCResultCallback
{
  aqiq(aqip paramaqip) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aqip.a(paramEIPCResult, "light");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      aqip.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    aqip.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqiq
 * JD-Core Version:    0.7.0.1
 */