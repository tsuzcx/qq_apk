import android.os.Bundle;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class axnn
  implements EIPCResultCallback
{
  axnn(axnl paramaxnl, axno paramaxno) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = (SoConfig.SoInfo)paramEIPCResult.data.getSerializable("res");
      if (this.jdField_a_of_type_Axno != null) {
        this.jdField_a_of_type_Axno.a(paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Axno == null) {
      return;
    }
    this.jdField_a_of_type_Axno.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnn
 * JD-Core Version:    0.7.0.1
 */