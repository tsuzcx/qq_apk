import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aonx
  implements EIPCResultCallback
{
  aonx(aonw paramaonw, String paramString) {}
  
  private void a(EIPCResult paramEIPCResult)
  {
    switch (paramEIPCResult.code)
    {
    default: 
      aonw.a(this.jdField_a_of_type_Aonw).a();
      return;
    }
    aonw.a(this.jdField_a_of_type_Aonw).a(this.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a(EIPCResult paramEIPCResult)
  {
    return (paramEIPCResult == null) || (paramEIPCResult.data == null) || (aonw.a(this.jdField_a_of_type_Aonw) == null);
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (a(paramEIPCResult))
    {
      QLog.e("ThirdPartyLoginUtilImpl", 1, "toWtLoginOnOpenSdk callback params error");
      return;
    }
    QLog.d("ThirdPartyLoginUtilImpl", 1, "code=" + paramEIPCResult.code + " ssoResult=" + paramEIPCResult.data.getInt("key_sso_ret"));
    a(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonx
 * JD-Core Version:    0.7.0.1
 */