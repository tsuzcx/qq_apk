package com.tencent.mobileqq.activity;

import acln;
import adxv;
import adxw;
import adxx;
import alto;
import alud;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

public class ShortcutRouterActivity
  extends BaseActivity
{
  private acln jdField_a_of_type_Acln;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new adxx(this);
  
  private int a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uintype", -1);
    String str = paramIntent.getStringExtra("uin");
    if ((i == -1) || (str == null)) {
      return 1;
    }
    if (paramIntent.getBooleanExtra("isTroopCard", false)) {
      return 0;
    }
    if (!((alto)this.app.getManager(51)).b(str)) {
      return 2;
    }
    return 0;
  }
  
  private void a()
  {
    String str = getAppRuntime().getAccount();
    bdjz localbdjz = bdgm.a(this, 230);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setGravity(17);
    localTextView.setTextSize(getResources().getInteger(2131427336));
    localTextView.setTextColor(getResources().getColor(2131165448));
    if (TextUtils.isEmpty(str)) {
      localTextView.setText(alud.a(2131714396));
    }
    for (;;)
    {
      localbdjz.setNegativeButton(2131720095, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      localbdjz.addView(localTextView);
      localbdjz.setOnDismissListener(new adxw(this));
      if (!isFinishing()) {
        localbdjz.show();
      }
      return;
      localTextView.setText(alud.a(2131714412) + str + alud.a(2131714415));
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    boolean bool1;
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(67371008);
      paramBundle.putExtra("shortcut_jump_key", getIntent());
      startActivity(paramBundle);
      finish();
      bool1 = false;
    }
    String str1;
    String str2;
    int i;
    do
    {
      boolean bool3;
      do
      {
        return bool1;
        str1 = paramBundle.getStringExtra("shotcut_forward");
        bool3 = paramBundle.getBooleanExtra("open_chatfragment", false);
        str2 = paramBundle.getStringExtra("forward");
        bool1 = bool2;
      } while (TextUtils.isEmpty(str1));
      if ((!TextUtils.isEmpty(str2)) && (str2.equals("starClub")) && (str1.equals(ChatActivity.class.getName())))
      {
        paramBundle.putExtra("uin", "1413778541");
        paramBundle.putExtra("uinname", alud.a(2131714417));
        paramBundle.putExtra("uintype", 1008);
        paramBundle.putExtra("from", "starShortcut");
        paramBundle.setClassName(this, str1);
        paramBundle.setFlags(67108864);
        startActivity(paramBundle);
        return true;
      }
      switch (a(paramBundle))
      {
      default: 
        if ((str1.equals(SplashActivity.class.getName())) && (bool3))
        {
          paramBundle.setClassName(this, str1);
          paramBundle.putExtra("entrance", 4);
          startActivity(paramBundle);
          finish();
          return true;
        }
        break;
      case 1: 
        QQToast.a(this, getString(2131720093), 0).b(getTitleBarHeight());
        finish();
        return true;
      case 2: 
        a();
        return true;
      }
      str1 = paramBundle.getStringExtra("uin");
      str2 = paramBundle.getStringExtra("uinname");
      i = paramBundle.getIntExtra("uintype", 0);
      paramBundle = paramBundle.getStringExtra("extraUin");
      if (this.jdField_a_of_type_Acln == null) {
        this.jdField_a_of_type_Acln = new adxv(this);
      }
      bool1 = bool2;
    } while (!ChatActivityUtils.a(this.app, this, i, str1, str2, null, true, paramBundle, true, true, this.jdField_a_of_type_Acln, "from_internal"));
    finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onStop()
  {
    super.onStop();
    finish();
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutRouterActivity
 * JD-Core Version:    0.7.0.1
 */