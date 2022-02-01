package com.tencent.mobileqq.activity.aio.qwallet;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQWalletHbItemUtils$6
  implements View.OnClickListener
{
  QQWalletHbItemUtils$6(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(1);
      }
      long l = System.currentTimeMillis();
      if (QWalletRedPkgUtils.a(QQWalletHbItemUtils.jdField_a_of_type_Long, l))
      {
        QQWalletHbItemUtils.jdField_a_of_type_Long = l;
        Object localObject = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
        PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          PasswdRedBagInfo localPasswdRedBagInfo = localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localPasswdRedBagInfo != null) && ((localPasswdRedBagInfo.jdField_a_of_type_Boolean) || (localPasswdRedBagInfo.b) || (localPasswdRedBagInfo.c) || (localPasswdRedBagInfo.jdField_a_of_type_Long < l)))
          {
            localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
            localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localPasswdRedBagInfo, l, ((MessageForQQWalletMsg)localObject).fromHBList);
            localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, true);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localPasswdRedBagInfo.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localPasswdRedBagInfo.b + ",isPasswdRedBagOverDue=" + localPasswdRedBagInfo.c);
            }
          }
          else
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
            {
              localObject = (QWalletAIOLifeCycleHelper)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(27);
              if (localObject != null) {
                ((QWalletAIOLifeCycleHelper)localObject).a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, HardCodeUtil.a(2131711152));
              }
            }
            localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, false);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils.6
 * JD-Core Version:    0.7.0.1
 */