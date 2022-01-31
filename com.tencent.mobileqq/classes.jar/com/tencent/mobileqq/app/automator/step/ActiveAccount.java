package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.PatchSecurityMode;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ActiveAccount
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.b.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (PatchSecurityMode.a(BaseApplicationImpl.sApplication))
    {
      PatchConfigServlet.a(this.a.b, this.a.b.getCurrentAccountUin(), -1, "SecurityMode");
      QLog.d("PatchLogTag", 1, "ActiveAccount requestPatchConfig as security mode.");
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.b.getApp().getSharedPreferences("acc_info" + this.a.b.getAccount(), 0);
    QQAppInterface localQQAppInterface = this.a.b;
    ThemeUtil.initTheme(localQQAppInterface);
    localQQAppInterface.a(true);
    SubAccountControll.a(localQQAppInterface);
    localQQAppInterface.b();
    UniformDownloadMgr.a().b();
    UnifiedMonitor.a().b();
    OpenApiManager.getInstance().onRuntimeActive(localQQAppInterface);
    if (TroopNotificationUtils.a(localQQAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      localQQAppInterface.a().d("last_group_seq", 0L);
      TroopNotificationUtils.a(localQQAppInterface.getCurrentAccountUin(), false);
      localQQAppInterface.a().d("last_friend_seq_47", 0L);
    }
    if (AnonymousChatHelper.a != null) {
      AnonymousChatHelper.a().a();
    }
    GoldMsgChatHelper.a();
    return 7;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */