package com.tencent.biz.lebasearch;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import bbyb;
import bcfr;
import bcga;
import bhlg;
import bmkq;
import bmtd;
import bmtk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import oix;
import wnu;

public class LebaSearchTransparentJumpActivity
  extends IphoneTitleBarActivity
{
  public View a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)paramBundle);
    }
    this.a = new View(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bbyb localbbyb = (bbyb)this.app.getManager(222);
    if (localbbyb.jdField_a_of_type_Bcfr != null) {
      localbbyb.jdField_a_of_type_Bcfr = null;
    }
    if (localbbyb.jdField_a_of_type_Bcga != null) {
      localbbyb.jdField_a_of_type_Bcga = null;
    }
  }
  
  public void doOnResume()
  {
    int j = 0;
    super.doOnResume();
    Object localObject1 = getIntent();
    switch (((Intent)localObject1).getIntExtra("key_business", 0))
    {
    }
    for (;;)
    {
      finish();
      return;
      wnu.a(this, 23, ((Intent)localObject1).getLongExtra("uin", 0L));
      continue;
      QWalletHelper.launchQWalletAct(this, this.app, true, false);
      continue;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("newflag", true);
      ((Intent)localObject1).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject1, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject1).addFlags(805306368);
      bmtd.b(this, this.app.getCurrentAccountUin(), (Intent)localObject1, -1);
      continue;
      ((Intent)localObject1).putExtra("selfSet_leftViewText", getString(2131690559));
      bmkq.a(this, this.app.getAccount(), (Intent)localObject1, -1, false);
      continue;
      bmtk localbmtk = bmtk.a();
      try
      {
        long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
        localbmtk.a = String.valueOf(l);
        String str = this.app.getCurrentNickname();
        localObject1 = str;
        if (TextUtils.isEmpty(str)) {
          localObject1 = bhlg.h(this.app, String.valueOf(l));
        }
        localbmtk.b = ((String)localObject1);
        bmtd.b(this, localbmtk, Long.valueOf(l), 0, false, -1);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
      int i = localException1.getIntExtra("tab_tab_index", 0);
      oix.a(this.app, this, 1, i);
      continue;
      Object localObject2 = new Intent(this, PhoneUnityBindInfoActivity.class);
      ((Intent)localObject2).putExtra("kSrouce", 18);
      startActivity((Intent)localObject2);
      continue;
      localObject2 = ((Intent)localObject2).getStringExtra("key_click_web_search_fts_key");
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject2 = ((String)localObject2).split("-");
      }
      try
      {
        i = Integer.valueOf(localObject2[1]).intValue();
        localObject2 = ((bbyb)this.app.getManager(222)).jdField_a_of_type_Bcfr;
        if (localObject2 != null)
        {
          this.a.setTag(2131381110, Integer.valueOf(i));
          ((bcfr)localObject2).a(this.a);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("IphoneTitleBarActivity", 2, " local result idStr parse error!");
            i = j;
          }
        }
        QLog.d("kueenie", 2, "result model is null");
      }
      continue;
      ((bbyb)this.app.getManager(222)).jdField_a_of_type_Bcga.a(this.a);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchTransparentJumpActivity
 * JD-Core Version:    0.7.0.1
 */