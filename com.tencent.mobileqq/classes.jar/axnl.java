import android.os.Bundle;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class axnl
  implements EIPCResultCallback
{
  axnl(axnj paramaxnj, axnm paramaxnm) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = (SoConfig.SoInfo)paramEIPCResult.data.getSerializable("res");
      if (this.jdField_a_of_type_Axnm != null) {
        this.jdField_a_of_type_Axnm.a(paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Axnm == null) {
      return;
    }
    this.jdField_a_of_type_Axnm.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnl
 * JD-Core Version:    0.7.0.1
 */