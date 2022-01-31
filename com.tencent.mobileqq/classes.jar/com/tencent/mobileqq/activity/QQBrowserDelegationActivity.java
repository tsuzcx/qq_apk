package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import azqs;
import baic;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import ntw;

public class QQBrowserDelegationActivity
  extends BaseActivity
{
  public static final String a;
  private Intent a;
  
  static
  {
    jdField_a_of_type_JavaLangString = MainFragment.c;
  }
  
  void a(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if ((paramIntent == null) || (paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {}
    do
    {
      int i;
      ntw localntw;
      do
      {
        return;
        i = 0;
        localntw = (ntw)paramQQAppInterface.getManager(88);
        if ("3046055438".equals(localntw.i)) {
          i = 1;
        }
        localntw.i = null;
      } while (i == 0);
      paramIntent.setClass(this, BusinessBrowser.class);
      paramIntent.putExtra("jump_from", 1);
      paramQQAppInterface = paramQQAppInterface.a().a(localntw.i, 1008);
    } while (paramQQAppInterface == null);
    paramIntent.putExtra("msg_id", paramQQAppInterface.getExtInfoFromExtStr("public_account_msg_id"));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (this.jdField_a_of_type_AndroidContentIntent.getExtras() == null) {
      finish();
    }
    Intent localIntent;
    String str;
    label244:
    boolean bool;
    do
    {
      return false;
      localIntent = new Intent(getIntent());
      int i = localIntent.getIntExtra("browserType", 0);
      localIntent.putExtra("needSkey", "true");
      switch (i)
      {
      case 2: 
      default: 
        localIntent.setClass(this, QQBrowserActivity.class);
        str = localIntent.getStringExtra("url");
        if (!baic.b(str)) {
          break label244;
        }
        paramBundle = null;
        i = localIntent.getIntExtra("uinType", 1);
        if (i == 1) {
          paramBundle = localIntent.getStringExtra("groupUin");
        }
        break;
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramBundle)) || (!baic.a(this, str, baic.a(this.app, paramBundle, i)))) {
          break label244;
        }
        azqs.b(this.app, "dc00898", "", paramBundle, "0X8009FCF", "0X8009FCF", 0, 0, "", "", "", "");
        finish();
        return false;
        localIntent.setClass(this, QQH5BrowserActivity.class);
        break;
        localIntent.putExtra("fragmentClass", ArkBrowserFragment.class);
        localIntent.setClass(this, QQBrowserActivity.class);
        break;
        if (i == 0) {
          paramBundle = localIntent.getStringExtra("friend_uin");
        }
      }
      paramBundle = localIntent;
      if (!baic.a(str)) {
        break label309;
      }
      if (!localIntent.getBooleanExtra("h5_ark_is_from_share", false)) {
        break;
      }
      bool = TeamWorkDocEditBrowserActivity.a(this, str, "s_qq_aio_ark_h5");
      finish();
    } while (bool);
    localIntent.setClass(this, TeamWorkDocEditBrowserActivity.class);
    localIntent.addFlags(603979776);
    paramBundle = TeamWorkDocEditBrowserActivity.a(localIntent, str, this);
    label309:
    a(paramBundle, this.app);
    paramBundle.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramBundle.putExtra("uin", this.app.getCurrentAccountUin());
    startActivity(paramBundle);
    finish();
    return false;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    mAppForground = GesturePWDUtils.getAppForground(getActivity());
    if ((!mAppForground) && (this.mCanLock) && (this.app != null) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
      startUnlockActivity();
    }
    if (!mAppForground)
    {
      mAppForground = true;
      GesturePWDUtils.setAppForground(getActivity(), mAppForground);
    }
    this.mStopFlag = 0;
    this.mCanLock = true;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserDelegationActivity
 * JD-Core Version:    0.7.0.1
 */