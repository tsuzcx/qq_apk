import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class axru
  implements anzu
{
  axru(axrr paramaxrr, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    anzl localanzl = this.jdField_a_of_type_Axrr.a();
    if ((localanzl == null) || (!TextUtils.equals(paramString, localanzl.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Axrr.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Axrr.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      axrr.a(this.jdField_a_of_type_Axrr, "onDownloadProgress", true);
      return;
    }
    QLog.w(axrr.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      axrr.a(this.jdField_a_of_type_Axrr, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    axrr.a(this.jdField_a_of_type_Axrr, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axru
 * JD-Core Version:    0.7.0.1
 */