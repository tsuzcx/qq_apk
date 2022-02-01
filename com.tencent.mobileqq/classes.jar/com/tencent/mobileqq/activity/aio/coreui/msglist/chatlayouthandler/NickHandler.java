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
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
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
import com.tencent.mobileqq.vas.avatar.VasAvatar;
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
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.setNick(bool, str, paramSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, "");
      return;
    }
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
    int i;
    int j;
    label30:
    int k;
    label65:
    int m;
    label92:
    String str;
    if (AppSetting.d)
    {
      if (paramChatMessage.istroop != 1) {
        break label183;
      }
      i = 1;
      if (paramChatMessage.istroop != 3000) {
        break label189;
      }
      j = 1;
      if ((paramChatMessage.fakeSenderType != 2) && (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg))) {
        break label195;
      }
      k = 1;
      if ((!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
        break label201;
      }
      m = 1;
      if ((i != 0) || (j != 0) || (k != 0))
      {
        if (i == 0) {
          break label310;
        }
        if (m == 0) {
          break label207;
        }
        str = HardCodeUtil.a(2131701024);
      }
    }
    label183:
    label189:
    label448:
    for (;;)
    {
      paramBaseChatItemLayout.a.setContentDescription(str);
      if ((AppSetting.d) && (paramViewHolder.b != null))
      {
        if ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          paramViewHolder.b.append("我");
        }
      }
      else
      {
        return;
        i = 0;
        break;
        j = 0;
        break label30;
        label195:
        k = 0;
        break label65;
        label201:
        m = 0;
        break label92;
        label207:
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          if (paramChatMessage.msgtype == -3006)
          {
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131697673), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = HardCodeUtil.a(2131701025);
          continue;
        }
        str = paramString + HardCodeUtil.a(2131701017);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = HardCodeUtil.a(2131701028);
            continue;
          }
          str = paramString + HardCodeUtil.a(2131701018);
          continue;
        }
        if (m != 0) {}
        for (str = HardCodeUtil.a(2131701028);; str = paramString + HardCodeUtil.a(2131701018))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label448;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131697673), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    label310:
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (AnonymousChatHelper.a(paramChatMessage)) {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690097) + paramBaseChatItemLayout;
    }
    paramViewHolder.b.insert(0, paramString);
  }
  
  @TargetApi(14)
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramChatMessage.istroop == 3000) {
      if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramChatMessage.senderuin) != 1) {
          break label304;
        }
        i = 1;
        label98:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a;
        if (i == 0) {
          break label310;
        }
        localObject1 = ((FlashChatManager.GlobalConfig)localObject1).d;
        label128:
        if (localObject2 == null) {
          break label316;
        }
        label133:
        paramBaseChatItemLayout.setNick(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
        NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility = paramBaseChatItemLayout.a(NickNameLayoutProcessor.d);
        localObject1 = localObject2;
        if (localNickNameExtenderViewBasicAbility != null)
        {
          localObject1 = localObject2;
          if (localNickNameExtenderViewBasicAbility.checkViewNonNull())
          {
            localNickNameExtenderViewBasicAbility.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = paramBaseChatItemLayout.a(NickNameLayoutProcessor.h);
      if ((localObject2 != null) && (((NickNameExtenderViewBasicAbility)localObject2).checkViewNonNull()) && (AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
        ((NickNameExtenderViewBasicAbility)localObject2).setAccessibilityDelegate(new NickHandler.1(this));
      }
      a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      return;
      if (paramChatMessage.isSend()) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();; localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
        break;
      }
      label304:
      i = 0;
      break label98;
      label310:
      localObject1 = null;
      break label128;
      label316:
      bool1 = false;
      break label133;
      if (paramChatMessage.istroop == 9501)
      {
        if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
        {
          localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
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
        }
        for (;;)
        {
          localObject1 = null;
          break;
          paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
        }
      }
      if (QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin))
      {
        localObject2 = QidianUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramBaseChatItemLayout.setNick(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, paramChatMessage.isSend(), false, false, false, "", null, "");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n)
      {
        a(paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
        localObject1 = null;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if ((paramChatMessage == null) || (paramViewGroup == null) || (paramContext == null) || (paramBaseChatItemLayout == null) || (paramViewHolder == null)) {}
    do
    {
      do
      {
        return;
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
      } while (paramChatMessage.fakeSenderType != 0);
      if (((paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 3000)) && (paramChatMessage.isMultiMsg))
      {
        a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
        return;
      }
    } while (paramChatMessage.istroop == 1);
    b(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.NickHandler
 * JD-Core Version:    0.7.0.1
 */