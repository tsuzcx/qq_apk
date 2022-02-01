import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class aylt
  implements aoss
{
  aylt(aylq paramaylq, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    aosj localaosj = this.jdField_a_of_type_Aylq.a();
    if ((localaosj == null) || (!TextUtils.equals(paramString, localaosj.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Aylq.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Aylq.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      aylq.a(this.jdField_a_of_type_Aylq, "onDownloadProgress", true);
      return;
    }
    QLog.w(aylq.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      aylq.a(this.jdField_a_of_type_Aylq, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    aylq.a(this.jdField_a_of_type_Aylq, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylt
 * JD-Core Version:    0.7.0.1
 */