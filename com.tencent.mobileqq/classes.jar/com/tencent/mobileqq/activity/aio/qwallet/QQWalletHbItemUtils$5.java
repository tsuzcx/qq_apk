package com.tencent.mobileqq.activity.aio.qwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class QQWalletHbItemUtils$5
  implements View.OnClickListener
{
  QQWalletHbItemUtils$5(QQWalletHbItemUtils paramQQWalletHbItemUtils) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener.a(2);
      }
      long l = System.currentTimeMillis();
      if (QWalletRedPkgUtils.a(QQWalletHbItemUtils.jdField_a_of_type_Long, l))
      {
        QQWalletHbItemUtils.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        Object localObject2 = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ((PasswdRedBagManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            localObject3 = (TroopGagMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            boolean bool = ((TroopGagMgr)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject3 = ((TroopGagMgr)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
            if ((bool) || ((localObject3 != null) && (((SelfGagInfo)localObject3).jdField_a_of_type_Boolean)))
            {
              ((PasswdRedBagManager)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject3 = ((PasswdRedBagManager)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject3 != null) && ((((PasswdRedBagInfo)localObject3).jdField_a_of_type_Boolean) || (((PasswdRedBagInfo)localObject3).b) || (((PasswdRedBagInfo)localObject3).c) || (((PasswdRedBagInfo)localObject3).jdField_a_of_type_Long < l)))
          {
            ((PasswdRedBagManager)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=13", 0, null);
            localObject1 = VoiceRedPacketHelper.b(localMessageForQQWalletMsg);
            ((PasswdRedBagManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (PasswdRedBagInfo)localObject3, l, 65536, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((PasswdRedBagInfo)localObject3).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((PasswdRedBagInfo)localObject3).b + ",isPasswdRedBagOverDue=" + ((PasswdRedBagInfo)localObject3).c);
            }
          }
          else
          {
            localObject2 = new Intent();
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
              ((Intent)localObject2).putExtra("session", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
            ((Intent)localObject2).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
            ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
            localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
            Object localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
            Object localObject5 = QWalletRedPkgUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            int j = ((Bundle)localObject5).getInt("groupType");
            localObject5 = ((Bundle)localObject5).getString("name");
            int i = 0;
            if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
              i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
            }
            localObject3 = QWalletRedPkgUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
            ((Bundle)localObject4).putString("callbackSn", "0");
            ((Intent)localObject2).putExtra("detail_bundle", (Bundle)localObject4);
            ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
            ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
            if (!(paramView.getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            PublicFragmentActivity.Launcher.a(paramView.getContext(), (Intent)localObject2, PublicTransFragmentActivity.class, RedPacketVoiceFragment.class);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + ((QQWalletRedPacketMsg)localObject1).elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils.5
 * JD-Core Version:    0.7.0.1
 */