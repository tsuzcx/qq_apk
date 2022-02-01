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
    if ((paramChatMessage.istroop != 1000) && (paramChatMessage.istroop != 1020) && (paramChatMessage.istroop != 1004)) {
      return paramChatMessage.senderuin;
    }
    return paramChatMessage.frienduin;
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramChatMessage != null) && (paramChatMessage.senderuin != null) && (!AnonymousChatHelper.c(paramChatMessage)) && (!(this.d instanceof MultiForwardActivity)) && (!this.c.G))
    {
      String str = a(paramChatMessage);
      FriendsManager localFriendsManager = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null)
      {
        a(paramChatMessage, paramBaseChatItemLayout, str, localFriendsManager);
      }
      else if (paramBaseChatItemLayout.ae != null)
      {
        paramBaseChatItemLayout.ae.setImageDrawable(null);
        paramBaseChatItemLayout.ae.setVisibility(8);
      }
      paramChatMessage.mPendantAnimatable = false;
      return;
    }
    paramBaseChatItemLayout.setPendantImageVisible(false);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, String paramString, FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.d(paramString, false);
    AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.b.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    String str;
    if ((localExtensionInfo != null) && (localExtensionInfo.lastUpdateTime < paramChatMessage.time))
    {
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_id");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleAvatarPendant: message id = ");
        localStringBuilder.append(str);
        QLog.d("AvatarPendantHandler", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(str)) && (Long.parseLong(str) != localExtensionInfo.pendantId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantHandler", 2, "handleAvatarPendant: message id not equals local");
        }
        AvatarPendantUtil.a(paramString);
        AvatarPendantUtil.a(this.b);
      }
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_diy_id");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleAvatarPendant: message pendantDiyId = ");
        localStringBuilder.append(str);
        QLog.d("AvatarPendantHandler", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      if (Integer.parseInt(str) == localExtensionInfo.pendantDiyId) {
        break label260;
      }
      AvatarPendantUtil.a(paramString);
      AvatarPendantUtil.a(this.b);
    }
    catch (Exception localException)
    {
      label224:
      break label224;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parse vip_pendant_diy_id field failed, value=");
    localStringBuilder.append(str);
    QLog.e("AvatarPendantHandler", 1, localStringBuilder.toString());
    label260:
    if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
    {
      AvatarPendantManager.d = true;
      if (AvatarPendantUtil.a(localExtensionInfo.pendantId)) {
        localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
      } else {
        localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 1, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
      }
      if ((!paramFriendsManager.n(paramString)) && (localExtensionInfo.isPendantExpired())) {
        AvatarPendantUtil.a(paramString);
      }
      if ((!localAvatarPendantManager.b(paramChatMessage.uniseq)) && (paramBaseChatItemLayout.ae != null)) {
        paramBaseChatItemLayout.ae.setVisibility(4);
      }
    }
    else
    {
      if (paramBaseChatItemLayout.ae != null)
      {
        paramBaseChatItemLayout.ae.setImageDrawable(null);
        paramBaseChatItemLayout.ae.setVisibility(8);
      }
      if (localExtensionInfo == null) {
        AvatarPendantUtil.a(paramString);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a(paramChatMessage, paramBaseChatItemLayout, paramInt1, paramInt2);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (SimpleUIUtil.e()) {
      return;
    }
    if (this.c.a == 10007) {
      return;
    }
    if ((paramChatMessage != null) && (!paramChatMessage.isShowQimStyleAvater) && ((!this.c.i) || (!this.c.p)) && (!ConfessMsgUtil.a(paramChatMessage)) && (UinTypeUtil.e(this.c.a) != 1044) && (paramChatMessage.fakeSenderType == 0))
    {
      if (AIOUtils.i) {
        return;
      }
      if (this.c.a == 1)
      {
        TroopInfo localTroopInfo = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.c.b);
        if ((localTroopInfo != null) && (localTroopInfo.hasOrgs())) {
          return;
        }
      }
      if ((paramChatMessage instanceof MessageForTroopConfess)) {
        return;
      }
      a(paramChatMessage, paramBaseChatItemLayout);
      return;
    }
    paramBaseChatItemLayout.setPendantImageVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.AvatarPendantHandler
 * JD-Core Version:    0.7.0.1
 */