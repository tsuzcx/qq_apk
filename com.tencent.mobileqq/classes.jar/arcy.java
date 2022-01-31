import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class arcy
  implements EIPCResultCallback
{
  arcy(arcx paramarcx) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    arcx.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      arcx.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    arcx.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcy
 * JD-Core Version:    0.7.0.1
 */