package com.tencent.mobileqq.activity;

import Override;
import afqy;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import anzj;
import bbav;
import bdll;
import bhjx;
import bhkd;
import bhyk;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler a = new afqy(this, Looper.getMainLooper());
  
  private void a()
  {
    setLeftButton(2131690728, null);
    ((Button)findViewById(2131378298)).setOnClickListener(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131563000);
    a();
    setTitle(anzj.a(2131713725));
    this.a.sendMessageDelayed(Message.obtain(this.a, 0, null), 5L);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((WebProcessManager)this.app.getManager(13)).e();
  }
  
  public boolean onBackEvent()
  {
    finish();
    bhkd.anim(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378298)
    {
      if (!bhjx.a()) {
        break label128;
      }
      finish();
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("FromWhere", "FromThemeNoviceGuide");
      VasWebviewUtil.openQQBrowserWithoutAD(this, bhyk.a(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, localIntent, false, -1);
      if (this.app != null) {
        ((bbav)this.app.getManager(36)).b("100005.100002");
      }
    }
    for (;;)
    {
      if (this.app != null) {
        bdll.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "theme_popup_click", 0, 0, "", "", "", "");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label128:
      Toast.makeText(getApplicationContext(), getString(2131717719), 0).show();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public String setLastActivityName()
  {
    return getString(2131690559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */