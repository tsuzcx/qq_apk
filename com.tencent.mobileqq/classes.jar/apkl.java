import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class apkl
  implements EIPCResultCallback
{
  apkl(apkf paramapkf, aple paramaple) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    if (paramEIPCResult.code != 0) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.async, method=" + this.jdField_a_of_type_Aple.a() + " result=" + paramEIPCResult);
    }
    aple localaple = this.jdField_a_of_type_Aple;
    if (paramEIPCResult.code == 0) {}
    for (;;)
    {
      localaple.a(bool, paramEIPCResult.data);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkl
 * JD-Core Version:    0.7.0.1
 */