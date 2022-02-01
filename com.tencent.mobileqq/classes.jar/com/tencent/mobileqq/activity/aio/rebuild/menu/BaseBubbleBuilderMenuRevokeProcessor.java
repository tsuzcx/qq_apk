package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
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
    paramContext = new QQCustomMenuItem(2131371954, paramContext.getString(2131694357));
    paramContext.a(2130839067);
    paramContext.a(paramBoolean);
    paramQQCustomMenu.a(paramContext);
    String str;
    if (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramContext = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
      str = paramMessageRecord.frienduin;
      if (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label134;
      }
    }
    label134:
    for (paramQQCustomMenu = "1";; paramQQCustomMenu = "2")
    {
      paramContext.a(new String[] { str, paramQQCustomMenu }).a();
      return;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    return (i == 0) || (i == 1) || (i == 3000) || (i == 1000) || (i == 1004);
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = TroopUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return ((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramChatMessage, paramContext);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext)
  {
    int j;
    int i;
    if ((paramContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)paramContext).getChatFragment();
      paramContext = null;
      if (localChatFragment != null) {
        paramContext = localChatFragment.a();
      }
      if (paramContext != null) {
        ((AIORevokeMsgHelper)paramContext.a(46)).a(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label189;
      }
      j = 6;
      i = 4;
    }
    for (;;)
    {
      if (AnonymousChatHelper.a(paramChatMessage)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADF4", "0X800ADF4", 0, 1, "" + i, "", "", "");
      }
      if (AskAnonymousUtil.a(paramChatMessage)) {
        ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "ans_recess", 0, 0, paramChatMessage.frienduin, "0", "", "");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + j, "", "", "");
      return;
      label189:
      if ((paramChatMessage instanceof MessageForText))
      {
        j = 1;
        i = 1;
      }
      else if ((paramChatMessage instanceof MessageForPic))
      {
        j = 3;
        i = 2;
      }
      else if ((paramChatMessage instanceof MessageForMarketFace))
      {
        j = 4;
        i = 5;
      }
      else if ((paramChatMessage instanceof MessageForApollo))
      {
        j = 5;
        i = 5;
      }
      else if ((paramChatMessage instanceof MessageForVideo))
      {
        j = 0;
        i = 4;
      }
      else
      {
        j = 0;
        i = 5;
      }
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    paramBundle.putBoolean("isInvokeMenuShow", a(paramQQCustomMenu, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage, paramBundle));
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131371954;
  }
  
  protected boolean a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    if (!b(paramMessageRecord)) {
      return false;
    }
    boolean bool = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((!paramMessageRecord.isSend()) && (!bool)) {
      return false;
    }
    if ((AnonymousChatHelper.a(paramMessageRecord)) && (!TroopAnonyRevokeConfProcessor.a().a)) {
      return false;
    }
    if (UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1032) {
      return false;
    }
    paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    if (paramInt == 1)
    {
      paramBundle = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuRevokeProcessor
 * JD-Core Version:    0.7.0.1
 */