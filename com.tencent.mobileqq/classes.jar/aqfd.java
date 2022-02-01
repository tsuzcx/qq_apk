import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.qphone.base.util.QLog;

class aqfd
  extends biht
{
  aqfd(aqez paramaqez, String paramString, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    QLog.d("ArkApp.ArkMultiProcUtil", 1, String.format("download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambihu.a) }));
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onDownload(parambihu.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfd
 * JD-Core Version:    0.7.0.1
 */