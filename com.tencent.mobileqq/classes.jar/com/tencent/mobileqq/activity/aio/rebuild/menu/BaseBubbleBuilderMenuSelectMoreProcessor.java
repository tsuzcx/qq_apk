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
      paramContext = AIOLongShotHelper.f();
      if (paramContext != null) {
        paramContext.e();
      }
      paramContext = localBaseActivity.getChatFragment().k();
      paramContext.c(paramChatMessage);
      paramContext.i(true);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramContext.d, "select_more_msg", true);
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
      paramChatMessage = this.a;
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(i);
      ReportController.b(paramChatMessage, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, paramContext.toString(), "", "", "");
      paramChatMessage = this.a;
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
    if ((a()) && (MultiMsgManager.a().b())) {
      paramQQCustomMenu.a(2131439015, paramContext.getString(2131892030), 2130839076);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext);
  }
  
  protected boolean a()
  {
    if ((this.b.a != 0) && (this.b.a != 1) && (this.b.a != 3000) && (this.b.a != 1008)) {
      return false;
    }
    if (this.b.a == 1)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localHotChatManager != null) && (localHotChatManager.b(this.b.b))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131439015;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuSelectMoreProcessor
 * JD-Core Version:    0.7.0.1
 */