package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

public class LebaSearchMoreInfoActivity
  extends AbsBaseWebViewActivity
{
  View a;
  TextView b;
  FrameLayout c;
  String d;
  String e;
  long f;
  boolean g = false;
  String h = null;
  QQCustomDialog i = null;
  Handler j = new LebaSearchMoreInfoActivity.1(this);
  TroopMemberApiClient k;
  public BusinessObserver l = new LebaSearchMoreInfoActivity.3(this);
  
  private void a()
  {
    this.k = TroopMemberApiClient.a();
    this.k.e();
    this.k.a(this.l);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      return;
    }
    this.d = localIntent.getStringExtra("url");
    this.f = localIntent.getLongExtra("id", -1L);
    if (TextUtils.isEmpty(this.d)) {
      finish();
    }
  }
  
  private void b()
  {
    this.a = findViewById(2131440440);
    this.a.setVisibility(8);
    this.b = ((TextView)this.a.findViewById(2131439344));
    this.b.setCompoundDrawables(null, null, null, null);
    this.a.setOnClickListener(this);
    Object localObject = (ImageView)this.a.findViewById(2131439343);
    ((ImageView)localObject).setImageResource(2130849336);
    ((ImageView)localObject).setOnClickListener(this);
    this.c = ((FrameLayout)findViewById(2131450074));
    this.j.post(new LebaSearchMoreInfoActivity.2(this));
    if (this.f != -1L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("uiResId", this.f);
      this.k.a(18, (Bundle)localObject, this.l);
    }
  }
  
  private void c()
  {
    if (this.g) {
      return;
    }
    if (this.e == null)
    {
      this.a.setVisibility(8);
      return;
    }
    Object localObject1 = getSharedPreferences("leba_search_more_config", 0);
    String str;
    if (getAppRuntime() == null) {
      str = "";
    } else {
      str = getAppRuntime().getAccount();
    }
    if (!TextUtils.isEmpty(this.e))
    {
      this.b.setText(this.e);
      localObject2 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append(";");
      localStringBuilder.append(getString(2131893803));
      ((TextView)localObject2).setContentDescription(localStringBuilder.toString());
    }
    else
    {
      this.b.setContentDescription("");
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("time_");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.f);
    long l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
    int m;
    if (System.currentTimeMillis() - l1 > 86400000L) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("time_");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(this.f);
      ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis());
      this.a.setVisibility(0);
    }
  }
  
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
    setContentView(2131625846);
    a();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    TroopMemberApiClient localTroopMemberApiClient = this.k;
    if (localTroopMemberApiClient != null)
    {
      localTroopMemberApiClient.f();
      this.k.b(this.l);
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int m = paramView.getId();
    if (m != 2131431402) {
      if (m != 2131439343)
      {
        if (m != 2131440440) {
          break label110;
        }
      }
      else
      {
        this.a.setVisibility(8);
        break label110;
      }
    }
    this.a.setVisibility(8);
    if (this.i == null) {
      this.i = Utils.createPluginSetDialogForWeb(this, this.k, this.l, 1, this.f, this.h, null);
    }
    if (this.i.isShowing()) {
      this.i.dismiss();
    }
    this.i.show();
    label110:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onReceivedTitle(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */