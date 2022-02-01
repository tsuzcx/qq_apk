package com.tencent.mobileqq.activity.history.adapter;

import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;

public class ChatHistoryDatalineFileAdapter
  extends ChatHistoryC2CFileAdapter
{
  private QQAppInterface a;
  
  public ChatHistoryDatalineFileAdapter(QQAppInterface paramQQAppInterface, Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
    this.a = paramQQAppInterface;
  }
  
  private DataLineMsgRecord a(FileManagerEntity paramFileManagerEntity)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramFileManagerEntity.datalineEntitySessionId);
    DatalineMessageManager localDatalineMessageManager = this.a.getMessageFacade().a(i);
    if (localDatalineMessageManager == null) {
      return null;
    }
    return localDatalineMessageManager.a(paramFileManagerEntity.datalineEntitySessionId);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return paramFileManagerEntity.peerType == 6000;
  }
  
  protected void a(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramFileManagerEntity))
    {
      paramFileManagerEntity = a(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        paramFileItemHolder.jdField_a_of_type_Int = 0;
        return;
      }
      if (paramFileManagerEntity.fileMsgStatus == 2L)
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramFileItemHolder.jdField_a_of_type_Int = 3;
        return;
      }
      if (paramFileManagerEntity.fileMsgStatus == 1L)
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramFileItemHolder.jdField_a_of_type_Int = 1;
        return;
      }
      if (paramFileManagerEntity.bIsTransfering)
      {
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(paramFileManagerEntity.progress * 100.0F));
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramFileItemHolder.jdField_a_of_type_Int = 2;
        return;
      }
      if ((paramFileManagerEntity.progress == 1.0F) && (paramFileManagerEntity.issuc))
      {
        if (FileUtils.b(paramFileManagerEntity.path))
        {
          paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
          paramFileItemHolder.jdField_a_of_type_Int = 0;
          return;
        }
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
        paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        paramFileItemHolder.jdField_a_of_type_Int = 1;
        return;
      }
      paramFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      paramFileItemHolder.jdField_a_of_type_Int = 0;
      return;
    }
    super.a(paramFileItemHolder, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.adapter.ChatHistoryDatalineFileAdapter
 * JD-Core Version:    0.7.0.1
 */