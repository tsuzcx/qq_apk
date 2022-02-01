import android.content.Context;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.RspBody;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class bfsl
  extends axkv
{
  bfsl(bfse parambfse, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void getSecurePhoneSuccess(oidb_0xe96.RspBody paramRspBody)
  {
    bfse.a(this.jdField_a_of_type_Bfse, paramRspBody.str_change_mibao_url.get());
    bfse.a(this.jdField_a_of_type_Bfse, paramRspBody.uint32_next_access_time.get());
    bfse.b(this.jdField_a_of_type_Bfse, paramRspBody.str_tips_content.get());
    bfse.b(this.jdField_a_of_type_Bfse, paramRspBody.uint32_display_flag.get());
    bfse.c(this.jdField_a_of_type_Bfse, paramRspBody.str_hori_bar_content.get());
    bfse.d(this.jdField_a_of_type_Bfse, paramRspBody.str_tips_header.get());
    QLog.d("SecurePhoneBannerManager", 1, new Object[] { "getSecurePhoneState, displayTag : ", Integer.valueOf(bfse.a(this.jdField_a_of_type_Bfse)) });
    if (bfse.a(this.jdField_a_of_type_Bfse) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134069);
      bfse.a(this.jdField_a_of_type_Bfse, true);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C3", "0X800B0C3", 0, 0, "", "", "", "");
      bcef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 24, 0, "", "", "", "");
      return;
    }
    bfyz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, true, "sp_key_secure_phone_notice_time", Integer.valueOf(bfse.b(this.jdField_a_of_type_Bfse)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsl
 * JD-Core Version:    0.7.0.1
 */