package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class BaseTroopMsgObserver
  extends MessageObserver
{
  protected BaseChatPie a;
  protected SessionInfo b;
  protected QQAppInterface c;
  
  public BaseTroopMsgObserver(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.c = paramBaseChatPie.d;
    this.b = paramBaseChatPie.ah;
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("BaseTroopMsgObserver.troop.revoked_troop_msg", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (MessageRecord)paramList.get(0);
      if (this.a.au != null)
      {
        int i = this.a.au.i();
        if (i != -1)
        {
          TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.c.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
          long l = localTroopAioNavigateBarManager.c(this.b.b);
          if (((MessageRecord)localObject).uniseq == l) {
            localTroopAioNavigateBarManager.c(this.b.b, i);
          }
          this.a.au.a(((MessageRecord)localObject).uniseq);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append("|navigaeSeq:");
            ((StringBuilder)localObject).append(l);
            QLog.d("BaseTroopMsgObserver.troop.special_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.j(131072);
  }
  
  protected void onRecvEmoticonRandomResult(String paramString, long paramLong)
  {
    if (TextUtils.equals(this.b.b, paramString)) {
      this.a.a(262144, null, paramLong);
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.b.b))
      {
        paramString = this.a;
        paramString.as = true;
        paramString.a(262144, paramMsgSendCostParams, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.b.b)) && (paramInt1 == this.b.a))
    {
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
      paramSendMessageHandler = this.c.getHotChatMng(true);
      if ((paramSendMessageHandler.b(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        HotChatHelper.a(this.c, paramSendMessageHandler.c(paramString1), paramString2, true);
        if ((paramInt2 == 112) || (paramInt2 == 113))
        {
          paramSendMessageHandler = (IHotChatApi)QRoute.api(IHotChatApi.class);
          paramSendMessageHandler.delHotChatRecentUserNotNotifyUi(this.c, paramString1, 6);
          paramSendMessageHandler.invokeRecentUserChangedToConversation(this.c);
        }
      }
      this.a.j(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = new StringBuilder();
      paramSendMessageHandler.append("onUpdateSendMsgError exception uin ");
      paramSendMessageHandler.append(paramString1);
      paramSendMessageHandler.append(" type ");
      paramSendMessageHandler.append(paramInt1);
      paramSendMessageHandler.append(" uniseq ");
      paramSendMessageHandler.append(paramLong2);
      QLog.d("BaseTroopMsgObserver", 2, paramSendMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopMsgObserver
 * JD-Core Version:    0.7.0.1
 */