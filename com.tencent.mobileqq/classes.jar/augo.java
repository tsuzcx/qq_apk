import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class augo
  implements akyw
{
  augo(augl paramaugl, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    akyn localakyn = this.jdField_a_of_type_Augl.a();
    if ((localakyn == null) || (!TextUtils.equals(paramString, localakyn.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Augl.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Augl.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      augl.a(this.jdField_a_of_type_Augl, "onDownloadProgress", true);
      return;
    }
    QLog.w(augl.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      augl.a(this.jdField_a_of_type_Augl, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    augl.a(this.jdField_a_of_type_Augl, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     augo
 * JD-Core Version:    0.7.0.1
 */