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
    return ChatLayoutBubbleBgExecutorImpl.a;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    Object localObject1;
    Object localObject2;
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!ConfessMsgUtil.a(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
    {
      localObject1 = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject2 = TranslateCache.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localObject2 != null) {
        localObject1 = ((TransDiskCache)localObject2).a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject1);
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((Trans_entity)localObject1).a().booleanValue()) && (!paramChatMessage.isSend())) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
      } else {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
      }
    }
    else
    {
      if ((paramInt3 != 3) && (paramChatMessage.needVipBubble()) && (!ConfessMsgUtil.a(paramChatMessage)))
      {
        localObject1 = (ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (paramChatMessage.fakeSenderType == 1) {
          paramInt1 = ((ISVIPHandler)localObject1).b();
        } else {
          paramInt1 = ((ISVIPHandler)localObject1).a(paramChatMessage);
        }
      }
      else
      {
        paramInt1 = 0;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.b(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.b(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
      localObject1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      bool1 = paramChatMessage.isSend();
      bool2 = paramChatMessage.needVipBubble();
      if (paramInt3 == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((BubbleInfo)localObject1).a((QQAppInterface)localObject2, bool1, bool2, paramBoolean, paramViewHolder.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramInt1);
    }
    else
    {
      localObject1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      bool1 = paramChatMessage.isSend();
      bool2 = paramChatMessage.needVipBubble();
      if (paramInt3 == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((BubbleInfo)localObject1).a((QQAppInterface)localObject2, bool1, bool2, paramBoolean, paramViewHolder.jdField_a_of_type_AndroidViewView, FontManagerConstants.getSenderUin(paramChatMessage), paramInt1);
    }
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.DefaultMsgBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */