import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class atin
  implements akkl
{
  atin(atik paramatik, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    akkc localakkc = this.jdField_a_of_type_Atik.a();
    if ((localakkc == null) || (!TextUtils.equals(paramString, localakkc.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Atik.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Atik.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      atik.a(this.jdField_a_of_type_Atik, "onDownloadProgress", true);
      return;
    }
    QLog.w(atik.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      atik.a(this.jdField_a_of_type_Atik, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    atik.a(this.jdField_a_of_type_Atik, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     atin
 * JD-Core Version:    0.7.0.1
 */