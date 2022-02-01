package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;

public class BaseBubbleBuilderMenuReplyProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuReplyProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage)
  {
    if (!a(paramContext))
    {
      Object localObject;
      if ((paramContext instanceof BaseActivity))
      {
        localObject = ((BaseActivity)paramContext).getChatFragment();
        if (localObject != null) {
          ((ReplyHelper)((ChatFragment)localObject).k().q(119)).a(paramChatMessage, 0, 0L, null);
        }
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)paramChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.a != null)) {
          StoryReportor.a(this.a, paramContext, (MessageForStructing)localObject, "reply");
        }
      }
      ReplyTextItemBuilder.a(this.a, paramChatMessage, "0X800A368");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramContext, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if (paramChatMessage != null)
    {
      if (paramChatMessage.shmsgseq == 0L) {
        return;
      }
      if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000) || (this.b.a == 0))
      {
        if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.a.getCurrentUin())) && (paramChatMessage.isSupportReply()))
        {
          paramQQCustomMenu.a(2131444634, paramContext.getString(2131895468), 2130839072);
          MessageForReplyText.reportReplyMsg(this.a, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
          return;
        }
        if ((paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && (paramChatMessage.istroop != 3000))
        {
          paramQQCustomMenu.a(2131444634, paramContext.getString(2131895468), 2130839072);
          MessageForReplyText.reportReplyMsg(this.a, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        }
      }
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramChatMessage, paramQQCustomMenu, paramContext);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131444634;
  }
  
  protected boolean a(Context paramContext)
  {
    int i = this.b.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (((TroopGagMgr)this.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.b.b, true).b)
      {
        QQToast.makeText(this.a.getApp(), 2131895180, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyProcessor
 * JD-Core Version:    0.7.0.1
 */