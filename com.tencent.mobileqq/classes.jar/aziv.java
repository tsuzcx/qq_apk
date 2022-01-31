import android.os.Bundle;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aziv
  implements EIPCResultCallback
{
  aziv(azit paramazit, aziw paramaziw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      localSoInfo = (SoConfig.SoInfo)paramEIPCResult.data.getSerializable("res");
      i = paramEIPCResult.data.getInt("code");
      if (this.jdField_a_of_type_Aziw != null) {
        this.jdField_a_of_type_Aziw.a(i, localSoInfo);
      }
    }
    while (this.jdField_a_of_type_Aziw == null)
    {
      SoConfig.SoInfo localSoInfo;
      int i;
      return;
    }
    this.jdField_a_of_type_Aziw.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziv
 * JD-Core Version:    0.7.0.1
 */