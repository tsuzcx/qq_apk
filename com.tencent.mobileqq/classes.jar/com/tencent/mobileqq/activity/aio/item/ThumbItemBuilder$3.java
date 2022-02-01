package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ThumbItemBuilder$3
  extends DownloadListener
{
  ThumbItemBuilder$3(ThumbItemBuilder paramThumbItemBuilder, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("coverDownloadListener.onCancel| task:");
      localStringBuilder.append(paramDownloadTask);
      QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("coverDownloadListener.onDone| task:");
      localStringBuilder.append(paramDownloadTask);
      QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
    }
    if (paramDownloadTask.b()) {
      return;
    }
    paramDownloadTask.a().getInt("type");
    if (paramDownloadTask.a() == -1) {
      return;
    }
    paramDownloadTask = new Message();
    paramDownloadTask.what = ThumbItemBuilder.jdField_a_of_type_Int;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("coverDownloadListener.onStart| task:");
      localStringBuilder.append(paramDownloadTask);
      QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */