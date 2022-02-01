import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.qphone.base.util.QLog;

class aqbs
  extends bhyn
{
  aqbs(aqbo paramaqbo, String paramString, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    QLog.d("ArkApp.ArkMultiProcUtil", 1, String.format("download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambhyo.a) }));
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onDownload(parambhyo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbs
 * JD-Core Version:    0.7.0.1
 */