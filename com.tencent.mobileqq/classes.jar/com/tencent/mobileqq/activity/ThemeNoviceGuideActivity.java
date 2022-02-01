package com.tencent.mobileqq.activity;

import Override;
import afay;
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
import anvx;
import bbbq;
import bdla;
import bhbx;
import bhnp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler a = new afay(this, Looper.getMainLooper());
  
  private void a()
  {
    setLeftButton(2131690845, null);
    ((Button)findViewById(2131378355)).setOnClickListener(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131562951);
    a();
    setTitle(anvx.a(2131714304));
    this.a.sendMessageDelayed(Message.obtain(this.a, 0, null), 5L);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((WebProcessManager)this.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER)).e();
  }
  
  public boolean onBackEvent()
  {
    finish();
    AlbumUtil.anim(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378355)
    {
      if (!bhbx.a()) {
        break label129;
      }
      finish();
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("FromWhere", "FromThemeNoviceGuide");
      VasWebviewUtil.openQQBrowserWithoutAD(this, bhnp.a(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, localIntent, false, -1);
      if (this.app != null) {
        ((bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005.100002");
      }
    }
    for (;;)
    {
      if (this.app != null) {
        bdla.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "theme_popup_click", 0, 0, "", "", "", "");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label129:
      Toast.makeText(getApplicationContext(), getString(2131718340), 0).show();
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
    return getString(2131690676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */