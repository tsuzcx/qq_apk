package com.tencent.mobileqq.activity.aio.qwallet;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQWalletHbItemUtils$3
  implements View.OnClickListener
{
  QQWalletHbItemUtils$3(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(11);
      }
      long l = System.currentTimeMillis();
      if (QWalletRedPkgUtils.a(QQWalletHbItemUtils.jdField_a_of_type_Long, l))
      {
        QQWalletHbItemUtils.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            localObject = (TroopGagMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            boolean bool = ((TroopGagMgr)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject = ((TroopGagMgr)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
            if ((bool) || ((localObject != null) && (((SelfGagInfo)localObject).jdField_a_of_type_Boolean)))
            {
              localPasswdRedBagManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject = localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject != null) && ((((PasswdRedBagInfo)localObject).jdField_a_of_type_Boolean) || (((PasswdRedBagInfo)localObject).b) || (((PasswdRedBagInfo)localObject).c) || (((PasswdRedBagInfo)localObject).jdField_a_of_type_Long < l)))
          {
            localPasswdRedBagManager.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=" + localMessageForQQWalletMsg.messageType, 0, null);
            Bundle localBundle = new Bundle();
            localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
            localPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (PasswdRedBagInfo)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((PasswdRedBagInfo)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((PasswdRedBagInfo)localObject).b + ",isPasswdRedBagOverDue=" + ((PasswdRedBagInfo)localObject).c);
            }
          }
          else
          {
            DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localMessageForQQWalletMsg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils.3
 * JD-Core Version:    0.7.0.1
 */