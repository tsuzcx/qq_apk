import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class amph
  implements EIPCResultCallback
{
  amph(ampb paramampb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow onDressChanged send!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amph
 * JD-Core Version:    0.7.0.1
 */