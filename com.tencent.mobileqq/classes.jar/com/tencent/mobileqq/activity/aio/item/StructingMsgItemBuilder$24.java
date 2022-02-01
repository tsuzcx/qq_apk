package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.teamwork.TeamWorkSender;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class StructingMsgItemBuilder$24
  implements ActionSheet.OnButtonClickListener
{
  StructingMsgItemBuilder$24(StructingMsgItemBuilder paramStructingMsgItemBuilder, boolean paramBoolean, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a)
    {
      if ((this.b instanceof MessageForStructing)) {
        new TeamWorkSender(this.d.d).a((MessageForStructing)this.b, this.d.f);
      }
    }
    else {
      try
      {
        paramInt = Integer.parseInt(this.b.getExtInfoFromExtStr("peerType"));
        paramView = this.b.getExtInfoFromExtStr("filePath");
        String str1 = this.b.getExtInfoFromExtStr("peerUin");
        String str2 = this.b.getExtInfoFromExtStr("strSendUin");
        if (1 == paramInt) {
          this.d.d.getFileManagerEngine().a(paramView, str1);
        } else {
          this.d.d.getFileManagerEngine().a(paramView, str2, str1, paramInt, true);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.24
 * JD-Core Version:    0.7.0.1
 */