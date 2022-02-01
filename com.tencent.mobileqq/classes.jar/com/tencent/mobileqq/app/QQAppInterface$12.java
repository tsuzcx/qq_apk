package com.tencent.mobileqq.app;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;

class QQAppInterface$12
  implements Runnable
{
  QQAppInterface$12(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    boolean bool1 = this.this$0.isVideoChatting();
    boolean bool2 = this.this$0.canPlayThemeSound();
    if ((!this.this$0.isRingerSilent()) && (bool2) && (!bool1) && (!this.this$0.isRingerVibrate()) && (!this.this$0.isRingEqualsZero()) && (this.this$0.isCallIdle()) && (this.this$0.recordingPttStopped()))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder((String)localObject);
        ((StringBuilder)localObject).append(File.separatorChar);
        ((StringBuilder)localObject).append("voice");
        ((StringBuilder)localObject).append(File.separatorChar);
        ((StringBuilder)localObject).append("tab");
        ((StringBuilder)localObject).append(this.val$tabIndex);
        ((StringBuilder)localObject).append(".mp3");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Uri:");
          localStringBuilder.append(((StringBuilder)localObject).toString());
          QLog.d("playThemeVoice", 2, localStringBuilder.toString());
        }
        if (localFile.exists()) {
          AudioUtil.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.12
 * JD-Core Version:    0.7.0.1
 */