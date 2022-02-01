package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopMsgObserver
  extends BaseTroopMsgObserver
{
  protected TroopChatPie d;
  private BaseActivity e;
  
  TroopMsgObserver(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
    this.d = paramTroopChatPie;
    this.e = paramTroopChatPie.f;
  }
  
  private void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseTroopMsgObserver", 2, "onUpdateSendMsgError, sticker msg is failed!");
    }
    this.c.getMessageFacade().a(paramMessageRecord, false);
    paramString = UinTypeUtil.a(paramString, paramInt);
    boolean bool3 = EmojiStickerManager.a().F.containsKey(paramString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      long l = ((Long)EmojiStickerManager.a().F.get(paramString)).longValue();
      if (System.currentTimeMillis() - l > 300000L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send sticker msg fail, is need send Toast ");
      localStringBuilder.append(bool1);
      QLog.i("BaseTroopMsgObserver", 2, localStringBuilder.toString());
    }
    if (bool1)
    {
      EmojiStickerManager.a().F.put(paramString, Long.valueOf(System.currentTimeMillis()));
      ThreadManager.getUIHandler().post(new TroopMsgObserver.1(this, paramMessageRecord));
    }
  }
  
  private boolean a(String paramString, int paramInt, long paramLong)
  {
    if ((paramString != null) && (paramString.equals(this.b.b)) && (paramInt == this.b.a)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateSendMsgError exception uin ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniseq ");
      localStringBuilder.append(paramLong);
      QLog.d("BaseTroopMsgObserver", 2, localStringBuilder.toString());
    }
    paramString = this.c.getMessageFacade().a(paramString, paramInt, paramLong);
    if ((paramString != null) && (paramString.msgtype == -2058) && ((paramString.extraflag == 32768) || (paramString.sendFailCode == 41)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopMsgObserver", 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
      }
      this.c.getMessageFacade().a(paramString, false);
    }
    return true;
  }
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopMsgObserver", 2, "onGetSystemMsgFin.success");
      }
      List localList = this.c.getMessageFacade().h(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      StringBuilder localStringBuilder = null;
      paramList = localStringBuilder;
      if (localList != null)
      {
        paramList = localStringBuilder;
        if (localList.size() - 1 >= 0) {
          paramList = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if (paramList != null)
      {
        if (!(paramList instanceof MessageForSystemMsg)) {
          return;
        }
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList.msg_type.get() == 2) && (paramList.msg.get() != null))
        {
          int i = paramList.msg.group_msg_type.get();
          if ((i == 3) || (i == 15))
          {
            long l = paramList.msg.group_code.get();
            if (this.b.b != null)
            {
              paramList = this.b.b;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(l);
              if (paramList.equalsIgnoreCase(localStringBuilder.toString())) {
                this.d.bQ();
              }
            }
          }
        }
      }
    }
  }
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
    if (paramList.isEmpty()) {
      paramList = null;
    } else {
      paramList = (MessageRecord)paramList.get(0);
    }
    if ((paramList != null) && (this.d.n.getCurrentPanel() == 35)) {
      this.d.a(true, true);
    }
  }
  
  protected void onUpdateMsgDelFriend(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (paramString.equals(this.b.b)))
    {
      if (paramInt1 != this.b.a) {
        return;
      }
      if (paramInt1 == 1)
      {
        if ((paramInt2 != 1) && (paramInt2 != 2))
        {
          if (paramInt2 != 3) {
            return;
          }
          paramString = this.d.bX.obtainMessage(5, 1, 0, this.e.getString(2131886618));
          this.d.bX.sendMessage(paramString);
        }
        else
        {
          paramString = this.d.bX.obtainMessage(5, 1, 0, this.e.getString(2131886624));
          this.d.bX.sendMessage(paramString);
        }
        this.d.L();
      }
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (a(paramString1, paramInt1, paramLong2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = new StringBuilder();
      paramSendMessageHandler.append("onUpdateSendMsgError uin ");
      paramSendMessageHandler.append(paramString1);
      paramSendMessageHandler.append(" type ");
      paramSendMessageHandler.append(paramInt1);
      paramSendMessageHandler.append(" uniseq ");
      paramSendMessageHandler.append(paramLong2);
      QLog.d("BaseTroopMsgObserver", 2, paramSendMessageHandler.toString());
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.c.getMessageFacade().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler instanceof MessageForStructing))
      {
        if ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction)) {
          MultiMsgManager.a().a(this.c, paramString1, paramInt1, paramLong2, false);
        }
      }
      else if ((paramSendMessageHandler != null) && (paramSendMessageHandler.msgtype == -2058) && ((paramSendMessageHandler.extraflag == 32768) || (paramSendMessageHandler.sendFailCode == 41))) {
        a(paramString1, paramInt1, paramSendMessageHandler);
      }
    }
    this.d.a(paramInt1, paramInt2, paramString2);
    this.d.j(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopMsgObserver
 * JD-Core Version:    0.7.0.1
 */