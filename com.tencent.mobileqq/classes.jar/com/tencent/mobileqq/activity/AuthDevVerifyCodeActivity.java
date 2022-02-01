package com.tencent.mobileqq.activity;

import Override;
import adxi;
import adxj;
import adxk;
import adxl;
import adxm;
import adxn;
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
import apdw;
import apdy;
import asvf;
import ayxn;
import bcvd;
import bdll;
import bhnv;
import bjbs;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, apdw
{
  public static long a;
  public static int b;
  protected int a;
  private adxm jdField_a_of_type_Adxm;
  private adxn jdField_a_of_type_Adxn;
  protected Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  apdy jdField_a_of_type_Apdy;
  ayxn jdField_a_of_type_Ayxn = new adxk(this);
  private bjbs jdField_a_of_type_Bjbs;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AuthDevVerifyCodeActivity.1(this);
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new adxl(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adxj(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new adxi(this);
  }
  
  private void a()
  {
    if (!bhnv.d(this))
    {
      QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
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
          bdll.b(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
          bcvd.b(this.app, (String)localObject1, this.jdField_a_of_type_Adxm);
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
          }
          if (this.jdField_a_of_type_Adxn == null) {
            this.jdField_a_of_type_Adxn = new adxn(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          }
          i = asvf.a().a(localAppInterface, this.jdField_a_of_type_Adxn, (String)localObject1);
          if (i == 0)
          {
            d();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + i);
          }
          a(2131715913, 1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
        }
        int i = asvf.a().a(localAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
        if (i == 0)
        {
          d();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + i);
        }
        a(2131715913, 1);
        return;
      }
      a(2131715842, 0);
      return;
    }
  }
  
  private void b()
  {
    if (!bhnv.d(this)) {
      QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
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
          bcvd.a(this.app, this.jdField_a_of_type_Adxm);
          return;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_Int != -1) {
          asvf.a().a(localAppInterface, this.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        if (this.jdField_a_of_type_Adxn == null) {
          this.jdField_a_of_type_Adxn = new adxn(this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        }
        i = asvf.a().a(localAppInterface, this.jdField_a_of_type_Adxn);
        if (i == 0)
        {
          a(2131715899);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      i = asvf.a().a(localAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        a(2131715899);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131715891) + "(" + jdField_b_of_type_Int + ")");
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      bdll.b(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
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
          bdll.b(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
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
    super.setContentView(2131561171);
    super.setTitle(2131715919);
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
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380287));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131372003));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364961));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131715914, new Object[] { this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363916));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131715891));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131694098));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131715891));
      }
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Adxm = new adxm(this.jdField_a_of_type_Ayxn);
      try
      {
        this.jdField_a_of_type_Apdy = new apdy(null);
        this.jdField_a_of_type_Apdy.a(this, this);
        l = System.currentTimeMillis() - jdField_a_of_type_Long;
        if (l >= 59000L)
        {
          jdField_b_of_type_Int = 1;
          if (jdField_b_of_type_Int > 1)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131715891) + "(" + jdField_b_of_type_Int + ")");
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
    if (this.jdField_a_of_type_Apdy != null) {}
    try
    {
      this.jdField_a_of_type_Apdy.a();
      this.jdField_a_of_type_Apdy = null;
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Adxn != null)
      {
        this.jdField_a_of_type_Adxn.a();
        this.jdField_a_of_type_Adxn = null;
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