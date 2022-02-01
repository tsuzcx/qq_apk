package com.dataline.activities;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class LiteActivity$35
  extends FMObserver
{
  LiteActivity$35(LiteActivity paramLiteActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = LiteActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnFileTransferEnd : isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], nSessionId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    paramString1 = this.a.app.getFileManagerDataCenter().a(paramLong2);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = LiteActivity.a;
        paramString2 = new StringBuilder();
        paramString2.append("OnFileTransferEnd faild, get entity is faild, sessionId[");
        paramString2.append(String.valueOf(paramLong2));
        paramString2.append("]");
        QLog.e(paramString1, 2, paramString2.toString());
      }
      return;
    }
    if (paramBoolean)
    {
      FileManagerUtil.a(paramLong2);
      return;
    }
    if ((paramString1.nOpType == 4) || (paramString1.nOpType == 6)) {
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.35
 * JD-Core Version:    0.7.0.1
 */