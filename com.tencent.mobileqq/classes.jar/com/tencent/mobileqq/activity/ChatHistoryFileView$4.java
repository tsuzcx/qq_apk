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
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localHistoryFileItemHolder.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.b(localFileManagerEntity);
    }
    switch (localHistoryFileItemHolder.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryFileAdapter.notifyDataSetChanged();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131692602);
        }
        else
        {
          FileModel.a(localFileManagerEntity).a(false, this.a.jdField_a_of_type_AndroidContentContext, new ChatHistoryFileView.4.1(this, localFileManagerEntity));
          break;
          this.a.a(localFileManagerEntity);
          break;
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, localFileManagerEntity.uniseq, false);
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
          break;
          if (NetworkUtil.d(BaseApplication.getContext())) {
            break label247;
          }
          FMToastUtil.a(2131692602);
        }
      }
      label247:
      boolean bool = localFileManagerEntity.isSend();
      FileModel.a(localFileManagerEntity).a(bool, this.a.jdField_a_of_type_AndroidContentContext, new ChatHistoryFileView.4.2(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView.4
 * JD-Core Version:    0.7.0.1
 */