package com.tencent.biz.qqcircle.publish.uploader;

import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadLog;

public class QcircleUploadLog
  implements IUploadLog
{
  public int d(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.w(paramString1, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.e(paramString1, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.w(paramString1, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.w(paramString1, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.w(paramString1, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    QLog.w(paramString, 1, paramThrowable.getMessage());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadLog
 * JD-Core Version:    0.7.0.1
 */