package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class SendMultiPictureHelper$2
  extends FMObserver
{
  SendMultiPictureHelper$2(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferStart");
    if (this.a.c != null) {
      this.a.c.setMessage(String.format(this.a.o, new Object[] { Integer.valueOf(this.a.e + 1), Integer.valueOf(this.a.f), Integer.valueOf(0) }));
    }
    paramString = this.a;
    paramString.u = paramString.b.getFileManagerProxy().c();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferProgress");
    if (this.a.u != null)
    {
      paramInt = 0;
      while (paramInt < this.a.d.size())
      {
        if (((SendMultiPictureHelper.SendingFileInfo)this.a.d.get(paramInt)).b == paramLong1) {
          break label74;
        }
        paramInt += 1;
      }
      paramInt = -1;
      label74:
      if (paramInt != -1)
      {
        paramInt = 0;
        while (paramInt < this.a.u.size())
        {
          paramString = (FileManagerEntity)this.a.u.get(paramInt);
          if (paramString.uniseq == paramLong1)
          {
            if (this.a.c == null) {
              break;
            }
            this.a.c.setMessage(String.format(this.a.o, new Object[] { Integer.valueOf(this.a.e + 1), Integer.valueOf(this.a.f), Integer.valueOf((int)(paramString.fProgress * 100.0F)) }));
            return;
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      paramString = this.a;
      paramString.u = paramString.b.getFileManagerProxy().c();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String arg6, int paramInt1, int paramInt2, String paramString2)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferEnd");
    if (!this.a.m) {
      synchronized (this.a.d)
      {
        this.a.a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.2
 * JD-Core Version:    0.7.0.1
 */