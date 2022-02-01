package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.VerifyCodeManager;
import mqq.observer.ServerNotifyObserver;

public class VerifyCodeActivity
  extends IphoneTitleBarActivity
{
  final int jdField_a_of_type_Int = 4;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new VerifyCodeActivity.5(this);
  private View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  VerifyCodeManager jdField_a_of_type_MqqManagerVerifyCodeManager;
  ServerNotifyObserver jdField_a_of_type_MqqObserverServerNotifyObserver = new VerifyCodeActivity.1(this);
  boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  
  private void a(Intent paramIntent)
  {
    Object localObject4 = null;
    c();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("image");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          i = paramIntent.getIntExtra("seq", 0);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject3;
            int i = 0;
            paramIntent = null;
            localObject2 = localObject1;
            localObject1 = localException2;
          }
        }
        try
        {
          localObject2 = paramIntent.getStringExtra("key");
        }
        catch (Exception localException3)
        {
          paramIntent = null;
          localObject2 = localObject1;
          localObject1 = localException3;
          break label210;
        }
        try
        {
          localObject3 = paramIntent.getStringExtra("note");
          paramIntent = (Intent)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          }
          localObject2 = paramIntent;
          if (paramIntent == null) {
            localObject2 = "";
          }
          if (arrayOfByte != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapManager.a(arrayOfByte, 0, arrayOfByte.length));
          }
          this.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(i);
          this.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey((String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131369170));
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new VerifyCodeActivity.4(this));
          this.jdField_a_of_type_AndroidViewView = findViewById(2131381793);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376846));
          this.jdField_a_of_type_MqqManagerVerifyCodeManager = ((VerifyCodeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(6));
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return;
        }
        catch (Exception localException4)
        {
          paramIntent = (Intent)localObject2;
          localObject2 = localObject1;
          localObject1 = localException4;
          break label210;
        }
        localException1 = localException1;
        i = 0;
        localObject2 = null;
        paramIntent = null;
      }
      label210:
      localObject3 = localObject4;
      localObject1 = localObject2;
    }
  }
  
  private void c()
  {
    setTitle(2131720473);
    setLeftButton(2131690800, new VerifyCodeActivity.2(this));
    setRightHighlightButton(2131692534, new VerifyCodeActivity.3(this));
  }
  
  void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    a(true);
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.refreVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
    }
  }
  
  void a(String paramString)
  {
    QLog.d("VerifyCodeActivity", 1, "sendVerifyCode");
    this.jdField_a_of_type_Boolean = true;
    a(true);
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.submitVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver, paramString);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.d("VerifyCodeActivity", 1, new Object[] { "showWaitting isShow=", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void b()
  {
    QLog.d("VerifyCodeActivity", 1, "cancelVerifyDialog");
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.cancelVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
    }
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      super.finish();
      return false;
    }
    super.setContentView(2131563194);
    setContentBackgroundResource(2130838979);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381140));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372396));
    a(paramBundle);
    LoginHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      b();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */