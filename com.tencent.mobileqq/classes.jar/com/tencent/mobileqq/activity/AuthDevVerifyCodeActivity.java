package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;
import rlh;
import rli;
import rlj;
import rlk;
import rll;
import rlm;
import rln;
import rlo;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static WeakReference a;
  public static int b;
  protected int a;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new rlh(this);
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new rlk(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new rlj(this);
  private rlo jdField_a_of_type_Rlo;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = 60;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public AuthDevVerifyCodeActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new rli(this);
  }
  
  private void a()
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
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
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      AppInterface localAppInterface = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      localObject2 = "";
      if (localAppInterface != null) {
        localObject2 = localAppInterface.getAccount();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
        }
        if (this.jdField_a_of_type_Rlo == null) {
          this.jdField_a_of_type_Rlo = new rlo(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        }
        i = EquipmentLockImpl.a().a(localAppInterface, this.jdField_a_of_type_Rlo, (String)localObject1);
        if (i == 0)
        {
          d();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + i);
        }
        a(2131434233, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
      }
      int i = EquipmentLockImpl.a().a(localAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        d();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + i);
      }
      a(2131434233, 1);
      return;
    }
    a(2131434258, 0);
  }
  
  private void b()
  {
    if (!NetworkUtil.d(this)) {
      QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      AppInterface localAppInterface;
      String str;
      do
      {
        return;
        localAppInterface = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        str = "";
        if (localAppInterface != null) {
          str = localAppInterface.getAccount();
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Int != -1) {
          EquipmentLockImpl.a().a(localAppInterface, this.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        if (this.jdField_a_of_type_Rlo == null) {
          this.jdField_a_of_type_Rlo = new rlo(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        }
        i = EquipmentLockImpl.a().a(localAppInterface, this.jdField_a_of_type_Rlo);
        if (i == 0)
        {
          a(2131434214);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      i = EquipmentLockImpl.a().a(localAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        a(2131434214);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434260) + "(" + jdField_b_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new rll(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new rlm(this));
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
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new rln(this, paramString1, paramString2));
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
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130970309);
    super.setTitle(2131434257);
    QQAppInterface localQQAppInterface = this.app;
    paramBundle = localQQAppInterface;
    if (localQQAppInterface == null) {
      paramBundle = (AppInterface)getAppRuntime();
    }
    if (paramBundle == null) {
      super.finish();
    }
    do
    {
      return;
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBundle);
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Boolean = paramBundle.getExtras().getBoolean("from_login");
      this.jdField_a_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
      this.jdField_b_of_type_JavaLangString = paramBundle.getExtras().getString("country_code");
      this.jdField_a_of_type_Int = paramBundle.getExtras().getInt("mobile_type", -1);
      this.c = paramBundle.getExtras().getInt("seq");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onCreate mIsFromLogin = " + this.jdField_b_of_type_Boolean + " mVerifySeq=" + this.c + " phoneNum=" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369992));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131365409));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131367686));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131434259, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369994));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434260));
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131432999));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131434260));
      }
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.c);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
      if (jdField_b_of_type_Int > 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      }
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidWidgetTextView);
    } while (jdField_b_of_type_Int > 1);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
    }
    jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Rlo != null)
    {
      this.jdField_a_of_type_Rlo.a();
      this.jdField_a_of_type_Rlo = null;
    }
    c();
    e();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */