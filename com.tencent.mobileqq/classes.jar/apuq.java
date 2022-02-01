import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class apuq
  implements EIPCResultCallback
{
  apuq(apuj paramapuj, apvj paramapvj) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    if (paramEIPCResult.code != 0) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.async, method=" + this.jdField_a_of_type_Apvj.a() + " result=" + paramEIPCResult);
    }
    apvj localapvj = this.jdField_a_of_type_Apvj;
    if (paramEIPCResult.code == 0) {}
    for (;;)
    {
      localapvj.a(bool, paramEIPCResult.data);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuq
 * JD-Core Version:    0.7.0.1
 */