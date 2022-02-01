package com.tencent.mobileqq.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneUnityVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String a;
  
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
    if (paramInt1 == 1001)
    {
      super.setResult(-1, paramIntent);
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561332);
    super.setTitle(getString(2131694577));
    this.leftView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131692996);
    this.rightViewText.setOnClickListener(this);
    paramBundle = (Button)super.findViewById(2131372641);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(this);
    }
    paramBundle = super.getIntent();
    if (paramBundle != null) {
      this.a = paramBundle.getStringExtra("url");
    }
    return true;
  }
  
  public boolean onBackEvent()
  {
    super.setResult(-1, new Intent());
    super.finish();
    super.overridePendingTransition(0, 2130772001);
    return false;
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
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("url", this.a);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("needResult", true);
      localIntent.putExtra("business", 16384L);
      super.startActivityForResult(localIntent, 1001);
      continue;
      super.setResult(-1, new Intent());
      super.finish();
      super.overridePendingTransition(0, 2130772001);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityVerifyActivity
 * JD-Core Version:    0.7.0.1
 */