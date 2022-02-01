package com.tencent.biz.richframework.animation.drawable;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

class QQAnimationDrawable$InternalHandler
  extends Handler
{
  private QQAnimationDrawable b;
  
  public QQAnimationDrawable$InternalHandler(QQAnimationDrawable paramQQAnimationDrawable1, QQAnimationDrawable paramQQAnimationDrawable2)
  {
    this.b = paramQQAnimationDrawable2;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof Long))
    {
      paramMessage = (Long)paramMessage.obj;
      if (paramMessage.longValue() < SystemClock.uptimeMillis())
      {
        this.a.scheduleSelf(this.b, SystemClock.uptimeMillis());
        return;
      }
      this.a.scheduleSelf(this.b, paramMessage.longValue());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InternalHandler handleMessage msg.obj:");
    localStringBuilder.append(paramMessage.obj);
    Log.d("QQAnimationDrawable", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.InternalHandler
 * JD-Core Version:    0.7.0.1
 */