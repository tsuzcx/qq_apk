package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;

public class QQBrowserDelegationActivity
  extends BaseActivity
{
  private Intent a;
  
  void a(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if ((paramIntent == null) || (paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {}
    do
    {
      int i;
      EcShopAssistantManager localEcShopAssistantManager;
      do
      {
        return;
        i = 0;
        localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
        if ("3046055438".equals(localEcShopAssistantManager.i)) {
          i = 1;
        }
        localEcShopAssistantManager.i = null;
      } while (i == 0);
      paramIntent.setClass(this, BusinessBrowser.class);
      paramIntent.putExtra("jump_from", 1);
      paramQQAppInterface = paramQQAppInterface.a().a(localEcShopAssistantManager.i, 1008);
    } while (paramQQAppInterface == null);
    paramIntent.putExtra("msg_id", paramQQAppInterface.getExtInfoFromExtStr("public_account_msg_id"));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = getIntent();
    if (this.a.getExtras() == null)
    {
      finish();
      return false;
    }
    Intent localIntent = new Intent(getIntent());
    int i = localIntent.getIntExtra("browserType", 0);
    localIntent.putExtra("needSkey", "true");
    switch (i)
    {
    default: 
      localIntent.setClass(this, QQBrowserActivity.class);
    }
    for (;;)
    {
      String str = localIntent.getStringExtra("url");
      paramBundle = localIntent;
      if (TeamWorkUtils.a(str))
      {
        localIntent.setClass(this, TeamWorkDocEditBrowserActivity.class);
        localIntent.addFlags(603979776);
        paramBundle = TeamWorkDocEditBrowserActivity.a(localIntent, str, this);
      }
      a(paramBundle, this.app);
      paramBundle.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBundle.putExtra("uin", this.app.getCurrentAccountUin());
      startActivity(paramBundle);
      finish();
      return false;
      localIntent.setClass(this, QQH5BrowserActivity.class);
    }
  }
  
  protected void doOnStart()
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserDelegationActivity
 * JD-Core Version:    0.7.0.1
 */