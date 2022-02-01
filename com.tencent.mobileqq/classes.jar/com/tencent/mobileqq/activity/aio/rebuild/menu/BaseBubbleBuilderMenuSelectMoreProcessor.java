package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public class BaseBubbleBuilderMenuSelectMoreProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuSelectMoreProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramChatMessage, paramContext);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    int i = 1;
    if ((localBaseActivity != null) && (localBaseActivity.getChatFragment() != null))
    {
      paramContext = AIOLongShotHelper.a();
      if (paramContext != null) {
        paramContext.c();
      }
      paramContext = localBaseActivity.getChatFragment().a();
      paramContext.c(paramChatMessage);
      paramContext.f(true);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
      if (paramChatMessage == null) {
        return;
      }
      int j;
      if (paramChatMessage.istroop == 0) {
        j = 1;
      } else if (paramChatMessage.istroop == 3000) {
        j = 2;
      } else if (paramChatMessage.istroop == 1) {
        j = 3;
      } else {
        j = 4;
      }
      if ((paramChatMessage instanceof MessageForFile)) {
        i = 6;
      } else if (!(paramChatMessage instanceof MessageForText)) {
        if ((paramChatMessage instanceof MessageForPic)) {
          i = 3;
        } else if ((paramChatMessage instanceof MessageForMarketFace)) {
          i = 4;
        } else {
          i = 0;
        }
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(i);
      ReportController.b(paramChatMessage, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, paramContext.toString(), "", "", "");
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(j);
      ReportController.b(paramChatMessage, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, paramContext.toString(), "", "", "");
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("onClickSelectMore Error:");
    if (localBaseActivity != null) {
      paramChatMessage = localBaseActivity.toString();
    } else {
      paramChatMessage = "ca is null ";
    }
    paramContext.append(paramChatMessage);
    QLog.e("BaseBubbleBuilder", 1, paramContext.toString());
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if ((a()) && (MultiMsgManager.a().a())) {
      paramQQCustomMenu.a(2131371603, paramContext.getString(2131694356), 2130838922);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext);
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131371603;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuSelectMoreProcessor
 * JD-Core Version:    0.7.0.1
 */