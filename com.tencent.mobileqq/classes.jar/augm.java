import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class augm
  implements akyx
{
  augm(augj paramaugj, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    akyo localakyo = this.jdField_a_of_type_Augj.a();
    if ((localakyo == null) || (!TextUtils.equals(paramString, localakyo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Augj.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Augj.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      augj.a(this.jdField_a_of_type_Augj, "onDownloadProgress", true);
      return;
    }
    QLog.w(augj.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      augj.a(this.jdField_a_of_type_Augj, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    augj.a(this.jdField_a_of_type_Augj, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     augm
 * JD-Core Version:    0.7.0.1
 */