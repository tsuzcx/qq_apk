import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class apyb
  implements EIPCResultCallback
{
  apyb(apxv paramapxv, apyu paramapyu) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    if (paramEIPCResult.code != 0) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.async, method=" + this.jdField_a_of_type_Apyu.a() + " result=" + paramEIPCResult);
    }
    apyu localapyu = this.jdField_a_of_type_Apyu;
    if (paramEIPCResult.code == 0) {}
    for (;;)
    {
      localapyu.a(bool, paramEIPCResult.data);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyb
 * JD-Core Version:    0.7.0.1
 */