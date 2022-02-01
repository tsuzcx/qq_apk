package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public class BaseBubbleBuilderMenuReplyOnlyProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuReplyOnlyProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramContext, paramChatMessage);
  }
  
  protected void a(Context paramContext, ChatMessage paramChatMessage)
  {
    int j = 2;
    if ((paramContext != null) && (paramChatMessage != null))
    {
      ((ForwardMsgManager)this.a.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(paramChatMessage);
      Intent localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
      localIntent.putExtra("uin", paramChatMessage.senderuin);
      Object localObject = new Bundle();
      ((Bundle)localObject).putLong("key_reply_only_uniseq", paramChatMessage.uniseq);
      localIntent.putExtras((Bundle)localObject);
      localObject = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramChatMessage.senderuin);
      localIntent.putExtra("troop_code", this.b.b);
      int i;
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        localIntent.putExtra("uintype", 0);
        paramContext.startActivity(localIntent);
        i = 1;
      }
      else
      {
        localIntent.putExtra("uintype", 1000);
        localIntent.putExtra("uinname", ContactUtils.d(this.a, this.b.b, paramChatMessage.senderuin));
        localIntent = new Intent(localIntent);
        localObject = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
        i = j;
        if (localObject != null)
        {
          ((TroopManager)localObject).a(this.b.b, new BaseBubbleBuilderMenuReplyOnlyProcessor.1(this, localIntent, paramContext));
          i = j;
        }
      }
      if (this.a.getCurrentUin().equals(paramChatMessage.senderuin)) {
        i = 3;
      }
      ReportController.b(this.a, "dc00898", "", "", "0X800A4F5", "0X800A4F5", i, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseBubbleBuilderMenuClickReplyOnlyProcessor", 2, "chatMessage or chatMessage is null");
    }
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if (this.b.a == 1)
    {
      if (paramChatMessage == null) {
        return;
      }
      if ((!RobotUtils.a(this.a, paramChatMessage.senderuin)) && (!AnonymousChatHelper.c(paramChatMessage)) && (!ConfessMsgUtil.b(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply()))
      {
        if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.a.getCurrentUin())))
        {
          paramQQCustomMenu.a(2131444651, paramContext.getString(2131895474), 2130839072);
          return;
        }
        if ((paramChatMessage.isSend()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768)) {
          paramQQCustomMenu.a(2131444651, paramContext.getString(2131895474), 2130839072);
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQCustomMenu = new StringBuilder("addReplyOnlyMenu isRobot=");
        paramQQCustomMenu.append(RobotUtils.a(this.a, paramChatMessage.senderuin));
        paramQQCustomMenu.append(" isAnonymousMsg=");
        paramQQCustomMenu.append(AnonymousChatHelper.c(paramChatMessage));
        paramQQCustomMenu.append(" isConfessMsg=");
        paramQQCustomMenu.append(ConfessMsgUtil.b(paramChatMessage));
        paramQQCustomMenu.append(" isNotSupport=");
        paramQQCustomMenu.append(paramChatMessage.isSupportReply() ^ true);
        QLog.d("BaseBubbleBuilderMenuClickReplyOnlyProcessor", 2, paramQQCustomMenu.toString());
      }
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramChatMessage, paramQQCustomMenu, paramContext);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131444651;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyOnlyProcessor
 * JD-Core Version:    0.7.0.1
 */