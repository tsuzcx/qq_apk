import android.os.Bundle;
import com.tencent.widget.soload.config.SoConfig.SoInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class besn
  implements EIPCResultCallback
{
  besn(besl parambesl, beso parambeso) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = (SoConfig.SoInfo)paramEIPCResult.data.getSerializable("res");
      if (this.jdField_a_of_type_Beso != null) {
        this.jdField_a_of_type_Beso.a(paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_Beso == null) {
      return;
    }
    this.jdField_a_of_type_Beso.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besn
 * JD-Core Version:    0.7.0.1
 */