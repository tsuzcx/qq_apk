package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoPTVItemBuilder$EncodeHandler
  extends Handler
{
  public ShortVideoPTVItemBuilder$EncodeHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      StringBuilder localStringBuilder;
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        i = paramMessage.arg1;
        if (paramMessage.arg1 != 0) {
          return;
        }
        paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ret is ");
          localStringBuilder.append(i);
          QLog.i("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("targetFile is ");
          localStringBuilder.append(paramMessage);
          QLog.i("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
        }
      }
      else
      {
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ret is ");
          localStringBuilder.append(i);
          QLog.i("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("data is ");
          localStringBuilder.append(paramMessage);
          QLog.i("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.EncodeHandler
 * JD-Core Version:    0.7.0.1
 */