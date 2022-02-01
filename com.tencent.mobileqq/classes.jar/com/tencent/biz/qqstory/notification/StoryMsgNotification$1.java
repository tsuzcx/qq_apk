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
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
    StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, mURLDrawableList.size():" + StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).size());
    }
    Bitmap localBitmap1 = com.tencent.mobileqq.utils.ImageUtil.a(paramURLDrawable.getCurrDrawable(), 200, 200);
    if (localBitmap1 == null) {}
    do
    {
      return;
      Bitmap localBitmap2 = com.tencent.biz.common.util.ImageUtil.b(localBitmap1, 1);
      if ((QLog.isColorLevel()) && (localBitmap2 != null)) {
        QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + localBitmap2.getHeight() + ", " + localBitmap2.getWidth());
      }
      this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon(localBitmap2);
      this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
      localBitmap1.recycle();
      StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).remove(paramURLDrawable);
    } while (!QLog.isColorLevel());
    QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed, mURLDrawableList.size():" + StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.1
 * JD-Core Version:    0.7.0.1
 */