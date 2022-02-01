import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aoro
  implements EIPCResultCallback
{
  aoro(aori paramaori, aosh paramaosh) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    if (paramEIPCResult.code != 0) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.async, method=" + this.jdField_a_of_type_Aosh.a() + " result=" + paramEIPCResult);
    }
    aosh localaosh = this.jdField_a_of_type_Aosh;
    if (paramEIPCResult.code == 0) {}
    for (;;)
    {
      localaosh.a(bool, paramEIPCResult.data);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoro
 * JD-Core Version:    0.7.0.1
 */