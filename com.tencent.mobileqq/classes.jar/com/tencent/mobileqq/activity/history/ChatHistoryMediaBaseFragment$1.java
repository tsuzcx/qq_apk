package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatHistoryMediaBaseFragment$1
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryMediaBaseFragment$1(ChatHistoryMediaBaseFragment paramChatHistoryMediaBaseFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = new ArrayList();
    if ((this.b.t != null) && (this.b.s != null))
    {
      List localList = this.b.s.o();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ChatMessage)localIterator.next();
        if (((ChatMessage)localObject).msgtype == -2005)
        {
          localObject = this.b.a.getFileManagerDataCenter().a(((ChatMessage)localObject).uniseq, ((ChatMessage)localObject).frienduin, ((ChatMessage)localObject).istroop);
          if (localObject != null) {
            this.b.a.getFileManagerEngine().c(((FileManagerEntity)localObject).nSessionId);
          }
        }
      }
      paramView.addAll(localList);
    }
    if (paramView.size() > 0) {
      ThreadManager.post(new ChatHistoryMediaBaseFragment.1.1(this, paramView), 8, null, true);
    }
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */