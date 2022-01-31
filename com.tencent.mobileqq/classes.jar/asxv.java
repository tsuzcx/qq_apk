import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class asxv
  implements EIPCResultCallback
{
  asxv(asxu paramasxu) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    asxu.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      asxu.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    asxu.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxv
 * JD-Core Version:    0.7.0.1
 */