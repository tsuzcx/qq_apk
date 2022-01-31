package com.tencent.mobileqq.activity.contact.addcontact;

import ahie;
import ahif;
import ahig;
import alud;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import swy;

public class SearchContactsActivity
  extends SearchBaseActivity
{
  private final MessageQueue.IdleHandler a;
  
  public SearchContactsActivity()
  {
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new ahig(this);
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
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alud.a(2131714004) + swy.a(this.app, getApplicationContext()) + alud.a(2131714003));
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
    else
    {
      if (this.h == 1) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alud.a(2131714011));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ahie(this, bool));
      String str2 = getResources().getString(2131690648);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str2);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahif(this));
      if (AppSetting.c)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str2);
        if (this.i != 12) {
          break label263;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(alud.a(2131714013));
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) || (getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false))) {
        break label278;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(alud.a(2131714010));
      break;
      label263:
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(alud.a(2131714009));
    }
    label278:
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */