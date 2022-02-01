package com.tencent.mobileqq.activity;

import Override;
import adku;
import adkv;
import adkw;
import adkx;
import adky;
import adkz;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import apak;
import apam;
import asll;
import ayra;
import bcvh;
import bdla;
import bisl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, apak
{
  public static long a;
  public static int b;
  protected int a;
  private adky jdField_a_of_type_Adky;
  private adkz jdField_a_of_type_Adkz;
  protected Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  apam jdField_a_of_type_Apam;
  ayra jdField_a_of_type_Ayra = new adkw(this);
  private bisl jdField_a_of_type_Bisl;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AuthDevVerifyCodeActivity.1(this);
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new adkx(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adkv(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new adku(this);
  }
  
  private void a()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
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
          bdla.b(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
          bcvh.b(this.app, (String)localObject1, this.jdField_a_of_type_Adky);
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
          }
          if (this.jdField_a_of_type_Adkz == null) {
            this.jdField_a_of_type_Adkz = new adkz(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          }
          i = asll.a().a(localAppInterface, this.jdField_a_of_type_Adkz, (String)localObject1);
          if (i == 0)
          {
            d();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + i);
          }
          a(2131716503, 1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
        }
        int i = asll.a().a(localAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
        if (i == 0)
        {
          d();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + i);
        }
        a(2131716503, 1);
        return;
      }
      a(2131716424, 0);
      return;
    }
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(this)) {
      QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
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
          bcvh.a(this.app, this.jdField_a_of_type_Adky);
          return;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Int != -1) {
          asll.a().a(localAppInterface, this.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        if (this.jdField_a_of_type_Adkz == null) {
          this.jdField_a_of_type_Adkz = new adkz(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        }
        i = asll.a().a(localAppInterface, this.jdField_a_of_type_Adkz);
        if (i == 0)
        {
          a(2131716489);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      i = asll.a().a(localAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        a(2131716489);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716478) + "(" + jdField_b_of_type_Int + ")");
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
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
      bdla.b(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      if (jdField_b_of_type_Int <= 1)
      {
        if ("f_SetFaceData".equals(this.jdField_c_of_type_JavaLangString)) {
          bdla.b(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
        }
        b();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561105);
    super.setTitle(2131716509);
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
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380349));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131372159));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365072));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131716504, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364016));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716478));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131694399));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716478));
      }
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Adky = new adky(this.jdField_a_of_type_Ayra);
      try
      {
        this.jdField_a_of_type_Apam = new apam(null);
        this.jdField_a_of_type_Apam.a(this, this);
        l = System.currentTimeMillis() - jdField_a_of_type_Long;
        if (l >= 59000L)
        {
          jdField_b_of_type_Int = 1;
          if (jdField_b_of_type_Int > 1)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716478) + "(" + jdField_b_of_type_Int + ")");
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
    if (this.jdField_a_of_type_Apam != null) {}
    try
    {
      this.jdField_a_of_type_Apam.a();
      this.jdField_a_of_type_Apam = null;
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Adkz != null)
      {
        this.jdField_a_of_type_Adkz.a();
        this.jdField_a_of_type_Adkz = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */