import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class auko
  implements EIPCResultCallback
{
  auko(aukn paramaukn) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    aukn.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      aukn.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    aukn.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auko
 * JD-Core Version:    0.7.0.1
 */