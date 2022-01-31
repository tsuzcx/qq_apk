package com.tencent.mobileqq.activity;

import aall;
import aalm;
import aaln;
import aalo;
import aalp;
import aalq;
import akwl;
import akwn;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aoen;
import atzn;
import axby;
import axqw;
import bbev;
import bcpq;
import bcpw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements akwl, TextWatcher, View.OnClickListener
{
  public static long a;
  public static int b;
  protected int a;
  private aalp jdField_a_of_type_Aalp;
  private aalq jdField_a_of_type_Aalq;
  akwn jdField_a_of_type_Akwn;
  protected Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  atzn jdField_a_of_type_Atzn = new aaln(this);
  private bcpq jdField_a_of_type_Bcpq;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AuthDevVerifyCodeActivity.1(this);
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new aalo(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aalm(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d = 60;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public AuthDevVerifyCodeActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new aall(this);
  }
  
  private void a()
  {
    if (!bbev.d(this))
    {
      bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
      return;
    }
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject2 = "";
        if (localAppInterface != null) {
          localObject2 = localAppInterface.getAccount();
        }
        if ("f_SetFaceData".equals(this.jdField_c_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "set face data commitSmsCode.begin to check smsCode=" + (String)localObject1);
          }
          axqw.b(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
          axby.b(this.app, (String)localObject1, this.jdField_a_of_type_Aalp);
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
          }
          if (this.jdField_a_of_type_Aalq == null) {
            this.jdField_a_of_type_Aalq = new aalq(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          }
          i = aoen.a().a(localAppInterface, this.jdField_a_of_type_Aalq, (String)localObject1);
          if (i == 0)
          {
            d();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + i);
          }
          a(2131717180, 1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
        }
        int i = aoen.a().a(localAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
        if (i == 0)
        {
          d();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + i);
        }
        a(2131717180, 1);
        return;
      }
      a(2131717081, 0);
      return;
    }
  }
  
  private void b()
  {
    if (!bbev.d(this)) {
      bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      AppInterface localAppInterface;
      String str;
      do
      {
        return;
        localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        str = "";
        if (localAppInterface != null) {
          str = localAppInterface.getAccount();
        }
        if ("f_SetFaceData".equals(this.jdField_c_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "Set Face Data startGetVerifyCode.begin");
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          axby.b(this.app, this.jdField_a_of_type_Aalp);
          return;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Int != -1) {
          aoen.a().a(localAppInterface, this.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        if (this.jdField_a_of_type_Aalq == null) {
          this.jdField_a_of_type_Aalq = new aalq(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        }
        i = aoen.a().a(localAppInterface, this.jdField_a_of_type_Aalq);
        if (i == 0)
        {
          a(2131717161);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      i = aoen.a().a(localAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        a(2131717161);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.AskDevLockSms failed ret=" + i);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717149) + "(" + jdField_b_of_type_Int + ")");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevVerifyCodeActivity.6(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevVerifyCodeActivity.7(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 21)
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 1, "onActivity requestCode == AuthDevActivity.REQ_LEGACY, resultCode is : " + paramInt2);
      if (paramInt2 == -1)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ("f_SetFaceData".equals(this.jdField_c_of_type_JavaLangString)) {
      axqw.b(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new AuthDevVerifyCodeActivity.8(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a();
      return;
    } while (jdField_b_of_type_Int > 1);
    if ("f_SetFaceData".equals(this.jdField_c_of_type_JavaLangString)) {
      axqw.b(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
    }
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560735);
    super.setTitle(2131717190);
    QQAppInterface localQQAppInterface = this.app;
    paramBundle = localQQAppInterface;
    if (localQQAppInterface == null) {
      paramBundle = (AppInterface)getAppRuntime();
    }
    if (paramBundle == null) {
      super.finish();
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBundle);
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Boolean = paramBundle.getExtras().getBoolean("from_login");
      this.jdField_a_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
      this.jdField_b_of_type_JavaLangString = paramBundle.getExtras().getString("country_code");
      this.jdField_a_of_type_Int = paramBundle.getExtras().getInt("mobile_type", -1);
      this.jdField_c_of_type_Int = paramBundle.getExtras().getInt("seq");
      this.jdField_c_of_type_JavaLangString = paramBundle.getExtras().getString("k_from");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onCreate mIsFromLogin = " + this.jdField_b_of_type_Boolean + " mVerifySeq=" + this.jdField_c_of_type_Int + " phoneNum=" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378503));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131370993));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364616));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131717181, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363635));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717149));
      if (AppSetting.d)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131694793));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717149));
      }
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Aalp = new aalp(this.jdField_a_of_type_Atzn);
      try
      {
        this.jdField_a_of_type_Akwn = new akwn(null);
        this.jdField_a_of_type_Akwn.a(this, this);
        l = System.currentTimeMillis() - jdField_a_of_type_Long;
        if (l >= 59000L)
        {
          jdField_b_of_type_Int = 1;
          if (jdField_b_of_type_Int > 1)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717149) + "(" + jdField_b_of_type_Int + ")");
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
          }
          if (jdField_b_of_type_Int > 1) {
            continue;
          }
          if (!"f_SetFaceData".equals(this.jdField_c_of_type_JavaLangString)) {
            break label566;
          }
          b(60);
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          long l;
          paramBundle.printStackTrace();
          continue;
          jdField_b_of_type_Int = (int)((60000L - l) / 1000L);
        }
        label566:
        b();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Akwn != null) {}
    try
    {
      this.jdField_a_of_type_Akwn.a();
      this.jdField_a_of_type_Akwn = null;
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Aalq != null)
      {
        this.jdField_a_of_type_Aalq.a();
        this.jdField_a_of_type_Aalq = null;
      }
      c();
      e();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */