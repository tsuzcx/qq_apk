import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class avqj
  implements EIPCResultCallback
{
  avqj(avqi paramavqi) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    avqi.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      avqi.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    avqi.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqj
 * JD-Core Version:    0.7.0.1
 */