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
  private boolean a;
  private boolean g;
  private CharSequence h;
  
  public NickHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    String str = paramSessionInfo.e;
    if (paramChatMessage.isSend()) {
      str = this.b.getCurrentNickname();
    }
    paramBaseChatItemLayout.setNick(TextUtils.isEmpty(str) ^ true, str, paramSessionInfo.H.b, paramChatMessage.isSend(), false, false, false, "", null, "");
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.b);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = MultiMsgUtil.b(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.setNick(true, (CharSequence)localObject2, this.c.H.b, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (AppSetting.e)
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
      if ((!TextUtils.equals(this.b.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
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
            localObject = HardCodeUtil.a(2131899183);
          }
          else if ("1000000".equals(paramChatMessage.senderuin))
          {
            if (paramChatMessage.msgtype == -3006) {
              localObject = String.format(paramBaseChatItemLayout.getResources().getString(2131895452), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext()) });
            } else {
              localObject = HardCodeUtil.a(2131899184);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899177));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else if (j != 0)
        {
          if (m != 0)
          {
            localObject = HardCodeUtil.a(2131899187);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899178));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          if (m != 0)
          {
            localObject = HardCodeUtil.a(2131899187);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899178));
            localObject = ((StringBuilder)localObject).toString();
          }
          if (paramChatMessage.msgtype == -3006) {
            localObject = String.format(paramBaseChatItemLayout.getResources().getString(2131895452), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext()) });
          }
        }
        paramBaseChatItemLayout = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
        if (paramBaseChatItemLayout != null)
        {
          paramBaseChatItemLayout = paramBaseChatItemLayout.c();
          if (paramBaseChatItemLayout != null) {
            paramBaseChatItemLayout.setContentDescription((CharSequence)localObject);
          }
        }
      }
    }
    if ((AppSetting.e) && (paramViewHolder.r != null))
    {
      if ((!TextUtils.equals(this.b.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend()))
      {
        paramBaseChatItemLayout = paramString;
        if (paramString == null) {
          paramBaseChatItemLayout = "";
        }
        paramString = paramBaseChatItemLayout;
        if (AnonymousChatHelper.c(paramChatMessage))
        {
          paramString = new StringBuilder();
          paramString.append(this.d.getResources().getString(2131886662));
          paramString.append(paramBaseChatItemLayout);
          paramString = paramString.toString();
        }
        paramViewHolder.r.insert(0, paramString);
        return;
      }
      paramViewHolder.r.append("我");
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
      if (ContactUtils.h(this.b, paramChatMessage.frienduin)) {
        localObject1 = ContactUtils.a(this.b, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
      } else if (paramChatMessage.isSend()) {
        localObject1 = this.b.getCurrentNickname();
      } else {
        localObject1 = ContactUtils.a(this.b, paramChatMessage.frienduin, paramChatMessage.senderuin);
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
      if (((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER)).p(paramChatMessage.senderuin) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = ((FlashChatManager)this.b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c;
      if (i != 0) {
        localObject1 = ((FlashChatManager.GlobalConfig)localObject1).d;
      } else {
        localObject1 = null;
      }
      if (localObject2 == null) {
        bool = false;
      }
      paramBaseChatItemLayout.setNick(bool, (CharSequence)localObject2, this.c.H.b, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
      localObject1 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.d);
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull())) {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setOnClickListener(this.e);
      }
      localObject1 = localObject2;
    }
    else if (paramChatMessage.istroop == 9501)
    {
      if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
      {
        localObject1 = ContactUtils.a(this.b, paramChatMessage.senderuin, true);
        if (paramChatMessage.senderuin.equals(paramChatMessage.frienduin)) {
          localObject1 = this.c.e;
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
        paramBaseChatItemLayout.setNick(true, (CharSequence)localObject2, this.c.H.b, false, false, false, false, "", null, null);
        localObject1 = localObject3;
      }
      else
      {
        paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
        localObject1 = localObject3;
      }
    }
    else if (QidianManager.a(this.b, paramChatMessage.senderuin))
    {
      localObject2 = QidianUtils.a(this.b, paramChatMessage);
      paramBaseChatItemLayout.setNick(true ^ TextUtils.isEmpty((CharSequence)localObject2), (CharSequence)localObject2, this.c.H.b, paramChatMessage.isSend(), false, false, false, "", null, "");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.c.e;
      }
    }
    else if (this.c.G)
    {
      a(paramBaseChatItemLayout, this.c, paramChatMessage);
      localObject1 = localObject3;
    }
    else
    {
      localObject1 = this.c.e;
      paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
    }
    Object localObject2 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
    if ((localObject2 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject2).checkViewNonNull()) && (AppSetting.e) && (Build.VERSION.SDK_INT >= 14)) {
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
        this.a = paramBundle.getBoolean("inChatHistory", false);
        this.g = paramBundle.getBoolean("inInMiniAIO", false);
        this.h = paramBundle.getCharSequence("dateTime");
      }
      if (this.c.H != null)
      {
        paramContext = this.c.H.b;
        paramViewGroup = paramContext;
        if (!this.a)
        {
          paramViewGroup = paramContext;
          if (!this.g)
          {
            paramViewGroup = paramContext;
            if (this.c.a == 1)
            {
              paramViewGroup = paramContext;
              if (AnonymousChatHelper.a().a(this.c.b)) {
                paramViewGroup = ColorStateList.valueOf(AnonymousChatHelper.d);
              }
            }
          }
        }
        if (this.c.a == 1033) {
          paramViewGroup = ColorStateList.valueOf(AnonymousChatHelper.d);
        }
        paramBaseChatItemLayout.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, paramViewGroup, this.h);
      }
      if (paramChatMessage.fakeSenderType == 1) {
        paramBaseChatItemLayout.setNick(false, null, null, false, false, false, false, "", null, null);
      }
      if ((paramChatMessage.fakeSenderType == 2) && (!AnonymousChatHelper.c(paramChatMessage))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.NickHandler
 * JD-Core Version:    0.7.0.1
 */