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
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class BaseBubbleBuilderMenuChatTodoProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private TroopToDoHandler c;
  private SessionInfo d;
  
  public BaseBubbleBuilderMenuChatTodoProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
    this.c = ((TroopToDoHandler)paramQQAppInterface.getBusinessHandler(TroopToDoHandler.class.getName()));
    this.d = paramSessionInfo;
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage)
  {
    if ((this.d != null) && (paramChatMessage != null))
    {
      if (paramChatMessage.shmsgseq <= 0L)
      {
        QQToast.makeText(paramContext, 2131887757, 2000).show();
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilderMenuChatTodoProcessor", 2, "message.shmsgseq <= 0");
        }
        return;
      }
      this.c.c(Long.parseLong(this.d.c), paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseBubbleBuilderMenuChatTodoProcessor", 2, "sessionInfo or chatMessage is null");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    paramInt = TroopTodoReportUtils.a(this.a, Long.parseLong(this.d.c));
    int i = TroopTodoReportUtils.a(paramChatMessage);
    String str = TroopTodoReportUtils.b(paramChatMessage);
    ReportController.b(this.a, "dc00898", "", "", "0X800BC6D", "0X800BC6D", 0, 0, String.valueOf(paramInt), String.valueOf(i), str, "");
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(paramContext, null);
    if (TroopTodoUtils.a()) {
      localActionSheet.setMainTitle(2131887756);
    } else {
      localActionSheet.setMainTitle(2131887755);
    }
    localActionSheet.addButton(2131887754, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new -..Lambda.BaseBubbleBuilderMenuChatTodoProcessor.7tMxj4r0C9QNm6c6nIbWu2sKvUw(this, paramContext, paramChatMessage, paramInt, i, str, localActionSheet));
    localActionSheet.setOnDismissListener(new -..Lambda.BaseBubbleBuilderMenuChatTodoProcessor.mwxhQMDi5ON_4OY_a5nqqCHmEIk(this, paramInt, i, str));
    localActionSheet.show();
    ReportController.b(this.a, "dc00898", "", "", "0X800BC70", "0X800BC70", 0, 0, String.valueOf(paramInt), String.valueOf(i), str, "");
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    paramQQCustomMenu.a(2131430651, paramContext.getString(2131887753), 0);
    paramInt = TroopTodoReportUtils.a(this.a, Long.parseLong(this.d.c));
    int i = TroopTodoReportUtils.a(paramChatMessage);
    paramQQCustomMenu = TroopTodoReportUtils.b(paramChatMessage);
    ReportController.b(this.a, "dc00898", "", "", "0X800BC6C", "0X800BC6C", 0, 0, String.valueOf(paramInt), String.valueOf(i), paramQQCustomMenu, "");
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131430651;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuChatTodoProcessor
 * JD-Core Version:    0.7.0.1
 */