import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aojz
  implements EIPCResultCallback
{
  aojz(aojy paramaojy, String paramString) {}
  
  private void a(EIPCResult paramEIPCResult)
  {
    switch (paramEIPCResult.code)
    {
    default: 
      aojy.a(this.jdField_a_of_type_Aojy).a();
      return;
    }
    aojy.a(this.jdField_a_of_type_Aojy).a(this.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a(EIPCResult paramEIPCResult)
  {
    return (paramEIPCResult == null) || (paramEIPCResult.data == null) || (aojy.a(this.jdField_a_of_type_Aojy) == null);
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
 * Qualified Name:     aojz
 * JD-Core Version:    0.7.0.1
 */