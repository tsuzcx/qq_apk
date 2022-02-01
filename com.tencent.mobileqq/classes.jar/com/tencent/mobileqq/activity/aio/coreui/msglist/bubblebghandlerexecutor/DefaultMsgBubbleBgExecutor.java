package com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;

public class DefaultMsgBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public DefaultMsgBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.d;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    Object localObject1;
    Object localObject2;
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!ConfessMsgUtil.b(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
    {
      localObject1 = LocaleUtil.a(this.c.getApplicationContext());
      localObject2 = TranslateCache.c(this.c.getApplicationContext());
      if (localObject2 != null) {
        localObject1 = ((TransDiskCache)localObject2).a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject1);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((Trans_entity)localObject1).c().booleanValue()) && (!paramChatMessage.isSend())) {
        paramViewHolder.i = BubbleUtils.a(100001, this.a, paramBoolean);
      } else {
        paramViewHolder.i = BubbleUtils.a(100000, this.a, paramBoolean);
      }
    }
    else
    {
      if ((paramInt3 != 3) && (paramChatMessage.needVipBubble()) && (!ConfessMsgUtil.b(paramChatMessage)))
      {
        localObject1 = (ISVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (paramChatMessage.fakeSenderType == 1) {
          paramInt1 = ((ISVIPHandler)localObject1).d();
        } else {
          paramInt1 = ((ISVIPHandler)localObject1).b(paramChatMessage);
        }
      }
      else
      {
        paramInt1 = 0;
      }
      paramViewHolder.i = BubbleUtils.a(paramInt1, this.a, paramBoolean);
    }
    paramViewHolder.i.a(paramViewHolder.h, null);
    if (paramViewHolder.h != null)
    {
      paramViewHolder.h.setMinimumWidth(AIOUtils.b(BubbleInfo.c(), this.c.getResources()));
      paramViewHolder.h.setMinimumHeight(AIOUtils.b(57.0F, this.c.getResources()));
    }
    paramInt2 = paramChatMessage.vipBubbleDiyTextId;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = SVIPHandlerConstants.b(paramChatMessage.vipBubbleID);
    }
    boolean bool1;
    boolean bool2;
    if (paramChatMessage.fakeSenderType == 1)
    {
      localObject1 = paramViewHolder.i;
      localObject2 = this.a;
      bool1 = paramChatMessage.isSend();
      bool2 = paramChatMessage.needVipBubble();
      if (paramInt3 == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((BubbleInfo)localObject1).a((QQAppInterface)localObject2, bool1, bool2, paramBoolean, paramViewHolder.h, this.a.getCurrentUin(), paramInt1);
    }
    else
    {
      localObject1 = paramViewHolder.i;
      localObject2 = this.a;
      bool1 = paramChatMessage.isSend();
      bool2 = paramChatMessage.needVipBubble();
      if (paramInt3 == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((BubbleInfo)localObject1).a((QQAppInterface)localObject2, bool1, bool2, paramBoolean, paramViewHolder.h, FontManagerConstants.getSenderUin(paramChatMessage), paramInt1);
    }
    if (paramViewHolder.h != null)
    {
      paramChatMessage = paramViewHolder.h.getBackground();
      if (paramChatMessage != null) {
        paramChatMessage.setAlpha(BaseBubbleBuilder.b);
      }
    }
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return paramInt != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.DefaultMsgBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */