import android.os.Bundle;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class anmi
  extends bdvu
{
  public anmi(ChooseImageIPCModule.2 param2, String paramString) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambdvv.a) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", parambdvv.a);
    parambdvv = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.this$0.callbackResult(this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.a, parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmi
 * JD-Core Version:    0.7.0.1
 */