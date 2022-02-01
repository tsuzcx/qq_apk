package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.todo.TroopTodoReportUtils;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class BaseBubbleBuilderMenuCancelChatTodoProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private TroopToDoHandler c;
  
  public BaseBubbleBuilderMenuCancelChatTodoProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
    this.c = ((TroopToDoHandler)paramQQAppInterface.getBusinessHandler(TroopToDoHandler.class.getName()));
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if ((this.b != null) && (paramChatMessage != null))
    {
      this.c.b(Long.parseLong(this.b.c), paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseBubbleBuilderMenuCancelChatTodoProcessor", 2, "sessionInfo or chatMessage is null");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    paramInt = TroopTodoReportUtils.a(this.a, Long.parseLong(this.b.c));
    int i = TroopTodoReportUtils.a(paramChatMessage);
    String str = TroopTodoReportUtils.b(paramChatMessage);
    ReportController.b(this.a, "dc00898", "", "", "0X800BC6F", "0X800BC6F", 0, 0, String.valueOf(paramInt), String.valueOf(i), str, "");
    paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
    paramContext.setMainTitle(2131917644);
    paramContext.addButton(2131887715, 5);
    paramContext.addCancelButton(2131887648);
    paramContext.setOnButtonClickListener(new -..Lambda.BaseBubbleBuilderMenuCancelChatTodoProcessor.z8K7YB2Fvv-ULnl-4xFxLNtIMuc(this, paramChatMessage, paramInt, i, str, paramContext));
    paramContext.setOnDismissListener(new -..Lambda.BaseBubbleBuilderMenuCancelChatTodoProcessor.wlu-y_34xQeDzM1nzthjl0aEP-E(this, paramInt, i, str));
    paramContext.show();
    ReportController.b(this.a, "dc00898", "", "", "0X800BC70", "0X800BC70", 0, 0, String.valueOf(paramInt), String.valueOf(i), str, "");
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    paramQQCustomMenu.a(2131430283, paramContext.getString(2131887714), 0);
    paramInt = TroopTodoReportUtils.a(this.a, Long.parseLong(this.b.c));
    int i = TroopTodoReportUtils.a(paramChatMessage);
    paramQQCustomMenu = TroopTodoReportUtils.b(paramChatMessage);
    ReportController.b(this.a, "dc00898", "", "", "0X800BC6E", "0X800BC6E", 0, 0, String.valueOf(paramInt), String.valueOf(i), paramQQCustomMenu, "");
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131430283;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuCancelChatTodoProcessor
 * JD-Core Version:    0.7.0.1
 */