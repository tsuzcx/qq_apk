package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PrinterBindTipActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String a;
  private long b;
  private Button c;
  
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
    super.getWindow().setBackgroundDrawableResource(2131165716);
    super.setContentView(2131625601);
    super.setTitle(HardCodeUtil.a(2131906198));
    super.setLeftViewName(2131888536);
    this.c = ((Button)super.findViewById(2131429496));
    this.c.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.a = paramBundle.getStringExtra("printer_bind_url");
    this.b = paramBundle.getIntExtra("din", 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    SmartDeviceReport.a();
    SmartDeviceReport.a(this.app, this.b, "printer_hp", 5, 0, 0);
    if (!TextUtils.isEmpty(this.a))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromQrcode", true);
      localIntent.putExtra("url", this.a);
      super.startActivity(localIntent);
    }
    super.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterBindTipActivity
 * JD-Core Version:    0.7.0.1
 */