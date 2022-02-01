package com.tencent.biz.qqstory.notification;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class StoryMsgNotification$1
  implements URLDrawable.URLDrawableListener
{
  StoryMsgNotification$1(StoryMsgNotification paramStoryMsgNotification, NotificationCompat.Builder paramBuilder, QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("thumbDrawable onLoadFialed, exception: ");
      localStringBuilder.append(QLog.getStackTraceString(paramThrowable));
      QLog.d("StoryMsgNotification", 2, localStringBuilder.toString());
    }
    this.e.a(this.b, this.c, this.d, this.a);
    StoryMsgNotification.a(this.e).remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thumbDrawable onLoadSuccessed start, mURLDrawableList.size():");
      ((StringBuilder)localObject).append(StoryMsgNotification.a(this.e).size());
      QLog.d("StoryMsgNotification", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = com.tencent.mobileqq.utils.ImageUtil.a(paramURLDrawable.getCurrDrawable(), 200, 200);
    if (localObject == null) {
      return;
    }
    Bitmap localBitmap = com.tencent.biz.common.util.ImageUtil.b((Bitmap)localObject, 1);
    if ((QLog.isColorLevel()) && (localBitmap != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("thumbDrawable onLoadSuccessed start, cutBitmap.size():");
      localStringBuilder.append(localBitmap.getHeight());
      localStringBuilder.append(", ");
      localStringBuilder.append(localBitmap.getWidth());
      QLog.d("StoryMsgNotification", 2, localStringBuilder.toString());
    }
    this.a.setLargeIcon(localBitmap);
    this.e.a(this.b, this.c, this.d, this.a);
    ((Bitmap)localObject).recycle();
    StoryMsgNotification.a(this.e).remove(paramURLDrawable);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("thumbDrawable onLoadSuccessed, mURLDrawableList.size():");
      paramURLDrawable.append(StoryMsgNotification.a(this.e).size());
      QLog.d("StoryMsgNotification", 2, paramURLDrawable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.1
 * JD-Core Version:    0.7.0.1
 */