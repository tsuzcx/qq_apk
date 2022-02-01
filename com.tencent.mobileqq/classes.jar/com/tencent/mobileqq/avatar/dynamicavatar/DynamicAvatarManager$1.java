package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarManager$1
  implements Runnable
{
  DynamicAvatarManager$1(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  public void run()
  {
    if (DynamicAvatarManager.a(this.this$0) != null)
    {
      boolean bool = VideoEnvironment.checkAndLoadAVCodec();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadVideoSo runnable has run and loaded is ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.this$0;
      int i;
      if (bool) {
        i = 2;
      } else {
        i = 0;
      }
      ((DynamicAvatarManager)localObject).m = i;
      if ((!bool) && ((DynamicAvatarManager.a(this.this$0) instanceof QQAppInterface)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "loadVideoSo download execute");
        }
        ShortVideoResDownload.a((QQAppInterface)DynamicAvatarManager.a(this.this$0), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */