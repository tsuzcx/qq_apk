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
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return paramFileManagerEntity.peerType == 6000;
  }
  
  private DataLineMsgRecord b(FileManagerEntity paramFileManagerEntity)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramFileManagerEntity.datalineEntitySessionId);
    DatalineMessageManager localDatalineMessageManager = this.a.getMessageFacade().d(i);
    if (localDatalineMessageManager == null) {
      return null;
    }
    return localDatalineMessageManager.a(paramFileManagerEntity.datalineEntitySessionId);
  }
  
  protected void a(ChatHistoryC2CFileAdapter.FileItemHolder paramFileItemHolder, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramFileManagerEntity))
    {
      paramFileManagerEntity = b(paramFileManagerEntity);
      if (paramFileManagerEntity == null)
      {
        paramFileItemHolder.b.setVisibility(8);
        paramFileItemHolder.c = 0;
        return;
      }
      if (paramFileManagerEntity.fileMsgStatus == 2L)
      {
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.b.setVisibility(0);
        paramFileItemHolder.c = 3;
        return;
      }
      if (paramFileManagerEntity.fileMsgStatus == 1L)
      {
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.b.setVisibility(0);
        paramFileItemHolder.c = 1;
        return;
      }
      if (paramFileManagerEntity.bIsTransfering)
      {
        paramFileItemHolder.b.setState(1);
        paramFileItemHolder.b.setProgress((int)(paramFileManagerEntity.progress * 100.0F));
        paramFileItemHolder.b.setVisibility(0);
        paramFileItemHolder.c = 2;
        return;
      }
      if ((paramFileManagerEntity.progress == 1.0F) && (paramFileManagerEntity.issuc))
      {
        if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.path))
        {
          paramFileItemHolder.b.setVisibility(8);
          paramFileItemHolder.c = 0;
          return;
        }
        paramFileItemHolder.b.setState(2);
        paramFileItemHolder.b.setVisibility(0);
        paramFileItemHolder.c = 1;
        return;
      }
      paramFileItemHolder.b.setVisibility(8);
      paramFileItemHolder.c = 0;
      return;
    }
    super.a(paramFileItemHolder, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.adapter.ChatHistoryDatalineFileAdapter
 * JD-Core Version:    0.7.0.1
 */