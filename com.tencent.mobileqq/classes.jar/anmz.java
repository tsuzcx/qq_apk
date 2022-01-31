import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.qphone.base.util.QLog;

class anmz
  extends bdvu
{
  anmz(anmv paramanmv, String paramString, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    QLog.d("ArkApp.ArkMultiProcUtil", 1, String.format("download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambdvv.a) }));
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onDownload(parambdvv.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmz
 * JD-Core Version:    0.7.0.1
 */