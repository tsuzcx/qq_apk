package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler;
import mqq.os.MqqHandler;

class ChatHistoryFileActivity$MyFMObserver
  extends FMObserver
{
  private ChatHistoryFileActivity$MyFMObserver(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if ((ResponseHandler.a(paramInt)) && (this.a.a != null)) {
      this.a.a.sendEmptyMessage(102);
    }
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((ResponseHandler.a(paramInt)) && (this.a.a != null)) {
      this.a.a.sendEmptyMessage(102);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryFIleActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.app.getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6) && (ResponseHandler.a(paramInt2)) && (this.a.a != null)) {
      this.a.a.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.MyFMObserver
 * JD-Core Version:    0.7.0.1
 */