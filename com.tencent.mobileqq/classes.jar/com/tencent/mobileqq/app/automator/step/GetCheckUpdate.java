package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate;
import com.tencent.biz.common.report.BnrReport.BnrReportCheckUpdate;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigCheckUpdateItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GetRichSig;
import com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReqDpcInfoNewItem;
import com.tencent.mobileqq.app.ReqGetSettingsItem;
import com.tencent.mobileqq.app.ReqSystemMsgNewItem;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.log.WebViewCheckUpdataItem;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.service.message.GetBlackListItem;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem;
import com.tencent.mobileqq.util.QQSettingUtil.UserBitFlagCheckUpdate;

public class GetCheckUpdate
  extends AsyncStep
{
  GetCheckUpdate.MyAutomatorObserver a;
  
  protected int doStep()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    int i;
    if (this.mStepId == 45) {
      i = 1;
    } else {
      i = 4;
    }
    localFriendListHandler.getCheckUpdate(true, i);
    return 2;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QQAppInterface localQQAppInterface = this.mAutomator.a;
    if (this.mStepId == 45)
    {
      IPublicAccountHandler localIPublicAccountHandler = (IPublicAccountHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localIPublicAccountHandler.isNeedUpdate()) {
        this.mAutomator.a(102, (CheckUpdateItemInterface)localIPublicAccountHandler.newPublicAccountCheckUpdateItem());
      }
      this.mAutomator.a(106, new QQSettingUtil.UserBitFlagCheckUpdate(this.mAutomator.a));
      this.mAutomator.a(118, new BnrReport.BnrReportCheckUpdate(this.mAutomator.a));
      this.mAutomator.a(127, new OfflineExpire.OfflineExpireCheckUpdate(this.mAutomator.a));
      this.mAutomator.a(117, new ReqDpcInfoNewItem(localQQAppInterface));
      this.mAutomator.a(113, new GetSimpleInfoCheckUpdateItem(localQQAppInterface));
      this.mAutomator.a(116, new GetBlackListItem(localQQAppInterface));
      this.mAutomator.a(114, new ReqSystemMsgNewItem(localQQAppInterface));
      this.mAutomator.a(115, new ReqGetSettingsItem(localQQAppInterface));
      this.mAutomator.a(122, new ProfileCardCheckUpdate(localQQAppInterface));
      this.mAutomator.a(119, new GetRichSig(localQQAppInterface));
      this.mAutomator.a(120, new AioAnimationConfigCheckUpdateItem(localQQAppInterface));
      this.mAutomator.a(123, new PreloadInfoCheckUpdateItem(this.mAutomator.a));
      this.mAutomator.a(126, new WebViewCheckUpdataItem(localQQAppInterface));
    }
    if (this.a == null)
    {
      this.a = new GetCheckUpdate.MyAutomatorObserver(this, null);
      localQQAppInterface.addObserver(this.a);
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.a.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */