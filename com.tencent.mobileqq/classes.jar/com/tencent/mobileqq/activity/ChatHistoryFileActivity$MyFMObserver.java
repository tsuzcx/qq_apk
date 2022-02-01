package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ChatHistoryFileActivity$MyFMObserver
  extends FMObserver
{
  private ChatHistoryFileActivity$MyFMObserver(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    if ((((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt)) && (this.a.w != null)) {
      this.a.w.sendEmptyMessage(102);
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt)) && (this.a.w != null)) {
      this.a.w.sendEmptyMessage(102);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("OnFileTransferEnd : isSuccess[");
      paramString2.append(paramBoolean);
      paramString2.append("], uniseq[");
      paramString2.append(paramLong1);
      paramString2.append("], nSessionId[");
      paramString2.append(paramLong2);
      paramString2.append(paramString1);
      paramString2.append("], peerType[");
      paramString2.append(paramInt1);
      paramString2.append("]");
      QLog.d("ChatHistoryFIleActivity", 2, paramString2.toString());
    }
    paramString1 = this.a.app.getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6) && (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt2)) && (this.a.w != null)) {
      this.a.w.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.MyFMObserver
 * JD-Core Version:    0.7.0.1
 */