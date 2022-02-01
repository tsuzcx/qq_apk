package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.HistoryFileItemHolder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryFileView$4
  implements View.OnClickListener
{
  ChatHistoryFileView$4(ChatHistoryFileView paramChatHistoryFileView) {}
  
  public void onClick(View paramView)
  {
    ChatHistoryFileAdapter.HistoryFileItemHolder localHistoryFileItemHolder = (ChatHistoryFileAdapter.HistoryFileItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localHistoryFileItemHolder.h;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.e(localFileManagerEntity);
    }
    int i = localHistoryFileItemHolder.c;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              FMToastUtil.a(2131889577);
              break label272;
            }
            boolean bool = localFileManagerEntity.isSend();
            FileModel.a(localFileManagerEntity).a(bool, this.a.c, new ChatHistoryFileView.4.2(this, localFileManagerEntity));
          }
        }
        else if (localFileManagerEntity.getCloudType() == 0) {
          this.a.b.getOnlineFileSessionCenter().c(localFileManagerEntity.nSessionId);
        } else if (localFileManagerEntity.getCloudType() == 6) {
          ((DataLineHandler)this.a.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, localFileManagerEntity.uniseq, false);
        } else {
          this.a.b.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
        }
      }
      else
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131889577);
          break label272;
        }
        FileModel.a(localFileManagerEntity).a(false, this.a.c, new ChatHistoryFileView.4.1(this, localFileManagerEntity));
      }
    }
    else {
      this.a.a(localFileManagerEntity);
    }
    this.a.g.notifyDataSetChanged();
    label272:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView.4
 * JD-Core Version:    0.7.0.1
 */