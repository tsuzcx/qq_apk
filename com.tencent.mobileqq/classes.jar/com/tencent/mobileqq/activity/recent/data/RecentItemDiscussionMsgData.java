package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemDiscussionMsgData
  extends RecentUserBaseData
{
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a(Context paramContext)
  {
    if (a().msg == null) {
      this.jdField_d_of_type_JavaLangString = "";
    }
    for (;;)
    {
      return;
      if ((a().msg instanceof AbstructRecentUserMsg))
      {
        AbstructRecentUserMsg localAbstructRecentUserMsg = (AbstructRecentUserMsg)a().msg;
        this.jdField_d_of_type_JavaLangCharSequence = localAbstructRecentUserMsg.a;
        this.jdField_d_of_type_JavaLangString = localAbstructRecentUserMsg.jdField_b_of_type_JavaLangString;
        if ((a().msg instanceof TroopAtAllMsg)) {
          this.jdField_d_of_type_JavaLangString = String.format("与%s的会话，有全体消息", new Object[] { this.jdField_b_of_type_JavaLangString });
        }
      }
      for (int i = 2131494288; (!android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) && (i > 0); i = 0)
      {
        this.e = paramContext.getResources().getColor(i);
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localObject1 = null)
    {
      if (localObject1 != null) {
        if ((((QQMessageFacade.Message)localObject1).istroop == 3000) && (((QQMessageFacade.Message)localObject1).msg == null) && (((QQMessageFacade.Message)localObject1).time == 0L)) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
        }
      }
      for (;;)
      {
        Object localObject3 = paramQQAppInterface.a();
        if (localObject3 != null)
        {
          this.jdField_c_of_type_Int = ((ConversationFacade)localObject3).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          label125:
          localObject3 = QCallFacade.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, this.jdField_c_of_type_Int, (QQMessageFacade.Message)localObject1);
          this.jdField_c_of_type_Int += ((QCallFacade.CallUnreadCountInfo)localObject3).a();
          if (((QCallFacade.CallUnreadCountInfo)localObject3).a() > 0)
          {
            this.jdField_d_of_type_JavaLangCharSequence = ((QCallFacade.CallUnreadCountInfo)localObject3).a();
            this.e = paramContext.getResources().getColor(2131494288);
          }
          label191:
          localObject3 = (DiscussionManager)paramQQAppInterface.getManager(52);
          if (localObject3 != null) {
            localObject2 = ((DiscussionManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          }
          if ((this.jdField_c_of_type_Int <= 0) || (!MsgProxyUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type))) {
            break label766;
          }
          this.jdField_b_of_type_Int = 3;
          if ((localObject2 != null) || (TimeManager.a().b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {}
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          ((DiscussionHandler)paramQQAppInterface.a(6)).a(l);
          TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          if ((localObject1 != null) && (!android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).senderuin)))
          {
            if (((QQMessageFacade.Message)localObject1).senderuin.equals(((QQMessageFacade.Message)localObject1).frienduin)) {
              ((QQMessageFacade.Message)localObject1).nickName = "";
            }
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            if (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramContext, (DiscussionInfo)localObject2);
            }
            if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangCharSequence = new QQText(this.jdField_b_of_type_JavaLangString, 1);
            }
            MsgSummary localMsgSummary = a();
            a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            localObject2 = "";
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              int i = ((DiscussionManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              localObject1 = localObject2;
              if (i > 0) {
                localObject1 = "(" + i + ")";
              }
            }
            this.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
            a(paramQQAppInterface);
            a(paramQQAppInterface, localMsgSummary);
            if (((a().msg instanceof TroopReceiptMsg)) && (this.jdField_c_of_type_Int > 0))
            {
              localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
              localMsgSummary.jdField_a_of_type_JavaLangCharSequence = "";
            }
            a(paramQQAppInterface, paramContext, localMsgSummary);
            if (localMsgSummary.jdField_a_of_type_Boolean) {
              break label879;
            }
            a(paramContext);
            paramQQAppInterface = a();
            if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
              paramQQAppInterface.reParse();
            }
            if (AppSetting.b)
            {
              if (this.jdField_b_of_type_JavaLangString == null) {
                break label912;
              }
              paramQQAppInterface = this.jdField_b_of_type_JavaLangString + "多人聊天";
              paramContext = new StringBuilder();
              paramContext.append(paramQQAppInterface).append(",");
              if (this.jdField_c_of_type_Int != 0) {
                break label919;
              }
              if (this.jdField_d_of_type_JavaLangCharSequence != null) {
                paramContext.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
              }
              paramContext.append(com.tencent.mobileqq.text.TextUtils.d(this.jdField_c_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
              this.jdField_d_of_type_JavaLangString = paramContext.toString();
            }
            e();
            return;
            this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
            continue;
            this.jdField_c_of_type_Int = 0;
            break label125;
            this.jdField_c_of_type_Int = 0;
            this.jdField_a_of_type_Long = 0L;
            break label191;
            label766:
            this.jdField_b_of_type_Int = 1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("discussion", 2, localNumberFormatException.toString());
              continue;
              if (!android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).frienduin)) {
                ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).senderuin, (MessageRecord)localObject1);
              }
              if (android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
                ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, true);
              }
              label912:
              label919:
              if (android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName))
              {
                ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
                continue;
                label879:
                if ((a().msg instanceof AbstructRecentUserMsg))
                {
                  this.jdField_d_of_type_JavaLangCharSequence = ((AbstructRecentUserMsg)a().msg).a;
                  continue;
                  paramQQAppInterface = "多人聊天";
                  continue;
                  if (this.jdField_c_of_type_Int == 1) {
                    paramContext.append("有一条未读");
                  } else if (this.jdField_c_of_type_Int == 2) {
                    paramContext.append("有两条未读");
                  } else if (this.jdField_c_of_type_Int > 0) {
                    paramContext.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */