package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class TextPreviewActivity$8
  extends DownloadListener
{
  TextPreviewActivity$8(TextPreviewActivity paramTextPreviewActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontNameDownloadListener.onCancel| task:");
      localStringBuilder.append(paramDownloadTask);
      QLog.d("TextPreviewActivity", 2, localStringBuilder.toString());
    }
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fontNameDownloadListener.onDone| task:");
      ((StringBuilder)localObject).append(paramDownloadTask);
      QLog.d("TextPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramDownloadTask.b()) {
      return;
    }
    if (paramDownloadTask.a() == -1)
    {
      paramDownloadTask = new Message();
      paramDownloadTask.what = 17;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramDownloadTask);
      return;
    }
    paramDownloadTask = this.a.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.getFontNameDrawable(this.a.e);
    if (paramDownloadTask != null)
    {
      localObject = new Message();
      ((Message)localObject).what = 18;
      ((Message)localObject).obj = paramDownloadTask;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fontNameDownloadListener.onStart| task:");
      localStringBuilder.append(paramDownloadTask);
      QLog.d("TextPreviewActivity", 2, localStringBuilder.toString());
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */