import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class awcb
  implements amub
{
  awcb(awby paramawby, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    amts localamts = this.jdField_a_of_type_Awby.a();
    if ((localamts == null) || (!TextUtils.equals(paramString, localamts.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramInt1 < this.jdField_a_of_type_Awby.jdField_a_of_type_ArrayOfInt.length) {
      this.jdField_a_of_type_Awby.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      awby.a(this.jdField_a_of_type_Awby, "onDownloadProgress", true);
      return;
    }
    QLog.w(awby.jdField_a_of_type_JavaLangString, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      awby.a(this.jdField_a_of_type_Awby, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    awby.a(this.jdField_a_of_type_Awby, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awcb
 * JD-Core Version:    0.7.0.1
 */