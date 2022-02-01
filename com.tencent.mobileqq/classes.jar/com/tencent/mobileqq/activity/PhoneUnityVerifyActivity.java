package com.tencent.mobileqq.activity;

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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627634);
    super.setTitle(getString(2131892487));
    this.leftView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131890215);
    this.rightViewText.setOnClickListener(this);
    paramBundle = (Button)super.findViewById(2131440086);
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
    super.overridePendingTransition(0, 2130772018);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131436211)
    {
      if (i == 2131440086)
      {
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
      }
    }
    else
    {
      super.setResult(-1, new Intent());
      super.finish();
      super.overridePendingTransition(0, 2130772018);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityVerifyActivity
 * JD-Core Version:    0.7.0.1
 */