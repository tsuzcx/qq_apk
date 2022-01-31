package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate;
import com.tencent.biz.common.report.BnrReport.BnrReportCheckUpdate;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigCheckUpdateItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GetRichSig;
import com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountHandler.PublicAccountCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReqDpcInfoNewItem;
import com.tencent.mobileqq.app.ReqGetSettingsItem;
import com.tencent.mobileqq.app.ReqSystemMsgNewItem;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.qzonelover.QzoneLoverService;
import com.tencent.mobileqq.log.WebViewCheckUpdataItem;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.qcall.PstnInfoCheckUpdateItem;
import com.tencent.mobileqq.service.message.GetBlackListItem;
import com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem;
import com.tencent.mobileqq.util.QQSettingUtil.UserBitFlagCheckUpdate;
import zqr;

public class GetCheckUpdate
  extends AsyncStep
{
  zqr a;
  
  protected int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(1);
    if (this.b == 45) {}
    for (int i = 1;; i = 4)
    {
      localFriendListHandler.a(true, i);
      QzoneLoverService.a().a();
      return 2;
    }
  }
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b;
    if (this.b == 45)
    {
      PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)localQQAppInterface.a(11);
      if (localPublicAccountHandler.a())
      {
        Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        localPublicAccountHandler.getClass();
        localAutomator.a(102, new PublicAccountHandler.PublicAccountCheckUpdateItem(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new QQSettingUtil.UserBitFlagCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new BnrReport.BnrReportCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new OfflineExpire.OfflineExpireCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new ReqDpcInfoNewItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new GetSimpleInfoCheckUpdateItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new GetBlackListItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new ReqSystemMsgNewItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new ReqGetSettingsItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new ProfileCardCheckUpdate(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new GetRichSig(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new AioAnimationConfigCheckUpdateItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new PreloadInfoCheckUpdateItem(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new WebViewCheckUpdataItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(128, new PstnInfoCheckUpdateItem(localQQAppInterface, 128));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(129, new PstnInfoCheckUpdateItem(localQQAppInterface, 129));
    }
    if (this.jdField_a_of_type_Zqr == null)
    {
      this.jdField_a_of_type_Zqr = new zqr(this, null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_Zqr);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Zqr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_Zqr);
      this.jdField_a_of_type_Zqr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */