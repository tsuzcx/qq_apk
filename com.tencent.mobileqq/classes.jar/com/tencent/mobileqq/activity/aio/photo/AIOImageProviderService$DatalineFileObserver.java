package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AIOImageProviderService$DatalineFileObserver
  extends DataLineObserver
{
  AIOImageProviderService$DatalineFileObserver(AIOImageProviderService paramAIOImageProviderService) {}
  
  private void a(long paramLong, DataLineMsgRecord paramDataLineMsgRecord, IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    int i = FileManagerUtil.c(paramDataLineMsgRecord.filename);
    paramDataLineMsgRecord = AIOImageProviderService.a(this.a, paramLong);
    if (paramDataLineMsgRecord == null) {
      return;
    }
    if (i == 0)
    {
      paramIAIOImageProviderCallBack.a(paramDataLineMsgRecord.uniseq, 0, 20, 2, "", false);
      this.a.a(paramDataLineMsgRecord.uniseq, 0, 20, "I:E");
      return;
    }
    if (i == 2) {
      paramIAIOImageProviderCallBack.a(paramDataLineMsgRecord.uniseq, 0, 269484034, 2, "", false);
    }
  }
  
  private void b(long paramLong, DataLineMsgRecord paramDataLineMsgRecord, IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    String str = paramDataLineMsgRecord.path;
    int i = FileManagerUtil.c(paramDataLineMsgRecord.filename);
    paramDataLineMsgRecord = AIOImageProviderService.a(this.a, paramLong);
    if (paramDataLineMsgRecord == null) {
      return;
    }
    if (i == 0)
    {
      paramIAIOImageProviderCallBack.a(paramDataLineMsgRecord.uniseq, 0, 20, 1, str, false);
      this.a.a(paramDataLineMsgRecord.uniseq, 0, 20, str);
      return;
    }
    if (i == 2)
    {
      if (this.a.x.contains(Long.valueOf(paramDataLineMsgRecord.uniseq)))
      {
        Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
        if (localContext != null) {
          FileManagerUtil.a(localContext, str);
        } else {
          QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [dataline file save album].");
        }
        this.a.x.remove(Long.valueOf(paramDataLineMsgRecord.uniseq));
      }
      paramIAIOImageProviderCallBack.a(paramDataLineMsgRecord.uniseq, 0, 269484034, 1, str, false);
    }
  }
  
  protected void a(long paramLong)
  {
    DataLineMsgRecord localDataLineMsgRecord = b(paramLong);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((localDataLineMsgRecord != null) && (localIAIOImageProviderCallBack != null))
    {
      MessageForDLFile localMessageForDLFile = AIOImageProviderService.a(this.a, paramLong);
      if (localMessageForDLFile == null) {
        return;
      }
      if (FileUtil.d(localDataLineMsgRecord.thumbPath))
      {
        localIAIOImageProviderCallBack.a(localMessageForDLFile.uniseq, 0, 16, 1, localDataLineMsgRecord.thumbPath, false);
        this.a.a(paramLong, 0, 16, localDataLineMsgRecord.thumbPath);
        localIAIOImageProviderCallBack.a(localMessageForDLFile.uniseq, 0, 18, 1, localDataLineMsgRecord.thumbPath, false);
        this.a.a(paramLong, 0, 18, localDataLineMsgRecord.thumbPath);
      }
      return;
    }
    QLog.i("AIOImageProviderService", 2, "onDatalineProgress: error");
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    DataLineMsgRecord localDataLineMsgRecord = b(paramLong);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((localDataLineMsgRecord != null) && (localIAIOImageProviderCallBack != null))
    {
      MessageForDLFile localMessageForDLFile = AIOImageProviderService.a(this.a, paramLong);
      if (localMessageForDLFile == null) {
        return;
      }
      if (FileManagerUtil.c(localDataLineMsgRecord.filename) == 0) {
        localIAIOImageProviderCallBack.a(localMessageForDLFile.uniseq, 0, 20, (int)(paramFloat * 10000.0F), localDataLineMsgRecord.filesize, false);
      }
      return;
    }
    QLog.i("AIOImageProviderService", 2, "onDatalineProgress: error");
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    paramString = b(paramLong);
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.y;
    if ((paramString != null) && (localIAIOImageProviderCallBack != null))
    {
      FileManagerUtil.c(paramString.filename);
      if (paramBoolean)
      {
        b(paramLong, paramString, localIAIOImageProviderCallBack);
        return;
      }
      a(paramLong, paramString, localIAIOImageProviderCallBack);
      return;
    }
    QLog.i("AIOImageProviderService", 2, "onDatalineProgress: error");
  }
  
  public DataLineMsgRecord b(long paramLong)
  {
    QQAppInterface localQQAppInterface = AIOImageProviderService.a(this.a);
    if (localQQAppInterface == null) {
      return null;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    return localQQAppInterface.getMessageFacade().d(i).a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.DatalineFileObserver
 * JD-Core Version:    0.7.0.1
 */