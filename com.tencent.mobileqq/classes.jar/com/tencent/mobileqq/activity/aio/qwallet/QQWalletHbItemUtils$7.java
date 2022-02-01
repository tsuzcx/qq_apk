package com.tencent.mobileqq.activity.aio.qwallet;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QQWalletHbItemUtils$7
  implements View.OnClickListener
{
  QQWalletHbItemUtils$7(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(10);
      }
      long l = System.currentTimeMillis();
      if (!QWalletRedPkgUtils.a(QQWalletHbItemUtils.jdField_a_of_type_Long, l)) {
        continue;
      }
      QQWalletHbItemUtils.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      if (AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        continue;
      }
      Object localObject1 = localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((PasswdRedBagInfo)localObject1).jdField_a_of_type_Boolean) || (((PasswdRedBagInfo)localObject1).b) || (((PasswdRedBagInfo)localObject1).c) || (((PasswdRedBagInfo)localObject1).jdField_a_of_type_Long < l)))
      {
        localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=" + ((MessageForQQWalletMsg)localObject2).messageType, 0, null);
        Bundle localBundle = new Bundle();
        localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
        localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (PasswdRedBagInfo)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, localBundle);
        localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((PasswdRedBagInfo)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((PasswdRedBagInfo)localObject1).b + ",isPasswdRedBagOverDue=" + ((PasswdRedBagInfo)localObject1).c);
        continue;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        localObject2 = (QWalletAIOLifeCycleHelper)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((QWalletAIOLifeCycleHelper)localObject2).a(localQQWalletRedPacketMsg.redPacketId, ((PasswdRedBagInfo)localObject1).e, localQQWalletRedPacketMsg.body.subChannel);
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(localQQWalletRedPacketMsg.redPacketId);
        localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label483:
        localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
      }
      catch (Throwable localThrowable)
      {
        break label483;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils.7
 * JD-Core Version:    0.7.0.1
 */