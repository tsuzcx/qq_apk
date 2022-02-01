import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class bfxi
  extends andd
{
  bfxi(String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    QLog.w("QAVGroupConfig", 1, "onGetTroopInfoResult[" + this.b + "], troopuin[" + this.jdField_a_of_type_JavaLangString + "], isSuc[" + paramBoolean + "]");
    if (paramBoolean) {
      bfxk.a(this.b + ".onGetTroopInfoResult", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxi
 * JD-Core Version:    0.7.0.1
 */