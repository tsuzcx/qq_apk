package com.tencent.mobileqq.ark.setting;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ArkAuthorityInfoActivity
  extends IphoneTitleBarActivity
{
  private static final String[] a = { "ark_authority_api_user_info", "ark_authority_api_location", "ark_authority_api_relationship", "ark_authority_api_login", "ark_authority_api_phone_number" };
  private String b;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131624252);
    super.setTitle(2131887022);
    this.b = getIntent().getStringExtra("intent_extra_authority_app_name");
    ((TextView)super.findViewById(2131428753)).setText(getString(2131887028, new Object[] { this.b }));
    int i = 0;
    while (i < a.length)
    {
      paramBundle = (FormSwitchItem)super.findViewById(new int[] { 2131428745, 2131428741, 2131428744, 2131428742, 2131428743 }[i]);
      int j = ((IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class)).getArkAuthorityInfo(this.b, a[i], this.app.getCurrentAccountUin());
      if (j == 0)
      {
        paramBundle.setVisibility(8);
      }
      else
      {
        paramBundle.setVisibility(0);
        boolean bool;
        if (1 == j) {
          bool = true;
        } else {
          bool = false;
        }
        paramBundle.setChecked(bool);
        paramBundle.setOnCheckedChangeListener(new ArkAuthorityInfoActivity.1(this, i));
      }
      i += 1;
    }
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity
 * JD-Core Version:    0.7.0.1
 */