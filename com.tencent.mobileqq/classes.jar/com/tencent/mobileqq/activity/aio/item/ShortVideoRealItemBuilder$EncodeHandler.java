package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ShortVideoRealItemBuilder$EncodeHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EncodeHandler.handleMessage, msg.what = ");
      ((StringBuilder)localObject).append(paramMessage.what);
      ((StringBuilder)localObject).append(", ret is ");
      ((StringBuilder)localObject).append(paramMessage.arg1);
      QLog.d("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        localObject = paramMessage.getData().getString("maxvideo.file.mp4");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("EncodeHandler.handleMessage MaxVideoConst.MSG_ENDret is ");
          localStringBuilder.append(paramMessage.arg1);
          localStringBuilder.append(",targetFile is ");
          localStringBuilder.append((String)localObject);
          QLog.d("ShortVideoRealItemBuilder", 2, localStringBuilder.toString());
        }
      }
      else
      {
        i = paramMessage.arg1;
        paramMessage = paramMessage.getData();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ret is ");
          ((StringBuilder)localObject).append(i);
          QLog.i("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("data is ");
          ((StringBuilder)localObject).append(paramMessage);
          QLog.i("ShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.EncodeHandler
 * JD-Core Version:    0.7.0.1
 */