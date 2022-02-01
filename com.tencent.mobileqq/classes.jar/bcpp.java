import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class bcpp
  extends bcpr
{
  bcpp(bcpn parambcpn, long paramLong, Map paramMap, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void a(boolean paramBoolean, bcps parambcps)
  {
    long l = parambcps.a();
    boolean bool = parambcps.a();
    String str1 = parambcps.a();
    String str2 = parambcps.b();
    int i = parambcps.a();
    if (l != this.jdField_a_of_type_Long) {
      QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not match");
    }
    do
    {
      return;
      parambcps = (bcpr)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (parambcps == null)
      {
        QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(parambcps);
      QLog.d("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo isSuccess: " + paramBoolean + " shouldDisplay: " + bool + " content: " + str1 + " barUrl: " + str2 + " nextAccessTime: " + i);
    } while (!paramBoolean);
    if (bool)
    {
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, "key_show_status", true);
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, "time_fetch_next_time", i * 1000L);
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, "bar_url", str2);
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, "bar_content_string", str1);
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      return;
    }
    this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, "key_verify_for_dlg_or_clk", false);
    this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, "key_show_status", false);
    this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpp
 * JD-Core Version:    0.7.0.1
 */