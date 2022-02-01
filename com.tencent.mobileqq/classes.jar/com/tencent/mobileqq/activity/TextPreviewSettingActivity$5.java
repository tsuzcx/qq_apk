package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class TextPreviewSettingActivity$5
  extends DownloadListener
{
  TextPreviewSettingActivity$5(TextPreviewSettingActivity paramTextPreviewSettingActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onCancel| task:" + paramDownloadTask);
    }
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {}
    do
    {
      return;
      if (paramDownloadTask.a() == -1)
      {
        paramDownloadTask = new Message();
        paramDownloadTask.what = 17;
        TextPreviewSettingActivity.a(this.a).sendMessage(paramDownloadTask);
        return;
      }
      paramDownloadTask = TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a));
    } while (paramDownloadTask == null);
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = paramDownloadTask;
    TextPreviewSettingActivity.a(this.a).sendMessage(localMessage);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewSettingActivity", 2, "fontNameDownloadListener.onStart| task:" + paramDownloadTask);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */