import android.os.Bundle;
import eipc.EIPCResult;

class amlp
  implements amoe
{
  amlp(amlo paramamlo, Bundle paramBundle, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramString1 == null) {}
    for (;;)
    {
      localEIPCResult.code = paramInt;
      localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
      localEIPCResult.data.putString("apolloRoleDir", paramString1);
      localEIPCResult.data.putString("apolloErrMsg", paramString2);
      this.jdField_a_of_type_Amlo.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlp
 * JD-Core Version:    0.7.0.1
 */