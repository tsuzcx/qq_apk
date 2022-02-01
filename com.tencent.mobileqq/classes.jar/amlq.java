import android.os.Bundle;
import eipc.EIPCResult;
import java.util.HashMap;

class amlq
  implements amod
{
  amlq(amlo paramamlo, Bundle paramBundle, int paramInt) {}
  
  public void onGetApolloDressInfo(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramHashMap == null) {}
    for (;;)
    {
      localEIPCResult.code = paramInt;
      localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
      localEIPCResult.data.putSerializable("apolloDressInfo", paramHashMap);
      localEIPCResult.data.putString("apolloErrMsg", paramString);
      this.jdField_a_of_type_Amlo.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlq
 * JD-Core Version:    0.7.0.1
 */