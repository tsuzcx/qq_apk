package com.tencent.biz.qqcircle.immersive.utils;

import android.os.Handler;
import android.os.Message;

final class QFSThreadUtils$1
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    QFSThreadUtils.OnHandlerCallback localOnHandlerCallback = this.a;
    if (localOnHandlerCallback != null) {
      localOnHandlerCallback.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils.1
 * JD-Core Version:    0.7.0.1
 */