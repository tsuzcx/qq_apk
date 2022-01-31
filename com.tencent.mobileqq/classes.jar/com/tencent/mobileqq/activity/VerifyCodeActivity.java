package com.tencent.mobileqq.activity;

import aegl;
import aegm;
import aegn;
import aego;
import aegp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bcwc;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import mqq.manager.VerifyCodeManager;
import mqq.observer.ServerNotifyObserver;
import mqq.os.MqqHandler;

public class VerifyCodeActivity
  extends IphoneTitleBarActivity
{
  final int jdField_a_of_type_Int = 4;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aegp(this);
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public TextView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ClearableEditText a;
  VerifyCodeManager jdField_a_of_type_MqqManagerVerifyCodeManager;
  public ServerNotifyObserver a;
  public boolean a;
  private TextView b;
  public boolean b;
  
  public VerifyCodeActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverServerNotifyObserver = new aegl(this);
  }
  
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
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bcwc.a(arrayOfByte, 0, arrayOfByte.length));
          }
          this.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(i);
          this.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey((String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131368360));
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new aego(this));
          this.jdField_a_of_type_AndroidViewView = findViewById(2131380056);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375530));
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
    setTitle(2131721264);
    setLeftButton(2131690648, new aegm(this));
    setRightHighlightButton(2131692680, new aegn(this));
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    a(true);
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.refreVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    a(true);
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.submitVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.cancelVerifyCode(this.jdField_a_of_type_MqqObserverServerNotifyObserver);
    }
    finish();
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
    super.setContentView(2131562791);
    setContentBackgroundResource(2130838591);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379454));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371248));
    a(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(LoginActivity.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(20140107);
    }
    paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(SubLoginActivity.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(20140107);
    }
    paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(AddAccountActivity.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(20140107);
    }
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      b();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */