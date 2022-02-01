package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ShortcutRouterActivity
  extends BaseActivity
{
  DialogInterface.OnClickListener a = new ShortcutRouterActivity.DialogInterfaceOnClickListener(this);
  private ChatActivityUtils.StartVideoListener b;
  
  private int a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uintype", -1);
    String str = paramIntent.getStringExtra("uin");
    if ((i != -1) && (str != null))
    {
      if (paramIntent.getBooleanExtra("isTroopCard", false)) {
        return 0;
      }
      if (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(str)) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  private void a()
  {
    String str = getAppRuntime().getAccount();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setGravity(17);
    localTextView.setTextSize(getResources().getInteger(2131492883));
    localTextView.setTextColor(getResources().getColor(2131165794));
    if (TextUtils.isEmpty(str))
    {
      localTextView.setText(HardCodeUtil.a(2131911414));
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131911430));
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131911431));
      localTextView.setText(localStringBuilder.toString());
    }
    localQQCustomDialog.setNegativeButton(2131916601, this.a);
    localQQCustomDialog.addView(localTextView);
    localQQCustomDialog.setOnDismissListener(new ShortcutRouterActivity.2(this));
    if (!isFinishing()) {
      localQQCustomDialog.show();
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
    paramBundle = getIntent();
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(67371008);
      paramBundle.putExtra("shortcut_jump_key", getIntent());
      RouteUtils.a(this, paramBundle, "/base/login");
      finish();
      return false;
    }
    String str1 = paramBundle.getStringExtra("shotcut_forward");
    boolean bool = paramBundle.getBooleanExtra("open_chatfragment", false);
    String str2 = paramBundle.getStringExtra("forward");
    if (!TextUtils.isEmpty(str1))
    {
      if ((!TextUtils.isEmpty(str2)) && (str2.equals("starClub")) && (str1.equals(ChatActivity.class.getName())))
      {
        paramBundle.putExtra("uin", "1413778541");
        paramBundle.putExtra("uinname", HardCodeUtil.a(2131911433));
        paramBundle.putExtra("uintype", 1008);
        paramBundle.putExtra("from", "starShortcut");
        paramBundle.setClassName(this, str1);
        paramBundle.setFlags(67108864);
        startActivity(paramBundle);
        return true;
      }
      int i = a(paramBundle);
      if (i != 1)
      {
        if (i != 2)
        {
          if ((str1.equals(SplashActivity.class.getName())) && (bool))
          {
            paramBundle.setClassName(this, str1);
            paramBundle.putExtra("entrance", 4);
            startActivity(paramBundle);
            finish();
            return true;
          }
          str1 = paramBundle.getStringExtra("uin");
          str2 = paramBundle.getStringExtra("uinname");
          i = paramBundle.getIntExtra("uintype", 0);
          paramBundle = paramBundle.getStringExtra("extraUin");
          if (this.b == null) {
            this.b = new ShortcutRouterActivity.1(this);
          }
          if (ChatActivityUtils.a(this.app, this, i, str1, str2, null, true, paramBundle, true, true, this.b, "from_internal"))
          {
            finish();
            return true;
          }
        }
        else
        {
          a();
          return true;
        }
      }
      else
      {
        QQToast.makeText(this, getString(2131916599), 0).show(getTitleBarHeight());
        finish();
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onStop()
  {
    super.onStop();
    finish();
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutRouterActivity
 * JD-Core Version:    0.7.0.1
 */