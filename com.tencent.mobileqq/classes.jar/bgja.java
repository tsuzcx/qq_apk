import android.content.Context;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.RspBody;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class bgja
  extends ayeu
{
  bgja(bgit parambgit, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void a(oidb_0xe96.RspBody paramRspBody)
  {
    bgit.a(this.jdField_a_of_type_Bgit, paramRspBody.str_change_mibao_url.get());
    bgit.a(this.jdField_a_of_type_Bgit, paramRspBody.uint32_next_access_time.get());
    bgit.b(this.jdField_a_of_type_Bgit, paramRspBody.str_tips_content.get());
    bgit.b(this.jdField_a_of_type_Bgit, paramRspBody.uint32_display_flag.get());
    bgit.c(this.jdField_a_of_type_Bgit, paramRspBody.str_hori_bar_content.get());
    bgit.d(this.jdField_a_of_type_Bgit, paramRspBody.str_tips_header.get());
    QLog.d("SecurePhoneBannerManager", 1, new Object[] { "getSecurePhoneState, displayTag : ", Integer.valueOf(bgit.a(this.jdField_a_of_type_Bgit)) });
    if (bgit.a(this.jdField_a_of_type_Bgit) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134069);
      bgit.a(this.jdField_a_of_type_Bgit, true);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C3", "0X800B0C3", 0, 0, "", "", "", "");
      bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 24, 0, "", "", "", "");
      return;
    }
    bgsg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, true, "sp_key_secure_phone_notice_time", Integer.valueOf(bgit.b(this.jdField_a_of_type_Bgit)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgja
 * JD-Core Version:    0.7.0.1
 */