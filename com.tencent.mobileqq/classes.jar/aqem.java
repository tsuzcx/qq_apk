import android.os.Bundle;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aqem
  implements anui
{
  public aqem(ChooseImageIPCModule.1 param1, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putBoolean("sucess", paramBoolean);
    localBundle.putString("data", (String)paramObject);
    paramObject = EIPCResult.createResult(0, localBundle);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, new Object[] { "ArkMultiProc.callSendAppMsg success callback cmd=", this.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$1.this$0.callbackResult(this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$1.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqem
 * JD-Core Version:    0.7.0.1
 */