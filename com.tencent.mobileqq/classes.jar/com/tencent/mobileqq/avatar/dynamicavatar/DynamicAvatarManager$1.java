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
    boolean bool;
    DynamicAvatarManager localDynamicAvatarManager;
    if (DynamicAvatarManager.a(this.this$0) != null)
    {
      bool = VideoEnvironment.checkAndLoadAVCodec();
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "loadVideoSo runnable has run and loaded is " + bool);
      }
      localDynamicAvatarManager = this.this$0;
      if (!bool) {
        break label108;
      }
    }
    label108:
    for (int i = 2;; i = 0)
    {
      localDynamicAvatarManager.b = i;
      if ((!bool) && ((DynamicAvatarManager.a(this.this$0) instanceof QQAppInterface)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "loadVideoSo download execute");
        }
        ShortVideoResDownload.a((QQAppInterface)DynamicAvatarManager.a(this.this$0), false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */