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
    if ((!MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) && (!(paramMessageRecord instanceof MessageForFuDai)))
    {
      if ((this.jdField_a_of_type_JavaLangObject instanceof TroopAtAllMsg)) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg instanceof TroopNotificationMsg))
      {
        if (((TroopNotificationMsg)this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.a().msg).c == 1)
        {
          this.jdField_a_of_type_Int = 2131167142;
          return;
        }
        if (TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin)) {
          this.jdField_a_of_type_Int = 2131167142;
        }
      }
      else
      {
        paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
        if (((paramAbstructRecentUserMsg instanceof TroopHomeworkSpecialMsg)) && (((TroopHomeworkSpecialMsg)paramAbstructRecentUserMsg).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697447))))
        {
          this.jdField_a_of_type_Int = 2131167142;
          return;
        }
        paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
        if (((paramAbstructRecentUserMsg instanceof TroopNewFileMsg)) && (((TroopNewFileMsg)paramAbstructRecentUserMsg).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697432))))
        {
          this.jdField_a_of_type_Int = 2131167142;
          return;
        }
        paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
        if (((paramAbstructRecentUserMsg instanceof TroopGamePartyMsg)) && ((((TroopGamePartyMsg)paramAbstructRecentUserMsg).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697428))) || (((TroopGamePartyMsg)this.jdField_a_of_type_JavaLangObject).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131692786))))) {
          this.jdField_a_of_type_Int = 2131167142;
        }
      }
    }
  }
  
  private void b(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramAbstructRecentUserMsg = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramAbstructRecentUserMsg.messageType == 7) || (paramAbstructRecentUserMsg.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131718757);
      }
    }
    else
    {
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        paramAbstructRecentUserMsg = (MessageForFuDai)paramMessageRecord;
        paramAbstructRecentUserMsg.parse();
        paramAbstructRecentUserMsg = paramAbstructRecentUserMsg.highlightMsg();
        if (!TextUtils.isEmpty(paramAbstructRecentUserMsg))
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append(HardCodeUtil.a(2131713121));
          paramMessageRecord.append(paramAbstructRecentUserMsg);
          paramMessageRecord.append("]");
          paramAbstructRecentUserMsg = paramMessageRecord.toString();
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
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = this.jdField_a_of_type_AndroidContentContext.getString(2131697326);
          return;
        }
        if (TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin))
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
      paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
      if ((paramAbstructRecentUserMsg instanceof TroopHasGiftMsg))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if (((paramAbstructRecentUserMsg instanceof TroopReceivedFlowsersMsg)) && (((TroopReceivedFlowsersMsg)paramAbstructRecentUserMsg).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697430))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
      if (((paramAbstructRecentUserMsg instanceof TroopEffectPicMsg)) && (((TroopEffectPicMsg)paramAbstructRecentUserMsg).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697433))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
      if (((paramAbstructRecentUserMsg instanceof TroopPubAccountMsg)) && (((TroopPubAccountMsg)paramAbstructRecentUserMsg).a.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131697435))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = "";
        return;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof TroopKeyWordMsg)) {
        this.b = true;
      }
    }
  }
  
  private void c(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramAbstructRecentUserMsg = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramAbstructRecentUserMsg.messageType == 7) || (paramAbstructRecentUserMsg.messageType == 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = this.jdField_a_of_type_AndroidContentContext.getString(2131718757);
      }
    }
    else
    {
      if ((paramMessageRecord instanceof MessageForFuDai))
      {
        paramAbstructRecentUserMsg = (MessageForFuDai)paramMessageRecord;
        paramAbstructRecentUserMsg.parse();
        paramAbstructRecentUserMsg = paramAbstructRecentUserMsg.highlightMsg();
        if (!TextUtils.isEmpty(paramAbstructRecentUserMsg))
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append(HardCodeUtil.a(2131713121));
          paramMessageRecord.append(paramAbstructRecentUserMsg);
          paramMessageRecord.append("]");
          paramAbstructRecentUserMsg = paramMessageRecord.toString();
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramAbstructRecentUserMsg;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = "";
        return;
      }
      paramAbstructRecentUserMsg = this.jdField_a_of_type_JavaLangObject;
      if ((paramAbstructRecentUserMsg instanceof TroopAtAllMsg))
      {
        paramAbstructRecentUserMsg = String.format(HardCodeUtil.a(2131713094), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mTitleName });
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = paramAbstructRecentUserMsg;
        return;
      }
      if ((paramAbstructRecentUserMsg instanceof TroopKeyWordMsg)) {
        this.b = true;
      }
    }
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dealMsgAttention, mUnreadNum:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUnreadNum);
          QLog.d("RecentItemTroopMsgData", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData;
        ((RecentItemTroopMsgData)localObject).mMsgExtroInfo = "";
        ((RecentItemTroopMsgData)localObject).mContentDesc = "";
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      AbstructRecentUserMsg localAbstructRecentUserMsg = (AbstructRecentUserMsg)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mMsgExtroInfo = localAbstructRecentUserMsg.a;
      this.jdField_a_of_type_Int = 2131167170;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mContentDesc = localAbstructRecentUserMsg.b;
      long l = this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin);
      Object localObject = null;
      if (l != 0L) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.uin, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemTroopMsgData.mUser.getType(), l);
      }
      a(localAbstructRecentUserMsg, (MessageRecord)localObject);
      b(localAbstructRecentUserMsg, (MessageRecord)localObject);
      c(localAbstructRecentUserMsg, (MessageRecord)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData.DealMsgAttentionType
 * JD-Core Version:    0.7.0.1
 */