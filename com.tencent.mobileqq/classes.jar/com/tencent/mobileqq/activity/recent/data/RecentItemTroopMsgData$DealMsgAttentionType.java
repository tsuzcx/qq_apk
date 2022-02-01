package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopEffectPicMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopGamePartyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHasGiftMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopKeyWordMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNewFileMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopPubAccountMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;

class RecentItemTroopMsgData$DealMsgAttentionType
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopAioNavigateBarManager jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public RecentItemTroopMsgData$DealMsgAttentionType(RecentItemTroopMsgData paramRecentItemTroopMsgData, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, TroopAioNavigateBarManager paramTroopAioNavigateBarManager, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager = paramTroopAioNavigateBarManager;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramBoolean;
  }
  
  private void a(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if ((MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForFuDai)) || ((this.jdField_a_of_type_JavaLangObject instanceof TroopAtAllMsg))) {}
    do
    {
      do
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof TroopNotificationMsg)) {
          break;
        }
        if (((TroopNotificationMsg)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg).c == 1)
        {
          this.jdField_a_of_type_Int = 2131167117;
          return;
        }
      } while (!TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin));
      this.jdField_a_of_type_Int = 2131167117;
      return;
      if (((this.jdField_a_of_type_JavaLangObject instanceof TroopHomeworkSpecialMsg)) && (((TroopHomeworkSpecialMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697428))))
      {
        this.jdField_a_of_type_Int = 2131167117;
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof TroopNewFileMsg)) && (((TroopNewFileMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697413))))
      {
        this.jdField_a_of_type_Int = 2131167117;
        return;
      }
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof TroopGamePartyMsg)) || ((!((TroopGamePartyMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697409))) && (!((TroopGamePartyMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131692832)))));
    this.jdField_a_of_type_Int = 2131167117;
  }
  
  private void b(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramAbstructRecentUserMsg = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramAbstructRecentUserMsg.messageType == 7) || (paramAbstructRecentUserMsg.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131719041);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramAbstructRecentUserMsg = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramAbstructRecentUserMsg))
        {
          paramAbstructRecentUserMsg = HardCodeUtil.a(2131713146) + paramAbstructRecentUserMsg + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramAbstructRecentUserMsg;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof TroopNotificationMsg))
      {
        paramMessageRecord = (TroopNotificationMsg)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg;
        TroopNotificationFlagMsg localTroopNotificationFlagMsg = TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
        if (paramMessageRecord.c == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131697307);
          return;
        }
        if (TroopNotificationHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramAbstructRecentUserMsg.a;
          return;
        }
        if (localTroopNotificationFlagMsg != null)
        {
          if (localTroopNotificationFlagMsg.a.isEmpty())
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = paramAbstructRecentUserMsg.a;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof TroopHasGiftMsg))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof TroopReceivedFlowsersMsg)) && (((TroopReceivedFlowsersMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697411))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof TroopEffectPicMsg)) && (((TroopEffectPicMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697414))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((this.jdField_a_of_type_JavaLangObject instanceof TroopPubAccountMsg)) && (((TroopPubAccountMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697416))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof TroopKeyWordMsg));
    this.b = true;
  }
  
  private void c(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramAbstructRecentUserMsg = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramAbstructRecentUserMsg.messageType == 7) || (paramAbstructRecentUserMsg.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = this.jdField_a_of_type_AndroidContentContext.getString(2131719041);
      }
    }
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        ((MessageForFuDai)paramMessageRecord).parse();
        paramAbstructRecentUserMsg = ((MessageForFuDai)paramMessageRecord).highlightMsg();
        if (!TextUtils.isEmpty(paramAbstructRecentUserMsg))
        {
          paramAbstructRecentUserMsg = HardCodeUtil.a(2131713146) + paramAbstructRecentUserMsg + "]";
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramAbstructRecentUserMsg;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof TroopAtAllMsg))
      {
        paramAbstructRecentUserMsg = String.format(HardCodeUtil.a(2131713119), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mTitleName });
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramAbstructRecentUserMsg;
        return;
      }
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof TroopKeyWordMsg));
    this.b = true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DealMsgAttentionType a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof AbstructRecentUserMsg))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum == 0) && (!(this.jdField_a_of_type_JavaLangObject instanceof TroopNotificationMsg)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      AbstructRecentUserMsg localAbstructRecentUserMsg = (AbstructRecentUserMsg)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = localAbstructRecentUserMsg.a;
      this.jdField_a_of_type_Int = 2131167145;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = localAbstructRecentUserMsg.b;
      long l = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
      MessageRecord localMessageRecord = null;
      if (l != 0L) {
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.getType(), l);
      }
      a(localAbstructRecentUserMsg, localMessageRecord);
      b(localAbstructRecentUserMsg, localMessageRecord);
      c(localAbstructRecentUserMsg, localMessageRecord);
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData.DealMsgAttentionType
 * JD-Core Version:    0.7.0.1
 */