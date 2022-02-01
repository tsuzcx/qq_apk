package com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.etrump.mixlayout.FontManager;
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
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;

public class DefaultMsgBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public DefaultMsgBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.a;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2;
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!ConfessMsgUtil.a(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
    {
      localObject1 = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject2 = TranslateCache.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localObject2 == null) {
        break label465;
      }
    }
    label402:
    label465:
    for (Object localObject1 = ((TransDiskCache)localObject2).a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject1);; localObject1 = null)
    {
      boolean bool3;
      if ((localObject1 != null) && (((Trans_entity)localObject1).a().booleanValue()) && (!paramChatMessage.isSend()))
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
        if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        paramInt2 = paramChatMessage.vipBubbleDiyTextId;
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = SVIPHandler.b(paramChatMessage.vipBubbleID);
        }
        if (paramChatMessage.fakeSenderType != 1) {
          break label402;
        }
        localObject1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        bool2 = paramChatMessage.isSend();
        bool3 = paramChatMessage.needVipBubble();
        paramBoolean = bool1;
        if (paramInt3 == 2) {
          paramBoolean = true;
        }
        ((BubbleInfo)localObject1).a((QQAppInterface)localObject2, bool2, bool3, paramBoolean, paramViewHolder.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramInt1);
      }
      for (;;)
      {
        if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
          if (paramChatMessage != null) {
            paramChatMessage.setAlpha(BaseBubbleBuilder.a);
          }
        }
        return;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
        break;
        if ((paramInt3 == 3) || (!paramChatMessage.needVipBubble()) || (ConfessMsgUtil.a(paramChatMessage))) {
          paramInt1 = 0;
        }
        for (;;)
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
          break;
          localObject1 = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
          if (paramChatMessage.fakeSenderType == 1) {
            paramInt1 = ((SVIPHandler)localObject1).b();
          } else {
            paramInt1 = ((SVIPHandler)localObject1).a(paramChatMessage);
          }
        }
        localObject1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        bool1 = paramChatMessage.isSend();
        bool3 = paramChatMessage.needVipBubble();
        paramBoolean = bool2;
        if (paramInt3 == 2) {
          paramBoolean = true;
        }
        ((BubbleInfo)localObject1).a((QQAppInterface)localObject2, bool1, bool3, paramBoolean, paramViewHolder.jdField_a_of_type_AndroidViewView, FontManager.a(paramChatMessage), paramInt1);
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