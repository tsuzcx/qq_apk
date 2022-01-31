package com.tencent.mobileqq.activity;

import acfo;
import ajyc;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import avpq;
import axqw;
import bbbd;
import bbbj;
import bbpp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler a = new acfo(this, Looper.getMainLooper());
  
  private void a()
  {
    setLeftButton(2131690832, null);
    ((Button)findViewById(2131376760)).setOnClickListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131562507);
    a();
    setTitle(ajyc.a(2131714922));
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
    bbbj.a(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376760)
    {
      if (!bbbd.a()) {
        break label121;
      }
      finish();
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("FromWhere", "FromThemeNoviceGuide");
      VasWebviewUtil.openQQBrowserWithoutAD(this, bbpp.a(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramView, false, -1);
      if (this.app != null) {
        ((avpq)this.app.getManager(36)).b("100005.100002");
      }
    }
    for (;;)
    {
      if (this.app != null) {
        axqw.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "theme_popup_click", 0, 0, "", "", "", "");
      }
      return;
      label121:
      Toast.makeText(getApplicationContext(), getString(2131719044), 0).show();
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