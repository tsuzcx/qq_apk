package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.util.QidianUtils;

public class NickHandler
  extends ChatLayoutHandler
{
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public NickHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    String str = paramSessionInfo.d;
    if (paramChatMessage.isSend()) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    paramBaseChatItemLayout.setNick(TextUtils.isEmpty(str) ^ true, str, paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, "");
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = MultiMsgUtil.a(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.setNick(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (AppSetting.d)
    {
      int i;
      if (paramChatMessage.istroop == 1) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (paramChatMessage.istroop == 3000) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if ((paramChatMessage.fakeSenderType != 2) && (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg))) {
        k = 0;
      } else {
        k = 1;
      }
      int m;
      if ((!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
        m = 0;
      } else {
        m = 1;
      }
      if ((i != 0) || (j != 0) || (k != 0))
      {
        Object localObject;
        if (i != 0)
        {
          if (m != 0)
          {
            localObject = HardCodeUtil.a(2131701167);
          }
          else if ("1000000".equals(paramChatMessage.senderuin))
          {
            if (paramChatMessage.msgtype == -3006) {
              localObject = String.format(paramBaseChatItemLayout.getResources().getString(2131697679), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            } else {
              localObject = HardCodeUtil.a(2131701168);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131701160));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else if (j != 0)
        {
          if (m != 0)
          {
            localObject = HardCodeUtil.a(2131701171);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131701161));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          if (m != 0)
          {
            localObject = HardCodeUtil.a(2131701171);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131701161));
            localObject = ((StringBuilder)localObject).toString();
          }
          if (paramChatMessage.msgtype == -3006) {
            localObject = String.format(paramBaseChatItemLayout.getResources().getString(2131697679), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          }
        }
        paramBaseChatItemLayout = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
        if (paramBaseChatItemLayout != null)
        {
          paramBaseChatItemLayout = paramBaseChatItemLayout.a();
          if (paramBaseChatItemLayout != null) {
            paramBaseChatItemLayout.setContentDescription((CharSequence)localObject);
          }
        }
      }
    }
    if ((AppSetting.d) && (paramViewHolder.b != null))
    {
      if ((!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend()))
      {
        paramBaseChatItemLayout = paramString;
        if (paramString == null) {
          paramBaseChatItemLayout = "";
        }
        paramString = paramBaseChatItemLayout;
        if (AnonymousChatHelper.a(paramChatMessage))
        {
          paramString = new StringBuilder();
          paramString.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690013));
          paramString.append(paramBaseChatItemLayout);
          paramString = paramString.toString();
        }
        paramViewHolder.b.insert(0, paramString);
        return;
      }
      paramViewHolder.b.append("我");
    }
  }
  
  @TargetApi(14)
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i = paramChatMessage.istroop;
    Object localObject3 = null;
    boolean bool = true;
    Object localObject1;
    if (i == 3000)
    {
      if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin)) {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
      } else if (paramChatMessage.isSend()) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      } else {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        localObject2 = paramChatMessage.senderuin;
      }
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramChatMessage.senderuin) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a;
      if (i != 0) {
        localObject1 = ((FlashChatManager.GlobalConfig)localObject1).d;
      } else {
        localObject1 = null;
      }
      if (localObject2 == null) {
        bool = false;
      }
      paramBaseChatItemLayout.setNick(bool, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
      localObject1 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.d);
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull())) {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      localObject1 = localObject2;
    }
    else if (paramChatMessage.istroop == 9501)
    {
      if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
        if (paramChatMessage.senderuin.equals(paramChatMessage.frienduin)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        paramBaseChatItemLayout.setNick(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, false, false, false, false, "", null, null);
        localObject1 = localObject3;
      }
      else
      {
        paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
        localObject1 = localObject3;
      }
    }
    else if (QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin))
    {
      localObject2 = QidianUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      paramBaseChatItemLayout.setNick(true ^ TextUtils.isEmpty((CharSequence)localObject2), (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, "");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n)
    {
      a(paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
      localObject1 = localObject3;
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
    }
    Object localObject2 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
    if ((localObject2 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject2).checkViewNonNull()) && (AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
      ((BaseChatItemLayoutViewBasicAbility)localObject2).setAccessibilityDelegate(new NickHandler.1(this));
    }
    a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if ((paramChatMessage != null) && (paramViewGroup != null) && (paramContext != null) && (paramBaseChatItemLayout != null))
    {
      if (paramViewHolder == null) {
        return;
      }
      if (paramBundle != null)
      {
        this.jdField_a_of_type_Boolean = paramBundle.getBoolean("inChatHistory", false);
        this.b = paramBundle.getBoolean("inInMiniAIO", false);
        this.jdField_a_of_type_JavaLangCharSequence = paramBundle.getCharSequence("dateTime");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        paramViewGroup = paramContext;
        if (!this.jdField_a_of_type_Boolean)
        {
          paramViewGroup = paramContext;
          if (!this.b)
          {
            paramViewGroup = paramContext;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramViewGroup = paramContext;
              if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                paramViewGroup = ColorStateList.valueOf(AnonymousChatHelper.d);
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
          paramViewGroup = ColorStateList.valueOf(AnonymousChatHelper.d);
        }
        paramBaseChatItemLayout.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, paramViewGroup, this.jdField_a_of_type_JavaLangCharSequence);
      }
      if (paramChatMessage.fakeSenderType == 1) {
        paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
      }
      if ((paramChatMessage.fakeSenderType == 2) && (!AnonymousChatHelper.a(paramChatMessage))) {
        a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      }
      if (paramChatMessage.fakeSenderType == 0)
      {
        if (((paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 3000)) && (paramChatMessage.isMultiMsg))
        {
          a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
          return;
        }
        if (paramChatMessage.istroop != 1) {
          b(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.NickHandler
 * JD-Core Version:    0.7.0.1
 */