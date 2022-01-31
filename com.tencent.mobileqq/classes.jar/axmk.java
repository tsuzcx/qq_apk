import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.observer.WtloginObserver;

class axmk
  extends WtloginObserver
{
  axmk(axmj paramaxmj) {}
  
  public void OnRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(axmj.jdField_a_of_type_JavaLangString, 2, "OnRegGetSMSVerifyLoginAccount ret=" + paramInt + " uin=" + paramLong);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    if (paramArrayOfByte3 != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
        QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = Integer.toString(paramInt);
        if (paramArrayOfByte1 != null) {
          break label208;
        }
        paramArrayOfByte3 = "";
        azqs.a(localQQAppInterface, "new_reg", "setting_page_no", "result", "", 1, "", str, "", paramArrayOfByte3, "", "", "", "", "");
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
        if (paramInt != 0) {
          break label469;
        }
        axmj.a(this.a, Long.valueOf(paramLong).toString());
        axmj.a(this.a, paramArrayOfByte2);
        if (!TextUtils.isEmpty(axmj.a(this.a))) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
      continue;
      label208:
      paramArrayOfByte3 = paramArrayOfByte1;
    }
    if ((axmj.a(this.a) == null) || (axmj.a(this.a).length == 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(axmj.jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccount ret: %s, uin: %s, sign: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), MD5.toMD5(axmj.a(this.a)) }));
    }
    paramArrayOfByte1 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
    paramArrayOfByte1.putExtra("phonenum", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString);
    paramArrayOfByte1.putExtra("invite_code", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c);
    paramArrayOfByte1.putExtra("key", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString);
    paramArrayOfByte1.putExtra("key_register_is_phone_num_registered", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_Boolean);
    paramArrayOfByte1.putExtra("uin", axmj.a(this.a));
    paramArrayOfByte1.putExtra("key_register_sign", axmj.a(this.a));
    paramArrayOfByte1.putExtra("key_register_from_send_sms", axmj.a(this.a));
    paramArrayOfByte1.putExtra("key_register_chose_bind_phone", true);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(paramArrayOfByte1);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
    return;
    label469:
    if (TextUtils.isEmpty(paramArrayOfByte1))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(paramArrayOfByte1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axmk
 * JD-Core Version:    0.7.0.1
 */