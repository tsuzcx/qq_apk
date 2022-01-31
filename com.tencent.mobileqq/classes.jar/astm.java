import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class astm
  implements EIPCResultCallback
{
  astm(astl paramastl) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    astl.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      astl.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    astl.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astm
 * JD-Core Version:    0.7.0.1
 */