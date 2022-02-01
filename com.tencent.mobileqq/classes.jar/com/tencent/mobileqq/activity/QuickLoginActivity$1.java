package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

class QuickLoginActivity$1
  implements AdapterView.OnItemClickListener
{
  QuickLoginActivity$1(QuickLoginActivity paramQuickLoginActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)((HashMap)this.a.a.get(paramInt)).get("qq");
    libsafeedit.getLoginLegal((String)((HashMap)this.a.a.get(paramInt)).get("password"));
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    this.a.getAppRuntime().login(str, arrayOfByte, QuickLoginActivity.a(this.a));
    Toast.makeText(this.a.getApplicationContext(), "logining...", 0).show();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QuickLoginActivity.1
 * JD-Core Version:    0.7.0.1
 */