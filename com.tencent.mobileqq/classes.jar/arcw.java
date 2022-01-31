import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class arcw
  implements EIPCResultCallback
{
  arcw(arcv paramarcv) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    arcv.a(paramEIPCResult, "action");
    switch (paramEIPCResult.code)
    {
    default: 
      return;
    case -102: 
      arcv.a(this.a).a(2, paramEIPCResult.data);
      return;
    }
    arcv.a(this.a).a(1, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcw
 * JD-Core Version:    0.7.0.1
 */