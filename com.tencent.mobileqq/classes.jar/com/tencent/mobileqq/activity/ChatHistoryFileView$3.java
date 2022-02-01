package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.HistoryFileItemHolder;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryFileView$3
  implements View.OnClickListener
{
  ChatHistoryFileView$3(ChatHistoryFileView paramChatHistoryFileView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof String))
    {
      Object localObject = (ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag();
      if ((((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject).a instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject).a;
        this.a.a((FileManagerEntity)localObject);
      }
      else if ((((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject).a instanceof TencentDocData))
      {
        localObject = (TencentDocData)((ChatHistoryFileAdapter.HistoryFileItemHolder)localObject).a;
        this.a.a((TencentDocData)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView.3
 * JD-Core Version:    0.7.0.1
 */