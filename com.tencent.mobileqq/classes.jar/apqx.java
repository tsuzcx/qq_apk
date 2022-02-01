import android.os.Bundle;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class apqx
  extends bhhe
{
  public apqx(ChooseImageIPCModule.2 param2, String paramString) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambhhf.a) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", parambhhf.a);
    parambhhf = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.this$0.callbackResult(this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.a, parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqx
 * JD-Core Version:    0.7.0.1
 */