import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class avxo
  implements EIPCResultCallback
{
  avxo(avxn paramavxn) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    avxn.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      avxn.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    avxn.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxo
 * JD-Core Version:    0.7.0.1
 */