package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

public class SearchContactsActivity
  extends SearchBaseActivity
{
  private final MessageQueue.IdleHandler a;
  
  public SearchContactsActivity()
  {
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new SearchContactsActivity.ShowInputKeyboardHandler(this);
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("//gettbs")))
    {
      String str4 = WebAccelerateHelper.getInstance().getTBSDpcParam();
      String str2 = "";
      String str3 = "";
      String str1 = str3;
      paramString = str2;
      if (!TextUtils.isEmpty(str4))
      {
        str1 = str3;
        paramString = str2;
        if (str4.length() > 2)
        {
          paramString = String.valueOf(str4.charAt(0));
          str1 = String.valueOf(str4.charAt(2));
        }
      }
      paramString = String.format("tbs_download:%s\ntbs_enable:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d", new Object[] { paramString, str1, Integer.valueOf(QbSdk.getTbsVersion(this)), Integer.valueOf(WebView.getTbsSDKVersion(this)) });
      QQToast.a(getActivity().getApplicationContext(), paramString, 0).b(getTitleBarHeight());
    }
  }
  
  protected SearchBaseFragment a()
  {
    return SearchContactsFragment.a(this.i);
  }
  
  protected void c()
  {
    super.c();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    String str1 = getIntent().getStringExtra("start_search_key");
    boolean bool = TextUtils.isEmpty(str1);
    if (!bool)
    {
      if (this.i == 12)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131713567) + ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) + HardCodeUtil.a(2131713566));
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
    else
    {
      if (this.h == 1) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131713574));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new SearchContactsActivity.1(this, bool));
      String str2 = getResources().getString(2131690800);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SearchContactsActivity.2(this));
      if (AppSetting.d)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str2);
        if (this.i != 12) {
          break label274;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(HardCodeUtil.a(2131713576));
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) || (getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false))) {
        break label290;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131713573));
      break;
      label274:
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(HardCodeUtil.a(2131713572));
    }
    label290:
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public void finish()
  {
    super.finish();
    if (!TextUtils.isEmpty(getIntent().getStringExtra("start_search_key"))) {
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */