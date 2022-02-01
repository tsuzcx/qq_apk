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
  private final MessageQueue.IdleHandler a = new SearchContactsActivity.ShowInputKeyboardHandler(this);
  
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
      QQToast.makeText(getActivity().getApplicationContext(), paramString, 0).show(getTitleBarHeight());
    }
  }
  
  protected void c()
  {
    super.c();
    this.L.setVisibility(8);
    String str = getIntent().getStringExtra("start_search_key");
    boolean bool = TextUtils.isEmpty(str);
    if (!bool)
    {
      if (this.H == 12)
      {
        localObject = this.K;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131911080));
        localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
        localStringBuilder.append(HardCodeUtil.a(2131911079));
        ((EditText)localObject).setHint(localStringBuilder.toString());
      }
      else
      {
        this.K.setHint(HardCodeUtil.a(2131911086));
      }
      this.K.setText(str);
      this.K.setSelection(this.K.getText().length());
      this.J.setVisibility(0);
    }
    if (this.G == 1) {
      this.K.setHint(HardCodeUtil.a(2131911087));
    }
    this.K.addTextChangedListener(new SearchContactsActivity.1(this, bool));
    Object localObject = getResources().getString(2131887648);
    this.I.setText((CharSequence)localObject);
    this.I.setOnClickListener(new SearchContactsActivity.2(this));
    if (AppSetting.e)
    {
      this.I.setContentDescription((CharSequence)localObject);
      if (this.H == 12) {
        this.K.setContentDescription(HardCodeUtil.a(2131911089));
      } else {
        this.K.setContentDescription(HardCodeUtil.a(2131911085));
      }
    }
    if ((!TextUtils.isEmpty(str)) && (!getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false))) {
      return;
    }
    Looper.myQueue().addIdleHandler(this.a);
  }
  
  protected SearchBaseFragment d()
  {
    return SearchContactsFragment.a(this.H);
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
    Looper.myQueue().removeIdleHandler(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */