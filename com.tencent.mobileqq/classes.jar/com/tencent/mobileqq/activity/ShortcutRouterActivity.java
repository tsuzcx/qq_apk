package com.tencent.mobileqq.activity;

import aagm;
import abrq;
import abrr;
import abrs;
import ajjj;
import ajjy;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import babr;
import bafb;
import bbmy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class ShortcutRouterActivity
  extends BaseActivity
{
  private aagm jdField_a_of_type_Aagm;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new abrs(this);
  
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
    if (!((ajjj)this.app.getManager(51)).b(str)) {
      return 2;
    }
    return 0;
  }
  
  private void a()
  {
    String str = getAppRuntime().getAccount();
    bafb localbafb = babr.a(this, 230);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setGravity(17);
    localTextView.setTextSize(getResources().getInteger(2131361800));
    localTextView.setTextColor(getResources().getColor(2131099854));
    if (TextUtils.isEmpty(str)) {
      localTextView.setText(ajjy.a(2131648213));
    }
    for (;;)
    {
      localbafb.setNegativeButton(2131653656, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      localbafb.addView(localTextView);
      localbafb.setOnDismissListener(new abrr(this));
      if (!isFinishing()) {
        localbafb.show();
      }
      return;
      localTextView.setText(ajjy.a(2131648229) + str + ajjy.a(2131648232));
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
        paramBundle.putExtra("uinname", ajjy.a(2131648234));
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
        bbmy.a(this, getString(2131653654), 0).b(getTitleBarHeight());
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
      if (this.jdField_a_of_type_Aagm == null) {
        this.jdField_a_of_type_Aagm = new abrq(this);
      }
      bool1 = bool2;
    } while (!ChatActivityUtils.a(this.app, this, i, str1, str2, null, true, paramBundle, true, true, this.jdField_a_of_type_Aagm, "from_internal"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutRouterActivity
 * JD-Core Version:    0.7.0.1
 */