package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RecentItemTroopMsgData
  extends RecentUserBaseData
{
  public long b;
  public boolean c;
  private boolean d;
  
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Long = 5L;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    try
    {
      l = Long.parseLong(a());
      this.jdField_a_of_type_Boolean = paramQQAppInterface.a().c(l);
      boolean bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = paramQQAppInterface.a().b(l);
      Object localObject;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = (TroopVideoManager)paramQQAppInterface.getManager(163);
        if ((localObject != null) && (((TroopVideoManager)localObject).a(a()) == 2)) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      if ((this.jdField_b_of_type_Boolean) && (!bool))
      {
        localObject = String.valueOf(l);
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + TroopUtils.a(paramQQAppInterface, (String)localObject), "", "");
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject3 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localMessage = null)
    {
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.jdField_c_of_type_Int = ((ConversationFacade)localObject1).a(localMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
          localObject1 = QCallFacade.a(paramQQAppInterface, localMessage.frienduin, localMessage.istroop, this.jdField_c_of_type_Int, localMessage);
          this.jdField_c_of_type_Int += ((QCallFacade.CallUnreadCountInfo)localObject1).a();
          if (((QCallFacade.CallUnreadCountInfo)localObject1).a() > 0)
          {
            this.jdField_d_of_type_JavaLangCharSequence = ((QCallFacade.CallUnreadCountInfo)localObject1).a();
            this.e = paramContext.getResources().getColor(2131494288);
          }
        }
      }
      TroopManager localTroopManager;
      label708:
      boolean bool;
      for (;;)
      {
        localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
        HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(59);
        HotChatInfo localHotChatInfo = localHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (localHotChatInfo == null) {
          break label898;
        }
        this.jdField_b_of_type_Int = 3;
        this.jdField_b_of_type_JavaLangString = localHotChatInfo.name;
        localObject1 = null;
        localObject3 = a();
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if ((localHotChatInfo == null) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.a() == 1) && (android.text.TextUtils.isEmpty(((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence)) && (android.text.TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        if (((a().msg instanceof TroopReceiptMsg)) && (this.jdField_c_of_type_Int > 0))
        {
          ((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence = "";
          ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence = "";
        }
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if ((((MsgSummary)localObject3).jdField_a_of_type_Boolean) && (a().msg == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentItemTroopMsgData.troop.special_msg.special_attention", 2, "msgSummary.bShowDraft && (null == getRecentUser().msg)");
          }
          this.jdField_d_of_type_JavaLangCharSequence = "";
        }
        if (!((MsgSummary)localObject3).jdField_a_of_type_Boolean) {
          b(paramQQAppInterface, paramContext);
        }
        if (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          paramQQAppInterface = localHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if ((paramQQAppInterface != null) && (!android.text.TextUtils.isEmpty(paramQQAppInterface.memo)) && (!paramQQAppInterface.memoShowed))
          {
            this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131433507);
            this.e = paramContext.getResources().getColor(2131494288);
          }
        }
        if ((android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) && (localMessage != null) && (localObject3 != null) && (AnonymousChatHelper.a(localMessage))) {
          this.jdField_c_of_type_JavaLangCharSequence = ((MsgSummary)localObject3).a(paramContext, paramContext.getResources().getString(2131430287), -1);
        }
        paramQQAppInterface = a();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
          paramQQAppInterface.reParse();
        }
        TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_Long);
        if (localTroopManager != null)
        {
          paramQQAppInterface = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (paramQQAppInterface != null)
          {
            this.jdField_b_of_type_Long = paramQQAppInterface.troopCreditLevel;
            if (this.jdField_b_of_type_Long == 0L) {
              this.jdField_b_of_type_Long = 5L;
            }
            if (QLog.isColorLevel()) {
              QLog.i("troop.credit.act", 2, "RecentItemTroopMsgData->update," + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + "," + this.jdField_b_of_type_Long);
            }
          }
        }
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
          if (this.jdField_c_of_type_Int != 0) {
            break label1136;
          }
          if (this.jdField_d_of_type_JavaLangCharSequence != null) {
            paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
          }
          paramQQAppInterface.append(com.tencent.mobileqq.text.TextUtils.d(this.jdField_c_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
          this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
        }
        if ((localMessage != null) && (localMessage.msgtype == -5021))
        {
          paramQQAppInterface = this.jdField_c_of_type_JavaLangCharSequence.toString();
          paramContext = paramContext.getString(2131433101);
          if (paramQQAppInterface.endsWith(paramContext)) {
            this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.subSequence(0, paramQQAppInterface.length() - paramContext.length() - 1);
          }
        }
        paramQQAppInterface = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((paramQQAppInterface == null) || (!paramQQAppInterface.hasOrgs())) {
          break label1205;
        }
        bool = true;
        label870:
        this.jdField_d_of_type_Boolean = bool;
        return;
        this.jdField_c_of_type_Int = 0;
        break;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_c_of_type_Int = 0;
      }
      label898:
      int i = this.f;
      if (localTroopManager != null) {}
      for (Object localObject2 = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject2 = null)
      {
        if (localObject2 != null) {
          localObject3 = ((TroopInfo)localObject2).getTroopName();
        }
        for (localObject1 = ((TroopInfo)localObject2).troopmemo;; localObject1 = null)
        {
          this.f = (i & 0xFFFFF0FF | 0x100);
          i = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if ((i == 1) || (this.jdField_c_of_type_Boolean))
          {
            this.jdField_b_of_type_Int = 1;
            label983:
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
              break label1118;
            }
          }
          label1118:
          for (this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);; this.jdField_b_of_type_JavaLangString = ((String)localObject3))
          {
            if ((localMessage != null) && (android.text.TextUtils.isEmpty(localMessage.nickName))) {
              localMessage.nickName = localMessage.senderuin;
            }
            e();
            if ((localObject2 == null) || (((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
              break label1127;
            }
            this.jdField_b_of_type_JavaLangCharSequence = ("(" + ((TroopInfo)localObject2).wMemberNumClient + ")");
            break;
            if ((i != 2) && (i != 3) && (i != 4)) {
              break label983;
            }
            this.jdField_b_of_type_Int = 3;
            break label983;
          }
          label1127:
          this.jdField_b_of_type_JavaLangCharSequence = "";
          break;
          label1136:
          if (this.jdField_c_of_type_Int == 1)
          {
            paramQQAppInterface.append("有一条未读");
            break label708;
          }
          if (this.jdField_c_of_type_Int == 2)
          {
            paramQQAppInterface.append("有两条未读");
            break label708;
          }
          if (this.jdField_c_of_type_Int <= 0) {
            break label708;
          }
          paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
          break label708;
          label1205:
          bool = false;
          break label870;
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser == null) {}
    label597:
    label600:
    for (;;)
    {
      return;
      Object localObject1 = (TroopInfoManager)paramQQAppInterface.getManager(36);
      Object localObject2 = a().msg;
      AbstructRecentUserMsg localAbstructRecentUserMsg;
      int i;
      if (localObject2 != null)
      {
        if (!(localObject2 instanceof AbstructRecentUserMsg)) {
          break label597;
        }
        if ((this.jdField_c_of_type_Int == 0) && (!(localObject2 instanceof TroopNotificationMsg)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + this.jdField_c_of_type_Int);
          }
          this.jdField_d_of_type_JavaLangCharSequence = "";
          this.jdField_d_of_type_JavaLangString = "";
          return;
        }
        localAbstructRecentUserMsg = (AbstructRecentUserMsg)localObject2;
        this.jdField_d_of_type_JavaLangCharSequence = localAbstructRecentUserMsg.a;
        this.jdField_d_of_type_JavaLangString = localAbstructRecentUserMsg.jdField_b_of_type_JavaLangString;
        long l = ((TroopInfoManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        localObject1 = null;
        if (l != 0L) {
          localObject1 = paramQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, l);
        }
        if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject1))
        {
          paramQQAppInterface = (MessageForQQWalletMsg)localObject1;
          if ((paramQQAppInterface.messageType == 7) || (paramQQAppInterface.messageType == 8))
          {
            this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131437904);
            this.jdField_d_of_type_JavaLangString = paramContext.getString(2131437904);
            i = 2131494288;
          }
        }
      }
      for (;;)
      {
        if ((android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) || (i <= 0)) {
          break label600;
        }
        this.e = paramContext.getResources().getColor(i);
        return;
        this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131437907);
        this.jdField_d_of_type_JavaLangString = paramContext.getString(2131437907);
        break;
        if ((localObject2 instanceof TroopAtAllMsg))
        {
          this.jdField_d_of_type_JavaLangString = String.format("与%s群的会话，有全体消息", new Object[] { this.jdField_b_of_type_JavaLangString });
          break;
        }
        if (!(a().msg instanceof TroopNotificationMsg)) {
          break;
        }
        if (((TroopNotificationMsg)a().msg).jdField_c_of_type_Int == 1)
        {
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131433510);
          break;
        }
        if ((TroopNotificationHelper.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) || (TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
        {
          this.jdField_d_of_type_JavaLangCharSequence = localAbstructRecentUserMsg.a;
          break;
        }
        this.jdField_d_of_type_JavaLangCharSequence = "";
        break;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131430827);
        }
        for (int j = 2131494288;; j = 0)
        {
          int k = ((TroopInfoManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (QLog.isColorLevel()) {
            QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, navigateMsgType:" + k + ", mUnreadNum:" + this.jdField_c_of_type_Int);
          }
          i = j;
          if (k != 15) {
            break;
          }
          i = j;
          if (this.jdField_c_of_type_Int == 0) {
            break;
          }
          paramQQAppInterface = ((TroopInfoManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 15);
          i = j;
          if (paramQQAppInterface == null) {
            break;
          }
          i = j;
          if (paramQQAppInterface.size() == 0) {
            break;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131433159);
          this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangCharSequence.toString();
          i = 2131494288;
          break;
          this.jdField_d_of_type_JavaLangCharSequence = "";
          this.jdField_d_of_type_JavaLangString = "";
        }
        i = 0;
      }
    }
  }
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */