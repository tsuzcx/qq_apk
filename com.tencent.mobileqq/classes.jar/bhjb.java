import android.content.Context;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.RspBody;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class bhjb
  extends ayxn
{
  bhjb(bhiu parambhiu, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void a(oidb_0xe96.RspBody paramRspBody)
  {
    bhiu.a(this.jdField_a_of_type_Bhiu, paramRspBody.str_change_mibao_url.get());
    bhiu.a(this.jdField_a_of_type_Bhiu, paramRspBody.uint32_next_access_time.get());
    bhiu.b(this.jdField_a_of_type_Bhiu, paramRspBody.str_tips_content.get());
    bhiu.b(this.jdField_a_of_type_Bhiu, paramRspBody.uint32_display_flag.get());
    bhiu.c(this.jdField_a_of_type_Bhiu, paramRspBody.str_hori_bar_content.get());
    bhiu.d(this.jdField_a_of_type_Bhiu, paramRspBody.str_tips_header.get());
    QLog.d("SecurePhoneBannerManager", 1, new Object[] { "getSecurePhoneState, displayTag : ", Integer.valueOf(bhiu.a(this.jdField_a_of_type_Bhiu)) });
    if (bhiu.a(this.jdField_a_of_type_Bhiu) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134069);
      bhiu.a(this.jdField_a_of_type_Bhiu, true);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C3", "0X800B0C3", 0, 0, "", "", "", "");
      bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 24, 0, "", "", "", "");
      return;
    }
    bhsi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, true, "sp_key_secure_phone_notice_time", Integer.valueOf(bhiu.b(this.jdField_a_of_type_Bhiu)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjb
 * JD-Core Version:    0.7.0.1
 */