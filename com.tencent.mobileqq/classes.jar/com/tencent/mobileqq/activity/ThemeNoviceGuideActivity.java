package com.tencent.mobileqq.activity;

import acfk;
import ajya;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import avps;
import axqy;
import bbbr;
import bbbx;
import bbqd;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler a = new acfk(this, Looper.getMainLooper());
  
  private void a()
  {
    setLeftButton(2131690832, null);
    ((Button)findViewById(2131376762)).setOnClickListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131562506);
    a();
    setTitle(ajya.a(2131714933));
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
    bbbx.a(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376762)
    {
      if (!bbbr.a()) {
        break label121;
      }
      finish();
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("FromWhere", "FromThemeNoviceGuide");
      VasWebviewUtil.openQQBrowserWithoutAD(this, bbqd.a(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramView, false, -1);
      if (this.app != null) {
        ((avps)this.app.getManager(36)).b("100005.100002");
      }
    }
    for (;;)
    {
      if (this.app != null) {
        axqy.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "theme_popup_click", 0, 0, "", "", "", "");
      }
      return;
      label121:
      Toast.makeText(getApplicationContext(), getString(2131719055), 0).show();
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131690572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */