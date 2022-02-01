import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class ayyf
  implements apcw
{
  ayyf(ayyc paramayyc, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    apcn localapcn = this.jdField_a_of_type_Ayyc.a();
    if ((localapcn == null) || (!TextUtils.equals(paramString, localapcn.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Ayyc.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Ayyc.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      ayyc.a(this.jdField_a_of_type_Ayyc, "onDownloadProgress", true);
      return;
    }
    QLog.w(ayyc.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      ayyc.a(this.jdField_a_of_type_Ayyc, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    ayyc.a(this.jdField_a_of_type_Ayyc, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyf
 * JD-Core Version:    0.7.0.1
 */