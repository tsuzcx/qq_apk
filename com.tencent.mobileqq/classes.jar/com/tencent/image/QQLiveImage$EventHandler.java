package com.tencent.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QQLiveImage$EventHandler
  extends Handler
{
  public QQLiveImage$EventHandler(QQLiveImage paramQQLiveImage, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.this$0.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.EventHandler
 * JD-Core Version:    0.7.0.1
 */