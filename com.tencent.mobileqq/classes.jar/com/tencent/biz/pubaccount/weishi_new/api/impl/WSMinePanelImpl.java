package com.tencent.biz.pubaccount.weishi_new.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.profilecard.WSProfileCardReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class WSMinePanelImpl
  implements IWSMinePanel
{
  public void downloadWeishiWithDialog(Activity paramActivity, boolean paramBoolean)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 3;
    if (paramBoolean) {}
    for (int i = 201;; i = 200)
    {
      localWSDownloadParams.mEventId = i;
      WeishiDownloadUtil.a(paramActivity, localWSDownloadParams, false);
      return;
    }
  }
  
  public void reportProfileCardExposure(boolean paramBoolean, String paramString)
  {
    WSProfileCardReport.a(paramBoolean, paramString);
  }
  
  public void reportProfilePageVisitEnter(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    WSProfileCardReport.a(paramProfileCardInfo, paramQQAppInterface);
  }
  
  public void reportProfilePageVisitExit(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    WSProfileCardReport.b(paramProfileCardInfo, paramQQAppInterface);
  }
  
  public void reportProfileSettingBtnClick(boolean paramBoolean)
  {
    WSProfileCardReport.b(paramBoolean);
  }
  
  public void reportProfileSettingExposure(boolean paramBoolean)
  {
    WSProfileCardReport.a(paramBoolean);
  }
  
  public void reportProfileSettingPageVisitEnter() {}
  
  public void reportProfileSettingPageVisitExit() {}
  
  public void reportWeiShiProfileClick(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    WSProfileCardReport.a(paramBoolean1, paramString, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.api.impl.WSMinePanelImpl
 * JD-Core Version:    0.7.0.1
 */