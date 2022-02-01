import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqMaskQQLogin;

public class azvs
{
  private static volatile azvs jdField_a_of_type_Azvs;
  private azvy jdField_a_of_type_Azvy;
  
  public static azvs a()
  {
    if (jdField_a_of_type_Azvs == null) {}
    try
    {
      if (jdField_a_of_type_Azvs == null) {
        jdField_a_of_type_Azvs = new azvs();
      }
      return jdField_a_of_type_Azvs;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString, azvy paramazvy)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("RegisterLimitHelperImpl", 1, "jumpWithPhoneProtectUinsUrl error: params invalid");
      return;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "jumpWithPhoneProtectUinsUrl, phoneProtectUinsUrl: " + paramString);
    bcef.a(null, "dc00898", "", "", "0X800B336", "0X800B336", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Azvy = paramazvy;
    paramazvy = new Intent(paramContext, QQBrowserActivity.class);
    paramazvy.putExtra("url", paramString);
    paramContext.startActivity(paramazvy);
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_Azvy == null))
    {
      QLog.e("RegisterLimitHelperImpl", 1, "recoverIntentFromPhoneProtectReg error: params invalid");
      return;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "recoverIntentFromPhoneProtectReg");
    paramIntent.putExtra("phonenum", this.jdField_a_of_type_Azvy.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("invite_code", this.jdField_a_of_type_Azvy.jdField_d_of_type_JavaLangString);
    paramIntent.putExtra("key", this.jdField_a_of_type_Azvy.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("key_register_smscode", this.jdField_a_of_type_Azvy.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_Azvy.jdField_a_of_type_Boolean);
    paramIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_Azvy.jdField_b_of_type_Boolean);
    paramIntent.putExtra("key_register_from", this.jdField_a_of_type_Azvy.jdField_a_of_type_Int);
    paramIntent.putExtra("key_register_nick", this.jdField_a_of_type_Azvy.e);
    paramIntent.putExtra("key_register_password", this.jdField_a_of_type_Azvy.f);
    paramIntent.putExtra("key_register_phonenum_bindnewqq", this.jdField_a_of_type_Azvy.jdField_c_of_type_Boolean);
    paramIntent.putExtra("key_register_from_send_sms", this.jdField_a_of_type_Azvy.jdField_d_of_type_Boolean);
  }
  
  public boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d("RegisterLimitHelperImpl", 1, "shouldLoginWithMask: false");
      return false;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "shouldLoginWithMask: true， isNeedLoginFlagFromJsApi: true,  uinEditTextValue: " + paramString1);
    return true;
  }
  
  public byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RegisterLimitHelperImpl", 1, "createUinEncryptData error: uinEncrypt invalid");
      return null;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "createUinEncryptData");
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    localReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(blhj.a(paramString));
    localReqBody.msg_req_mask_qq_login.setHasFlag(true);
    localReqBody.setHasFlag(true);
    return localReqBody.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvs
 * JD-Core Version:    0.7.0.1
 */