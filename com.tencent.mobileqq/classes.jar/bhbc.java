import android.content.Context;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.RspBody;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class bhbc
  extends ayra
{
  bhbc(bhav parambhav, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void getSecurePhoneSuccess(oidb_0xe96.RspBody paramRspBody)
  {
    bhav.a(this.jdField_a_of_type_Bhav, paramRspBody.str_change_mibao_url.get());
    bhav.a(this.jdField_a_of_type_Bhav, paramRspBody.uint32_next_access_time.get());
    bhav.b(this.jdField_a_of_type_Bhav, paramRspBody.str_tips_content.get());
    bhav.b(this.jdField_a_of_type_Bhav, paramRspBody.uint32_display_flag.get());
    bhav.c(this.jdField_a_of_type_Bhav, paramRspBody.str_hori_bar_content.get());
    bhav.d(this.jdField_a_of_type_Bhav, paramRspBody.str_tips_header.get());
    QLog.d("SecurePhoneBannerManager", 1, new Object[] { "getSecurePhoneState, displayTag : ", Integer.valueOf(bhav.a(this.jdField_a_of_type_Bhav)) });
    if (bhav.a(this.jdField_a_of_type_Bhav) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134069);
      bhav.a(this.jdField_a_of_type_Bhav, true);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C3", "0X800B0C3", 0, 0, "", "", "", "");
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 24, 0, "", "", "", "");
      return;
    }
    bhhr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, true, "sp_key_secure_phone_notice_time", Integer.valueOf(bhav.b(this.jdField_a_of_type_Bhav)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbc
 * JD-Core Version:    0.7.0.1
 */