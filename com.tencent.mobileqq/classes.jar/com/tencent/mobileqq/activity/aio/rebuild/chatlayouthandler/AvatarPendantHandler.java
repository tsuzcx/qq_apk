package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;

public class AvatarPendantHandler
  extends ChatLayoutHandler
{
  public AvatarPendantHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004)) {
      return paramChatMessage.frienduin;
    }
    return paramChatMessage.senderuin;
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (AnonymousChatHelper.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    String str = a(paramChatMessage);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null) {
      a(paramChatMessage, paramBaseChatItemLayout, str, localFriendsManager);
    }
    for (;;)
    {
      paramChatMessage.mPendantAnimatable = false;
      return;
      if (paramBaseChatItemLayout.a != null)
      {
        paramBaseChatItemLayout.a.setImageDrawable(null);
        paramBaseChatItemLayout.a.setVisibility(8);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, String paramString, FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(paramString, false);
    AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    String str;
    if ((localExtensionInfo != null) && (localExtensionInfo.lastUpdateTime < paramChatMessage.time))
    {
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_id");
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantHandler", 2, "handleAvatarPendant: message id = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (Long.parseLong(str) != localExtensionInfo.pendantId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantHandler", 2, "handleAvatarPendant: message id not equals local");
        }
        AvatarPendantUtil.a(paramString);
        AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_diy_id");
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantHandler", 2, "handleAvatarPendant: message pendantDiyId = " + str);
      }
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      if (Integer.parseInt(str) != localExtensionInfo.pendantDiyId)
      {
        AvatarPendantUtil.a(paramString);
        AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        AvatarPendantManager.b = true;
        if (AvatarPendantUtil.a(localExtensionInfo.pendantId))
        {
          localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
          if ((!paramFriendsManager.b(paramString)) && (localExtensionInfo.isPendantExpired())) {
            AvatarPendantUtil.a(paramString);
          }
          if ((!localAvatarPendantManager.a(paramChatMessage.uniseq)) && (paramBaseChatItemLayout.a != null)) {
            paramBaseChatItemLayout.a.setVisibility(4);
          }
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("AvatarPendantHandler", 1, "parse vip_pendant_diy_id field failed, value=" + str);
          continue;
          localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 1, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
        }
        if (paramBaseChatItemLayout.a != null)
        {
          paramBaseChatItemLayout.a.setImageDrawable(null);
          paramBaseChatItemLayout.a.setVisibility(8);
        }
      } while (localExtensionInfo != null);
      AvatarPendantUtil.a(paramString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a(paramChatMessage, paramBaseChatItemLayout, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (SimpleUIUtil.a()) {}
    label6:
    do
    {
      TroopInfo localTroopInfo;
      do
      {
        do
        {
          break label6;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007);
          if ((paramChatMessage == null) || (paramChatMessage.isShowQimStyleAvater) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (ConfessMsgUtil.a(paramChatMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1037) || (UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1044) || (paramChatMessage.fakeSenderType != 0))
          {
            paramBaseChatItemLayout.setPendantImageVisible(false);
            return;
          }
        } while (AIOUtils.i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((localTroopInfo != null) && (localTroopInfo.hasOrgs()));
    } while ((AioApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || ((paramChatMessage instanceof MessageForTroopConfess)));
    a(paramChatMessage, paramBaseChatItemLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.AvatarPendantHandler
 * JD-Core Version:    0.7.0.1
 */