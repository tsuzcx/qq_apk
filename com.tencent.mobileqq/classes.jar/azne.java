import android.os.Bundle;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class azne
  implements EIPCResultCallback
{
  azne(aznc paramaznc, aznf paramaznf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      localSoInfo = (SoConfig.SoInfo)paramEIPCResult.data.getSerializable("res");
      i = paramEIPCResult.data.getInt("code");
      if (this.jdField_a_of_type_Aznf != null) {
        this.jdField_a_of_type_Aznf.a(i, localSoInfo);
      }
    }
    while (this.jdField_a_of_type_Aznf == null)
    {
      SoConfig.SoInfo localSoInfo;
      int i;
      return;
    }
    this.jdField_a_of_type_Aznf.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azne
 * JD-Core Version:    0.7.0.1
 */