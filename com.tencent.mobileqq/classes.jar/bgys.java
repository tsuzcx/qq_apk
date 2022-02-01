import android.os.Bundle;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule.Params;
import eipc.EIPCResult;

public class bgys
  implements bgyq
{
  public bgys(QuickUpdateIPCModule paramQuickUpdateIPCModule, int paramInt) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QuickUpdateIPCModule.Params localParams = new QuickUpdateIPCModule.Params(null);
    localParams.intVal = paramInt;
    localParams.strVal1 = paramString1;
    localParams.strVal2 = paramString2;
    paramString1 = new Bundle();
    paramString1.putSerializable("params", localParams);
    paramString1 = EIPCResult.createResult(0, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqVasQuickUpdateIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgys
 * JD-Core Version:    0.7.0.1
 */