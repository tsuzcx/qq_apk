package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.filemanager.core.IFileVideoDownloadListener;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.qphone.base.util.QLog;

class AIOImageProviderService$8
  implements IFileVideoDownloadListener
{
  AIOImageProviderService$8(AIOImageProviderService paramAIOImageProviderService, BaseVideoBiz paramBaseVideoBiz, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject = this.c.y;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadProgressUpdate: callback = null , ctxId[");
      ((StringBuilder)localObject).append(this.a.a());
      ((StringBuilder)localObject).append("] ");
      QLog.i("AIOImageProviderService", 2, ((StringBuilder)localObject).toString());
      return;
    }
    paramInt1 = (int)((float)paramLong1 / (float)paramLong2 * 10000.0F);
    ((IAIOImageProviderCallBack)localObject).a(this.b, 0, 269484035, paramInt1, paramLong2, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.c.y;
    if (localIAIOImageProviderCallBack == null)
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadProgressUpdate: error, ctxId[");
      paramString.append(this.b);
      paramString.append("] ");
      QLog.i("AIOImageProviderService", 2, paramString.toString());
      return;
    }
    if ((paramInt2 != -7003) && (paramInt2 != -6101)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 16;
    }
    localIAIOImageProviderCallBack.a(this.b, paramInt1, 269484034, 2, paramString, false);
  }
  
  public void a(String paramString)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.c.y;
    if (localIAIOImageProviderCallBack == null)
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadFinish callback = null , ctxId[");
      paramString.append(this.b);
      paramString.append("] ");
      QLog.i("AIOImageProviderServiceXOXO", 2, paramString.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----------> notify download finish:");
    localStringBuilder.append(this.b);
    QLog.i("AIOImageProviderService", 1, localStringBuilder.toString());
    localIAIOImageProviderCallBack.a(this.b, 1, 269484034, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.8
 * JD-Core Version:    0.7.0.1
 */