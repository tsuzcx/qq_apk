import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class azem
  implements apgi
{
  azem(azej paramazej, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    apfz localapfz = this.jdField_a_of_type_Azej.a();
    if ((localapfz == null) || (!TextUtils.equals(paramString, localapfz.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Azej.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Azej.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      azej.a(this.jdField_a_of_type_Azej, "onDownloadProgress", true);
      return;
    }
    QLog.w(azej.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      azej.a(this.jdField_a_of_type_Azej, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    azej.a(this.jdField_a_of_type_Azej, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azem
 * JD-Core Version:    0.7.0.1
 */