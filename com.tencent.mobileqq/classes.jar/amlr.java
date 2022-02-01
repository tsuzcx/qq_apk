import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloResManager.ApolloDressInfo;
import eipc.EIPCResult;

class amlr
  implements amof
{
  amlr(amlo paramamlo, Bundle paramBundle, int paramInt) {}
  
  public void a(ApolloResManager.ApolloDressInfo paramApolloDressInfo, String paramString, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramApolloDressInfo == null) {}
    for (;;)
    {
      localEIPCResult.code = paramInt;
      localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
      localEIPCResult.data.putParcelable("apolloUserDressInfo", paramApolloDressInfo);
      localEIPCResult.data.putString("apolloErrMsg", paramString);
      this.jdField_a_of_type_Amlo.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */