package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQBrowserDelegationActivity
  extends BaseActivity
{
  public static final String a;
  private Intent a;
  
  static
  {
    jdField_a_of_type_JavaLangString = FrameControllerUtil.d;
  }
  
  public QQBrowserDelegationActivity()
  {
    this.jdField_a_of_type_AndroidContentIntent = null;
  }
  
  void a(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if ((paramIntent != null) && (paramQQAppInterface != null))
    {
      if (paramQQAppInterface.getMessageFacade() == null) {
        return;
      }
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      boolean bool = "3046055438".equals(localEcShopAssistantManager.i);
      localEcShopAssistantManager.i = null;
      if (bool)
      {
        paramIntent.setClass(this, BusinessBrowser.class);
        paramIntent.putExtra("jump_from", 1);
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().getLastMessage(localEcShopAssistantManager.i, 1008);
        if (paramQQAppInterface != null) {
          paramIntent.putExtra("msg_id", paramQQAppInterface.getExtInfoFromExtStr("public_account_msg_id"));
        }
      }
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
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (this.jdField_a_of_type_AndroidContentIntent.getExtras() == null)
    {
      finish();
      return false;
    }
    Intent localIntent = new Intent(getIntent());
    int i = localIntent.getIntExtra("browserType", 0);
    localIntent.putExtra("needSkey", "true");
    if (i != 1)
    {
      if (i != 3)
      {
        localIntent.setClass(this, QQBrowserActivity.class);
      }
      else
      {
        localIntent.putExtra("fragmentClass", ArkBrowserFragment.class);
        localIntent.setClass(this, QQBrowserActivity.class);
      }
    }
    else {
      localIntent.setClass(this, QQH5BrowserActivity.class);
    }
    String str = localIntent.getStringExtra("url");
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsFormUrl(str))
    {
      paramBundle = null;
      i = localIntent.getIntExtra("uinType", 1);
      if (i == 1) {
        paramBundle = localIntent.getStringExtra("groupUin");
      } else if (i == 0) {
        paramBundle = localIntent.getStringExtra("friend_uin");
      }
      if ((!TextUtils.isEmpty(paramBundle)) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).openTroopFormMiniApp(this, str, ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).getTroopFormGrayParameter(this.app, paramBundle, i))))
      {
        ReportController.b(this.app, "dc00898", "", paramBundle, "0X8009FCF", "0X8009FCF", 0, 0, "", "", "", "");
        finish();
        return false;
      }
    }
    paramBundle = localIntent;
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str))
    {
      if (localIntent.getBooleanExtra("h5_ark_is_from_share", false))
      {
        boolean bool = ((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(this, str, "s_qq_aio_ark_h5");
        finish();
        if (bool) {
          return false;
        }
      }
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserDelegationActivity
 * JD-Core Version:    0.7.0.1
 */