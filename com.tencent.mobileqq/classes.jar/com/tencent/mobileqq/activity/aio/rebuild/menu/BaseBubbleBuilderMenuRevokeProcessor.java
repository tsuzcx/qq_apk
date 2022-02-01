package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.GeneralDataBean;
import com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class BaseBubbleBuilderMenuRevokeProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuRevokeProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, MessageRecord paramMessageRecord, Context paramContext, boolean paramBoolean)
  {
    paramContext = new QQCustomMenuItem(2131438943, paramContext.getString(2131891960));
    paramContext.a(2130839074);
    paramContext.a(paramBoolean);
    paramQQCustomMenu.a(paramContext);
    if (TroopUtils.a(this.a, paramMessageRecord, this.a.getCurrentAccountUin()))
    {
      paramContext = new ReportTask(this.a).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
      String str = paramMessageRecord.frienduin;
      if (TroopUtils.a(this.a, paramMessageRecord.frienduin, this.a.getCurrentAccountUin())) {
        paramQQCustomMenu = "1";
      } else {
        paramQQCustomMenu = "2";
      }
      paramContext.a(new String[] { str, paramQQCustomMenu }).a();
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 3000)
        {
          bool1 = bool2;
          if (i != 1000)
          {
            if (i == 1004) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = TroopUtils.c(this.a, paramMessageRecord, this.a.getCurrentAccountUin());
    return ((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (TroopUtils.a(this.a, paramMessageRecord, this.a.getCurrentAccountUin()));
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramChatMessage, paramContext);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext)
  {
    if ((paramContext instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)paramContext).getChatFragment();
      paramContext = null;
      if (localObject != null) {
        paramContext = ((ChatFragment)localObject).k();
      }
      if (paramContext != null) {
        ((AIORevokeMsgHelper)paramContext.q(46)).a(paramChatMessage);
      }
      int i = 0;
      int k = 0;
      boolean bool = paramChatMessage instanceof MessageForFile;
      int j = 5;
      if (bool) {}
      for (i = 6;; i = k)
      {
        j = 4;
        break;
        if ((paramChatMessage instanceof MessageForText))
        {
          i = 1;
          j = 1;
          break;
        }
        if ((paramChatMessage instanceof MessageForPic))
        {
          i = 3;
          j = 2;
          break;
        }
        if ((paramChatMessage instanceof MessageForMarketFace))
        {
          i = 4;
          break;
        }
        if ((paramChatMessage instanceof IMessageForApollo))
        {
          i = 5;
          break;
        }
        if (!(paramChatMessage instanceof MessageForVideo)) {
          break;
        }
      }
      if (AnonymousChatHelper.c(paramChatMessage))
      {
        paramContext = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(j);
        ReportController.b(paramContext, "dc00898", "", "", "0X800ADF4", "0X800ADF4", 0, 1, ((StringBuilder)localObject).toString(), "", "", "");
      }
      if (AskAnonymousUtil.a(paramChatMessage)) {
        ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "ans_recess", 0, 0, paramChatMessage.frienduin, "0", "", "");
      }
      paramChatMessage = this.a;
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(i);
      ReportController.b(paramChatMessage, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, paramContext.toString(), "", "", "");
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    paramBundle.putBoolean("isInvokeMenuShow", a(paramQQCustomMenu, paramContext, this.b.a, paramChatMessage, paramBundle));
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131438943;
  }
  
  protected boolean a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    if (!b(paramMessageRecord)) {
      return false;
    }
    boolean bool = TroopUtils.a(this.a, paramMessageRecord, this.a.getCurrentAccountUin());
    if ((!paramMessageRecord.isSend()) && (!bool)) {
      return false;
    }
    if ((AnonymousChatHelper.c(paramMessageRecord)) && (!TroopAnonyRevokeConfProcessor.a().a)) {
      return false;
    }
    if (UinTypeUtil.e(this.b.a) == 1032) {
      return false;
    }
    paramBundle = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.b.a == 0) && (!paramBundle.n(this.b.b))) {
      return false;
    }
    if (paramInt == 1)
    {
      paramBundle = (HotChatManager)this.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((paramBundle != null) && (paramBundle.b(paramMessageRecord.frienduin))) {
        return false;
      }
    }
    if ((paramMessageRecord instanceof MessageForDLFile)) {
      return false;
    }
    if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
    {
      paramBundle = (MessageForArkApp)paramMessageRecord;
      if ((paramBundle.ark_app_message != null) && (paramBundle.ark_app_message.appName.equals("com.tencent.mannounce"))) {
        return false;
      }
    }
    if (a(paramMessageRecord))
    {
      a(paramQQCustomMenu, paramMessageRecord, paramContext, bool);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuRevokeProcessor
 * JD-Core Version:    0.7.0.1
 */