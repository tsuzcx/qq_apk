package com.tencent.av.avatar;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class QavAvatarHelper$1
  implements Runnable
{
  QavAvatarHelper$1(QavAvatarHelper paramQavAvatarHelper, VideoAppInterface paramVideoAppInterface, AvatarParam paramAvatarParam, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    try
    {
      QavAvatarHelper.a(this.this$0, this.a, this.b, this.c, this.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QavAvatarHelper", 2, "downloadHDAvatar, retry fail", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avatar.QavAvatarHelper.1
 * JD-Core Version:    0.7.0.1
 */