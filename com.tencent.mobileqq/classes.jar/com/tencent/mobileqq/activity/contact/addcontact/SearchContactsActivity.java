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
      String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
      boolean bool = TextUtils.isEmpty(str);
      paramString = "";
      if ((!bool) && (str.length() > 2))
      {
        paramString = String.valueOf(str.charAt(0));
        str = String.valueOf(str.charAt(2));
      }
      else
      {
        str = "";
      }
      paramString = String.format("tbs_download:%s\ntbs_enable:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d", new Object[] { paramString, str, Integer.valueOf(QbSdk.getTbsVersion(this)), Integer.valueOf(WebView.getTbsSDKVersion(this)) });
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
    String str = getIntent().getStringExtra("start_search_key");
    boolean bool = TextUtils.isEmpty(str);
    if (!bool)
    {
      if (this.i == 12)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131713534));
        localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
        localStringBuilder.append(HardCodeUtil.a(2131713533));
        ((EditText)localObject).setHint(localStringBuilder.toString());
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131713540));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if (this.h == 1) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131713541));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new SearchContactsActivity.1(this, bool));
    Object localObject = getResources().getString(2131690728);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SearchContactsActivity.2(this));
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject);
      if (this.i == 12) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(HardCodeUtil.a(2131713543));
      } else {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(HardCodeUtil.a(2131713539));
      }
    }
    if ((!TextUtils.isEmpty(str)) && (!getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false))) {
      return;
    }
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
  
  protected void doOnDestroy()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */