import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class avfl
  implements EIPCResultCallback
{
  avfl(avfk paramavfk) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    avfk.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      avfk.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    avfk.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfl
 * JD-Core Version:    0.7.0.1
 */