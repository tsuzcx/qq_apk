package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemMsgBox
  extends RecentUserBaseData
{
  private QQMessageFacade.Message a;
  
  public RecentItemMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localObject1 = localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    }
    ConversationFacade localConversationFacade = paramQQAppInterface.a();
    if ((localConversationFacade != null) && (localObject1 != null))
    {
      this.jdField_c_of_type_Int = localConversationFacade.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      label85:
      if (localObject1 != null) {
        break label2394;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = new QQMessageFacade.Message();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
      localObject4 = localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "msg is null: " + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + "," + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      }
    }
    label278:
    label303:
    label376:
    label1274:
    Object localObject2;
    label547:
    label804:
    label1071:
    label2378:
    label2385:
    label2394:
    for (Object localObject4 = localObject1;; localObject4 = localObject2)
    {
      MsgSummary localMsgSummary = a();
      Object localObject3;
      if (!TextUtils.isEmpty(localObject4.senderuin))
      {
        localObject3 = localObject4.senderuin;
        if ((!AppConstants.G.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (!AppConstants.X.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
        {
          localObject1 = localObject3;
          if (!AppConstants.v.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {}
        }
        else if (AppConstants.v.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          localObject1 = ContactUtils.b(paramQQAppInterface, localObject4.senderuin, true);
        }
      }
      for (;;)
      {
        if ((localObject4.getMessageText() != null) || (localObject4.msgData != null))
        {
          this.jdField_a_of_type_Long = localObject4.time;
          if ((localObject4.msgtype != -1024) && (localObject4.msgtype != -4011) && (!DatingUtil.a(paramQQAppInterface, localObject4)) && (!DatingUtil.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)) && (!DatingUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type))) {
            break label998;
          }
          if (!AppConstants.G.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label1933;
          }
          this.jdField_b_of_type_JavaLangString = paramContext.getString(2131434026);
          this.jdField_d_of_type_JavaLangCharSequence = "";
          if (!DatingUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)) {
            break label1071;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131437897);
          this.e = paramContext.getResources().getColor(2131494288);
          if (localConversationFacade != null) {
            localMsgSummary.b = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 1001, paramContext.getResources().getString(2131437898), 0);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + ",type:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + ",hasUnreadRedPacketMsg]");
          }
          if (localObject4.msgtype != -4011) {
            break label1293;
          }
        }
        try
        {
          localObject1 = new MessageForNearbyRecommenderTips();
          ((MessageForNearbyRecommenderTips)localObject1).msgData = localObject4.msgData;
          ((MessageForNearbyRecommenderTips)localObject1).parse();
          localMsgSummary.b = paramContext.getResources().getString(2131437415);
          if ((((MessageForNearbyRecommenderTips)localObject1).strBrief != null) && (!"".equals(((MessageForNearbyRecommenderTips)localObject1).strBrief))) {
            localMsgSummary.b = ((MessageForNearbyRecommenderTips)localObject1).strBrief;
          }
          if (((MessageForNearbyRecommenderTips)localObject1).readFlag) {
            break label1274;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131437416);
          this.e = paramContext.getResources().getColor(2131494288);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + ",type:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + ",unreadNum:" + this.jdField_c_of_type_Int + "]");
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.b)
        {
          paramContext = localMsgSummary.b;
          paramQQAppInterface = paramContext;
          if (TextUtils.isEmpty(paramContext)) {
            paramQQAppInterface = this.jdField_d_of_type_JavaLangCharSequence;
          }
          paramContext = paramQQAppInterface;
          if (paramQQAppInterface == null) {
            paramContext = "";
          }
          if (this.jdField_c_of_type_Int <= 0) {
            break label2320;
          }
          if (this.jdField_b_of_type_JavaLangString == null) {
            break label2307;
          }
          paramQQAppInterface = this.jdField_b_of_type_JavaLangString;
          if (this.jdField_c_of_type_JavaLangString == null) {
            break label2313;
          }
        }
        for (localObject1 = this.jdField_c_of_type_JavaLangString;; localObject2 = "")
        {
          paramQQAppInterface = String.format("%s,%s,%d条未读,%s", new Object[] { paramQQAppInterface, localObject1, Integer.valueOf(this.jdField_c_of_type_Int), paramContext });
          this.jdField_d_of_type_JavaLangString = paramQQAppInterface;
          e();
          return;
          this.jdField_c_of_type_Int = 0;
          break label85;
          if (MsgProxyUtils.c(localObject4.senderuin))
          {
            localObject1 = localObject3;
            if (localQQMessageFacade == null) {
              break label2385;
            }
            QQMessageFacade.Message localMessage = localQQMessageFacade.a(localObject4.senderuin, localObject4.istroop);
            localObject1 = localObject3;
            if (localMessage != null)
            {
              localObject3 = ContactUtils.q(paramQQAppInterface, localMessage.senderuin);
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, false);
              }
            }
            break label278;
          }
          localObject3 = ContactUtils.q(paramQQAppInterface, localObject4.senderuin);
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label2385;
          }
          localObject1 = ContactUtils.b(paramQQAppInterface, localObject4.senderuin, false);
          break label278;
          this.jdField_a_of_type_Long = 0L;
          break label303;
          label998:
          boolean bool = false;
          if (AppConstants.G.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            bool = true;
          }
          if (localObject4.isSend())
          {
            MsgUtils.a(paramContext, paramQQAppInterface, localObject4, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, null, bool, false);
            break label376;
          }
          MsgUtils.a(paramContext, paramQQAppInterface, localObject4, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject1, bool, false);
          break label376;
          if (DatingUtil.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type))
          {
            this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131438802);
            this.e = paramContext.getResources().getColor(2131494288);
            if (!QLog.isColorLevel()) {
              break label547;
            }
            QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + ",type:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + ",hasUnreadGiftMsg]");
            break label547;
          }
          if (!DatingUtil.a(paramQQAppInterface, localObject4)) {
            break label547;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131437967);
          this.e = paramContext.getResources().getColor(2131494288);
          if (!QLog.isColorLevel()) {
            break label547;
          }
          QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + ",type:" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + ",hasHelloMsg]");
          break label547;
          this.jdField_d_of_type_JavaLangCharSequence = "";
          break label661;
          if (localObject4.msgtype == -2053)
          {
            localObject2 = (MessageForNearbyLiveTip)paramQQAppInterface.a().a(localObject4.senderuin, localObject4.istroop, localObject4.uniseq);
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg_box.item_data", 2, "msg.msgtype == MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP, tip = null");
              return;
            }
            ((MessageForNearbyLiveTip)localObject2).parse();
            localMsgSummary.a = null;
            this.jdField_b_of_type_Int = 1;
            localObject3 = paramContext.getResources().getString(2131437862);
            if (!TextUtils.isEmpty(((MessageForNearbyLiveTip)localObject2).c2cMsgWording))
            {
              localMsgSummary.b = ((MessageForNearbyLiveTip)localObject2).c2cMsgWording;
              this.jdField_c_of_type_JavaLangCharSequence = ((MessageForNearbyLiveTip)localObject2).c2cMsgWording;
              break label661;
            }
            if (((MessageForNearbyLiveTip)localObject2).isLiving)
            {
              localMsgSummary.b = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
              this.jdField_c_of_type_JavaLangCharSequence = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
              break label661;
            }
            if (MessageForNearbyLiveTip.isHuayangTip(((MessageForNearbyLiveTip)localObject2).jumpingUrl))
            {
              localMsgSummary.b = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).liveEndWording);
              this.jdField_c_of_type_JavaLangCharSequence = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).liveEndWording);
              break label661;
            }
            localMsgSummary.b = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + "的" + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
            this.jdField_c_of_type_JavaLangCharSequence = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + "的" + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
            break label661;
          }
          if (localObject4.msgtype == -2055)
          {
            localObject2 = (MessageForInteractAndFollow)paramQQAppInterface.a().a(localObject4.senderuin, localObject4.istroop, localObject4.uniseq);
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg_box.item_data", 2, "interactAndFollow == null");
              return;
            }
            ((MessageForInteractAndFollow)localObject2).parse();
            localMsgSummary.a = null;
            localMsgSummary.b = ((MessageForInteractAndFollow)localObject2).context;
            this.jdField_c_of_type_JavaLangCharSequence = ((MessageForInteractAndFollow)localObject2).context;
            this.jdField_c_of_type_Int = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
            if ((this.jdField_c_of_type_Int > 0) || (localConversationFacade == null)) {
              break label661;
            }
            this.jdField_c_of_type_Int = localConversationFacade.b();
            this.jdField_b_of_type_Int = 3;
            break label661;
          }
          if (localQQMessageFacade != null)
          {
            this.jdField_b_of_type_Int = 1;
            this.jdField_c_of_type_Int = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
            if ((this.jdField_c_of_type_Int <= 0) && (localConversationFacade != null))
            {
              this.jdField_c_of_type_Int = localConversationFacade.b();
              this.jdField_b_of_type_Int = 3;
            }
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (DatingUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)) || (!DatingUtil.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type))) {
            break label661;
          }
          localMsgSummary.b = paramContext.getString(2131434027);
          break label661;
          if (AppConstants.X.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131437594);
            if (localQQMessageFacade != null)
            {
              this.jdField_b_of_type_Int = 1;
              this.jdField_c_of_type_Int = localConversationFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              if ((this.jdField_c_of_type_Int <= 0) && (localConversationFacade != null))
              {
                this.jdField_c_of_type_Int = localConversationFacade.a(AppConstants.af, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
                this.jdField_b_of_type_Int = 3;
              }
            }
            if ((localObject4.msg == null) || (-999 == localObject4.msgtype))
            {
              localMsgSummary.b = paramContext.getString(2131437595);
              localObject3 = localObject2;
            }
            for (;;)
            {
              DatingUtil.a("data_recent_msg", new Object[] { localObject3, localMsgSummary.b });
              break;
              localObject3 = localObject2;
              if (localObject4.msgtype == -1024)
              {
                localObject3 = localObject2;
                if (localObject2 != null)
                {
                  localObject3 = localObject2;
                  if (((String)localObject2).length() > 12) {
                    localObject3 = ((String)localObject2).substring(0, 11) + "...";
                  }
                }
                if (localObject4.isSendFromLocal()) {
                  localMsgSummary.b = paramContext.getString(2131437665, new Object[] { localObject3 });
                } else {
                  localMsgSummary.b = paramContext.getString(2131437666, new Object[] { localObject3 });
                }
              }
            }
          }
          if (AppConstants.v.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131434034);
            if (localQQMessageFacade != null) {
              this.jdField_c_of_type_Int = localQQMessageFacade.c();
            }
            if ((-999 != localObject4.msgtype) && (localObject4.msg != null)) {
              break label661;
            }
            localMsgSummary.b = paramContext.getString(2131434035);
            break label661;
          }
          this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          break label661;
          paramQQAppInterface = "";
          break label804;
        }
        if (this.jdField_b_of_type_JavaLangString != null)
        {
          paramQQAppInterface = this.jdField_b_of_type_JavaLangString;
          if (this.jdField_c_of_type_JavaLangString == null) {
            break label2378;
          }
        }
        for (localObject2 = this.jdField_c_of_type_JavaLangString;; localObject2 = "")
        {
          paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, localObject2, paramContext });
          break;
          paramQQAppInterface = "";
          break label2332;
        }
        continue;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox
 * JD-Core Version:    0.7.0.1
 */