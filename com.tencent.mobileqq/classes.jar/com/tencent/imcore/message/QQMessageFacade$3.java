package com.tencent.imcore.message;

import aopk;
import atlf;
import atpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class QQMessageFacade$3
  implements atpl
{
  QQMessageFacade$3(QQMessageFacade paramQQMessageFacade, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity) {}
  
  public void onError(int paramInt, String paramString)
  {
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      this.val$entity.status = 16;
      QQMessageFacade.access$100(this.this$0).getFileManagerDataCenter().c(this.val$entity);
    }
    QQMessageFacade.access$100(this.this$0).getMsgHandler().a().a(this.val$msg.frienduin, this.val$msg.istroop, aopk.e, 0);
  }
  
  public void onSuccess()
  {
    this.this$0.getBaseMessageManager(this.val$msg.istroop).c(this.val$msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.3
 * JD-Core Version:    0.7.0.1
 */