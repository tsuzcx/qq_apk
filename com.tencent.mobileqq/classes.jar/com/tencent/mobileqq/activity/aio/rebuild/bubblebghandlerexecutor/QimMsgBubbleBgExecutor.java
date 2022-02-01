package com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.theme.SkinEngine;

public class QimMsgBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public QimMsgBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    paramChatMessage.isShowQIMStyleGroup = QIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0) && (paramChatMessage.isShowQIMStyleGroup);
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    return ((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.e;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (b(paramChatMessage))
    {
      if (paramChatMessage.istroop == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      } else if (paramChatMessage.istroop == 3000) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
      }
      paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838170);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramChatMessage);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = new BubbleInfo(0);
      return;
    }
    if (a(paramChatMessage))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
      if (((paramChatMessage instanceof MessageForText)) && (!(paramViewHolder instanceof TextTranslationItemBuilder.Holder)))
      {
        if ((paramChatMessage.isSend() ^ true)) {
          paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838169);
        } else {
          paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838170);
        }
      }
      else
      {
        paramBoolean = paramChatMessage.isSend();
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
        paramInt1 = 2130850159;
        paramInt2 = 2130850336;
        Drawable localDrawable1;
        Drawable localDrawable2;
        if (bool)
        {
          paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources();
          if (!paramBoolean) {
            paramInt2 = 2130850160;
          }
          localDrawable1 = paramChatMessage.getDrawable(paramInt2);
          paramChatMessage = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources();
          if (paramBoolean) {
            paramInt1 = 2130850335;
          }
          localDrawable2 = paramChatMessage.getDrawable(paramInt1);
          paramChatMessage = new StateListDrawable();
          paramChatMessage.addState(new int[] { 16842919 }, localDrawable1);
          paramChatMessage.addState(new int[] { 16842910 }, localDrawable2);
        }
        else
        {
          paramChatMessage = SkinEngine.getInstances();
          if (!paramBoolean) {
            paramInt2 = 2130850160;
          }
          localDrawable1 = paramChatMessage.getDefaultThemeDrawable(paramInt2);
          paramChatMessage = SkinEngine.getInstances();
          if (paramBoolean) {
            paramInt1 = 2130850335;
          }
          localDrawable2 = paramChatMessage.getDefaultThemeDrawable(paramInt1);
          paramChatMessage = new StateListDrawable();
          paramChatMessage.addState(new int[] { 16842919 }, localDrawable1);
          paramChatMessage.addState(new int[] { 16842910 }, localDrawable2);
        }
      }
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramChatMessage);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = new BubbleInfo(0);
    }
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    if (paramInt == 0) {
      return false;
    }
    if (b(paramChatMessage)) {
      return true;
    }
    return a(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.QimMsgBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */