import android.os.Bundle;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aoxy
  extends bgod
{
  public aoxy(ChooseImageIPCModule.2 param2, String paramString) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambgoe.a) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", parambgoe.a);
    parambgoe = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.this$0.callbackResult(this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.a, parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxy
 * JD-Core Version:    0.7.0.1
 */