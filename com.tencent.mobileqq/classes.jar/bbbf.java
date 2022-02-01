import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqMaskQQLogin;

public class bbbf
{
  private static volatile bbbf jdField_a_of_type_Bbbf;
  private bbbl jdField_a_of_type_Bbbl;
  
  public static bbbf a()
  {
    if (jdField_a_of_type_Bbbf == null) {}
    try
    {
      if (jdField_a_of_type_Bbbf == null) {
        jdField_a_of_type_Bbbf = new bbbf();
      }
      return jdField_a_of_type_Bbbf;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString, bbbl parambbbl)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("RegisterLimitHelperImpl", 1, "jumpWithPhoneProtectUinsUrl error: params invalid");
      return;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "jumpWithPhoneProtectUinsUrl, phoneProtectUinsUrl: " + paramString);
    bdll.a(null, "dc00898", "", "", "0X800B336", "0X800B336", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Bbbl = parambbbl;
    parambbbl = new Intent(paramContext, QQBrowserActivity.class);
    parambbbl.putExtra("url", paramString);
    paramContext.startActivity(parambbbl);
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_Bbbl == null))
    {
      QLog.e("RegisterLimitHelperImpl", 1, "recoverIntentFromPhoneProtectReg error: params invalid");
      return;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "recoverIntentFromPhoneProtectReg");
    paramIntent.putExtra("phonenum", this.jdField_a_of_type_Bbbl.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("invite_code", this.jdField_a_of_type_Bbbl.jdField_d_of_type_JavaLangString);
    paramIntent.putExtra("key", this.jdField_a_of_type_Bbbl.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("key_register_smscode", this.jdField_a_of_type_Bbbl.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_Bbbl.jdField_a_of_type_Boolean);
    paramIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_Bbbl.jdField_b_of_type_Boolean);
    paramIntent.putExtra("key_register_from", this.jdField_a_of_type_Bbbl.jdField_a_of_type_Int);
    paramIntent.putExtra("key_register_nick", this.jdField_a_of_type_Bbbl.e);
    paramIntent.putExtra("key_register_password", this.jdField_a_of_type_Bbbl.f);
    paramIntent.putExtra("key_register_phonenum_bindnewqq", this.jdField_a_of_type_Bbbl.jdField_c_of_type_Boolean);
    paramIntent.putExtra("key_register_from_send_sms", this.jdField_a_of_type_Bbbl.jdField_d_of_type_Boolean);
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
    localReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(bocc.a(paramString));
    localReqBody.msg_req_mask_qq_login.setHasFlag(true);
    localReqBody.setHasFlag(true);
    return localReqBody.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbf
 * JD-Core Version:    0.7.0.1
 */