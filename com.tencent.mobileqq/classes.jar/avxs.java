import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class avxs
  implements ampm
{
  avxs(avxp paramavxp, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ampd localampd = this.jdField_a_of_type_Avxp.a();
    if ((localampd == null) || (!TextUtils.equals(paramString, localampd.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Avxp.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Avxp.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      avxp.a(this.jdField_a_of_type_Avxp, "onDownloadProgress", true);
      return;
    }
    QLog.w(avxp.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      avxp.a(this.jdField_a_of_type_Avxp, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    avxp.a(this.jdField_a_of_type_Avxp, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxs
 * JD-Core Version:    0.7.0.1
 */