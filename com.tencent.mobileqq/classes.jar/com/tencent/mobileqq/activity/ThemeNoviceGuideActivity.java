package com.tencent.mobileqq.activity;

import aebj;
import alud;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import axlx;
import azqs;
import bdeu;
import bdfa;
import bdtg;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler a = new aebj(this, Looper.getMainLooper());
  
  private void a()
  {
    setLeftButton(2131690885, null);
    ((Button)findViewById(2131377328)).setOnClickListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131562727);
    a();
    setTitle(alud.a(2131715317));
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
    bdfa.anim(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377328)
    {
      if (!bdeu.a()) {
        break label121;
      }
      finish();
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("FromWhere", "FromThemeNoviceGuide");
      VasWebviewUtil.openQQBrowserWithoutAD(this, bdtg.a(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramView, false, -1);
      if (this.app != null) {
        ((axlx)this.app.getManager(36)).b("100005.100002");
      }
    }
    for (;;)
    {
      if (this.app != null) {
        azqs.b(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "theme_mall", "theme_popup_click", 0, 0, "", "", "", "");
      }
      return;
      label121:
      Toast.makeText(getApplicationContext(), getString(2131719547), 0).show();
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131690623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */