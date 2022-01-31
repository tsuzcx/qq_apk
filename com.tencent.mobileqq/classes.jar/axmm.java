import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

class axmm
  extends AccountObserver
{
  axmm(axml paramaxml) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterWithNickAndPwd", 2, "onGetQuickRegisterAccount code = " + paramInt + ";uin = " + paramString1 + ";phoneNum=" + paramString2 + ";mIsfromLH=" + this.a.d);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
    if (!paramBoolean) {
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        paramString2 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131717527);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(paramString2, 1);
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          paramString1 = null;
        }
      }
    }
    if (paramInt == 0)
    {
      axml.a(this.a, paramString1);
      axml.b(this.a, paramString2);
      if ((TextUtils.isEmpty(axml.a(this.a))) || (TextUtils.isEmpty(axml.b(this.a))))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
        return;
      }
      paramString1 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterQQNumberActivity.class);
      paramString1.putExtra("key_register_secret_phone", paramString2);
      paramString1.putExtra("uin", axml.a(this.a));
      paramString1.putExtra("key_register_password", axml.c(this.a));
      paramString1.putExtra("key_register_unbind", true);
      paramString1.putExtra("key_register_from_quick_register", this.a.jdField_a_of_type_Boolean);
      paramString1.putExtra("key_register_is_phone_num_registered", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.b);
      paramString1.putExtra("key_register_has_pwd", this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c);
      paramString1.putExtra("key_register_from_send_sms", this.a.b);
      paramString1.putExtra("key_register_chose_bind_phone", false);
      if ((this.a.c) && (!this.a.d))
      {
        axml.a(this.a, paramString1, false);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(paramString1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterWithNickAndPwd", 2, "RegisterByNicknameAndPwdActivity onRegisterCommitPassResp ");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.isFinishing()) {
      return;
    }
    try
    {
      paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
      QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramBoolean)
      {
        str = Integer.toString(paramInt);
        if (paramArrayOfByte2 != null) {
          break label172;
        }
        localObject = "";
        azqs.a(localQQAppInterface, "new_reg", "setting_page_yes", "result", "", 1, "", str, "", (String)localObject, "", "", "", "", "");
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
        if (paramBoolean) {
          break label179;
        }
        paramString = paramArrayOfByte2;
        if (TextUtils.isEmpty(paramArrayOfByte2)) {
          paramString = this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getString(2131717527);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(paramString, 1);
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte2)
    {
      for (;;)
      {
        paramArrayOfByte2.printStackTrace();
        paramArrayOfByte2 = null;
        continue;
        String str = "-1001";
        continue;
        label172:
        Object localObject = paramArrayOfByte2;
      }
      label179:
      if (QLog.isColorLevel())
      {
        paramArrayOfByte2 = new StringBuilder().append("RegisterByNicknameAndPwdActivity onRegisterCommitPassResp code = ").append(paramInt).append(";uin = ").append(paramString).append(";contactsig = ");
        if (paramArrayOfByte1 != null) {
          break label289;
        }
      }
      label289:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("RegisterWithNickAndPwd", 2, paramBoolean);
        if (paramInt != 0) {
          break label337;
        }
        axml.a(this.a, paramString);
        axml.a(this.a, paramArrayOfByte1);
        if (!TextUtils.isEmpty(axml.a(this.a))) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
        return;
      }
      if ((axml.a(this.a) == null) || (axml.a(this.a).length == 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
        return;
      }
      this.a.e();
      return;
      label337:
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717527, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axmm
 * JD-Core Version:    0.7.0.1
 */