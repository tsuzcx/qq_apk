package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

class RegisterActivity$13
  extends AccountObserver
{
  RegisterActivity$13(RegisterActivity paramRegisterActivity) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.c();
      QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910835), 1).show();
      return;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RegisterActivity onRegQueryAccountResp code = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(";strMsg = ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.d("RegisterActivity", 2, localStringBuilder.toString());
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramArrayOfByte = null;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            this.a.c();
            Object localObject = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              localObject = HardCodeUtil.a(2131910826);
            }
            QQToast.makeText(this.a.getApplicationContext(), (CharSequence)localObject, 1).show();
            return;
          }
          this.a.c();
          this.a.p.sendEmptyMessage(8);
          return;
        }
        this.a.c();
        this.a.p.sendEmptyMessage(8);
        return;
      }
      this.a.c();
      this.a.b("该手机号码已绑定其他QQ号码", HardCodeUtil.a(2131910840));
      return;
    }
    this.a.a();
  }
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (!paramBoolean)
    {
      QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910811), 1).show();
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910832), 1).show();
              return;
            }
            try
            {
              paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
              if (!TextUtils.isEmpty(paramArrayOfByte1))
              {
                this.a.p.post(new RegisterActivity.13.1(this, paramArrayOfByte1));
                return;
              }
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.d("IphoneTitleBarActivity", 2, "captcha url is empty");
              return;
            }
            catch (Throwable paramArrayOfByte1)
            {
              paramArrayOfByte1.printStackTrace();
              return;
            }
          }
          else
          {
            try
            {
              paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
            }
            catch (UnsupportedEncodingException paramArrayOfByte1)
            {
              paramArrayOfByte1.printStackTrace();
              paramArrayOfByte1 = null;
            }
            if (TextUtils.isEmpty(paramArrayOfByte1))
            {
              QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910829), 1).show();
              return;
            }
            this.a.b(paramArrayOfByte1);
          }
        }
        else
        {
          try
          {
            paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
          }
          catch (UnsupportedEncodingException paramArrayOfByte2)
          {
            paramArrayOfByte2.printStackTrace();
            paramArrayOfByte2 = null;
          }
          try
          {
            paramArrayOfByte1 = new String(paramArrayOfByte1, "utf-8");
          }
          catch (UnsupportedEncodingException paramArrayOfByte1)
          {
            paramArrayOfByte1.printStackTrace();
            paramArrayOfByte1 = null;
          }
          if ((!TextUtils.isEmpty(paramArrayOfByte2)) && (!TextUtils.isEmpty(paramArrayOfByte1)))
          {
            this.a.c(paramArrayOfByte2, paramArrayOfByte1);
            return;
          }
          QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910837), 1).show();
        }
      }
      else {
        this.a.p.sendEmptyMessage(1);
      }
    }
    else {
      this.a.p.sendEmptyMessage(1);
    }
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (this.a.isFinishing()) {
      return;
    }
    boolean bool = true;
    if (!paramBoolean)
    {
      this.a.c();
      QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910822), 1).show();
      return;
    }
    paramArrayOfByte2 = new StringBuilder();
    paramArrayOfByte2.append("RegisterActivity onRegisterCommitPassResp code = ");
    paramArrayOfByte2.append(paramInt);
    paramArrayOfByte2.append(";uin = ");
    paramArrayOfByte2.append(paramString);
    paramArrayOfByte2.append(";contactsig = ");
    if (paramArrayOfByte1 == null) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    paramArrayOfByte2.append(paramBoolean);
    QLog.d("RegisterActivity", 2, paramArrayOfByte2.toString());
  }
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.c();
      QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910828), 1).show();
      return;
    }
    if (paramInt == 0)
    {
      this.a.p.sendEmptyMessage(8);
    }
    else
    {
      this.a.c = HardCodeUtil.a(2131910815);
      this.a.p.sendEmptyMessage(5);
    }
    paramString1 = new StringBuilder();
    paramString1.append("RegisterActivity onRegisterCommitSmsCodeResp code = ");
    paramString1.append(paramInt);
    QLog.d("RegisterActivity", 2, paramString1.toString());
  }
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.a.isFinishing()) {
      return;
    }
    RegisterActivity.d(this.a);
    if (!paramBoolean)
    {
      RegisterActivity.e(this.a);
      QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910823), 1).show();
      return;
    }
    paramString1 = null;
    if (paramArrayOfByte != null) {}
    try
    {
      paramString1 = new String(paramArrayOfByte, "utf-8");
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("zsw RegisterActivity onRegisterQuerySmsStatResp code = ");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(";strMsg = ");
      paramArrayOfByte.append(paramString1);
      paramArrayOfByte.append(";next_chk_time =");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(";total_time_over =");
      paramArrayOfByte.append(paramInt3);
      QLog.d("RegisterActivity", 2, paramArrayOfByte.toString());
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    if (paramInt1 == 0)
    {
      RegisterActivity.e(this.a);
      this.a.p.sendEmptyMessage(8);
      return;
    }
    if (paramInt1 == 4)
    {
      int i = 60000;
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = 60000;
      }
      RegisterActivity.a(this.a, paramInt1 * 1000);
      if (paramInt3 <= 0) {
        paramInt3 = i;
      }
      try
      {
        this.a.p.postDelayed(new RegisterActivity.13.2(this), paramInt3 * 1000);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.makeText(this.a.getApplicationContext(), HardCodeUtil.a(2131910827), 1).show();
      return;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RegisterActivity onRegisterSendResendSmsreqResp code = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(";strMsg = ");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append(";next_chk_time =");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(";total_time_over =");
      localStringBuilder.append(paramInt3);
      QLog.d("RegisterActivity", 2, localStringBuilder.toString());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.13
 * JD-Core Version:    0.7.0.1
 */