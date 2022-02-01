package com.tencent.mobileqq.activity;

import Override;
import adkq;
import adkr;
import adks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import aodi;
import aodj;
import bisl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AuthDevRenameActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public static String a;
  public static String b = "appname";
  public static String c = "appid";
  public static String d = "sub_appid";
  public static String e = "device_guid";
  public static String f = "target_name";
  public static String g = "target_type_info";
  public static String h = "target_desc";
  public static String i = "index";
  private Handler jdField_a_of_type_AndroidOsHandler = new adks(this);
  private aodj jdField_a_of_type_Aodj = new adkr(this);
  private bisl jdField_a_of_type_Bisl;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  
  static
  {
    jdField_a_of_type_JavaLangString = "uin";
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevRenameActivity.4(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevRenameActivity.5(this));
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
    super.setContentView(2131561095);
    super.addObserver(this.jdField_a_of_type_Aodj);
    super.setRightButton(2131691945, this);
    this.leftView.setText(2131690697);
    this.leftView.setOnClickListener(this);
    if ((this.centerView != null) && ((this.centerView instanceof TextView))) {
      this.centerView.setVisibility(8);
    }
    paramBundle = super.getIntent();
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getStringExtra(f);
      paramBundle = paramBundle.getStringExtra(g);
    }
    for (;;)
    {
      Object localObject = super.findViewById(2131379056);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131379098);
        if (localTextView != null) {
          localTextView.setText(2131691992);
        }
        localObject = (TextView)((View)localObject).findViewById(2131379031);
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((TextView)localObject).setText(paramBundle);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131363077));
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(str);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setImeOptions(6);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnEditorActionListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setImeActionLabel(getString(2131693719), 6);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFilters(new InputFilter[] { new adkq(this) });
        return true;
        super.setTitle(2131691992);
      }
      paramBundle = null;
      str = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
      }
      else
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getEditableText().toString();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QQToast.a(this, getString(2131691961), 0).b(getTitleBarHeight());
        }
        else
        {
          Object localObject2 = super.getIntent();
          if (localObject2 == null) {
            break;
          }
          String str = ((Intent)localObject2).getStringExtra(f);
          if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, (CharSequence)localObject1))) {
            break;
          }
          localObject2 = ((Intent)localObject2).getExtras();
          ((Bundle)localObject2).putString(f, (String)localObject1);
          ((Bundle)localObject2).putString(jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin());
          localObject1 = (aodi)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
          if (localObject1 == null) {
            break;
          }
          a();
          ((aodi)localObject1).a((Bundle)localObject2);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    b();
    super.onDestroy();
    super.removeObserver(this.jdField_a_of_type_Aodj);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      onClick(this.rightViewText);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity
 * JD-Core Version:    0.7.0.1
 */