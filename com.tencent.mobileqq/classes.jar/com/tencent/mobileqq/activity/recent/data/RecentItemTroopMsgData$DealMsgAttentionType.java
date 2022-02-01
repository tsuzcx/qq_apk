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
  private boolean b;
  private QQAppInterface c;
  private Context d;
  private int e;
  private TroopAioNavigateBarManager f;
  private Object g;
  private boolean h;
  
  public RecentItemTroopMsgData$DealMsgAttentionType(RecentItemTroopMsgData paramRecentItemTroopMsgData, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, TroopAioNavigateBarManager paramTroopAioNavigateBarManager, Object paramObject, boolean paramBoolean)
  {
    this.c = paramQQAppInterface;
    this.d = paramContext;
    this.e = paramInt;
    this.f = paramTroopAioNavigateBarManager;
    this.g = paramObject;
    this.h = paramBoolean;
  }
  
  private void a(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if ((!MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) && (!(paramMessageRecord instanceof MessageForFuDai)))
    {
      if ((this.g instanceof TroopAtAllMsg)) {
        return;
      }
      if ((this.a.e().msg instanceof TroopNotificationMsg))
      {
        if (((TroopNotificationMsg)this.a.e().msg).i == 1)
        {
          this.e = 2131168122;
          return;
        }
        if (TroopNotificationHelper.c(this.a.mUser.uin)) {
          this.e = 2131168122;
        }
      }
      else
      {
        paramAbstructRecentUserMsg = this.g;
        if (((paramAbstructRecentUserMsg instanceof TroopHomeworkSpecialMsg)) && (((TroopHomeworkSpecialMsg)paramAbstructRecentUserMsg).c.equalsIgnoreCase(this.d.getString(2131895220))))
        {
          this.e = 2131168122;
          return;
        }
        paramAbstructRecentUserMsg = this.g;
        if (((paramAbstructRecentUserMsg instanceof TroopNewFileMsg)) && (((TroopNewFileMsg)paramAbstructRecentUserMsg).c.equalsIgnoreCase(this.d.getString(2131895205))))
        {
          this.e = 2131168122;
          return;
        }
        paramAbstructRecentUserMsg = this.g;
        if (((paramAbstructRecentUserMsg instanceof TroopGamePartyMsg)) && ((((TroopGamePartyMsg)paramAbstructRecentUserMsg).c.equalsIgnoreCase(this.d.getString(2131895201))) || (((TroopGamePartyMsg)this.g).c.equalsIgnoreCase(this.d.getString(2131889879))))) {
          this.e = 2131168122;
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
        this.a.mMsgExtroInfo = this.d.getString(2131916263);
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
          paramMessageRecord.append(HardCodeUtil.a(2131910680));
          paramMessageRecord.append(paramAbstructRecentUserMsg);
          paramMessageRecord.append("]");
          paramAbstructRecentUserMsg = paramMessageRecord.toString();
          this.a.mMsgExtroInfo = paramAbstructRecentUserMsg;
          return;
        }
        this.a.mMsgExtroInfo = "";
        return;
      }
      if ((this.a.e().msg instanceof TroopNotificationMsg))
      {
        paramMessageRecord = (TroopNotificationMsg)this.a.e().msg;
        TroopNotificationFlagMsg localTroopNotificationFlagMsg = TroopNotificationHelper.d(this.c, this.a.mUser.uin);
        if (paramMessageRecord.i == 1)
        {
          this.a.mMsgExtroInfo = this.d.getString(2131895099);
          return;
        }
        if (TroopNotificationHelper.c(this.a.mUser.uin))
        {
          this.a.mMsgExtroInfo = paramAbstructRecentUserMsg.c;
          return;
        }
        if (localTroopNotificationFlagMsg != null)
        {
          if (localTroopNotificationFlagMsg.a.isEmpty())
          {
            this.a.mMsgExtroInfo = "";
            return;
          }
          this.a.mMsgExtroInfo = paramAbstructRecentUserMsg.c;
          return;
        }
        this.a.mMsgExtroInfo = "";
        return;
      }
      paramAbstructRecentUserMsg = this.g;
      if ((paramAbstructRecentUserMsg instanceof TroopHasGiftMsg))
      {
        this.a.mMsgExtroInfo = "";
        return;
      }
      if (((paramAbstructRecentUserMsg instanceof TroopReceivedFlowsersMsg)) && (((TroopReceivedFlowsersMsg)paramAbstructRecentUserMsg).c.equalsIgnoreCase(this.d.getString(2131895203))))
      {
        this.a.mMsgExtroInfo = "";
        return;
      }
      paramAbstructRecentUserMsg = this.g;
      if (((paramAbstructRecentUserMsg instanceof TroopEffectPicMsg)) && (((TroopEffectPicMsg)paramAbstructRecentUserMsg).c.equalsIgnoreCase(this.d.getString(2131895206))))
      {
        this.a.mMsgExtroInfo = "";
        return;
      }
      paramAbstructRecentUserMsg = this.g;
      if (((paramAbstructRecentUserMsg instanceof TroopPubAccountMsg)) && (((TroopPubAccountMsg)paramAbstructRecentUserMsg).c.equalsIgnoreCase(this.d.getString(2131895208))))
      {
        this.a.mMsgExtroInfo = "";
        return;
      }
      if ((this.g instanceof TroopKeyWordMsg)) {
        this.h = true;
      }
    }
  }
  
  private void c(AbstructRecentUserMsg paramAbstructRecentUserMsg, MessageRecord paramMessageRecord)
  {
    if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))
    {
      paramAbstructRecentUserMsg = (MessageForQQWalletMsg)paramMessageRecord;
      if ((paramAbstructRecentUserMsg.messageType == 7) || (paramAbstructRecentUserMsg.messageType == 8)) {
        this.a.mContentDesc = this.d.getString(2131916263);
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
          paramMessageRecord.append(HardCodeUtil.a(2131910680));
          paramMessageRecord.append(paramAbstructRecentUserMsg);
          paramMessageRecord.append("]");
          paramAbstructRecentUserMsg = paramMessageRecord.toString();
          this.a.mContentDesc = paramAbstructRecentUserMsg;
          return;
        }
        this.a.mContentDesc = "";
        return;
      }
      paramAbstructRecentUserMsg = this.g;
      if ((paramAbstructRecentUserMsg instanceof TroopAtAllMsg))
      {
        paramAbstructRecentUserMsg = String.format(HardCodeUtil.a(2131910653), new Object[] { this.a.mTitleName });
        this.a.mContentDesc = paramAbstructRecentUserMsg;
        return;
      }
      if ((paramAbstructRecentUserMsg instanceof TroopKeyWordMsg)) {
        this.h = true;
      }
    }
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public DealMsgAttentionType d()
  {
    if ((this.g instanceof AbstructRecentUserMsg))
    {
      if ((this.a.mUnreadNum == 0) && (!(this.g instanceof TroopNotificationMsg)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dealMsgAttention, mUnreadNum:");
          ((StringBuilder)localObject).append(this.a.mUnreadNum);
          QLog.d("RecentItemTroopMsgData", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.a;
        ((RecentItemTroopMsgData)localObject).mMsgExtroInfo = "";
        ((RecentItemTroopMsgData)localObject).mContentDesc = "";
        this.b = true;
        return this;
      }
      AbstructRecentUserMsg localAbstructRecentUserMsg = (AbstructRecentUserMsg)this.g;
      this.a.mMsgExtroInfo = localAbstructRecentUserMsg.c;
      this.e = 2131168153;
      this.a.mContentDesc = localAbstructRecentUserMsg.d;
      long l = this.f.c(this.a.mUser.uin);
      Object localObject = null;
      if (l != 0L) {
        localObject = this.c.getMessageFacade().d(this.a.mUser.uin, this.a.mUser.getType(), l);
      }
      a(localAbstructRecentUserMsg, (MessageRecord)localObject);
      b(localAbstructRecentUserMsg, (MessageRecord)localObject);
      c(localAbstructRecentUserMsg, (MessageRecord)localObject);
    }
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData.DealMsgAttentionType
 * JD-Core Version:    0.7.0.1
 */